/**
 * @author Alexey Evlampev
 *
 * Implementation of shunting-yard algorithm for arithmetic operators and brackets. No functions handling
 * uses both stack and queue
 */

public class InfixToPostifx {
    private LinkedQueue<Character> outputQueue = new LinkedQueue<>();
    private LinkedStack<Character> operatorsStack = new LinkedStack<>();
    private char[] operatorsOrder = {'+', '-', '*', '/'};

    /**
     * main feature of algorithm, which takes tokens one by one and put elements to operators stack and output queue
     * @param tok is the next read token (number, operator or bracket)
     */
    public void passToken(Character tok){
        if(Character.isDigit(tok)) outputQueue.enqueue(tok);
        else if (tok.equals('(')){
            operatorsStack.push(tok);
        }
        else if (tok.equals(')')){
            while(!operatorsStack.top().equals('(')){
                outputQueue.enqueue(operatorsStack.pop());
            }
            operatorsStack.pop();
        }
        else {
            operatorsStack.push(tok);
        }
    }


    /**
     * use this method when no more tokens to read
     * pops all operators onto output queue
     */
    public void finishExpression(){
        while(!operatorsStack.isEmpty()){
            outputQueue.enqueue(operatorsStack.pop());
        }
    }


    /**
     * @return the expression according to the standards of reversed polish notation (RPN)
     */
    public String getExpresion(){
        StringBuilder str = new StringBuilder();
        while(!outputQueue.isEmpty()){
            str.append(outputQueue.dequeue());
        }
        return str.toString();
    }
}