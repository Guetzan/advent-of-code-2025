package day01_secret_entrance;

public class Dial {
    private int currentPosition;
    private int totalPositions = 100; //do 0 ao 99

    public Dial(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void rotate(String[] directions, int[] distances) {
        for(int index = 0; index < directions.length; index++) {
            for(int clicks = 0; clicks < distances[index]; clicks++) {
                if(directions[index].equals("R")) {
                    this.currentPosition++;

                    if(this.currentPosition > 99) {
                        this.currentPosition = 0;
                        continue;
                    }
                }

                if(directions[index].equals("L")) {
                    this.currentPosition--;

                    if(this.currentPosition < 0) {
                        this.currentPosition = 99;
                        continue;
                    }
                }                
            }
        }
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }
}