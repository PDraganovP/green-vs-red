package game;

import java.util.Arrays;

public class Grid {

    public int getGenerationsTheCellWasGreen(int[][] generationZeroGrid, int rowCoordinate, int columnCoordinate, int n) {
        int[][] grid = generationZeroGrid;
        int numberOfGenerationTheCellWasGreen = 0;
        int cellYX = generationZeroGrid[rowCoordinate][columnCoordinate];

        if (cellYX == 1) {
            numberOfGenerationTheCellWasGreen++;
        }
        for (int i = 0; i < n; i++) {
            int[][] nextGenerationGrid = getNextGridGeneration(grid);
            grid = nextGenerationGrid;

            cellYX = grid[rowCoordinate][columnCoordinate];

            if (cellYX == 1) {
                numberOfGenerationTheCellWasGreen++;
            }

            //Print next grid generation if you want to see it
           /* System.out.println("----------------------------");
            printGrid(nextGenerationGrid);
            System.out.println("-----------" + i + "-------------");*/
        }

        return numberOfGenerationTheCellWasGreen;
    }

    private int[][] getNextGridGeneration(int[][] grid) {
        int numberOfRows = grid.length;
        int numberOfColumns = grid[0].length;

        int[][] nextGridGeneration = new int[numberOfRows][numberOfColumns];

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                int greenCellCounter = 0;
                int gridColor = grid[i][j];

                if (i - 1 >= 0 && j - 1 >= 0) {
                    int upperLeftElement = grid[i - 1][j - 1];
                    if (upperLeftElement == 1) {
                        greenCellCounter++;
                    }
                }
                if (i - 1 >= 0) {
                    int upperElement = grid[i - 1][j];
                    if (upperElement == 1) {
                        greenCellCounter++;
                    }
                }
                if (i - 1 >= 0 && j + 1 < numberOfColumns) {
                    int upperRightElement = grid[i - 1][j + 1];
                    if (upperRightElement == 1) {
                        greenCellCounter++;
                    }
                }
                if (j - 1 >= 0) {
                    int leftElement = grid[i][j - 1];
                    if (leftElement == 1) {
                        greenCellCounter++;
                    }
                }
                if (j + 1 < numberOfColumns) {
                    int rightElement = grid[i][j + 1];
                    if (rightElement == 1) {
                        greenCellCounter++;
                    }
                }
                if (i + 1 < numberOfRows && j - 1 >= 0) {
                    int bottomLeftElement = grid[i + 1][j - 1];
                    if (bottomLeftElement == 1) {
                        greenCellCounter++;
                    }
                }
                if (i + 1 < numberOfRows) {
                    int bottomElement = grid[i + 1][j];
                    if (bottomElement == 1) {
                        greenCellCounter++;
                    }
                }
                if (i + 1 < numberOfRows && j + 1 < numberOfColumns) {
                    int bottomRightElement = grid[i + 1][j + 1];
                    if (bottomRightElement == 1) {
                        greenCellCounter++;
                    }
                }
                Cell cell = new Cell();
                int newCellColor = cell.changeCellColor(gridColor, greenCellCounter);
                nextGridGeneration[i][j] = newCellColor;
            }
        }

        return nextGridGeneration;

    }

    private void printGrid(int[][] matrix) {
        int numberOfRows = matrix.length;

        for (int i = 0; i < numberOfRows; i++) {
            System.out.println(Arrays.toString(matrix[i]));

        }

    }
}
