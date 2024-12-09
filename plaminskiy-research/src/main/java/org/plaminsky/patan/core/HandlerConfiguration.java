package org.plaminsky.patan.core;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.plaminsky.patan.service.BrainSheetHandler;
import org.plaminsky.patan.service.HeartSheetHandler;
import org.plaminsky.patan.service.KidneysSheetHandler;
import org.plaminsky.patan.service.LiverSheetHandler;
import org.plaminsky.patan.service.LungsSheetHandler;
import org.plaminsky.patan.service.SepsisSheetHandler;
import org.plaminsky.patan.service.SepsisTypeSheetHandler;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class HandlerConfiguration {

    private final BrainSheetHandler brainSheetHandler;
    private final SepsisSheetHandler sepsisSheetHandler;
    private final SepsisTypeSheetHandler sepsisTypeSheetHandler;
    private final LungsSheetHandler lungsSheetHandler;
    private final HeartSheetHandler heartSheetHandler;
    private final KidneysSheetHandler kidneysSheetHandler;
    private final LiverSheetHandler liverSheetHandler;

    @PostConstruct
    private void init() {
        sepsisTypeSheetHandler.setNext(sepsisSheetHandler);
        sepsisSheetHandler.setNext(brainSheetHandler);
        brainSheetHandler.setNext(lungsSheetHandler);
        lungsSheetHandler.setNext(heartSheetHandler);
        heartSheetHandler.setNext(liverSheetHandler);
        liverSheetHandler.setNext(kidneysSheetHandler);
    }
}
