package hexlet.code.games;

public class Calc implements Game {
    private static final String NAME = "Calc";
    private static final String DESCRIPTION = "What is the result of the expression?";

    public String getDescription() {
        return DESCRIPTION;
    }

    public String getName() {
        return NAME;
    }

    private static final String[] OPERATIONS = {"+", "-", "*"};

    private static int getAnswerBySign(String operationSign, int operand1, int operand2) {
        switch (operationSign) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            default:
                return operand1 * operand2;
        }
    }

    public String[] getChallenge() {
        var operationIdx = (int) (Math.random() * 100) % OPERATIONS.length;
        var operationSign = OPERATIONS[operationIdx];

        var operand1 = (int) (Math.random() * 100);
        var operand2 = (int) (Math.random() * 100);

        var question = operand1 + " " + operationSign + " " + operand2;
        var answer = getAnswerBySign(operationSign, operand1, operand2);

        return new String[] {question, String.valueOf(answer)};
    }
}