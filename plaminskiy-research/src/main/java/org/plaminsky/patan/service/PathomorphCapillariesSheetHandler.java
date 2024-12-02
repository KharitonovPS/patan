package org.plaminsky.patan.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.patan.core.SheetHandler;
import org.plaminsky.patan.mapper.PathomorphCapillariesMapper;
import org.plaminsky.patan.repository.PathomorphCapillariesRepository;
import org.springframework.stereotype.Service;

import static org.plaminsky.patan.core.SheetConstant.PATHOMORPH_CAPILLARIES_SHEET;

@Slf4j
@Service
@RequiredArgsConstructor
public class PathomorphCapillariesSheetHandler implements SheetHandler {

    private final PathomorphCapillariesMapper pathomorphCapillariesMapper;
    private final PathomorphCapillariesRepository pathomorphCapillariesRepository;
    private SheetHandler next;

    @Override
    public void setNext(SheetHandler next) {
        this.next = next;
    }

    @Override
    public void handle(Sheet sheet) {
        if (isPathomorphCapillaries(sheet)) {
            processSheet(sheet);
        } else if (next != null) {
            next.handle(sheet);
        }
    }

    private boolean isPathomorphCapillaries(Sheet sheet) {
        return PATHOMORPH_CAPILLARIES_SHEET.equals(sheet.getSheetName());
    }

    private void processSheet(Sheet sheet) {
        var pathomorphCapillaries = pathomorphCapillariesMapper.processPathomorphCapillaries(sheet);
        pathomorphCapillariesRepository.saveAll(pathomorphCapillaries);
        log.info("Processing sheet {}", sheet.getSheetName());
        log.info("PathomorphCapillaries processed: {}", pathomorphCapillaries.size());
    }
}
