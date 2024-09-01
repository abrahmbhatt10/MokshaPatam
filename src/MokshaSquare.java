public class MokshaSquare {
    private int squareValue;
    private int squareType; //0 is for a regular square, 1 is for a ladder, and 2 is for a snake.
    private int nextSquare; //
    private int numRollsToReachMe;

    public MokshaSquare(int squareValue, int squareType, int nextSquare, int numRollsToReachMe) {
        this.squareValue = squareValue;
        this.squareType = squareType;
        this.nextSquare = nextSquare;
        this.numRollsToReachMe = numRollsToReachMe;
    }

    public MokshaSquare() {
        this.squareValue = 0;
        this.squareType = 0;
        this.nextSquare = 0;
        this.numRollsToReachMe = -1;
    }



    public int getSquareValue() {
        return squareValue;
    }

    public void setSquareValue(int squareValue) {
        this.squareValue = squareValue;
    }

    public int getSquareType() {
        return squareType;
    }

    public void setSquareType(int squareType) {
        this.squareType = squareType;
    }

    public int getNextSquare() {
        return nextSquare;
    }

    public void setNextSquare(int nextSquare) {
        this.nextSquare = nextSquare;
    }

    public int getNumRollsToReachMe() {
        return numRollsToReachMe;
    }

    public void setNumRollsToReachMe(int numRollsToReachMe) {
        this.numRollsToReachMe = numRollsToReachMe;
    }
}
