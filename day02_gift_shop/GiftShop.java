/*

1 - separar os ranges em uma lista
2 - percorrer a lista de ranges
3 - dentro de cada range, verificar se existe um numero dobrado


todo: identificar o erro lógico e corrigir, retornando a soma incorreta.
*/

import java.util.Arrays;

class GiftShop {
    public static void main(String[] args) {
        String inputPath = "inputs/day02_input.txt";
        InvalidIdsIdentifier reader = new InvalidIdsIdentifier(inputPath);

        
        System.out.println("Sum: " + reader.getSumOfInvalidIds());
    }
}