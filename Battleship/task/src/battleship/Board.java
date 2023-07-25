package battleship;

import java.util.Arrays;

public class Board {
    //[10][10] array, each position with 3 possible values
    private Cell[][] cells;

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

    private boolean placeBoat(String coordinates) {
        char row1 = coordinates.charAt(0);
        char column1 = coordinates.charAt(1);
        char row2 = coordinates.charAt(3);
        char column2 = coordinates.charAt(4);

        boolean placementIsValid = false;

        if (row1 == row2 || column1 == column2) {
            placementIsValid = true;
        }


        return placementIsValid;
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
