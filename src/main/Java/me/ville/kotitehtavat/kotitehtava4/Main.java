package main.Java.me.ville.kotitehtavat.kotitehtava4;

import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static String filename = "words.txt";

    public static void main(String[] args) {

        Scanner inputChecker = new Scanner(System.in);
        try {
            WordList wordList = new WordList(filename);
            Hangman game;
            System.out.println("Welcome to Hangman, the game from everyone's childhood");
            System.out.println("Do you want to filter the word list? [y/n]");
            char filterOrNoFilter;
            do {
                System.out.print("Choose difficulty: ");
                filterOrNoFilter = inputChecker.nextLine().toLowerCase().charAt(0);
            }
            while (filterOrNoFilter != 'y' && filterOrNoFilter != 'n');

            if (filterOrNoFilter == 'y'){
                System.out.println("Would you like to filter word list by [L]ength or [C]haracter position?");
                char filterChoice;
                do {
                    System.out.print("Choose difficulty: ");
                    filterChoice = inputChecker.nextLine().toLowerCase().charAt(0);
                }
                while (filterChoice != 'l' && filterChoice != 'c');

                if (filterChoice == 'l'){
                    System.out.println("What length of word would you like to guess?");
                    System.out.print("Input number: ");
                    int length = Integer.parseInt(inputChecker.nextLine());
                    wordList = wordList.theWordsOfLength(length);
                }
                if (filterChoice == 'c'){
                    // tähän filteri viel
                }
            }


            System.out.println("Choose your difficulty: [E]asy (10 guesses) [M]edium (5 guesses) or [H]ard (3 guesses)");
            char difficultyChoice;
            do {
                System.out.print("Choose difficulty: ");
                difficultyChoice = inputChecker.nextLine().toLowerCase().charAt(0);
            }
            while (difficultyChoice != 'e' && difficultyChoice != 'm' && difficultyChoice != 'h');
            if (difficultyChoice == 'e'){
                game = new Hangman(wordList, 10);
            }
            else if (difficultyChoice == 'm'){
                game = new Hangman(wordList, 5);
            }
            else{
                game = new Hangman(wordList, 3);
            }
            while (true) {
                System.out.printf("""
                        The hidden word...
                                                
                        %s
                                                
                        Guesses left: %d
                        Guessed letters:""", game.hiddenWord(), game.guessesLeft());
                System.out.println(game.guesses());
                game.guess(askForChar());
                System.out.println();
                if (game.guessesLeft() == 0) {
                    System.out.println("Sorry, you lost!");
                    System.out.printf("The hidden word was: \"%s\"\n", game.word());
                    break;
                }
                if (game.theEnd()) {
                    System.out.println("Congratulations! You won!!!");
                    System.out.printf("The hidden word was: \"%s\"\n", game.word());
                    break;

                }

            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Word file not found");
        }


    }
    private static Character askForChar() {
        Scanner guessScanner = new Scanner(System.in);
        Locale finnish = new Locale("fi", "FI");
        String input;

        do {
            System.out.print("Guess a letter: ");
            input = guessScanner.nextLine().toLowerCase(finnish);
        }
        while (input.length() != 1);

        return input.charAt(0);
    }
}
