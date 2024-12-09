package org.plaminsky.patan.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.patan.core.SheetHandler;
import org.plaminsky.patan.mapper.SepsisTypeMapper;
import org.plaminsky.patan.repository.SepsisTypeRepository;
import org.springframework.stereotype.Service;

import static org.plaminsky.patan.core.SheetConstant.SEPSIS_TYPE_SHEET;

@Slf4j
@Service
@RequiredArgsConstructor
public class SepsisTypeSheetHandler implements SheetHandler {

    private final SepsisTypeMapper sepsisTypeMapper;
    private final SepsisTypeRepository sepsisTypeRepository;
    private SheetHandler next;

    @Override
    public void setNext(SheetHandler next) {
        this.next = next;
    }

    @Override
    public void handle(Sheet sheet) {
        if (isSepsisType(sheet)) {
            processSheet(sheet);
        } else if (next != null) {
            next.handle(sheet);
        }
    }

    private boolean isSepsisType(Sheet sheet) {
        return SEPSIS_TYPE_SHEET.equalsIgnoreCase(sheet.getSheetName());
    }

    private void processSheet(Sheet sheet) {
        var sepsisType = sepsisTypeMapper.toSepsisType(sheet);
        sepsisTypeRepository.saveAll(sepsisType);
        log.info("SepsisType processed: {}", sepsisType.size());
    }
}
