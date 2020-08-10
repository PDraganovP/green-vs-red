package game;

import java.util.Scanner;

/**
 * The class includes methods that read grid size, generation Zero grid,
 * cell location coordinates(X,Y) and last generation grid(number
 * of the grid generations excluded Generation Zero) from the console
 */
public class UserInput {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Return integer array with number of the grid rows and columns after they were
     * read from the console
     *
     * @return integer array that contains the number of the grid rows and
     * the number of the grid columns
     */
    public int[] getGridSize() {
        int[] gridSize = new int[2];
        int gridColumns = 0;
        int gridRows = 0;

        do {
            String[] gridSizeReadFromTheConsole = readGridSizeFromTheConsole();
            int[] parsedGridSize = parseGridSize(gridSizeReadFromTheConsole);
            gridRows = parsedGridSize[0];
            gridColumns = parsedGridSize[1];

        } while (gridColumns > gridRows || gridRows >= 1000 || gridColumns <= 0 || gridRows <= 0);

        gridSize[0] = gridRows;
        gridSize[1] = gridColumns;

        return gridSize;
    }

    /**
     * Return generation Zero grid after it was read from the console
     *
     * @param gridRows    number of the grid rows
     * @param gridColumns number of the grid columns
     * @return a matrix(Generation Zero grid)
     */
    public int[][] getGenerationZeroGrid(int gridRows, int gridColumns) {
        int[][] generationZeroGrid = new int[gridRows][gridColumns];
        System.out.println("Please enter Generation Zero grid");
        for (int i = 0; i < gridRows; i++) {
            String gridRowComponent = "";
            int numberOfRowElements = 0;
            do {
                gridRowComponent = this.scanner.nextLine();
                numberOfRowElements = gridRowComponent.length();
                checkLineLength(gridColumns, numberOfRowElements);

            } while (numberOfRowElements != gridColumns);
            for (int j = 0; j < gridColumns; j++) {
                char character = gridRowComponent.charAt(j);
                int rowElement = Integer.parseInt(String.valueOf(character));
                generationZeroGrid[i][j] = rowElement;
            }
        }
        return generationZeroGrid;
    }

    /**
     * Return integer array with coordinates X and Y. The array contains and N(
     * number of the grid generations excluded Generation Zero).Information is read
     * from the console
     *
     * @return integer array that contains the row and the column coordinates where
     * the cell is located.The array contains and N that is the last grid generation(
     * number of the grid generations excluded Generation Zero)
     */
    public int[] getLastLineArguments() {
        String[] lastLineArgumentsReadFromTheConsole = readLastLineArgumentsFromTheConsole();
        int[] parsedLastLineArguments = parseLastLineArguments(lastLineArgumentsReadFromTheConsole);

        return parsedLastLineArguments;

    }

    /**
     * Read grid size from the console
     *
     * @return String array that contains grid size read from the console
     */
    private String[] readGridSizeFromTheConsole() {
        System.out.println("Please enter grid size in format x,y\n" +
                "where x is grid width and y is grid height\n" +
                "Your input has to be in this range x <= y < 1000");
        String lineWithGridSize = this.scanner.nextLine();
        String[] gridSizeReadFromTheConsole = lineWithGridSize.split(",");

        return gridSizeReadFromTheConsole;
    }

    /**
     * Parse grid size read from the console
     *
     * @param gridSizeReadFromTheConsole grid size read from the console
     * @return integer array that contains parsed grid size read from the console
     */
    private int[] parseGridSize(String[] gridSizeReadFromTheConsole) {
        String gridWidthComponent = gridSizeReadFromTheConsole[0].trim();
        String gridHeightComponent = gridSizeReadFromTheConsole[1].trim();

        int gridRows = Integer.parseInt(gridHeightComponent);
        int gridColumns = Integer.parseInt(gridWidthComponent);
        int[] parsedGridSize = new int[2];
        parsedGridSize[0] = gridRows;
        parsedGridSize[1] = gridColumns;
        return parsedGridSize;
    }

    /**
     * Check if number of the grid columns is equal with number of the row characters
     *
     * @param gridColumns         the number of the grid columns
     * @param numberOfRowElements the number of the characters that line has
     */
    private void checkLineLength(int gridColumns, int numberOfRowElements) {
        boolean isInputCorrect = numberOfRowElements == gridColumns;

        if (!isInputCorrect) {
            System.out.printf("Please enter correct data.\n" +
                    "The line has to be long %d characters\n" +
                    "and contain only 0s and/or 1s\n", gridColumns);
        }
    }


    /**
     * Read  the last line arguments from the console
     *
     * @return String array that contains  the last line arguments read from the console
     */
    private String[] readLastLineArgumentsFromTheConsole() {
        String[] lastLineArgumentsReadFromTheConsole = null;

        System.out.println("Please enter coordinates x and y and generation N");
        do {
            String cellCoordinatesAndN = this.scanner.nextLine();
            lastLineArgumentsReadFromTheConsole = cellCoordinatesAndN.split(",");

            if (lastLineArgumentsReadFromTheConsole.length != 3) {
                System.out.printf("Please enter your data in format x1,y1,N\n" +
                        "where x1 and y1 are cell coordinates and N\n" +
                        "is number of generations\n");
            }
        } while (lastLineArgumentsReadFromTheConsole.length != 3);
        return lastLineArgumentsReadFromTheConsole;
    }

    /**
     * Parse the last line arguments read from the console
     *
     * @param lastLineArgumentsReadFromTheConsole String array that contains the last line
     *                                            arguments read from the console
     * @return integer array that contains parsed  the last line arguments read from
     * the console
     */
    private int[] parseLastLineArguments(String[] lastLineArgumentsReadFromTheConsole) {
        int[] parsedLastLineArguments = new int[3];
        String coordinateXComponent = lastLineArgumentsReadFromTheConsole[0].trim();
        String coordinateYComponent = lastLineArgumentsReadFromTheConsole[1].trim();
        String nComponent = lastLineArgumentsReadFromTheConsole[2].trim();
        int columnCoordinate = Integer.parseInt(coordinateXComponent);
        int rowCoordinate = Integer.parseInt(coordinateYComponent);
        int n = Integer.parseInt(nComponent);

        parsedLastLineArguments[0] = rowCoordinate;
        parsedLastLineArguments[1] = columnCoordinate;
        parsedLastLineArguments[2] = n;

        return parsedLastLineArguments;
    }
}
