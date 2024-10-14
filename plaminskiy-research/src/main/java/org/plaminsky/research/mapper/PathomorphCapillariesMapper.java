package org.plaminsky.research.mapper;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.research.entity.DeceasedRecord;
import org.plaminsky.research.entity.PathomorphСapillaries;
import org.plaminsky.research.repository.DeceasedRecordRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PathomorphCapillariesMapper {

    private final DeceasedRecordRepository deceasedRecordRepository;


    public List<PathomorphСapillaries> processPathomorphCapillaries(Sheet sheet) {
        List<PathomorphСapillaries> pathomorphCapillariesList = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                PathomorphСapillaries pathomorphCapillaries = new PathomorphСapillaries();

                if (row.getCell(1) != null) {
                    pathomorphCapillaries.setDeceasedRecord(
                            deceasedRecordRepository.findById(row.getCell(1).getStringCellValue()).orElseThrow()
                    );
                }

                if (row.getCell(2) != null) {
                    pathomorphCapillaries.setCapillaryDensityInteralveolarSepataZ1((float) row.getCell(2).getNumericCellValue());
                }
                if (row.getCell(3) != null) {
                    pathomorphCapillaries.setCapillaryDensityInteralveolarSepataZ2((float) row.getCell(3).getNumericCellValue());
                }
                if (row.getCell(4) != null) {
                    pathomorphCapillaries.setCapillaryDensityInteralveolarSepataZ3((float) row.getCell(4).getNumericCellValue());
                }
                if (row.getCell(5) != null) {
                    pathomorphCapillaries.setCapillaryDensityInteralveolarSepataZ4((float) row.getCell(5).getNumericCellValue());
                }
                if (row.getCell(6) != null) {
                    pathomorphCapillaries.setCapillaryDensityInteralveolarSepataZ5((float) row.getCell(6).getNumericCellValue());
                }
                if (row.getCell(7) != null) {
                    pathomorphCapillaries.setCapillaryDensityInteralveolarSepataZ6((float) row.getCell(7).getNumericCellValue());
                }

                if (row.getCell(8) != null) {
                    pathomorphCapillaries.setVolumeMicrocirculationCapillariesZ1((float) row.getCell(8).getNumericCellValue());
                }
                if (row.getCell(9) != null) {
                    pathomorphCapillaries.setVolumeMicrocirculationCapillariesZ2((float) row.getCell(9).getNumericCellValue());
                }
                if (row.getCell(10) != null) {
                    pathomorphCapillaries.setVolumeMicrocirculationCapillariesZ3((float) row.getCell(10).getNumericCellValue());
                }
                if (row.getCell(11) != null) {
                    pathomorphCapillaries.setVolumeMicrocirculationCapillariesZ4((float) row.getCell(11).getNumericCellValue());
                }
                if (row.getCell(12) != null) {
                    pathomorphCapillaries.setVolumeMicrocirculationCapillariesZ5((float) row.getCell(12).getNumericCellValue());
                }
                if (row.getCell(13) != null) {
                    pathomorphCapillaries.setVolumeMicrocirculationCapillariesZ6((float) row.getCell(13).getNumericCellValue());
                }

                if (row.getCell(14) != null) {
                    pathomorphCapillaries.setTotalVolumeMicrocirculationCapillaries((float) row.getCell(14).getNumericCellValue());
                }

                if (row.getCell(15) != null) {
                    pathomorphCapillaries.setRadiusCapillariesZ1((float) row.getCell(15).getNumericCellValue());
                }
                if (row.getCell(16) != null) {
                    pathomorphCapillaries.setRadiusCapillariesZ2((float) row.getCell(16).getNumericCellValue());
                }
                if (row.getCell(17) != null) {
                    pathomorphCapillaries.setRadiusCapillariesZ3((float) row.getCell(17).getNumericCellValue());
                }
                if (row.getCell(18) != null) {
                    pathomorphCapillaries.setRadiusCapillariesZ4((float) row.getCell(18).getNumericCellValue());
                }
                if (row.getCell(19) != null) {
                    pathomorphCapillaries.setRadiusCapillariesZ5((float) row.getCell(19).getNumericCellValue());
                }
                if (row.getCell(20) != null) {
                    pathomorphCapillaries.setRadiusCapillariesZ6((float) row.getCell(20).getNumericCellValue());
                }

                if (row.getCell(21) != null) {
                    pathomorphCapillaries.setChangeInLumenVenulesZ1((float) row.getCell(21).getNumericCellValue());
                }
                if (row.getCell(22) != null) {
                    pathomorphCapillaries.setChangeInLumenCapillariesZ2((float) row.getCell(22).getNumericCellValue());
                }
                if (row.getCell(23) != null) {
                    pathomorphCapillaries.setChangeInLumenCapillariesZ3((float) row.getCell(23).getNumericCellValue());
                }
                if (row.getCell(24) != null) {
                    pathomorphCapillaries.setChangeInLumenCapillariesZ4((float) row.getCell(24).getNumericCellValue());
                }
                if (row.getCell(25) != null) {
                    pathomorphCapillaries.setChangeInLumenCapillariesZ5((float) row.getCell(25).getNumericCellValue());
                }
                if (row.getCell(26) != null) {
                    pathomorphCapillaries.setChangeInLumenCapillariesZ6((float) row.getCell(26).getNumericCellValue());
                }

                if (row.getCell(27) != null) {
                    pathomorphCapillaries.setResistanceCapillariesZ1((float) row.getCell(27).getNumericCellValue());
                }
                if (row.getCell(28) != null) {
                    pathomorphCapillaries.setResistanceCapillariesZ2((float) row.getCell(28).getNumericCellValue());
                }
                if (row.getCell(29) != null) {
                    pathomorphCapillaries.setResistanceCapillariesZ3((float) row.getCell(29).getNumericCellValue());
                }
                if (row.getCell(30) != null) {
                    pathomorphCapillaries.setResistanceCapillariesZ4((float) row.getCell(30).getNumericCellValue());
                }
                if (row.getCell(31) != null) {
                    pathomorphCapillaries.setResistanceCapillariesZ5((float) row.getCell(31).getNumericCellValue());
                }
                if (row.getCell(32) != null) {
                    pathomorphCapillaries.setResistanceCapillariesZ6((float) row.getCell(32).getNumericCellValue());
                }

                pathomorphCapillariesList.add(pathomorphCapillaries);
            }
        }
        return pathomorphCapillariesList;
    }


}
