package day01_secret_entrance;

public class Main {
    public static void main(String[] args) {
        String[] directions = {"L", "L", "R", "L", "R", "L", "L", "L", "R", "L"};
        int[] distances = {68, 30, 48, 5, 60, 55, 1, 99, 14, 82};
    
        Dial dial = new Dial(50);
    
        dial.rotate(directions, distances);
        System.out.println(dial.getCurrentPosition());
    }
}
