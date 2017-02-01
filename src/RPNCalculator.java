import java.io.IOException;

/**
 * @author Alexey Evlampev
 */

public class RPNCalculator {
    private Queue<String> RPNBuffer;
    private LinkedStack<Double> stack;

    public void setExpression(Queue<String> RPNExpression) {
        this.RPNBuffer = RPNExpression;
        this.stack = new LinkedStack<>();
    }

    public double calculate() throws IOException {
        while (!RPNBuffer.isEmpty()) {
            String token = RPNBuffer.dequeue();

            try {
                stack.push(Double.parseDouble(token));
            } catch (NumberFormatException e) {
                double num2 = stack.pop();
                double num1 = stack.pop();
                double result = 0;
                switch (token) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                }
                stack.push(result);
            }
        }
        return stack.pop();
    }
}
