import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class MokshaPath {
    public Queue<Integer> squaresList;
    private boolean isDone;

    public MokshaPath() {
        this.squaresList = new LinkedList<Integer>();
        isDone = false;
    }

    public Queue<Integer> getSquaresList() {
        return squaresList;
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
        return squaresList.peek();
    }

    public String toString()
    {
        String pString = "Path is ";
        Iterator<Integer> it = squaresList.iterator();
        while (it.hasNext()) {
            Integer sValue = it.next();
            pString += sValue.toString() + " ";
        }
        pString += "Number of Rolls: " + getNumberOfRolls();
        return pString;
    }

}
