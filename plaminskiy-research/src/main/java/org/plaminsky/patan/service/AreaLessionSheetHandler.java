package org.plaminsky.patan.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.patan.core.SheetHandler;
import org.plaminsky.patan.mapper.AreaLesionMapper;
import org.plaminsky.patan.repository.AreaLesionRepository;
import org.springframework.stereotype.Service;

import static org.plaminsky.patan.core.SheetConstant.AREA_LESION_SHEET;

@Slf4j
@Service
@RequiredArgsConstructor
public class AreaLessionSheetHandler implements SheetHandler {

    private final AreaLesionMapper areaLesionMapper;
    private final AreaLesionRepository areaLesionRepository;
    private SheetHandler next;

    @Override
    public void setNext(SheetHandler next) {
        this.next = next;
    }

    @Override
    public void handle(Sheet sheet) {
        if (isAreaLesion(sheet)) {
            processSheet(sheet);
        } else if (next != null) {
            next.handle(sheet);
        }
    }

    private boolean isAreaLesion(Sheet sheet) {
        return AREA_LESION_SHEET.equals(sheet.getSheetName());
    }

    private void processSheet(Sheet sheet) {
        var areaLesions = areaLesionMapper.toAreaLesions(sheet);
        areaLesionRepository.saveAll(areaLesions);
        log.info("Processing sheet {}", sheet.getSheetName());
        log.info("AreaLesions processed: {}", areaLesions.size());
    }
}
