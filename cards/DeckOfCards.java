import java.util.*;
public class DeckOfCards {
    
    public String[] cards;
    private String[] suits;
    private String[] values;
    public static void main (String args[]) {
        DeckOfCards deck=new DeckOfCards();
        deck.shuffler();
        for (int i=0; i<52; i++) {
            System.out.println(deck.cards[i]);
        }
        
        
        
    
    }
    public DeckOfCards()
    {
        suits=new String[]{"clubs", "diamonds", "hearts", "spades"};
        values=new String[]{"2", "3", "4", "5","6","7","8","9","10","J","Q","K","A"};
        cards=new String[52];
        int counter=0;
        for (int i=0; i<suits.length; i++) {
            
            
            for (int j=0; j<values.length; j++) {
                cards[counter]=suits[i]+values[j];
                counter++;
                
            }
            
        }
        
    }
    
    public void shuffler() { //shuffle deck of cards
        Random r= new Random();
        for (int i=0; i<52; i++) {
            int num=r.nextInt(52);
            String temp=cards[num];
            cards[num]=cards[i];
            cards[i]=temp;
            
            
        
        }
    }

}

