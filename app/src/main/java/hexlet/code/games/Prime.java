package hexlet.code.games;

public class Prime implements Game {
    private static final String NAME = "Prime";
    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public String getDescription() {
        return DESCRIPTION;
    }

    public String getName() {
        return NAME;
    }

    private static boolean isPrime(int n) {
        if (n < 2 || n % 2 == 0) {
            return false;
        }

        for (int i = 3; i < n / 2; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public String[] getChallenge() {
        var randomInt = (int) (Math.random() * 100);
        var question = String.valueOf(randomInt);
        var answer = isPrime(randomInt) ? "yes" : "no";

        return new String[] {question, answer};
    }
}
