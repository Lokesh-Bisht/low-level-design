package service;

import exceptions.GameAlreadyStartedException;
import exceptions.PlayersLimitException;
import model.Player;

import java.util.Queue;

public interface GameService {

    void startGame();
    void makeMove(Player player);
    void setPlayers(Queue<Player> playerList) throws PlayersLimitException, GameAlreadyStartedException;
}
