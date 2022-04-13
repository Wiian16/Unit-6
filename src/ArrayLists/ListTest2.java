package ArrayLists;

import java.util.ArrayList;
import java.util.Random;

public class ListTest2 {
    public static void main(String [] args){
        Random rand = new Random();
        ArrayList<Integer> data = new ArrayList<>();
        
        for(int i = 0; i < 10; i ++)
            data.add(rand.nextInt(100) + 1);
        System.out.println(data);
        
        double a = findAverage(data);
        System.out.println("The Average is " + a);
        //removeOdds(data);
        makeEven(data);
        System.out.println(data);
    }
    
    public static double findAverage(ArrayList<Integer> list){
        double total = 0;
        for(int i = 0; i < list.size(); i++)
            total += list.get(i);
        return total / list.size();
    }
    
    public static void removeOdds(ArrayList<Integer> list){
        for(int i = list.size() - 1; i >= 0; i--){
            if(list.get(i) % 2 == 1) {
                list.remove(i);
            }
        }
    }
    
    //this method will make each odd value even by adding 1
    public static void makeEven(ArrayList<Integer> list){
        for(int i = list.size() - 1; i >= 0; i--){
            if(list.get(i) % 2 == 1) {
                list.set(i, list.get(i) + 1);
            }
        }
    }
}
