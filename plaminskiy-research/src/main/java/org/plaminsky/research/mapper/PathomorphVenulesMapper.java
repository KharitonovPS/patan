package org.plaminsky.research.mapper;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.research.entity.PathomorphVenules;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PathomorphVenulesMapper {

    public List<PathomorphVenules> toPathomorphVenules(Sheet sheet) {
        List<PathomorphVenules> pathomorphVenulesList = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                PathomorphVenules pathomorphVenules = new PathomorphVenules();

                pathomorphVenules.setRadiusOfVenulesZ1((float) row.getCell(0).getNumericCellValue());
                pathomorphVenules.setRadiusOfVenulesZ2((float) row.getCell(1).getNumericCellValue());
                pathomorphVenules.setRadiusOfVenulesZ3((float) row.getCell(2).getNumericCellValue());
                pathomorphVenules.setRadiusOfVenulesZ4((float) row.getCell(3).getNumericCellValue());
                pathomorphVenules.setRadiusOfVenulesZ5((float) row.getCell(4).getNumericCellValue());
                pathomorphVenules.setRadiusOfVenulesZ6((float) row.getCell(5).getNumericCellValue());

                pathomorphVenules.setVolumeOfMicrocirculationOfVenulesZ1((float) row.getCell(6).getNumericCellValue());
                pathomorphVenules.setVolumeOfMicrocirculationOfVenulesZ2((float) row.getCell(7).getNumericCellValue());
                pathomorphVenules.setVolumeOfMicrocirculationOfVenulesZ3((float) row.getCell(8).getNumericCellValue());
                pathomorphVenules.setVolumeOfMicrocirculationOfVenulesZ4((float) row.getCell(9).getNumericCellValue());
                pathomorphVenules.setVolumeOfMicrocirculationOfVenulesZ5((float) row.getCell(10).getNumericCellValue());
                pathomorphVenules.setVolumeOfMicrocirculationOfVenulesZ6((float) row.getCell(11).getNumericCellValue());

                pathomorphVenules.setTotalVolumeOfMicrocirculationOfVenules((float) row.getCell(12).getNumericCellValue());

                pathomorphVenules.setAverageRadiusOfVenulesZ1((float) row.getCell(13).getNumericCellValue());
                pathomorphVenules.setAverageRadiusOfVenulesZ2((float) row.getCell(14).getNumericCellValue());
                pathomorphVenules.setAverageRadiusOfVenulesZ3((float) row.getCell(15).getNumericCellValue());
                pathomorphVenules.setAverageRadiusOfVenulesZ4((float) row.getCell(16).getNumericCellValue());
                pathomorphVenules.setAverageRadiusOfVenulesZ5((float) row.getCell(17).getNumericCellValue());
                pathomorphVenules.setAverageRadiusOfVenulesZ6((float) row.getCell(18).getNumericCellValue());

                pathomorphVenules.setChangeInTheLumenOfVenulesZ1((float) row.getCell(19).getNumericCellValue());
                pathomorphVenules.setChangeInTheLumenOfVenulesZ2((float) row.getCell(20).getNumericCellValue());
                pathomorphVenules.setChangeInTheLumenOfVenulesZ3((float) row.getCell(21).getNumericCellValue());
                pathomorphVenules.setChangeInTheLumenOfVenulesZ4((float) row.getCell(22).getNumericCellValue());
                pathomorphVenules.setChangeInTheLumenOfVenulesZ5((float) row.getCell(23).getNumericCellValue());
                pathomorphVenules.setChangeInTheLumenOfVenulesZ6((float) row.getCell(24).getNumericCellValue());

                pathomorphVenules.setResistanceOfVenulesZ1((float) row.getCell(25).getNumericCellValue());
                pathomorphVenules.setResistanceOfVenulesZ2((float) row.getCell(26).getNumericCellValue());
                pathomorphVenules.setResistanceOfVenulesZ3((float) row.getCell(27).getNumericCellValue());
                pathomorphVenules.setResistanceOfVenulesZ4((float) row.getCell(28).getNumericCellValue());
                pathomorphVenules.setResistanceOfVenulesZ5((float) row.getCell(29).getNumericCellValue());
                pathomorphVenules.setResistanceOfVenulesZ6((float) row.getCell(30).getNumericCellValue());

                pathomorphVenulesList.add(pathomorphVenules);
            }
        }

        return pathomorphVenulesList;
    }

}
