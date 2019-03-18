package com.jetbrains;

public class Hangman {

    public static void main(String[] args) throws Exception{
        HttpURLCon http = new HttpURLCon();
        System.out.println("Sending HTTP GET request");
        http.sendGet();

        Game game = new Game(http.sendGet());
        Prompter prompter = new Prompter(game);
        while (game.getRemaningTries() > 0 && !game.isWon()) {
            prompter.displayProgress();
            prompter.promptForGuess();
        }
        prompter.displayOutcome();

    }

}
