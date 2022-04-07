package Sorting;

import java.util.*;

public class Binary {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int [] list = new int [99999999];
        Date d, d1, d2;
        int target = sc.nextInt();
        
        d = new Date();
        for(int i = 0; i < list.length; i++)
            list[i] = rand.nextInt(100000000);
        Arrays.sort(list);
        System.out.println("done");
        
        d1 = new Date();
        int pos = binarySearch(list, target);
        d2 = new Date();
        
        if(pos != -1)
            System.out.println("Item found in position " + pos);
        else
            System.out.println("Item not found");
        System.out.println(d.getTime() - d1.getTime());
        System.out.println(d1.getTime() - d2.getTime());
        System.out.println(d.getTime() - d2.getTime());
    }
    
    public static int binarySearch(int [] list, int target){
        int low = 0, high = list.length - 1, mid;
        
        while(low <= high){
            mid = (low + high) / 2;
            if(target == list[mid])
                return mid;
            else if(target > list[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
