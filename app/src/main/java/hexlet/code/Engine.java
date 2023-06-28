package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final int ROUNDS_COUNT = 3;
    private static int currentRound = 0;

    private static String userName;
    private static boolean isCorrect = true;

    public static void startGame(String description) {
        userName = Cli.greet();
        System.out.println(description);
    }

    public static boolean hasNextRound() {
        return currentRound < ROUNDS_COUNT && isCorrect;
    }

    public static void nextRound(String[] challenge) {
        Scanner scanner = new Scanner(System.in);

        var question = challenge[0];
        var answer = challenge[1];

        System.out.println("Question: " + question);

        var userAnswer = scanner.next();

        isCorrect = answer.equals(userAnswer);

        var result = isCorrect ? "Correct!" : userAnswer + " is wrong answer ;(. Correct answer was " + answer;

        System.out.println(result);

        currentRound++;
    }

    private static void resetState() {
        currentRound = 0;
        isCorrect = true;
    }

    public static void endGame() {
        var goodbye = (isCorrect ? "Congratulations, " : "Let's try again, ") + userName + "!";
        System.out.println(goodbye);

        resetState();
    }
}
