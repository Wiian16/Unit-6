package Sorting;

import java.util.Arrays;

public class Insertion {
    public static void main(String [] args){
        String [] list = {"Bruh", "Stupid", "Matt", "Samarth", "Sam"};
        insertionSort(list);
        System.out.println(Arrays.toString(list));
    }
    
    public static void insertionSort(String [] list){
        for(int i = 1; i < list.length; i++){
            String item = list[i];
            for(int j = i - 1; j >= 0; j--){
                if(list[j].compareTo(item) > 0){
                    list[j + 1] = list[j];
                }
                else{
                    list[j + 1] = item;
                    break;
                }
                
                if(j == 0)
                    list[0] = item;
            }
        }
    }
}
