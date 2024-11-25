package org.plaminsky.research.mapper;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.research.entity.PathomorphСapillaries;
import org.plaminsky.research.repository.DeceasedRecordRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static util.CellExtractor.extractFloatFromCell;

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

                pathomorphCapillaries.setCapillaryDensityInteralveolarSepataZ1(
                        extractFloatFromCell(row.getCell(2))
                );
                pathomorphCapillaries.setCapillaryDensityInteralveolarSepataZ2(
                        extractFloatFromCell(row.getCell(3))
                );
                pathomorphCapillaries.setCapillaryDensityInteralveolarSepataZ3(
                        extractFloatFromCell(row.getCell(4))
                );
                pathomorphCapillaries.setCapillaryDensityInteralveolarSepataZ4(
                        extractFloatFromCell(row.getCell(5))
                );
                pathomorphCapillaries.setCapillaryDensityInteralveolarSepataZ5(
                        extractFloatFromCell(row.getCell(6))
                );
                pathomorphCapillaries.setCapillaryDensityInteralveolarSepataZ6(
                        extractFloatFromCell(row.getCell(7))
                );

                pathomorphCapillaries.setVolumeMicrocirculationCapillariesZ1(
                        extractFloatFromCell(row.getCell(8))
                );
                pathomorphCapillaries.setVolumeMicrocirculationCapillariesZ2(
                        extractFloatFromCell(row.getCell(9))
                );
                pathomorphCapillaries.setVolumeMicrocirculationCapillariesZ3(
                        extractFloatFromCell(row.getCell(10))
                );
                pathomorphCapillaries.setVolumeMicrocirculationCapillariesZ4(
                        extractFloatFromCell(row.getCell(11))
                );
                pathomorphCapillaries.setVolumeMicrocirculationCapillariesZ5(
                        extractFloatFromCell(row.getCell(12))
                );
                pathomorphCapillaries.setVolumeMicrocirculationCapillariesZ6(
                        extractFloatFromCell(row.getCell(13))
                );

                pathomorphCapillaries.setTotalVolumeMicrocirculationCapillaries(
                        extractFloatFromCell(row.getCell(14))
                );

                pathomorphCapillaries.setRadiusCapillariesZ1(
                        extractFloatFromCell(row.getCell(15))
                );
                pathomorphCapillaries.setRadiusCapillariesZ2(
                        extractFloatFromCell(row.getCell(16))
                );
                pathomorphCapillaries.setRadiusCapillariesZ3(
                        extractFloatFromCell(row.getCell(17))
                );
                pathomorphCapillaries.setRadiusCapillariesZ4(
                        extractFloatFromCell(row.getCell(18))
                );
                pathomorphCapillaries.setRadiusCapillariesZ5(
                        extractFloatFromCell(row.getCell(19))
                );
                pathomorphCapillaries.setRadiusCapillariesZ6(
                        extractFloatFromCell(row.getCell(20))
                );

                pathomorphCapillaries.setChangeInLumenVenulesZ1(
                        extractFloatFromCell(row.getCell(21))
                );
                pathomorphCapillaries.setChangeInLumenCapillariesZ2(
                        extractFloatFromCell(row.getCell(22))
                );
                pathomorphCapillaries.setChangeInLumenCapillariesZ3(
                        extractFloatFromCell(row.getCell(23))
                );
                pathomorphCapillaries.setChangeInLumenCapillariesZ4(
                        extractFloatFromCell(row.getCell(24))
                );
                pathomorphCapillaries.setChangeInLumenCapillariesZ5(
                        extractFloatFromCell(row.getCell(25))
                );
                pathomorphCapillaries.setChangeInLumenCapillariesZ6(
                        extractFloatFromCell(row.getCell(26))
                );

                pathomorphCapillaries.setResistanceCapillariesZ1(
                        extractFloatFromCell(row.getCell(27))
                );
                pathomorphCapillaries.setResistanceCapillariesZ2(
                        extractFloatFromCell(row.getCell(28))
                );
                pathomorphCapillaries.setResistanceCapillariesZ3(
                        extractFloatFromCell(row.getCell(29))
                );
                pathomorphCapillaries.setResistanceCapillariesZ4(
                        extractFloatFromCell(row.getCell(30))
                );
                pathomorphCapillaries.setResistanceCapillariesZ5(
                        extractFloatFromCell(row.getCell(31))
                );
                pathomorphCapillaries.setResistanceCapillariesZ6(
                        extractFloatFromCell(row.getCell(32))
                );


                pathomorphCapillariesList.add(pathomorphCapillaries);
            }
        }
        return pathomorphCapillariesList;
    }


}
