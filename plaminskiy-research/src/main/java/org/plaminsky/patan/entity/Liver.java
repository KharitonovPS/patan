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
@Table(name = "liver", schema = "liver")
public class Liver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "autopsy_id", referencedColumnName = "autopsy_id"),
            @JoinColumn(name = "sepsis_type", referencedColumnName = "sepsis_type")
    })
    private Sepsis sepsis;

    @Column(name = "congestion_arterioles")
    private Float congestionArterioles;

    @Column(name = "congestion_central_veins")
    private Float congestionCentralVeins;

    @Column(name = "congestion_portal_tract_veins")
    private Float congestionPortalTractVeins;

    @Column(name = "congestion_sinusoidal_zone_3")
    private Integer congestionSinusoidalZone3;

    @Column(name = "congestion_sinusoidal_zone_1")
    private Integer congestionSinusoidalZone1;

    @Column(name = "fibrin_clotting_arterioles")
    private Float fibrinClottingArterioles;

    @Column(name = "fibrin_clotting_central_veins")
    private Float fibrinClottingCentralVeins;

    @Column(name = "fibrin_clotting_portal_tract_veins")
    private Float fibrinClottingPortalTractVeins;

    @Column(name = "fibrin_clotting_sinusoidal_zones_3")
    private Integer fibrinClottingSinusoidalZones3;

    @Column(name = "fibrin_clotting_sinusoidal_zones_1")
    private Integer fibrinClottingSinusoidalZones1;

    @Column(name = "sludge_er_arterioles")
    private Integer sludgeErArterioles;

    @Column(name = "sludge_er_central_veins")
    private Float sludgeErCentralVeins;

    @Column(name = "sludge_er_portal_tract_veins")
    private Float sludgeErPortalTractVeins;

    @Column(name = "sludge_er_sinusoidal_zones_3")
    private Integer sludgeErSinusoidalZones3;

    @Column(name = "sludge_er_sinusoidal_zones_1")
    private Float sludgeErSinusoidalZones1;

    @Column(name = "erythrocyte_agreggates_arterioles")
    private Float erythrocyteAgreggatesArterioles;

    @Column(name = "erythrocyte_agreggates_central_veins")
    private Float erythrocyteAgreggatesCentralVeins;

    @Column(name = "erythrocyte_agreggates_portal_tract_veins")
    private Float erythrocyteAgreggatesPortalTractVeins;

    @Column(name = "erythrocyte_agreggates_sinusoidal_zones_3")
    private Integer erythrocyteAgreggatesSinusoidalZones3;

    @Column(name = "erythrocyte_agreggates_sinusoidal_zones_1")
    private Integer erythrocyteAgreggatesSinusoidalZones1;

    @Column(name = "endothelial_shedding_arterioles")
    private Float endothelialSheddingArterioles;

    @Column(name = "endothelial_shedding_central_veins")
    private Integer endothelialSheddingCentralVeins;

    @Column(name = "endothelial_shedding_portal_tract_veins")
    private Float endothelialSheddingPortalTractVeins;

    @Column(name = "endothelial_swelling_arterioles")
    private Integer endothelialSwellingArterioles;

    @Column(name = "endothelial_swelling_central_veins")
    private Float endothelialSwellingCentralVeins;

    @Column(name = "endothelial_swelling_portal_tract_veins")
    private Integer endothelialSwellingPortalTractVeins;

    @Column(name = "endothelial_swelling_sinusoids")
    private Integer endothelialSwellingSinusoids;

    @Column(name = "leukostasis_arterioles")
    private Integer leukostasisArterioles;

    @Column(name = "leukostasis_central_veins")
    private Float leukostasisCentralVeins;

    @Column(name = "leukostasis_portal_tract_veins")
    private Float leukostasisPortalTractVeins;

    @Column(name = "leukostasis_sinusoidal_zones_3")
    private Integer leukostasisSinusoidalZones3;

    @Column(name = "leukostasis_sinusoidal_zones_1")
    private Integer leukostasisSinusoidalZones1;

    @Column(name = "boundary_standing_arterioles")
    private Integer boundaryStandingArterioles;

    @Column(name = "boundary_standing_central_veins")
    private Integer boundaryStandingCentralVeins;

    @Column(name = "boundary_standing_portal_tract_veins")
    private Integer boundaryStandingPortalTractVeins;

    @Column(name = "boundary_standing_sinusoidal_zones_3")
    private Integer boundaryStandingSinusoidalZones3;

    @Column(name = "boundary_standing_zone_1")
    private Integer boundaryStandingZone1;

    @Column(name = "hemorrhages_portal_tracts")
    private Integer hemorrhagesPortalTracts;

    @Column(name = "bacteria_arterioles")
    private Integer bacteriaArterioles;

    @Column(name = "bacteria_central_veins")
    private Float bacteriaCentralVeins;

    @Column(name = "bacteria_portal_tract_veins")
    private Integer bacteriaPortalTractVeins;

    @Column(name = "bacteria_sinusoids")
    private Integer bacteriaSinusoids;

    @Column(name = "diameter_central_veins")
    private Float diameterCentralVeins;

    @Column(name = "diameter_portal_tract_veins")
    private Float diameterPortalTractVeins;

    @Column(name = "kernohan_index_arterioles")
    private Float kernohanIndexArterioles;

    @Column(name = "neutrophil_count_in_field_of_vision_40x")
    private Float neutrophilCountInFieldOfVision40x;

    @Column(name = "apoptotic_body_count_in_field_of_vision_40x")
    private Float apoptoticBodyCountInFieldOfVision40x;

    @Column(name = "neutrophils_portal_tracts")
    private Integer neutrophilsPortalTracts;

    @Column(name = "cholestasis")
    private Integer cholestasis;

    @Column(name = "centro_lobular_necrosis")
    private Integer centroLobularNecrosis;

    @Column(name = "intralobular_necrosis")
    private Integer intralobularNecrosis;

    @Column(name = "subtotal_necrosis")
    private Integer subtotalNecrosis;

    @Column(name = "necrosis")
    private Integer necrosis;

}
