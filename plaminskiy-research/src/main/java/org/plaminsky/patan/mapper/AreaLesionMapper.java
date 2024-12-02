package org.plaminsky.patan.mapper;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.patan.entity.Brain;
import org.plaminsky.patan.repository.DeceasedRecordRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static util.CellExtractor.extractFloatFromCell;

@Component
@RequiredArgsConstructor
public class AreaLesionMapper {

    private final DeceasedRecordRepository deceasedRecordRepository;

    public List<Brain> toAreaLesions(Sheet sheet) {
        List<Brain> brains = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                Brain brain = new Brain();

                if (row.getCell(1) != null) {
                    brain.setDeceasedRecord(
                            deceasedRecordRepository.findById(row.getCell(1).getStringCellValue()).orElseThrow()
                    );
                }
                brain.setAreaLesionZ1(extractFloatFromCell(row.getCell(2)));
                brain.setAreaLesionZ2(extractFloatFromCell(row.getCell(3)));
                brain.setAreaLesionZ3(extractFloatFromCell(row.getCell(4)));
                brain.setAreaLesionZ4(extractFloatFromCell(row.getCell(5)));
                brain.setAreaLesionZ5(extractFloatFromCell(row.getCell(6)));
                brain.setAreaLesionZ6(extractFloatFromCell(row.getCell(7)));
                brains.add(brain);
            }
        }

        return brains;
    }

}
