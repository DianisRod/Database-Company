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
}
