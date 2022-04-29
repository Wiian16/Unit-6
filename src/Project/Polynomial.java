package Project;

import java.util.ArrayList;
import java.util.Scanner;

public class Polynomial {
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String [] args){
        ArrayList<Term> poly1 = new ArrayList<>();
        ArrayList<Term> poly2 = new ArrayList<>();
        fillPolynomials(poly1, poly2);
        System.out.println("Here are you polynomials added:");
        System.out.println(printPolynomial(addPolynomials(poly1, poly2)));
        System.out.println("Here are your polynomials multiplied");
        System.out.println(printPolynomial(multiplyPolynomials(poly1, poly2)));
    }
    
    /**
     * Redirects to {@link #fillPolynomial(ArrayList)} for each {@link ArrayList}
     * @param poly1 {@link ArrayList} of type {@link Term}
     * @param poly2 {@link ArrayList} of type {@link Term}
     */
    public static void fillPolynomials(ArrayList<Term> poly1, ArrayList<Term> poly2){
        System.out.println("Enter the coefficient and the exponent for each term of you polynomial separated by a space");
        System.out.println("Enter your first polynomial, enter 0 0 when finished");
        fillPolynomial(poly1);
        System.out.println("Enter your second polynomial, enter 0 0 when finished");
        fillPolynomial(poly2);
        System.out.println(poly1);
        System.out.println(poly2);
    }
    
    /**
     * Fills {@link ArrayList} of type {@link Term} with user-specified data
     * @param poly {@link ArrayList} of type {@link Term}
     */
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
                    if(Character.isDigit(input.charAt(i)) || input.charAt(i) == '-')
                        coef += input.charAt(i);
                    else if(input.charAt(i) == ' ') {
                        index = i + 1;
                        break;
                    }
                }
                //taking exponent out of input string
                for(int i = index; i < input.length(); i ++){
                    if(Character.isDigit(input.charAt(i)) || input.charAt(i) == '-')
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
        combineLikeTerms(poly);
    }
    
    /**
     * Sorts an {@code ArrayList} of {@link Term} into descending order
     * @param poly {@link ArrayList} of {@link Term}
     */
    public static void sortPolynomials(ArrayList<Term> poly){
        //standard bubble sort(sorts in ascending order)
        boolean sorted;
        //outer loop counts passes through the array
        for(int i = 0; i < poly.size() - 1; i++){
            sorted = true;
            //inner loop counts position in array
            for(int j = 0; j < poly.size() - 1 - i; j++){
                //swap out of order variables
                if(poly.get(j).getExponet() > poly.get(j + 1).getExponet()){
                    Term temp = poly.get(j);
                    poly.set(j, poly.get(j + 1));
                    poly.set(j + 1, temp);
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
    
    /**
     * Adds contents of {@code poly1} and {@code poly2} to {@code sum} and calls {@link #combineLikeTerms}
     * @param poly1 {@link ArrayList} of type {@link Term}
     * @param poly2 {@link ArrayList} of type {@link Term}
     * @return {@link ArrayList} {@code sum} of type {@link Term}
     */
    public static ArrayList<Term> addPolynomials(ArrayList<Term> poly1, ArrayList<Term> poly2){
        ArrayList<Term> sum = (ArrayList<Term>)poly1.clone();
        sum.addAll(poly2);
        combineLikeTerms(sum);
        return(sum);
    }
    
    public static ArrayList<Term> multiplyPolynomials(ArrayList<Term> poly1, ArrayList<Term> poly2){
        ArrayList<Term> product = new ArrayList<>();
        
        for(int i = 0; i < poly1.size(); i++){
            for(int j = 0; j < poly2.size(); j++){
                int coef = poly1.get(i).getCoefficient() * poly2.get(j).getCoefficient();
                int exp = poly1.get(i).getExponet() + poly2.get(j).getExponet();
                product.add(new Term(coef, exp));
            }
        }
        combineLikeTerms(product);
        return product;
    }
    
    /**
     * Combines any like terms in given {@link ArrayList} of type {@link Term}
     * @param poly {@link ArrayList} of type {@link Term}
     */
    public static void combineLikeTerms(ArrayList<Term> poly){
        //find terms that may not have been combined
        for(int i = 0; i < poly.size() - 1; i ++){
            int exp = poly.get(i).getExponet();
            //finding terms that match the first term to combine
            for(int j = i + 1; j < poly.size(); j++){
                if(poly.get(j).getExponet() == exp) {
                    poly.get(i).setCoefficient(poly.get(i).getCoefficient() + poly.get(j).getCoefficient());
                    poly.remove(j);
                }
            }
        }
        sortPolynomials(poly);
    }
    
    /**
     *
     * @param list {@link ArrayList} of type {@link Term}
     * @return {@code String str} of a formatted polynomial
     */
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
