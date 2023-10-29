import org.jetbrains.annotations.NotNull;

import java.sql.SQLOutput;
import java.util.*;

// it came with Java 14
// it has hashCode, equals, toString, default constructors and getters,setters
record Person (String name, int age, double weight){
    public Person(String name){
        this(name, 30, 45);
    }
}

enum SIZES{
    SMALL, MEDIUM, BIG;

    public int getReward(){
        return switch (this){
            case SMALL -> 1;
            case MEDIUM -> 2;
            case BIG -> 4;
        };
    }
}
public class Main {
    public static void main(String[] args) {
        getEnums(SIZES.BIG);
    }

    // enhanced switch statement with expressions
    public static String enhancedSwitch(@NotNull StringBuilder day){
        return switch (day.toString()){
            case "first" -> "Monday"; // {yield "Monday"}
            case "second" -> "Tuesday";
            default -> day + " bad input";
        };
    }

    // embedded binary search method from Arrays class.
    private static int binarySearchArray(int[] array, int searchedNumber){
        return Arrays.binarySearch(array, searchedNumber);
    }

    // List class and its children.
    private static List<Person> validPersons(@NotNull ArrayList<Person> persons){
        ArrayList<Person> validPersons;
        validPersons = (ArrayList<Person>) persons.stream().filter(person -> person.age() == 30);
        //validPersons.sort(Comparator.naturalOrder());
        return validPersons;
    }

    // Iterators and LinkedList methods
    private static LinkedList<Person> maturePersons(@NotNull List<Person> persons){
        LinkedList<Person> validPersons = new LinkedList<>();
        ListIterator<Person> listIterator = persons.listIterator();

        while (listIterator.hasNext()){
            Person person = listIterator.next();
            // queue methods
            validPersons.offerFirst(person);
            validPersons.offerLast(person);
            // stack methods
            validPersons.push(person);
        }
        return validPersons;
    }

    // new enums methods
    private static SIZES getEnums(SIZES size){
        System.out.println(SIZES.BIG.ordinal());
        System.out.println(SIZES.BIG.name());
        System.out.println(SIZES.values().toString());
        System.out.println(size.getReward());
        return size;
    }
}