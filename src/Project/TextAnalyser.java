package Project;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TextAnalyser {
    
    public static final String sentenceEndings = ".?!";
    
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.###");
        
        System.out.println("Enter a paragraph you would like to have analysed");
        String paragrapgh = sc.nextLine();
        System.out.println("This paragraph has " + numChars(paragrapgh) + " characters");
        System.out.println("This paragraph has " + numWords(paragrapgh) + " words");
        System.out.println("This paragraph has an average of "  + df.format(avgWords(paragrapgh)) + " words per sentence");
        System.out.println("This paragraph has an average of " + df.format(avgWordLength(paragrapgh)) + " letter per word");
        
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
        double words = 1, sentences = 0;
        
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                words++;
            }
            if(sentenceEndings.indexOf(str.charAt(i)) !=  -1)
                sentences++;
        }
        if(sentences == 0)
            sentences = 1;
        return words / sentences;
    }
    
    //returns the average word length in the paragraph
    public static double avgWordLength(String str){
        return (double)numChars(str) / numWords(str);
    }
}
