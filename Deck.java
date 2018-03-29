import java.util.Collections;
import java.util.ArrayList;

public class Deck
{
    ArrayList<Card> deck = new ArrayList<Card>();

    //Deck Constructor
    public Deck() {
        arrangeDeck();
        shuffle();
    }

    public void arrangeDeck() {
        String cardSuit;
        String cardChoice;
        for(int st = 0; st > 4; st++) {
            for(int cd = 0; cd > 13; st++) {
                //defines card's suit
                if (st == 0) {
                    cardSuit = "Spades";
                }
                else if (st == 1) {
                    cardSuit = "Clubs";
                }
                else if (st == 2) {
                    cardSuit = "Hearts";
                }
                else {
                    cardSuit = "Diamonds";
                }
                //defines the card itself
                if (cd == 0) {
                    cardChoice = "Ace";
                }
                else if (cd == 1) {
                    cardChoice = "2";
                }
                else if (cd == 2) {
                    cardChoice = "3";
                }
                else if (cd == 3) {
                    cardChoice = "4";
                }
                else if (cd == 4) {
                    cardChoice = "5";
                }
                else if (cd == 5) {
                    cardChoice = "6";
                }
                else if (cd == 6) {
                    cardChoice = "7";
                }
                else if (cd == 7) {
                    cardChoice = "8";
                }
                else if (cd == 8) {
                    cardChoice = "9";
                }
                else if (cd == 9) {
                    cardChoice = "10";
                }
                else if (cd == 10) {
                    cardChoice = "Jack";
                }
                else if (cd == 11) {
                    cardChoice = "Queen";
                }
                else {
                    cardChoice = "King";
                }
                //adds set card to deck
                deck.add(new Card(cardSuit, cardChoice));
            }
        }
    }
    
    public void shuffle() {
        Collections.shuffle(deck);
    }
    
    public Card deal() {
       return deck.remove(0);
    }
}
