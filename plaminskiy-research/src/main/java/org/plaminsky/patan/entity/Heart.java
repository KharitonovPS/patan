package org.plaminsky.patan.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "heart", schema = "patan_spb")
public class Heart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "autopsy_id", referencedColumnName = "autopsy_id"),
            @JoinColumn(name = "sepsis_type", referencedColumnName = "sepsis_type")
    })
    private Sepsis sepsis;

    @Column(name = "fibrin_microthrombi")
    private Integer fibrinMicrothrombi;

    @Column(name = "spasms")
    private Integer spasms;

    @Column(name = "vacuolar_degeneration")
    private Integer vacuolarDegeneration;

    @Column(name = "wavy_deformation_of_cardiomyocytes")
    private Integer wavyDeformationOfCardiomyocytes;

    @Column(name = "fragmentation_of_cardiomyocytes")
    private Integer fragmentationOfCardiomyocytes;

    @Column(name = "overstretching_of_cardiomyocytes")
    private Integer overstretchingOfCardiomyocytes;

    @Column(name = "nonreactive_necrosis")
    private Integer nonreactiveNecrosis;

    @Column(name = "necrosis_with_inflammatory_reaction")
    private Integer necrosisWithInflammatoryReaction;

    @Column(name = "kernoghan_index_arterioles")
    private Float kernoghanIndexArterioles;

    @Column(name = "congestion_in_arterioles")
    private Integer congestionInArterioles;

    @Column(name = "congestion_in_venules")
    private Integer congestionInVenules;

    @Column(name = "congestion_in_capillaries")
    private Integer congestionInCapillaries;

    @Column(name = "fibrin_clots_in_arterioles")
    private Integer fibrinClotsInArterioles;

    @Column(name = "fibrin_clots_in_venules")
    private Integer fibrinClotsInVenules;

    @Column(name = "fibrin_clots_in_capillaries")
    private Integer fibrinClotsInCapillaries;

    @Column(name = "red_cell_sludge_in_arterioles")
    private Integer redCellSludgeInArterioles;

    @Column(name = "red_cell_sludge_in_venules")
    private Integer redCellSludgeInVenules;

    @Column(name = "red_cell_sludge_in_capillaries")
    private Integer redCellSludgeInCapillaries;

    @Column(name = "erythrocytic_thrombi_in_arterioles")
    private Integer erythrocyticThrombiInArterioles;

    @Column(name = "erythrocytic_thrombi_in_venules")
    private Integer erythrocyticThrombiInVenules;

    @Column(name = "erythrocytic_thrombi_in_capillaries")
    private Integer erythrocyticThrombiInCapillaries;

    @Column(name = "unaffected_endothelium_in_arterioles")
    private Integer unaffectedEndotheliumInArterioles;

    @Column(name = "unaffected_endothelium_in_venules")
    private Integer unaffectedEndotheliumInVenules;

    @Column(name = "unaffected_endothelium_in_capillaries")
    private Integer unaffectedEndotheliumInCapillaries;

    @Column(name = "endothelial_shedding_in_arterioles")
    private Integer endothelialSheddingInArterioles;

    @Column(name = "endothelial_shedding_in_venules")
    private Integer endothelialSheddingInVenules;

    @Column(name = "endothelial_shedding_in_capillaries")
    private Integer endothelialSheddingInCapillaries;

    @Column(name = "edema_of_endothelium_in_arterioles")
    private Integer edemaOfEndotheliumInArterioles;

    @Column(name = "edema_of_endothelium_in_venules")
    private Integer edemaOfEndotheliumInVenules;

    @Column(name = "edema_of_endothelium_in_capillaries")
    private Integer edemaOfEndotheliumInCapillaries;

    @Column(name = "leukostasis_in_arterioles")
    private Integer leukostasisInArterioles;

    @Column(name = "leukostasis_in_venules")
    private Integer leukostasisInVenules;

    @Column(name = "leukostasis_in_capillaries")
    private Integer leukostasisInCapillaries;

    @Column(name = "marginal_leukocyte_stasis_in_arterioles")
    private Integer marginalLeukocyteStasisInArterioles;

    @Column(name = "marginal_leukocyte_stasis_in_venules")
    private Integer marginalLeukocyteStasisInVenules;

    @Column(name = "perivascular_infiltration_in_arterioles")
    private Integer perivascularInfiltrationInArterioles;

    @Column(name = "perivascular_infiltration_in_venules")
    private Integer perivascularInfiltrationInVenules;

    @Column(name = "perivascular_infiltration_in_capillaries")
    private Integer perivascularInfiltrationInCapillaries;

    @Column(name = "diapedesis_hemorrhage_in_arterioles")
    private Integer diapedesisHemorrhageInArterioles;

    @Column(name = "diapedesis_hemorrhage_in_venules")
    private Integer diapedesisHemorrhageInVenules;

    @Column(name = "diapedesis_hemorrhage_in_capillaries")
    private Integer diapedesisHemorrhageInCapillaries;

    @Column(name = "microbes_in_arterioles")
    private Integer microbesInArterioles;

    @Column(name = "microbes_in_venules")
    private Integer microbesInVenules;

    @Column(name = "microbes_in_capillaries")
    private Integer microbesInCapillaries;

    @Column(name = "macro_abscesses")
    private Integer macroAbscesses;

    @Column(name = "microabscesses")
    private Integer microabscesses;

    @Column(name = "mini_abscesses")
    private Integer miniAbscesses;


}
