package Project;

import java.util.Scanner;

public class Acronym {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a phrase to generate an acronym");
        String input = sc.nextLine();
        System.out.println(createAcronym(input));
    }
    
    public static String createAcronym(String input){
        String acronym = "";
        if(Character.isLetter(input.charAt(0))) {
            acronym += input.charAt(0);
            for(int i = 1; i < input.length(); i++){
                if(input.charAt(i) == ' ' && Character.isLetter(input.charAt(i + 1)))
                    acronym += input.charAt(i + 1);
            }
        }
        
        else{
            int index = 0;
            for(int i = 0; i < input.length(); i++){
                if(Character.isLetter(input.charAt(i))){
                    acronym += input.charAt(i);
                    index = i;
                    break;
                }
            }
            
            for(int i = index; i < input.length(); i++){
                if(input.charAt(i) == ' ' && Character.isLetter(input.charAt(i + 1)))
                    acronym += input.charAt(i + 1);
            }
        }
        return acronym.toUpperCase();
    }
}