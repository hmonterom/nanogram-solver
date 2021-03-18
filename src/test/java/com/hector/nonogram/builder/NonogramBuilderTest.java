package com.hector.nonogram.builder;

import com.hector.nonogram.model.Nonogram;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class NonogramBuilderTest {

    NonogramBuilder builder;

    @Test
    public void testLoad5sizePuzzle() throws IOException {
        File puzzleFile = new File(".\\src\\test\\resources\\id8041890size5.txt");
        List<String> lines = Files.lines(puzzleFile.toPath()).collect(Collectors.toList());

        Nonogram nonogram = new NonogramBuilder().fromLines(lines).build();

        assertEquals(nonogram.getSize(), 5, "Failed size assert");
        assertEquals(nonogram.getVerticalClues(), new int[][]{{1}, {1, 1, 1}, {2}, {4}, {3}}, "Failed vert assert");
        assertEquals(nonogram.getHorizontalClues(), new int[][]{{2}, {2}, {1, 2}, {3}, {3}}, "Failed hori assert");
        assertEquals(nonogram.getGrid(), new char[][]{{'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.'}},
                "Failed grid assert");
    }
}