package org.plaminsky.patan.mapper;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.patan.entity.Liver;
import org.plaminsky.patan.repository.SepsisRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static util.CellExtractor.extractFloatFromCell;
import static util.CellExtractor.extractIntegerFromCell;

@Component
@RequiredArgsConstructor
public class LiverMapper {

    private final SepsisRepository sepsisRepository;

    public List<Liver> toLivers(Sheet sheet) {
        List<Liver> liverList = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                var liver = new Liver();

                liver.setId((long) row.getCell(0).getNumericCellValue());
                if (row.getCell(1) != null) {
                    liver.setSepsis(
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
                liver.setCongestionArterioles(extractFloatFromCell(row.getCell(3)));
                liver.setCongestionCentralVeins(extractFloatFromCell(row.getCell(4)));
                liver.setCongestionPortalTractVeins(extractFloatFromCell(row.getCell(5)));
                liver.setCongestionSinusoidalZone3(extractIntegerFromCell(row.getCell(6)));
                liver.setCongestionSinusoidalZone1(extractIntegerFromCell(row.getCell(7)));
                liver.setFibrinClottingArterioles(extractFloatFromCell(row.getCell(8)));
                liver.setFibrinClottingCentralVeins(extractFloatFromCell(row.getCell(9)));
                liver.setFibrinClottingPortalTractVeins(extractFloatFromCell(row.getCell(10)));
                liver.setFibrinClottingSinusoidalZones3(extractIntegerFromCell(row.getCell(11)));
                liver.setFibrinClottingSinusoidalZones1(extractIntegerFromCell(row.getCell(12)));
                liver.setSludgeErArterioles(extractIntegerFromCell(row.getCell(13)));
                liver.setSludgeErCentralVeins(extractFloatFromCell(row.getCell(14)));
                liver.setSludgeErPortalTractVeins(extractFloatFromCell(row.getCell(15)));
                liver.setSludgeErSinusoidalZones3(extractIntegerFromCell(row.getCell(16)));
                liver.setSludgeErSinusoidalZones1(extractFloatFromCell(row.getCell(17)));
                liver.setErythrocyteAgreggatesArterioles(extractFloatFromCell(row.getCell(18)));
                liver.setErythrocyteAgreggatesCentralVeins(extractFloatFromCell(row.getCell(19)));
                liver.setErythrocyteAgreggatesPortalTractVeins(extractFloatFromCell(row.getCell(20)));
                liver.setErythrocyteAgreggatesSinusoidalZones3(extractIntegerFromCell(row.getCell(21)));
                liver.setErythrocyteAgreggatesSinusoidalZones1(extractIntegerFromCell(row.getCell(22)));
                liver.setEndothelialSheddingArterioles(extractFloatFromCell(row.getCell(23)));
                liver.setEndothelialSheddingCentralVeins(extractIntegerFromCell(row.getCell(24)));
                liver.setEndothelialSheddingPortalTractVeins(extractFloatFromCell(row.getCell(25)));
                liver.setEndothelialSwellingArterioles(extractIntegerFromCell(row.getCell(26)));
                liver.setEndothelialSwellingCentralVeins(extractFloatFromCell(row.getCell(27)));
                liver.setEndothelialSwellingPortalTractVeins(extractIntegerFromCell(row.getCell(28)));
                liver.setEndothelialSwellingSinusoids(extractIntegerFromCell(row.getCell(29)));
                liver.setLeukostasisArterioles(extractIntegerFromCell(row.getCell(30)));
                liver.setLeukostasisCentralVeins(extractFloatFromCell(row.getCell(31)));
                liver.setLeukostasisPortalTractVeins(extractFloatFromCell(row.getCell(32)));
                liver.setLeukostasisSinusoidalZones3(extractIntegerFromCell(row.getCell(33)));
                liver.setLeukostasisSinusoidalZones1(extractIntegerFromCell(row.getCell(34)));
                liver.setBoundaryStandingArterioles(extractIntegerFromCell(row.getCell(35)));
                liver.setBoundaryStandingCentralVeins(extractIntegerFromCell(row.getCell(36)));
                liver.setBoundaryStandingPortalTractVeins(extractIntegerFromCell(row.getCell(37)));
                liver.setBoundaryStandingSinusoidalZones3(extractIntegerFromCell(row.getCell(38)));
                liver.setBoundaryStandingZone1(extractIntegerFromCell(row.getCell(39)));
                liver.setHemorrhagesPortalTracts(extractIntegerFromCell(row.getCell(40)));
                liver.setBacteriaArterioles(extractIntegerFromCell(row.getCell(41)));
                liver.setBacteriaCentralVeins(extractFloatFromCell(row.getCell(42)));
                liver.setBacteriaPortalTractVeins(extractIntegerFromCell(row.getCell(43)));
                liver.setBacteriaSinusoids(extractIntegerFromCell(row.getCell(44)));
                liver.setDiameterCentralVeins(extractFloatFromCell(row.getCell(45)));
                liver.setDiameterPortalTractVeins(extractFloatFromCell(row.getCell(46)));
                liver.setKernohanIndexArterioles(extractFloatFromCell(row.getCell(47)));
                liver.setNeutrophilCountInFieldOfVision40x(extractFloatFromCell(row.getCell(48)));
                liver.setApoptoticBodyCountInFieldOfVision40x(extractFloatFromCell(row.getCell(49)));
                liver.setNeutrophilsPortalTracts(extractIntegerFromCell(row.getCell(50)));
                liver.setCholestasis(extractIntegerFromCell(row.getCell(51)));
                liver.setCentroLobularNecrosis(extractIntegerFromCell(row.getCell(52)));
                liver.setIntralobularNecrosis(extractIntegerFromCell(row.getCell(53)));
                liver.setSubtotalNecrosis(extractIntegerFromCell(row.getCell(54)));
                liver.setNecrosis(extractIntegerFromCell(row.getCell(55)));

                liverList.add(liver);
            }
        }
        return liverList;
    }
    
}