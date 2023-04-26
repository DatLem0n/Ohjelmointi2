package main.Java.me.ville.kotitehtavat.kotitehtava4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class WordList {
    private final String filename;
    private final List<String> wordList = new ArrayList<String>();
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
            if (lengthFilter){
                if(line.length() == lengthFilterThreshold){
                    wordList.add(line.toLowerCase(FINNISH));
                }
            }

            else if (charFilter) {
                if(line.length() == charFilterModel.length()){
                    int nonMatchesInWord = 0;
                    for (int i = 0; i < line.length(); i++) {
                        if(line.charAt(i) != charFilterModel.charAt(i) && charFilterModel.charAt(i) != '_'){
                            nonMatchesInWord ++;
                        }
                    }
                    if (nonMatchesInWord == 0) {
                        wordList.add(line.toLowerCase(FINNISH));
                    }
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
        wordList.clear();
        readFile(filename, 1);

        return this;
    }

    public WordList theWordsWithCharacters(String someString)throws FileNotFoundException {
        // The method returns a new WordList object with only the words with the letters in the exact positions
        // specified in the given string (and matching the length of that given string).
        charFilterModel = someString;
        wordList.clear();
        readFile(filename, 2);
        return this;
    }
}

