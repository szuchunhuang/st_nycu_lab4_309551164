public class Game {
    public void check_IllegalArgumentException(String input) {
        if (!input.equals("scissors") && !input.equals("rock") && !input.equals("paper")) {
            throw new IllegalArgumentException(input);
        }
    }

    String play_game(String player1, String player2) {
        if (player1.equals(player2)) {
            return "Draw";
        } else if (player1.equals("scissors")) {
            if (player2.equals("rock")) {
                return "Player2 wins!";
            } else {
                return "Player1 wins!";
            }
        } else if (player1.equals("rock")) {
            if (player2.equals("scissors")) {
                return "Player1 wins!";
            } else {
                return "Player2 wins!";
            }
        } else if (player1.equals("paper")) {
            if (player2.equals("rock")) {
                return "Player1 wins!";
            } else {
                return "Player2 wins!";
            }
        }
        return "ERROR!";
    }

}
