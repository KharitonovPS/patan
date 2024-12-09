package org.plaminsky.patan.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.patan.core.SheetHandler;
import org.plaminsky.patan.mapper.KidneysMapper;
import org.plaminsky.patan.repository.KidneysRepository;
import org.springframework.stereotype.Service;

import static org.plaminsky.patan.core.SheetConstant.KIDNEYS_SHEET;

@Slf4j
@Service
@RequiredArgsConstructor
public class KidneysSheetHandler implements SheetHandler {

    private final KidneysMapper kidneysMapper;
    private final KidneysRepository kidneysRepository;
    private SheetHandler next;

    @Override
    public void setNext(SheetHandler next) {
        this.next = next;
    }

    @Override
    public void handle(Sheet sheet) {
        if (isKidneysSheet(sheet)) {
            processSheet(sheet);
        } else if (next != null) {
            next.handle(sheet);
        }
    }

    private boolean isKidneysSheet(Sheet sheet) {
        return KIDNEYS_SHEET.equalsIgnoreCase(sheet.getSheetName());
    }

    private void processSheet(Sheet sheet) {
        var kidneysList = kidneysMapper.toKidneys(sheet);
        kidneysRepository.saveAll(kidneysList);
        log.info("KIDNEYS_SHEET processed: {}", kidneysList.size());
    }
}
