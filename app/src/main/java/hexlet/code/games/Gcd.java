package hexlet.code.games;

public final class Gcd implements Game {
    private static final String NAME = "GCD";
    private static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";

    public String getDescription() {
        return DESCRIPTION;
    }

    public String getName() {
        return NAME;
    }

    private static int getGcd(int n1, int n2) {
        var reminder = n1 % n2;

        while (reminder != 0) {
            n1 = n2;
            n2 = reminder;
            reminder = n1 % n2;
        }

        return n2;
    }

    private static final int MAX_NUMBER = 100;

    public String[] getChallenge() {
        var randomInt1 = (int) (Math.random() * MAX_NUMBER);
        var randomInt2 = (int) (Math.random() * MAX_NUMBER);
        var gcd = getGcd(randomInt1, randomInt2);

        var question = randomInt1 + " " + randomInt2;
        var answer = String.valueOf(gcd);

        return new String[] {question, answer};
    }
}
