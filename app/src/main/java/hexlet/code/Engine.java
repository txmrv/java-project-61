package hexlet.code;

import hexlet.code.games.Game;

import java.util.Scanner;

public class Engine {
    private static final int ROUNDS_COUNT = 3;

    public static void run(Game game) {
        var userName = Cli.greet();

        var description = game.getDescription();
        System.out.println(description);

        Scanner scanner = new Scanner(System.in);

        var isWin = true;

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            var challenge = game.getChallenge();

            var question = challenge[0];
            var answer = challenge[1];

            System.out.println("Question: " + question);

            var userAnswer = scanner.next();

            var isCorrect = answer.equals(userAnswer);

            var result = isCorrect ? "Correct!" : userAnswer + " is wrong answer ;(. Correct answer was " + answer;

            System.out.println(result);

            if (!isCorrect) {
                isWin = false;
                break;
            }
        }

        var goodbye = (isWin ? "Congratulations, " : "Let's try again, ") + userName + "!";
        System.out.println(goodbye);
    }
}
