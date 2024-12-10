package org.plaminsky.patan.mapper;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.patan.entity.Heart;
import org.plaminsky.patan.repository.SepsisRepository;
import org.plaminsky.patan.repository.SepsisTypeRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static util.CellExtractor.extractFloatFromCell;
import static util.CellExtractor.extractIntegerFromCell;

@Component
@RequiredArgsConstructor
public class HeartMapper {

    private final SepsisRepository sepsisRepository;
    private final SepsisTypeRepository sepsisTypeRepository;

    public List<Heart> toHeart(Sheet sheet) {
        List<Heart> heartList = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                var heart = new Heart();

                if (row.getCell(1) != null) {
                    heart.setSepsis(
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
                    heart.setSepsisType(
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
                heart.setFibrinMicrothrombi(extractIntegerFromCell(row.getCell(3)));
                heart.setSpasms(extractIntegerFromCell(row.getCell(4)));
                heart.setVacuolarDegeneration(extractIntegerFromCell(row.getCell(5)));
                heart.setWavyDeformationOfCardiomyocytes(extractIntegerFromCell(row.getCell(6)));
                heart.setFragmentationOfCardiomyocytes(extractIntegerFromCell(row.getCell(7)));
                heart.setOverstretchingOfCardiomyocytes(extractIntegerFromCell(row.getCell(8)));
                heart.setNonreactiveNecrosis(extractIntegerFromCell(row.getCell(9)));
                heart.setNecrosisWithInflammatoryReaction(extractIntegerFromCell(row.getCell(10)));

                heart.setKernoghanIndexArterioles(extractFloatFromCell(row.getCell(11)));
                heart.setCongestionInArterioles(extractIntegerFromCell(row.getCell(12)));
                heart.setCongestionInVenules(extractIntegerFromCell(row.getCell(13)));
                heart.setCongestionInCapillaries(extractIntegerFromCell(row.getCell(14)));

                heart.setFibrinClotsInArterioles(extractIntegerFromCell(row.getCell(15)));
                heart.setFibrinClotsInVenules(extractIntegerFromCell(row.getCell(16)));
                heart.setFibrinClotsInCapillaries(extractIntegerFromCell(row.getCell(17)));

                heart.setRedCellSludgeInArterioles(extractIntegerFromCell(row.getCell(18)));
                heart.setRedCellSludgeInVenules(extractIntegerFromCell(row.getCell(19)));
                heart.setRedCellSludgeInCapillaries(extractIntegerFromCell(row.getCell(20)));

                heart.setErythrocyticThrombiInArterioles(extractIntegerFromCell(row.getCell(21)));
                heart.setErythrocyticThrombiInVenules(extractIntegerFromCell(row.getCell(22)));
                heart.setErythrocyticThrombiInCapillaries(extractIntegerFromCell(row.getCell(23)));

                heart.setUnaffectedEndotheliumInArterioles(extractIntegerFromCell(row.getCell(24)));
                heart.setUnaffectedEndotheliumInVenules(extractIntegerFromCell(row.getCell(25)));
                heart.setUnaffectedEndotheliumInCapillaries(extractIntegerFromCell(row.getCell(26)));

                heart.setEndothelialSheddingInArterioles(extractIntegerFromCell(row.getCell(27)));
                heart.setEndothelialSheddingInVenules(extractIntegerFromCell(row.getCell(28)));
                heart.setEndothelialSheddingInCapillaries(extractIntegerFromCell(row.getCell(29)));

                heart.setEdemaOfEndotheliumInArterioles(extractIntegerFromCell(row.getCell(30)));
                heart.setEdemaOfEndotheliumInVenules(extractIntegerFromCell(row.getCell(31)));
                heart.setEdemaOfEndotheliumInCapillaries(extractIntegerFromCell(row.getCell(32)));

                heart.setLeukostasisInArterioles(extractIntegerFromCell(row.getCell(33)));
                heart.setLeukostasisInVenules(extractIntegerFromCell(row.getCell(34)));
                heart.setLeukostasisInCapillaries(extractIntegerFromCell(row.getCell(35)));

                heart.setMarginalLeukocyteStasisInArterioles(extractIntegerFromCell(row.getCell(36)));
                heart.setMarginalLeukocyteStasisInVenules(extractIntegerFromCell(row.getCell(37)));

                heart.setPerivascularInfiltrationInArterioles(extractIntegerFromCell(row.getCell(38)));
                heart.setPerivascularInfiltrationInVenules(extractIntegerFromCell(row.getCell(39)));
                heart.setPerivascularInfiltrationInCapillaries(extractIntegerFromCell(row.getCell(40)));

                heart.setDiapedesisHemorrhageInArterioles(extractIntegerFromCell(row.getCell(41)));
                heart.setDiapedesisHemorrhageInVenules(extractIntegerFromCell(row.getCell(42)));
                heart.setDiapedesisHemorrhageInCapillaries(extractIntegerFromCell(row.getCell(43)));

                heart.setMicrobesInArterioles(extractIntegerFromCell(row.getCell(44)));
                heart.setMicrobesInVenules(extractIntegerFromCell(row.getCell(45)));
                heart.setMicrobesInCapillaries(extractIntegerFromCell(row.getCell(46)));

                heart.setMacroAbscesses(extractIntegerFromCell(row.getCell(47)));
                heart.setMicroabscesses(extractIntegerFromCell(row.getCell(48)));
                heart.setMiniAbscesses(extractIntegerFromCell(row.getCell(49)));

                heartList.add(heart);
            }
        }
        return heartList;
    }
}