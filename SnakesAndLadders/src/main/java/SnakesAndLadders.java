import model.Player;
import service.BoardService;
import service.DiceService;
import service.GameService;
import service.impl.BoardServiceImpl;
import service.impl.DiceServiceImpl;
import service.impl.GameServiceImpl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SnakesAndLadders {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Setting up game board.");
        System.out.println("Enter board dimension:");
        int dimension = scanner.nextInt();
        System.out.println("Enter the number of players:");
        int playersCount = scanner.nextInt();
        Queue<Player> playerQueue = new LinkedList<>();
        try {
            while (playersCount != 0) {
                System.out.println("Enter player name:");
                String name = scanner.nextLine();;
                Player player = new Player(name, 0);
                --playersCount;
                playerQueue.add(player);
            }
            DiceService diceService = new DiceServiceImpl(6);
            BoardService boardService = BoardServiceImpl.builder().dimension(dimension).build();
            GameService gameService = GameServiceImpl.builder()
                .diceService(diceService)
                .boardService(boardService)
                .build();
            gameService.setPlayers(playerQueue);
            System.out.println("Game board setup completed.");
            System.out.println("Starting game.");
            gameService.startGame();
        } catch (Exception ex) {
            System.out.println("Exiting game! Cause: " + ex.getMessage());
        }
    }
}
