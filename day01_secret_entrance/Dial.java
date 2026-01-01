package day01_secret_entrance;
import java.util.ArrayList;

public class Dial {
    private int currentPosition;
    private int pointedAtZero;

    public Dial(int currentPosition) {
        this.currentPosition = currentPosition;
        this.pointedAtZero = 0;
    }

    public void rotate(ArrayList<String> directions, ArrayList<Integer> distances) {
        for(int index = 0; index < directions.size(); index++) {
            if(directions.get(index).equals("R")) {
                for(int clicks = 0; clicks < distances.get(index); clicks++) {
                    this.currentPosition++;

                    if(this.currentPosition > 99) {
                        this.currentPosition = 0;
                    }
                }
            }

            if(directions.get(index).equals("L")) {
                for(int clicks = 0; clicks < distances.get(index); clicks++) {
                    this.currentPosition--;

                    if(this.currentPosition < 0) {
                        this.currentPosition = 99;
                    }
                }
            }
            
            if(this.currentPosition == 0) {
                this.pointedAtZero++;
            }
        }
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    public int getAnswer() {
        return this.pointedAtZero;
    }
}