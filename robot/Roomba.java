package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	// Main method to make this self-contained
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		String worldName = "robot/TestWorld-1.wld";
		World.setDelay(1);
		Roomba cleaner = new Roomba();
		int totalBeepers = cleaner.cleanRoom(worldName, 25, 13);
		//System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");  
		//System.out.println("Roomba cleaned up a total of " + totalBeepers + " piles.");
	}

	// declared here so it is visible in all the methods!
	private Robot roomba;

	// You will need to add many variables!!




	public int cleanRoom(String worldName, int startX, int startY) {

		// A new Robot should be constructed and assigned to the global (instance) variable named roomba that is declared above.
        // Make sure it starts at startX and startY location.

		World.readWorld(worldName);
		World.setVisible(true);
		boolean end = true;
		roomba = new Robot(startX, startY, East, 0); 
		int count = 0; 
		int units = 0; 
		int pileSize = 0;  
		int max = 0; 
		int street = startX; 
		int ave = startY; 
		roomba.street();
		while(end){
			while(roomba.frontIsClear()){
				roomba.move(); 
				units++; 
				int max2 = 0;
				if(roomba.nextToABeeper() == true){
					pileSize++; 
					while(roomba.nextToABeeper()){
						roomba.pickBeeper(); 
						count++; 
						max2 += 1;
						if(max2 >= max){
							max = max2;
							street = roomba.street(); 
							ave = roomba.avenue(); 
						}
						
				} 
			}
				//pileSize++; 
			}
			if(roomba.facingEast() && !roomba.frontIsClear()){
				roomba.turnLeft(); 
				roomba.move();
				roomba.turnLeft(); 
			}
			else if(roomba.facingWest() && !roomba.frontIsClear()){
				turnRight(roomba); 
				roomba.move(); 
				turnRight(roomba); 
			}
			if(roomba.facingNorth() && !roomba.frontIsClear()){
				end = false;
			}
		
		} 
		System.out.println("Total Beepers = "+ count);
		System.out.println("Total Piles = "+ pileSize); 
		System.out.println("Total Squares traveled: "+units); 
		System.out.println("Max: "+max); 
		System.out.println("Coordinates: ("+street+ ", "+ave+")"); 
		return pileSize; 
		
		

			

		/** This section will have all the logic that takes the Robot to every location
		 * and cleans up all piles of beepers. Think about ways you can break this
		 * large, complex task into smaller, easier to solve problems.
		 */

		// the line below causes a null pointer exception
		// what is that and why are we getting it?


		//int totalBeepers = 20; // Need to move this somewhere else.
        // This method should return the total number of beepers cleaned up.
		//return totalBeepers;
	}

	public static void turnRight(Robot roomba){
		roomba.turnLeft(); 
		roomba.turnLeft(); 
		roomba.turnLeft(); 
	}
}
