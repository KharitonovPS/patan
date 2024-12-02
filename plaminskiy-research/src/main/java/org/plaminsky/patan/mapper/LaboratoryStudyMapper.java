package org.plaminsky.patan.mapper;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.patan.entity.Lung;
import org.plaminsky.patan.repository.DeceasedRecordRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static util.CellExtractor.extractFloatFromCell;

@Component
@RequiredArgsConstructor
public class LaboratoryStudyMapper {

    private final DeceasedRecordRepository deceasedRecordRepository;

    public List<Lung> toLaboratoryStudy(Sheet sheet) {
        List<Lung> laboratoryStudies = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                Lung lung = new Lung();

                lung.setDeceasedRecord(
                            deceasedRecordRepository.findById(row.getCell(1).getStringCellValue()).orElseThrow()
                );

                lung.setErythrocytes10e12PerL(extractFloatFromCell(row.getCell(2)));
                lung.setHemoglobinGPerL(extractFloatFromCell(row.getCell(3)));
                lung.setLeukocytes10e9PerL(extractFloatFromCell(row.getCell(4)));
                lung.setPlatelets10e9PerL(extractFloatFromCell(row.getCell(5)));
                lung.setCreatinineUmolPerL(extractFloatFromCell(row.getCell(6)));
                lung.setCReactiveProteinMgPerL(extractFloatFromCell(row.getCell(7)));
                lung.setProcalcitoninNgPerMl(extractFloatFromCell(row.getCell(8)));
                lung.setTroponinNgPerL(extractFloatFromCell(row.getCell(9)));
                lung.setFerritinUgPerL(extractFloatFromCell(row.getCell(10)));
                lung.setFibrinogenGPerL(extractFloatFromCell(row.getCell(11)));
                lung.setDDimerNgPerMl(extractFloatFromCell(row.getCell(12)));
                lung.setBilirubinUmolPerL(extractFloatFromCell(row.getCell(13)));

                laboratoryStudies.add(lung);
            }
        }

        return laboratoryStudies;
    }

}
