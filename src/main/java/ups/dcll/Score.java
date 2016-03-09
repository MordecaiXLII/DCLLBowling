package ups.dcll;

/**
 * Created by Alexandre Lagane on 3/2/16.
 */
public abstract class Score {
    private static final int strikeScore = 10;
    private static final int spareScore = 10;
    private static final int framesNumber = 10;
    private static final int pinsNumber = 10;

    public static int score(int[] tab) {
        int total = 0;
        int frame = 0;
        int i = 0;
        int frameScore = 0;
        while (frame < framesNumber) {
            if (tab[i] == pinsNumber) { /* Strike */
                total += strikeScore + tab[i + 1] + tab[i + 2];
            } else {
                frameScore = tab[i];
                i++;
                if (frameScore + tab[i] == pinsNumber) { /* Spare */
                    total += spareScore + tab[i + 1];
                } else { /* Miss */
                    total += frameScore + tab[i];
                }
            }
            i++;
            frame++;
        }

        return total;
    }

    public static boolean isValid(int tab[]) {
        int test;
        int frame = 0;
        int i;
        int frameScore = 0;

        for (i = 0; i < tab.length; i++) {
            if (tab[i] < 0 || tab[i] > pinsNumber)
                return true;
        }

        i = 0;
        try {
            while (frame < framesNumber) {
                if (tab[i] == pinsNumber) { /* Strike */
                    test = tab[i + 1];
                    test = tab[i + 2];
                } else {
                    frameScore = tab[i];
                    i++;
                    if (frameScore + tab[i] > pinsNumber)
                        return false;
                    if (frameScore + tab[i] == pinsNumber) { /* Spare */
                        test = tab[i + 1];
                    }
                    /* else Miss */
                }
                i++;
                frame++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }

        return true;
    }
}