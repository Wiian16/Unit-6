public class StringTest1 {
    public static void main(String [] args){
        String day = "Monday", month = "March";
        for(int i = 0; i < day.length(); i++){
            System.out.println(day.charAt(i));
        }
        
        int pos = month.indexOf('c');
        int pos2 = month.indexOf('q');
        System.out.println(pos);
        System.out.println(pos2);
        System.out.println(month.charAt(2));
    }
}
