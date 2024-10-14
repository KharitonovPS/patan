package org.plaminsky.research.mapper;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.research.entity.AreaLesion;
import org.plaminsky.research.repository.DeceasedRecordRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

                if (row.getCell(2) != null) {
                    areaLesion.setAreaLesionZ1((float) row.getCell(2).getNumericCellValue());
                }
                if (row.getCell(3) != null) {
                    areaLesion.setAreaLesionZ2((float) row.getCell(3).getNumericCellValue());
                }
                if (row.getCell(4) != null) {
                    areaLesion.setAreaLesionZ3((float) row.getCell(4).getNumericCellValue());
                }
                if (row.getCell(5) != null) {
                    areaLesion.setAreaLesionZ4((float) row.getCell(5).getNumericCellValue());
                }
                if (row.getCell(6) != null) {
                    areaLesion.setAreaLesionZ5((float) row.getCell(6).getNumericCellValue());
                }
                if (row.getCell(7) != null) {
                    areaLesion.setAreaLesionZ6((float) row.getCell(7).getNumericCellValue());
                }
                areaLesions.add(areaLesion);
            }
        }

        return areaLesions;
    }

}
