package battleship;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Write your code here
        Board board = new Board();
        Scanner scan = new Scanner(System.in);

        System.out.println(board);

        System.out.println(board.askForCoordinatesText(5));
        String coordinate = scan.nextLine();
    }

}
