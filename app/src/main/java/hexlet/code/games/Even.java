package hexlet.code.games;

public class Even implements Game {
    private static final String NAME = "Even";
    private static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public String getDescription() {
        return DESCRIPTION;
    }

    public String getName() {
        return NAME;
    }

    public String[] getChallenge() {
        var randomInt = (int) (Math.random() * 100);
        var question = String.valueOf(randomInt);
        var answer = randomInt % 2 == 0 ? "yes" : "no";

        return new String[] {question, answer};
    }
}
