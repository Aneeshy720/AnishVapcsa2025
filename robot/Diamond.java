package robot;
import kareltherobot.*;


public class Diamond implements Directions{

  public static void main(String[] args) {

    World.setVisible(true);// allows us to see the run output
    // the bigger the street, the farther north
    World.setSize(10,10);
    World.setDelay(20); 
    // The line below creates a Robot that we will refer to as rob  
    // Find out what the numbers and direction do!
    // Put rob in a better location for your initials.
    Robot rob = new Robot(9,5,North,100);
		
    // Want a second robot?  No prob.  They are cheap :)
    //Robot dude = new Robot(7,5,West,9);
    // examples of commands you can invoke on a Robot
    //rob.move();// move one step in the direction it is facing

        rob.putBeeper();
        rob.turnLeft(); 
        rob.move(); 
        rob.turnLeft(); 
        rob.move(); 
        
        rob.putBeeper();
        turnRight(rob); 
        rob.move(); 
        rob.turnLeft(); 
        rob.move(); 
        
        rob.putBeeper();
        turnRight(rob); 
        rob.move(); 
        rob.turnLeft(); 
        rob.move(); 
        
        rob.putBeeper(); 
        rob.move(); 
        rob.turnLeft(); 
        rob.move(); 
        
        rob.putBeeper(); 
        turnRight(rob); 
        rob.move(); 
        rob.turnLeft(); 
        rob.move(); 
        
        rob.putBeeper(); 
        turnRight(rob);
        rob.move(); 
        rob.turnLeft(); 
        rob.move(); 

        rob.putBeeper(); 
        rob.turnLeft(); 

        for(int i = 1; i<=3; i++){
            turnRight(rob);
            rob.move(); 
            rob.turnLeft(); 
            rob.move(); 
            rob.putBeeper();
        }
        
        for(int i = 1; i<=3; i++){
            rob.move(); 
            rob.turnLeft(); 
            rob.move();
            rob.putBeeper(); 
            turnRight(rob); 
        }
        
    }

    public static void turnRight(Robot rob){
        rob.turnLeft(); 
        rob.turnLeft(); 
        rob.turnLeft(); 
    } 
}

