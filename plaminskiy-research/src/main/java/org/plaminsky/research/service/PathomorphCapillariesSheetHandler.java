package org.plaminsky.research.service;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.research.core.SheetHandler;
import org.plaminsky.research.mapper.PathomorphCapillariesMapper;
import org.plaminsky.research.repository.PathomorphCapillariesRepository;
import org.springframework.stereotype.Service;

import static org.plaminsky.research.core.SheetConstant.PATHOMORPH_CAPILLARIES_SHEET;

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
    }
}
