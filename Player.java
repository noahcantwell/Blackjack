
import java.util.ArrayList;

public class Player
{
    private String name;
    private int money;
    private ArrayList<Card> hand = new ArrayList<Card>();
    private int handTotal;
    private boolean hasAce = false;
    
    //constructor
    public Player(String nm, int mny)
    {
        this.name = nm;
        this.money = mny;
    }
    
    public String getName() {
        return this.name;
    }
    
    public ArrayList getHand() {
        return this.hand;
    }
    
    public int getMoney() {
        return this.money;
    }
    
    public void setName(String newName) {
        this.name = newName;
    }
    
    public void bet(int betAmt) {
        this.money -= betAmt;
    }
    
    public void addCard(Card c) {
        hand.add(c);
    }

    public int calculateHand() {
        int total = 0;
        for (Card object: hand) {
            total += object.getValue();
            if (object.getRank() == "Ace") {
                hasAce = true;
            }
        }
        if (total > 21 && hasAce == true) {
            total -= 10;
        }
        return total;
    }
}
