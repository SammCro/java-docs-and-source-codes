import javax.annotation.processing.SupportedSourceVersion;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    }


    // enhanced switch statement with expressions
    public static String enhancedSwitch(StringBuilder day){
        return switch (day.toString()){
            case "first" -> "Monday"; // {yield "Monday"}
            case "second" -> "Tuesday";
            default -> {
                String badDay = day + " bad input";
                yield badDay;
            }
        };
    }
}