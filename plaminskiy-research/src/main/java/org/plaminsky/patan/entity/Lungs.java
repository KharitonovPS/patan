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
@Table(name = "lungs", schema = "patan_spb")
public class Lungs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sepsis_id", nullable = false)
    private Sepsis sepsis;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sepsis_type_id", referencedColumnName = "id", nullable = false)
    private SepsisType sepsisType;

    @Column(name = "congestion_arterioles")
    private Integer congestionArterioles;

    @Column(name = "congestion_venules")
    private Integer congestionVenules;

    @Column(name = "congestion_capillaries")
    private Integer congestionCapillaries;

    @Column(name = "fibrin_clots_arterioles")
    private Integer fibrinClotsArterioles;

    @Column(name = "fibrin_clots_venules")
    private Integer fibrinClotsVenules;

    @Column(name = "fibrin_clots_capillaries")
    private Integer fibrinClotsCapillaries;

    @Column(name = "red_cell_sludge_arterioles")
    private Integer redCellSludgeArterioles;

    @Column(name = "red_cell_sludge_venules")
    private Integer redCellSludgeVenules;

    @Column(name = "red_cell_sludge_capillaries")
    private Integer redCellSludgeCapillaries;

    @Column(name = "erythrocytic_thrombi_arterioles")
    private Integer erythrocyticThrombiArterioles;

    @Column(name = "erythrocytic_thrombi_venules")
    private Integer erythrocyticThrombiVenules;

    @Column(name = "erythrocytic_thrombi_capillaries")
    private Integer erythrocyticThrombiCapillaries;

    @Column(name = "unaffected_endothelium_arterioles")
    private Integer unaffectedEndotheliumArterioles;

    @Column(name = "unaffected_endothelium_venules")
    private Integer unaffectedEndotheliumVenules;

    @Column(name = "unaffected_endothelium_capillaries")
    private Integer unaffectedEndotheliumCapillaries;

    @Column(name = "endothelial_shedding_arterioles")
    private Integer endothelialSheddingArterioles;

    @Column(name = "endothelial_shedding_venules")
    private Integer endothelialSheddingVenules;

    @Column(name = "endothelial_shedding_capillaries")
    private Integer endothelialSheddingCapillaries;

    @Column(name = "endothelial_edema_arterioles")
    private Integer endothelialEdemaArterioles;

    @Column(name = "endothelial_edema_venules")
    private Integer endothelialEdemaVenules;

    @Column(name = "endothelial_edema_capillaries")
    private Integer endothelialEdemaCapillaries;

    @Column(name = "leukostasis_arterioles")
    private Integer leukostasisArterioles;

    @Column(name = "leukostasis_venules")
    private Integer leukostasisVenules;

    @Column(name = "leukostasis_capillaries")
    private Integer leukostasisCapillaries;

    @Column(name = "marginal_leukocyte_stasis_arterioles")
    private Integer marginalLeukocyteStasisArterioles;

    @Column(name = "marginal_leukocyte_stasis_venules")
    private Integer marginalLeukocyteStasisVenules;

    @Column(name = "perivascular_infiltration_arterioles")
    private Integer perivascularInfiltrationArterioles;

    @Column(name = "perivascular_infiltration_venules")
    private Integer perivascularInfiltrationVenules;

    @Column(name = "perivascular_infiltration_capillaries")
    private Integer perivascularInfiltrationCapillaries;

    @Column(name = "diapedesis_hemorrhage_arterioles")
    private Integer diapedesisHemorrhageArterioles;

    @Column(name = "diapedesis_hemorrhage_venules")
    private Integer diapedesisHemorrhageVenules;

    @Column(name = "diapedesis_hemorrhage_capillaries")
    private Integer diapedesisHemorrhageCapillaries;

    @Column(name = "microbes_in_arterioles")
    private Integer microbesInArterioles;

    @Column(name = "microbes_in_venules")
    private Integer microbesInVenules;

    @Column(name = "microbes_in_capillaries")
    private Integer microbesInCapillaries;

    @Column(name = "wall_thickness_arterioles")
    private Float wallThicknessArterioles;

    @Column(name = "lumen_diameter_arterioles")
    private Float lumenDiameterArterioles;

    @Column(name = "wall_thickness_venules")
    private Float wallThicknessVenules;

    @Column(name = "lumen_diameter_venules")
    private Float lumenDiameterVenules;

    @Column(name = "kernoghan_index_arterioles")
    private Float kernoghanIndexArterioles;

    @Column(name = "kernoghan_index_venules")
    private Float kernoghanIndexVenules;

    @Column(name = "capillary_volume_fraction")
    private Float capillaryVolumeFraction;

    @Column(name = "macro_abscesses")
    private Integer macroAbscesses;

    @Column(name = "microabscesses")
    private Integer microabscesses;

    @Column(name = "mini_abscesses")
    private Integer miniAbscesses;

    @Column(name = "leukocyte_infiltration_interalveolar_septae")
    private Integer leukocyteInfiltrationInteralveolarSeptae;

    @Column(name = "interalveolar_edema")
    private Integer interalveolarEdema;

    @Column(name = "intrapulmonary_edema")
    private Integer intrapulmonaryEdema;

    @Column(name = "hyaline_membranes")
    private Integer hyalineMembranes;

    @Column(name = "emphysema")
    private Integer emphysema;

    @Column(name = "atelactasis")
    private Integer atelactasis;

    @Column(name = "fibrosis")
    private Integer fibrosis;

    @Column(name = "necrosis_of_alveolocytes")
    private Integer necrosisOfAlveolocytes;
}
