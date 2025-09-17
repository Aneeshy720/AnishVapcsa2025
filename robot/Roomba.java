package robot;

import kareltherobot.*;

public class Roomba implements Directions {

	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		String worldName = "robot/finalTestWorld2024.wld";
		World.setDelay(0);
		Roomba cleaner = new Roomba();
		int totalBeepers = cleaner.cleanRoom(worldName, 26, 101);
		//System.out.println("Roomba cleaned up a total of " + totalBeepers + " beepers.");  
		//System.out.println("Roomba cleaned up a total of " + totalBeepers + " piles.");
	}

	// declared here so it is visible in all the methods!
	private Robot roomba;

	public int cleanRoom(String worldName, int startX, int startY) {

		// A new Robot should be constructed and assigned to the global (instance) variable named roomba that is declared above.
        // Make sure it starts at startX and startY location.

		//initializing variables
		World.readWorld(worldName);
		World.setVisible(true);
		boolean end = true;
		roomba = new Robot(startX, startY, East, 0); 
		int beeperNum = 0; 
		int squares = 0; 
		int numOfPiles = 0;  
		int maxBeeperPile = 0; 
		int street = roomba.street();   
		int ave = roomba.avenue();      

		//this will detect of any beepers must be picked up in the beginning
		if (roomba.nextToABeeper()) {
        	numOfPiles++;
        	int currentPileSize = 0;
        while (roomba.nextToABeeper()) {
            roomba.pickBeeper(); 
            beeperNum++; 
            currentPileSize++; 
        }
        if (currentPileSize > maxBeeperPile) {
            maxBeeperPile = currentPileSize;
            street = roomba.street(); 
            ave = roomba.avenue(); 
        }
    }
		// The "while(end)" command allows this loop to iterate indefinitely until there are no more squares to cover.
		while(end){
			while(roomba.frontIsClear()){ //As long as the front is clear, the roomba will keep moving 
				roomba.move(); 
				squares++; 
				if(roomba.nextToABeeper() == true){
					numOfPiles++; 
					int currentPileSize = 0;
					while(roomba.nextToABeeper()){
						roomba.pickBeeper(); 
						beeperNum++; 
						currentPileSize++; 
					}
						if(currentPileSize >= maxBeeperPile){
							maxBeeperPile = currentPileSize;
							street = roomba.street(); 
							ave = roomba.avenue(); 
						}
				}
			}
			//If the roomba is facing east and the front is not clear, then the roomba will do this following in the condition
			if(roomba.facingEast() && !roomba.frontIsClear()){ 
				roomba.turnLeft(); 
				if(!roomba.frontIsClear()){
					squares++;
					end = false;
				}
				else{ 
					roomba.move();
					squares++; 
					roomba.turnLeft(); 
				}
				; 
			}
			//If the roomba is facing west and the front is not clear, then the roomba will do this following in the condition
			else if(roomba.facingWest() && !roomba.frontIsClear()){ 
				turnRight(roomba); 
				if(!roomba.frontIsClear()){  
					squares++;
					end = false; 
				}else{
				roomba.move(); 
				squares++;  
				turnRight(roomba); 
				}

			}

		//This will detect if any beepers must be picked up at the end.
		if (roomba.nextToABeeper()) {  
		numOfPiles++;
		int currentPileSize = 0;
		while (roomba.nextToABeeper()) {
			roomba.pickBeeper();
			beeperNum++;
			currentPileSize++;
		}
		if (currentPileSize > maxBeeperPile) {
			maxBeeperPile = currentPileSize;
			street = roomba.street();
			ave = roomba.avenue();
			}
		}
	} 
		 
		//equations to find the average pile size and the percentage of the room dirty
		double averagePileSize = (double)beeperNum/numOfPiles ; 
		double percentDirty = (double)numOfPiles / squares *100; 

		//print statements
		System.out.println("Total number of Beepers = "+ beeperNum);
		System.out.println("Total number of Piles = "+ numOfPiles); 
		System.out.println("Total Squares traveled: "+squares); 
		System.out.println("The maximum number of beepers in a pile is "+maxBeeperPile); 
		System.out.println("Coordinates: ("+street+ ", "+ave+")"); 
		System.out.println("Relative Position: "+(street-startX)+" units up and "+(ave - startY)+" units right.");
		System.out.println("Average Pile size = "+ averagePileSize); 
		System.out.println("Percent dirty: "+percentDirty+"%"); 
		return numOfPiles; 
	}
	//method to turn right is a simplfication for turning left three times 
	public static void turnRight(Robot roomba){
		roomba.turnLeft(); 
		roomba.turnLeft(); 
		roomba.turnLeft(); 
	}
}