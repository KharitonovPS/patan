package org.plaminsky.research.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.plaminsky.research.entity.AreaLesion;
import org.plaminsky.research.entity.DeceasedRecord;
import org.plaminsky.research.entity.Gender;
import org.plaminsky.research.entity.LaboratoryStudy;
import org.plaminsky.research.entity.PathomorphArterioles;
import org.plaminsky.research.entity.PathomorphVenules;
import org.plaminsky.research.entity.PathomorphСapillaries;
import org.plaminsky.research.repository.AreaLesionRepository;
import org.plaminsky.research.repository.DeceasedRecordRepository;
import org.plaminsky.research.repository.LaboratoryStudyRepository;
import org.plaminsky.research.repository.PathomorphArteriolesRepository;
import org.plaminsky.research.repository.PathomorphVenulesrRepository;
import org.plaminsky.research.repository.PathomorphСapillariesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExcelProcessingService {

    private final AreaLesionRepository areaLesionRepository;
    private final DeceasedRecordRepository deceasedRecordRepository;
    private final LaboratoryStudyRepository laboratoryStudyRepository;
    private final PathomorphArteriolesRepository pathomorphArteriolesRepository;
    private final PathomorphVenulesrRepository pathomorphVenulesrRepository;
    private final PathomorphСapillariesRepository pathomorphСapillariesRepository;



    public ResponseEntity<String> uploadExcel(MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is empty");
        }
        try (InputStream inputStream = file.getInputStream()) {
            Workbook workbook = new XSSFWorkbook(inputStream);

            // Обработка всех листов в файле
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                Sheet sheet = workbook.getSheetAt(i);
                String sheetName = sheet.getSheetName();
                log.info("Processing sheet: {}", sheetName);

                // Пример обработки по названию листа
                if (sheetName.equalsIgnoreCase("DeceasedRecords")) {
                    processDeceasedRecords(sheet);
                } else if (sheetName.equalsIgnoreCase("AreaLesions")) {
                    processAreaLesions(sheet);
                } else {
                    log.warn("Unknown sheet name: {}", sheetName);
                }
            }

            return ResponseEntity.ok("File processed successfully");
        } catch (IOException e) {
            log.error("Error processing Excel file", e);
            return ResponseEntity.status(500).body("Failed to process Excel file");
        }
    }

    private List<DeceasedRecord> processDeceasedRecords(Sheet sheet) {
        log.info("Processing DeceasedRecords sheet");
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

    private List<AreaLesion> processAreaLesions(Sheet sheet) {
        log.info("Processing AreaLesions sheet");
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
