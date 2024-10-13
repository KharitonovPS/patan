package org.plaminsky.research.service;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Sheet;
import org.plaminsky.research.core.SheetHandler;
import org.plaminsky.research.mapper.LaboratoryStudyMapper;
import org.plaminsky.research.repository.LaboratoryStudyRepository;
import org.springframework.stereotype.Service;

import static org.plaminsky.research.core.SheetConstant.LABORATORY_STUDY_SHEET;

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
    }
}
