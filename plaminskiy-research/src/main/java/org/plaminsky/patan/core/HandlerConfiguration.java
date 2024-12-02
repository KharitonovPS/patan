package org.plaminsky.patan.core;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.plaminsky.patan.service.AreaLessionSheetHandler;
import org.plaminsky.patan.service.DeceasedRecordSheetHandler;
import org.plaminsky.patan.service.LaboratoryStudySheetHandler;
import org.plaminsky.patan.service.PathomorphArteriolesSheetHandler;
import org.plaminsky.patan.service.PathomorphCapillariesSheetHandler;
import org.plaminsky.patan.service.PathomorphVenulesSheetHandler;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class HandlerConfiguration {

    private final AreaLessionSheetHandler areaLessionSheetHandler;
    private final DeceasedRecordSheetHandler deceasedRecordSheetHandler;
    private final LaboratoryStudySheetHandler laboratoryStudySheetHandler;
    private final PathomorphArteriolesSheetHandler pathomorphArteriolesSheetHandler;
    private final PathomorphCapillariesSheetHandler pathomorphCapillariesSheetHandler;
    private final PathomorphVenulesSheetHandler pathomorphVenulesSheetHandler;

    @PostConstruct
    private void init() {
        deceasedRecordSheetHandler.setNext(areaLessionSheetHandler);
        areaLessionSheetHandler.setNext(laboratoryStudySheetHandler);
        laboratoryStudySheetHandler.setNext(pathomorphArteriolesSheetHandler);
        pathomorphArteriolesSheetHandler.setNext(pathomorphCapillariesSheetHandler);
        pathomorphCapillariesSheetHandler.setNext(pathomorphVenulesSheetHandler);
    }
}
