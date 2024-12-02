package org.plaminsky.patan.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.patan.core.SheetHandler;
import org.plaminsky.patan.mapper.DeceasedRecordMapper;
import org.plaminsky.patan.repository.DeceasedRecordRepository;
import org.springframework.stereotype.Service;

import static org.plaminsky.patan.core.SheetConstant.DECEASED_RECORD_SHEET;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeceasedRecordSheetHandler implements SheetHandler {

    private final DeceasedRecordMapper deceasedRecordMapper;
    private final DeceasedRecordRepository deceasedRecordRepository;
    private SheetHandler next;

    @Override
    public void setNext(SheetHandler next) {
        this.next = next;
    }

    @Override
    public void handle(Sheet sheet) {
        if (isDeceasedRecord(sheet)) {
            processSheet(sheet);
        } else if (next != null) {
            next.handle(sheet);
        }
    }

    private boolean isDeceasedRecord(Sheet sheet) {
        return DECEASED_RECORD_SHEET.equals(sheet.getSheetName());
    }

    private void processSheet(Sheet sheet) {
        var deceasedRecords = deceasedRecordMapper.toDeceasedRecords(sheet);
        deceasedRecordRepository.saveAll(deceasedRecords);
        log.info("Processing sheet {}", sheet.getSheetName());
        log.info("DeceasedRecord processed: {}", deceasedRecords.size());
    }
}
