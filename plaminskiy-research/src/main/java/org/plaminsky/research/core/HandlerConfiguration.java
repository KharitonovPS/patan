package org.plaminsky.research.core;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.plaminsky.research.service.AreaLessionSheetHandler;
import org.plaminsky.research.service.DeceasedRecordSheetHandler;
import org.plaminsky.research.service.LaboratoryStudySheetHandler;
import org.plaminsky.research.service.PathomorphArteriolesSheetHandler;
import org.plaminsky.research.service.PathomorphCapillariesSheetHandler;
import org.plaminsky.research.service.PathomorphVenulesSheetHandler;
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
