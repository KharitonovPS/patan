package org.plaminsky.research.mapper;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.research.entity.AreaLesion;
import org.plaminsky.research.repository.DeceasedRecordRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static util.CellExtractor.extractFloatFromCell;

@Component
@RequiredArgsConstructor
public class AreaLesionMapper {

    private final DeceasedRecordRepository deceasedRecordRepository;

    public List<AreaLesion> toAreaLesions(Sheet sheet) {
        List<AreaLesion> areaLesions = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                AreaLesion areaLesion = new AreaLesion();

                if (row.getCell(1) != null) {
                    areaLesion.setDeceasedRecord(
                            deceasedRecordRepository.findById(row.getCell(1).getStringCellValue()).orElseThrow()
                    );
                }
                areaLesion.setAreaLesionZ1(extractFloatFromCell(row.getCell(2)));
                areaLesion.setAreaLesionZ2(extractFloatFromCell(row.getCell(3)));
                areaLesion.setAreaLesionZ3(extractFloatFromCell(row.getCell(4)));
                areaLesion.setAreaLesionZ4(extractFloatFromCell(row.getCell(5)));
                areaLesion.setAreaLesionZ5(extractFloatFromCell(row.getCell(6)));
                areaLesion.setAreaLesionZ6(extractFloatFromCell(row.getCell(7)));
                areaLesions.add(areaLesion);
            }
        }

        return areaLesions;
    }

}
