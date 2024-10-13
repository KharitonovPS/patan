package org.plaminsky.research.service;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.research.core.SheetHandler;
import org.plaminsky.research.mapper.DeceasedRecordMapper;
import org.plaminsky.research.repository.DeceasedRecordRepository;
import org.springframework.stereotype.Service;

import static org.plaminsky.research.core.SheetConstant.DECEASED_RECORD_SHEET;

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
    }
}
