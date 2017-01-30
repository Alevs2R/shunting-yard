import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //converting the given arithmetic expression to the reversed polish notation form

        Scanner in = new Scanner(new File("input.txt"));

        InfixToPostifx converter = new InfixToPostifx();

        for(Character ch: in.nextLine().toCharArray()){
            if(!ch.equals(' ')) // skip spaces
                converter.passToken(ch);
        }
        converter.finishExpression();
        String rpn = converter.getExpresion();

        // now we evaluate given RPN and save the result

        RPNCalculator calc = new RPNCalculator();
        calc.setExpression(rpn);

        PrintWriter writer = new PrintWriter("output.txt");
        writer.println(String.format(Locale.US, "%.2f", calc.calculate()));
        writer.close();
    }
}
