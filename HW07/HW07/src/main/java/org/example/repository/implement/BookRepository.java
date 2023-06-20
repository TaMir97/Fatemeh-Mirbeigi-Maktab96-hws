package org.example.repository.implement;

import org.example.connection.DBConnection;
import org.example.entity.Book;
import org.example.repository.Repository;

import java.sql.*;
import java.util.Random;

public class BookRepository implements Repository {
    Random random = new Random();
    int records = recordCounter();

    public void save(Book book) {
        final String QUERY = "insert into books (book_id, title, release_year, author_id)" +
                " values (?,?,?,?)";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            book.setBookId(idGenerator());
            preparedStatement.setInt(1, book.getBookId());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setInt(3, book.getReleaseYear());
            preparedStatement.setInt(4, book.getAuthorId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Book load(int bookId) {
        Book book = new Book();
        final String QUERY = "select * from books where book_id = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, bookId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                book.setBookId(resultSet.getInt(1));
                book.setTitle(resultSet.getString(2));
                book.setReleaseYear(resultSet.getInt(3));
                book.setAuthorId(resultSet.getInt(4));
            }
            preparedStatement.close();
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    public void deleteBook(Book book) {
        int bookId = book.getBookId();
        String QUERY = "delete from books where book_id = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, bookId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int[] loadAllIDs() {
        final String QUERY = "select book_id from books";
        int[] IDs = new int[records];
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();

            int counter = 0;
            while (resultSet.next()) {
                IDs[counter] = resultSet.getInt(1);
                counter++;
            }
            preparedStatement.close();
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return IDs;
    }

    @Override
    public int recordCounter() {
        int count;
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            String query = "select count(*) from books";
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            count = resultSet.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return count;
    }

    @Override
    public boolean isUnique(int newID) {
        int[] IDs = loadAllIDs();
        boolean isUnique = true;

        for (int ID : IDs) {
            if (newID == ID) {
                isUnique = false;
                break;
            }
        }

        return isUnique;
    }

    @Override
    public int idGenerator() {
        int generatedID = random.nextInt(1, 999);
        while (!isUnique(generatedID)) {
            generatedID = random.nextInt(1, 999);
        }
        return generatedID;
    }
}
