import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class InvalidIdsIdentifier {
    private ArrayList<IdRange> ranges;
    private ArrayList<Long> invalidIds;

    public InvalidIdsIdentifier() {
        this.ranges = new ArrayList<>();
        this.invalidIds = new ArrayList<>();
    }
    
    public void feedRangesList(String inputPath) {
        try(Scanner inputFile = new Scanner(Paths.get(inputPath))) {
            String line = inputFile.nextLine();
            String[] ranges = line.split(",");

            for(String range: ranges) {
                addRange(range);
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addRange(String range) {
        this.ranges.add(new IdRange(range));
    }

    public void detectInvalids() {
        for(IdRange range: this.ranges) {
           this.invalidIds.addAll(this.getInvalidIdsInRange(range));
        }
    }
    
    public ArrayList<Long> getInvalidIdsInRange(IdRange range) {
        ArrayList<Long> invalidIdsInRange = new ArrayList<>();

        final HashMap<String, Long> bounds = range.getRangeBounds();
        long lowerBound = bounds.get("lowerBound");
        long upperBound = bounds.get("upperBound");
        
        for(long id = lowerBound; id <= upperBound; id++) {
            if(this.isInvalid(id)) {
                invalidIdsInRange.add(id);
            }
        }

        return invalidIdsInRange;
    }
    
    public boolean isInvalid(long id) {
        if(String.valueOf(id).length() % 2 != 0) {
            return false;
        }
        
        long[] halves = this.getIdHalves(id);
        
        long firstHalf = halves[0];
        long secondHalf = halves[1];
        
        if(firstHalf == secondHalf) {
            return true;
        }
        
        return false;
    }

    public long[] getIdHalves(long id) {
        String idString = String.valueOf(id);
        
        int index = 0;
        
        String firstHalf = "";
        while(index < idString.length() / 2) {
            firstHalf += idString.charAt(index);
            index++;
        }
        
        String secondHalf = "";
        while(index <  idString.length()) {
            secondHalf += idString.charAt(index);
            index++;
        }

        long[] halves = {Long.valueOf(firstHalf), Long.valueOf(secondHalf)};
        return halves;
    } 

    public long getSumOfInvalidIds() {
        if(this.invalidIds.isEmpty()) {
            return 0;
        }
        
        long sum = 0;

        for(long invalidId: this.invalidIds) {
            sum += invalidId;
        }
        
        return sum;
    }
}
