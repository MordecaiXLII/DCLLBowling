package ups.dcll;

/**
 * Created by Alexandre Lagane on 3/2/16.
 */
public abstract class Score {
    public static int score(int tab[]) {est
        int total = 0;
        int frameScore = 0;
        int frame = 0;
        int i = 0;
        while (frame < 10) {
            if (tab[i] == 10) { /* Strike */
                total += 10 + tab[i + 1] + tab[i + 2];
            } else {
                frameScore = tab[i];
                i++;
                if (frameScore + tab[i] == 10) {/* Spare */
                    total += 10 + tab[i + 1];
                } else { /* Miss */
                    total = frameScore + tab[i];
                }
            }
            i++;
            frame++;
        }

        return total;
    }
}
