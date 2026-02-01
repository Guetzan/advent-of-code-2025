import java.util.HashMap;

public class IdRange {
    private final String range;//formato: "lowerBound-upperBound"

    public IdRange(String range) {
        this.range = range;
    }

    public HashMap<String, Long> getRangeBounds() {
        HashMap<String, Long> bounds = new HashMap<>();
        
        String[] splittedRange = this.range.split("-");
        
        if(splittedRange.length != 2) {
            return null;
        }

        long lowerBound = Long.valueOf(splittedRange[0]);
        long upperBound = Long.valueOf(splittedRange[1]);

        if(lowerBound > upperBound) {
            return null;
        }

        bounds.put("lowerBound", lowerBound);
        bounds.put("upperBound", upperBound);

        return bounds;
    }
}
