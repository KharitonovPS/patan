package org.plaminsky.patan.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.patan.core.SheetHandler;
import org.plaminsky.patan.mapper.HeartMapper;
import org.plaminsky.patan.repository.HeartRepository;
import org.springframework.stereotype.Service;

import static org.plaminsky.patan.core.SheetConstant.HEART_SHEET;

@Slf4j
@Service
@RequiredArgsConstructor
public class HeartSheetHandler implements SheetHandler {

    private final HeartMapper heartMapper;
    private final HeartRepository heartRepository;
    private SheetHandler next;

    @Override
    public void setNext(SheetHandler next) {
        this.next = next;
    }

    @Override
    public void handle(Sheet sheet) {
        if (isHeart(sheet)) {
            processSheet(sheet);
        } else if (next != null) {
            next.handle(sheet);
        }
    }

    private boolean isHeart(Sheet sheet) {
        return HEART_SHEET.equalsIgnoreCase(sheet.getSheetName());
    }

    private void processSheet(Sheet sheet) {
        var heartList = heartMapper.toHeart(sheet);
        heartRepository.saveAll(heartList);
        log.info("HEART_SHEET processed: {}", heartList.size());
    }
}
