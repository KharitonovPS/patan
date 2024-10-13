package org.plaminsky.research.mapper;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.research.entity.AreaLesion;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AreaLesionMapper {

    public List<AreaLesion> toAreaLesions(Sheet sheet) {
        List<AreaLesion> areaLesions = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                float areaLesionZ1 = (float) row.getCell(0).getNumericCellValue();
                float areaLesionZ2 = (float) row.getCell(1).getNumericCellValue();
                float areaLesionZ3 = (float) row.getCell(2).getNumericCellValue();
                float areaLesionZ4 = (float) row.getCell(3).getNumericCellValue();
                float areaLesionZ5 = (float) row.getCell(4).getNumericCellValue();
                float areaLesionZ6 = (float) row.getCell(5).getNumericCellValue();

                AreaLesion areaLesion = new AreaLesion();
                areaLesion.setAreaLesionZ1(areaLesionZ1);
                areaLesion.setAreaLesionZ2(areaLesionZ2);
                areaLesion.setAreaLesionZ3(areaLesionZ3);
                areaLesion.setAreaLesionZ4(areaLesionZ4);
                areaLesion.setAreaLesionZ5(areaLesionZ5);
                areaLesion.setAreaLesionZ6(areaLesionZ6);

                areaLesions.add(areaLesion);
            }
        }

        return areaLesions;
    }

}
