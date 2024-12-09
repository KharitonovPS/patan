package org.plaminsky.patan.mapper;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.patan.entity.Lungs;
import org.plaminsky.patan.repository.SepsisRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static util.CellExtractor.extractFloatFromCell;
import static util.CellExtractor.extractIntegerFromCell;

@Component
@RequiredArgsConstructor
public class LungsMapper {

    private final SepsisRepository sepsisRepository;

    public List<Lungs> toLungs(Sheet sheet) {
        List<Lungs> lungsList = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                var lungs = new Lungs();

                lungs.setId((long) row.getCell(0).getNumericCellValue());
                if (row.getCell(1) != null) {
                    lungs.setSepsis(
                            sepsisRepository.findByAutopsyIdAndSepsisType(
                                    row.getCell(1).getStringCellValue(),
                                    (long) row.getCell(2).getNumericCellValue()
                            ).orElseThrow(
                                    () -> new IllegalArgumentException("Sepsis not found row:%s sheet:%s".formatted(
                                            row.getRowNum(),
                                            sheet.getSheetName())
                                    )
                            )
                    );
                }
                lungs.setCongestionArterioles(extractIntegerFromCell(row.getCell(3)));
                lungs.setCongestionVenules(extractIntegerFromCell(row.getCell(4)));
                lungs.setCongestionCapillaries(extractIntegerFromCell(row.getCell(5)));

                lungs.setFibrinClotsArterioles(extractIntegerFromCell(row.getCell(6)));
                lungs.setFibrinClotsVenules(extractIntegerFromCell(row.getCell(7)));
                lungs.setFibrinClotsCapillaries(extractIntegerFromCell(row.getCell(8)));

                lungs.setRedCellSludgeArterioles(extractIntegerFromCell(row.getCell(9)));
                lungs.setRedCellSludgeVenules(extractIntegerFromCell(row.getCell(10)));
                lungs.setRedCellSludgeCapillaries(extractIntegerFromCell(row.getCell(11)));

                lungs.setErythrocyticThrombiArterioles(extractIntegerFromCell(row.getCell(12)));
                lungs.setErythrocyticThrombiVenules(extractIntegerFromCell(row.getCell(13)));
                lungs.setErythrocyticThrombiCapillaries(extractIntegerFromCell(row.getCell(14)));

                lungs.setUnaffectedEndotheliumArterioles(extractIntegerFromCell(row.getCell(15)));
                lungs.setUnaffectedEndotheliumVenules(extractIntegerFromCell(row.getCell(16)));
                lungs.setUnaffectedEndotheliumCapillaries(extractIntegerFromCell(row.getCell(17)));

                lungs.setEndothelialSheddingArterioles(extractIntegerFromCell(row.getCell(18)));
                lungs.setEndothelialSheddingVenules(extractIntegerFromCell(row.getCell(19)));
                lungs.setEndothelialSheddingCapillaries(extractIntegerFromCell(row.getCell(20)));

                lungs.setEndothelialEdemaArterioles(extractIntegerFromCell(row.getCell(21)));
                lungs.setEndothelialEdemaVenules(extractIntegerFromCell(row.getCell(22)));
                lungs.setEndothelialEdemaCapillaries(extractIntegerFromCell(row.getCell(23)));

                lungs.setLeukostasisArterioles(extractIntegerFromCell(row.getCell(24)));
                lungs.setLeukostasisVenules(extractIntegerFromCell(row.getCell(25)));
                lungs.setLeukostasisCapillaries(extractIntegerFromCell(row.getCell(26)));

                lungs.setMarginalLeukocyteStasisArterioles(extractIntegerFromCell(row.getCell(27)));
                lungs.setMarginalLeukocyteStasisVenules(extractIntegerFromCell(row.getCell(28)));

                lungs.setPerivascularInfiltrationArterioles(extractIntegerFromCell(row.getCell(29)));
                lungs.setPerivascularInfiltrationVenules(extractIntegerFromCell(row.getCell(30)));
                lungs.setPerivascularInfiltrationCapillaries(extractIntegerFromCell(row.getCell(31)));

                lungs.setDiapedesisHemorrhageArterioles(extractIntegerFromCell(row.getCell(32)));
                lungs.setDiapedesisHemorrhageVenules(extractIntegerFromCell(row.getCell(33)));
                lungs.setDiapedesisHemorrhageCapillaries(extractIntegerFromCell(row.getCell(34)));

                lungs.setMicrobesInArterioles(extractIntegerFromCell(row.getCell(35)));
                lungs.setMicrobesInVenules(extractIntegerFromCell(row.getCell(36)));
                lungs.setMicrobesInCapillaries(extractIntegerFromCell(row.getCell(37)));

                lungs.setWallThicknessArterioles(extractFloatFromCell(row.getCell(38)));
                lungs.setLumenDiameterArterioles(extractFloatFromCell(row.getCell(39)));
                lungs.setWallThicknessVenules(extractFloatFromCell(row.getCell(40)));
                lungs.setLumenDiameterVenules(extractFloatFromCell(row.getCell(41)));

                lungs.setKernoghanIndexArterioles(extractFloatFromCell(row.getCell(42)));
                lungs.setKernoghanIndexVenules(extractFloatFromCell(row.getCell(43)));

                lungs.setCapillaryVolumeFraction(extractFloatFromCell(row.getCell(44)));

                lungs.setMacroAbscesses(extractIntegerFromCell(row.getCell(45)));
                lungs.setMicroabscesses(extractIntegerFromCell(row.getCell(46)));
                lungs.setMiniAbscesses(extractIntegerFromCell(row.getCell(47)));

                lungs.setLeukocyteInfiltrationInteralveolarSeptae(extractIntegerFromCell(row.getCell(48)));
                lungs.setInteralveolarEdema(extractIntegerFromCell(row.getCell(49)));
                lungs.setIntrapulmonaryEdema(extractIntegerFromCell(row.getCell(50)));

                lungs.setHyalineMembranes(extractIntegerFromCell(row.getCell(51)));
                lungs.setEmphysema(extractIntegerFromCell(row.getCell(52)));
                lungs.setAtelactasis(extractIntegerFromCell(row.getCell(53)));
                lungs.setFibrosis(extractIntegerFromCell(row.getCell(54)));
                lungs.setNecrosisOfAlveolocytes(extractIntegerFromCell(row.getCell(55)));

                lungsList.add(lungs);
            }
        }

        return lungsList;
    }

}
