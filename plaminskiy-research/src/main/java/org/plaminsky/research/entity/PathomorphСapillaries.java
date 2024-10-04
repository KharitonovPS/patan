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
public class PathomorphСapillaries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deceased_record_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_deceased_record")
    )
    private DeceasedRecord deceasedRecord;

    @Column(name = "capillary_density_from_the_area_of_interalveolar_septa_z1")
    private float capillaryDensityInteralveolarSepataZ1;

    @Column(name = "capillary_density_from_the_area_of_interalveolar_septa_z2")
    private float capillaryDensityInteralveolarSepataZ2;

    @Column(name = "capillary_density_from_the_area_of_interalveolar_septa_z3")
    private float capillaryDensityInteralveolarSepataZ3;

    @Column(name = "capillary_density_from_the_area_of_interalveolar_septa_z4")
    private float capillaryDensityInteralveolarSepataZ4;

    @Column(name = "capillary_density_from_the_area_of_interalveolar_septa_z5")
    private float capillaryDensityInteralveolarSepataZ5;

    @Column(name = "capillary_density_from_the_area_of_interalveolar_septa_z6")
    private float capillaryDensityInteralveolarSepataZ6;

    @Column(name = "volume_of_the_microcirculation_system_of_capillaries_z1")
    private float volumeMicrocirculationCapillariesZ1;

    @Column(name = "volume_of_the_microcirculation_system_of_capillaries_z2")
    private float volumeMicrocirculationCapillariesZ2;

    @Column(name = "volume_of_the_microcirculation_system_of_capillaries_z3")
    private float volumeMicrocirculationCapillariesZ3;

    @Column(name = "volume_of_the_microcirculation_system_of_capillaries_z4")
    private float volumeMicrocirculationCapillariesZ4;

    @Column(name = "volume_of_the_microcirculation_system_of_capillaries_z5")
    private float volumeMicrocirculationCapillariesZ5;

    @Column(name = "volume_of_the_microcirculation_system_of_capillaries_z6")
    private float volumeMicrocirculationCapillariesZ6;

    @Column(name = "total_volume_of_the_microcirculation_system_of_capillaries")
    private float totalVolumeMicrocirculationCapillaries;

    @Column(name = "radius_of_capillaries_z1")
    private float radiusCapillariesZ1;

    @Column(name = "radius_of_capillaries_z2")
    private float radiusCapillariesZ2;

    @Column(name = "radius_of_capillaries_z3")
    private float radiusCapillariesZ3;

    @Column(name = "radius_of_capillaries_z4")
    private float radiusCapillariesZ4;

    @Column(name = "radius_of_capillaries_z5")
    private float radiusCapillariesZ5;

    @Column(name = "radius_of_capillaries_z6")
    private float radiusCapillariesZ6;

    @Column(name = "change_in_the_lumen_of_venules_z1")
    private float changeInLumenVenulesZ1;

    @Column(name = "change_in_the_lumen_of_capillaries_z2")
    private float changeInLumenCapillariesZ2;

    @Column(name = "change_in_the_lumen_of_capillaries_z3")
    private float changeInLumenCapillariesZ3;

    @Column(name = "change_in_the_lumen_of_capillaries_z4")
    private float changeInLumenCapillariesZ4;

    @Column(name = "change_in_the_lumen_of_capillaries_z5")
    private float changeInLumenCapillariesZ5;

    @Column(name = "change_in_the_lumen_of_capillaries_z6")
    private float changeInLumenCapillariesZ6;

    @Column(name = "resistance_of_capillaries_z1")
    private float resistanceCapillariesZ1;

    @Column(name = "resistance_of_capillaries_z2")
    private float resistanceCapillariesZ2;

    @Column(name = "resistance_of_capillaries_z3")
    private float resistanceCapillariesZ3;

    @Column(name = "resistance_of_capillaries_z4")
    private float resistanceCapillariesZ4;

    @Column(name = "resistance_of_capillaries_z5")
    private float resistanceCapillariesZ5;

    @Column(name = "resistance_of_capillaries_z6")
    private float resistanceCapillariesZ6;

}
