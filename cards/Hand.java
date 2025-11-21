package cards;

public class Hand {
    private int numCards;  
    private Card[] cards; 

    public Hand(int maxNumCards){ 
        numCards = 0; 
        cards = new Card[maxNumCards];
    }
    
//add one card
    public void add(Card oneCard){
        if(numCards < cards.length){
            cards[numCards] = oneCard; 
            numCards++; 
        }
    }

    public int length(){
        return numCards; 
    }
    //gets a card   
    public Card get(int index){
        if(index>=0 && index < numCards){
            return cards[index]; 
        } 
        return null;
    }

    //removes one card the positions of the cards after it are shifted one position back to kill in the empty gap. 
    public Card remove(int index){
        Card returnCard = get(index); 
        if(returnCard!=null){          
            for(int i=index; i<numCards; i++){
                if(i!=numCards-1){
                    cards[i] = cards[i+1];  
                }
                else{
                    cards[i] = null; 
                }
            }  
            numCards--;
            return returnCard; 
        }
        return null;   
    }

    //toString() method called automatically for formatting
    public String toString(){
        String str = ""; 
        for(int i = 0; i<numCards; i++){
            if(i!=numCards-1){
                str += cards[i].toString() + " "; 
            }
            else{
                str += cards[i].toString(); 
            }
        }
        return str; 

    }

    public static void main(String[] args){
        //test class
        Hand hand = new Hand(10);
        hand.add(new Card(0, 9)); 
        hand.add(new Card(0, 4));
        hand.add(new Card(0, 10));
        hand.add(new Card(0, 2));
        hand.add(new Card(0, 0));
        System.out.println(hand); 
        System.out.println("Number of cards = "+hand.length());
        System.out.println(hand.remove(1)); 
        System.out.println(hand); 
        System.out.println(hand.remove(3)); 
        System.out.println(hand);   
        System.out.println(hand.get(5)); 
        System.out.println(hand.get(3));
        System.out.println(hand.get(0));
        
        hand = new Hand(10);
        System.out.println(hand.remove(0)); 
         
    }



}
