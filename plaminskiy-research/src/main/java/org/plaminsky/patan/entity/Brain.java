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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "brain", schema = "patan_spb")
public class Brain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sepsis_id", nullable = false)
    private Sepsis sepsis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sepsis_type_id", referencedColumnName = "id", nullable = false)
    private SepsisType sepsisType;

    @Column(name = "congestion_vessels")
    private Float congestionVessels;

    @Column(name = "fibrin_clots_in_vessels")
    private Integer fibrinClotsInVessels;

    @Column(name = "red_cell_sludge_in_vessels")
    private Integer redCellSludgeInVessels;

    @Column(name = "erythrocytic_thrombi_in_vessels")
    private Integer erythrocyticThrombiInVessels;

    @Column(name = "unaffected_endothelium_vessels")
    private Integer unaffectedEndotheliumVessels;

    @Column(name = "endothelial_shedding_vessels")
    private Integer endothelialSheddingVessels;

    @Column(name = "endothelial_edema_vessels")
    private Integer endothelialEdemaVessels;

    @Column(name = "leukostasis_in_vessels")
    private Integer leukostasisInVessels;

    @Column(name = "marginal_leukocyte_stasis_in_vessels")
    private Integer marginalLeukocyteStasisInVessels;

    @Column(name = "perivascular_infiltration_vessels")
    private Integer perivascularInfiltrationVessels;

    @Column(name = "diapedesis_hemorrhage_in_vessels")
    private Integer diapedesisHemorrhageInVessels;

    @Column(name = "microbes_in_vessels")
    private Integer microbesInVessels;

    @Column(name = "wall_thickness_of_vessels")
    private Float wallThicknessOfVessels;

    @Column(name = "lumen_diameter_of_vessels")
    private Float lumenDiameterOfVessels;

    @Column(name = "kernoghan_index_of_vessels")
    private Float kernoghanIndexOfVessels;

    @Column(name = "capillary_volume_fraction")
    private Float capillaryVolumeFraction;

    @Column(name = "wall_thickness_of_arterioles")
    private Float wallThicknessOfArterioles;

    @Column(name = "lumen_diameter_of_arterioles")
    private Float lumenDiameterOfArterioles;

    @Column(name = "wall_thickness_of_venules")
    private Float wallThicknessOfVenules;

    @Column(name = "lumen_diameter_of_venules")
    private Float lumenDiameterOfVenules;

    @Column(name = "kernoghan_index_of_arterioles")
    private Float kernoghanIndexOfArterioles;

    @Column(name = "kernoghan_index_of_venules")
    private Float kernoghanIndexOfVenules;

    @Column(name = "leukocyte_infiltration")
    private Integer leukocyteInfiltration;

    @Column(name = "leukocyte_infiltration_of_sheaths")
    private Integer leukocyteInfiltrationOfSheaths;

    @Column(name = "edema_of_sheaths_trabeculae")
    private Integer edemaOfSheathsTrabeculae;

    @Column(name = "shadow_cells")
    private Float shadowCells;

    @Column(name = "hyperchromatosis")
    private Float hyperchromatosis;

    @Column(name = "perinuclear_spaces")
    private Float perinuclearSpaces;

    @Column(name = "satellite_cells")
    private Float satelliteCells;

    @Column(name = "drainage_forms_of_oligodendrogliacytes")
    private Float drainageFormsOfOligodendrogliacytes;

    @Column(name = "cell_sum")
    private Float cellSum;

    @Column(name = "glial_reactivity")
    private Integer glialReactivity;

    @Column(name = "macro_abscesses")
    private Integer macroAbscesses;

    @Column(name = "microabscesses")
    private Integer microabscesses;

    @Column(name = "perivascular_edema")
    private Integer perivascularEdema;

    @Column(name = "pericellular_edema")
    private Integer pericellularEdema;

    @Column(name = "unaffected_cells")
    private Float unaffectedCells;

    @Column(name = "changed_cells")
    private Float changedCells;

    @Column(name = "pericellular_edema_percentage")
    private Float pericellularEdemaPercentage;

}

