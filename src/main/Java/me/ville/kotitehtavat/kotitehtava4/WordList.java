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
    private Locale finnish = new Locale("fi", "FI");
    WordList(String filename) throws FileNotFoundException{
        if (!filename.endsWith(".txt")){
            filename += ".txt";
        }
        this.filename = filename;
        readFile(filename);
    }
    private void readFile(String filename) throws FileNotFoundException{
        File wordFile = new File(filename);
        Scanner wordScanner = new Scanner(wordFile);
        while (wordScanner.hasNextLine()){
            String line = wordScanner.nextLine();
            if (line.length() > 2) {
                wordList.add(line.toLowerCase(finnish));
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
        WordList WordList = new WordList(filename);
        return WordList;
    }

    public WordList theWordsWithCharacters(String someString)throws FileNotFoundException {
        // The method returns a new WordList object with only the words with the letters in the exact positions
        // specified in the given string (and matching the length of that given string).
        WordList WordList = new WordList(filename);
        return WordList;
    }
}

