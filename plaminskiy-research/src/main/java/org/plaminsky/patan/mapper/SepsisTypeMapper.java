package org.plaminsky.patan.mapper;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.patan.entity.SepsisType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SepsisTypeMapper {

    public List<SepsisType> toSepsisType(Sheet sheet) {
        List<SepsisType> sepsisTypes = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                var id = row.getCell(0).getNumericCellValue();
                var name = row.getCell(1).getStringCellValue();
                var description = row.getCell(2).getStringCellValue();

                var sepsis = new SepsisType();
                sepsis.setId((long) id);
                sepsis.setName(name);
                sepsis.setDescription(description);
                sepsisTypes.add(sepsis);
            }
        }

        return sepsisTypes;
    }
}
