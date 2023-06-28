package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Prime {
    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MAX_NUMBER = 100;

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i += 1) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static String[] getChallenge() {
        var randomInt = Utils.getRandomIntInclusive(0, MAX_NUMBER);

        var question = Integer.toString(randomInt);
        var answer = isPrime(randomInt) ? "yes" : "no";

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
