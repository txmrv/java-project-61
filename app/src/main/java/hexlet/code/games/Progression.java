package hexlet.code.games;

import java.util.StringJoiner;

public class Progression implements Game {
    private static final String NAME = "Progression";
    private static final String DESCRIPTION = "What number is missing in the progression?";

    public String getDescription() {
        return DESCRIPTION;
    }

    public String getName() {
        return NAME;
    }

    private static final int PROGRESSION_SIZE = 10;
    private static final int MAX_PROGRESSION_STEP = 10;
    private static final int MAX_PROGRESSION_ITEM = 100;

    public String[] getChallenge() {
        var progressionStep = (int) (Math.random() * MAX_PROGRESSION_STEP) + 1;
        var maxProgressionStart = MAX_PROGRESSION_ITEM - (PROGRESSION_SIZE - 1) * progressionStep;
        var progressionStart = (int) (Math.random() * maxProgressionStart);

        var progression = new StringJoiner(" ");
        var hiddenNumberIdx = (int) (Math.random() * PROGRESSION_SIZE);
        var hiddenNumber = progressionStart + progressionStep * hiddenNumberIdx;

        for (int i = 0; i < PROGRESSION_SIZE; i++) {
            var nextNumber = progressionStart + progressionStep * i;
            var nextElem = i == hiddenNumberIdx ? ".." : String.valueOf(nextNumber);
            progression.add(nextElem);
        }

        var question = progression.toString();
        var answer = String.valueOf(hiddenNumber);

        return new String[] {question, answer};
    }
}
