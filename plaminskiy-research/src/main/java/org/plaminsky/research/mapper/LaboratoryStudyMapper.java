package org.plaminsky.research.mapper;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.research.entity.LaboratoryStudy;
import org.plaminsky.research.repository.DeceasedRecordRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static util.CellExtractor.extractFloatFromCell;
import static util.CellExtractor.isValid;

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

                laboratoryStudy.setErythrocytes10e12PerL(extractFloatFromCell(row.getCell(2)));
                laboratoryStudy.setHemoglobinGPerL(extractFloatFromCell(row.getCell(3)));
                laboratoryStudy.setLeukocytes10e9PerL(extractFloatFromCell(row.getCell(4)));
                laboratoryStudy.setPlatelets10e9PerL(extractFloatFromCell(row.getCell(5)));
                laboratoryStudy.setCreatinineUmolPerL(extractFloatFromCell(row.getCell(6)));
                laboratoryStudy.setCReactiveProteinMgPerL(extractFloatFromCell(row.getCell(7)));
                laboratoryStudy.setProcalcitoninNgPerMl(extractFloatFromCell(row.getCell(8)));
                laboratoryStudy.setTroponinNgPerL(extractFloatFromCell(row.getCell(9)));
                laboratoryStudy.setFerritinUgPerL(extractFloatFromCell(row.getCell(10)));
                laboratoryStudy.setFibrinogenGPerL(extractFloatFromCell(row.getCell(11)));
                laboratoryStudy.setDDimerNgPerMl(extractFloatFromCell(row.getCell(12)));
                laboratoryStudy.setBilirubinUmolPerL(extractFloatFromCell(row.getCell(13)));

                laboratoryStudies.add(laboratoryStudy);
            }
        }

        return laboratoryStudies;
    }

}
