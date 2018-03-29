import java.util.Scanner;

public class BlackJack
{
    public static void main(String[] args) {
        //set player name
        Scanner reader = new Scanner(System.in);
        System.out.println("What is your name");
        String playerName = reader.next();
        
        Game g = new Game("playerName");
        g.play();
    }
}
