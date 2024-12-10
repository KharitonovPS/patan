create database "patan-spb";
create schema "patan-spb";

create table patan_spb.sepsis_type (
                                       id bigint generated by default as identity,
                                       description varchar(255),
                                       name varchar(255) not null unique,
                                       primary key (id)
);

create table patan_spb.sepsis (
                                  id bigint generated by default as identity,
                                  sepsis_type bigint not null,
                                  autopsy_id varchar(255),
                                  primary key (id),
                                  constraint sepsis_autopsy_id_sepsis_type_uc unique (autopsy_id, sepsis_type)
);

create table patan_spb.brain (
                                 capillary_volume_fraction float4,
                                 cell_sum float4,
                                 changed_cells float4,
                                 congestion_vessels float4,
                                 diapedesis_hemorrhage_in_vessels integer,
                                 drainage_forms_of_oligodendrogliacytes float4,
                                 edema_of_sheaths_trabeculae integer,
                                 endothelial_edema_vessels integer,
                                 endothelial_shedding_vessels integer,
                                 erythrocytic_thrombi_in_vessels integer,
                                 fibrin_clots_in_vessels integer,
                                 glial_reactivity integer,
                                 hyperchromatosis float4,
                                 kernoghan_index_of_arterioles float4,
                                 kernoghan_index_of_venules float4,
                                 kernoghan_index_of_vessels float4,
                                 leukocyte_infiltration integer,
                                 leukocyte_infiltration_of_sheaths integer,
                                 leukostasis_in_vessels integer,
                                 lumen_diameter_of_arterioles float4,
                                 lumen_diameter_of_venules float4,
                                 lumen_diameter_of_vessels float4,
                                 macro_abscesses integer,
                                 marginal_leukocyte_stasis_in_vessels integer,
                                 microabscesses integer,
                                 microbes_in_vessels integer,
                                 pericellular_edema integer,
                                 pericellular_edema_percentage float4,
                                 perinuclear_spaces float4,
                                 perivascular_edema integer,
                                 perivascular_infiltration_vessels integer,
                                 red_cell_sludge_in_vessels integer,
                                 satellite_cells float4,
                                 shadow_cells float4,
                                 unaffected_cells float4,
                                 unaffected_endothelium_vessels integer,
                                 wall_thickness_of_arterioles float4,
                                 wall_thickness_of_venules float4,
                                 wall_thickness_of_vessels float4,
                                 id bigint generated by default as identity,
                                 sepsis_type bigint,
                                 autopsy_id varchar(255),
                                 primary key (id),
                                 unique (autopsy_id, sepsis_type)
);

create table patan_spb.heart (
                                 congestion_in_arterioles integer,
                                 congestion_in_capillaries integer,
                                 congestion_in_venules integer,
                                 diapedesis_hemorrhage_in_arterioles integer,
                                 diapedesis_hemorrhage_in_capillaries integer,
                                 diapedesis_hemorrhage_in_venules integer,
                                 edema_of_endothelium_in_arterioles integer,
                                 edema_of_endothelium_in_capillaries integer,
                                 edema_of_endothelium_in_venules integer,
                                 endothelial_shedding_in_arterioles integer,
                                 endothelial_shedding_in_capillaries integer,
                                 endothelial_shedding_in_venules integer,
                                 erythrocytic_thrombi_in_arterioles integer,
                                 erythrocytic_thrombi_in_capillaries integer,
                                 erythrocytic_thrombi_in_venules integer,
                                 fibrin_clots_in_arterioles integer,
                                 fibrin_clots_in_capillaries integer,
                                 fibrin_clots_in_venules integer,
                                 fibrin_microthrombi integer,
                                 fragmentation_of_cardiomyocytes integer,
                                 kernoghan_index_arterioles float4,
                                 leukostasis_in_arterioles integer,
                                 leukostasis_in_capillaries integer,
                                 leukostasis_in_venules integer,
                                 macro_abscesses integer,
                                 marginal_leukocyte_stasis_in_arterioles integer,
                                 marginal_leukocyte_stasis_in_venules integer,
                                 microabscesses integer,
                                 microbes_in_arterioles integer,
                                 microbes_in_capillaries integer,
                                 microbes_in_venules integer,
                                 mini_abscesses integer,
                                 necrosis_with_inflammatory_reaction integer,
                                 nonreactive_necrosis integer,
                                 overstretching_of_cardiomyocytes integer,
                                 perivascular_infiltration_in_arterioles integer,
                                 perivascular_infiltration_in_capillaries integer,
                                 perivascular_infiltration_in_venules integer,
                                 red_cell_sludge_in_arterioles integer,
                                 red_cell_sludge_in_capillaries integer,
                                 red_cell_sludge_in_venules integer,
                                 spasms integer,
                                 unaffected_endothelium_in_arterioles integer,
                                 unaffected_endothelium_in_capillaries integer,
                                 unaffected_endothelium_in_venules integer,
                                 vacuolar_degeneration integer,
                                 wavy_deformation_of_cardiomyocytes integer,
                                 id bigint generated by default as identity,
                                 sepsis_type bigint,
                                 autopsy_id varchar(255),
                                 primary key (id),
                                 unique (autopsy_id, sepsis_type)
);

