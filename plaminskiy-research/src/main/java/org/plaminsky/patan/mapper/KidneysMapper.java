package org.plaminsky.patan.mapper;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.patan.entity.Kidneys;
import org.plaminsky.patan.repository.SepsisRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static util.CellExtractor.extractFloatFromCell;
import static util.CellExtractor.extractIntegerFromCell;

@Component
@RequiredArgsConstructor
public class KidneysMapper {

    private final SepsisRepository sepsisRepository;


    public List<Kidneys> toKidneys(Sheet sheet) {
        List<Kidneys> kidneysList = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                var kidneys = new Kidneys();

                kidneys.setId((long) row.getCell(0).getNumericCellValue());
                if (row.getCell(1) != null) {
                    kidneys.setSepsis(
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
                kidneys.setInterstitialFibrosisOfCerebralSubstance(extractIntegerFromCell(row.getCell(3)));
                kidneys.setInterstitialFibrosisOfCortex(extractIntegerFromCell(row.getCell(4)));
                kidneys.setFractionOfLymphocyticInterstitialInflammationInCortex(extractIntegerFromCell(row.getCell(5)));
                kidneys.setFractionOfLymphocyticInterstitialInflammationInCerebralSubstance(extractIntegerFromCell(row.getCell(6)));
                kidneys.setAcutePurulentInflammationInCortex(extractIntegerFromCell(row.getCell(7)));
                kidneys.setAcutePurulentInflammationInCerebralSubstance(extractIntegerFromCell(row.getCell(8)));
                kidneys.setNeutrophilsInGlomerularCapillaries(extractIntegerFromCell(row.getCell(9)));
                kidneys.setNeutrophilsInPeritubularAndStraightCapillaries(extractIntegerFromCell(row.getCell(10)));
                kidneys.setMicrobialEmboliInPeritubularCapillaries(extractIntegerFromCell(row.getCell(11)));
                kidneys.setMicrobialEmboliInArterioles(extractIntegerFromCell(row.getCell(12)));
                kidneys.setMicrobialEmboliInLymphaticVessels(extractIntegerFromCell(row.getCell(13)));
                kidneys.setMicrobialEmboliInTubules(extractIntegerFromCell(row.getCell(14)));
                kidneys.setMicrobialEmboliInGlomerularVessels(extractIntegerFromCell(row.getCell(15)));
                kidneys.setFibrinoidNecrosisOfGlomerularVessels(extractIntegerFromCell(row.getCell(16)));
                kidneys.setChronicFibrosisOfGlomerulusVessels(extractIntegerFromCell(row.getCell(17)));
                kidneys.setNephroteliumKidneyDamage(extractIntegerFromCell(row.getCell(18)));
                kidneys.setHyperemiaOfCerebralSubstance(extractIntegerFromCell(row.getCell(19)));
                kidneys.setHyperemiaOfCortex(extractIntegerFromCell(row.getCell(20)));
                kidneys.setAreaOfHemorrhage(extractIntegerFromCell(row.getCell(21)));
                kidneys.setSheddingOfEndothelium(extractIntegerFromCell(row.getCell(22)));
                kidneys.setProximalTubuleNecrosisSeverity(extractIntegerFromCell(row.getCell(23)));
                kidneys.setDistalTubuleNecrosisSeverity(extractIntegerFromCell(row.getCell(24)));
                kidneys.setStraightTubulesDystrophySeverity(extractIntegerFromCell(row.getCell(25)));
                kidneys.setApoptosisOfTubules(extractIntegerFromCell(row.getCell(26)));
                kidneys.setSheddingOfEpitheliumOfTubules(extractIntegerFromCell(row.getCell(27)));
                kidneys.setNervesDystrophy(extractIntegerFromCell(row.getCell(28)));
                kidneys.setInterlobularArteryInternalDiameter(extractFloatFromCell(row.getCell(29)));
                kidneys.setInterlobularArteryWallThickness(extractFloatFromCell(row.getCell(30)));
                kidneys.setInterlobularArteryKernoghanIndex(extractFloatFromCell(row.getCell(31)));
                kidneys.setInterlobularArteryHyperemia(extractIntegerFromCell(row.getCell(32)));
                kidneys.setInterlobularArterySludges(extractIntegerFromCell(row.getCell(33)));
                kidneys.setInterlobularArteryFibrinous(extractIntegerFromCell(row.getCell(34)));
                kidneys.setInterlobularArteryErythrocyticThrombi(extractIntegerFromCell(row.getCell(35)));
                kidneys.setInterlobularArteryUnalteredEndothelium(extractIntegerFromCell(row.getCell(36)));
                kidneys.setInterlobularArterySheddingOfEndothelium(extractIntegerFromCell(row.getCell(37)));
                kidneys.setInterlobularArteryEdemaOfEndothelium(extractIntegerFromCell(row.getCell(38)));
                kidneys.setInterlobularArteryLeukostasis(extractIntegerFromCell(row.getCell(39)));
                kidneys.setInterlobularArteryMarginalStasisOfLeukocytes(extractIntegerFromCell(row.getCell(40)));
                kidneys.setInterlobularArteryPerivascularInfiltration(extractIntegerFromCell(row.getCell(41)));
                kidneys.setInterlobularArteryDiapedesisHemorrhages(extractIntegerFromCell(row.getCell(42)));
                kidneys.setInterlobularArteryMicrobes(extractIntegerFromCell(row.getCell(43)));

                kidneys.setInterlobularVeinDiameter(extractFloatFromCell(row.getCell(44)));
                kidneys.setInterlobularVeinWallThickness(extractFloatFromCell(row.getCell(45)));
                kidneys.setInterlobularVeinKernoghanIndex(extractFloatFromCell(row.getCell(46)));
                kidneys.setInterlobularVeinHyperemia(extractIntegerFromCell(row.getCell(47)));
                kidneys.setInterlobularVeinSludges(extractIntegerFromCell(row.getCell(48)));
                kidneys.setInterlobularVeinFibrinous(extractIntegerFromCell(row.getCell(49)));
                kidneys.setInterlobularVeinErythrocyticThrombi(extractIntegerFromCell(row.getCell(50)));
                kidneys.setInterlobularVeinUnalteredEndothelium(extractIntegerFromCell(row.getCell(51)));
                kidneys.setInterlobularVeinSheddingOfEndothelium(extractIntegerFromCell(row.getCell(52)));
                kidneys.setInterlobularVeinEdemaOfEndothelium(extractIntegerFromCell(row.getCell(53)));
                kidneys.setInterlobularVeinLeukostasis(extractIntegerFromCell(row.getCell(54)));
                kidneys.setInterlobularVeinMarginalStasisOfLeukocytes(extractIntegerFromCell(row.getCell(55)));
                kidneys.setInterlobularVeinPerivascularInfiltration(extractIntegerFromCell(row.getCell(56)));
                kidneys.setInterlobularVeinDiapedesisHemorrhages(extractIntegerFromCell(row.getCell(57)));
                kidneys.setInterlobularVeinMicrobes(extractIntegerFromCell(row.getCell(58)));
                kidneys.setCorticalGlomerulusCapillaryDiameter(extractFloatFromCell(row.getCell(58)));
                kidneys.setCorticalGlomerulusFibrinoidNecrosis(extractIntegerFromCell(row.getCell(59)));
                kidneys.setCorticalGlomerulusErythrocytesInLumen(extractIntegerFromCell(row.getCell(60)));
                kidneys.setCorticalGlomerulusSludges(extractIntegerFromCell(row.getCell(61)));
                kidneys.setCorticalGlomerulusThrombi(extractIntegerFromCell(row.getCell(62)));
                kidneys.setCorticalGlomerulusPodocytesShedding(extractIntegerFromCell(row.getCell(63)));
                kidneys.setCorticalGlomerulusNephroteliumParietalCapsuleShedding(extractIntegerFromCell(row.getCell(64)));
                kidneys.setCorticalGlomerulusEndothelialCellsShedding(extractIntegerFromCell(row.getCell(65)));
                kidneys.setCorticalGlomerulusBacteria(extractIntegerFromCell(row.getCell(66)));
                kidneys.setCorticalGlomerulusNeutrophils(extractIntegerFromCell(row.getCell(67)));

                kidneys.setCorticalGlomerulusArterioleDiameter(extractFloatFromCell(row.getCell(68)));
                kidneys.setCorticalGlomerulusArterioleWallThickness(extractFloatFromCell(row.getCell(69)));
                kidneys.setCorticalGlomerulusArterioleKernoghanIndex(extractFloatFromCell(row.getCell(70)));
                kidneys.setCorticalGlomerulusArterioleHyperemia(extractIntegerFromCell(row.getCell(71)));
                kidneys.setCorticalGlomerulusArterioleSludges(extractIntegerFromCell(row.getCell(72)));
                kidneys.setCorticalGlomerulusArterioleFibrinousThrombi(extractIntegerFromCell(row.getCell(73)));
                kidneys.setCorticalGlomerulusArterioleErythrocyticThrombi(extractIntegerFromCell(row.getCell(74)));
                kidneys.setCorticalGlomerulusArterioleUnalteredEndothelium(extractIntegerFromCell(row.getCell(75)));
                kidneys.setCorticalGlomerulusArterioleSheddingOfEndothelium(extractIntegerFromCell(row.getCell(76)));
                kidneys.setCorticalGlomerulusArterioleEdemaOfEndothelium(extractIntegerFromCell(row.getCell(77)));
                kidneys.setCorticalGlomerulusArterioleLeukostasis(extractIntegerFromCell(row.getCell(78)));
                kidneys.setCorticalGlomerulusArterioleMarginalStasisOfLeukocytes(extractIntegerFromCell(row.getCell(79)));
                kidneys.setCorticalGlomerulusArteriolePerivascularInfiltration(extractIntegerFromCell(row.getCell(80)));
                kidneys.setCorticalGlomerulusArterioleDiapedesisHemorrhages(extractIntegerFromCell(row.getCell(81)));
                kidneys.setCorticalGlomerulusArterioleMicrobes(extractIntegerFromCell(row.getCell(82)));
                kidneys.setCorticalZonePeritubularCapillaryWallThickness(extractIntegerFromCell(row.getCell(83)));
                kidneys.setCorticalZonePeritubularCapillaryKernoghanIndex(extractIntegerFromCell(row.getCell(84)));
                kidneys.setCorticalZonePeritubularCapillaryHyperemia(extractIntegerFromCell(row.getCell(85)));
                kidneys.setCorticalZonePeritubularCapillarySludges(extractIntegerFromCell(row.getCell(86)));
                kidneys.setCorticalZonePeritubularCapillaryFibrinousThrombi(extractIntegerFromCell(row.getCell(87)));
                kidneys.setCorticalZonePeritubularCapillaryErythrocyticThrombi(extractIntegerFromCell(row.getCell(88)));
                kidneys.setCorticalZonePeritubularCapillaryUnalteredEndothelium(extractIntegerFromCell(row.getCell(89)));
                kidneys.setCorticalZonePeritubularCapillarySheddingOfEndothelium(extractIntegerFromCell(row.getCell(90)));
                kidneys.setCorticalZonePeritubularCapillaryEdemaOfEndothelium(extractIntegerFromCell(row.getCell(91)));
                kidneys.setCorticalZonePeritubularCapillaryLeukostasis(extractFloatFromCell(row.getCell(92)));
                kidneys.setCorticalZonePeritubularCapillaryMarginalStasisOfLeukocytes(extractFloatFromCell(row.getCell(93)));
                kidneys.setCorticalZonePeritubularCapillaryPerivascularInfiltration(extractFloatFromCell(row.getCell(94)));
                kidneys.setCorticalZonePeritubularCapillaryDiapedesisHemorrhages(extractIntegerFromCell(row.getCell(95)));
                kidneys.setCorticalZonePeritubularCapillaryMicrobes(extractIntegerFromCell(row.getCell(96)));

                kidneys.setMedullaryGlomeruliCapillaryDiameter(extractIntegerFromCell(row.getCell(97)));
                kidneys.setMedullaryGlomeruliFibrinoidNecrosis(extractIntegerFromCell(row.getCell(98)));
                kidneys.setMedullaryGlomeruliErythrocytesInLumen(extractIntegerFromCell(row.getCell(99)));
                kidneys.setMedullaryGlomeruliSludges(extractIntegerFromCell(row.getCell(100)));
                kidneys.setMedullaryGlomeruliThrombi(extractIntegerFromCell(row.getCell(101)));
                kidneys.setMedullaryGlomeruliPodocytesShedding(extractIntegerFromCell(row.getCell(102)));
                kidneys.setMedullaryGlomeruliNephroteliumParietalCapsuleShedding(extractIntegerFromCell(row.getCell(103)));
                kidneys.setMedullaryGlomeruliSheddingOfEndothelium(extractIntegerFromCell(row.getCell(104)));
                kidneys.setMedullaryGlomeruliMicrobes(extractIntegerFromCell(row.getCell(105)));
                kidneys.setMedullaryGlomeruliNeutrophils(extractIntegerFromCell(row.getCell(106)));

                kidneys.setMedullaryGlomerulusArterioleDiameter(extractFloatFromCell(row.getCell(107)));
                kidneys.setMedullaryGlomerulusArterioleWallThickness(extractFloatFromCell(row.getCell(108)));
                kidneys.setMedullaryGlomerulusArterioleKernoghanIndex(extractFloatFromCell(row.getCell(109)));
                kidneys.setMedullaryGlomerulusArterioleHyperemia(extractIntegerFromCell(row.getCell(110)));
                kidneys.setMedullaryGlomerulusArterioleSludges(extractIntegerFromCell(row.getCell(111)));
                kidneys.setMedullaryGlomerulusArterioleFibrinousThrombi(extractIntegerFromCell(row.getCell(112)));
                kidneys.setMedullaryGlomerulusArterioleErythrocyticThrombi(extractIntegerFromCell(row.getCell(113)));
                kidneys.setMedullaryGlomerulusArterioleUnalteredEndothelium(extractIntegerFromCell(row.getCell(114)));
                kidneys.setMedullaryGlomerulusArterioleSheddingOfEndothelium(extractIntegerFromCell(row.getCell(115)));
                kidneys.setMedullaryGlomerulusArterioleEdemaOfEndothelium(extractIntegerFromCell(row.getCell(116)));
                kidneys.setMedullaryGlomerulusArterioleLeukostasis(extractIntegerFromCell(row.getCell(117)));
                kidneys.setMedullaryGlomerulusArterioleMarginalStasisOfLeukocytes(extractIntegerFromCell(row.getCell(118)));
                kidneys.setMedullaryGlomerulusArteriolePerivascularInfiltration(extractIntegerFromCell(row.getCell(119)));
                kidneys.setMedullaryGlomerulusArterioleDiapedesisHemorrhages(extractIntegerFromCell(row.getCell(120)));
                kidneys.setMedullaryGlomerulusArterioleMicrobes(extractIntegerFromCell(row.getCell(121)));

                kidneys.setMedullaryZonePeritubularCapillaryDiameter(extractFloatFromCell(row.getCell(122)));
                kidneys.setMedullaryZonePeritubularCapillaryWallThickness(extractFloatFromCell(row.getCell(123)));
                kidneys.setMedullaryZonePeritubularCapillaryKernoghanIndex(extractFloatFromCell(row.getCell(124)));
                kidneys.setMedullaryZonePeritubularCapillaryHyperemia(extractIntegerFromCell(row.getCell(125)));
                kidneys.setMedullaryZonePeritubularCapillarySludges(extractIntegerFromCell(row.getCell(126)));
                kidneys.setMedullaryZonePeritubularCapillaryFibrinousThrombi(extractIntegerFromCell(row.getCell(127)));
                kidneys.setMedullaryZonePeritubularCapillaryErythrocyticThrombi(extractIntegerFromCell(row.getCell(128)));
                kidneys.setMedullaryZonePeritubularCapillaryUnalteredEndothelium(extractIntegerFromCell(row.getCell(129)));
                kidneys.setMedullaryZonePeritubularCapillarySheddingOfEndothelium(extractIntegerFromCell(row.getCell(130)));
                kidneys.setMedullaryZonePeritubularCapillaryEdemaOfEndothelium(extractIntegerFromCell(row.getCell(131)));
                kidneys.setMedullaryZonePeritubularCapillaryLeukostasis(extractIntegerFromCell(row.getCell(132)));
                kidneys.setMedullaryZonePeritubularCapillaryMarginalStasisOfLeukocytes(extractIntegerFromCell(row.getCell(133)));
                kidneys.setMedullaryZonePeritubularCapillaryPerivascularInfiltration(extractIntegerFromCell(row.getCell(134)));
                kidneys.setMedullaryZonePeritubularCapillaryDiapedesisHemorrhages(extractIntegerFromCell(row.getCell(135)));
                kidneys.setMedullaryZonePeritubularCapillaryMicrobes(extractIntegerFromCell(row.getCell(136)));

                kidneys.setMedullaryZoneStraightVenulesAndCapillariesDiameter(extractFloatFromCell(row.getCell(137)));
                kidneys.setMedullaryZoneStraightVenulesAndCapillariesWallThickness(extractFloatFromCell(row.getCell(138)));
                kidneys.setMedullaryZoneStraightVenulesAndCapillariesKernoghanIndex(extractFloatFromCell(row.getCell(139)));
                kidneys.setMedullaryZoneStraightVenulesAndCapillariesHyperemia(extractIntegerFromCell(row.getCell(140)));
                kidneys.setMedullaryZoneStraightVenulesAndCapillariesSludges(extractIntegerFromCell(row.getCell(141)));
                kidneys.setMedullaryZoneStraightVenulesAndCapillariesFibrinousThrombi(extractIntegerFromCell(row.getCell(142)));
                kidneys.setMedullaryZoneStraightVenulesAndCapillariesErythrocyticThrombi(extractIntegerFromCell(row.getCell(143)));
                kidneys.setMedullaryZoneStraightVenulesAndCapillariesUnalteredEndothelium(extractIntegerFromCell(row.getCell(144)));
                kidneys.setMedullaryZoneStraightVenulesAndCapillariesSheddingOfEndothelium(extractIntegerFromCell(row.getCell(145)));
                kidneys.setMedullaryZoneStraightVenulesAndCapillariesEdemaOfEndothelium(extractIntegerFromCell(row.getCell(146)));
                kidneys.setMedullaryZoneStraightVenulesAndCapillariesLeukostasis(extractIntegerFromCell(row.getCell(147)));
                kidneys.setMedullaryZoneStraightVenulesAndCapillariesMarginalStasisOfLeukocytes(extractIntegerFromCell(row.getCell(148)));
                kidneys.setMedullaryZoneStraightVenulesAndCapillariesPerivascularInfiltration(extractIntegerFromCell(row.getCell(149)));
                kidneys.setMedullaryZoneStraightVenulesAndCapillariesDiapedesisHemorrhages(extractIntegerFromCell(row.getCell(150)));
                kidneys.setMedullaryZoneStraightVenulesAndCapillariesMicrobes(extractIntegerFromCell(row.getCell(151)));
                kidneys.setMedullaryZoneStraightVenulesAndCapillariesFibrosisOfPeritubularStroma(extractIntegerFromCell(row.getCell(152)));

                kidneysList.add(kidneys);
            }
        }
        return kidneysList;
    }


}
