package main.Java.me.ville.kotitehtavat.kotitehtava4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class WordList {
    private String filename;
    private List<String> wordList = new ArrayList<String>();
    private final Locale FINNISH = new Locale("fi", "FI");
    private int lengthFilterThreshold = 0;
    private String charFilterModel = "";
    WordList(String filename) throws FileNotFoundException{
        if (!filename.endsWith(".txt")){
            filename += ".txt";
        }
        this.filename = filename;
        readFile(filename, 0);
    }
    WordList(String filename, int filterType) throws FileNotFoundException{
        // filterType int 1 = length, 2 = Character sort
        if (!filename.endsWith(".txt")){
            filename += ".txt";
        }
        this.filename = filename;
        readFile(filename, filterType);
    }
    private void readFile(String filename, int filterType) throws FileNotFoundException{
        // filterType int 1 = length, 2 = Character
        boolean lengthFilter = false;
        boolean charFilter = false;
        if (filterType == 1) {
            lengthFilter = true;
        }
        else if (filterType == 2) {
            charFilter = true;
        }

        File wordFile = new File(filename);
        Scanner wordScanner = new Scanner(wordFile);
        while (wordScanner.hasNextLine()){
            String line = wordScanner.nextLine();
            if (lengthFilter && line.length() == lengthFilterThreshold){
                wordList.add(line.toLowerCase(FINNISH));
            }

            else if (charFilter && line.length() == charFilterModel.length()) {
                boolean matchingWord = false;
                for (int i = 0; i < line.length(); i++) {
                    matchingWord = line.charAt(i) == charFilterModel.charAt(i) || charFilterModel.charAt(i) == '_';
                }
                if (matchingWord) {
                    wordList.add(line.toLowerCase(FINNISH));
                }
            }

            else{
                if (line.length() > 2) {
                    wordList.add(line.toLowerCase(FINNISH));
                }
            }
        }
    }
    public List<String> giveWords()
    {
        //return words of wordlist in a list
        return wordList;
    }

    public WordList theWordsOfLength(int length)throws FileNotFoundException{
        // The method returns a new WordList object with only the words whose length corresponds to the value of
        // the variable given as a parameter.
        lengthFilterThreshold = length;
        return new WordList(filename, 1);
    }

    public WordList theWordsWithCharacters(String someString)throws FileNotFoundException {
        // The method returns a new WordList object with only the words with the letters in the exact positions
        // specified in the given string (and matching the length of that given string).
        charFilterModel = someString;
        return new WordList(filename, 2);
    }
}

