package org.plaminsky.patan.mapper;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.patan.entity.Brain;
import org.plaminsky.patan.repository.SepsisRepository;
import org.plaminsky.patan.repository.SepsisTypeRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static util.CellExtractor.extractFloatFromCell;
import static util.CellExtractor.extractIntegerFromCell;

@Component
@RequiredArgsConstructor
public class BrainMapper {

    private final SepsisRepository sepsisRepository;
    private final SepsisTypeRepository sepsisTypeRepository;

    public List<Brain> toBrain(Sheet sheet) {
        List<Brain> brains = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                var brain = new Brain();

                if (row.getCell(1) != null) {
                    brain.setSepsis(
                            sepsisRepository.findByAutopsyId(
                                    row.getCell(1).getStringCellValue()
                            ).orElseThrow(
                            () -> new IllegalArgumentException("Sepsis not found row:%s sheet:%s".formatted(
                                    row.getRowNum(),
                                    sheet.getSheetName())
                            )
                    )
                    );
                }

                if (row.getCell(1) != null) {
                    brain.setSepsisType(
                            sepsisTypeRepository.findById(
                                    (long)  row.getCell(2).getNumericCellValue()
                            ).orElseThrow(
                                    () -> new IllegalArgumentException("Sepsis not found row:%s sheet:%s".formatted(
                                            row.getRowNum(),
                                            sheet.getSheetName())
                                    )
                            )
                    );
                }

                brain.setCongestionVessels(extractFloatFromCell(row.getCell(3)));
                brain.setFibrinClotsInVessels(extractIntegerFromCell(row.getCell(4)));
                brain.setRedCellSludgeInVessels(extractIntegerFromCell(row.getCell(5)));
                brain.setErythrocyticThrombiInVessels(extractIntegerFromCell(row.getCell(6)));
                brain.setUnaffectedEndotheliumVessels(extractIntegerFromCell(row.getCell(7)));
                brain.setEndothelialSheddingVessels(extractIntegerFromCell(row.getCell(8)));
                brain.setEndothelialEdemaVessels(extractIntegerFromCell(row.getCell(9)));
                brain.setLeukostasisInVessels(extractIntegerFromCell(row.getCell(10)));
                brain.setMarginalLeukocyteStasisInVessels(extractIntegerFromCell(row.getCell(11)));
                brain.setPerivascularInfiltrationVessels(extractIntegerFromCell(row.getCell(12)));
                brain.setDiapedesisHemorrhageInVessels(extractIntegerFromCell(row.getCell(13)));
                brain.setMicrobesInVessels(extractIntegerFromCell(row.getCell(14)));
                brain.setWallThicknessOfVessels(extractFloatFromCell(row.getCell(15)));
                brain.setLumenDiameterOfVessels(extractFloatFromCell(row.getCell(16)));
                brain.setKernoghanIndexOfVessels(extractFloatFromCell(row.getCell(17)));
                brain.setCapillaryVolumeFraction(extractFloatFromCell(row.getCell(18)));
                brain.setWallThicknessOfArterioles(extractFloatFromCell(row.getCell(19)));
                brain.setLumenDiameterOfArterioles(extractFloatFromCell(row.getCell(20)));
                brain.setWallThicknessOfVenules(extractFloatFromCell(row.getCell(21)));
                brain.setLumenDiameterOfVenules(extractFloatFromCell(row.getCell(22)));
                brain.setKernoghanIndexOfArterioles(extractFloatFromCell(row.getCell(23)));
                brain.setKernoghanIndexOfVenules(extractFloatFromCell(row.getCell(24)));
                brain.setLeukocyteInfiltration(extractIntegerFromCell(row.getCell(25)));
                brain.setLeukocyteInfiltrationOfSheaths(extractIntegerFromCell(row.getCell(26)));
                brain.setEdemaOfSheathsTrabeculae(extractIntegerFromCell(row.getCell(27)));
                brain.setShadowCells(extractFloatFromCell(row.getCell(28)));
                brain.setHyperchromatosis(extractFloatFromCell(row.getCell(29)));
                brain.setPerinuclearSpaces(extractFloatFromCell(row.getCell(30)));
                brain.setSatelliteCells(extractFloatFromCell(row.getCell(31)));
                brain.setDrainageFormsOfOligodendrogliacytes(extractFloatFromCell(row.getCell(32)));
                brain.setCellSum(extractFloatFromCell(row.getCell(33)));
                brain.setGlialReactivity(extractIntegerFromCell(row.getCell(34)));
                brain.setMacroAbscesses(extractIntegerFromCell(row.getCell(35)));
                brain.setMicroabscesses(extractIntegerFromCell(row.getCell(36)));
                brain.setPerivascularEdema(extractIntegerFromCell(row.getCell(37)));
                brain.setPericellularEdema(extractIntegerFromCell(row.getCell(38)));
                brain.setUnaffectedCells(extractFloatFromCell(row.getCell(39)));
                brain.setChangedCells(extractFloatFromCell(row.getCell(40)));
                brain.setPericellularEdemaPercentage(extractFloatFromCell(row.getCell(41)));

                brains.add(brain);
            }
        }

        return brains;
    }

}
