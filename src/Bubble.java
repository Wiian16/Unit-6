import java.util.Random;
import java.util.Arrays;
import java.util.Date;

public class Bubble {
    public static void main(String [] args){
        Random rand = new Random();
        int [] list = new int [1000000];
        for(int i = 0; i < list.length; i++)
            list[i] = rand.nextInt(100);
        System.out.println(Arrays.toString(list));
        Date d = new Date();
        BubbleSort(list);
        Date d1 = new Date();
        System.out.println(Arrays.toString(list));
        System.out.println(d1.getTime() - d.getTime());
    }
    
    public static void BubbleSort(int [] list){
        int counter = list.length - 1;
        //outer loop counts passes through the array
        for(int i = 0; i < list.length - 1; i++){
            //inner loop counts position in array
            for(int j = 0; j < counter; j++){
                //swap out of order variables
                if(list[j] > list[j + 1]){
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
            counter--;
        }
    }
}
