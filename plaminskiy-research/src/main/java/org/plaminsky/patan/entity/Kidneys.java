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
@Table(name = "kidneys", schema = "patan_spb")
public class Kidneys {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "autopsy_id", referencedColumnName = "autopsy_id"),
            @JoinColumn(name = "sepsis_type", referencedColumnName = "sepsis_type")
    })
    private Sepsis sepsis;

    @Column(name = "interstitial_fibrosis_of_cerebral_substance")
    private Integer interstitialFibrosisOfCerebralSubstance;

    @Column(name = "interstitial_fibrosis_of_cortex")
    private Integer interstitialFibrosisOfCortex;

    @Column(name = "fraction_of_lymphocytic_interstitial_inflammation_in_cortex")
    private Integer fractionOfLymphocyticInterstitialInflammationInCortex;

    @Column(name = "fraction_of_lymphocytic_interstitial_inflammation_in_cerebral_substance")
    private Integer fractionOfLymphocyticInterstitialInflammationInCerebralSubstance;

    @Column(name = "acute_purulent_inflammation_in_cortex")
    private Integer acutePurulentInflammationInCortex;

    @Column(name = "acute_purulent_inflammation_in_cerebral_substance")
    private Integer acutePurulentInflammationInCerebralSubstance;

    @Column(name = "neutrophils_in_glomerular_capillaries")
    private Integer neutrophilsInGlomerularCapillaries;

    @Column(name = "neutrophils_in_peritubular_and_straight_capillaries")
    private Integer neutrophilsInPeritubularAndStraightCapillaries;

    @Column(name = "microbial_emboli_in_peritubular_capillaries")
    private Integer microbialEmboliInPeritubularCapillaries;

    @Column(name = "microbial_emboli_in_arterioles")
    private Integer microbialEmboliInArterioles;

    @Column(name = "microbial_emboli_in_lymphatic_vessels")
    private Integer microbialEmboliInLymphaticVessels;

    @Column(name = "microbial_emboli_in_tubules")
    private Integer microbialEmboliInTubules;

    @Column(name = "microbial_emboli_in_glomerular_vessels")
    private Integer microbialEmboliInGlomerularVessels;

    @Column(name = "fibrinoid_necrosis_of_glomerular_vessels")
    private Integer fibrinoidNecrosisOfGlomerularVessels;

    @Column(name = "chronic_fibrosis_of_glomerulus_vessels")
    private Integer chronicFibrosisOfGlomerulusVessels;

    @Column(name = "nephrotelium_kidney_damage")
    private Integer nephroteliumKidneyDamage;

    @Column(name = "hyperemia_of_cerebral_substance")
    private Integer hyperemiaOfCerebralSubstance;

    @Column(name = "hyperemia_of_cortex")
    private Integer hyperemiaOfCortex;

    @Column(name = "area_of_hemorrhage")
    private Integer areaOfHemorrhage;

    @Column(name = "shedding_of_endothelium")
    private Integer sheddingOfEndothelium;

    @Column(name = "proximal_tubule_necrosis_severity")
    private Integer proximalTubuleNecrosisSeverity;

    @Column(name = "distal_tubule_necrosis_severity")
    private Integer distalTubuleNecrosisSeverity;

    @Column(name = "straight_tubules_dystrophy_severity")
    private Integer straightTubulesDystrophySeverity;

    @Column(name = "apoptosis_of_tubules")
    private Integer apoptosisOfTubules;

    @Column(name = "shedding_of_epithelium_of_tubules")
    private Integer sheddingOfEpitheliumOfTubules;

    @Column(name = "nerves_dystrophy")
    private Integer nervesDystrophy;

    @Column(name = "interlobular_artery_internal_diameter")
    private Float interlobularArteryInternalDiameter;

    @Column(name = "interlobular_artery_wall_thickness")
    private Float interlobularArteryWallThickness;

    @Column(name = "interlobular_artery_kernoghan_index")
    private Float interlobularArteryKernoghanIndex;

    @Column(name = "interlobular_artery_hyperemia")
    private Integer interlobularArteryHyperemia;

    @Column(name = "interlobular_artery_sludges")
    private Integer interlobularArterySludges;

    @Column(name = "interlobular_artery_fibrinous")
    private Integer interlobularArteryFibrinous;

    @Column(name = "interlobular_artery_erythrocytic_thrombi")
    private Integer interlobularArteryErythrocyticThrombi;

    @Column(name = "interlobular_artery_unaltered_endothelium")
    private Integer interlobularArteryUnalteredEndothelium;

    @Column(name = "interlobular_artery_shedding_of_endothelium")
    private Integer interlobularArterySheddingOfEndothelium;

    @Column(name = "interlobular_artery_edema_of_endothelium")
    private Integer interlobularArteryEdemaOfEndothelium;

    @Column(name = "interlobular_artery_leukostasis")
    private Integer interlobularArteryLeukostasis;

    @Column(name = "interlobular_artery_marginal_stasis_of_leukocytes")
    private Integer interlobularArteryMarginalStasisOfLeukocytes;

    @Column(name = "interlobular_artery_perivascular_infiltration")
    private Integer interlobularArteryPerivascularInfiltration;

    @Column(name = "interlobular_artery_diapedesis_hemorrhages")
    private Integer interlobularArteryDiapedesisHemorrhages;

    @Column(name = "interlobular_artery_microbes")
    private Integer interlobularArteryMicrobes;

    @Column(name = "interlobular_vein_diameter")
    private Float interlobularVeinDiameter;

    @Column(name = "interlobular_vein_wall_thickness")
    private Float interlobularVeinWallThickness;

    @Column(name = "interlobular_vein_kernoghan_index")
    private Float interlobularVeinKernoghanIndex;

    @Column(name = "interlobular_vein_hyperemia")
    private Integer interlobularVeinHyperemia;

    @Column(name = "interlobular_vein_sludges")
    private Integer interlobularVeinSludges;

    @Column(name = "interlobular_vein_fibrinous")
    private Integer interlobularVeinFibrinous;

    @Column(name = "interlobular_vein_erythrocytic_thrombi")
    private Integer interlobularVeinErythrocyticThrombi;

    @Column(name = "interlobular_vein_unaltered_endothelium")
    private Integer interlobularVeinUnalteredEndothelium;

    @Column(name = "interlobular_vein_shedding_of_endothelium")
    private Integer interlobularVeinSheddingOfEndothelium;

    @Column(name = "interlobular_vein_edema_of_endothelium")
    private Integer interlobularVeinEdemaOfEndothelium;

    @Column(name = "interlobular_vein_leukostasis")
    private Integer interlobularVeinLeukostasis;

    @Column(name = "interlobular_vein_marginal_stasis_of_leukocytes")
    private Integer interlobularVeinMarginalStasisOfLeukocytes;

    @Column(name = "interlobular_vein_perivascular_infiltration")
    private Integer interlobularVeinPerivascularInfiltration;

    @Column(name = "interlobular_vein_diapedesis_hemorrhages")
    private Integer interlobularVeinDiapedesisHemorrhages;

    @Column(name = "interlobular_vein_microbes")
    private Integer interlobularVeinMicrobes;

    @Column(name = "cortical_glomerulus_capillary_diameter")
    private Float corticalGlomerulusCapillaryDiameter;

    @Column(name = "cortical_glomerulus_fibrinoid_necrosis")
    private Integer corticalGlomerulusFibrinoidNecrosis;

    @Column(name = "cortical_glomerulus_erythrocytes_in_lumen")
    private Integer corticalGlomerulusErythrocytesInLumen;

    @Column(name = "cortical_glomerulus_sludges")
    private Integer corticalGlomerulusSludges;

    @Column(name = "cortical_glomerulus_thrombi")
    private Integer corticalGlomerulusThrombi;

    @Column(name = "cortical_glomerulus_podocytes_shedding")
    private Integer corticalGlomerulusPodocytesShedding;

    @Column(name = "cortical_glomerulus_nephrotelium_parietal_capsule_shedding")
    private Integer corticalGlomerulusNephroteliumParietalCapsuleShedding;

    @Column(name = "cortical_glomerulus_endothelial_cells_shedding")
    private Integer corticalGlomerulusEndothelialCellsShedding;

    @Column(name = "cortical_glomerulus_bacteria")
    private Integer corticalGlomerulusBacteria;

    @Column(name = "cortical_glomerulus_neutrophils")
    private Integer corticalGlomerulusNeutrophils;

    @Column(name = "cortical_glomerulus_arteriole_diameter")
    private Float corticalGlomerulusArterioleDiameter;

    @Column(name = "cortical_glomerulus_arteriole_wall_thickness")
    private Float corticalGlomerulusArterioleWallThickness;

    @Column(name = "cortical_glomerulus_arteriole_kernoghan_index")
    private Float corticalGlomerulusArterioleKernoghanIndex;

    @Column(name = "cortical_glomerulus_arteriole_hyperemia")
    private Integer corticalGlomerulusArterioleHyperemia;

    @Column(name = "cortical_glomerulus_arteriole_sludges")
    private Integer corticalGlomerulusArterioleSludges;

    @Column(name = "cortical_glomerulus_arteriole_fibrinous_thrombi")
    private Integer corticalGlomerulusArterioleFibrinousThrombi;

    @Column(name = "cortical_glomerulus_arteriole_erythrocytic_thrombi")
    private Integer corticalGlomerulusArterioleErythrocyticThrombi;

    @Column(name = "cortical_glomerulus_arteriole_unaltered_endothelium")
    private Integer corticalGlomerulusArterioleUnalteredEndothelium;

    @Column(name = "cortical_glomerulus_arteriole_shedding_of_endothelium")
    private Integer corticalGlomerulusArterioleSheddingOfEndothelium;

    @Column(name = "cortical_glomerulus_arteriole_edema_of_endothelium")
    private Integer corticalGlomerulusArterioleEdemaOfEndothelium;

    @Column(name = "cortical_glomerulus_arteriole_leukostasis")
    private Integer corticalGlomerulusArterioleLeukostasis;

    @Column(name = "cortical_glomerulus_arteriole_marginal_stasis_of_leukocytes")
    private Integer corticalGlomerulusArterioleMarginalStasisOfLeukocytes;

    @Column(name = "cortical_glomerulus_arteriole_perivascular_infiltration")
    private Integer corticalGlomerulusArteriolePerivascularInfiltration;

    @Column(name = "cortical_glomerulus_arteriole_diapedesis_hemorrhages")
    private Integer corticalGlomerulusArterioleDiapedesisHemorrhages;

    @Column(name = "cortical_glomerulus_arteriole_microbes")
    private Integer corticalGlomerulusArterioleMicrobes;

    private Integer corticalZonePeritubularCapillaryWallThickness;
    private Integer corticalZonePeritubularCapillaryKernoghanIndex;
    private Integer corticalZonePeritubularCapillaryHyperemia;
    private Integer corticalZonePeritubularCapillarySludges;
    private Integer corticalZonePeritubularCapillaryFibrinousThrombi;
    private Integer corticalZonePeritubularCapillaryErythrocyticThrombi;
    private Integer corticalZonePeritubularCapillaryUnalteredEndothelium;
    private Integer corticalZonePeritubularCapillarySheddingOfEndothelium;
    private Integer corticalZonePeritubularCapillaryEdemaOfEndothelium;
    private Float corticalZonePeritubularCapillaryLeukostasis;
    private Float corticalZonePeritubularCapillaryMarginalStasisOfLeukocytes;
    private Float corticalZonePeritubularCapillaryPerivascularInfiltration;
    private Integer corticalZonePeritubularCapillaryDiapedesisHemorrhages;
    private Integer corticalZonePeritubularCapillaryMicrobes;

    private Integer medullaryGlomeruliCapillaryDiameter;
    private Integer medullaryGlomeruliFibrinoidNecrosis;
    private Integer medullaryGlomeruliErythrocytesInLumen;
    private Integer medullaryGlomeruliSludges;
    private Integer medullaryGlomeruliThrombi;
    private Integer medullaryGlomeruliPodocytesShedding;
    private Integer medullaryGlomeruliNephroteliumParietalCapsuleShedding;
    private Integer medullaryGlomeruliSheddingOfEndothelium;
    private Integer medullaryGlomeruliMicrobes;
    private Integer medullaryGlomeruliNeutrophils;

    private Float medullaryGlomerulusArterioleDiameter;
    private Float medullaryGlomerulusArterioleWallThickness;
    private Float medullaryGlomerulusArterioleKernoghanIndex;
    private Integer medullaryGlomerulusArterioleHyperemia;
    private Integer medullaryGlomerulusArterioleSludges;
    private Integer medullaryGlomerulusArterioleFibrinousThrombi;
    private Integer medullaryGlomerulusArterioleErythrocyticThrombi;
    private Integer medullaryGlomerulusArterioleUnalteredEndothelium;
    private Integer medullaryGlomerulusArterioleSheddingOfEndothelium;
    private Integer medullaryGlomerulusArterioleEdemaOfEndothelium;
    private Integer medullaryGlomerulusArterioleLeukostasis;
    private Integer medullaryGlomerulusArterioleMarginalStasisOfLeukocytes;
    private Integer medullaryGlomerulusArteriolePerivascularInfiltration;
    private Integer medullaryGlomerulusArterioleDiapedesisHemorrhages;
    private Integer medullaryGlomerulusArterioleMicrobes;

    private Float medullaryZonePeritubularCapillaryDiameter;
    private Float medullaryZonePeritubularCapillaryWallThickness;
    private Float medullaryZonePeritubularCapillaryKernoghanIndex;
    private Integer medullaryZonePeritubularCapillaryHyperemia;
    private Integer medullaryZonePeritubularCapillarySludges;
    private Integer medullaryZonePeritubularCapillaryFibrinousThrombi;
    private Integer medullaryZonePeritubularCapillaryErythrocyticThrombi;
    private Integer medullaryZonePeritubularCapillaryUnalteredEndothelium;
    private Integer medullaryZonePeritubularCapillarySheddingOfEndothelium;
    private Integer medullaryZonePeritubularCapillaryEdemaOfEndothelium;
    private Integer medullaryZonePeritubularCapillaryLeukostasis;
    private Integer medullaryZonePeritubularCapillaryMarginalStasisOfLeukocytes;
    private Integer medullaryZonePeritubularCapillaryPerivascularInfiltration;
    private Integer medullaryZonePeritubularCapillaryDiapedesisHemorrhages;
    private Integer medullaryZonePeritubularCapillaryMicrobes;

    private Float medullaryZoneStraightVenulesAndCapillariesDiameter;
    private Float medullaryZoneStraightVenulesAndCapillariesWallThickness;
    private Float medullaryZoneStraightVenulesAndCapillariesKernoghanIndex;
    private Integer medullaryZoneStraightVenulesAndCapillariesHyperemia;
    private Integer medullaryZoneStraightVenulesAndCapillariesSludges;
    private Integer medullaryZoneStraightVenulesAndCapillariesFibrinousThrombi;
    private Integer medullaryZoneStraightVenulesAndCapillariesErythrocyticThrombi;
    private Integer medullaryZoneStraightVenulesAndCapillariesUnalteredEndothelium;
    private Integer medullaryZoneStraightVenulesAndCapillariesSheddingOfEndothelium;
    private Integer medullaryZoneStraightVenulesAndCapillariesEdemaOfEndothelium;
    private Integer medullaryZoneStraightVenulesAndCapillariesLeukostasis;
    private Integer medullaryZoneStraightVenulesAndCapillariesMarginalStasisOfLeukocytes;
    private Integer medullaryZoneStraightVenulesAndCapillariesPerivascularInfiltration;
    private Integer medullaryZoneStraightVenulesAndCapillariesDiapedesisHemorrhages;
    private Integer medullaryZoneStraightVenulesAndCapillariesMicrobes;
    private Integer medullaryZoneStraightVenulesAndCapillariesFibrosisOfPeritubularStroma;
}
