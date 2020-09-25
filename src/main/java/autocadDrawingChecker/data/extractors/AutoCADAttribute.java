package autocadDrawingChecker.data.extractors;

/**
 * An AutoCADAttribute represents
 * a column in an AutoCAD export.
 * 
 * This will likely be removed in the future,
 * and replaced by simply using static string 
 * constants in the various extractors, as that
 * is a far more extendable pattern than this.
 * 
 * PRO-TIP: control shift F and replace when refactoring
 * 
 * @author Matt Crow
 */
public enum AutoCADAttribute {
    COUNT("Count"),
    NAME("Name"),
    ANGLE("Angle"),
    CENTER_X("Center X"),
    CENTER_Y("Center Y"),
    CENTER_Z("Center Z"),
    COLOR("Color"),
    DELTA_X("Delta X"),
    DELTA_Y("Delta Y"),
    DELTA_Z("Delta Z"),
    DIAMETER("Diameter"),
    DRAWING("Drawing"),
    END_X("End X"),
    END_Y("End Y"),
    END_Z("End Z"),
    LAYER("Layer"),
    LENGTH("Length"),
    LINE_TYPE("Linetype"),
    LINE_TYPE_SCALE("Linetype Scale"),
    LINE_WEIGTH("Lineweight"),
    PLOT_STYLE("Plot Style"),
    START_X("Start X"),
    START_Y("Start Y"),
    START_Z("Start Z"),
    THICKNESS("Thickness"),
    CONTENTS("Contents"),
    CONTENTS_RTF("ContentsRTF"),
    POSITION_X("Position X"),
    POSITION_Y("Position Y"),
    POSITION_Z("Position Z"),
    ROTATION("Rotation"),
    SHOW_BORDERS("ShowBorders"),
    WIDTH("Width"),
    AREA("Area"),
    CLOSED("Closed"),
    GLOBAL_WIDTH("Global Width"),
    DIM_STYLE("Dim Style"),
    DYNAMIC_DIMENSION("DynamicDimension"),
    TEXT_DEFINED_SIZE("TextDefinedSize"),
    VALUE("Value");
    
    private final String header;
    
    /**
     * 
     * @param sheetHeader the header of this attribute
     * as it appears in the AutoCAD export sheet.
     */
    private AutoCADAttribute(String sheetHeader){
        header = sheetHeader;
    }
    
    /**
     * 
     * @return the header of this attribute
     * as it appears in the AutoCAD export 
     * sheet.
     */
    public final String getHeader(){
        return header;
    }
}