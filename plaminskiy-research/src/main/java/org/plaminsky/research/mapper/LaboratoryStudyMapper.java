package org.plaminsky.research.mapper;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.research.entity.LaboratoryStudy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.plaminsky.research.core.SheetConstant.LABORATORY_STUDY_SHEET;

@Component
public class LaboratoryStudyMapper {

    public List<LaboratoryStudy> toLaboratoryStudy(Sheet sheet) {
        List<LaboratoryStudy> laboratoryStudies = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                LaboratoryStudy laboratoryStudy = new LaboratoryStudy();

                // Убедитесь, что каждая ячейка содержит корректный тип данных
                laboratoryStudy.setErythrocytes10e12PerL((float) row.getCell(0).getNumericCellValue());
                laboratoryStudy.setHemoglobinGPerL((float) row.getCell(1).getNumericCellValue());
                laboratoryStudy.setLeukocytes10e9PerL((float) row.getCell(2).getNumericCellValue());
                laboratoryStudy.setPlatelets10e9PerL((float) row.getCell(3).getNumericCellValue());
                laboratoryStudy.setCreatinineUmolPerL((float) row.getCell(4).getNumericCellValue());
                laboratoryStudy.setCReactiveProteinMgPerL((float) row.getCell(5).getNumericCellValue());
                laboratoryStudy.setProcalcitoninNgPerMl((float) row.getCell(6).getNumericCellValue());
                laboratoryStudy.setTroponinNgPerL((float) row.getCell(7).getNumericCellValue());
                laboratoryStudy.setFerritinUgPerL((float) row.getCell(8).getNumericCellValue());
                laboratoryStudy.setFibrinogenGPerL((float) row.getCell(9).getNumericCellValue());
                laboratoryStudy.setDDimerNgPerMl((float) row.getCell(10).getNumericCellValue());
                laboratoryStudy.setBilirubinUmolPerL((float) row.getCell(11).getNumericCellValue());

                laboratoryStudies.add(laboratoryStudy);
            }
        }

        return laboratoryStudies;
    }


}
