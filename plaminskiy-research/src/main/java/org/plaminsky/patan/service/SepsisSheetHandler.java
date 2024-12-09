package org.plaminsky.patan.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.patan.core.SheetHandler;
import org.plaminsky.patan.mapper.SepsisMapper;
import org.plaminsky.patan.repository.SepsisRepository;
import org.springframework.stereotype.Service;

import static org.plaminsky.patan.core.SheetConstant.SEPSIS_SHEET;

@Slf4j
@Service
@RequiredArgsConstructor
public class SepsisSheetHandler implements SheetHandler {

    private final SepsisMapper sepsisMapper;
    private final SepsisRepository sepsisRepository;
    private SheetHandler next;

    @Override
    public void setNext(SheetHandler next) {
        this.next = next;
    }

    @Override
    public void handle(Sheet sheet) {
        if (isSepsis(sheet)) {
            processSheet(sheet);
        } else if (next != null) {
            next.handle(sheet);
        }
    }

    private boolean isSepsis(Sheet sheet) {
        return SEPSIS_SHEET.equalsIgnoreCase(sheet.getSheetName());
    }

    private void processSheet(Sheet sheet) {
        var sepsisList = sepsisMapper.toSepsis(sheet);
        sepsisRepository.saveAll(sepsisList);
        log.info("Sepsis processed: {}", sepsisList.size());
    }
}
