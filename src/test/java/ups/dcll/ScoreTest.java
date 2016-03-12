package ups.dcll;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Classe de tests de la classe Score.
 */
public class ScoreTest extends Score {

    @Test
    public void testScore() throws Exception {
        assertEquals(0, Score.score(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
        assertEquals(300, Score.score(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
        assertEquals(190, Score.score(new int[]{9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9}));
        assertEquals(145, Score.score(new int[]{1, 2, 3, 4, 5, 5, 6, 4, 7, 3, 8, 2, 9, 1, 10, 0, 10, 6, 3}));
    }

    @Test
    public void testIsValid() throws Exception {
        assertTrue(Score.isValid(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
        assertTrue(Score.isValid(new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
        assertTrue(Score.isValid(new int[]{9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9, 1, 9}));
        assertTrue(Score.isValid(new int[]{1, 2, 3, 4, 5, 5, 6, 4, 7, 3, 8, 2, 9, 1, 10, 0, 10, 6, 3}));

        //nombre de coups inférieur à 12
        assertFalse("Moins de 12 coups", Score.isValid(new int[]{2}));

        //nombre de coups supérieur à 21 avec !=0 après le dernier
        assertFalse("Plus de 21 coups", Score.isValid(new int []{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}));

        //nombre de strikes trop élevé
        assertFalse("Coups en trop", Score.isValid(new int []{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));

        //frames non cohérentes
        assertFalse("Coups normalement impossibles", Score.isValid(new int []{9, 5, 9, 2, 6, 5, 7, 7, 9, 9, 8, 8, 4, 9, 9, 2, 9, 9, 9, 3}));

        //partie non terminée
        assertFalse("Pas assez de coups", Score.isValid(new int []{4, 5, 9, 1, 5, 3, 7, 0, 4, 2, 1, 9, 3, 3}));

        //scores inférieurs à 0
        assertFalse("Coup négatif", Score.isValid(new int []{-1, 2, -3, 4, -5, 5, 6, 4, 7, 3, 8, -2, 9, 1, 10, -0, 1764, 6, 3}));

        //scores inférieurs à 0 ou supérieurs à 10
        assertFalse("Coup supérieur à 10", Score.isValid(new int []{100, 2, -3, 4, -5, 5, 6, 4, 7, 3, 8, -2, 9, 1, 10, -0, 1764, 6, 3}));

        //boule bonus non nécessaire
        assertFalse("Boules bonues en trop", Score.isValid(new int []{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 ,4, 4, 4, 4, 4, 4}));

        //strike sans lancers suivants
        assertFalse("Strike sans lancers après", Score.isValid(new int []{10}));

        //spare sans lancers suivants
        assertFalse("Spare sans lancers après", Score.isValid(new int []{5, 5}));
    }
}
