package battleship;

import java.util.Arrays;
import java.util.Scanner;

public class Board {
    //[10][10] array, each position with 3 possible values
    public Cell[][] cells;

    Board() {
        cells = new Cell[10][10];
        for (Cell[] row: cells) {
            Arrays.fill(row, Cell.FOG);
        }
    }

    public String askForCoordinatesText(int boatLength) {
        String boatText = switch (boatLength) {
            case 2 -> "Destroyer (2 cells):";
            case 3 -> "Submarine (3 cells):";
            case 4 -> "Battleship (4 cells):";
            case 5 -> "Aircraft Carrier (5 cells):";
            default -> "";
        };
        return "Enter the coordinates of the " + boatText;
    }

    private String placementState(int length, int row1, int row2, int column1, int column2) {

        if (row1 == row2 && Math.abs(column1 - column2) == length - 1) {
            if (checkPlacementAvailabilityHorizontal(length, row1, row2, column1, column2)) {
                System.out.println("H");
                return "horizontal";
            }
        }

        if (column1 == column2 && Math.abs(row1 - row2) == length - 1) {
            if (checkPlacementAvailabilityVertical(length, row1, row2, column1, column2)) {
                System.out.println("V");
                return "vertical";
            }
        }

        System.out.println("I");
        return "invalid";
    }

    private boolean checkPlacementAvailabilityVertical(int length, int row1, int row2, int column1, int column2) {
        int min = row1 < row2 ? row1 : row2;
        System.out.println(min);

        for(int i = min; i < length + min; i++) {
            if (checkCellAvailavility(column1, i))
                return false;
        }

        return true;
    }

    private boolean checkPlacementAvailabilityHorizontal(int length, int row1, int row2, int column1, int column2) {
        int min = column1 < column2 ? column1 : column2;
        System.out.println(min);

        for(int i = min; i < length + min; i++) {
            if (checkCellAvailavility(i, row1))
                return false;
        }

        return true;
    }

    public void placeBoat(String coordinates, int length) {
        Scanner coordStream = new Scanner(coordinates);

        System.out.println(coordinates);

        int[] coordinateArr = parsePlacementCode(coordinates);

        int row1 = coordinateArr[0];
        int column1 = coordinateArr[1];
        int row2 = coordinateArr[2];
        int column2 = coordinateArr[3];

        System.out.println(column1 + " " + column2);
        System.out.println(row1 + " " + row2);

        String direction = placementState(length, row1, row2, column1, column2);
        if (direction.equals("horizontal")) {
            horizontalFill(row1, row2, column1, column2, length);
        }
        if (direction.equals("vertical")) {
            verticalFill(row1, row2, column1, column2, length);
        }
        else {
            System.out.println(direction);
        }

    }

    public int[] parsePlacementCode(String code) {
        int[] toReturn = new int[4];
        String[] strings = code.split(" ");
        System.out.println(strings[0] + " " + strings[1]);

        toReturn[0] = strings[0].charAt(0) - 65;
        toReturn[2] = strings[1].charAt(0) - 65;

        toReturn[1] = Integer.parseInt((strings[0].split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)")[1])) - 1;
        toReturn[3] = Integer.parseInt((strings[1].split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)")[1])) - 1;

        System.out.println(Arrays.toString(toReturn));

        return toReturn;
    }

    private void horizontalFill(int row1, int row2, int column1, int column2, int length) {
        int min = column1 < column2 ? column1 : column2;
        System.out.println(min);

        for(int i = min; i < length + min; i++) {
            cells[i][row1] = Cell.O;
        }
    }

    private void verticalFill(int row1, int row2, int column1, int column2, int length) {
        int min = row1 < row2 ? row1 : row2;
        System.out.println(min);

        for(int i = min; i < length + min; i++) {
            cells[column1][i] = Cell.O;
        }
    }

    public boolean checkCellAvailavility(int row, int column) {
        System.out.println(row + " " + column);
        if (cellIsOutOfBounds(row, column)) return false;
        if (!cellIsOutOfBounds(row, column) && !cellIsFog(row, column)) return false;
        if (!cellIsOutOfBounds(row, column + 1) && !cellIsFog(row, column + 1)) return false;
        if (!cellIsOutOfBounds(row, column - 1) && !cellIsFog(row, column - 1)) return false;
        if (!cellIsOutOfBounds(row + 1, column) && !cellIsFog(row + 1, column)) return false;
        if (!cellIsOutOfBounds(row - 1, column) && !cellIsFog(row - 1, column)) return false;
        return true;
    }

    public boolean cellIsOutOfBounds(int row, int column) {
        return row > 9 || row < 0 || column > 9 || column < 0;
    }

    public boolean cellIsFog (int row, int column) {
        return this.cells[column + 1][row].equals(Cell.FOG);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("  1 2 3 4 5 6 7 8 9 10");

        for (int i = 0; i < 10; i++) {
            sb.append("\n" + (char)(i + 65));
            for (int j = 0; j < 10; j++) {
                sb.append(" " + cells[j][i]);
            }
        }
        return sb.toString();
    }

}
