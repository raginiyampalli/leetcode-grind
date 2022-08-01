package stacks;

import java.util.Stack;

/**
 Push values into a stack, when you encounter an operator -> we pop from stack twice to get
 two values and perform operation on them using operator and push the value back to stack.
 */


public class ReversePolishNotation_LC_150 {
    public static void main(String args[]){
        RPN rpn = new RPN();
        String[] input = {"4","13","5","/","+"};
        System.out.println(rpn.evalRPN(input));
    }
}
class RPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(String input:tokens){
            if(!isOperator(input)){
                stack.push(Integer.valueOf(input));
            } else {
                //Pop two values; calculate; push back.
                int val2 = stack.pop();
                int val1 = stack.pop();
                int result = calculate(val1,val2,input);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    public int calculate (int val1, int val2, String operator){
        if(operator.equals("+")){
            return val1+val2;
        } else if(operator.equals("-")){
            return val1-val2;
        } else if(operator.equals("*")){
            return val1*val2;
        }else {
            return val1/val2;
        }
    }

    public boolean isOperator(String input){
        return input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/") ;
    }
}
