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

        int[] indices;
        for (String word : words) {
            indices = wordSearch.find(word);
            assertFalse(Arrays.equals(WORD_NOT_FOUND, indices), word);
            System.out.println(word + " found at: " + Arrays.toString(indices));
        }
    }

    @Test
    public void testFindGoku(){
        // ARRANGE
        WordSearch wordSearch = new WordSearch(GRID);
        int[] indicesGoku = wordSearch.find("goku");
        // ASSERT
        assertArrayEquals(new int[]{8, 8}, indicesGoku);
    }

    @Test
    public void testFindKrilin(){
        // ARRANGE
        WordSearch wordSearch = new WordSearch(GRID);
        int[] indicesKrilin = wordSearch.find("krilin");
        // ASSERT
        assertArrayEquals(new int[]{9, 0}, indicesKrilin);
    }

    @Test
    public void testFindCell(){
        // ARRANGE
        WordSearch wordSearch = new WordSearch(GRID);
        int[] indicesCell = wordSearch.find("cell");
        // ASSERT
        assertArrayEquals(new int[]{6, 18}, indicesCell);
    }

    @Test
    public void testFindPiccoro(){
        // ARRANGE
        WordSearch wordSearch = new WordSearch(GRID);
        int[] indicesPiccoro = wordSearch.find("piccoro");
        // ASSERT
        assertArrayEquals(new int[]{0, 19}, indicesPiccoro);
    }

    @Test
    public void testFindVidel(){
        // ARRANGE
        WordSearch wordSearch = new WordSearch(GRID);
        int[] indicesVidel = wordSearch.find("videl");
        // ASSERT
        assertArrayEquals(new int[]{0, 11}, indicesVidel);
    }

    @Test
    public void testFindYamcha(){
        // ARRANGE
        WordSearch wordSearch = new WordSearch(GRID);
        int[] indicesYamcha = wordSearch.find("yamcha");
        // ASSERT
        assertArrayEquals(new int[]{9, 16}, indicesYamcha);
    }

    @Test
    public void testFindBroli(){
        // ARRANGE
        WordSearch wordSearch = new WordSearch(GRID);
        int[] indicesBroli = wordSearch.find("broli");
        // ASSERT
        assertArrayEquals(new int[]{6, 8}, indicesBroli);
    }

    @Test
    public void testFindVegeta(){
        // ARRANGE
        WordSearch wordSearch = new WordSearch(GRID);
        int[] indicesVegeta = wordSearch.find("vegeta");
        // ASSERT
        assertArrayEquals(new int[]{0, 7}, indicesVegeta);
    }

    @Test
    public void testFindGohan(){
        // ARRANGE
        WordSearch wordSearch = new WordSearch(GRID);
        int[] indicesGohan = wordSearch.find("gohan");
        // ASSERT
        assertArrayEquals(new int[]{0, 1}, indicesGohan);
    }

    @Test
    public void testFindBulma(){
        // ARRANGE
        WordSearch wordSearch = new WordSearch(GRID);
        int[] indicesBulma = wordSearch.find("bulma");
        // ASSERT
        assertArrayEquals(new int[]{6, 8}, indicesBulma);
    }

    @Test
    public void testFindRoshi(){
        // ARRANGE
        WordSearch wordSearch = new WordSearch(GRID);
        int[] indicesRoshi = wordSearch.find("roshi");
        // ASSERT
        assertArrayEquals(new int[]{8, 7}, indicesRoshi);
    }

    @Test
    public void testFindFreezer(){
        // ARRANGE
        WordSearch wordSearch = new WordSearch(GRID);
        int[] indicesFreezer = wordSearch.find("freezer");
        // ASSERT
        assertArrayEquals(new int[]{9, 1}, indicesFreezer);
    }

}
