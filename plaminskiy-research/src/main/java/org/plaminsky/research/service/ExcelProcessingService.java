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

    private static final String DECEASED_RECORD_SHEET = "deceased_record";
    private static final String LABORATORY_STUDY_SHEET = "laboratory_study";
    private static final String AREA_LESION_SHEET = "area_lesion";
    private static final String PATHOMORPH_CAPILLARIES_SHEET = "pathomorph_capillaries";
    private static final String PATHOMORPH_ARTERIOLES_SHEET = "pathomorph_arterioles";
    private static final String PATHOMORPH_VENULES_SHEET = "pathomorph_venules";

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
                    pathomorphVenulesrRepository.saveAll(pathomorphVenules);
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
        log.info("Processing {} sheet", DECEASED_RECORD_SHEET);
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
        log.info("Processing {} sheet", AREA_LESION_SHEET);
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

    public List<LaboratoryStudy> processLaboratoryStudy(Sheet sheet) {
        log.info("Processing {} sheet", LABORATORY_STUDY_SHEET);
        List<LaboratoryStudy> laboratoryStudies = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                LaboratoryStudy laboratoryStudy = new LaboratoryStudy();

                // Убедитесь, что каждая ячейка содержит корректный тип данных
                laboratoryStudy.setErythrocytes10e12PerL((float) row.getCell(0).getNumericCellValue());
                laboratoryStudy.setHemoglobinGPerL((float) row.getCell(1).getNumericCellValue());
                laboratoryStudy.setLeukocytes10e9PerL((float) row.getCell(2).getNumericCellValue());
                laboratoryStudy.setPlatelets10e9PerL((float) row.getCell(3).getNumericCellValue());
                laboratoryStudy.setCreatinineUmolPerL((float) row.getCell(4).getNumericCellValue());
                laboratoryStudy.setCReactiveProteinMgPerL((float) row.getCell(5).getNumericCellValue());
                laboratoryStudy.setProcalcitoninNgPerMl((float) row.getCell(6).getNumericCellValue());
                laboratoryStudy.setTroponinNgPerL((float) row.getCell(7).getNumericCellValue());
                laboratoryStudy.setFerritinUgPerL((float) row.getCell(8).getNumericCellValue());
                laboratoryStudy.setFibrinogenGPerL((float) row.getCell(9).getNumericCellValue());
                laboratoryStudy.setDDimerNgPerMl((float) row.getCell(10).getNumericCellValue());
                laboratoryStudy.setBilirubinUmolPerL((float) row.getCell(11).getNumericCellValue());

                laboratoryStudies.add(laboratoryStudy);
            }
        }

        return laboratoryStudies;
    }

    public List<PathomorphArterioles> processPathomorphArterioles(Sheet sheet) {
        log.info("Processing {} sheet", PATHOMORPH_ARTERIOLES_SHEET);
        List<PathomorphArterioles> pathomorphArteriolesList = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                PathomorphArterioles pathomorphArterioles = new PathomorphArterioles();

                // Присваиваем значения из ячеек
                pathomorphArterioles.setRadiusOfArteriolesZ1((float) row.getCell(0).getNumericCellValue());
                pathomorphArterioles.setRadiusOfArteriolesZ2((float) row.getCell(1).getNumericCellValue());
                pathomorphArterioles.setRadiusOfArteriolesZ3((float) row.getCell(2).getNumericCellValue());
                pathomorphArterioles.setRadiusOfArteriolesZ4((float) row.getCell(3).getNumericCellValue());
                pathomorphArterioles.setRadiusOfArteriolesZ5((float) row.getCell(4).getNumericCellValue());
                pathomorphArterioles.setRadiusOfArteriolesZ6((float) row.getCell(5).getNumericCellValue());

                pathomorphArterioles.setVolumeOfMicrocirculationOfArteriolesZ1((float) row.getCell(6).getNumericCellValue());
                pathomorphArterioles.setVolumeOfMicrocirculationOfArteriolesZ2((float) row.getCell(7).getNumericCellValue());
                pathomorphArterioles.setVolumeOfMicrocirculationOfArteriolesZ3((float) row.getCell(8).getNumericCellValue());
                pathomorphArterioles.setVolumeOfMicrocirculationOfArteriolesZ4((float) row.getCell(9).getNumericCellValue());
                pathomorphArterioles.setVolumeOfMicrocirculationOfArteriolesZ5((float) row.getCell(10).getNumericCellValue());
                pathomorphArterioles.setVolumeOfMicrocirculationOfArteriolesZ6((float) row.getCell(11).getNumericCellValue());

                pathomorphArterioles.setTotalVolumeOfMicrocirculationOfArterioles((float) row.getCell(12).getNumericCellValue());

                pathomorphArterioles.setAverageRadiusOfArteriolesZ1((float) row.getCell(13).getNumericCellValue());
                pathomorphArterioles.setAverageRadiusOfArteriolesZ2((float) row.getCell(14).getNumericCellValue());
                pathomorphArterioles.setAverageRadiusOfArteriolesZ3((float) row.getCell(15).getNumericCellValue());
                pathomorphArterioles.setAverageRadiusOfArteriolesZ4((float) row.getCell(16).getNumericCellValue());
                pathomorphArterioles.setAverageRadiusOfArteriolesZ5((float) row.getCell(17).getNumericCellValue());
                pathomorphArterioles.setAverageRadiusOfArteriolesZ6((float) row.getCell(18).getNumericCellValue());

                pathomorphArterioles.setChangeInTheLumenOfArteriolesZ1((float) row.getCell(19).getNumericCellValue());
                pathomorphArterioles.setChangeInTheLumenOfArteriolesZ2((float) row.getCell(20).getNumericCellValue());
                pathomorphArterioles.setChangeInTheLumenOfArteriolesZ3((float) row.getCell(21).getNumericCellValue());
                pathomorphArterioles.setChangeInTheLumenOfArteriolesZ4((float) row.getCell(22).getNumericCellValue());
                pathomorphArterioles.setChangeInTheLumenOfArteriolesZ5((float) row.getCell(23).getNumericCellValue());
                pathomorphArterioles.setChangeInTheLumenOfVenulesZ6((float) row.getCell(24).getNumericCellValue());

                pathomorphArterioles.setResistanceOfArteriolesZ1((float) row.getCell(25).getNumericCellValue());
                pathomorphArterioles.setResistanceOfArteriolesZ2((float) row.getCell(26).getNumericCellValue());
                pathomorphArterioles.setResistanceOfArteriolesZ3((float) row.getCell(27).getNumericCellValue());
                pathomorphArterioles.setResistanceOfArteriolesZ4((float) row.getCell(28).getNumericCellValue());
                pathomorphArterioles.setResistanceOfArteriolesZ5((float) row.getCell(29).getNumericCellValue());
                pathomorphArterioles.setResistanceOfArteriolesZ6((float) row.getCell(30).getNumericCellValue());

                pathomorphArteriolesList.add(pathomorphArterioles);
            }
        }

        return pathomorphArteriolesList;
    }

    private List<PathomorphСapillaries> processPathomorphCapillaries(Sheet sheet) {
        log.info("Processing {} sheet", PATHOMORPH_CAPILLARIES_SHEET);
        List<PathomorphСapillaries> pathomorphCapillariesList = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                PathomorphСapillaries pathomorphCapillaries = new PathomorphСapillaries();

                // Присваиваем значения из ячеек
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

    private List<PathomorphVenules> processPathomorphVenules(Sheet sheet) {
        log.info("Processing {} sheet", PATHOMORPH_VENULES_SHEET);
        List<PathomorphVenules> pathomorphVenulesList = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                PathomorphVenules pathomorphVenules = new PathomorphVenules();

                // Присваиваем значения из ячеек
                pathomorphVenules.setRadiusOfVenulesZ1((float) row.getCell(0).getNumericCellValue());
                pathomorphVenules.setRadiusOfVenulesZ2((float) row.getCell(1).getNumericCellValue());
                pathomorphVenules.setRadiusOfVenulesZ3((float) row.getCell(2).getNumericCellValue());
                pathomorphVenules.setRadiusOfVenulesZ4((float) row.getCell(3).getNumericCellValue());
                pathomorphVenules.setRadiusOfVenulesZ5((float) row.getCell(4).getNumericCellValue());
                pathomorphVenules.setRadiusOfVenulesZ6((float) row.getCell(5).getNumericCellValue());

                pathomorphVenules.setVolumeOfMicrocirculationOfVenulesZ1((float) row.getCell(6).getNumericCellValue());
                pathomorphVenules.setVolumeOfMicrocirculationOfVenulesZ2((float) row.getCell(7).getNumericCellValue());
                pathomorphVenules.setVolumeOfMicrocirculationOfVenulesZ3((float) row.getCell(8).getNumericCellValue());
                pathomorphVenules.setVolumeOfMicrocirculationOfVenulesZ4((float) row.getCell(9).getNumericCellValue());
                pathomorphVenules.setVolumeOfMicrocirculationOfVenulesZ5((float) row.getCell(10).getNumericCellValue());
                pathomorphVenules.setVolumeOfMicrocirculationOfVenulesZ6((float) row.getCell(11).getNumericCellValue());

                pathomorphVenules.setTotalVolumeOfMicrocirculationOfVenules((float) row.getCell(12).getNumericCellValue());

                pathomorphVenules.setAverageRadiusOfVenulesZ1((float) row.getCell(13).getNumericCellValue());
                pathomorphVenules.setAverageRadiusOfVenulesZ2((float) row.getCell(14).getNumericCellValue());
                pathomorphVenules.setAverageRadiusOfVenulesZ3((float) row.getCell(15).getNumericCellValue());
                pathomorphVenules.setAverageRadiusOfVenulesZ4((float) row.getCell(16).getNumericCellValue());
                pathomorphVenules.setAverageRadiusOfVenulesZ5((float) row.getCell(17).getNumericCellValue());
                pathomorphVenules.setAverageRadiusOfVenulesZ6((float) row.getCell(18).getNumericCellValue());

                pathomorphVenules.setChangeInTheLumenOfVenulesZ1((float) row.getCell(19).getNumericCellValue());
                pathomorphVenules.setChangeInTheLumenOfVenulesZ2((float) row.getCell(20).getNumericCellValue());
                pathomorphVenules.setChangeInTheLumenOfVenulesZ3((float) row.getCell(21).getNumericCellValue());
                pathomorphVenules.setChangeInTheLumenOfVenulesZ4((float) row.getCell(22).getNumericCellValue());
                pathomorphVenules.setChangeInTheLumenOfVenulesZ5((float) row.getCell(23).getNumericCellValue());
                pathomorphVenules.setChangeInTheLumenOfVenulesZ6((float) row.getCell(24).getNumericCellValue());

                pathomorphVenules.setResistanceOfVenulesZ1((float) row.getCell(25).getNumericCellValue());
                pathomorphVenules.setResistanceOfVenulesZ2((float) row.getCell(26).getNumericCellValue());
                pathomorphVenules.setResistanceOfVenulesZ3((float) row.getCell(27).getNumericCellValue());
                pathomorphVenules.setResistanceOfVenulesZ4((float) row.getCell(28).getNumericCellValue());
                pathomorphVenules.setResistanceOfVenulesZ5((float) row.getCell(29).getNumericCellValue());
                pathomorphVenules.setResistanceOfVenulesZ6((float) row.getCell(30).getNumericCellValue());

                pathomorphVenulesList.add(pathomorphVenules);
            }
        }

        return pathomorphVenulesList;
    }

}
