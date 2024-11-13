package service;

import model.Entity;
import model.Dice;

import java.util.HashMap;

public class SnakeAndLadderService {
    private Entity entity;
    private HashMap<String, Integer> playersLatestHistory;
    private Dice dice;

    public SnakeAndLadderService(Entity entity) {
        this.playersLatestHistory = new HashMap<>();
        this.entity = entity;
        this.dice = new Dice();
    }

    public void start() {
        initializePlayerPosition();
        int playerId = -1;

        do {
            playerId++;

            if (playerId >= entity.getPlayers().size()) {
                playerId = 0;
            }

            String playerName = entity.getPlayers().get(playerId);
            StringBuilder stringBuilder = new StringBuilder();
            int diceNumber = dice.rollDice();
            int playerEndPosition = playersLatestHistory.get(playerName) + diceNumber;

            stringBuilder.append(playerName)
                    .append(" rolled a ")
                    .append(diceNumber)
                    .append(" and moved from ")
                    .append(playersLatestHistory.get(playerName));

            if (playerEndPosition <= 100) {
                if (entity.getSnakes().get(playerEndPosition) != null) {
                    // snake ate player
                    int newPosition = entity.getSnakes().get(playerEndPosition);
                    stringBuilder.append(" to ")
                            .append(newPosition)
                            .append(" - snake ate player");
                    playersLatestHistory.put(playerName, newPosition);
                }
                else if (entity.getLadders().get(playerEndPosition) != null) {
                    // player can climb the ladder
                    int newPosition = entity.getLadders().get(playerEndPosition);
                    stringBuilder.append(" to ")
                            .append(newPosition)
                            .append(" - player climb ladder");
                    playersLatestHistory.put(playerName, newPosition);
                }
                else {
                    // no snakes or ladder, increase position normally
                    stringBuilder.append(" to ").append(playerEndPosition);
                    playersLatestHistory.put(playerName, playerEndPosition);
                }
            }
            System.out.println(stringBuilder);
        } while (!checkIfPlayerPositionIs100(entity.getPlayers().get(playerId)));

        System.out.println(entity.getPlayers().get(playerId) + " won the game.");
    }

    private boolean checkIfPlayerPositionIs100(String playerName) {
        return playersLatestHistory.get(playerName) == 100;
    }

    private void initializePlayerPosition() {
        for(int i = 0; i < entity.getPlayers().size(); i++){
            playersLatestHistory.put(entity.getPlayers().get(i), 0);
        }
    }
}
