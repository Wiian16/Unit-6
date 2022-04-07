package Sorting;

import java.util.Date;
import java.util.Random;

public class Selection {
    public static void main(String [] args) {
        Random rand = new Random();
        int [] list = new int[10000];
        
        for(int i = 0; i < list.length; i ++)
            list[i] = rand.nextInt(100);
        
        Date d = new Date();
        SelectionSort(list);
        Date d1 = new Date();
        System.out.println(d1.getTime() - d.getTime());
    }
    
    public static void SelectionSort(int [] list){
        for(int i = 0; i < list.length - 1; i ++){
            int small = findSmallestIndex(list, i);
            swap(list, i, small);
        }
    }
    
    public static void swap(int [] list, int index1, int index2){
        int temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }
    
    public static int findSmallestIndex(int [] list, int index){
        int pos = index;
        for(int i = index; i < list.length; i ++){
            if(list[i] < list[pos])
                pos = i;
        }
        return pos;
    }
}
