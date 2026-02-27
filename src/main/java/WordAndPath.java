import java.util.ArrayList;
import java.util.List;

public class WordAndPath {

    private String word;
    private List<int[]> path;

    public WordAndPath(String word, List<int[]> path) {
        this.word = word;
        this.path = new ArrayList<>(path);
    }

    public String getWord() {
        return word;
    }

    public List<int[]> getPath() {
        return path;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WordAndPath other = (WordAndPath) obj;
        return this.word.equals(other.word);
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }
}
