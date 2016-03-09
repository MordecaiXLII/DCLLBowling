package ups.dcll;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Alexandre Lagane on 3/9/16.
 */
public class ScoreTest {

    @Test
    public void testScore() throws Exception {
        assertEquals(Score.score(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}), 0);
        assertEquals(Score.score(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}), 300);
        assertEquals(Score.score(new int[]{9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9}), 190);
        assertEquals(Score.score(new int[]{1, 2, 3, 4, 5, 5, 6, 4, 7, 3, 8, 2, 9, 1, 10, 0, 10, 6}), 156);

    }
}