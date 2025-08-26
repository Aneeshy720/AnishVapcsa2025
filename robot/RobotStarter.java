package robot;
import kareltherobot.*;


public class RobotStarter implements Directions{

  public static void main(String[] args) {

    World.setVisible(true);// allows us to see the run output
    // the bigger the street, the farther north
    World.setSize(20,20);
    World.setDelay(20); 
    // The line below creates a Robot that we will refer to as rob  
    // Find out what the numbers and direction do!
    // Put rob in a better location for your initials.
    Robot rob = new Robot(15,7,North,9);
		
    // Want a second robot?  No prob.  They are cheap :)
    //Robot dude = new Robot(7,5,West,9);
    // examples of commands you can invoke on a Robot
    //rob.move();// move one step in the direction it is facing
    
    
    // starting the letter A
    rob.putBeeper(); 
    rob.move(); 
    rob.turnLeft();
    rob.move(); 
    rob.turnLeft();
    rob.turnLeft();
    rob.turnLeft(); 
    rob.putBeeper(); 
    rob.move(); 
    rob.turnLeft();
    rob.move(); 
    rob.turnLeft();
    rob.turnLeft();
    rob.turnLeft();
    rob.putBeeper(); 
    rob.move(); 
    rob.turnLeft();
    rob.move(); 
    rob.turnLeft();
    rob.turnLeft();
    rob.turnLeft();
    rob.putBeeper(); 
    // done seg 1 of A
    rob.turnLeft(); 
    rob.move(); 
    rob.turnLeft(); 
    rob.move(); 
    rob.putBeeper(); 
    rob.turnLeft();
    rob.turnLeft();
    rob.turnLeft();
    rob.move();
    rob.turnLeft(); 
    rob.move(); 
    rob.putBeeper();
    rob.turnLeft();
    rob.turnLeft();
    rob.turnLeft();
    rob.move();
    rob.turnLeft();
    rob.move();
    rob.putBeeper();
    rob.turnLeft();
    rob.move(); 
    rob.move(); 
    rob.move(); 
    rob.turnLeft(); 
    rob.move(); 
    rob.putBeeper(); 
    rob.turnLeft();
    rob.move();
    rob.putBeeper(); 
    rob.turnLeft();
    rob.turnLeft();
    rob.move(); 
    rob.move(); 
    rob.putBeeper(); 
    
//Letter V
    Robot rob2 = new Robot(18,8,North,9); 
    rob2.putBeeper(); 
    rob2.turnLeft();
    rob2.turnLeft();
    rob2.move(); 
    rob2.turnLeft();
    rob2.move();
    rob2.putBeeper(); 
    turnRight(rob2);
    rob2.move();
    rob2.turnLeft();
    rob2.move();
    rob2.putBeeper();
    turnRight(rob2);
    rob2.move();
    rob2.turnLeft(); 
    rob2.move();
    rob2.putBeeper();
    rob2.move(); 
    rob2.turnLeft();
    rob2.move();
    rob2.putBeeper();
    turnRight(rob2);
    rob2.move(); 
    rob2.turnLeft();
    rob2.move();
    rob2.putBeeper();
    turnRight(rob2); 
    rob2.move();
    rob2.turnLeft();
    rob2.move();
    

   
  }
  
  public static void turnRight(Robot rob){
    rob.turnLeft(); 
    rob.turnLeft(); 
    rob.turnLeft(); 
  }

}
