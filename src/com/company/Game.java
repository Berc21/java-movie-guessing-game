package com.company;

import java.util.Scanner;

public class Game {

    private String movieToGuess;
    private int pointsLost;
    private boolean isWin;
    private String correctLetters;
    private String wrongLetters;

    public Game(String filename) {
        RandomMovie randomMovie = new RandomMovie(filename);

        movieToGuess = randomMovie.getRandomMovie().trim();
        pointsLost = 0;
        correctLetters = "";
        wrongLetters = "";
        isWin = false;
    }

    public String getMovieToGuess() {
        return movieToGuess;
    }
    public String getWrongLetters() {
        return wrongLetters;
    }

    public boolean getIsWin() {
        return isWin;
    }

    public boolean isEnd() {
        if (pointsLost >= 10) {
            return true;
        }
        if(!underScoreMovie().contains("_")) {
            isWin = true;
            return true;
        }
        return false;
    }

    public String underScoreMovie() {
        if (correctLetters.equals("")) return movieToGuess.replaceAll("[a-zA-Z]", "_");

        else return movieToGuess.replaceAll("[a-zA-Z&&[^" + correctLetters + "]]", "_");
    }

    private String acceptLetter() {

        System.out.println("Guess a letter:");
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.nextLine().toLowerCase();
        if(!letter.matches("[a-z]")) {
            System.out.println("It's not even letter, please entet a letter between a to z");
            return acceptLetter();
        } else if (correctLetters.contains(letter) || wrongLetters.contains(letter)) {
            System.out.println("You have alreadt tried this " + letter + "letter" );
            return acceptLetter();
        } else {
            return letter;
        }
    }

    public void startGame() {
        System.out.println("Welcome to Guess the Movie!");
        System.out.println("Rules:, the System randomly picks a movie, and gives you tips about it.");
        System.out.println("Your goal is guessing movie letter by letter.");
        System.out.println("If you're wrong, you'll lose 1 point and if you lose 10 points in total, game over!");
        System.out.println("Let's get started!");
        System.out.println("The movie title has " + getMovieToGuess().length() + " characters (including spaces and punctuation).");
    }

    public void guessLetter() {
        String guessedLetter = acceptLetter();

        if (movieToGuess.toLowerCase().contains(guessedLetter)) {
            correctLetters += guessedLetter + guessedLetter.toUpperCase();
        }
        else {
            pointsLost++;
            wrongLetters += " " + guessedLetter;
        }
    }



}
