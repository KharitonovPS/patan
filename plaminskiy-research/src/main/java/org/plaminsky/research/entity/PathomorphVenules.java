package org.plaminsky.research.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PathomorphVenules {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deceased_record_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_deceased_record")
    )
    private DeceasedRecord deceasedRecord;

    @Column(name = "radius_of_venules_z1")
    private float radiusOfVenulesZ1;

    @Column(name = "radius_of_venules_z2")
    private float radiusOfVenulesZ2;

    @Column(name = "radius_of_venules_z3")
    private float radiusOfVenulesZ3;

    @Column(name = "radius_of_venules_z4")
    private float radiusOfVenulesZ4;

    @Column(name = "radius_of_venules_z5")
    private float radiusOfVenulesZ5;

    @Column(name = "radius_of_venules_z6")
    private float radiusOfVenulesZ6;

    @Column(name = "volume_of_microcirculation_of_venules_z1")
    private float volumeOfMicrocirculationOfVenulesZ1;

    @Column(name = "volume_of_microcirculation_of_venules_z2")
    private float volumeOfMicrocirculationOfVenulesZ2;

    @Column(name = "volume_of_microcirculation_of_venules_z3")
    private float volumeOfMicrocirculationOfVenulesZ3;

    @Column(name = "volume_of_microcirculation_of_venules_z4")
    private float volumeOfMicrocirculationOfVenulesZ4;

    @Column(name = "volume_of_microcirculation_of_venules_z5")
    private float volumeOfMicrocirculationOfVenulesZ5;

    @Column(name = "volume_of_microcirculation_of_venules_z6")
    private float volumeOfMicrocirculationOfVenulesZ6;

    @Column(name = "total_volume_of_microcirculation_of_venules")
    private float totalVolumeOfMicrocirculationOfVenules;

    @Column(name = "average_radius_of_venules_z1")
    private float averageRadiusOfVenulesZ1;

    @Column(name = "average_radius_of_venules_z2")
    private float averageRadiusOfVenulesZ2;

    @Column(name = "average_radius_of_venules_z3")
    private float averageRadiusOfVenulesZ3;

    @Column(name = "average_radius_of_venules_z4")
    private float averageRadiusOfVenulesZ4;

    @Column(name = "average_radius_of_venules_z5")
    private float averageRadiusOfVenulesZ5;

    @Column(name = "average_radius_of_venules_z6")
    private float averageRadiusOfVenulesZ6;

    @Column(name = "change_in_the_lumen_of_venules_z1")
    private float changeInTheLumenOfVenulesZ1;

    @Column(name = "change_in_the_lumen_of_venules_z2")
    private float changeInTheLumenOfVenulesZ2;

    @Column(name = "change_in_the_lumen_of_venules_z3")
    private float changeInTheLumenOfVenulesZ3;

    @Column(name = "change_in_the_lumen_of_venules_z4")
    private float changeInTheLumenOfVenulesZ4;

    @Column(name = "change_in_the_lumen_of_venules_z5")
    private float changeInTheLumenOfVenulesZ5;

    @Column(name = "change_in_the_lumen_of_venules_z6")
    private float changeInTheLumenOfVenulesZ6;

    @Column(name = "resistance_of_venules_z1")
    private float resistanceOfVenulesZ1;

    @Column(name = "resistance_of_venules_z2")
    private float resistanceOfVenulesZ2;

    @Column(name = "resistance_of_venules_z3")
    private float resistanceOfVenulesZ3;

    @Column(name = "resistance_of_venules_z4")
    private float resistanceOfVenulesZ4;

    @Column(name = "resistance_of_venules_z5")
    private float resistanceOfVenulesZ5;

    @Column(name = "resistance_of_venules_z6")
    private float resistanceOfVenulesZ6;

}
