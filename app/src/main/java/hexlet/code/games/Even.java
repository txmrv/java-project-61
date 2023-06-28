package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Even {
    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MAX_NUMBER = 100;

    public static String[] getChallenge() {
        var randomInt = Utils.getRandomIntInclusive(0, MAX_NUMBER);
        var question = Integer.toString(randomInt);
        var answer = randomInt % 2 == 0 ? "yes" : "no";

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
