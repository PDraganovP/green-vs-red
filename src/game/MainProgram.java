package game;

public class MainProgram {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        int[] gridSize = userInput.getGridSize();
        int gridRows = gridSize[0];
        int gridColumns = gridSize[1];

        int[][] generationZeroGrid = userInput.getGenerationZeroGrid(gridRows, gridColumns);

        int[] coordinatesAndN = userInput.getCoordinatesAndN();
        int rowCoordinate = coordinatesAndN[0];
        int columnCoordinate = coordinatesAndN[1];
        int n = coordinatesAndN[2];

        Grid grid = new Grid();
        int generationsTheCellWasGreen = grid.getGenerationsTheCellWasGreen(generationZeroGrid, rowCoordinate, columnCoordinate, n);

        // Variant I. Only print number of generation the cell was green
        System.out.println(generationsTheCellWasGreen);

        //Variant II. Here program print message in the console
       /* System.out.printf("The cell with coordinates [%d,%d] was green\n" +
                "%d generations including Generation Zero and generation N", columnCoordinate, rowCoordinate, generationsTheCellWasGreen);*/

    }
}
