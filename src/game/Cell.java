package game;

public class Cell {

    public int changeCellColor(int cellColor, int greenCellCounter) {
        int newCellColor = 0;
        switch (cellColor) {
            case 0:
                newCellColor = paintRed(greenCellCounter);
                break;
            case 1:
                newCellColor = paintGreen(greenCellCounter);
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
    private int paintRed(int colorCounter) {

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
    private int paintGreen(int colorCounter) {
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
