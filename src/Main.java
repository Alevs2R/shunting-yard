import java.io.*;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //converting the given arithmetic expression to the reversed polish notation form

        Scanner in = new Scanner(new File("input.txt"));

        InfixToPostifx converter = new InfixToPostifx();

        StringTokenizer tok = new StringTokenizer(in.nextLine(), "()+-/* ", true);
        while (tok.hasMoreTokens()) {
            converter.passToken(tok.nextToken());
        }

        converter.finishExpression();

        // now we evaluate given RPN and save the result

        RPNCalculator calc = new RPNCalculator();
        calc.setExpression(converter.getRPNQueue());

        PrintWriter writer = new PrintWriter("output.txt");
        writer.println(String.format(Locale.US, "%.2f", calc.calculate()));
        writer.close();
    }
}
