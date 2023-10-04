package service.impl;

import lombok.Builder;
import model.Ladder;
import model.Snake;
import service.BoardService;

import java.util.HashMap;

@Builder
public class BoardServiceImpl implements BoardService {

    private int dimension;

    private HashMap<Integer, Snake> snakesHashMap;

    private HashMap<Integer, Ladder> laddersHashMap;

    @Override
    public int getTotalCells() {
        return dimension * dimension;
    }

    @Override
    public boolean hasSnake(int position) {
        return snakesHashMap.containsKey(position);
    }

    @Override
    public boolean hasLadder(int position) {
        return laddersHashMap.containsKey(position);
    }

    @Override
    public Snake getSnake(int position) {
        return snakesHashMap.get(position);
    }

    @Override
    public Ladder getLadder(int position) {
        return laddersHashMap.get(position);
    }

    @Override
    public void printBoard() {
        int totalCells = getTotalCells();

        for (int i = totalCells; i > 0; --i) {
            System.out.print("|" + i + " ");
            if (hasSnake(i)) {
                System.out.println(snakesHashMap.get(i).getId());
            } else if (hasLadder(i)) {
                System.out.println(laddersHashMap.get(i).getId());
            }
            System.out.print(" |");
            if (totalCells % 10 == 0) {
                System.out.println();
            }
        }
    }

}
