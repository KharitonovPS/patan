package util;

import lombok.experimental.UtilityClass;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

@UtilityClass
public class CellExtractor {


    public static boolean isValid(Cell cell) {
        return cell != null && cell.getCellType() != CellType.BLANK;
    }

    public static float extractFloatFromCell(Cell cell) {
        if (cell == null) {
            return 0.0f;
        }
        try {
            return parseFromCell(cell);
        } catch (Exception e) {
            return 0.0f;
        }
    }

    private static float parseFromCell(Cell cell) {
        try {
            return Float.parseFloat(cell.getStringCellValue().trim());
        } catch (Exception e) {
            return (float) cell.getNumericCellValue();
        }
    }

}
