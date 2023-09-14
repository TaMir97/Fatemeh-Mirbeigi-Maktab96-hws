package org.example.util;

import org.example.repository.InstallmentRepository;
import org.example.repository.LoanAccountRepository;
import org.example.repository.LoanRepository;
import org.example.repository.StudentRepository;
import org.example.repository.impl.InstallmentRepoImpl;
import org.example.repository.impl.LoanAccountRepoImpl;
import org.example.repository.impl.LoanRepoImpl;
import org.example.repository.impl.StudentRepoImpl;
import org.example.service.InstallmentService;
import org.example.service.LoanAccountService;
import org.example.service.LoanService;
import org.example.service.StudentService;
import org.example.service.impl.InstallmentServiceImpl;
import org.example.service.impl.LoanAccountServiceImpl;
import org.example.service.impl.LoanServiceImpl;
import org.example.service.impl.StudentServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ApplicationContext {
    private static final EntityManagerFactory emf;
    private static final EntityManager em;
    private static final InstallmentRepository INSTALLMENT_REPOSITORY;
    private static final InstallmentService INSTALLMENT_SERVICE;
    private static final LoanAccountRepository LOAN_ACCOUNT_REPOSITORY;
    private static final LoanAccountService LOAN_ACCOUNT_SERVICE;
    private static final LoanRepository LOAN_REPOSITORY;
    private static final LoanService LOAN_SERVICE;
    private static final StudentRepository STUDENT_REPOSITORY;
    private static final StudentService STUDENT_SERVICE;


    static {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();

        INSTALLMENT_REPOSITORY = new InstallmentRepoImpl(em);
        INSTALLMENT_SERVICE = new InstallmentServiceImpl(INSTALLMENT_REPOSITORY);

        LOAN_ACCOUNT_REPOSITORY = new LoanAccountRepoImpl(em);
        LOAN_ACCOUNT_SERVICE = new LoanAccountServiceImpl(LOAN_ACCOUNT_REPOSITORY);

        LOAN_REPOSITORY = new LoanRepoImpl(em);
        LOAN_SERVICE = new LoanServiceImpl(LOAN_REPOSITORY);

        STUDENT_REPOSITORY = new StudentRepoImpl(em);
        STUDENT_SERVICE = new StudentServiceImpl(STUDENT_REPOSITORY);
    }

    public static InstallmentService getInstallmentService() {
        return INSTALLMENT_SERVICE;
    }

    public static LoanAccountService getLoanAccountService() {
        return LOAN_ACCOUNT_SERVICE;
    }

    public static LoanService getLoanService() {
        return LOAN_SERVICE;
    }

    public static StudentService getStudentService() {
        return STUDENT_SERVICE;
    }
}
