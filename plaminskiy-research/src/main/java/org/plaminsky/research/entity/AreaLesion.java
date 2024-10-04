package org.plaminsky.research.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AreaLesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "deceased_record_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_deceased_record")
    )
    private DeceasedRecord deceasedRecord;

    @Column(name = "area_lesion_Z1")
    private float areaLesionZ1;

    @Column(name = "area_lesion_Z2")
    private float areaLesionZ2;

    @Column(name = "area_lesion_Z3")
    private float areaLesionZ3;

    @Column(name = "area_lesion_Z4")
    private float areaLesionZ4;

    @Column(name = "area_lesion_Z5")
    private float areaLesionZ5;

    @Column(name = "area_lesion_Z6")
    private float areaLesionZ6;

}

