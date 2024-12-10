package org.plaminsky.patan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sepsis", schema = "patan_spb",
        uniqueConstraints = @UniqueConstraint(columnNames = {"autopsyId", "sepsis_type_id"}))
public class Sepsis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String autopsyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sepsis_type_id", nullable = false)
    private SepsisType sepsisType;


}

