package ir.maktab;


import ir.maktab.mockdata.MockData;
import ir.maktab.model.Person;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    List<Person> people = MockData.getPeople();
    assert people != null;

    //Q1
//    List<Person> youngPeople = people.stream()
//        .filter(person -> person.getAge() < 50)
//        .toList();
//    youngPeople.forEach(System.out::println);

    //Q2
//    List<Person> sortedByUsername = people.stream()
//        .sorted(Comparator.comparing(Person::getUsername))
//        .toList();
//    sortedByUsername.forEach(System.out::println);

    //Q3
    Comparator<Person> comparedByAgeThenLastName = Comparator
        .comparing(Person::getAge)
        .thenComparing(Person::getLastName);
    List<Person> sortedByAgeThenLastName = people.stream()
        .sorted(comparedByAgeThenLastName)
        .toList();
    sortedByAgeThenLastName.forEach(System.out::println);

    //Q4
//    List<String> ipv4 = people.stream()
//        .map(Person::getIpv4)
//        .toList();
//    ipv4.forEach(System.out::println);

  }
}