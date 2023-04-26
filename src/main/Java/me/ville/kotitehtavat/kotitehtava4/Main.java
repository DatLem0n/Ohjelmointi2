package main.Java.me.ville.kotitehtavat.kotitehtava4;

import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static final String filename = "words.txt";
    private static final Scanner inputChecker = new Scanner(System.in);
    private static int numOfGuesses = 0;
    private static WordList wordList;

    public static void main(String[] args) {
        try {
            Hangman game;
            System.out.println("Welcome to Hangman, the game from everyone's childhood");
            menu();
            game = new Hangman(wordList, numOfGuesses);
            play(game);
        }
        catch (FileNotFoundException e) {
            System.out.println("Word file not found");
        }
    }

    private static void menu() throws FileNotFoundException {
        System.out.println("Choose your difficulty: [E]asy (10 guesses) [M]edium (5 guesses) or [H]ard (3 guesses)");
        char difficultyChoice;
        do {
            System.out.print("Choose difficulty: ");
            difficultyChoice = inputChecker.nextLine().toLowerCase().charAt(0);
        }
        while (difficultyChoice != 'e' && difficultyChoice != 'm' && difficultyChoice != 'h');
        if (difficultyChoice == 'e'){
            numOfGuesses = 10;
        }
        else if (difficultyChoice == 'm'){
            numOfGuesses = 5;
        }
        else{
            numOfGuesses = 3;
        }

        wordList = new WordList(filename);
        System.out.println("Do you want to filter the word list? [y/n]");
        char filterOrNoFilter;
        do {
            System.out.print("Make your choice: ");
            filterOrNoFilter = inputChecker.nextLine().toLowerCase().charAt(0);
        }
        while (filterOrNoFilter != 'y' && filterOrNoFilter != 'n');

        if (filterOrNoFilter == 'y'){
            System.out.println("Would you like to filter word list by [L]ength or [C]haracter position?");
            char filterChoice;
            do {
                System.out.print("Make your choice: ");
                filterChoice = inputChecker.nextLine().toLowerCase().charAt(0);
            }
            while (filterChoice != 'l' && filterChoice != 'c');

            if (filterChoice == 'l'){
                System.out.println("What length of word would you like to guess?");
                while(true){
                    try {
                        do {
                            System.out.print("Input number: ");
                            int length = Integer.parseInt(inputChecker.nextLine());
                            wordList = wordList.theWordsOfLength(length);
                            if (wordList.giveWords().size() == 0) {
                                System.out.println("There are no words of that length");
                            }
                        } while (wordList.giveWords().size() == 0);
                        break;
                    }
                    catch (NumberFormatException e){
                        System.out.println("Please input just numbers");
                    }
                }

            }
            else {
                System.out.println("Please format your character input with '_' character representing any character");
                System.out.println("Example: _a_e_ (matching words could be camel or panel)");
                do {
                    System.out.print("Write your filter: ");
                    String charModel = inputChecker.nextLine();
                    wordList = wordList.theWordsWithCharacters(charModel);
                    if (wordList.giveWords().size() == 0) {
                        System.out.println("There are no words matching your filter");
                    }
                }
                while (wordList.giveWords().size() == 0);
            }
        }
    }

    private static void play(Hangman game) throws FileNotFoundException {
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
                System.out.println();
                System.out.println("R to retry, M for menu, any other key to quit");
                System.out.print("Again?: ");
                String line = inputChecker.nextLine().toLowerCase();
                if(line.length() != 0){
                    if (line.charAt(0) == 'r'){
                        retry();
                    }else if (line.charAt(0) == 'm') {
                        menu();
                        retry();
                    }
                }
                break;

            }
            if (game.theEnd()) {
                System.out.println("Congratulations! You won!!!");
                System.out.printf("The hidden word was: \"%s\"\n", game.word());
                System.out.println();
                System.out.println("R to retry, M for menu, any other key to quit");
                System.out.print("Again?: ");
                String line = inputChecker.nextLine().toLowerCase();
                if(line.length() != 0){
                    if (line.charAt(0) == 'r'){
                        retry();
                    } else if (line.charAt(0) == 'm') {
                        menu();
                        retry();
                    }
                }
                break;
            }

        }
    }
    private static void retry() throws FileNotFoundException {
        Hangman game = new Hangman(wordList, numOfGuesses);
        play(game);
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
