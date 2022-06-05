package sample;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Dictionary {
    private Map<String, String> vocabulary = new HashMap<>();
    private String translate;

    public Dictionary(Map<String, String> map) {
        this.vocabulary = map;
    }

    public Dictionary() {
        super();
    }

    public Map<String, String> getMap() {
        vocabulary.put("translation", "переклад");
        vocabulary.put("Ukrainian", "українська");
        vocabulary.put("text", "текст");
        vocabulary.put("vocabulary", "словник");
        vocabulary.put("English", "англійська");
        vocabulary.put("using", "використовуючи");
        return vocabulary;
    }

    public Map<String, String> addMap(String wordKey, String wordValue) {
        vocabulary.put(wordKey, wordValue);
        return vocabulary;
    }

    public void saveDictionaryIntoFile () {
        File file = new File("Dictionary.txt");
        Set<String> keys = vocabulary.keySet();

        try (PrintWriter pw = new PrintWriter(file)) {
            for(String k: keys) {
                pw.println(k + ";" + vocabulary.get(k));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getTranslate(File fileEng) {
        String[] textEng = getTextFromFile(fileEng).split("[ ]");
        getMap();
        translate = "";
        for(String word: textEng) {
            if (vocabulary.containsKey(word)) {
                translate += vocabulary.get(word) + " ";
            } else {
                translate += "";
            }
        }
        return translate;
    }

    public String getTextFromFile(File file) {
        String result = "";
        try (Scanner sc = new Scanner(file)) {
            for (; sc.hasNextLine();) {
                result += sc.nextLine() + System.lineSeparator();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void writeTextInFile (String text) {
        File file = new File("Ukrainian.out.txt");
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
