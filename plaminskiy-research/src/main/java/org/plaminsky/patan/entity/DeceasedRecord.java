package org.plaminsky.patan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeceasedRecord {

    @Id
    @Column(length = 36, unique = true, nullable = false)
    private String id;

    @Column(name = "date_of_death", nullable = false)
    private LocalDate dateOfDeath;

    @Column(name="age")
    private int age;

    @Column(name = "gender")
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(name = "days_of_illness")
    private int daysOfIllness;

    @Column(name = "bed_days")
    private int bedDays;

    @Column(name = "phase_of_covid_19")
    private int phaseOfCovid19;
}

