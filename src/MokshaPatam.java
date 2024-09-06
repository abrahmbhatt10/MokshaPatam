import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: Agastya Brahmbhatt
 *
 */

public class MokshaPatam {

    /*
        This will return the next square value depending on the amount of
        ladders, snakes, and the current square on the board.
     */
    public static int getNextSquare(int currentPosition, int[][] ladders, int[][] snakes){
        int nextPosition = 0;
        for(int i = 0; i < ladders.length; i++)
        {
            if(currentPosition == ladders[i][0])
            {
                nextPosition = ladders[i][1];
                break;
            }
        }
        for(int i = 0; i < snakes.length; i++)
        {
            if(currentPosition == snakes[i][0])
            {
                nextPosition = snakes[i][1];
                break;
            }
        }
        if(nextPosition == 0)
        {
            nextPosition = currentPosition;
        }
        return nextPosition;
    }

    public static boolean isEnd(int boardSize, int currentPosition)
    {
        if(currentPosition == boardSize)
        {
            return true;
        }
        return false;
    }

    public static int getNumRolls(MokshaNode pNode){
        if(pNode == null){
            return -1;
        }
        int numRolls = 0;
        MokshaNode parentNode = null;
        MokshaNode cNode = pNode;
        while(cNode != null){
            if(cNode.getSquareValue() != 0)
                numRolls++;
            System.out.println(cNode.getSquareValue()+" ");
            cNode = cNode.getParentNode();
        }
        return numRolls;
    }
    /**
     * fewestMoves() returns the minimum number of moves
     *  to reach the final square on a board with the given size, ladders, and snakes.
     */
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {
        Queue<MokshaNode> mBoard= new LinkedList<MokshaNode>();
        mBoard.removeAll(mBoard);
        /*
            Added the first position to the Queue.
         */
        MokshaNode pNode = new MokshaNode();
        mBoard.add(pNode);
        /*
        While there are still nodes left in the queue:
        currentNode = queue.remove()
        If currentNode == last square, return its roll #!
        For each roll (1-6), r:
        node = the node r spaces away.
        If it is the beginning of a snake/ladder:
        node = the ending node of the snake/ladder
        If node has never been visited:
        Save the # of rolls it took to get to node
        Add node to the back of the queue
         */
        boolean playDice = true;
        int currentPosition = 0;
        MokshaNode startNode = null;
        int nextPosition = 0;
        MokshaNode newNode = null;
        boolean[] isVisited = new boolean[boardsize + 1];
        for(int i = 1; i < boardsize + 1; i++){
            isVisited[i] = false;
        }
        isVisited[0] = true;
        while(playDice)
        {
            startNode = mBoard.remove();
            if((startNode != null) && (startNode.getSquareValue() == boardsize)){
                return getNumRolls(startNode);
            }
            currentPosition = startNode.getSquareValue();
            for(int diceValue = 1; diceValue < 7; diceValue++){
                if(currentPosition + diceValue > boardsize){
                    continue;
                }
                currentPosition += diceValue;
                nextPosition = getNextSquare(currentPosition, ladders, snakes);
                if(isVisited[nextPosition] == false)
                {
                    newNode = new MokshaNode(nextPosition,startNode);
                    mBoard.add(newNode);
                    isVisited[nextPosition] = true;
                    if(currentPosition != nextPosition){
                        isVisited[currentPosition] = true;
                    }
                }
            }
        }
        return -1;
    }
}