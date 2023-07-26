package battleship;

import java.util.Scanner;

public class Main {

    public static void testSomething(int i, int j, Board board) {
        board.cells[i][j] = Cell.M;
        System.out.println(board);
    }

    public static String testCheckCell(String c, Board board) {
        return c + ": " + board.checkCellAvailavility(c.charAt(0) - 65, Integer.parseInt((c.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)")[1])) - 1);
    }

    public static void main(String[] args) {
        // Write your code here
        Board board = new Board();
        Scanner scan = new Scanner(System.in);

        System.out.println(board);
        System.out.println(testCheckCell("B2", board));
        System.out.println(testCheckCell("A1", board));
        board.cells[1][1] = Cell.X;
        System.out.println(board);
        System.out.println(testCheckCell("A2", board));
        System.out.println(testCheckCell("B1", board));
        System.out.println(testCheckCell("B3", board));
        System.out.println(testCheckCell("C1", board));
        System.out.println(testCheckCell("A1", board));
        System.out.println(testCheckCell("A3", board));
        System.out.println(testCheckCell("C1", board));
        System.out.println(testCheckCell("C3", board));






        for (int i = 5; i > 2; i--) {
            System.out.println(board.askForCoordinatesText(i));
            board.placeBoat(scan.nextLine(), i);
            System.out.println(board);

        }


    }

}
