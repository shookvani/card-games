import java.util.*;
//import DeckOfCards;
public class War {
    //ArrayList<String>[] cardhand;
    static ArrayList<String> hand1;
    static ArrayList<String> hand2;
    static DeckOfCards deck;
    
    public static void main(String[] args) {
        War game= new War();
         /*for (int i=0; i<hand1.size(); i++) {
            System.out.println(hand1.get(i));
        }
        System.out.println("");
        for (int i=0; i<hand2.size(); i++) {
            System.out.println(hand2.get(i));
        }
        /*for (int i=0; i<52; i++) {
            System.out.println(deck.cards[i]);
        }*/
        while (hand1.size()>0 && hand2.size()>0) {
            game();
        }
        if (hand1.size()==0) {
            System.out.println("Player 2 wins");
        }
        else { 
            System.out.println("Player 1 wins");
        }

        
    }
    
    public War(/*int players*/) {
        deck= new DeckOfCards();
        deck.shuffler();
        hand1=new ArrayList<String>();
        hand2=new ArrayList<String>();
        dealer();
        
        
    }
    private static void dealer() {
        for (int i=0; i<52; i++) {
            if (i%2==0) {
                hand1.add(deck.cards[i]);
            }
            else {
                hand2.add(deck.cards[i]);
            }
        }
    }

    private static void game() {
        String card1= hand1.remove(0);
        String card2=hand2.remove(0);
        //System.out.println(card1);
        //System.out.println(card2);
        int value1=makeNumber(card1);
        int value2=makeNumber(card2);
        //System.out.println(value1);
        //System.out.println(value2);
        System.out.println("player 1"+card1);
        System.out.println("player 2"+card2);
        int comparison=compare(value1, value2);
        if (comparison==0) {
            System.out.println("Player 2 wins");
            hand2.add(card1);
            hand2.add(card2);

        }
        else if (comparison==1) {
            System.out.println("Player 1 wins");
            hand1.add(card1);
            hand1.add(card2);
            
        }
        else {
            /*if (hand1.length()<4 && hand2.length<4) {
                //game draw
            }
            else if (hand1.length()<4) {
                //game over
            }
            else if (hand2.length()<4) {
                    //game over
                    */
            ArrayList<String> storage=new ArrayList<String>();
            storage.add(card1);
            storage.add(card2);
            //while loop: while compare value1, value2==2 ---- check lengtth of hands, rmv 4 cards, add total 8 cards to array list-----compare 4 cards from each hand ------- will tell if we need to keep going in a while loop, once outside of loop, add cards to winning hand
            while (value1==value2) {

                System.out.println("War");
                if (hand1.size()<4 && hand2.size()<4) {
                     System.exit(0);
                }
                else if (hand1.size()<4) {
                    System.exit(0);
                }
                else if (hand2.size()<4) {
                       System.exit(0);
                }

                String warcards1_1= hand1.remove(0);
                String warcards2_1=hand2.remove(0);
                String warcards1_2= hand1.remove(0);
                String warcards2_2=hand2.remove(0);
                String warcards1_3= hand1.remove(0);
                String warcards2_3=hand2.remove(0);
                String warcards1_4= hand1.remove(0);
                String warcards2_4=hand2.remove(0);
                value1=makeNumber(warcards1_4);
                value2=makeNumber(warcards2_4);
                storage.add(warcards1_1);
                storage.add(warcards1_2);
                storage.add(warcards1_3);
                storage.add(warcards1_4);
                storage.add(warcards2_1);
                storage.add(warcards2_2);
                storage.add(warcards2_3);
                storage.add(warcards2_4);
                System.out.println("player 1"+warcards1_4);
                System.out.println("player 2"+warcards2_4);
                 if (value1<value2) {
                    //card 2 wins
                    hand2.addAll(storage);
                    System.out.println("2 wins War");
                    break;
                }
                else if (value1>value2) {
                    //card 1 wins
                    System.out.println("1 wins War");
                    hand1.addAll(storage);
                    break;
                }

            }
        }


    }
    private static int compare(int v1, int v2) {
        if (v1<v2) {
            return 0;
        }
        else if (v1>v2) {
            return 1;
        }
        else {
            return 2;
        }


    }
    private static int makeNumber(String c) {

        switch (c.substring(c.length()-1)) {
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                break;

        }
        return Integer.parseInt(c.replaceAll("\\D+", ""));

    }
}
