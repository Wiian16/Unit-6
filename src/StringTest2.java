import java.util.Scanner;

public class StringTest2 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter you first and last name");
        String fullname = sc.nextLine();
        
        int space = fullname.indexOf(' ');
        
        String lastname = fullname.substring(space + 1);
        System.out.println(fullname);
        System.out.println(lastname);
    }
}
