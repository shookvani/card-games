import java.util.*;
import javax.swing.*;
//import DeckOfCards;
public class gofish {
    //ArrayList<String>[] cardhand;
    static ArrayList<String> hand1;
    static ArrayList<String> hand2;
    static ArrayList<String> shared;
    static DeckOfCards deck;
    static String input;
    static int playercount;
    static int computercount;
    static boolean checker=true;
    static Scanner scan= new Scanner(System.in);
    static String card="";
    static int playerscore;
    static int dealerscore;
    
    public static void main(String[] args) {
    	gofish game= new gofish();
    	while (checker==true ){
	        playgame();
	    }

        
         
    }
    
    public gofish(/*int players*/) {
    	/*System.out.println(hand1.size());
        deck= new DeckOfCards();
        deck.shuffler();
        hand1=new ArrayList<String>();
        hand2=new ArrayList<String>();
        shared=new ArrayList<String>();
        dealer();
        System.out.println("before^ | afterv");
        System.out.println(hand1.size());  */
        
    }


    private static void playgame() {
        reset();
        showhand();
        while (checker==true) {
        	if (hand1.size()>0) {
           	 System.out.println("What number card do you want to fish for? (ex. 2, 3, Q, K, A) If you want to fish for 10, type 0. "); 
           	 input= scan.next();
	           	 if (hand2.size()==0 && shared.size()==0) {
	    			break;

	    		}
            	searchhanddealer();
	            checkplayer();
	           	

           	}
           	else {
           		if (shared.size()>=5) {
           			//move cards from share to hand
           			hand1.add(fish());
           			hand1.add(fish());
           			hand1.add(fish());
           			hand1.add(fish());
           			hand1.add(fish());
           		}
           		else if(shared.size()>0) {
           			//what to do if not enough cards in shared
           			int x=shared.size();
           			for (int i=0; i<x; i++) {
           				hand1.add(fish());
           			}
           		}
           		else {
           			//0 cards
           			checker=false;
           			break;
           		}

           	}

           	if (hand2.size()>0) {
            
	            if (hand1.size()==0 && shared.size()==0) {
	    			break;

	    		}
	            showhand();
	      		pickcard();
	      		if (hand1.size()==0 && shared.size()==0) {
	    			break;

	    		}
	            searchhandplayer();
	            checkdealer();
	           	

           }
           else {
	           	if (shared.size()>=5) {
	           			//move cards from share to hand
	           			hand2.add(fish());
	           			hand2.add(fish());
	           			hand2.add(fish());
	           			hand2.add(fish());
	           			hand2.add(fish());
	           		}
	           		else if(shared.size()>0) {
	           			//what to do if not enough cards in shared
	           			int x=shared.size();
	           			for (int i=0; i<x; i++) {
	           				hand2.add(fish());
	           			}
	           		}
	           		else {
	           			//0 cards
	           			checker=false;
	           			break;
	           		}

           }
            //showboth();
        }
        again();

       
    }

    

    private static void reset() {
        playercount=0;
        computercount=0;
        checker=true;
        //System.out.println(hand1.size());
        deck= new DeckOfCards();
        deck.shuffler();
        hand1=new ArrayList<String>();
        hand2=new ArrayList<String>();
        shared=new ArrayList<String>();
        dealer();
        //System.out.println("before^ | afterv");
        //System.out.println(hand1.size());
    }

    private static void again() {
    	if (playerscore>dealerscore) {
    		 System.out.println("Player wins");
    	}
    	else {
    		 System.out.println("Dealer wins");
    	}
        System.out.println("Want to play again? Type Y or N");
        String choice = scan.next();
        if (choice.equals("Y")) {
            checker=true;
            playgame();
        }
        else {
            checker=false;
        }
    }

    private static void checkplayer() {
       String x = hand1.get(hand1.size()-1);
       String y = x.substring(x.length()-1);
       int equal=0;
       ArrayList<String> temp= new ArrayList<String>();
       for (int i =0; i<hand1.size(); i++ ) {
            if(hand1.get(i).substring(hand1.get(i).length()-1).equals(y)) {
                equal++;
                temp.add(hand1.get(i));

           }
       }
       if (equal==4) {
            for (int i=0; i<temp.size(); i++) {
                hand1.remove(hand1.indexOf(temp.get(i)));
                playercount++;
                System.out.println("got4");
                System.out.println("");
                System.out.println(temp.get(i));
                System.out.println("");
                playerscore++;

            }
       }



    }



    private static void checkdealer() {
       String x = hand2.get(hand2.size()-1);
       String y = x.substring(x.length()-1);
       int equal=0;
       ArrayList<String> temp= new ArrayList<String>();
       for (int i =0; i<hand2.size(); i++ ) {
            if(hand2.get(i).substring(hand2.get(i).length()-1).equals(y)) {
                equal++;
                temp.add(hand2.get(i));

           }
       }
       if (equal==4) {
            for (int i=0; i<temp.size(); i++) {
                hand2.remove(hand2.indexOf(temp.get(i)));
                playercount++;
                System.out.println("got4");
                System.out.println("");
                System.out.println(temp.get(i));
                System.out.println("");
                dealerscore++;

            }
       }



    }


    
    private static void showboth() {
        showhand();
        System.out.println("xxxxx");
        cheathand();
        System.out.println("");
    }

    private static String fish() {
        return shared.remove(0);



    }

    private static void searchhanddealer() {
        ArrayList<String> cardvalue= new ArrayList<String>();

        for (int i=0; i<hand2.size(); i++) {
            //System.out.println(hand2.get(i));
            if (hand2.get(i).substring(hand2.get(i).length()-1).equals(input)) {
                //hands2[i] >> add it to an array list 
                hand1.add(hand2.get(i));
                cardvalue.add(hand2.get(i));
            }
        }
        if (cardvalue.size()>=1) {

            for (int i=0; i<cardvalue.size(); i++) {
                hand2.remove(hand2.indexOf(cardvalue.get(i)));
            }
        }
        else if (shared.size()>0) {
        	 hand1.add(fish());
        
        	
        }
           
    }


     private static void searchhandplayer() {
        ArrayList<String> cardvalue= new ArrayList<String>();

        for (int i=0; i<hand1.size(); i++) {
            //System.out.println(hand2.get(i));
            if (hand1.get(i).substring(hand1.get(i).length()-1).equals(card)) {
                //hands2[i] >> add it to an array list 
                hand2.add(hand1.get(i));
                cardvalue.add(hand1.get(i));
            }
        }
        if (cardvalue.size()>=1) {

            for (int i=0; i<cardvalue.size(); i++) {
                hand1.remove(hand1.indexOf(cardvalue.get(i)));
            }
        }
        else if (shared.size()>0) {
        	 hand2.add(fish());
        
        	
        }
    }

    private static void showhand() {
         for (int i=0; i<hand1.size(); i++) {
            System.out.println(hand1.get(i));
        }
    }
    private static void cheathand() {
         for (int i=0; i<hand2.size(); i++) {
            System.out.println(hand2.get(i));
        }
    }

    private static void dealer() {
        for (int i=0; i<52; i++) {
            if (i<5) {
                hand1.add(deck.cards[i]);
            }
            else if (i<10) {
                hand2.add(deck.cards[i]);
            }
            else {
                shared.add(deck.cards[i]);
            }
        }
    }


    private static void pickcard() {
    	
    	card=hand2.get(0).substring(hand2.get(0).length()-1);
    }

}

