package org.plaminsky.research.mapper;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.research.entity.DeceasedRecord;
import org.plaminsky.research.entity.Gender;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DeceasedRecordMapper {

    public List<DeceasedRecord> toDeceasedRecords(Sheet sheet) {
        List<DeceasedRecord> deceasedRecords = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                String id = row.getCell(0).getStringCellValue();
                Date date = row.getCell(1).getDateCellValue();
                LocalDate dateOfDeath = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int age = (int) row.getCell(2).getNumericCellValue();
                String genderStr = row.getCell(3).getStringCellValue();
                Gender gender;
                if (genderStr.equalsIgnoreCase("m")) {
                    gender = Gender.MALE;
                } else if (genderStr.equalsIgnoreCase("f")) {
                    gender = Gender.FEMALE;
                } else {
                    throw new IllegalArgumentException("Invalid gender: " + genderStr);
                }
                int dayOfIllness = (int) row.getCell(4).getNumericCellValue();
                int bedDays = (int) row.getCell(5).getNumericCellValue();
                int phaseOfCovid19 = (int) row.getCell(6).getNumericCellValue();

                DeceasedRecord deceasedRecord = new DeceasedRecord();
                deceasedRecord.setDateOfDeath(dateOfDeath);
                deceasedRecord.setAge(age);
                deceasedRecord.setGender(gender);
                deceasedRecord.setBedDays(bedDays);
                deceasedRecord.setPhaseOfCovid19(phaseOfCovid19);
                deceasedRecord.setId(id);
                deceasedRecord.setDaysOfIllness(dayOfIllness);

                deceasedRecords.add(deceasedRecord);
            }
        }

        return deceasedRecords;
    }
}
