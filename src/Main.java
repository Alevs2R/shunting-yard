import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //converting the given arithmetic expression to the reversed polish notation form

        InfixToPostifx converter = new InfixToPostifx();
        String expression = "(2*7+4)/3";
        for(Character ch: expression.toCharArray()){
            if(!ch.equals(' '))
                converter.passToken(ch);
        }
        converter.finishExpression();
        String rpn = converter.getExpresion();
        System.out.println(rpn);

        RPNCalculator calc = new RPNCalculator();
        calc.setExpression(rpn);
        System.out.println(calc.calculate());
    }
}
