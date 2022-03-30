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
        
        String sentence = "Today is Wednesday and we have academic lab";
        
        //find the number of words in a given string
        int words = 1;
        for(int i = 0; i < sentence.length(); i++){
            if(sentence.charAt(i) == ' ')
                words++;
        }
        System.out.println(words + " words");
    }
}
