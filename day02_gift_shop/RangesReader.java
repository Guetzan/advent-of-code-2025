import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RangesReader {
    private String inputPath;
    private ArrayList<Integer> invalidIds;

    public RangesReader(String inputPath) {
        this.inputPath = inputPath;
        this.invalidIds = new ArrayList<>();
    }

    public String[] createRangesListFromInputFile() {
        try(Scanner inputFile = new Scanner(Paths.get(this.inputPath))) {
            String line = inputFile.nextLine();
            return line.split(",");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public HashMap<String, Integer> getBoundOfIds(String range) {
        String[] splittedRange = range.split("-");

        if(splittedRange.length != 2) {
            return null;
        }

        int startID = Integer.valueOf(splittedRange[0]);
        int endID = Integer.valueOf(splittedRange[1]);

        HashMap<String, Integer> indexes = new HashMap<>();
        indexes.put("startID", startID);
        indexes.put("endID", endID);

        return indexes;        
    }

    public HashMap<String, String> getHalvesOfId(int id) {
        HashMap<String, String> idHalves = new HashMap<>();
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

        idHalves.put("firstHalf", firstHalf);
        idHalves.put("secondHalf", secondHalf);

        return idHalves;
    }

    public void checkForInvalidIdsInRange(String range) {
        HashMap<String, Integer> indexes = this.getBoundOfIds(range);
        int startID = indexes.get("startID");
        int endIndex = indexes.get("endID");

        for(int id = startID; id <= endIndex; id++) {
            if(!(String.valueOf(id).length() % 2 == 0)) {
                continue;
            }

            if(this.getHalvesOfId(id).get("firstHalf").equals(this.getHalvesOfId(id).get("secondHalf"))) {
                //implementar lógica caso as metades sejam iguais
            }
        }
    }

    public ArrayList<Integer> getAllInvalidIdsFromRangesList(String[] rangesList) {
        //implementar lógica para ler uma lista de ranges de id e montar uma lista 
        //com todos os ids inválidos
        
        return this.invalidIds;
    }
}
