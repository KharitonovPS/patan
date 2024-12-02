package org.plaminsky.patan.mapper;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.patan.entity.Heart;
import org.plaminsky.patan.repository.DeceasedRecordRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static util.CellExtractor.extractFloatFromCell;

@Component
@RequiredArgsConstructor
public class PathomorphArteriolesMapper {

    private final DeceasedRecordRepository deceasedRecordRepository;

    public List<Heart> toPathomorphArterioles(Sheet sheet) {
        List<Heart> heartList = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                Heart heart = new Heart();

                // Set deceased record
                if (row.getCell(1) != null) {
                    heart.setDeceasedRecord(
                            deceasedRecordRepository.findById(row.getCell(1).getStringCellValue()).orElseThrow()
                    );
                }

                // Set volume of microcirculation of arterioles
                heart.setVolumeOfMicrocirculationOfArteriolesZ1(extractFloatFromCell(row.getCell(8)));
                heart.setVolumeOfMicrocirculationOfArteriolesZ2(extractFloatFromCell(row.getCell(9)));
                heart.setVolumeOfMicrocirculationOfArteriolesZ3(extractFloatFromCell(row.getCell(10)));
                heart.setVolumeOfMicrocirculationOfArteriolesZ4(extractFloatFromCell(row.getCell(11)));
                heart.setVolumeOfMicrocirculationOfArteriolesZ5(extractFloatFromCell(row.getCell(12)));
                heart.setVolumeOfMicrocirculationOfArteriolesZ6(extractFloatFromCell(row.getCell(13)));

                // Set total volume of microcirculation of arterioles
                heart.setTotalVolumeOfMicrocirculationOfArterioles(extractFloatFromCell(row.getCell(14)));

                // Set average radius of arterioles
                heart.setAverageRadiusOfArteriolesZ1(extractFloatFromCell(row.getCell(15)));
                heart.setAverageRadiusOfArteriolesZ2(extractFloatFromCell(row.getCell(16)));
                heart.setAverageRadiusOfArteriolesZ3(extractFloatFromCell(row.getCell(17)));
                heart.setAverageRadiusOfArteriolesZ4(extractFloatFromCell(row.getCell(18)));
                heart.setAverageRadiusOfArteriolesZ5(extractFloatFromCell(row.getCell(19)));
                heart.setAverageRadiusOfArteriolesZ6(extractFloatFromCell(row.getCell(20)));

                // Set change in the lumen of arterioles
                heart.setChangeInTheLumenOfArteriolesZ1(extractFloatFromCell(row.getCell(21)));
                heart.setChangeInTheLumenOfArteriolesZ2(extractFloatFromCell(row.getCell(22)));
                heart.setChangeInTheLumenOfArteriolesZ3(extractFloatFromCell(row.getCell(23)));
                heart.setChangeInTheLumenOfArteriolesZ4(extractFloatFromCell(row.getCell(24)));
                heart.setChangeInTheLumenOfArteriolesZ5(extractFloatFromCell(row.getCell(25)));
                heart.setChangeInTheLumenOfVenulesZ6(extractFloatFromCell(row.getCell(26)));

                // Set resistance of arterioles
                heart.setResistanceOfArteriolesZ1(extractFloatFromCell(row.getCell(27)));
                heart.setResistanceOfArteriolesZ2(extractFloatFromCell(row.getCell(28)));
                heart.setResistanceOfArteriolesZ3(extractFloatFromCell(row.getCell(29)));
                heart.setResistanceOfArteriolesZ4(extractFloatFromCell(row.getCell(30)));
                heart.setResistanceOfArteriolesZ5(extractFloatFromCell(row.getCell(31)));
                heart.setResistanceOfArteriolesZ6(extractFloatFromCell(row.getCell(32)));

                heartList.add(heart);
            }
        }
        return heartList;
    }
}