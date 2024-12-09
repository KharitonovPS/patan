package org.plaminsky.patan.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.patan.core.SheetHandler;
import org.plaminsky.patan.mapper.LungsMapper;
import org.plaminsky.patan.repository.LungsRepository;
import org.springframework.stereotype.Service;

import static org.plaminsky.patan.core.SheetConstant.LUNG_SHEET;

@Slf4j
@Service
@RequiredArgsConstructor
public class LungsSheetHandler implements SheetHandler {

    private final LungsMapper laboratoryStudyMapper;
    private final LungsRepository lungsRepository;
    private SheetHandler next;

    @Override
    public void setNext(SheetHandler next) {
        this.next = next;
    }

    @Override
    public void handle(Sheet sheet) {
        if (isLungs(sheet)) {
            processSheet(sheet);
        } else if (next != null) {
            next.handle(sheet);
        }
    }

    private boolean isLungs(Sheet sheet) {
        return LUNG_SHEET.equalsIgnoreCase(sheet.getSheetName());
    }

    private void processSheet(Sheet sheet) {
        var lungsList = laboratoryStudyMapper.toLungs(sheet);
        lungsRepository.saveAll(lungsList);
        log.info("LungsSheet processed: {}", lungsList.size());
    }
}
