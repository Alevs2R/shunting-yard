public class Main {
    public static void main(String[] args) {
        //converting the given arithmetic expression to the reversed polish notation form

        InfixToPostifx converter = new InfixToPostifx();
        String expression = "(1 + 5)/(7 + 1)";
        for(Character ch: expression.toCharArray()){
            if(!ch.equals(' '))
                converter.passToken(ch);
        }
        converter.finishExpression();
        System.out.println(converter.getExpresion());
    }
}
