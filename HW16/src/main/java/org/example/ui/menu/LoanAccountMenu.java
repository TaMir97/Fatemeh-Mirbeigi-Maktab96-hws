package org.example.ui.menu;

import org.example.domain.CardInfo;
import org.example.domain.LoanAccount;
import org.example.domain.Student;
import org.example.domain.enums.*;
import org.example.service.LoanAccountService;
import org.example.service.StudentService;
import org.example.ui.Printer;
import org.example.util.ApplicationContext;
import org.example.util.Constant;
import org.example.util.JsonFileReader;

import java.util.Scanner;

public class LoanAccountMenu {
    static StudentService studentService = ApplicationContext.getStudentService();
    static LoanAccountService loanAccountService = ApplicationContext.getLoanAccountService();

    static LoanAccount loanAccount = new LoanAccount();

    static Scanner input = new Scanner(System.in);

    public static void signUp() {
        System.out.println("Enter firstname: ");
        String firstname = input.nextLine();

        System.out.println("Enter lastname: ");
        String lastname = input.nextLine();

        System.out.println("Enter gender: ");
        Gender[] genders = Gender.values();
        for (int i = 0; i < genders.length; i++) {
            System.out.println((i + 1) + ". " + genders[i]);
        }
        System.out.print("Enter the number for the chosen season: ");
        int selectedGenderIndex = Integer.parseInt(input.nextLine());
        if (selectedGenderIndex < 1 || selectedGenderIndex > genders.length) {
            System.out.println("Invalid season selection.");
        }
        Gender gender = genders[selectedGenderIndex - 1];

        System.out.println("Enter fatherName: ");
        String fatherName = input.nextLine();

        System.out.println("Enter motherName: ");
        String motherName = input.nextLine();

        System.out.println("Enter birthCN: ");
        Long birthCN = Long.valueOf(input.nextLine());

        System.out.println("Enter birthId: ");
        Long birthId = Long.valueOf(input.nextLine());

        System.out.println("Enter birthdate: ");
        String birthdate = input.nextLine();

        System.out.println("Enter homeCity: ");
        String homeCity = JsonFileReader.jsonPrinter();


        System.out.println("Enter marriageState: ");
        MarriageState[] marriageStates = MarriageState.values();
        for (int i = 0; i < marriageStates.length; i++) {
            System.out.println((i + 1) + ". " + marriageStates[i]);
        }
        System.out.print("Enter the number for the chosen season: ");
        int selectedMarriageStateIndex = Integer.parseInt(input.nextLine());
        if (selectedMarriageStateIndex < 1 || selectedMarriageStateIndex > marriageStates.length) {
            System.out.println("Invalid season selection.");
        }
        MarriageState marriageState = marriageStates[selectedMarriageStateIndex - 1];

        System.out.println("Enter spouseBirthIs: ");
        Long spouseBirthIs = Long.valueOf(input.nextLine());

        System.out.println("Enter studentId: ");
        Long studentId = Long.valueOf(input.nextLine());

        System.out.println("Enter universityName: ");
        String universityName = input.nextLine();

        System.out.println("Enter universityType: ");
        UniversityType[] universityTypes = UniversityType.values();
        for (int i = 0; i < universityTypes.length; i++) {
            System.out.println((i + 1) + ". " + universityTypes[i]);
        }
        System.out.print("Enter the number for the chosen season: ");
        int selectedUniversityTypeIndex = Integer.parseInt(input.nextLine());
        if (selectedUniversityTypeIndex < 1 || selectedUniversityTypeIndex > universityTypes.length) {
            System.out.println("Invalid season selection.");
        }
        UniversityType universityType = universityTypes[selectedUniversityTypeIndex - 1];

        GovernmentUniversity governmentUniversity = null;
        if (universityType.equals(UniversityType.DOWLATI)){
            System.out.println("Enter governmentUniversityType: ");
            GovernmentUniversity[] governmentUniversities = GovernmentUniversity.values();
            for (int i = 0; i < governmentUniversities.length; i++) {
                System.out.println((i + 1) + ". " + governmentUniversities[i]);
            }
            System.out.print("Enter the number for the chosen season: ");
            int selectedGovernmentUniversitiesTypeIndex = Integer.parseInt(input.nextLine());
            if (selectedGovernmentUniversitiesTypeIndex < 1 || selectedGovernmentUniversitiesTypeIndex > governmentUniversities.length) {
                System.out.println("Invalid season selection.");
            }
            governmentUniversity = governmentUniversities[selectedGovernmentUniversitiesTypeIndex - 1];
        }

        System.out.println("Enter startedYear: ");
        Integer startedYear = Integer.valueOf(input.nextLine());

        System.out.println("Enter grade: ");
        EducationalGrade[] educationalGrades = EducationalGrade.values();
        for (int i = 0; i < educationalGrades.length; i++) {
            System.out.println((i + 1) + ". " + educationalGrades[i]);
        }
        System.out.print("Enter the number for the chosen educationalGrades: ");
        int selectedEducationalGradesIndex = Integer.parseInt(input.nextLine());
        if (selectedEducationalGradesIndex < 1 || selectedEducationalGradesIndex > educationalGrades.length) {
            System.out.println("Invalid season selection.");
        }
        EducationalGrade educationalGrade = educationalGrades[selectedEducationalGradesIndex - 1];

        System.out.println("Enter city: ");
        String city = JsonFileReader.jsonPrinter();

        System.out.println("Enter isGraduated: ");
        Boolean isGraduated = Boolean.valueOf(input.nextLine());

        Student student = studentService.signUp(firstname,
                lastname,
                gender,
                fatherName,
                motherName,
                birthCN,
                birthId,
                birthdate,
                homeCity,
                marriageState,
                spouseBirthIs,
                studentId,
                universityName,
                universityType,
                governmentUniversity,
                startedYear,
                educationalGrade,
                city,
                isGraduated);

        System.out.println("Enter you Card Info");
        CardInfo cardInfo = new CardInfo();
        cardInfo.setValue(input.nextLine());

        loanAccount = loanAccountService.signUp(student, cardInfo);
        System.out.println(loanAccount);

    }


    public static void login() {
        System.out.println("username: ");
        System.out.println("password: ");
        String username = input.nextLine();
        String password = input.nextLine();
        if (loanAccountService.login(username,password) != null){
            boolean initialMenuLoop = true;
            while (initialMenuLoop) {
                System.out.println("Enter your choice: ");
                Printer.printItem(Constant.LOAN_ACCOUNT, "Loan or Installments: ");
                String initialInput = input.nextLine();
                switch (initialInput) {
                    case "1" -> InstallmentMenu.payment();
                    case "2" -> chooseALoanType();
                    case "3" -> initialMenuLoop = false;
                    default -> System.out.println("This choice does not exist.");
                }
            }
        }

    }

    public static void chooseALoanType() {
        if (!loanAccountService.graduationState(loanAccount)){
            boolean initialMenuLoop = true;
            while (initialMenuLoop) {
                System.out.println("Enter your choice: ");
                Printer.printItem(Constant.LOAN_TYPE, "Loan Type: ");
                String initialInput = input.nextLine();
                switch (initialInput) {
                    case "1" -> mortgage();
                    case "2" -> educational();
                    case "3" -> tuition();
                    case "4" -> initialMenuLoop = false;
                    default -> System.out.println("This choice does not exist.");
                }
            }
        }
    }

    private static void mortgage() {
        
    }

    private static void educational() {
    }

    private static void tuition() {
    }
}