create table patan_spb.kidneys (
                                   acute_purulent_inflammation_in_cerebral_substance integer,
                                   acute_purulent_inflammation_in_cortex integer,
                                   apoptosis_of_tubules integer,
                                   area_of_hemorrhage integer,
                                   chronic_fibrosis_of_glomerulus_vessels integer,
                                   cortical_glomerulus_arteriole_diameter float4,
                                   cortical_glomerulus_arteriole_diapedesis_hemorrhages integer,
                                   cortical_glomerulus_arteriole_edema_of_endothelium integer,
                                   cortical_glomerulus_arteriole_erythrocytic_thrombi integer,
                                   cortical_glomerulus_arteriole_fibrinous_thrombi integer,
                                   cortical_glomerulus_arteriole_hyperemia integer,
                                   cortical_glomerulus_arteriole_kernoghan_index float4,
                                   cortical_glomerulus_arteriole_leukostasis integer,
                                   cortical_glomerulus_arteriole_marginal_stasis_of_leukocytes integer,
                                   cortical_glomerulus_arteriole_microbes integer,
                                   cortical_glomerulus_arteriole_perivascular_infiltration integer,
                                   cortical_glomerulus_arteriole_shedding_of_endothelium integer,
                                   cortical_glomerulus_arteriole_sludges integer,
                                   cortical_glomerulus_arteriole_unaltered_endothelium integer,
                                   cortical_glomerulus_arteriole_wall_thickness float4,
                                   cortical_glomerulus_bacteria integer,
                                   cortical_glomerulus_capillary_diameter float4,
                                   cortical_glomerulus_endothelial_cells_shedding integer,
                                   cortical_glomerulus_erythrocytes_in_lumen integer,
                                   cortical_glomerulus_fibrinoid_necrosis integer,
                                   cortical_glomerulus_nephrotelium_parietal_capsule_shedding integer,
                                   cortical_glomerulus_neutrophils integer,
                                   cortical_glomerulus_podocytes_shedding integer,
                                   cortical_glomerulus_sludges integer,
                                   cortical_glomerulus_thrombi integer,
                                   cortical_zone_peritubular_capillary_diapedesis_hemorrhages integer,
                                   cortical_zone_peritubular_capillary_edema_of_endothelium integer,
                                   cortical_zone_peritubular_capillary_erythrocytic_thrombi integer,
                                   cortical_zone_peritubular_capillary_fibrinous_thrombi integer,
                                   cortical_zone_peritubular_capillary_hyperemia integer,
                                   cortical_zone_peritubular_capillary_kernoghan_index integer,
                                   cortical_zone_peritubular_capillary_leukostasis float4,
                                   cortical_zone_peritubular_capillary_marginal_stasis_of_leukocytes float4,
                                   cortical_zone_peritubular_capillary_microbes integer,
                                   cortical_zone_peritubular_capillary_perivascular_infiltration float4,
                                   cortical_zone_peritubular_capillary_shedding_of_endothelium integer,
                                   cortical_zone_peritubular_capillary_sludges integer,
                                   cortical_zone_peritubular_capillary_unaltered_endothelium integer,
                                   cortical_zone_peritubular_capillary_wall_thickness integer,
                                   distal_tubule_necrosis_severity integer,
                                   fibrinoid_necrosis_of_glomerular_vessels integer,
                                   fraction_of_lymphocytic_interstitial_inflammation_in_cerebral_substance integer,
                                   fraction_of_lymphocytic_interstitial_inflammation_in_cortex integer,
                                   hyperemia_of_cerebral_substance integer,
                                   hyperemia_of_cortex integer,
                                   interlobular_artery_diapedesis_hemorrhages integer,
                                   interlobular_artery_edema_of_endothelium integer,
                                   interlobular_artery_erythrocytic_thrombi integer,
                                   interlobular_artery_fibrinous integer,
                                   interlobular_artery_hyperemia integer,
                                   interlobular_artery_internal_diameter float4,
                                   interlobular_artery_kernoghan_index float4,
                                   interlobular_artery_leukostasis integer,
                                   interlobular_artery_marginal_stasis_of_leukocytes integer,
                                   interlobular_artery_microbes integer,
                                   interlobular_artery_perivascular_infiltration integer,
                                   interlobular_artery_shedding_of_endothelium integer,
                                   interlobular_artery_sludges integer,
                                   interlobular_artery_unaltered_endothelium integer,
                                   interlobular_artery_wall_thickness float4,
                                   interlobular_vein_diameter float4,
                                   interlobular_vein_diapedesis_hemorrhages integer,
                                   interlobular_vein_edema_of_endothelium integer,
                                   interlobular_vein_erythrocytic_thrombi integer,
                                   interlobular_vein_fibrinous integer,
                                   interlobular_vein_hyperemia integer,
                                   interlobular_vein_kernoghan_index float4,
                                   interlobular_vein_leukostasis integer,
                                   interlobular_vein_marginal_stasis_of_leukocytes integer,
                                   interlobular_vein_microbes integer,
                                   interlobular_vein_perivascular_infiltration integer,
                                   interlobular_vein_shedding_of_endothelium integer,
                                   interlobular_vein_sludges integer,
                                   interlobular_vein_unaltered_endothelium integer,
                                   interlobular_vein_wall_thickness float4,
                                   interstitial_fibrosis_of_cerebral_substance integer,
                                   interstitial_fibrosis_of_cortex integer,
                                   medullary_glomeruli_capillary_diameter integer,
                                   medullary_glomeruli_erythrocytes_in_lumen integer,
                                   medullary_glomeruli_fibrinoid_necrosis integer,
                                   medullary_glomeruli_microbes integer,
                                   medullary_glomeruli_nephrotelium_parietal_capsule_shedding integer,
                                   medullary_glomeruli_neutrophils integer,
                                   medullary_glomeruli_podocytes_shedding integer,
                                   medullary_glomeruli_shedding_of_endothelium integer,
                                   medullary_glomeruli_sludges integer,
                                   medullary_glomeruli_thrombi integer,
                                   medullary_glomerulus_arteriole_diameter float4,
                                   medullary_glomerulus_arteriole_diapedesis_hemorrhages integer,
                                   medullary_glomerulus_arteriole_edema_of_endothelium integer,
                                   medullary_glomerulus_arteriole_erythrocytic_thrombi integer,
                                   medullary_glomerulus_arteriole_fibrinous_thrombi integer,
                                   medullary_glomerulus_arteriole_hyperemia integer,
                                   medullary_glomerulus_arteriole_kernoghan_index float4,
                                   medullary_glomerulus_arteriole_leukostasis integer,
                                   medullary_glomerulus_arteriole_marginal_stasis_of_leukocytes integer,
                                   medullary_glomerulus_arteriole_microbes integer,
                                   medullary_glomerulus_arteriole_perivascular_infiltration integer,
                                   medullary_glomerulus_arteriole_shedding_of_endothelium integer,
                                   medullary_glomerulus_arteriole_sludges integer,
                                   medullary_glomerulus_arteriole_unaltered_endothelium integer,
                                   medullary_glomerulus_arteriole_wall_thickness float4,
                                   medullary_zone_peritubular_capillary_diameter float4,
                                   medullary_zone_peritubular_capillary_diapedesis_hemorrhages integer,
                                   medullary_zone_peritubular_capillary_edema_of_endothelium integer,
                                   medullary_zone_peritubular_capillary_erythrocytic_thrombi integer,
                                   medullary_zone_peritubular_capillary_fibrinous_thrombi integer,
                                   medullary_zone_peritubular_capillary_hyperemia integer,
                                   medullary_zone_peritubular_capillary_kernoghan_index float4,
                                   medullary_zone_peritubular_capillary_leukostasis integer,
                                   medullary_zone_peritubular_capillary_marginal_stasis_of_leukocytes integer,
                                   medullary_zone_peritubular_capillary_microbes integer,
                                   medullary_zone_peritubular_capillary_perivascular_infiltration integer,
                                   medullary_zone_peritubular_capillary_shedding_of_endothelium integer,
                                   medullary_zone_peritubular_capillary_sludges integer,
                                   medullary_zone_peritubular_capillary_unaltered_endothelium integer,
                                   medullary_zone_peritubular_capillary_wall_thickness float4,
                                   medullary_zone_straight_venules_and_capillaries_diameter float4,
                                   medullary_zone_straight_venules_and_capillaries_diapedesis_hemorrhages integer,
                                   medullary_zone_straight_venules_and_capillaries_edema_of_endothelium integer,
                                   medullary_zone_straight_venules_and_capillaries_erythrocytic_thrombi integer,
                                   medullary_zone_straight_venules_and_capillaries_fibrinous_thrombi integer,
                                   medullary_zone_straight_venules_and_capillaries_fibrosis_of_peritubular_stroma integer,
                                   medullary_zone_straight_venules_and_capillaries_hyperemia integer,
                                   medullary_zone_straight_venules_and_capillaries_kernoghan_index float4,
                                   medullary_zone_straight_venules_and_capillaries_leukostasis integer,
                                   medullary_zone_straight_venules_and_capillaries_marginal_stasis_of_leukocytes integer,
                                   medullary_zone_straight_venules_and_capillaries_microbes integer,
                                   medullary_zone_straight_venules_and_capillaries_perivascular_infiltration integer,
                                   medullary_zone_straight_venules_and_capillaries_shedding_of_endothelium integer,
                                   medullary_zone_straight_venules_and_capillaries_sludges integer,
                                   medullary_zone_straight_venules_and_capillaries_unaltered_endothelium integer,
                                   medullary_zone_straight_venules_and_capillaries_wall_thickness float4,
                                   microbial_emboli_in_arterioles integer,
                                   microbial_emboli_in_glomerular_vessels integer,
                                   microbial_emboli_in_lymphatic_vessels integer,
                                   microbial_emboli_in_peritubular_capillaries integer,
                                   microbial_emboli_in_tubules integer,
                                   nephrotelium_kidney_damage integer,
                                   nerves_dystrophy integer,
                                   neutrophils_in_glomerular_capillaries integer,
                                   neutrophils_in_peritubular_and_straight_capillaries integer,
                                   proximal_tubule_necrosis_severity integer,
                                   shedding_of_endothelium integer,
                                   shedding_of_epithelium_of_tubules integer,
                                   straight_tubules_dystrophy_severity integer,
                                   id bigint generated by default as identity,
                                   sepsis_type bigint,
                                   autopsy_id varchar(255),
                                   primary key (id),
                                   unique (autopsy_id, sepsis_type)
);

