package polygon;
import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*; // for DrawingTool

public class Main {
    public static void main(String [] args)
    {

        IrregularPolygon myPolygon = new IrregularPolygon(); 
        double[][] polygonPoints = { {-50,-30}, {13,67}, {50,50}, {111, 121}, {30,10}}; //testing my own set of points
        for(double[] p : polygonPoints){
            Point2D.Double point = new Point2D.Double(p[0], p[1]); 
            myPolygon.add(point); 
        }

        myPolygon.draw(); 
        TestSuite.run();
    }
    
}
