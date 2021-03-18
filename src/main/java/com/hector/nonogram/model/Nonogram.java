package com.hector.nonogram.model;

public class Nonogram {
    private int size;
    private int[][] verticalClues;
    private int[][] horizontalClues;
    private char[][] grid;

    public Nonogram(int size, int[][] verticalClues, int[][] horizontalClues, char[][] grid) {
        this.size = size;
        this.verticalClues = verticalClues;
        this.horizontalClues = horizontalClues;
        this.grid = grid;
    }

    public int getSize() {
        return size;
    }

    public int[][] getVerticalClues() {
        return verticalClues;
    }

    public int[][] getHorizontalClues() {
        return horizontalClues;
    }

    public char[][] getGrid() {
        return grid;
    }
}
