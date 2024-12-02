package org.plaminsky.patan.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.patan.core.SheetHandler;
import org.plaminsky.patan.mapper.LaboratoryStudyMapper;
import org.plaminsky.patan.repository.LaboratoryStudyRepository;
import org.springframework.stereotype.Service;

import static org.plaminsky.patan.core.SheetConstant.LABORATORY_STUDY_SHEET;

@Slf4j
@Service
@RequiredArgsConstructor
public class LaboratoryStudySheetHandler implements SheetHandler {

    private final LaboratoryStudyMapper laboratoryStudyMapper;
    private final LaboratoryStudyRepository laboratoryStudyRepository;
    private SheetHandler next;

    @Override
    public void setNext(SheetHandler next) {
        this.next = next;
    }

    @Override
    public void handle(Sheet sheet) {
        if (isLaboratoryStudy(sheet)) {
            processSheet(sheet);
        } else if (next != null) {
            next.handle(sheet);
        }
    }

    private boolean isLaboratoryStudy(Sheet sheet) {
        return LABORATORY_STUDY_SHEET.equals(sheet.getSheetName());
    }

    private void processSheet(Sheet sheet) {
        var laboratoryStudy = laboratoryStudyMapper.toLaboratoryStudy(sheet);
        laboratoryStudyRepository.saveAll(laboratoryStudy);
        log.info("Processing sheet {}", sheet.getSheetName());
        log.info("LaboratoryStudy processed: {}", laboratoryStudy.size());
    }
}
