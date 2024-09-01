import java.util.ArrayList;

public class MokshaPath {
    private ArrayList<Integer> squaresList;
    private boolean isDone;

    public MokshaPath() {
        this.squaresList = new ArrayList<Integer>();
        isDone = false;
    }

    public ArrayList<Integer> getSquaresList() {
        return squaresList;
    }

    public void setSquaresList(MokshaPath sourcePath) {
        this.squaresList = (ArrayList<Integer>) sourcePath.getSquaresList().clone();
        //System.out.println(squaresList);
    }

    public int addSquare(int squareValue, int boardSize)
    {
        //System.out.println("Square Value: " + squareValue + " Board Size: " + boardSize);
        if(squareValue < 0 || squareValue > boardSize)
        {
            return -1;
        }
        squaresList.add(squareValue);
        if(squareValue == boardSize)
        {
            setDone(true);
        }
        //System.out.println("Add Square: " + squaresList);
        return 0;
    }

    public int getNumberOfRolls()
    {
        return squaresList.size();
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public int getLastSquare()
    {
        if((squaresList == null) || squaresList.size() <= 0)
        {
            return 0;
        }
        return squaresList.getLast();
    }

    public String toString()
    {
        String pString = "Path is ";
        for(int i = 0; i < squaresList.size(); i++)
        {
            pString += squaresList.get(i) + " ";
        }
        pString += "Number of Rolls: " + getNumberOfRolls();
        return pString;
    }

}
