package autocadDrawingChecker.autocadData;

/**
 *
 * @author Matt Crow
 */
public class AutoCADDimension extends AutoCADElement {
    private final String style;
    private final int dynamicDimension;
    private final String textDefSize;
    
    public AutoCADDimension(String style, int dynamicDim, String textSize){
        super();
        this.style = style;
        dynamicDimension = dynamicDim;
        textDefSize = textSize;
    }
    
    public final String getDimensionStyle(){
        return style;
    }
    
    public final int getDynamicDimension(){
        return dynamicDimension;
    }
    
    public final String getTextDefinedSize(){
        return textDefSize;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("AutoCAD Dimension:");
        sb.append("\n").append(super.toString());
        sb.append(String.format("\n\t* Style: %s", style));
        sb.append(String.format("\n\t* Dynamic Dimension: %d", dynamicDimension));
        sb.append(String.format("\n\t* Text defined size: %s", textDefSize));
        return sb.toString();
    }
}
