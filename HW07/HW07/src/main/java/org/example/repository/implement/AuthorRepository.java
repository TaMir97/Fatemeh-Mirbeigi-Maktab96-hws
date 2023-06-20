package org.example.repository.implement;

import org.example.connection.DBConnection;
import org.example.entity.Author;
import org.example.repository.Repository;

import java.sql.*;
import java.util.Random;

public class AuthorRepository implements Repository {
    int records = recordCounter();
    Random random = new Random();

    public void save(Author author) {
        final String QUERY = "insert into authors (author_id,firstname, lastname, age)" +
                " values (?,?,?,?)";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            author.setAuthorId(idGenerator());
            preparedStatement.setInt(1, author.getAuthorId());
            preparedStatement.setString(2, author.getFirstname());
            preparedStatement.setString(3, author.getLastname());
            preparedStatement.setInt(4, author.getAge());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Author load(int authorId) {
        Author author = new Author();
        final String QUERY = "select * from authors where author_id = ?";
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
            preparedStatement.setInt(1, authorId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                author.setAuthorId(resultSet.getInt(1));
                author.setFirstname(resultSet.getString(2));
                author.setLastname(resultSet.getString(3));
                author.setAge(resultSet.getInt(4));
            }
            preparedStatement.close();
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return author;
    }

    @Override
    public int[] loadAllIDs() {

        final String QUERY = "select author_id from authors";
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
            String query = "select count(*) from authors";
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
