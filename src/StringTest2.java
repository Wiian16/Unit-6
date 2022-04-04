import java.util.Scanner;

public class StringTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter you first and last name");
        String fullName = sc.nextLine();
        
        int space = fullName.indexOf(' ');
        String lastName = fullName.substring(space + 1);
        System.out.println(fullName);
        System.out.println(lastName);
    }
}
