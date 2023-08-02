package ir.maktab;


import ir.maktab.mockdata.MockData;
import ir.maktab.model.Person;
import ir.maktab.model.PersonSummary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
//    Comparator<Person> comparedByAgeThenLastName = Comparator
//        .comparing(Person::getAge)
//        .thenComparing(Person::getLastName);
//    List<Person> sortedByAgeThenLastName = people.stream()
//        .sorted(comparedByAgeThenLastName)
//        .toList();
//    sortedByAgeThenLastName.forEach(System.out::println);

    //Q4
//    List<String> ipv4 = people.stream()
//        .map(Person::getIpv4)
//        .toList();
//    ipv4.forEach(System.out::println);

    //Q5 (temporary)
    Comparator<Person> customComparator = Comparator
        .comparing(Person::getLastName)
        .thenComparing(Person::getFirstName);

    Map<String, Person> personMap = new HashMap<>();
    people.stream()
        .filter(person -> person.getGender().equalsIgnoreCase("Female") && person.getAge() > 40)
        .sorted(customComparator)
        .dropWhile(person -> person.getFirstName().toLowerCase().startsWith("a"))
        .skip(5)
        .limit(100)
        .forEach(person -> {
          String key = person.getFirstName() + " " + person.getLastName();
          int counter = 1;
          while (personMap.containsKey(key)) {
            key = person.getFirstName() + " " + person.getLastName() + " " + counter;
            counter++;
          }
          personMap.put(key, person);
        });
    personMap.values().forEach(System.out::println);
    personMap.keySet().forEach(System.out::println);

    //Q6
//    double maleAverageAge = people.stream()
//        .filter(person -> person.getGender().equalsIgnoreCase("Male"))
//        .map(PersonSummary::map)
//        .mapToInt(PersonSummary::getAge)
//        .average()
//        .orElse(0);
//    System.out.println(maleAverageAge);


  }
}