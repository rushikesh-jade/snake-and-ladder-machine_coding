import model.Entity;
import service.SnakeAndLadderService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
            1. Create a Entity for snake, ladder and player
            2. Create Dice class which return random number between 1 to 6
            3. Accept number of snakes, ladders and player input from user
            4. Create service class with Rules -
                - Each player rolls the dice when their turn comes.
                - Based on the dice value, the player moves their piece forward that number of cells
                - A player wins if it exactly reaches the position 100 and the game ends there.
                - After the dice roll, if a piece is supposed to move outside position 100, it does not move.
                - Whenever a piece ends up at a position with the start of the ladder, the piece should go up to the position of the end of that ladder.
                - There could be another snake/ladder at the tail of the snake or the end position of the ladder and the piece should go up/down accordingly.
         */

        Entity entity = new Entity();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of snakes: ");
        int numberOfSnakes = scanner.nextInt();
        for (int i = 0; i < numberOfSnakes; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            entity.setSnakes(start, end);
        }

        System.out.print("Enter number of ladders: ");
        int numberOfLadders = scanner.nextInt();
        for (int i = 0; i < numberOfLadders; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            entity.setLadders(start, end);
        }

        System.out.print("Enter number of players: ");
        int numberOfPlayers = scanner.nextInt();
        for (int i = 0; i < numberOfPlayers; i++) {
            String playerName = scanner.next();
            entity.setPlayers(i, playerName);
        }

        SnakeAndLadderService game = new SnakeAndLadderService(entity);
        game.start();

    }
}