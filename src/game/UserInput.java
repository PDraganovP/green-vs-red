package game;

import java.util.Scanner;

public class UserInput {

    private Scanner scanner = new Scanner(System.in);

    public int[] getGridSize() {
        int[] gridSize = new int[2];
        int gridColumns = 0;
        int gridRows = 0;

        do {
            System.out.println("Please enter grid size in format x,y\n" +
                    "where x is grid width and y is grid height\n" +
                    "Your input has to be in this range x <= y < 1000");
            String lineWithGridSize = this.scanner.nextLine();
            String[] gridSizeComponents = lineWithGridSize.split(",");
            String gridWidthComponent = gridSizeComponents[0].trim();
            String gridHeightComponent = gridSizeComponents[1].trim();

            gridColumns = Integer.parseInt(gridWidthComponent);
            gridRows = Integer.parseInt(gridHeightComponent);


        } while (gridColumns > gridRows || gridRows >= 1000 || gridColumns <= 0 || gridRows <= 0);

        gridSize[0] = gridRows;
        gridSize[1] = gridColumns;

        return gridSize;
    }

    public int[][] getGenerationZeroGrid(int gridRows, int gridColumns) {
        int[][] generationZeroGrid = new int[gridRows][gridColumns];
        System.out.println("Please enter Generation Zero grid");
        for (int i = 0; i < gridRows; i++) {
            String gridRowComponent = "";
            int numberOfRowElements = 0;
            do {

                gridRowComponent = this.scanner.nextLine();
                numberOfRowElements = gridRowComponent.length();
                boolean isInputCorrect = numberOfRowElements == gridColumns;

                if (!isInputCorrect) {
                    System.out.printf("Please enter correct data.\n" +
                            "The line has to be long %d characters\n" +
                            "and contain only 0s and/or 1s\n", gridColumns);
                }

            } while (numberOfRowElements != gridColumns);
            for (int j = 0; j < gridColumns; j++) {
                char character = gridRowComponent.charAt(j);
                int rowElement = Integer.parseInt(String.valueOf(character));
                generationZeroGrid[i][j] = rowElement;
            }
        }
        return generationZeroGrid;
    }

    public int[] getLastLineArguments() {
        int[] lastLineArguments = new int[3];
        String[] cellCoordinatesAndNComponents = null;

        System.out.println("Please enter coordinates x and y and generation N");
        do {
            String cellCoordinatesAndN = this.scanner.nextLine();
            cellCoordinatesAndNComponents = cellCoordinatesAndN.split(",");

            if (cellCoordinatesAndNComponents.length != 3) {
                System.out.printf("Please enter your data in format x1,y1,N\n" +
                        "where x1 and y1 are cell coordinates and N\n" +
                        "is number of generations\n");
            }
        } while (cellCoordinatesAndNComponents.length != 3);

        String coordinateXComponent = cellCoordinatesAndNComponents[0].trim();
        String coordinateYComponent = cellCoordinatesAndNComponents[1].trim();
        String nComponent = cellCoordinatesAndNComponents[2].trim();
        int columnCoordinate = Integer.parseInt(coordinateXComponent);
        int rowCoordinate = Integer.parseInt(coordinateYComponent);
        int n = Integer.parseInt(nComponent);

        lastLineArguments[0] = rowCoordinate;
        lastLineArguments[1] = columnCoordinate;
        lastLineArguments[2] = n;

        return lastLineArguments;
    }
}
