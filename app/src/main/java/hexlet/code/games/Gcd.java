package hexlet.code.games;

public class Gcd implements Game {
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

    public String[] getChallenge() {
        var randomInt1 = (int) (Math.random() * 100);
        var randomInt2 = (int) (Math.random() * 100);
        var gcd = getGcd(randomInt1, randomInt2);

        var question = randomInt1 + " " + randomInt2;
        var answer = String.valueOf(gcd);

        return new String[] {question, answer};
    }
}
