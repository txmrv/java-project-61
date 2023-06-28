package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Gcd {
    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";
    private static final int MAX_NUMBER = 100;

    private static int getGcd(int n1, int n2) {
        var reminder = n1 % n2;

        while (reminder != 0) {
            n1 = n2;
            n2 = reminder;
            reminder = n1 % n2;
        }

        return n2;
    }

    public static String[] getChallenge() {
        var randomInt1 = Utils.getRandomIntInclusive(0, MAX_NUMBER);
        var randomInt2 = Utils.getRandomIntInclusive(1, MAX_NUMBER);
        var gcd = getGcd(randomInt1, randomInt2);

        var question = randomInt1 + " " + randomInt2;
        var answer = Integer.toString(gcd);

        return new String[] {question, answer};
    }

    public static void run() {
        Engine.startGame(DESCRIPTION);

        while (Engine.hasNextRound()) {
            Engine.nextRound(getChallenge());
        }

        Engine.endGame();
    }
}
