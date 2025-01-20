import com.fasp.SubArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SubArrayTest {

    @Test
    public void findeSubArrayTest(){
        int[] werte = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] subArray = {4, 5, 6};
        int[] notSubArray = {6, 5, 4};

        boolean positivesErgebnis = SubArray.findeSubArray(werte, subArray);
        boolean negativesErgebnis = SubArray.findeSubArray(werte, notSubArray);

        assertTrue(positivesErgebnis);
        assertFalse(negativesErgebnis);
    }

    @Test
    public void find2dSubarrayTest(){
        int[][] array = {
                {34, 7, 23, 32, 5, 62, 78},
                {45, 12, 89, 56, 90, 11, 67},
                {24, 88, 73, 54, 31, 19, 40},
                {99, 21, 18, 76, 43, 55, 66},
                {81, 39, 28, 14, 92, 33, 50},
                {60, 25, 47, 13, 70, 85, 22}
        };

        int[][] subArray = {
            {54, 31, 19},
            {76, 43, 55},
            {14, 92, 33}
        };

        int[][] notSubArray = {
            {8, 9, 10},
            {13, 14, 15},
            {18, 19, 20}
        };

        boolean positivesErgebnis = SubArray.finde2dSubArray(array, subArray);
        boolean negativesErgebnis = SubArray.finde2dSubArray(array, notSubArray);

        assertTrue(positivesErgebnis);
        assertFalse(negativesErgebnis);
    }
}
