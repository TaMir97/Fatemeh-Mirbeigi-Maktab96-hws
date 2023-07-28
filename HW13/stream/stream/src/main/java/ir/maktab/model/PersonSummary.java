package ir.maktab.model;

import lombok.*;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.time.ZoneId;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PersonSummary {

  private Integer id;
  private String firstName;
  private String lastName;
  private Integer age;
  private Date birthDate;

  public static PersonSummary map(Person person) {

    try {
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      Date birthDate = sdf.parse(person.getBirthDate());
      int yearOfBirth = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear();
      int currentYear = Year.now().getValue();


      return new PersonSummary(person.getId(), person.getFirstName(), person.getLastName(),
          currentYear - yearOfBirth, birthDate);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}


