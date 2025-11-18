package cards;

public class Card {
    private int suit; 
    private int value; 
    public static final String[] SUIT = {"♦", "♣", "♥", "♠"}; 
    public static final String[] VALUE = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    public Card(int suit, int value){
        if(suit<0){
            this.suit=0; 
        }
        else if(suit>SUIT.length-1){
            this.suit = SUIT.length-1; 
        }
        else{
            this.suit = suit; 
        }

        if(value<0){
            this.value = 0; 
        }
        else if(value>VALUE.length-1){
            this.value = VALUE.length-1;
        }
        else{
            this.value = value; 
        }
        
    }
    public int getValue(){
        return value;
    } 

    public String toString(){
        return SUIT[suit]+VALUE[value]; 
    }

    public static void main(String[] args){
        System.out.println(new Card(0, 10)); 
        System.out.println(new Card(-11, 10));
        System.out.println(new Card(2, 15));
        System.out.println(new Card(100, 100));
    }

}
