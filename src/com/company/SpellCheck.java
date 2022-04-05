package com.company;
import java.io.*;
import java.util.Scanner;

public class SpellCheck {

    public static final int listSize = 150000;
    private String[] wordList;
    private int numWords = 0;

    public SpellCheck() {
        wordList = new String[listSize];
        ReadFile();
        SearchWords();
    }

    public void ReadFile() {
        System.out.println("Reading wordlist ...");
        System.out.println();
        Scanner scan = null;
        try {
            scan = new Scanner(new File("spellcheck.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }

        while (scan.hasNextLine()) {
            String str = scan.nextLine();
            wordList[numWords] = str;
            numWords++;
        }
    }
    public void SearchWords() {
        System.out.println("Enter the word you would like to check:");
        Scanner myVar = new Scanner(System.in);
        String key = myVar.nextLine();

        int left = 0;
        int right = numWords;
        int midpoint;
        while (left <= right) {
            midpoint = (left + right) / 2;
            int result = (wordList[midpoint].compareTo(key));
            if (result == 0){
                System.out.println("Your word was found. Your spelling for " + wordList[midpoint] + " is correct.");
                System.out.println("Position of word in list: " + midpoint);
                break;}
            else if (result < 0)
                left = midpoint + 1;
            else
                right = midpoint - 1;
        }
    }
    public static void main(String[] args) {
        System.out.println("Would you like to find a word? (y/n)");
        Scanner myVar = new Scanner(System.in);
        String ans = myVar.nextLine();
        while (ans.equals("y")) {
            SpellCheck spellCheck = new SpellCheck();
            System.out.println("Number of words " + spellCheck.numWords);
            System.out.println();
            System.out.println("Would you like to find a word? (y/n)");
             myVar = new Scanner(System.in);
             ans = myVar.nextLine();
        }
    }
}


