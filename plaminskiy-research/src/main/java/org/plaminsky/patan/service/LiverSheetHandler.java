package org.plaminsky.patan.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.patan.core.SheetHandler;
import org.plaminsky.patan.mapper.LiverMapper;
import org.plaminsky.patan.repository.LiverRepository;
import org.springframework.stereotype.Service;

import static org.plaminsky.patan.core.SheetConstant.LIVER_SHEET;

@Slf4j
@Service
@RequiredArgsConstructor
public class LiverSheetHandler implements SheetHandler {

    private final LiverMapper liverMapper;
    private final LiverRepository liverRepository;
    private SheetHandler next;

    @Override
    public void setNext(SheetHandler next) {
        this.next = next;
    }

    @Override
    public void handle(Sheet sheet) {
        if (isLivers(sheet)) {
            processSheet(sheet);
        } else if (next != null) {
            next.handle(sheet);
        }
    }

    private boolean isLivers(Sheet sheet) {
        return LIVER_SHEET.equalsIgnoreCase(sheet.getSheetName());
    }

    private void processSheet(Sheet sheet) {
        var liverList = liverMapper.toLivers(sheet);
        liverRepository.saveAll(liverList);
        log.info("LIVER_SHEET processed: {}", liverList.size());
    }
}
