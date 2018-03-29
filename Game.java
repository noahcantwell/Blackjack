import java.util.Scanner;

public class Game
{
    // instance variables - replace the example below with your own
    private Player p = new Player("plyr", 100);
    private Player d = new Player("Dealer", 0);
    Deck gameDeck = new Deck();
    Scanner reader = new Scanner(System.in);
    private Player winner = null;
    
    public Game(String playerName)
    {
        p.setName(playerName);
    }
    
    public void play() {
        //deal opening two cards
        dealTwoCards(p);
        dealTwoCards(d);
        
        //tell player about hand
        System.out.println("Your hand is " + p.getHand());
        System.out.println("Your hand is worth " + p.calculateHand());
        
        //player decides bet
        System.out.println("How much do you want to bet");
        int betAmt = reader.nextInt();
        p.bet(betAmt);
        
        //player decides to hit or stay
        System.out.println("'hit' or 'stay'");
        String response = reader.next();
        
        //player can hit/stay
        while (response == "hit" && p.calculateHand()<22) {
            //player can only hit if not already busted
            hit(p);
            System.out.println("Your hand is " + p.getHand());
            System.out.println("Your hand is worth " + p.calculateHand());
            System.out.println("'hit' or 'stay'");
            response = reader.next();
        }
        
        //dealer's turn, after player has either busted or stayed
        dealerTurn();
        
        //determine who is the winner
        tellWinner();
        
        if (winner == p) {
            //player wins
            System.out.println("You won");
            //bet negative money, AKA instead of losing betting money,
            //player gains twice betting money
            p.bet(-2 * betAmt);
            System.out.println("Your money is " + p.getMoney());
        }
        else {
            //dealer wins/player loses
            System.out.println("You lost");
            System.out.println("Your money is " + p.getMoney());
        }
    }
    
    public void dealTwoCards(Player plr) {
        plr.addCard(gameDeck.deal());
        plr.addCard(gameDeck.deal());
    }

    public void dealerTurn() {
        while (d.calculateHand() < 17) {
            hit(d);
        }
    }
    
    public void tellWinner() {
        if (p.calculateHand() > 21) {
            winner = d;
        }
        else if (d.calculateHand() > 21) {
            winner = p;
        }
        else if (p.calculateHand() > d.calculateHand()) {
            winner = p;
        }
        else {
            winner = d;
        }
    }
    
    public void hit(Player plr) {
        plr.addCard(gameDeck.deal()); 
    }
}
