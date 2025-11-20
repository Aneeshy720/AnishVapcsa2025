package cards;

public class Deck {
    private int currentCardIndex = 0; 
    private Card[] playingCards = new Card[Card.SUIT.length * Card.VALUE.length]; // making the size of the array 52 
    public Deck(){
        int index = 0; 
        for(int suit = 0; suit<Card.SUIT.length; suit++){
            for(int value = 0; value<Card.VALUE.length; value++){
                playingCards[index] = new Card(suit, value); 
                index++;                 
            }
        }
    }
    public Card draw(){
        if(currentCardIndex<playingCards.length){
            return playingCards[currentCardIndex++]; 
        }
        return null; 
    }

    public void cut(int num){
        // if num is out of the boundaries there will not be an amount to cut
        if(num<1 || num>playingCards.length ){  
            return;
        }

        Card[] cutPlayingCards = new Card[Card.SUIT.length * Card.VALUE.length];
        for(int i = num; i<playingCards.length; i++){
            cutPlayingCards[i-num] = playingCards[i]; 
        }

        for(int i = 0; i<num; i++){
            cutPlayingCards[playingCards.length - num + i] = playingCards[i];
        }
        playingCards = cutPlayingCards; 
    }

    public void print(int numCards){ 
        if(numCards>playingCards.length){
            numCards = playingCards.length;
        }
        for(int i = 0; i<numCards; i++){
            System.out.print(playingCards[i]+" "); 
        }
        System.out.println(); 
    }

    public void shuffle(){
        for(int i=0; i<1000; i++){
            int firstIndex = (int) (Math.random()*52); 
            int secondIndex = (int) (Math.random()*52); 
            if(firstIndex!=secondIndex){
                Card temp = playingCards[firstIndex]; 
                playingCards[firstIndex] = playingCards[secondIndex]; 
                playingCards[secondIndex] = temp; 
            }
        }
    }

    public void resetDraw(){
        currentCardIndex = 0; 
    }

    public static void main(String[] args){
        Deck deck = new Deck();
        for(int i = 0; i<53; i++){
            System.out.println(deck.draw()); 
        }
        System.out.println("Printing 5 cards:"); 
        deck.print(5); 
        System.out.println("Printing -5 cards:"); 
        deck.print(-5);
        System.out.println("Printing 100 cards:"); 
        deck.print(100);
        System.out.println("Now shuffling ..."); 
        deck.shuffle();
        deck.resetDraw(); 
        deck.print(52); 
        deck.cut(52); 
        deck.print(52); 
        System.out.println("Printing 5 cards:"); 
        deck.print(5); 
        System.out.println("Printing -5 cards:"); 
        deck.print(-5);
        System.out.println("Printing 100 cards:"); 
        deck.print(100); 
    }


}
