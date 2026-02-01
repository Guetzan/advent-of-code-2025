/*

1 - separar os ranges em uma lista
2 - percorrer a lista de ranges
3 - dentro de cada range, verificar se existe um numero dobrado

*/

import java.util.Arrays;

class GiftShop {
    public static void main(String[] args) {
        String inputPath = "inputs/day02_input.txt";
        RangesReader reader = new RangesReader(inputPath);

        String[] ranges = reader.createRangesListFromInputFile();
        reader.checkForInvalidIdsInRange("1188511880-1188511890");
    }
}