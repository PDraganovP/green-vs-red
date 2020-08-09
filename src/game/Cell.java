package game;

/**
 * The class includes method that change the cell color
 */
public class Cell {
    /**
     * Change the color of the cell
     *
     * @param cellColor        can be 0 or 1.The cell color with 0 is equal to red
     *                         and cell color with 1 is equal to green
     * @param greenCellCounter number of the green neighbours that
     *                         given cell has
     * @return 0 or 1. If cellColor parameter  is not 0 or 1 the method
     * return -1
     */
    public int changeCellColor(int cellColor, int greenCellCounter) {
        int newCellColor = 0;
        switch (cellColor) {
            case 0:
                newCellColor = paintRedCell(greenCellCounter);
                break;
            case 1:
                newCellColor = paintGreenCell(greenCellCounter);
                break;
            default:
                newCellColor = -1;
                break;
        }
        return newCellColor;

    }

    //  red = 0 and green = 1
    //  1. Each red cell that is surrounding by exactly 3 or
    //  exactly 6 green cells will also become green in the next generation.
    //  2.  A red cell will stay red in the next generation if it has either
    //  0, 1, 2, 4, 5, 7 or 8 green neighbours.

    /**
     * Pain cell that was red
     *
     * @param colorCounter the number of the green color neighbours that given
     *                     cell has
     * @return 0 or 1. If the colorCounter is not in range from 0 to 8 included
     * method return -1
     */
    private int paintRedCell(int colorCounter) {

        int cellColor = 0;
        switch (colorCounter) {
            case 0:
            case 1:
            case 2:
            case 4:
            case 5:
            case 7:
            case 8:
                cellColor = 0;
                break;
            case 3:
            case 6:
                cellColor = 1;
                break;
            default:
                cellColor = -1;
                break;

        }
        return cellColor;
    }

    //  3. Each green cell surrounded by 0, 1, 4, 5, 7 or 8 green neighbours
    //  will become red in the next generation.
    //  4. A green cell will stay green in the next generation  if it has
    //  either 2, 3 or 6 green neighbours.

    /**
     * Paint cell that was green
     *
     * @param colorCounter the number of the green color neighbours that given
     *                     cell has
     * @return 0 or 1. If the colorCounter is not in range from 0 to 8 included
     * method return -1
     */
    private int paintGreenCell(int colorCounter) {
        int cellColor = 0;
        switch (colorCounter) {
            case 0:
            case 1:
            case 4:
            case 5:
            case 7:
            case 8:
                cellColor = 0;
                break;
            case 2:
            case 3:
            case 6:
                cellColor = 1;
                break;
            default:
                cellColor = -1;
                break;

        }

        return cellColor;
    }
}
