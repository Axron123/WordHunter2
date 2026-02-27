import java.util.Scanner;

public class Board {

    private char[][] board;

    public Board(char[][] board) {
        this.board = board;
    }

    public void printBoard() {
        System.out.println("WordHunt Board: ");
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {
                System.out.print(" " + board[i][j] + " ");

            }
            System.out.println();
        }
    }

    public int getRows() {
        return board.length;
    }

    public int getColumns() {
        return board[0].length;
    }

    public char getChar(int row, int col) {
        return board[row][col];
    }

    public void setBoard() {

    }
}
