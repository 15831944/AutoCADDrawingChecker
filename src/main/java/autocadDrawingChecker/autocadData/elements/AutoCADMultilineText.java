package autocadDrawingChecker.autocadData.elements;

import java.util.Arrays;

/**
 *
 * @author Matt
 */
public class AutoCADMultilineText extends AbstractAutoCADText {
    private final String contentsRTF;
    private final double[] position;
    private final int showBorders;
    private final double width;
    
    public AutoCADMultilineText(String textContents, String rtfContents, double[] coords, int theta, int showBorders, double width) {
        super(textContents, theta);
        contentsRTF = rtfContents;
        position = Arrays.copyOf(coords, coords.length);
        this.showBorders = showBorders;
        this.width = width;
    }
    
    public final String getRTFContents(){
        return contentsRTF;
    }
    public final double getX(){
        return position[0];
    }
    public final double getY(){
        return position[1];
    }
    public final double getZ(){
        return position[2];
    }
    
    public final int getShowBorders(){
        return showBorders;
    }
    public final double getWidth(){
        return width;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("AutoCAD Text:");
        sb.append("\n").append(super.toString());
        sb.append(String.format("\n\t* Contents: %s", getTextContents()));
        sb.append(String.format("\n\t* RTF: %s", contentsRTF));
        sb.append(String.format("\n\t* Position: (%f, %f, %f)", position[0], position[1], position[2]));
        sb.append(String.format("\n\t* Rotation: %d", getRotation()));
        sb.append(String.format("\n\t* Show Borders: %d", showBorders));
        sb.append(String.format("\n\t* Width: %f", width));
        return sb.toString();
    }
}