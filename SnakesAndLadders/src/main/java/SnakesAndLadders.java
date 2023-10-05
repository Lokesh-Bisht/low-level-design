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

    private static final int DEFAULT_NO_OF_DICES = 1;

    private static final int DEFAULT_BOARD_DIMENSION = 10;

    public static BoardService setGameBoard(Scanner scanner) {
        System.out.println("Setting up game board.");
        BoardService boardService = BoardServiceImpl.builder().dimension(DEFAULT_BOARD_DIMENSION).build();
        System.out.println("Enter number of snakes: ");
        int numberOfSnakes = scanner.nextInt();
        for (int i = 0; i < numberOfSnakes; ++i) {
            System.out.println("Provide starting and ending points for Snake" + (i + 1) + " :" );
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            boardService.setSnake(i + 1, start, end);
        }
        System.out.println("Enter number of snakes");
        int numberOfLadders = scanner.nextInt();
        for (int i = 0; i < numberOfLadders; ++i) {
            System.out.println("Provide starting and ending points for ladder" + (i + 1) + " :" );
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            boardService.setLadder(i + 1, start, end);
        }
        System.out.println("Game board setup completed.");
        return boardService;
    }

    public static Queue<Player> setPlayers(Scanner scanner) {
        System.out.println("Start adding players to the game.");
        System.out.println("Enter the number of players:");
        int playersCount = scanner.nextInt();
        Queue<Player> playerQueue = new LinkedList<>();
        while (playersCount != 0) {
            System.out.println("Enter player's name:");
            String name = scanner.nextLine();
            Player player = new Player(name, 0);
            --playersCount;
            playerQueue.add(player);
        }
        System.out.println("Completed adding players to the game.");
        return playerQueue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DiceService diceService = new DiceServiceImpl(DEFAULT_NO_OF_DICES * 6);
        BoardService boardService = setGameBoard(scanner);
        Queue<Player> playerQueue = setPlayers(scanner);
        GameService gameService = GameServiceImpl.builder()
            .diceService(diceService)
            .boardService(boardService)
            .build();
        try {
            gameService.setPlayers(playerQueue);
            System.out.println("Starting game ...");
            gameService.startGame();
        } catch (Exception ex) {
            System.out.println("Exiting game! Cause: " + ex.getMessage());
        }
    }
}
