package gol;

import java.util.Arrays;

public class GameOfLife implements Board {

    // Integers: 0 or 1 for alive or dead
    private int[][] board;

    //contructor 
    public GameOfLife(int x, int y)
    {
        board = new int[x][y]; //created board as a 2D area with x number of rows and y number of columns 
    }

    // Set values on the board
    public void set(int x, int y, int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                board[i + x][j + y] = data[i][j];
            }
        }
    }

    // Run the simulation for a number of turns
    public void run(int turns) {
        // call step the number of times requested
        for(int i = 1; i<=turns; i++){
            step();
        }
    }

    // Step the simulation forward one turn. 
    public void step()
    {
        //number of rows in the board 
        int rows = board.length; 
        //number of columns in the board
        int cols = board[0].length; 
        //create a new board of the same size of board
        int[][] newBoard = new int[rows][cols];
        //initialize a new board based on the 4 game rules
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                //find the number of neighbors for the cell at [i][j]
                int neighbors = countNeighbors(i, j); 
                if(board[i][j]==0){ //empty cell
                    if(neighbors==3){
                        newBoard[i][j] = 1; //number of neighbors for an empty cell is 3, so make it alive
                    }
                    else{
                        newBoard[i][j] = 0; //number of neighbors is not 3, leave it empty
                    }
                }
                else{ //this cell is alive in current board
                    if(neighbors == 2 || neighbors == 3){ 
                        newBoard[i][j] = 1; //number of neighbors is 2 or 3, so it keep it alive
                    }
                    else{
                        newBoard[i][j] = 0; //number of neighbors is fewer than 2 or greater than 3, so it does not live on to the next generation
                    }
                }
            }
        }
        board = newBoard; //move the state one step forward by making board refer to the next board
         

        //print();
        // Update the game board, store a 1 if the cell is alive and a 0 otherwise.
    }


    public int countNeighbors(int x, int y) {
        int count = 0;
        // count the number of neighbors the cell has
        // use the get(x,y) method to read any board state you need.
        count += get(x-1, y-1); //top left cell
        count += get(x-1, y); //top cell
        count += get(x-1,y+1);//top right cell
        count += get(x, y-1); //left cell
        count += get(x, y+1);//right cell
        count += get(x+1, y-1); //bottom left cell
        count += get(x+1, y); //bottom cell
        count += get(x+1, y+1); //bottom right cell

        return count; //return the number of neighbors
    }

    // Get a value from the board with "wrap around"
    // Locations outside the board will loop back into the board.
    // Ex: -1 will read board.length-1
    public int get(int x, int y) {
        int xLimit = board.length;
        int yLimit= board[0].length;
        return board[(x+xLimit)%xLimit][(y+yLimit)%yLimit];
    }

    // Test helper to get the whole board state
    public int[][] get()
    {
        return board;
    }

    // Test helper to print the current state
    public void print(){
        // Print the header
        System.out.print("\n ");
        for (int y = 0; y < board[0].length; y++) {
            System.out.print(y%10 + " ");
        }

        for (int x = 0; x < board.length; x++) {
            System.out.print("\n" + x%10);
            for (int y=0; y<board[x].length; y++)
            {
                if (board[x][y] == 1)
                {
                    System.out.print("⬛");
                }
                else
                {
                    System.out.print("⬜");
                }
            }
        }
        System.out.println();
    }
}
