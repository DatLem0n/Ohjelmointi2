package main.Java.me.ville.kotitehtavat.kotitehtava4;

import java.util.ArrayList;
import java.util.List;

public class Hangman {

    public boolean guess(Character c){
        // The method compares the character entered as a parameter to the word being guessed and adds the guess
        //to the list of guesses. If the character is found in the word being guessed, the method will return true. If
        //character is not found from the word being guessed, the number of guesses is reduced by one and the
        //method will return false.
        return true;
    }

    public List<Character> guesses(){
        //The method returns the guesses made (as a List of Character objects). Each character should be in the list
        //only once (even if the user has guessed the same character several times).

        List<Character> returnList = new ArrayList<>();

        return returnList;
    }

    public int guessesLeft(){
        // The method returns the number of remaining guesses. Note, must not be negative
        return 0;
    }

    public String word(){
        // The method returns the selected word (unmasked, i.e., as read from the file)
        return null;
    }

    public boolean theEnd() {
        //The method indicates whether the game is over or not. The game ends if all the letters in the word are
        //guessed correctly

        return true;
    }

}
