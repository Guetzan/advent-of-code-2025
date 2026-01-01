package day01_secret_entrance;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String file = "input.txt";
        InputParser parser = new InputParser(file);

        parser.parse();

        ArrayList<String> directions = parser.getDirections();
        ArrayList<Integer> distances = parser.getDistances();

        Dial dial = new Dial(50);
        dial.rotate(directions, distances);

        System.out.println("ANSWER: " + dial.getAnswer());
    }
}
