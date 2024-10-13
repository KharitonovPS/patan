package org.plaminsky.research.service;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.research.core.SheetHandler;
import org.plaminsky.research.mapper.AreaLesionMapper;
import org.plaminsky.research.repository.AreaLesionRepository;
import org.springframework.stereotype.Service;

import static org.plaminsky.research.core.SheetConstant.AREA_LESION_SHEET;

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
    }
}