create table patan_spb.liver (
                                 apoptotic_body_count_in_field_of_vision_40x float4,
                                 bacteria_arterioles integer,
                                 bacteria_central_veins float4,
                                 bacteria_portal_tract_veins integer,
                                 bacteria_sinusoids integer,
                                 boundary_standing_arterioles integer,
                                 boundary_standing_central_veins integer,
                                 boundary_standing_portal_tract_veins integer,
                                 boundary_standing_sinusoidal_zones_3 integer,
                                 boundary_standing_zone_1 integer,
                                 centro_lobular_necrosis integer,
                                 cholestasis integer,
                                 congestion_arterioles float4,
                                 congestion_central_veins float4,
                                 congestion_portal_tract_veins float4,
                                 congestion_sinusoidal_zone_1 integer,
                                 congestion_sinusoidal_zone_3 integer,
                                 diameter_central_veins float4,
                                 diameter_portal_tract_veins float4,
                                 endothelial_shedding_arterioles float4,
                                 endothelial_shedding_central_veins integer,
                                 endothelial_shedding_portal_tract_veins float4,
                                 endothelial_swelling_arterioles integer,
                                 endothelial_swelling_central_veins float4,
                                 endothelial_swelling_portal_tract_veins integer,
                                 endothelial_swelling_sinusoids integer,
                                 erythrocyte_agreggates_arterioles float4,
                                 erythrocyte_agreggates_central_veins float4,
                                 erythrocyte_agreggates_portal_tract_veins float4,
                                 erythrocyte_agreggates_sinusoidal_zones_1 integer,
                                 erythrocyte_agreggates_sinusoidal_zones_3 integer,
                                 fibrin_clotting_arterioles float4,
                                 fibrin_clotting_central_veins float4,
                                 fibrin_clotting_portal_tract_veins float4,
                                 fibrin_clotting_sinusoidal_zones_1 integer,
                                 fibrin_clotting_sinusoidal_zones_3 integer,
                                 hemorrhages_portal_tracts integer,
                                 intralobular_necrosis integer,
                                 kernohan_index_arterioles float4,
                                 leukostasis_arterioles integer,
                                 leukostasis_central_veins float4,
                                 leukostasis_portal_tract_veins float4,
                                 leukostasis_sinusoidal_zones_1 integer,
                                 leukostasis_sinusoidal_zones_3 integer,
                                 necrosis integer,
                                 neutrophil_count_in_field_of_vision_40x float4,
                                 neutrophils_portal_tracts integer,
                                 sludge_er_arterioles integer,
                                 sludge_er_central_veins float4,
                                 sludge_er_portal_tract_veins float4,
                                 sludge_er_sinusoidal_zones_1 float4,
                                 sludge_er_sinusoidal_zones_3 integer,
                                 subtotal_necrosis integer,
                                 id bigint generated by default as identity,
                                 sepsis_type bigint,
                                 autopsy_id varchar(255),
                                 primary key (id),
                                 unique (autopsy_id, sepsis_type)
);

