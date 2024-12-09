package org.plaminsky.patan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sepsis", schema = "patan_spb",
        uniqueConstraints = {
                @UniqueConstraint(name = "sepsis_autopsy_id_sepsis_type_uc",
                        columnNames = {"autopsy_id", "sepsis_type"})
        })
public class Sepsis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "autopsy_id")
    private String autopsyId;

    @Column(name = "sepsis_type", nullable = false)
    private Long sepsisTypeId;

}

