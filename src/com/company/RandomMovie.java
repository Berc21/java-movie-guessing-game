package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RandomMovie {

    private List<String> movies;

    public RandomMovie(String fileName) {
        movies = new ArrayList();
        File file = new File(fileName);
        try {
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String word = input.nextLine();
                movies.add(word);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exist!");
        }

    }

    public String getRandomMovie() {
        int movieIndex = (int) (Math.random() * movies.size());
        final String movie = movies.get(movieIndex);

        return movie;
    }

}
