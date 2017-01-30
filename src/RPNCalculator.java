import java.io.IOException;

/**
 * @author Alexey Evlampev
 */

public class RPNCalculator {
    private String RPNBuffer;
    private LinkedStack<Double> stack;

    public void setExpression(String RPNExpression){
        this.RPNBuffer = RPNExpression;
        this.stack = new LinkedStack<>();
    }
    public double calculate() throws IOException {
        for(Character ch: RPNBuffer.toCharArray()) {
            if (!ch.equals(' ')) {
                if (Character.isDigit(ch)) {
                    stack.push(Double.parseDouble(ch.toString()));
                } else {
                    double num2 = stack.pop();
                    double num1 = stack.pop();
                    double result = 0;
                    switch (ch) {
                        case '+':
                            result = num1 + num2;
                            break;
                        case '-':
                            result = num1 - num2;
                            break;
                        case '*':
                            result = num1 * num2;
                            break;
                        case '/':
                            result = num1 / num2;
                            break;
                    }
                    stack.push(result);
                }
            }
        }
        return stack.pop();
    }
}
