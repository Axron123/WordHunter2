import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BoardSolver {
    private int rows;
    private int columns;
    private Board board;
    private boolean[][] visited;
    private Trie dictionary;
    private List<int[]> currentPath;
    private Set<WordAndPath> wordAndPathSet;
    private List<WordAndPath> sortedWordAndPathList;

    public BoardSolver(Board boardToSolve, Trie dictionary) {
        this.board = boardToSolve;
        rows = boardToSolve.getRows();
        columns = boardToSolve.getColumns();
        this.visited = new boolean[rows][columns];
        this.dictionary = dictionary;
        this.currentPath = new ArrayList<>();
        this.wordAndPathSet = new HashSet<>();
    }


    private void dfs(int currentRow, int currentColumn, StringBuilder prefix, List<int[]> currentPath) {
        //set current node as visited
        visited[currentRow][currentColumn] = true;

        // append the current char to prefix string
        prefix.append(board.getChar(currentRow, currentColumn));

        //append the current node coordinate to arrayList
        currentPath.add(new int[] {currentRow, currentColumn});

        //prune after appending the new char
        if(!dictionary.containsPrefix(prefix.toString())) {

            //once all valid neighbors have been visited, backtrack by setting the current node as unvisited
            visited[currentRow][currentColumn] = false;

            //remove the last character added to the stringbuilder
            prefix.deleteCharAt(prefix.length()-1);

            //remove the last node coordinate added to the arrayList
            currentPath.remove(currentPath.size() - 1);
            return;

        }





        if (prefix.length() >=3 && dictionary.containsWord(prefix.toString())) {

            //add valid word path object to wordAndPathList, store copy of prefix and currentPath
            wordAndPathSet.add(new WordAndPath(prefix.toString(), new ArrayList<>(currentPath)));

            //print prefix to console
            //System.out.println(prefix);

        }


        //implement neighbor movement logic
        int[][] movement = {
                {-1,-1}, //UL
                {-1, 0}, //U
                {-1, 1}, //UR
                {0, 1}, //R
                {1, 1}, //DR
                {1, 0}, //D
                {1, -1}, //DL
                {0, -1}, //L
        };

        //check if move is inside array bounds and if move is to an unvisited neighbor
        for (int[] direction : movement) {

            int newRow = currentRow + direction[0];
            int newColumn = currentColumn + direction[1];

            if (!isValid(newRow, newColumn) || visited[newRow][newColumn]) {
                continue;
            }

            //if the new node is valid call dfs recursively
            dfs(newRow, newColumn, prefix, currentPath);
        }

        //once all valid neighbors have been visited, backtrack by setting the current node as unvisited
        visited[currentRow][currentColumn] = false;

        //remove the last character added to the stringbuilder
        prefix.deleteCharAt(prefix.length()-1);

        //remove the last node coordinate added to the arrayList
        currentPath.remove(currentPath.size() - 1);
    }

    private boolean isValid(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public void boardSolver() {

        //loop through each node of the board
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                dfs(row, col, new StringBuilder(), new ArrayList<>());
            }
        }

        sortedWordAndPathList = new ArrayList<>(wordAndPathSet);

        //sort longest words first
        sortedWordAndPathList.sort((a, b) -> b.getWord().length() - a.getWord().length());
        for (WordAndPath wordAndPath : sortedWordAndPathList) {
            System.out.println(wordAndPath.getWord());
        }
    }

    public List<WordAndPath> getWordAndPathList() {
        return sortedWordAndPathList;
    }

}
