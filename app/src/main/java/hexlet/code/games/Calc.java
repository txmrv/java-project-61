package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Calc {
    private static final String DESCRIPTION = "What is the result of the expression?";

    private static final String[] OPERATIONS = {"+", "-", "*"};
    private static final int MAX_NUMBER = 100;

    public static int calcExpression(String operationSign, int operand1, int operand2) {
        switch (operationSign) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            default:
                return operand1 * operand2;
        }
    }

    public static String[] getChallenge() {
        var operationIdx = Utils.getRandomInt(0, OPERATIONS.length);
        var operationSign = OPERATIONS[operationIdx];

        var operand1 = Utils.getRandomIntInclusive(0, MAX_NUMBER);
        var operand2 = Utils.getRandomIntInclusive(0, MAX_NUMBER);
        var result = calcExpression(operationSign, operand1, operand2);

        var question = operand1 + " " + operationSign + " " + operand2;
        var answer = Integer.toString(result);

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
