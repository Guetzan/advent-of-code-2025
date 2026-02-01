import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class InvalidIdsIdentifier {
    private String inputPath;
    // private ArrayList<Integer> invalidIds;

    public InvalidIdsIdentifier(String inputPath) {
        this.inputPath = inputPath;
        // this.invalidIds = new ArrayList<>();
    }
    
    public String[] createRangeListFromInputFile() {
        try(Scanner inputFile = new Scanner(Paths.get(this.inputPath))) {
            String line = inputFile.nextLine();
            return line.split(",");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    //retorna um hashmap contendo os limites de um range de ids, ou seja, o menor e o maior id dentro do range passado
    public HashMap<String, Long> getBoundsOfRange(String range) {
        String[] splittedRange = range.split("-");

        if(splittedRange.length != 2) {
            return null;
        }

        long startID = Long.valueOf(splittedRange[0]);
        long endID = Long.valueOf(splittedRange[1]);

        HashMap<String, Long> indexes = new HashMap<>();
        indexes.put("startID", startID);
        indexes.put("endID", endID);

        return indexes;        
    }

    //retorna um hashmap com duas chaves, cada uma contendo uma metade literal do id.
    //sendo assim, caso receba 113114 como parametro, irá retornar um hashmap {firstHalf=113, secondHalf=114}
    public HashMap<String, Long> getHalvesOfId(long id) {
        HashMap<String, Long> idHalves = new HashMap<>();
        String[] splittedId = String.valueOf(id).split("");

        String firstHalf = "";
        String secondHalf = "";

        int digitIndex = 0;
        while(digitIndex < splittedId.length) {
            String digit = splittedId[digitIndex];

            if(digitIndex < splittedId.length / 2) {
                firstHalf += digit;

                digitIndex++;
                continue;
            }

            if(digitIndex >= splittedId.length / 2) {
                secondHalf += digit;
            }

            digitIndex++;
        }

        idHalves.put("firstHalf", Long.valueOf(firstHalf));
        idHalves.put("secondHalf", Long.valueOf(secondHalf));

        return idHalves;
    }

    public boolean isIdIncorrect(long id) {
        if((String.valueOf(id).length() % 2) != 0) {
            return false;
        }

        final HashMap<String, Long> halves = this.getHalvesOfId(id);

        long firstHalf = halves.get("firstHalf");
        long secondHalf = halves.get("secondHalf");

        if(firstHalf == secondHalf) {
            return true;
        }

        return false;
    }

    public ArrayList<Long> getInvalidIdsInRange(String range) {
        ArrayList<Long> invalidIdsInRange = new ArrayList<>();
        final HashMap<String, Long> indexes = this.getBoundsOfRange(range);

        long startID = indexes.get("startID");
        long endIndex = indexes.get("endID");

        for(long id = startID; id <= endIndex; id++) {
            if(this.isIdIncorrect(id)) {
                invalidIdsInRange.add(id);
            }
        }

        return invalidIdsInRange;
    }

    public ArrayList<Long> getAllInvalidIdsFromRangeList() {
        ArrayList<Long> invalidIds = new ArrayList<>();
        String[] ranges = this.createRangeListFromInputFile();

        for(String range: ranges) {
            ArrayList<Long> invalidIdsInRange = getInvalidIdsInRange(range);
            invalidIds.addAll(invalidIdsInRange);
        }
        
        return invalidIds;
    }

    public long getSumOfInvalidIds() {
        ArrayList<Long> invalidIds = this.getAllInvalidIdsFromRangeList();
        System.out.println(invalidIds.toString());
        long sum = 0;

        int index = 0;
        while(index < invalidIds.size()) {
            sum += invalidIds.get(index);
            index++;
        }

        return sum;
    }
}
