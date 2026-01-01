package day01_secret_entrance;
import java.util.Scanner;
import java.util.ArrayList;
import java.nio.file.Paths;

public class InputParser {
    private String filePath;
    private ArrayList<String> directions = new ArrayList<>();
    private ArrayList<Integer> distances = new ArrayList<>();

    public InputParser(String filePath) {
        this.filePath = filePath;
    }

    public void parse() {
        try(Scanner inputFile = new Scanner(Paths.get("day01_secret_entrance/input.txt"))) {
            while(inputFile.hasNextLine()) {
                String[] row = inputFile.nextLine().split("");
                
                String rowDirection = row[0];
                this.directions.add(rowDirection);

                String concatenatedDistance = "";
                for(int index = 1; index < row.length; index++) {
                    concatenatedDistance += row[index];
                }

                this.distances.add(Integer.valueOf(concatenatedDistance));
            }
        } catch(Exception error) {
            System.out.println("error: " + error.getMessage());
        }
    }

    public ArrayList<String> getDirections() {
        return this.directions;
    }

    public ArrayList<Integer> getDistances() {
        return this.distances;
    }
}
