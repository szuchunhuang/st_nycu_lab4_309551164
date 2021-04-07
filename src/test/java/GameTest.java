import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    static Stream<Arguments> playerProvider() {
        return Stream.of(
            Arguments.of(new String[]{"scissors", "scissors"}, new String("Draw")),
            Arguments.of(new String[]{"scissors", "rock"}, new String("Player2 wins!")),
            Arguments.of(new String[]{"scissors", "paper"}, new String("Player1 wins!")),
            Arguments.of(new String[]{"rock", "scissors"}, new String("Player1 wins!")),
            Arguments.of(new String[]{"rock", "rock"}, new String("Draw")),
            Arguments.of(new String[]{"rock", "paper"}, new String("Player2 wins!")),
            Arguments.of(new String[]{"paper", "scissors"}, new String("Player2 wins!")),
            Arguments.of(new String[]{"paper", "rock"}, new String("Player1 wins!")),
            Arguments.of(new String[]{"paper", "paper"}, new String("Draw"))
        );
    }

    @ParameterizedTest(name="#{index} - Test with Argument={0},{1}")
    @MethodSource("playerProvider")
    void play_game_Test(String[] input_player, String expected_result) {
        Game game = new Game();
        String result = game.play_game(input_player[0], input_player[1]);
        assertEquals(expected_result, result);
    }

    @Test
    void check_IllegalArgumentException_Test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game();
            game.check_IllegalArgumentException("fruit");
            game.check_IllegalArgumentException("apple");
            game.check_IllegalArgumentException("banana");
        });
        Assertions.assertDoesNotThrow(() -> {
            Game game = new Game();
            game.check_IllegalArgumentException("scissors");
            game.check_IllegalArgumentException("rock");
            game.check_IllegalArgumentException("paper");

        });
    }
}

