package autocadDrawingChecker.grading.implementations;

import autocadDrawingChecker.autocadData.AutoCADLine;
import autocadDrawingChecker.autocadData.AutoCADElement;

/**
 *
 * @author Matt Crow
 */
public class LineStart implements AbstractVectorCriteria<AutoCADLine> {
    @Override
    public String getDescription() {
        return "Grades based on how closesly the student's line start points match up with those of the instructor's";
    }

    @Override
    public String getName() {
        return "Line Start";
    }

    @Override
    public double[] extractVector(AutoCADLine e) {
        double[] v = new double[AutoCADLine.DIMENSION_COUNT];
        for(int i = 0; i < v.length; i++){
            v[i] = e.getStart(i);
        }
        return v;
    }

    @Override
    public AutoCADLine cast(AutoCADElement e) {
        return (e instanceof AutoCADLine) ? (AutoCADLine)e : null;
    }
}
