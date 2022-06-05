package sample;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File eng = new File("English.in.txt");

        Dictionary sample = new Dictionary();
        sample.addMap("into", "на");
        sample.addMap("from", "з");

        sample.writeTextInFile(sample.getTranslate (eng));
        sample.saveDictionaryIntoFile();

        File dictionary = new File("Dictionary.txt");
        String textDictionary = sample.getTextFromFile(dictionary);
        System.out.println(textDictionary);

    }

}
