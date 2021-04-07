import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner player1 = new Scanner(System.in);
        System.out.println("Player1 choose (scissors, rock or paper): ");
        String player1_choice = player1.nextLine();

        Scanner player2 = new Scanner(System.in);
        System.out.println("Player2 choose (scissors, rock or paper): ");
        String player2_choice = player2.nextLine();

        // call Game.java
        Game game = new Game();
        game.check_IllegalArgumentException(player1_choice);
        game.check_IllegalArgumentException(player2_choice);
        String result = game.play_game(player1_choice, player2_choice);
        System.out.println(result);
    }
}
