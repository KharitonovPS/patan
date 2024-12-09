package util;

import lombok.experimental.UtilityClass;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

@UtilityClass
public class CellExtractor {


    public static boolean isValid(Cell cell) {
        return cell != null && cell.getCellType() != CellType.BLANK;
    }

    public static Float extractFloatFromCell(Cell cell) {
        if (cell == null) {
            return null;
        }
        try {
            return parseFloatFromCell(cell);
        } catch (Exception e) {
            return null;
        }
    }

    private static Float parseFloatFromCell(Cell cell) {
        try {
            return Float.parseFloat(cell.getStringCellValue().trim());
        } catch (Exception e) {
            return (float) cell.getNumericCellValue();
        }
    }

    public static Integer extractIntegerFromCell(Cell cell) {
        if (cell == null) {
            return null;
        }
        try {
            return parseIntegerFromCell(cell);
        } catch (Exception e) {
            return null;
        }
    }

    private static Integer parseIntegerFromCell(Cell cell) {
        try {
            return Integer.parseInt(cell.getStringCellValue().trim());
        } catch (Exception e) {
            return (int) cell.getNumericCellValue();
        }
    }

}
