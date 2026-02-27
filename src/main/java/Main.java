import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        // 1. Set up board and dictionary


        char[][] board = new char[4][4];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < board.length; i++) {
            System.out.println("Enter characters for row: " + i);
            String rowChars = input.next().toUpperCase();
            for (int j = 0; j < board[1].length; j++) {


                board[i][j] = rowChars.charAt(j);
            }
        }
        Board wordHuntBoard = new Board(board);
        Trie dictionary = new Trie();
        DictionaryLoader.loadDictionary(dictionary, "Dictionary2.txt");
        wordHuntBoard.printBoard();

        //wait 5 seconds before beginning auto solve
        Thread.sleep(2500);

        //Solve board
        BoardSolver solver = new BoardSolver(wordHuntBoard, dictionary);
        solver.boardSolver();



        //Start swipe automation
        SwipeAutomation automation = new SwipeAutomation(1200, 487, 71, 71);
        automation.startAutomation(solver.getWordAndPathList());


    }
}