package Project;

import java.util.ArrayList;
import java.util.Scanner;

public class Polynomial {
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String [] args){
        ArrayList<Term> poly1 = new ArrayList<>();
        ArrayList<Term> poly2 = new ArrayList<>();
        fillPolynomials(poly1, poly2);
        sortPolynomials(poly1);
        sortPolynomials(poly2);
        System.out.println(printPolynomial(poly1));
        System.out.println(printPolynomial(poly2));
    }
    
    //fill polynomials with user data
    public static void fillPolynomials(ArrayList<Term> poly1, ArrayList<Term> poly2){
        System.out.println("Enter the coefficient and the exponent for each term of you polynomial separated by a space");
        System.out.println("Enter your first polynomial, enter 0 0 when finished");
        fillPolynomial(poly1);
        System.out.println("Enter your second polynomial, enter 0 0 when finished");
        fillPolynomial(poly2);
        System.out.println(poly1);
        System.out.println(poly2);
    }
    
    public static void fillPolynomial(ArrayList<Term> poly){
        String input = "";
        int index = 0;
        
        while(!input.equals("0 0")){
            String coef = "", exp = "";
            int coefficient, exponent;
        
            input = sc.nextLine();
            if(!input.equals("0 0")){
                //taking coefficient out of input string
                for(int i = 0; i < input.length(); i++){
                    if(Character.isDigit(input.charAt(i)))
                        coef += input.charAt(i);
                    else if(input.charAt(i) == ' ') {
                        index = i + 1;
                        break;
                    }
                }
                //taking exponent out of input string
                for(int i = index; i < input.length(); i ++){
                    if(Character.isDigit(input.charAt(i)))
                        exp += input.charAt(i);
                    else if(input.charAt(i) == ' ') {
                        index = i;
                        break;
                    }
                }
            
                //turning strings into ints
                coefficient = Integer.parseInt(coef);
                exponent = Integer.parseInt(exp);
            
                //adding term to arrayList
                poly.add(new Term(coefficient, exponent));
            }
        }
    }
    
    public static void sortPolynomials(ArrayList<Term> poly){
        //standard bubble sort(sorts in ascending order)
        boolean sorted;
        for(int i = 0; i < poly.size() - 1; i++){
            sorted = true;
            for(int j = 0; j < poly.size() - 1 - i; j++){
                if(poly.get(i).getExponet() > poly.get(i + 1).getExponet()){
                    Term temp = poly.get(i);
                    poly.set(i, poly.get(i + 1));
                    poly.set(i + 1, temp);
                    sorted = false;
                }
            }
            if(sorted)
                break;
        }
        //reversing the array to have it in descending order
        ArrayList<Term> temp = new ArrayList<>();
        for(int i = poly.size() - 1; i >= 0; i--)
            temp.add(poly.get(i));
        poly.clear();
        poly.addAll(temp);
    }
    
    //Todo: method create the sum of two polynomials, return new arraylist
    
    //Todo: method to create product of two polynomials, return new arraylist
    
    //Todo: method to combine any like terms
    
    //Todo: toString method for polynomials(possibly static)
    public static String printPolynomial(ArrayList<Term> list){
        String str = "";
        str += list.get(0);
        for(int i = 1; i < list.size(); i++){
            Term temp = list.get(i);
            if(temp.getCoefficient() > 0)
                str += " + " + temp;
            else
                str += " " + temp;
        }
        return str;
    }
}
