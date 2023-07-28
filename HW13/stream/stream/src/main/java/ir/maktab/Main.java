package ir.maktab;


import ir.maktab.mockdata.MockData;
import ir.maktab.model.Person;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    List<Person> people = MockData.getPeople();
    assert people != null;

    //Q1
    List<Person> youngPeople = people.stream()
        .filter(person -> person.getAge() < 50)
        .toList();
    youngPeople.forEach(System.out::println);



    //Q4
    List<String> ipv4 = people.stream()
        .map(Person::getIpv4)
        .toList();
    ipv4.forEach(System.out::println);

  }
}