package org.plaminsky.patan.mapper;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.patan.entity.Sepsis;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SepsisMapper {

    public List<Sepsis> toSepsis(Sheet sheet) {
        List<Sepsis> sepsisArrayList = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                var id = row.getCell(0).getStringCellValue();
                var autopsyId = row.getCell(1).getStringCellValue();
                var type = row.getCell(2).getNumericCellValue();

                Sepsis sepsis = new Sepsis();
                sepsis.setId(Long.valueOf(id));
                sepsis.setAutopsyId(autopsyId);
                sepsis.setSepsisTypeId((long) type);
                sepsisArrayList.add(sepsis);
            }
        }

        return sepsisArrayList;
    }
}
