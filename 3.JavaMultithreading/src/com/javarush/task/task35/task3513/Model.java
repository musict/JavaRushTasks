package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    int score;
    int maxTile;
    private Stack previousStates = new Stack();
    private Stack previousScores = new Stack();
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
    }

    public void resetGameTiles() {
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
        score = 0;
        maxTile = 2;
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (emptyTiles.size() != 0 && emptyTiles != null) {
            emptyTiles.get((int) (Math.random() * emptyTiles.size())).value = (Math.random() < 0.9 ? 2 : 4);
        }
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> result = new ArrayList<>();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                if (gameTiles[i][j].isEmpty()) {
                    result.add(gameTiles[i][j]);
                }
            }
        }
        return result;
    }

    //ряд {4, 2, 0, 4} становится рядом {4, 2, 4, 0}
    private boolean compressTiles(Tile[] tiles) {
        int counter = 0;
        boolean isChanged = false;
        int values[] = new int[tiles.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = 0;
        }

        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i].value != 0) {
                values[counter] = tiles[i].value;
                counter++;
            }
        }

        for (int i = 0; i < tiles.length; i++) {
            if (values[i] != tiles[i].value) {
                isChanged = true;
            }
            tiles[i].value = values[i];
        }

        return isChanged;

    }

    // ряд {4, 4, 2, 0} становится рядом {8, 2, 0, 0}.
    private boolean mergeTiles(Tile[] tiles) {
        boolean isChanged = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value == tiles[i + 1].value && tiles[i].value != 0) {
                tiles[i].value = tiles[i].value * 2;
                score = score + tiles[i].value;
                if (tiles[i].value > maxTile) {
                    maxTile = tiles[i].value;
                }
                for (int j = 2; j <= tiles.length - i; j++) {
                    try {
                        tiles[i + j - 1].value = tiles[i + j].value;
                    } catch (Exception e) {
                        tiles[i + j - 1].value = 0;
                        isChanged = true;
                    }
                }
            }
        }
        return isChanged;
    }

    private void rotate(Tile[][] arrayGameTiles) {
        int[][] values = new int[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                values[i][j] = arrayGameTiles[i][j].value;
            }
        }

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                arrayGameTiles[j][FIELD_WIDTH - i - 1].value = values[i][j];
            }
        }
    }

    public void left() {
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        boolean isChanged = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i])) {
                isChanged = true;
            }
            if (mergeTiles(gameTiles[i])) {
                isChanged = true;
            }
        }
        if (isChanged) {
            addTile();
        }

        isSaveNeeded = true;
    }

    public void up() {
        saveState(gameTiles);
        rotate(gameTiles);
        rotate(gameTiles);
        rotate(gameTiles);
        left();
        rotate(gameTiles);
    }

    public void right() {
        saveState(gameTiles);
        rotate(gameTiles);
        rotate(gameTiles);
        left();
        rotate(gameTiles);
        rotate(gameTiles);
    }

    public void down() {
        saveState(gameTiles);
        rotate(gameTiles);
        left();
        rotate(gameTiles);
        rotate(gameTiles);
        rotate(gameTiles);
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public boolean canMove() {
        if (!getEmptyTiles().isEmpty()) return true;
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j - 1].value)
                    return true;
            }
        }
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[j][i].value == gameTiles[j - 1][i].value) return true;
            }
        }
        return false;
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] pushTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                pushTiles[i][j] = new Tile(tiles[i][j].value);
            }

        }
        previousStates.push(pushTiles);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousScores.empty() && !previousStates.empty()) {
            gameTiles = (Tile[][]) previousStates.pop();
            score = (int) previousScores.pop();
        }

    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n) {
            case 0: left(); break;
            case 1: right(); break;
            case 2: up(); break;
            case 3: down(); break;
        }
    }

    public boolean hasBoardChanged() {
        int sumValuesGameTiles = 0;
        int sumValuesStackGameTiles = 0;

        for (Tile[] gameTile : gameTiles) {
            for (Tile tile : gameTile) {
                sumValuesGameTiles += tile.value;
            }
        }
        for (Tile[] gameTile : (Tile[][]) previousStates.peek()) {
            for (Tile tile : gameTile) {
                sumValuesStackGameTiles += tile.value;
            }
        }
        return sumValuesGameTiles != sumValuesStackGameTiles;

    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        MoveEfficiency movEff = null;
        move.move();

        if (!hasBoardChanged()) {
            movEff = new MoveEfficiency(-1 ,0 ,move);
        } else {
            movEff = new MoveEfficiency(getEmptyTiles().size() ,score ,move);
        }
        rollback();
        return movEff;
    }

    public void autoMove() {
        PriorityQueue queue = new PriorityQueue(4, Collections.<MoveEfficiency>reverseOrder());
        queue.add(getMoveEfficiency(this::randomMove));
        queue.offer(getMoveEfficiency(this::right));
        queue.offer(getMoveEfficiency(this::up));
        queue.offer(getMoveEfficiency(this::down));
        MoveEfficiency efficientMove = (MoveEfficiency) queue.poll();
        efficientMove.getMove().move();
    }
}
