package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.StringJoiner;

public final class Progression {
    private static final String DESCRIPTION = "What number is missing in the progression?";

    private static final int PROGRESSION_SIZE = 10;
    private static final int MIN_PROGRESSION_STEP = 1;
    private static final int MAX_PROGRESSION_STEP = 10;
    private static final int MAX_PROGRESSION_ITEM = 100;

    public static String[] getChallenge() {
        var progressionStep = Utils.getRandomIntInclusive(MIN_PROGRESSION_STEP, MAX_PROGRESSION_STEP);
        var maxProgressionStart = MAX_PROGRESSION_ITEM - (PROGRESSION_SIZE - 1) * progressionStep;
        var progressionStart = Utils.getRandomIntInclusive(0, maxProgressionStart);

        var progression = new StringJoiner(" ");
        var hiddenNumberIdx = Utils.getRandomInt(0, PROGRESSION_SIZE);
        var hiddenNumber = progressionStart + progressionStep * hiddenNumberIdx;

        for (int i = 0; i < PROGRESSION_SIZE; i++) {
            var nextNumber = progressionStart + progressionStep * i;
            var nextElem = i == hiddenNumberIdx ? ".." : Integer.toString(nextNumber);
            progression.add(nextElem);
        }

        var question = progression.toString();
        var answer = Integer.toString(hiddenNumber);

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
