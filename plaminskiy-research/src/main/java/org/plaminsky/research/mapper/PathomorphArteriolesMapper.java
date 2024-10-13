package org.plaminsky.research.mapper;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.research.entity.LaboratoryStudy;
import org.plaminsky.research.entity.PathomorphArterioles;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PathomorphArteriolesMapper {

    public List<PathomorphArterioles> toPathomorphArterioles(Sheet sheet) {
        List<PathomorphArterioles> pathomorphArteriolesList = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                PathomorphArterioles pathomorphArterioles = new PathomorphArterioles();

                // Присваиваем значения из ячеек
                pathomorphArterioles.setRadiusOfArteriolesZ1((float) row.getCell(0).getNumericCellValue());
                pathomorphArterioles.setRadiusOfArteriolesZ2((float) row.getCell(1).getNumericCellValue());
                pathomorphArterioles.setRadiusOfArteriolesZ3((float) row.getCell(2).getNumericCellValue());
                pathomorphArterioles.setRadiusOfArteriolesZ4((float) row.getCell(3).getNumericCellValue());
                pathomorphArterioles.setRadiusOfArteriolesZ5((float) row.getCell(4).getNumericCellValue());
                pathomorphArterioles.setRadiusOfArteriolesZ6((float) row.getCell(5).getNumericCellValue());

                pathomorphArterioles.setVolumeOfMicrocirculationOfArteriolesZ1((float) row.getCell(6).getNumericCellValue());
                pathomorphArterioles.setVolumeOfMicrocirculationOfArteriolesZ2((float) row.getCell(7).getNumericCellValue());
                pathomorphArterioles.setVolumeOfMicrocirculationOfArteriolesZ3((float) row.getCell(8).getNumericCellValue());
                pathomorphArterioles.setVolumeOfMicrocirculationOfArteriolesZ4((float) row.getCell(9).getNumericCellValue());
                pathomorphArterioles.setVolumeOfMicrocirculationOfArteriolesZ5((float) row.getCell(10).getNumericCellValue());
                pathomorphArterioles.setVolumeOfMicrocirculationOfArteriolesZ6((float) row.getCell(11).getNumericCellValue());

                pathomorphArterioles.setTotalVolumeOfMicrocirculationOfArterioles((float) row.getCell(12).getNumericCellValue());

                pathomorphArterioles.setAverageRadiusOfArteriolesZ1((float) row.getCell(13).getNumericCellValue());
                pathomorphArterioles.setAverageRadiusOfArteriolesZ2((float) row.getCell(14).getNumericCellValue());
                pathomorphArterioles.setAverageRadiusOfArteriolesZ3((float) row.getCell(15).getNumericCellValue());
                pathomorphArterioles.setAverageRadiusOfArteriolesZ4((float) row.getCell(16).getNumericCellValue());
                pathomorphArterioles.setAverageRadiusOfArteriolesZ5((float) row.getCell(17).getNumericCellValue());
                pathomorphArterioles.setAverageRadiusOfArteriolesZ6((float) row.getCell(18).getNumericCellValue());

                pathomorphArterioles.setChangeInTheLumenOfArteriolesZ1((float) row.getCell(19).getNumericCellValue());
                pathomorphArterioles.setChangeInTheLumenOfArteriolesZ2((float) row.getCell(20).getNumericCellValue());
                pathomorphArterioles.setChangeInTheLumenOfArteriolesZ3((float) row.getCell(21).getNumericCellValue());
                pathomorphArterioles.setChangeInTheLumenOfArteriolesZ4((float) row.getCell(22).getNumericCellValue());
                pathomorphArterioles.setChangeInTheLumenOfArteriolesZ5((float) row.getCell(23).getNumericCellValue());
                pathomorphArterioles.setChangeInTheLumenOfVenulesZ6((float) row.getCell(24).getNumericCellValue());

                pathomorphArterioles.setResistanceOfArteriolesZ1((float) row.getCell(25).getNumericCellValue());
                pathomorphArterioles.setResistanceOfArteriolesZ2((float) row.getCell(26).getNumericCellValue());
                pathomorphArterioles.setResistanceOfArteriolesZ3((float) row.getCell(27).getNumericCellValue());
                pathomorphArterioles.setResistanceOfArteriolesZ4((float) row.getCell(28).getNumericCellValue());
                pathomorphArterioles.setResistanceOfArteriolesZ5((float) row.getCell(29).getNumericCellValue());
                pathomorphArterioles.setResistanceOfArteriolesZ6((float) row.getCell(30).getNumericCellValue());

                pathomorphArteriolesList.add(pathomorphArterioles);
            }
        }

        return pathomorphArteriolesList;
    }


}
