package org.plaminsky.patan.mapper;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.patan.entity.Sepsis;
import org.plaminsky.patan.repository.SepsisTypeRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SepsisMapper {

    private final SepsisTypeRepository sepsisRepository;

    public List<Sepsis> toSepsis(Sheet sheet) {
        List<Sepsis> sepsisArrayList = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                var autopsyId = row.getCell(1).getStringCellValue();
                var type = row.getCell(2).getNumericCellValue();

                Sepsis sepsis = new Sepsis();
                sepsis.setAutopsyId(autopsyId);
                sepsis.setSepsisType(sepsisRepository.findById((long) type).orElseThrow(
                        () -> new IllegalArgumentException("Wrong type_id for sepsis_type, sheet:%s, rowNum:%s"
                                .formatted(sheet.getSheetName(), row.getRowNum()))
                ));
                sepsisArrayList.add(sepsis);
            }
        }

        return sepsisArrayList;
    }
}
