create database "pmva-plaminskiy";

create table deceased_record
(
    age               integer,
    bed_days          integer,
    date_of_death     date not null,
    phase_of_covid_19 integer,
    id                bigint generated by default as identity,
    gender            varchar(255) check (gender in ('MALE', 'FEMALE')),
    primary key (id)
);
create table area_lesion
(
    area_lesion_z1     float4,
    area_lesion_z2     float4,
    area_lesion_z3     float4,
    area_lesion_z4     float4,
    area_lesion_z5     float4,
    area_lesion_z6     float4,
    deceased_record_id bigint unique,
    id                 bigint generated by default as identity,
    primary key (id)
);
create table laboratory_study
(
    bilirubin_umol_per_l        float4,
    c_reactive_protein_mg_per_l float4,
    creatinine_umol_per_l       float4,
    d_dimer_ng_per_ml           float4,
    erythrocytes_10e12_per_l    float4,
    ferritin_ug_per_l           float4,
    fibrinogen_g_per_l          float4,
    hemoglobin_g_per_l          float4,
    leukocytes_10e9_per_l       float4,
    platelets_10e9_per_l        float4,
    procalcitonin_ng_per_ml     float4,
    troponin_ng_per_l           float4,
    deceased_record_id          bigint unique,
    id                          bigint generated by default as identity,
    primary key (id)
);
create table pathomorph_arterioles
(
    average_radius_of_arterioles_z1                float4,
    average_radius_of_arterioles_z2                float4,
    average_radius_of_arterioles_z3                float4,
    average_radius_of_arterioles_z4                float4,
    average_radius_of_arterioles_z5                float4,
    average_radius_of_arterioles_z6                float4,
    change_in_the_lumen_of_arterioles_z1           float4,
    change_in_the_lumen_of_arterioles_z2           float4,
    change_in_the_lumen_of_arterioles_z3           float4,
    change_in_the_lumen_of_arterioles_z4           float4,
    change_in_the_lumen_of_arterioles_z5           float4,
    change_in_the_lumen_of_venules_z6              float4,
    radius_of_arterioles_z1                        float4,
    radius_of_arterioles_z2                        float4,
    radius_of_arterioles_z3                        float4,
    radius_of_arterioles_z4                        float4,
    radius_of_arterioles_z5                        float4,
    radius_of_arterioles_z6                        float4,
    resistance_of_arterioles_z1                    float4,
    resistance_of_arterioles_z2                    float4,
    resistance_of_arterioles_z3                    float4,
    resistance_of_arterioles_z4                    float4,
    resistance_of_arterioles_z5                    float4,
    resistance_of_arterioles_z6                    float4,
    total_volume_of_microcirculation_of_arterioles float4,
    volume_of_microcirculation_of_arterioles_z1    float4,
    volume_of_microcirculation_of_arterioles_z2    float4,
    volume_of_microcirculation_of_arterioles_z3    float4,
    volume_of_microcirculation_of_arterioles_z4    float4,
    volume_of_microcirculation_of_arterioles_z5    float4,
    volume_of_microcirculation_of_arterioles_z6    float4,
    deceased_record_id                             bigint unique,
    id                                             bigint generated by default as identity,
    primary key (id)
);
create table pathomorph_venules
(
    average_radius_of_venules_z1                float4,
    average_radius_of_venules_z2                float4,
    average_radius_of_venules_z3                float4,
    average_radius_of_venules_z4                float4,
    average_radius_of_venules_z5                float4,
    average_radius_of_venules_z6                float4,
    change_in_the_lumen_of_venules_z1           float4,
    change_in_the_lumen_of_venules_z2           float4,
    change_in_the_lumen_of_venules_z3           float4,
    change_in_the_lumen_of_venules_z4           float4,
    change_in_the_lumen_of_venules_z5           float4,
    change_in_the_lumen_of_venules_z6           float4,
    radius_of_venules_z1                        float4,
    radius_of_venules_z2                        float4,
    radius_of_venules_z3                        float4,
    radius_of_venules_z4                        float4,
    radius_of_venules_z5                        float4,
    radius_of_venules_z6                        float4,
    resistance_of_venules_z1                    float4,
    resistance_of_venules_z2                    float4,
    resistance_of_venules_z3                    float4,
    resistance_of_venules_z4                    float4,
    resistance_of_venules_z5                    float4,
    resistance_of_venules_z6                    float4,
    total_volume_of_microcirculation_of_venules float4,
    volume_of_microcirculation_of_venules_z1    float4,
    volume_of_microcirculation_of_venules_z2    float4,
    volume_of_microcirculation_of_venules_z3    float4,
    volume_of_microcirculation_of_venules_z4    float4,
    volume_of_microcirculation_of_venules_z5    float4,
    volume_of_microcirculation_of_venules_z6    float4,
    deceased_record_id                          bigint unique,
    id                                          bigint generated by default as identity,
    primary key (id)
);
create table pathomorph_сapillaries
(
    capillary_density_from_the_area_of_interalveolar_septa_z1  float4,
    capillary_density_from_the_area_of_interalveolar_septa_z2  float4,
    capillary_density_from_the_area_of_interalveolar_septa_z3  float4,
    capillary_density_from_the_area_of_interalveolar_septa_z4  float4,
    capillary_density_from_the_area_of_interalveolar_septa_z5  float4,
    capillary_density_from_the_area_of_interalveolar_septa_z6  float4,
    change_in_the_lumen_of_capillaries_z2                      float4,
    change_in_the_lumen_of_capillaries_z3                      float4,
    change_in_the_lumen_of_capillaries_z4                      float4,
    change_in_the_lumen_of_capillaries_z5                      float4,
    change_in_the_lumen_of_capillaries_z6                      float4,
    change_in_the_lumen_of_venules_z1                          float4,
    radius_of_capillaries_z1                                   float4,
    radius_of_capillaries_z2                                   float4,
    radius_of_capillaries_z3                                   float4,
    radius_of_capillaries_z4                                   float4,
    radius_of_capillaries_z5                                   float4,
    radius_of_capillaries_z6                                   float4,
    resistance_of_capillaries_z1                               float4,
    resistance_of_capillaries_z2                               float4,
    resistance_of_capillaries_z3                               float4,
    resistance_of_capillaries_z4                               float4,
    resistance_of_capillaries_z5                               float4,
    resistance_of_capillaries_z6                               float4,
    total_volume_of_the_microcirculation_system_of_capillaries float4,
    volume_of_the_microcirculation_system_of_capillaries_z1    float4,
    volume_of_the_microcirculation_system_of_capillaries_z2    float4,
    volume_of_the_microcirculation_system_of_capillaries_z3    float4,
    volume_of_the_microcirculation_system_of_capillaries_z4    float4,
    volume_of_the_microcirculation_system_of_capillaries_z5    float4,
    volume_of_the_microcirculation_system_of_capillaries_z6    float4,
    deceased_record_id                                         bigint unique,
    id                                                         bigint generated by default as identity,
    primary key (id)
);

alter table if exists area_lesion
    add constraint fk_deceased_record
        foreign key (deceased_record_id)
            references deceased_record;

alter table if exists laboratory_study
    add constraint fk_deceased_record
        foreign key (deceased_record_id)
            references deceased_record;

alter table if exists pathomorph_arterioles
    add constraint fk_deceased_record
        foreign key (deceased_record_id)
            references deceased_record;

alter table if exists pathomorph_venules
    add constraint fk_deceased_record
        foreign key (deceased_record_id)
            references deceased_record;

alter table if exists pathomorph_сapillaries
    add constraint fk_deceased_record
        foreign key (deceased_record_id)
            references deceased_record;