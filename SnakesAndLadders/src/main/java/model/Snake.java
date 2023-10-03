package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Snake implements SnakeOrLadder {

    private int start;

    private int end;

    private String id;
}
