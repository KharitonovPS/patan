package org.plaminsky.research.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.plaminsky.research.entity.PathomorphVenules;
import org.plaminsky.research.entity.PathomorphСapillaries;
import org.plaminsky.research.repository.AreaLesionRepository;
import org.plaminsky.research.repository.DeceasedRecordRepository;
import org.plaminsky.research.repository.LaboratoryStudyRepository;
import org.plaminsky.research.repository.PathomorphArteriolesRepository;
import org.plaminsky.research.repository.PathomorphVenulesRepository;
import org.plaminsky.research.repository.PathomorphСapillariesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
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
    private final PathomorphVenulesRepository pathomorphVenulesRepository;
    private final PathomorphСapillariesRepository pathomorphСapillariesRepository;



    public ResponseEntity<String> uploadExcel(MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is empty");
        }
        try (InputStream inputStream = file.getInputStream()) {
            Workbook workbook = new XSSFWorkbook(inputStream);

            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                Sheet sheet = workbook.getSheetAt(i);
                String sheetName = sheet.getSheetName();
                log.info("Processing sheet: {}", sheetName);

                // TODO: переделать не цепь обязанностей и вынести маппинг в классы
                if (sheetName.equalsIgnoreCase(DECEASED_RECORD_SHEET)) {
                    var deceasedRecords = processDeceasedRecords(sheet);
                    deceasedRecordRepository.saveAll(deceasedRecords);
                } else if (sheetName.equalsIgnoreCase(AREA_LESION_SHEET)) {
                    var areaLesions = processAreaLesions(sheet);
                    areaLesionRepository.saveAll(areaLesions);
                } else if (sheetName.equalsIgnoreCase(LABORATORY_STUDY_SHEET)) {
                    var laboratoryStudies = processLaboratoryStudy(sheet);
                    laboratoryStudyRepository.saveAll(laboratoryStudies);
                } else if (sheetName.equalsIgnoreCase(PATHOMORPH_ARTERIOLES_SHEET)) {
                    var pathomorphArterioles = processPathomorphArterioles(sheet);
                    pathomorphArteriolesRepository.saveAll(pathomorphArterioles);
                } else if (sheetName.equalsIgnoreCase(PATHOMORPH_CAPILLARIES_SHEET)) {
                    var pathomorphСapillaries = processPathomorphCapillaries(sheet);
                    pathomorphСapillariesRepository.saveAll(pathomorphСapillaries);
                } else if (sheetName.equalsIgnoreCase(PATHOMORPH_VENULES_SHEET)) {
                    var pathomorphVenules = processPathomorphVenules(sheet);
                    pathomorphVenulesRepository.saveAll(pathomorphVenules);
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












}
