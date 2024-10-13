package org.plaminsky.research.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExcelProcessingService {

    private final DeceasedRecordSheetHandler deceasedRecordSheetHandler;

    public ResponseEntity<String> uploadExcel(MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is empty");
        }
        try (InputStream inputStream = file.getInputStream()) {
            var workbook = new XSSFWorkbook(inputStream);
            var sheets = new ArrayList<Sheet>();
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                sheets.add(workbook.getSheetAt(i));
            }
            for (Sheet sheet : sheets) {
                deceasedRecordSheetHandler.handle(sheet);
            }

            return ResponseEntity.ok("File processed successfully");
        } catch (IOException e) {
            log.error("Error processing Excel file", e);
            return ResponseEntity.status(500).body("Failed to process Excel file");
        }

    }

}
