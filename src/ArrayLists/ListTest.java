package ArrayLists;

import java.util.ArrayList;
import java.util.Arrays;

public class ListTest {
    public static void main(String [] args){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(8);
        list.add(3);
        list.add(1, 3);
        System.out.println(list);
        list.set(1, 4);
        System.out.println(list);
        System.out.println(list.get(3));
        
        list.add(8);
        list.remove(new Integer(3));
        System.out.println(list);
       
        ArrayList<String> names = new ArrayList<String>();
        
        names.add("David");
        names.add("Joe");
        names.add("Sam");
        names.add("Paige");
        System.out.println(names);
        System.out.println(names.remove("Sam"));
        System.out.println(names);
        System.out.println(names.remove("Winston"));
    }
}
