package com.company;


public class Main {

    public static void main(String[] args) {

        Game game = new Game("movies.txt");

        game.startGame();

        while(!game.isEnd()){
            System.out.println("You are guessing:" + game.underScoreMovie());
            System.out.println("You have guessed (" + game.getWrongLetters().length()/2 + ") wrong letters:"
                    + game.getWrongLetters());
            game.guessLetter();
        }
        if(game.getIsWin()){
            System.out.println("You win!");
            System.out.println("You have guessed " + game.getMovieToGuess() + " correctly.");
        }
        else{
            System.out.println("You have guessed (" + game.getWrongLetters().length()/2 + ") wrong letters:" +
                    game.getWrongLetters());
            System.out.println("You lost!");
            System.out.println("The movie title was " + game.getMovieToGuess());
            System.out.println("Better luck next time.");
        }
    }
}
