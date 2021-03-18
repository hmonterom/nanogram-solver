package com.hector.nonogram.builder;

import com.hector.nonogram.model.Nonogram;

import java.util.List;

public class NonogramBuilder {
    private List<String> lines;

    public NonogramBuilder fromLines(List<String> lines) {
        this.lines = lines;
        return this;
    }

    public Nonogram build() {
        //size
        int size = Integer.parseInt(lines.get(0));
        //vertical clues
        int[][] verticalClues = new int[size][];
        for (int i = 1; i < size + 1; i++) {
            String[] split = lines.get(i).split(",");
            int[] clues = new int[split.length];
            for (int j = 0; j < split.length; j++) {
                clues[j] = Integer.parseInt(split[j]);
                verticalClues[i-1] = clues;
            }
        }
        //horizaontal clues
        int[][] horizontalClues = new int[size][];
        for (int i = 1+size; i < size + size + 1; i++) {
            String[] split = lines.get(i).split(",");
            int[] clues = new int[split.length];
            for (int j = 0; j < split.length; j++) {
                clues[j] = Integer.parseInt(split[j]);
                horizontalClues[i-size-1] = clues;
            }
        }
        char[][] grid = new char[size][size];
        for (int i = 1+size+size; i < size +size +size+1; i++) {
            char[] gridLine = lines.get(i).toCharArray();
            grid[i-size-size-1] = gridLine;
        }
        return new Nonogram(size, verticalClues, horizontalClues, grid);
    }
}
