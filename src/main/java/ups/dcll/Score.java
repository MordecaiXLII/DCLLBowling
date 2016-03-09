package ups.dcll;

/**
 * Classe pour calculer des scores au bowling.
 */
public class Score {
    /**
     * Score de base pour les strikes.
     */
    private static final int STRIKE_SCORE = 10;
    /**
     * Score de base pour les spares.
     */
    private static final int SPARE_SCORE = 10;
    /**
     * Nombre de frames dans une partie.
     */
    private static final int FRAMES_NUMBER = 10;
    /**
     * Nombre de quilles maximum.
     */
    private static final int PINS_NUMBER = 10;

    /**
     * Calcul du score avec un tableau validé par la méthode
     * {@link boolean isValid}.
     * @param tab La séquence de lancers
     * @return Le score total de la séquence
     */
    public static int score(final int[] tab) {
        int total = 0;
        int frame = 0;
        int i = 0;
        int frameScore;
        while (frame < FRAMES_NUMBER) {
            if (tab[i] == PINS_NUMBER) { /* Strike */
                total += STRIKE_SCORE + tab[i + 1] + tab[i + 2];
            } else {
                frameScore = tab[i];
                i++;
                if (frameScore + tab[i] == PINS_NUMBER) { /* Spare */
                    total += SPARE_SCORE + tab[i + 1];
                } else { /* Miss */
                    total += frameScore + tab[i];
                }
            }
            i++;
            frame++;
        }

        return total;
    }

    /**
     * Vérification de la validité d'une séquence de lancers sous forme de
     * tableau d'entiers fournies en entrée.
     * La séquence d'entiers peut avoir une taille supèrieure aux nombres de
     * lancers si les lancers après le dernier valent 0.
     * @param tab La séquence de lancers
     * @return true si la séquence est valide, false sinon
     */
    public static boolean isValid(final int[] tab) {
        int frame = 0;
        int i, j;
        int frameScore;

        for (i = 0; i < tab.length; i++) {
            if (tab[i] < 0 || tab[i] > PINS_NUMBER) {
                return false;
            }
        }

        i = 0; j = 0;
        try {
            while (frame < FRAMES_NUMBER) {
                if (tab[i] == PINS_NUMBER) { /* Strike */
                    if (i + 2 >= tab.length) {
                        return false;
                    }
                    j = i + 2;
                } else {
                    frameScore = tab[i];
                    i++;
                    j = i;
                    if (frameScore + tab[i] > PINS_NUMBER) {
                        return false;
                    }
                    if (frameScore + tab[i] == PINS_NUMBER) { /* Spare */
                        if (i + 1 >= tab.length) {
                            return false;
                        }
                        j = i + 1;
                    }
                    /* else Miss */
                }
                i++;
                frame++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }

        for (j++; j < tab.length; j++) {
            if (tab[j] != 0) {
                return false;
            }
        }

        return true;
    }
}
