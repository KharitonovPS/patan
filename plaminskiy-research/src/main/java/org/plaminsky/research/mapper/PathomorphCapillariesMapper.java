package org.plaminsky.research.mapper;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.research.entity.PathomorphСapillaries;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PathomorphCapillariesMapper {

    public List<PathomorphСapillaries> processPathomorphCapillaries(Sheet sheet) {
        List<PathomorphСapillaries> pathomorphCapillariesList = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                PathomorphСapillaries pathomorphCapillaries = new PathomorphСapillaries();

                pathomorphCapillaries.setCapillaryDensityInteralveolarSepataZ1((float) row.getCell(0).getNumericCellValue());
                pathomorphCapillaries.setCapillaryDensityInteralveolarSepataZ2((float) row.getCell(1).getNumericCellValue());
                pathomorphCapillaries.setCapillaryDensityInteralveolarSepataZ3((float) row.getCell(2).getNumericCellValue());
                pathomorphCapillaries.setCapillaryDensityInteralveolarSepataZ4((float) row.getCell(3).getNumericCellValue());
                pathomorphCapillaries.setCapillaryDensityInteralveolarSepataZ5((float) row.getCell(4).getNumericCellValue());
                pathomorphCapillaries.setCapillaryDensityInteralveolarSepataZ6((float) row.getCell(5).getNumericCellValue());

                pathomorphCapillaries.setVolumeMicrocirculationCapillariesZ1((float) row.getCell(6).getNumericCellValue());
                pathomorphCapillaries.setVolumeMicrocirculationCapillariesZ2((float) row.getCell(7).getNumericCellValue());
                pathomorphCapillaries.setVolumeMicrocirculationCapillariesZ3((float) row.getCell(8).getNumericCellValue());
                pathomorphCapillaries.setVolumeMicrocirculationCapillariesZ4((float) row.getCell(9).getNumericCellValue());
                pathomorphCapillaries.setVolumeMicrocirculationCapillariesZ5((float) row.getCell(10).getNumericCellValue());
                pathomorphCapillaries.setVolumeMicrocirculationCapillariesZ6((float) row.getCell(11).getNumericCellValue());

                pathomorphCapillaries.setTotalVolumeMicrocirculationCapillaries((float) row.getCell(12).getNumericCellValue());

                pathomorphCapillaries.setRadiusCapillariesZ1((float) row.getCell(13).getNumericCellValue());
                pathomorphCapillaries.setRadiusCapillariesZ2((float) row.getCell(14).getNumericCellValue());
                pathomorphCapillaries.setRadiusCapillariesZ3((float) row.getCell(15).getNumericCellValue());
                pathomorphCapillaries.setRadiusCapillariesZ4((float) row.getCell(16).getNumericCellValue());
                pathomorphCapillaries.setRadiusCapillariesZ5((float) row.getCell(17).getNumericCellValue());
                pathomorphCapillaries.setRadiusCapillariesZ6((float) row.getCell(18).getNumericCellValue());

                pathomorphCapillaries.setChangeInLumenVenulesZ1((float) row.getCell(19).getNumericCellValue());
                pathomorphCapillaries.setChangeInLumenCapillariesZ2((float) row.getCell(20).getNumericCellValue());
                pathomorphCapillaries.setChangeInLumenCapillariesZ3((float) row.getCell(21).getNumericCellValue());
                pathomorphCapillaries.setChangeInLumenCapillariesZ4((float) row.getCell(22).getNumericCellValue());
                pathomorphCapillaries.setChangeInLumenCapillariesZ5((float) row.getCell(23).getNumericCellValue());
                pathomorphCapillaries.setChangeInLumenCapillariesZ6((float) row.getCell(24).getNumericCellValue());

                pathomorphCapillaries.setResistanceCapillariesZ1((float) row.getCell(25).getNumericCellValue());
                pathomorphCapillaries.setResistanceCapillariesZ2((float) row.getCell(26).getNumericCellValue());
                pathomorphCapillaries.setResistanceCapillariesZ3((float) row.getCell(27).getNumericCellValue());
                pathomorphCapillaries.setResistanceCapillariesZ4((float) row.getCell(28).getNumericCellValue());
                pathomorphCapillaries.setResistanceCapillariesZ5((float) row.getCell(29).getNumericCellValue());
                pathomorphCapillaries.setResistanceCapillariesZ6((float) row.getCell(30).getNumericCellValue());

                pathomorphCapillariesList.add(pathomorphCapillaries);
            }
        }
        return pathomorphCapillariesList;

    }

}
