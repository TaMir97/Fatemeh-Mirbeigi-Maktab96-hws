package org.example.ui.menu;

import org.example.domain.*;
import org.example.domain.enums.*;
import org.example.service.InstallmentService;
import org.example.service.LoanAccountService;
import org.example.service.LoanService;
import org.example.service.StudentService;
import org.example.ui.Printer;
import org.example.util.ApplicationContext;
import org.example.util.Constant;
import org.example.util.JsonFileReader;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class LoanAccountMenu {
    static StudentService studentService = ApplicationContext.getStudentService();
    static LoanAccountService loanAccountService = ApplicationContext.getLoanAccountService();
    static LoanService loanService = ApplicationContext.getLoanService();
    static InstallmentService installmentService = ApplicationContext.getInstallmentService();
    static LoanAccount loanAccount = new LoanAccount();
    static LocalDate registerDate = LocalDate.now();

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
        if (universityType.equals(UniversityType.DOWLATI)) {
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
        loanAccount = loanAccountService.login(username, password);
        if (loanAccountService.login(username, password) != null) {
            boolean initialMenuLoop = true;
            while (initialMenuLoop) {
                System.out.println("Enter your choice: ");
                Printer.printItem(Constant.LOAN_ACCOUNT, "Loan or Installments: ");
                String initialInput = input.nextLine();
                switch (initialInput) {
                    case "2" -> payment();
                    case "1" -> chooseALoanType();
                    case "3" -> updateField();
                    case "4" -> initialMenuLoop = false;
                    default -> System.out.println("This choice does not exist.");
                }
            }
        }

    }

    public static void payment() {
        if (loanAccount.getStudent().getGraduated()) {
            List<Loan> loans = loanService.installmentsPayments(loanAccount);
            Long totalLoanAmount = loans.stream()
                    .mapToLong(Loan::getTotalAmount)
                    .sum();
            Installment installment = new Installment();
            installment.setPayedAmount(totalLoanAmount / 12);
            for (int i = 0; i < loans.size(); i++) {
                System.out.println("Index: " + i);
                System.out.println(loans.get(i));
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the index to save: ");
            int selectedIndex = scanner.nextInt();

            if (selectedIndex >= 0 && selectedIndex < loans.size()) {
                Loan selectedLoan = loans.get(selectedIndex);
                installment.setLoan(selectedLoan);
                System.out.println("You selected: " + selectedLoan);
            } else {
                System.out.println("Invalid index selected.");
            }
            installment.setDateOfPayment(LocalDate.now());
            installmentService.save(installment);

        }
    }

    public static void updateField() {
        Constant.updateSingleField(loanAccount.getStudent());
    }

    public static void chooseALoanType() {
        if (!loanAccountService.graduationState(loanAccount)) {
            boolean initialMenuLoop = true;
            while (initialMenuLoop
                    || (registerDate.isBefore(LocalDate.ofYearDay(2023, 217))) && registerDate.isAfter(LocalDate.ofYearDay(2023, 224))
                    || (registerDate.isBefore(LocalDate.ofYearDay(2023, 300))) && registerDate.isAfter(LocalDate.ofYearDay(2023, 307))) {
                System.out.println("Enter your choice: ");
                Printer.printItem(Constant.LOAN_TYPE, "Loan Type: ");
                String initialInput = input.nextLine();
                switch (initialInput) {
                    case "1" -> mortgage();
                    case "2" -> educational();
                    case "3" -> {
                        if (!loanAccount.getStudent().getUniversityType().equals(UniversityType.DOWLATI)
                                || loanAccount.getStudent().getGovernmentUniversityType().equals(GovernmentUniversity.NO_FUNDED)) {
                            tuition();
                        }
                    }
                    case "4" -> initialMenuLoop = false;
                    default -> System.out.println("This choice does not exist.");
                }
            }
        }
    }

    public static void mortgage() {
        Long totalAmount;
        if (loanAccount.getStudent().getGrade().equals(EducationalGrade.ASSOCIATE) ||
                loanAccount.getStudent().getGrade().equals(EducationalGrade.BACHELOR) ||
                !loanService.mortgageLoan(loanAccount) ||
                !loanAccount.getStudent().getHomeCity().equals(loanAccount.getStudent().getCity())
        ) {
            totalAmount = 1_900_000L;
        } else if (loanAccount.getStudent().getGrade().equals(EducationalGrade.MASTER)) {
            totalAmount = 2_250_000L;
        } else {
            totalAmount = 2_600_000L;
        }
        LoanType loanType = LoanType.MORTGAGE;
        Loan loan = new Loan();
        loan.setLoanAccount(loanAccount);
        loan.setLoanType(loanType);
        loan.setRegisterDate(registerDate);
        loan.setTotalAmount(totalAmount);

        loanService.save(loan);
    }

    public static void educational() {
        Long totalAmount;
        if (loanAccount.getStudent().getGrade().equals(EducationalGrade.ASSOCIATE) ||
                loanAccount.getStudent().getGrade().equals(EducationalGrade.BACHELOR)) {
            totalAmount = 1_300_000L;
        } else if (loanAccount.getStudent().getGrade().equals(EducationalGrade.MASTER)) {
            totalAmount = 2_600_000L;
        } else {
            totalAmount = 65_000_000L;
        }
        LoanType loanType = LoanType.EDUCATIONAL;
        Loan loan = new Loan();
        loan.setLoanAccount(loanAccount);
        loan.setLoanType(loanType);
        loan.setRegisterDate(registerDate);
        loan.setTotalAmount(totalAmount);

        loanService.save(loan);
    }

    public static void tuition() {
        Long totalAmount;
        if (loanAccount.getStudent().getGrade().equals(EducationalGrade.ASSOCIATE) ||
                loanAccount.getStudent().getGrade().equals(EducationalGrade.BACHELOR)) {
            totalAmount = 1_900_000L;
        } else if (loanAccount.getStudent().getGrade().equals(EducationalGrade.MASTER)) {
            totalAmount = 2_250_000L;
        } else {
            totalAmount = 2_600_000L;
        }
        LoanType loanType = LoanType.MORTGAGE;
        Loan loan = new Loan();
        loan.setLoanAccount(loanAccount);
        loan.setLoanType(loanType);
        loan.setRegisterDate(registerDate);
        loan.setTotalAmount(totalAmount);

        loanService.save(loan);
    }
}
