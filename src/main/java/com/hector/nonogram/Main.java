package com.hector.nonogram;

import com.hector.nonogram.builder.NonogramBuilder;
import com.hector.nonogram.model.Nonogram;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Nanogram Solver");

        List<File> filesList = Files.walk(Paths.get(".\\src\\main\\resources\\"))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .collect(Collectors.toList());

        System.out.println("Following puzzles were found:");
        int i = 0;
        for (File file : filesList) {
            i++;
            System.out.println(i + ". " + file);
        }

        System.out.println("Choose your puzzle: ");
        int puzzleNumber = System.in.read() -1;

        if (puzzleNumber < filesList.size()) {
            File puzzleFile = filesList.get(puzzleNumber);
            List<String> lines = Files.lines(puzzleFile.toPath()).collect(Collectors.toList());
            Nonogram nonogram = new NonogramBuilder().fromLines(lines).build();
        } else {
            System.out.println("Incorrect option");
        }


    }
}
