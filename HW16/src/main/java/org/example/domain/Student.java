package org.example.domain;

import org.example.base.domain.BaseEntity;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class Student extends BaseEntity<Long> {
    @Embedded
    private PersonalInfo personalInfo;
    @Embedded
    private EducationalInfo educationalInfo;

}
