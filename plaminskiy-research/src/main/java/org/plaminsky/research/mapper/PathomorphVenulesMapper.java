package org.plaminsky.research.mapper;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.research.entity.PathomorphVenules;
import org.plaminsky.research.repository.DeceasedRecordRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static util.CellExtractor.extractFloatFromCell;

@Component
@RequiredArgsConstructor
public class PathomorphVenulesMapper {

    private final DeceasedRecordRepository deceasedRecordRepository;

    public List<PathomorphVenules> toPathomorphVenules(Sheet sheet) {
        List<PathomorphVenules> pathomorphVenulesList = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                PathomorphVenules pathomorphVenules = new PathomorphVenules();

                if (row.getCell(1) != null) {
                    pathomorphVenules.setDeceasedRecord(
                            deceasedRecordRepository.findById(row.getCell(1).getStringCellValue()).orElseThrow()
                    );
                }

                pathomorphVenules.setRadiusOfVenulesZ1(extractFloatFromCell(row.getCell(2)));
                pathomorphVenules.setRadiusOfVenulesZ2(extractFloatFromCell(row.getCell(3)));
                pathomorphVenules.setRadiusOfVenulesZ3(extractFloatFromCell(row.getCell(4)));
                pathomorphVenules.setRadiusOfVenulesZ4(extractFloatFromCell(row.getCell(5)));
                pathomorphVenules.setRadiusOfVenulesZ5(extractFloatFromCell(row.getCell(6)));
                pathomorphVenules.setRadiusOfVenulesZ6(extractFloatFromCell(row.getCell(7)));

                pathomorphVenules.setVolumeOfMicrocirculationOfVenulesZ1(extractFloatFromCell(row.getCell(8)));
                pathomorphVenules.setVolumeOfMicrocirculationOfVenulesZ2(extractFloatFromCell(row.getCell(9)));
                pathomorphVenules.setVolumeOfMicrocirculationOfVenulesZ3(extractFloatFromCell(row.getCell(10)));
                pathomorphVenules.setVolumeOfMicrocirculationOfVenulesZ4(extractFloatFromCell(row.getCell(11)));
                pathomorphVenules.setVolumeOfMicrocirculationOfVenulesZ5(extractFloatFromCell(row.getCell(12)));
                pathomorphVenules.setVolumeOfMicrocirculationOfVenulesZ6(extractFloatFromCell(row.getCell(13)));

                pathomorphVenules.setTotalVolumeOfMicrocirculationOfVenules(extractFloatFromCell(row.getCell(14)));

                pathomorphVenules.setAverageRadiusOfVenulesZ1(extractFloatFromCell(row.getCell(15)));
                pathomorphVenules.setAverageRadiusOfVenulesZ2(extractFloatFromCell(row.getCell(16)));
                pathomorphVenules.setAverageRadiusOfVenulesZ3(extractFloatFromCell(row.getCell(17)));
                pathomorphVenules.setAverageRadiusOfVenulesZ4(extractFloatFromCell(row.getCell(18)));
                pathomorphVenules.setAverageRadiusOfVenulesZ5(extractFloatFromCell(row.getCell(19)));
                pathomorphVenules.setAverageRadiusOfVenulesZ6(extractFloatFromCell(row.getCell(20)));

                pathomorphVenules.setChangeInTheLumenOfVenulesZ1(extractFloatFromCell(row.getCell(21)));
                pathomorphVenules.setChangeInTheLumenOfVenulesZ2(extractFloatFromCell(row.getCell(22)));
                pathomorphVenules.setChangeInTheLumenOfVenulesZ3(extractFloatFromCell(row.getCell(23)));
                pathomorphVenules.setChangeInTheLumenOfVenulesZ4(extractFloatFromCell(row.getCell(24)));
                pathomorphVenules.setChangeInTheLumenOfVenulesZ5(extractFloatFromCell(row.getCell(25)));
                pathomorphVenules.setChangeInTheLumenOfVenulesZ6(extractFloatFromCell(row.getCell(26)));

                pathomorphVenules.setResistanceOfVenulesZ1(extractFloatFromCell(row.getCell(27)));
                pathomorphVenules.setResistanceOfVenulesZ2(extractFloatFromCell(row.getCell(28)));
                pathomorphVenules.setResistanceOfVenulesZ3(extractFloatFromCell(row.getCell(29)));
                pathomorphVenules.setResistanceOfVenulesZ4(extractFloatFromCell(row.getCell(30)));
                pathomorphVenules.setResistanceOfVenulesZ5(extractFloatFromCell(row.getCell(31)));
                pathomorphVenules.setResistanceOfVenulesZ6(extractFloatFromCell(row.getCell(32)));
                pathomorphVenulesList.add(pathomorphVenules);
            }
        }
        return pathomorphVenulesList;
    }
    
}