package org.plaminsky.patan.mapper;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.patan.entity.Liver;
import org.plaminsky.patan.repository.DeceasedRecordRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static util.CellExtractor.extractFloatFromCell;

@Component
@RequiredArgsConstructor
public class PathomorphVenulesMapper {

    private final DeceasedRecordRepository deceasedRecordRepository;

    public List<Liver> toPathomorphVenules(Sheet sheet) {
        List<Liver> liverList = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                Liver liver = new Liver();

                if (row.getCell(1) != null) {
                    liver.setDeceasedRecord(
                            deceasedRecordRepository.findById(row.getCell(1).getStringCellValue()).orElseThrow()
                    );
                }

                liver.setRadiusOfVenulesZ1(extractFloatFromCell(row.getCell(2)));
                liver.setRadiusOfVenulesZ2(extractFloatFromCell(row.getCell(3)));
                liver.setRadiusOfVenulesZ3(extractFloatFromCell(row.getCell(4)));
                liver.setRadiusOfVenulesZ4(extractFloatFromCell(row.getCell(5)));
                liver.setRadiusOfVenulesZ5(extractFloatFromCell(row.getCell(6)));
                liver.setRadiusOfVenulesZ6(extractFloatFromCell(row.getCell(7)));

                liver.setVolumeOfMicrocirculationOfVenulesZ1(extractFloatFromCell(row.getCell(8)));
                liver.setVolumeOfMicrocirculationOfVenulesZ2(extractFloatFromCell(row.getCell(9)));
                liver.setVolumeOfMicrocirculationOfVenulesZ3(extractFloatFromCell(row.getCell(10)));
                liver.setVolumeOfMicrocirculationOfVenulesZ4(extractFloatFromCell(row.getCell(11)));
                liver.setVolumeOfMicrocirculationOfVenulesZ5(extractFloatFromCell(row.getCell(12)));
                liver.setVolumeOfMicrocirculationOfVenulesZ6(extractFloatFromCell(row.getCell(13)));

                liver.setTotalVolumeOfMicrocirculationOfVenules(extractFloatFromCell(row.getCell(14)));

                liver.setAverageRadiusOfVenulesZ1(extractFloatFromCell(row.getCell(15)));
                liver.setAverageRadiusOfVenulesZ2(extractFloatFromCell(row.getCell(16)));
                liver.setAverageRadiusOfVenulesZ3(extractFloatFromCell(row.getCell(17)));
                liver.setAverageRadiusOfVenulesZ4(extractFloatFromCell(row.getCell(18)));
                liver.setAverageRadiusOfVenulesZ5(extractFloatFromCell(row.getCell(19)));
                liver.setAverageRadiusOfVenulesZ6(extractFloatFromCell(row.getCell(20)));

                liver.setChangeInTheLumenOfVenulesZ1(extractFloatFromCell(row.getCell(21)));
                liver.setChangeInTheLumenOfVenulesZ2(extractFloatFromCell(row.getCell(22)));
                liver.setChangeInTheLumenOfVenulesZ3(extractFloatFromCell(row.getCell(23)));
                liver.setChangeInTheLumenOfVenulesZ4(extractFloatFromCell(row.getCell(24)));
                liver.setChangeInTheLumenOfVenulesZ5(extractFloatFromCell(row.getCell(25)));
                liver.setChangeInTheLumenOfVenulesZ6(extractFloatFromCell(row.getCell(26)));

                liver.setResistanceOfVenulesZ1(extractFloatFromCell(row.getCell(27)));
                liver.setResistanceOfVenulesZ2(extractFloatFromCell(row.getCell(28)));
                liver.setResistanceOfVenulesZ3(extractFloatFromCell(row.getCell(29)));
                liver.setResistanceOfVenulesZ4(extractFloatFromCell(row.getCell(30)));
                liver.setResistanceOfVenulesZ5(extractFloatFromCell(row.getCell(31)));
                liver.setResistanceOfVenulesZ6(extractFloatFromCell(row.getCell(32)));
                liverList.add(liver);
            }
        }
        return liverList;
    }
    
}