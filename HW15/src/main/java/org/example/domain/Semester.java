package org.example.domain;

import org.example.base.domain.BaseEntity;
import org.example.domain.enums.Season;

import javax.persistence.Entity;
import javax.persistence.PrePersist;
import java.time.Year;


@Entity
public class Semester extends BaseEntity<Long> {

    private Season season;

    private Integer year;

    @PrePersist
    private void prePersist() {
        year = Year.now().getValue();
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Season getSeason() {
        return season;
    }

    public Integer getYear() {
        return year;
    }
}
