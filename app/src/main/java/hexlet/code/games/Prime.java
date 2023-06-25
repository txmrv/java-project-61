package hexlet.code.games;

public final class Prime implements Game {
    private static final String NAME = "Prime";
    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public String getDescription() {
        return DESCRIPTION;
    }

    public String getName() {
        return NAME;
    }

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

    private static final int MAX_NUMBER = 100;

    public String[] getChallenge() {
        var randomInt = (int) (Math.random() * MAX_NUMBER);
        var question = String.valueOf(randomInt);
        var answer = isPrime(randomInt) ? "yes" : "no";

        return new String[] {question, answer};
    }
}
