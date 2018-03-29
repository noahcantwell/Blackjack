
public class Card
{
    private String suit;
    //4 major suits
    private String rank;
    //type of card
    private int value;
    //blackjack card value
    
    //Card constructor
    public Card(String cardSuit, String cardRank) {
        this.suit = cardSuit;
        this.rank = cardRank;
        sortFaces(cardRank);
    }
    
    public void sortFaces(String face) {
        //sets card blackjack value based on card name
        if((rank == "Queen") || (rank == "King") || (rank == "Jack")) {
            this.value = 10;
        }
        else if (rank == "Ace") {
            this.value = 11;
        }
        else {
            this.value = Integer.parseInt(face);
        }   
    }
    
    public String getSuit() {
        return this.suit;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public String getRank() {
        return this.rank;
    }
    
    public String toString() {
        return (rank + " of " + suit + ", Value = " + value);
    }
}