create table patan_spb.lungs (
                                atelactasis integer,
                                capillary_volume_fraction float4,
                                congestion_arterioles integer,
                                congestion_capillaries integer,
                                congestion_venules integer,
                                diapedesis_hemorrhage_arterioles integer,
                                diapedesis_hemorrhage_capillaries integer,
                                diapedesis_hemorrhage_venules integer,
                                emphysema integer,
                                endothelial_edema_arterioles integer,
                                endothelial_edema_capillaries integer,
                                endothelial_edema_venules integer,
                                endothelial_shedding_arterioles integer,
                                endothelial_shedding_capillaries integer,
                                endothelial_shedding_venules integer,
                                erythrocytic_thrombi_arterioles integer,
                                erythrocytic_thrombi_capillaries integer,
                                erythrocytic_thrombi_venules integer,
                                fibrin_clots_arterioles integer,
                                fibrin_clots_capillaries integer,
                                fibrin_clots_venules integer,
                                fibrosis integer,
                                hyaline_membranes integer,
                                interalveolar_edema integer,
                                intrapulmonary_edema integer,
                                kernoghan_index_arterioles float4,
                                kernoghan_index_venules float4,
                                leukocyte_infiltration_interalveolar_septae integer,
                                leukostasis_arterioles integer,
                                leukostasis_capillaries integer,
                                leukostasis_venules integer,
                                lumen_diameter_arterioles float4,
                                lumen_diameter_venules float4,
                                macro_abscesses integer,
                                marginal_leukocyte_stasis_arterioles integer,
                                marginal_leukocyte_stasis_venules integer,
                                microabscesses integer,
                                microbes_in_arterioles integer,
                                microbes_in_capillaries integer,
                                microbes_in_venules integer,
                                mini_abscesses integer,
                                necrosis_of_alveolocytes integer,
                                perivascular_infiltration_arterioles integer,
                                perivascular_infiltration_capillaries integer,
                                perivascular_infiltration_venules integer,
                                red_cell_sludge_arterioles integer,
                                red_cell_sludge_capillaries integer,
                                red_cell_sludge_venules integer,
                                unaffected_endothelium_arterioles integer,
                                unaffected_endothelium_capillaries integer,
                                unaffected_endothelium_venules integer,
                                wall_thickness_arterioles float4,
                                wall_thickness_venules float4,
                                id bigint generated by default as identity,
                                sepsis_type bigint,
                                autopsy_id varchar(255),
                                primary key (id),
                                unique (autopsy_id, sepsis_type)
);





alter table if exists patan_spb.brain
    add constraint FK6f4ske1rqjef7y4fgrrles4v
        foreign key (autopsy_id, sepsis_type)
            references patan_spb.sepsis (autopsy_id, sepsis_type);

alter table if exists patan_spb.heart
    add constraint FK4kptjr2s4r3l0mf7eq87ow5bn
        foreign key (autopsy_id, sepsis_type)
            references patan_spb.sepsis (autopsy_id, sepsis_type);

alter table if exists patan_spb.kidneys
    add constraint FK7l9m2xothknmdepxyxuuq2dfs
        foreign key (autopsy_id, sepsis_type)
            references patan_spb.sepsis (autopsy_id, sepsis_type);

alter table if exists patan_spb.liver
    add constraint FKbrvh1vxwkjp94p5vksf33aql5
        foreign key (autopsy_id, sepsis_type)
            references patan_spb.sepsis (autopsy_id, sepsis_type);

alter table if exists patan_spb.lungs
    add constraint FKuffpkw49ufqwgtmw3alhkpf6
        foreign key (autopsy_id, sepsis_type)
            references patan_spb.sepsis (autopsy_id, sepsis_type);