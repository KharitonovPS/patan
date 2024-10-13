package org.plaminsky.research.core;

import org.apache.poi.ss.usermodel.Sheet;

public interface SheetHandler {

    void setNext(SheetHandler next);

    void handle(Sheet sheet);
}
