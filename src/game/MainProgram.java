package game;

public class MainProgram {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        int[] gridSize = userInput.getGridSize();
        int gridRows = gridSize[0];
        int gridColumns = gridSize[1];

        int[][] generationZeroGrid = userInput.getGenerationZeroGrid(gridRows, gridColumns);

        int[] lastLineArguments = userInput.getLastLineArguments();
        int rowCoordinate = lastLineArguments[0];
        int columnCoordinate = lastLineArguments[1];
        int n = lastLineArguments[2];

        Grid grid = new Grid();
        int numberOfGenerationsTheCellWasGreen = grid.getNumberOfGenerationsTheCellWasGreen(generationZeroGrid, rowCoordinate, columnCoordinate, n);

        // Variant I. Only print number of generations the cell was green
        System.out.println(numberOfGenerationsTheCellWasGreen);

        //Variant II. Here program print message in the console
       /* System.out.printf("The cell with coordinates [%d,%d] was green\n" +
                "%d generations including Generation Zero and generation N", columnCoordinate, rowCoordinate, generationsTheCellWasGreen);*/

    }
}
