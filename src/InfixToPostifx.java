/**
 * @author Alexey Evlampev
 *         <p>
 *         Implementation of shunting-yard algorithm for arithmetic operators and brackets. No functions handling
 *         uses both stack and queue
 */

public class InfixToPostifx {
    private LinkedQueue<String> outputQueue = new LinkedQueue<>();
    private LinkedStack<String> operatorsStack = new LinkedStack<>();

    /**
     * main feature of algorithm, which takes tokens one by one and put elements to operators stack and output queue
     *
     * @param tok is the next read token (number, operator or bracket)
     */
    public void passToken(String tok) {
        if (tok.equals(" ")) return;

        if (isNumber(tok))
            outputQueue.enqueue(tok);
        else {
            if (tok.equals("(")) {
                operatorsStack.push(tok);
            } else if (tok.equals(")")) {
                while (!operatorsStack.isEmpty() && !operatorsStack.top().equals("(")) {
                    outputQueue.enqueue(operatorsStack.pop());
                }
                operatorsStack.pop();
            } else {
                while (isOperatorLessPrecedence(tok, operatorsStack.top()))
                    outputQueue.enqueue(operatorsStack.pop());

                operatorsStack.push(tok);
            }
        }
    }

    private boolean isNumber(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperatorLessPrecedence(String op1, String op2) {
        if (op2 == null) return false;
        return getOperatorPrecedence(op1) <= getOperatorPrecedence(op2);

    }

    private int getOperatorPrecedence(String op) {
        if (op.equals("(")) return 0;
        return (op.equals("*") || op.equals("/")) ? 2 : 1;
    }

    /**
     * use this method when no more tokens to read
     * pops all operators onto output queue
     */
    public void finishExpression() {
        while (!operatorsStack.isEmpty()) {
            outputQueue.enqueue(operatorsStack.pop());
        }
    }


    /**
     * @return the expression according to the standards of reversed polish notation (RPN)
     */
    public Queue<String> getRPNQueue() {
        return outputQueue;
    }
}
