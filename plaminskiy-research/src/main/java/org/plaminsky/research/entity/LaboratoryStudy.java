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
public class LaboratoryStudy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deceased_record_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_deceased_record")
    )
    private DeceasedRecord deceasedRecord;

    @Column(name = "erythrocytes_10e12_per_L")
    private float erythrocytes10e12PerL;

    @Column(name = "hemoglobin_g_per_L")
    private float hemoglobinGPerL;

    @Column(name = "leukocytes_10e9_per_L")
    private float leukocytes10e9PerL;

    @Column(name = "platelets_10e9_per_L")
    private float platelets10e9PerL;

    @Column(name = "creatinine_umol_per_L")
    private float creatinineUmolPerL;

    @Column(name = "c_reactive_protein_mg_per_L")
    private float cReactiveProteinMgPerL;

    @Column(name = "procalcitonin_ng_per_mL")
    private float procalcitoninNgPerMl;

    @Column(name = "troponin_ng_per_L")
    private float troponinNgPerL;

    @Column(name = "ferritin_ug_per_L")
    private float ferritinUgPerL;

    @Column(name = "fibrinogen_g_per_L")
    private float fibrinogenGPerL;

    @Column(name = "d_dimer_ng_per_mL")
    private float dDimerNgPerMl;

    @Column(name = "bilirubin_umol_per_L")
    private float bilirubinUmolPerL;
}
