package model;

import java.util.HashMap;

public class Entity {

    private HashMap<Integer, Integer> snakes;
    private HashMap<Integer, Integer> ladders;
    private HashMap<Integer, String> players;

    public Entity() {
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();
        this.players = new HashMap<>();
    }

    public HashMap<Integer, Integer> getSnakes() {
        return snakes;
    }

    public void setSnakes(int startPosition, int endPosition) {
        this.snakes.put(startPosition, endPosition);
    }

    public HashMap<Integer, Integer> getLadders() {
        return ladders;
    }

    public void setLadders(int startPosition, int endPosition) {
        this.ladders.put(startPosition, endPosition);
    }

    public HashMap<Integer, String> getPlayers() {
        return players;
    }

    public void setPlayers(int startPosition, String playerName) {
        this.players.put(startPosition, playerName);
    }
}
