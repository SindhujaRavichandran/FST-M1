package Activities;
import java.util.ArrayList;
public class Activity9 {
    public static void main(String[] args){
       ArrayList<String> myList = new ArrayList<String>();
        myList.add("India");
        myList.add("America");
        myList.add("Japan");
        myList.add("Australia");
        myList.add("China");
System.out.println("Family Members");
        for(String s:myList){
            System.out.println(s);
        }
        System.out.println("4th element in the list is: " + myList.get(3));
        System.out.println("Is China is in list: " + myList.contains("China"));
        System.out.println("Size of ArrayList: " + myList.size());

        myList.remove("China");

        System.out.println("New Size of ArrayList: " + myList.size());
            }
}
