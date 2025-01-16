import com.fasp.WordSearch;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class WordSearchTest {

    private static char[][] GRID;

    @BeforeAll
    public static void setup(){
        GRID = new char[][]{
                {'t', 'g', 'o', 'h', 'a', 'n', 'l', 'v', 't', 'z', 'e', 'v', 'e', 'n', 'c', 'o', 'r', 'n', 'a', 'p'},
                {'p', 'm', 'a', 'r', 'a', 'p', 'y', 'e', 'k', 'h', 'r', 'i', 'j', 'o', 'b', 'l', 'i', 'e', 'i', 'g'},
                {'j', 'x', 'p', 'c', 'e', 'u', 'l', 'g', 'a', 'r', 'a', 'd', 'o', 'k', 'u', 'g', 'a', 'c', 'a', 'o'},
                {'a', 'i', 'y', 'e', 'a', 'e', 'a', 'e', 'm', 's', 'r', 'e', 't', 'a', 't', 'a', 'c', 'm', 'a', 'h'},
                {'v', 't', 'a', 't', 'a', 'n', 'z', 't', 'l', 'a', 'a', 'l', 'a', 'a', 'i', 'o', 'a', 'h', 'o', 'g'},
                {'e', 'o', 'm', 'l', 'i', 'e', 'h', 'a', 'u', 'h', 'o', 's', 'e', 'l', 'r', 'a', 'm', 'e', 'n', 'd'},
                {'a', 'g', 'a', 'l', 'r', 'a', 'a', 'm', 'b', 'r', 'o', 'l', 'i', 'o', 'a',  'l', 'l', 'e', 'c', 'a'},
                {'i', 's', 'i', 'b', 'o', 'g', 'a', 'a','e', 't', 'a', 'r', 'f', 'a', 't', 'a', 'm', 'v', 'i', 'o'},
                {'m', 'r', 'a', 'i', 'h', 's', 'o', 'r', 'g', 'o', 'k', 'u', 'a', 'l', 'o', 'a', 'q', 'b', 'p', 'b'},
                {'k', 'f', 'r', 'e', 'e', 'z', 'e', 'r', 's', 'h', 'i', 'a', 'h', 'c', 'm', 'a', 'y', 'a', 'm', 'z'}
        };
    }

    @Test
    public void testAllWordsAreFound() {

        // ARRANGE
        WordSearch wordSearch = new WordSearch(GRID);
        int[] WORD_NOT_FOUND = {-1,-1};

        // ACT
        String[] words = {"goku", "krilin", "cell", "piccoro", "videl", "yamcha","broli","vegeta",  "gohan","bulma",  "roshi", "freezer"};

        // ASSERT
        for (String word : words) {
            int[] indices = wordSearch.find(word);
            assertFalse(Arrays.equals(WORD_NOT_FOUND, indices), word);
            System.out.println(word + " found at: " + Arrays.toString(indices));
        }
    }

    @Test
    public void testFindGoku(){
        testCorrectIndices(new int[]{8, 8}, "goku");
    }

    @Test
    public void testFindKrilin(){
        testCorrectIndices(new int[]{9, 0}, "krilin");
    }

    @Test
    public void testFindCell(){
        testCorrectIndices(new int[]{6, 18}, "cell");
    }

    @Test
    public void testFindPiccoro(){
        testCorrectIndices(new int[]{0, 19}, "piccoro");
    }

    @Test
    public void testFindVidel(){
        testCorrectIndices(new int[]{0, 11}, "videl");
    }

    @Test
    public void testFindYamcha(){
        testCorrectIndices(new int[]{9, 16}, "yamcha");
    }

    @Test
    public void testFindBroli(){
        testCorrectIndices(new int[]{6, 8}, "broli");
    }

    @Test
    public void testFindVegeta(){
        testCorrectIndices(new int[]{0, 7}, "vegeta");
    }

    @Test
    public void testFindGohan(){
        testCorrectIndices(new int[]{0, 1}, "gohan");
    }

    @Test
    public void testFindBulma(){
        testCorrectIndices(new int[]{6, 8}, "bulma");
    }

    @Test
    public void testFindRoshi(){
        testCorrectIndices(new int[]{8, 7}, "roshi");
    }

    @Test
    public void testFindFreezer(){
        testCorrectIndices(new int[]{9, 1}, "freezer");
    }

    private void testCorrectIndices(int[] expectedIndices, String word){
        // ARRANGE
        WordSearch wordSearch = new WordSearch(GRID);
        // ACT
        int[] indices = wordSearch.find(word);
        // ASSERT
        assertArrayEquals(expectedIndices, indices);
    }

}
