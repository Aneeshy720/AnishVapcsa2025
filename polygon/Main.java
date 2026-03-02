package polygon;

public class Main {
    public static void main(String [] args)
    {

        IrregularPolygon myPolygon = new IrregularPolygon(); 
        //double[][] points = {{0,1}, {13,67}, {49,21}, {12,10}}; 
        myPolygon.draw();
        /*for (int i = 0; i<points.length; i++)
        {
            //System.out.println("  Adding point: " + Arrays.toString(point));
            myPolygon.add(new Point2D.Double(poin));
        }
        */

        TestSuite.run();
    }
    
}
