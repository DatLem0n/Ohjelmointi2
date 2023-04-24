package main.Java.me.ville.kotitehtavat.kotitehtava4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hangman {
private String theWord;
private int guessesLeft = 5;
private List<Character> charsOfWord = new ArrayList<>();
private List<Character> correctGuesses = new ArrayList<>();
private List<Character> guesses = new ArrayList<>();


    public Hangman(WordList wordList, int numberOfGuesses){
        theWord = wordList.giveWords().get((int) (Math.random() * wordList.giveWords().size()));
        guessesLeft = numberOfGuesses;
        getCharsOfWord(theWord);
    }
    private void getCharsOfWord(String word){
        for (char ch : word.toCharArray()){
            if (!charsOfWord.contains(ch)){
                charsOfWord.add(ch);
            }
        }
        Collections.sort(charsOfWord);
    }
    public boolean guess(Character c){
        // The method compares the character entered as a parameter to the word being guessed and adds the guess
        //to the list of guesses. If the character is found in the word being guessed, the method will return true.
        char guess = Character.toLowerCase(c);
        if (!guesses.contains(guess)){
            guesses.add(guess);
        }

        for (char ch : charsOfWord){
            if (guess == ch){
                correctGuesses.add(guess);
                Collections.sort(correctGuesses);
                return true;
            }
        }
        guessesLeft--;
        return false;
    }

    public List<Character> guesses(){
        //The method returns the guesses made (as a List of Character objects).
        return guesses;
    }

    public int guessesLeft(){
        // The method returns the number of remaining guesses.
        return guessesLeft;
    }

    public String word(){
        // The method returns the selected word
        return theWord;
    }

    public String hiddenWord(){
        // builds the word mask for the word
        StringBuilder hiddenWord = new StringBuilder();
        for (Character ch : theWord.toCharArray()){
            if(correctGuesses.contains(ch)){
                hiddenWord.append(ch);
            }
            else{
                hiddenWord.append("*");
            }
            hiddenWord.append(" ");
        }
        return hiddenWord.toString().strip();
    }

    public boolean theEnd() {
        //The method indicates whether the game is over or not. The game ends if all the letters in the word are
        //guessed correctly

        return correctGuesses.equals(charsOfWord);
    }

}
