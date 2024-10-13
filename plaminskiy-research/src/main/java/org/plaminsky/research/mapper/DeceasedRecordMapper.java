package org.plaminsky.research.mapper;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.research.entity.DeceasedRecord;
import org.plaminsky.research.entity.Gender;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DeceasedRecordMapper {

    public List<DeceasedRecord> toDeceasedRecords(Sheet sheet) {
        List<DeceasedRecord> deceasedRecords = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                LocalDate dateOfDeath = LocalDate.parse(row.getCell(0).getStringCellValue());
                int age = (int) row.getCell(1).getNumericCellValue();
                String genderStr = row.getCell(2).getStringCellValue();
                Gender gender = Gender.valueOf(genderStr.toUpperCase());
                int bedDays = (int) row.getCell(3).getNumericCellValue();
                int phaseOfCovid19 = (int) row.getCell(4).getNumericCellValue();

                DeceasedRecord deceasedRecord = new DeceasedRecord();
                deceasedRecord.setDateOfDeath(dateOfDeath);
                deceasedRecord.setAge(age);
                deceasedRecord.setGender(gender);
                deceasedRecord.setBedDays(bedDays);
                deceasedRecord.setPhaseOfCovid19(phaseOfCovid19);

                deceasedRecords.add(deceasedRecord);
            }
        }

        return deceasedRecords;
    }
}
