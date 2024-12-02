package org.plaminsky.patan.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.patan.core.SheetHandler;
import org.plaminsky.patan.mapper.PathomorphArteriolesMapper;
import org.plaminsky.patan.repository.PathomorphArteriolesRepository;
import org.springframework.stereotype.Service;

import static org.plaminsky.patan.core.SheetConstant.PATHOMORPH_ARTERIOLES_SHEET;

@Slf4j
@Service
@RequiredArgsConstructor
public class PathomorphArteriolesSheetHandler implements SheetHandler {

    private final PathomorphArteriolesMapper pathomorphArteriolesMapper;
    private final PathomorphArteriolesRepository pathomorphArteriolesRepository;
    private SheetHandler next;

    @Override
    public void setNext(SheetHandler next) {
        this.next = next;
    }

    @Override
    public void handle(Sheet sheet) {
        if (isPathomorphArterioles(sheet)) {
            processSheet(sheet);
        } else if (next != null) {
            next.handle(sheet);
        }
    }

    private boolean isPathomorphArterioles(Sheet sheet) {
        return PATHOMORPH_ARTERIOLES_SHEET.equals(sheet.getSheetName());
    }

    private void processSheet(Sheet sheet) {
        var pathomorphArterioles = pathomorphArteriolesMapper.toPathomorphArterioles(sheet);
        pathomorphArteriolesRepository.saveAll(pathomorphArterioles);
        log.info("Processing sheet {}", sheet.getSheetName());
        log.info("PathomorphArterioles processed: {}", pathomorphArterioles.size());
    }
}
