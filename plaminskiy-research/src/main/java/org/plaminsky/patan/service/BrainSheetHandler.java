package org.plaminsky.patan.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.patan.core.SheetHandler;
import org.plaminsky.patan.mapper.BrainMapper;
import org.plaminsky.patan.repository.BrainRepository;
import org.springframework.stereotype.Service;

import static org.plaminsky.patan.core.SheetConstant.BRAIN_SHEET;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrainSheetHandler implements SheetHandler {

    private final BrainMapper brainMapper;
    private final BrainRepository brainRepository;
    private SheetHandler next;

    @Override
    public void setNext(SheetHandler next) {
        this.next = next;
    }

    @Override
    public void handle(Sheet sheet) {
        if (isBrainSheet(sheet)) {
            processSheet(sheet);
        } else if (next != null) {
            next.handle(sheet);
        }
    }

    private boolean isBrainSheet(Sheet sheet) {
        return BRAIN_SHEET.equalsIgnoreCase(sheet.getSheetName());
    }

    private void processSheet(Sheet sheet) {
        var brainList = brainMapper.toBrain(sheet);
        brainRepository.saveAll(brainList);
        log.info("BrainSheet processed: {}", brainList.size());
    }
}
