package org.plaminsky.research.mapper;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.research.entity.PathomorphArterioles;
import org.plaminsky.research.repository.DeceasedRecordRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PathomorphArteriolesMapper {

    private final DeceasedRecordRepository deceasedRecordRepository;

    public List<PathomorphArterioles> toPathomorphArterioles(Sheet sheet) {
        List<PathomorphArterioles> pathomorphArteriolesList = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                PathomorphArterioles pathomorphArterioles = new PathomorphArterioles();

                // Set deceased record
                if (row.getCell(1) != null) {
                    pathomorphArterioles.setDeceasedRecord(
                            deceasedRecordRepository.findById(row.getCell(1).getStringCellValue()).orElseThrow()
                    );
                }

                // Set volume of microcirculation of arterioles
                pathomorphArterioles.setVolumeOfMicrocirculationOfArteriolesZ1(getCellFloatValue(row.getCell(8)));
                pathomorphArterioles.setVolumeOfMicrocirculationOfArteriolesZ2(getCellFloatValue(row.getCell(9)));
                pathomorphArterioles.setVolumeOfMicrocirculationOfArteriolesZ3(getCellFloatValue(row.getCell(10)));
                pathomorphArterioles.setVolumeOfMicrocirculationOfArteriolesZ4(getCellFloatValue(row.getCell(11)));
                pathomorphArterioles.setVolumeOfMicrocirculationOfArteriolesZ5(getCellFloatValue(row.getCell(12)));
                pathomorphArterioles.setVolumeOfMicrocirculationOfArteriolesZ6(getCellFloatValue(row.getCell(13)));

                // Set total volume of microcirculation of arterioles
                pathomorphArterioles.setTotalVolumeOfMicrocirculationOfArterioles(getCellFloatValue(row.getCell(14)));

                // Set average radius of arterioles
                pathomorphArterioles.setAverageRadiusOfArteriolesZ1(getCellFloatValue(row.getCell(15)));
                pathomorphArterioles.setAverageRadiusOfArteriolesZ2(getCellFloatValue(row.getCell(16)));
                pathomorphArterioles.setAverageRadiusOfArteriolesZ3(getCellFloatValue(row.getCell(17)));
                pathomorphArterioles.setAverageRadiusOfArteriolesZ4(getCellFloatValue(row.getCell(18)));
                pathomorphArterioles.setAverageRadiusOfArteriolesZ5(getCellFloatValue(row.getCell(19)));
                pathomorphArterioles.setAverageRadiusOfArteriolesZ6(getCellFloatValue(row.getCell(20)));

                // Set change in the lumen of arterioles
                pathomorphArterioles.setChangeInTheLumenOfArteriolesZ1(getCellFloatValue(row.getCell(21)));
                pathomorphArterioles.setChangeInTheLumenOfArteriolesZ2(getCellFloatValue(row.getCell(22)));
                pathomorphArterioles.setChangeInTheLumenOfArteriolesZ3(getCellFloatValue(row.getCell(23)));
                pathomorphArterioles.setChangeInTheLumenOfArteriolesZ4(getCellFloatValue(row.getCell(24)));
                pathomorphArterioles.setChangeInTheLumenOfArteriolesZ5(getCellFloatValue(row.getCell(25)));
                pathomorphArterioles.setChangeInTheLumenOfVenulesZ6(getCellFloatValue(row.getCell(26)));

                // Set resistance of arterioles
                pathomorphArterioles.setResistanceOfArteriolesZ1(getCellFloatValue(row.getCell(27)));
                pathomorphArterioles.setResistanceOfArteriolesZ2(getCellFloatValue(row.getCell(28)));
                pathomorphArterioles.setResistanceOfArteriolesZ3(getCellFloatValue(row.getCell(29)));
                pathomorphArterioles.setResistanceOfArteriolesZ4(getCellFloatValue(row.getCell(30)));
                pathomorphArterioles.setResistanceOfArteriolesZ5(getCellFloatValue(row.getCell(31)));
                pathomorphArterioles.setResistanceOfArteriolesZ6(getCellFloatValue(row.getCell(32)));

                pathomorphArteriolesList.add(pathomorphArterioles);
            }
        }

        return pathomorphArteriolesList;
    }

    //TODO: вынести в утильный класс
    private Float getCellFloatValue(Cell cell) {
        if (cell != null) {
            if (cell.getCellType() == CellType.NUMERIC) {
                try {
                    return (float) cell.getNumericCellValue();
                } catch (Exception e) {
                    return null;
                }
            }
        }
        return 0.0f;
    }
}