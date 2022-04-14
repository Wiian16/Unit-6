package Project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TextAnalyser {
    
    public static final String wordEndings = " ,;:.?/!";
    
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a paragraph you would like to have analysed");
        String paragrapgh = sc.nextLine();
        System.out.println(numChars(paragrapgh));
        System.out.println(numWords(paragrapgh));
        System.out.println(avgWords(paragrapgh));
        System.out.println(avgWordLength(paragrapgh));
        
    }
    
    //returns total number of characters excluding whitespace
    public static int numChars(String str){
        int chars = 0;
        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ')
                chars++;
        }
        return chars;
    }
    
    //returns total number of words in the paragraph
    public static int numWords(String str){
        int words = 1;
        for(int i = 0; i <str.length(); i++){
            if(str.charAt(i) == ' ')
                words++;
        }
        return words;
    }
    
    //returns the average number of words per sentence in the paragraph
    public static double avgWords(String str){
        int words = 0;
        
        for(int i = 0; i < str.length(); i++){
            if(wordEndings.indexOf(str.charAt(i)) != -1){
            
            }
        }
        return 0;
    }
    
    //returns the average word length in the paragraph
    public static double avgWordLength(String str){
        return 0;
    }
}
