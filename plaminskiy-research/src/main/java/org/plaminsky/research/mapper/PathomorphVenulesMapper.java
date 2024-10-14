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

                if (row.getCell(2) != null) {
                    pathomorphVenules.setRadiusOfVenulesZ1(getFloatCellValue(row.getCell(2)));
                }
                if (row.getCell(3) != null) {
                    pathomorphVenules.setRadiusOfVenulesZ2(getFloatCellValue(row.getCell(3)));
                }
                if (row.getCell(4) != null) {
                    pathomorphVenules.setRadiusOfVenulesZ3(getFloatCellValue(row.getCell(4)));
                }
                if (row.getCell(5) != null) {
                    pathomorphVenules.setRadiusOfVenulesZ4(getFloatCellValue(row.getCell(5)));
                }
                if (row.getCell(6) != null) {
                    pathomorphVenules.setRadiusOfVenulesZ5(getFloatCellValue(row.getCell(6)));
                }
                if (row.getCell(7) != null) {
                    pathomorphVenules.setRadiusOfVenulesZ6(getFloatCellValue(row.getCell(7)));
                }

                if (row.getCell(8) != null) {
                    pathomorphVenules.setVolumeOfMicrocirculationOfVenulesZ1(getFloatCellValue(row.getCell(8)));
                }
                if (row.getCell(9) != null) {
                    pathomorphVenules.setVolumeOfMicrocirculationOfVenulesZ2(getFloatCellValue(row.getCell(9)));
                }
                if (row.getCell(10) != null) {
                    pathomorphVenules.setVolumeOfMicrocirculationOfVenulesZ3(getFloatCellValue(row.getCell(10)));
                }
                if (row.getCell(11) != null) {
                    pathomorphVenules.setVolumeOfMicrocirculationOfVenulesZ4(getFloatCellValue(row.getCell(11)));
                }
                if (row.getCell(12) != null) {
                    pathomorphVenules.setVolumeOfMicrocirculationOfVenulesZ5(getFloatCellValue(row.getCell(12)));
                }
                if (row.getCell(13) != null) {
                    pathomorphVenules.setVolumeOfMicrocirculationOfVenulesZ6(getFloatCellValue(row.getCell(13)));
                }

                if (row.getCell(14) != null) {
                    pathomorphVenules.setTotalVolumeOfMicrocirculationOfVenules(getFloatCellValue(row.getCell(14)));
                }

                if (row.getCell(15) != null) {
                    pathomorphVenules.setAverageRadiusOfVenulesZ1(getFloatCellValue(row.getCell(15)));
                }
                if (row.getCell(16) != null) {
                    pathomorphVenules.setAverageRadiusOfVenulesZ2(getFloatCellValue(row.getCell(16)));
                }
                if (row.getCell(17) != null) {
                    pathomorphVenules.setAverageRadiusOfVenulesZ3(getFloatCellValue(row.getCell(17)));
                }
                if (row.getCell(18) != null) {
                    pathomorphVenules.setAverageRadiusOfVenulesZ4(getFloatCellValue(row.getCell(18)));
                }
                if (row.getCell(19) != null) {
                    pathomorphVenules.setAverageRadiusOfVenulesZ5(getFloatCellValue(row.getCell(19)));
                }
                if (row.getCell(20) != null) {
                    pathomorphVenules.setAverageRadiusOfVenulesZ6(getFloatCellValue(row.getCell(20)));
                }

                if (row.getCell(21) != null) {
                    pathomorphVenules.setChangeInTheLumenOfVenulesZ1(getFloatCellValue(row.getCell(21)));
                }
                if (row.getCell(22) != null) {
                    pathomorphVenules.setChangeInTheLumenOfVenulesZ2(getFloatCellValue(row.getCell(22)));
                }
                if (row.getCell(23) != null) {
                    pathomorphVenules.setChangeInTheLumenOfVenulesZ3(getFloatCellValue(row.getCell(23)));
                }
                if (row.getCell(24) != null) {
                    pathomorphVenules.setChangeInTheLumenOfVenulesZ4(getFloatCellValue(row.getCell(24)));
                }
                if (row.getCell(25) != null) {
                    pathomorphVenules.setChangeInTheLumenOfVenulesZ5(getFloatCellValue(row.getCell(25)));
                }
                if (row.getCell(26) != null) {
                    pathomorphVenules.setChangeInTheLumenOfVenulesZ6(getFloatCellValue(row.getCell(26)));
                }

                if (row.getCell(27) != null) {
                    pathomorphVenules.setResistanceOfVenulesZ1(getFloatCellValue(row.getCell(27)));
                }
                if (row.getCell(28) != null) {
                    pathomorphVenules.setResistanceOfVenulesZ2(getFloatCellValue(row.getCell(28)));
                }
                if (row.getCell(29) != null) {
                    pathomorphVenules.setResistanceOfVenulesZ3(getFloatCellValue(row.getCell(29)));
                }
                if (row.getCell(30) != null) {
                    pathomorphVenules.setResistanceOfVenulesZ4(getFloatCellValue(row.getCell(30)));
                }
                if (row.getCell(31) != null) {
                    pathomorphVenules.setResistanceOfVenulesZ5(getFloatCellValue(row.getCell(31)));
                }
                if (row.getCell(32) != null) {
                    pathomorphVenules.setResistanceOfVenulesZ6(getFloatCellValue(row.getCell(32)));
                }

                pathomorphVenulesList.add(pathomorphVenules);
            }
        }

        return pathomorphVenulesList;
    }

    private Float getFloatCellValue(Cell cell) {
        return (cell != null && cell.getCellType() == CellType.NUMERIC)
                ? (float) cell.getNumericCellValue()
                : 0.0f;
    }
}