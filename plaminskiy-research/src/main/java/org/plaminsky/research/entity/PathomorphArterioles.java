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
public class PathomorphArterioles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deceased_record_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_deceased_record")
    )
    private DeceasedRecord deceasedRecord;

    @Column(name = "radius_of_arterioles_z1")
    private float radiusOfArteriolesZ1;

    @Column(name = "radius_of_arterioles_z2")
    private float radiusOfArteriolesZ2;

    @Column(name = "radius_of_arterioles_z3")
    private float radiusOfArteriolesZ3;

    @Column(name = "radius_of_arterioles_z4")
    private float radiusOfArteriolesZ4;

    @Column(name = "radius_of_arterioles_z5")
    private float radiusOfArteriolesZ5;

    @Column(name = "radius_of_arterioles_z6")
    private float radiusOfArteriolesZ6;

    @Column(name = "volume_of_microcirculation_of_arterioles_z1")
    private float volumeOfMicrocirculationOfArteriolesZ1;

    @Column(name = "volume_of_microcirculation_of_arterioles_z2")
    private float volumeOfMicrocirculationOfArteriolesZ2;

    @Column(name = "volume_of_microcirculation_of_arterioles_z3")
    private float volumeOfMicrocirculationOfArteriolesZ3;

    @Column(name = "volume_of_microcirculation_of_arterioles_z4")
    private float volumeOfMicrocirculationOfArteriolesZ4;

    @Column(name = "volume_of_microcirculation_of_arterioles_z5")
    private float volumeOfMicrocirculationOfArteriolesZ5;

    @Column(name = "volume_of_microcirculation_of_arterioles_z6")
    private float volumeOfMicrocirculationOfArteriolesZ6;

    @Column(name = "total_volume_of_microcirculation_of_arterioles")
    private float totalVolumeOfMicrocirculationOfArterioles;

    @Column(name = "average_radius_of_arterioles_z1")
    private float averageRadiusOfArteriolesZ1;

    @Column(name = "average_radius_of_arterioles_z2")
    private float averageRadiusOfArteriolesZ2;

    @Column(name = "average_radius_of_arterioles_z3")
    private float averageRadiusOfArteriolesZ3;

    @Column(name = "average_radius_of_arterioles_z4")
    private float averageRadiusOfArteriolesZ4;

    @Column(name = "average_radius_of_arterioles_z5")
    private float averageRadiusOfArteriolesZ5;

    @Column(name = "average_radius_of_arterioles_z6")
    private float averageRadiusOfArteriolesZ6;

    @Column(name = "change_in_the_lumen_of_arterioles_z1")
    private float changeInTheLumenOfArteriolesZ1;

    @Column(name = "change_in_the_lumen_of_arterioles_z2")
    private float changeInTheLumenOfArteriolesZ2;

    @Column(name = "change_in_the_lumen_of_arterioles_z3")
    private float changeInTheLumenOfArteriolesZ3;

    @Column(name = "change_in_the_lumen_of_arterioles_z4")
    private float changeInTheLumenOfArteriolesZ4;

    @Column(name = "change_in_the_lumen_of_arterioles_z5")
    private float changeInTheLumenOfArteriolesZ5;

    @Column(name = "change_in_the_lumen_of_venules_z6")
    private float changeInTheLumenOfVenulesZ6;

    @Column(name = "resistance_of_arterioles_z1")
    private float resistanceOfArteriolesZ1;

    @Column(name = "resistance_of_arterioles_z2")
    private float resistanceOfArteriolesZ2;

    @Column(name = "resistance_of_arterioles_z3")
    private float resistanceOfArteriolesZ3;

    @Column(name = "resistance_of_arterioles_z4")
    private float resistanceOfArteriolesZ4;

    @Column(name = "resistance_of_arterioles_z5")
    private float resistanceOfArteriolesZ5;

    @Column(name = "resistance_of_arterioles_z6")
    private float resistanceOfArteriolesZ6;

}
