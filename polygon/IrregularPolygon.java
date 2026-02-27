package polygon;

import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*; // for DrawingTool

public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    // constructor
    public IrregularPolygon() {}

    // public methods
    public void add(Point2D.Double aPoint)
    {
        // TODO: Add a point to the IrregularPolygon.
        myPolygon.add(aPoint);
    }

    public double perimeter() {
        double perimeter = 0;
        if(myPolygon.size()>=3){
            int size = myPolygon.size(); 
            for(int i = 0; i<size; i++){
                Point2D.Double current = myPolygon.get(i);
                if(i==size-1){
                    perimeter = perimeter + current.distance(myPolygon.get(0)); 
                }
                else{
                    Point2D.Double next = myPolygon.get(i+1);
                    perimeter += current.distance(next);
                }
            }
        }
        return perimeter; 
        
        //return 3.14;
    }

    public double area() {
        // TODO: Calculate the area.
        double area = 0;
        int size = myPolygon.size(); 
        for(int i=0; i<size; i++){
            Point2D.Double firstPoint = myPolygon.get(0); 
            Point2D.Double current = myPolygon.get(i);
            Point2D.Double lastPoint = myPolygon.get(size-1);
            if(i==size-1){
                area += (lastPoint.getX()*firstPoint.getY() - lastPoint.getY()*firstPoint.getX());
            }
            else{
                Point2D.Double next = myPolygon.get(i+1);
                area += (current.getX()*next.getY()) - (current.getY()*next.getX()); 
            }
        }
        return Math.abs(area) / 2.0;
    }

    public void draw()
    {
        // Wrap the DrawingTool in a try/catch to allow development without need for graphics.
        try {
            // TODO: Draw the polygon.
            // Documents: https://pavao.org/compsci/gpdraw/html/gpdraw/DrawingTool.html
            DrawingTool myDrawingTool = new DrawingTool(new SketchPad(500, 500));
            myDrawingTool.move(50, 50);
        } catch (java.awt.HeadlessException e) {
            System.out.println("Exception: No graphics support available.");
        }
    }

}
