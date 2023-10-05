package service;

import model.Ladder;
import model.Snake;

import java.util.List;

public interface BoardService {

    int getTotalCells();
    boolean hasSnake(int position);
    boolean hasLadder(int position);
    Snake getSnake(int position);
    Ladder getLadder(int position);
    void setSnake(int id, int start, int end);
    void setLadder(int id, int start, int end);
    void printBoard();
}
