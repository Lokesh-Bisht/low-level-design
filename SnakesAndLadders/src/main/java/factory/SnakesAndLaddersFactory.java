package factory;

import enums.GameConstants;
import model.Ladder;
import model.Snake;
import model.SnakeOrLadder;

public abstract class SnakesAndLaddersFactory {

    public static SnakeOrLadder setSnakesAndLaddersFactory(String type, String id, int start, int end) {
        if (type.equals(GameConstants.SNAKE.name())) {
            return new Snake(start, end, id);
        } else if (type.equals(GameConstants.LADDER.name())) {
            return new Ladder(start, end, id);
        }
        return null;
    }
}
