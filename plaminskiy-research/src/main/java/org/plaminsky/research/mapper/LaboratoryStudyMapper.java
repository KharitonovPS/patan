package org.plaminsky.research.mapper;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.research.entity.LaboratoryStudy;
import org.plaminsky.research.repository.DeceasedRecordRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class LaboratoryStudyMapper {

    private final DeceasedRecordRepository deceasedRecordRepository;

    public List<LaboratoryStudy> toLaboratoryStudy(Sheet sheet) {
        List<LaboratoryStudy> laboratoryStudies = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                LaboratoryStudy laboratoryStudy = new LaboratoryStudy();

                laboratoryStudy.setDeceasedRecord(
                        deceasedRecordRepository.findById(row.getCell(1).getStringCellValue()).orElseThrow()
                );

                if (row.getCell(2) != null) {
                    laboratoryStudy.setErythrocytes10e12PerL((float) row.getCell(2).getNumericCellValue());
                }
                if (row.getCell(3) != null) {
                    laboratoryStudy.setHemoglobinGPerL((float) row.getCell(3).getNumericCellValue());
                }
                if (row.getCell(4) != null) {
                    laboratoryStudy.setLeukocytes10e9PerL((float) row.getCell(4).getNumericCellValue());
                }
                if (row.getCell(5) != null) {
                    laboratoryStudy.setPlatelets10e9PerL((float) row.getCell(5).getNumericCellValue());
                }
                if (row.getCell(6) != null) {
                    laboratoryStudy.setCreatinineUmolPerL((float) row.getCell(6).getNumericCellValue());
                }
                if (row.getCell(7) != null) {
                    laboratoryStudy.setCReactiveProteinMgPerL((float) row.getCell(7).getNumericCellValue());
                }
                if (row.getCell(8) != null) {
                    laboratoryStudy.setProcalcitoninNgPerMl((float) row.getCell(8).getNumericCellValue());
                }
                if (row.getCell(9) != null) {
                    laboratoryStudy.setTroponinNgPerL((float) row.getCell(9).getNumericCellValue());
                }
                if (row.getCell(10) != null) {
                    laboratoryStudy.setFerritinUgPerL((float) row.getCell(10).getNumericCellValue());
                }
                if (row.getCell(11) != null) {
                    laboratoryStudy.setFibrinogenGPerL((float) row.getCell(11).getNumericCellValue());
                }
                if (row.getCell(12) != null) {
                    laboratoryStudy.setDDimerNgPerMl((float) row.getCell(12).getNumericCellValue());
                }
                if (row.getCell(14) != null) {
                    laboratoryStudy.setBilirubinUmolPerL((float) row.getCell(14).getNumericCellValue());
                }

                laboratoryStudies.add(laboratoryStudy);
            }
        }

        return laboratoryStudies;
    }

}
