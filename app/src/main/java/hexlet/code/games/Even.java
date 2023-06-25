package hexlet.code.games;

public final class Even implements Game {
    private static final String NAME = "Even";
    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public String getDescription() {
        return DESCRIPTION;
    }

    public String getName() {
        return NAME;
    }

    private static final int MAX_NUMBER = 100;

    public String[] getChallenge() {
        var randomInt = (int) (Math.random() * MAX_NUMBER);
        var question = String.valueOf(randomInt);
        var answer = randomInt % 2 == 0 ? "yes" : "no";

        return new String[] {question, answer};
    }
}
