package ir.maktab;


import ir.maktab.mockdata.MockData;
import ir.maktab.model.Person;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    List<Person> people = MockData.getPeople();

    List<Person> youngPeople = people.stream()
        .filter(person -> person.getAge() < 50)
        .toList();
    youngPeople.forEach(System.out::println);

  }
}