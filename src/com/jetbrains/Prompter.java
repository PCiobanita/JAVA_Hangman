package com.jetbrains;

import java.util.Scanner;

public class Prompter {
    private Game game;

    public Prompter(Game game){
        this.game = game;
    }

    public boolean promptForGuess() {
        Scanner scanner = new Scanner(System.in);
        boolean isHit = false;
        boolean isAcceptable = false;

        do {
            System.out.print("Enter a letter :   ");
            String guessInput = scanner.nextLine();

            try {
                isHit = game.applyGuess(guessInput);
                isAcceptable = true;
            } catch (IllegalArgumentException iae) {
                System.out.printf("%s. please try again %n", iae.getMessage());
            }
        } while (!isAcceptable);
        return isHit;
    }

    public void displayProgress(){
        System.out.printf("You have %d tries left to solve:  %s%n" , game.getRemaningTries(), game.getCurrentProgress());
    }

    public void displayOutcome(){
        if (game.isWon()) {
            System.out.println("Congratulation You Have Won! You guessed:    " + game.getAnswer() );
        } else {
            System.out.println("Bummer!!! You ARE Out Of Tries The word was:  " + game.getAnswer());
        }
    }
}
