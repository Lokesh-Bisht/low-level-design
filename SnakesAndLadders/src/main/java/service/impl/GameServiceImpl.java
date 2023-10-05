package service.impl;

import enums.GameStatus;
import exceptions.GameAlreadyStartedException;
import exceptions.PlayersLimitException;
import lombok.Builder;
import model.Player;
import service.BoardService;
import service.DiceService;
import service.GameService;

import java.util.Queue;

@Builder
public class GameServiceImpl implements GameService {

    private GameStatus gameStatus;

    private Queue<Player> players;

    private DiceService diceService;

    private BoardService boardService;

    @Override
    public void startGame() {
        gameStatus = GameStatus.RUNNING;
        boardService.printBoard();

        // Run until we have only one player left on the board
        while (players.size() > 1) {
            Player player = players.poll();
            makeMove(player);

            if (player.getPosition() == boardService.getTotalCells()) {
                System.out.println(player.getName() + " has completed the game!");
            } else {
                players.add(player);
            }
        }
        System.out.println("Game over!");
        gameStatus = GameStatus.FINISHED;
    }

    @Override
    public void makeMove(Player player) {
        System.out.println();
        System.out.println(player.getName() + "'s turn");
        System.out.println("Press enter to roll the dice.");

        int currentPosition = player.getPosition();
        int nextPosition = currentPosition + diceService.roll();

        if (nextPosition > boardService.getTotalCells()) {
            System.out.println("Invalid move.");
        } else {
            if (boardService.hasSnake(nextPosition)) {
                nextPosition = boardService.getSnake(nextPosition).getEnd();
            } else if (boardService.hasLadder(nextPosition)) {
                nextPosition = boardService.getLadder(nextPosition).getEnd();
            }
            player.setPosition(nextPosition);
        }
    }

    @Override
    public void setPlayers(Queue<Player> players) throws PlayersLimitException, GameAlreadyStartedException {
        if (gameStatus == GameStatus.NOT_STARTED) {
            if (players.size() > 4) {
                throw new PlayersLimitException("Maximum four players can play this game at a time.");
            }
            this.players.addAll(players);
        }
        throw new GameAlreadyStartedException("Game has already started!");
    }
}
