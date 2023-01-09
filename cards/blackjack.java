import java.util.*;
//import org.apache.commons.lang3.ArrayUtils;
//import DeckOfCards;
public class Blackjack {
    //ArrayList<String>[] cardhand;
    static ArrayList<String> hand1;
    static ArrayList<String> hand2;
    static ArrayList<String> shared;
    static DeckOfCards deck;
    static String input;
    static Boolean num;
    static int usersum;
    static int dealsum;
    
    public static void main(String[] args) {
        blackjack game= new blackjack();
        game();
           
    }
    
    public Blackjack(/*int players*/) {
        deck= new DeckOfCards();
        deck.shuffler();
        hand1=new ArrayList<String>();
        hand2=new ArrayList<String>();
        shared=new ArrayList<String>();         
    }


    private static void game() {
        num=false;
        dealer();
        showhand();
        while (num==false) {
            hit();
            showhand();
        }
        if (usersum>21) {
            System.out.println("game over");
            return;
        }
        hitD();

        if (dealsum>21 || usersum>dealsum) {
            System.out.println("game over, user wins");
            return;
        }
        else {
            System.out.println("game over, dealer wins");
            return;
        }
       
    }

    private static int handsumD() {
        ArrayList<String> cardvalue= new ArrayList<String>();
        int sum=0;
        int counter=0;
        for (int i=0; i<hand2.size(); i++) {
            int x= makeNumber(hand2.get(i));
            if (makeNumber(hand2.get(i))==11) {
                counter++;
            }
            //Integer.parseInt(i);
            sum=sum+x;
            //System.out.println(sum);

        }


        while (sum>21 && counter >=1) {
            sum=sum-10;
            counter--;
                
        }
        dealsum=sum;
        //System.out.println("hi"+dealsum);
        return sum;
     }



     private static int handsumP() {
        ArrayList<String> cardvalue= new ArrayList<String>();
        int sum=0;
        int counter=0;
        for (int i=0; i<hand1.size(); i++) {
            int x= makeNumber(hand1.get(i));
            if (makeNumber(hand1.get(i))==11) {
                counter++;
            }
            //Integer.parseInt(i);
            sum=sum+x;
            //System.out.println(sum);

        }
        
        while (sum>21 && counter >=1) {
            sum=sum-10;
            counter--;
                
        }
        usersum=sum;
        //System.out.println("hi"+usersum);
        return sum;
     }



     private static void hit() {
        Scanner scan = new Scanner(System.in); 
        System.out.println("Do you want to hit or stay?");
        String choice = scan.nextLine();
        if (choice.equals("hit")) {
            hand1.add(shared.get(0));
            shared.remove(0);
            //deck.cards=ArrayUtils.removeElement(deck.cards, deck.cards[0]);
        }
        handsumP();
        if (choice.equals("stay") || usersum>21) {
            num=true;

        }

     }

     private static void hitD() {
        dealsum=handsumD();
        while (dealsum<=17) {
            hand2.add(shared.get(0));
            shared.remove(0);
            handsumD();
        }
     }


    private static void showhand() {
         for (int i=0; i<hand1.size(); i++) {
            System.out.println(hand1.get(i));
        }
        System.out.println("Dealer:");
        System.out.println(hand2.get(0));
    }
    private static void cheathand() {
         for (int i=0; i<hand2.size(); i++) {
            System.out.println(hand2.get(i));
        }
    }

    private static void dealer() {

        for (int i=0; i<52; i++) {
            if (i<2) {
                hand1.add(deck.cards[i]);
            }
            else if (i<4) {
                hand2.add(deck.cards[i]);
            }
            else {
                shared.add(deck.cards[i]);
            }
        }


        /*for (int i=0; i<4; i++) {
            if (i<2) {
                hand1.add(deck.cards[i]);
            }
            else {
                hand2.add(deck.cards[i]);
            }
            
        }

        for (int i=0; i<4; i++) {

            //deck.cards=ArrayUtils.removeElement(deck.cards, deck.cards[0]);
        }*/

    }

    private static int makeNumber(String c) {

        switch (c.substring(c.length()-1)) {
            case "J":
                return 10;
            case "Q":
                return 10;
            case "K":
                return 10;
            case "A":
                return 11;
            default:
                break;

        }
        return Integer.parseInt(c.replaceAll("\\D+", ""));

    }
}



