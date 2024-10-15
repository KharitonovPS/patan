package org.plaminsky.research.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.research.core.SheetHandler;
import org.plaminsky.research.mapper.PathomorphVenulesMapper;
import org.plaminsky.research.repository.PathomorphVenulesRepository;
import org.springframework.stereotype.Service;

import static org.plaminsky.research.core.SheetConstant.PATHOMORPH_VENULES_SHEET;

@Slf4j
@Service
@RequiredArgsConstructor
public class PathomorphVenulesSheetHandler implements SheetHandler {

    private final PathomorphVenulesMapper pathomorphVenulesMapper;
    private final PathomorphVenulesRepository pathomorphVenulesRepository;
    private SheetHandler next;

    @Override
    public void setNext(SheetHandler next) {
        this.next = next;
    }

    @Override
    public void handle(Sheet sheet) {
        if (isPathomorphVenules(sheet)) {
            processSheet(sheet);
        } else if (next != null) {
            next.handle(sheet);
        }
    }

    private boolean isPathomorphVenules(Sheet sheet) {
        return PATHOMORPH_VENULES_SHEET.equals(sheet.getSheetName());
    }

    private void processSheet(Sheet sheet) {
        var pathomorphVenules = pathomorphVenulesMapper.toPathomorphVenules(sheet);
        pathomorphVenulesRepository.saveAll(pathomorphVenules);
        log.info("Processing sheet {}", sheet.getSheetName());
        log.info("PathomorphVenules processed: {}", pathomorphVenules.size());
    }
}
