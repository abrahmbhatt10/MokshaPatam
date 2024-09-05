import java.util.ArrayList;

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
    private static MokshaPath mBoard;
    private static MokshaPath pathsList;

    public MokshaPatam() {
        this.mBoard = new MokshaPath();
        this.pathsList = new MokshaPath();
    }


    /**
     * This function fewestMoves() returns the minimum number of moves
     * to reach the final square on a board with the given size, ladders, and snakes.
     */
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {
        if(boardsize < 1 || boardsize > 400)
        {
            System.out.println("Boardsize is wrong");
            return -1;
        }
        if(ladders.length < 1 || ladders.length > 15)
        {
            System.out.println("Laddersize is wrong");
            return -1;
        }
        if(snakes.length < 1 || snakes.length > 15)
        {
            System.out.println("Snakesize is wrong");
            return -1;
        }
        // Initializing the board
        MokshaSquare pSquare = null;
        mBoard.squaresList.removeAll(mBoard.squaresList);
        pathsList.squaresList.removeAll(pathsList.squaresList);
        boolean hasLadder = false;
        boolean hasSnake = false;
        int mSquareType = 0;
        int mNextSquare = 0;
        for(int i = 0; i < boardsize + 1; i++)
        {
            hasLadder = false;
            for(int j = 0; j < ladders.length; j++)
            {
                if(i == ladders[j][0])
                {
                    hasLadder = true;
                    mNextSquare = ladders[j][1];
                    break;
                }
            }
            hasSnake = false;
            for(int a = 0; a < snakes.length; a++)
            {
                if(i == snakes[a][0])
                {
                    hasSnake = true;
                    mNextSquare = snakes[a][1];
                    break;
                }
            }
            if(hasLadder == true){
                mSquareType = 1;
            }
            else if(hasSnake == true)
            {
                mSquareType = 2;
            }
            else {
                mSquareType = 0;
                mNextSquare = i;
            }
            pSquare = new MokshaSquare(i, mSquareType, mNextSquare);
            mBoard.add(i);
        }
        System.out.println("Mboard Size: " + (mBoard.size() - 1));
        // Finding All Paths
        int fewest = rollDice(boardsize);
        return fewest;
    }

    public static MokshaSquare getSquare(int index)
    {
        return mBoard.get(index);
    }

    public static int getTraverseNode(int currentSquareValue, int dieValue, int boardSize)
    {
        MokshaSquare pSquare = null;
        if((currentSquareValue + dieValue) > boardSize)
        {
            return -1;
        }
        pSquare = getSquare(currentSquareValue + dieValue);
        return pSquare.getNextSquare();
    }

    public static int rollDice(int boardSize)
    {
        /*
        Add the first node, 1, to the queue
            While there are still nodes left in the queue:
	            Pop off the node at the front and visit it.
	                If we are at the end of the graph, then we are done!
	                    Check all the edges that extend out of this node:
		            If any of them are unvisited:
			            add them to the back of the queue
         */
        MokshaSquare firstSquare = new MokshaSquare();
        pathsList.squaresList.add(firstSquare.getSquareValue());
        for(int j = 1; j < 7; j++){

        }


        /*
        // Initial dice roll when paths are 0.
        MokshaPath pPath = null;
        MokshaPath pNewPath = null;
        for(int i = 6; i > 0; i--)
        {
            pPath = new MokshaPath();
            pPath.addSquare(getTraverseNode(0,i, boardSize), boardSize);
            addPathToList(pPath);
        }
        int fewest = 0;
        for(int i = 0; i < getPathsListSize(); i++)
        {
            pPath = getPathsListIndex(i);
            if(!pPath.isDone())
            {
                for(int j = 6; j > 0; j--)
                {
                    //System.out.println("sourcePath:");
                    //System.out.println(pPath.getSquaresList());
                    if(j == 1)
                    {
                        pPath.addSquare(getTraverseNode(pPath.getLastSquare(), 6, boardSize), boardSize);
                    }
                    else
                    {
                        pNewPath = new MokshaPath();
                        pNewPath.setSquaresList(pPath);
                        pNewPath.addSquare(getTraverseNode(pPath.getLastSquare(), j, boardSize), boardSize);
                        // System.out.println(pNewPath.getSquaresList());
                        addPathToList(pNewPath);
                    }
                }
            }
                fewest = 0;
                for(int k = 0; k < getPathsListSize(); k++){
                    pPath = getPathsListIndex(k);
                    if(pPath.isDone())
                    {
                        System.out.println("Successful " + pPath.toString());
                        if((fewest == 0) || (fewest > pPath.getNumberOfRolls()))
                        {
                            fewest = pPath.getNumberOfRolls();
                        }
                    }
                }
                if(fewest != 0)
                {
                    return fewest;
                }
            }
         */
        return -1;
    }
}
