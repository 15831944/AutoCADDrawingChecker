package autocadDrawingChecker.data.extractors;

import autocadDrawingChecker.data.elements.Record;
import autocadDrawingChecker.logging.Logger;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 * @author Matt
 */
public abstract class RecordExtractor<T extends Record> {
    private HashMap<String, Integer> currentCols;
    private Row currentRow;
    
    private Object getCell(String col){
        Object ret = null;
        int colIdx = currentCols.get(col);
        if(colIdx == -1){
            throw new RuntimeException(String.format("Missing column: %s", col));
        }
        Cell c = currentRow.getCell(colIdx);
        switch(c.getCellType()){
            case BOOLEAN:
                ret = c.getBooleanCellValue();
                break;
            case NUMERIC:
                ret = c.getNumericCellValue();
                break;
            case STRING:
                ret = c.getStringCellValue();
                break;
            default:
                Logger.logError(String.format("RecordExtractor encountered cell with type %s", c.getCellType().name()));
                ret = c.toString();
                break;
        }
        return ret;
    }
    
    protected String getCellString(String col){
        String ret = null;
        try {
            ret = (String)getCell(col);
        } catch(ClassCastException ex){
            Logger.logError(String.format("Column \"%s\" is not a string", col));
            throw ex;
        }
        return ret;
    }
    
    protected boolean currentRowHasCell(String col){
        int colIdx = currentCols.get(col);
        boolean hasCol = 
            colIdx != -1 && 
            currentRow.getCell(colIdx) != null;
        // getCell doesn't throw an exception if it doesn't have a cell for the given column: it just returns null
        
        return hasCol;
    }
    
    /**
     * Extracts data from the given row, and converts it to an AutoCAD element.
     * @param columns the mapping of columns to the index of the column
     * in the given row.
     * @param currentRow the row to extract data from
     * @return the extracted AutoCADElement.
     */
    public synchronized final T extract(HashMap<String, Integer> columns, Row currentRow){
        // temporarily set the columns and row. Note this method is synchronized to prevent multithreading issues
        this.currentCols = columns;
        this.currentRow = currentRow;
        T ret = doExtract();
        this.currentCols = null;
        this.currentRow = null;
        return ret;
    }
    
    private T doExtract(){
        T ret = createNew();
        currentCols.keySet().forEach((header)->{
            if(this.currentRowHasCell(header)){
                ret.setAttribute(header, getCell(header));
            }
        });
        return ret;
    }
    
    public abstract T createNew();
}
