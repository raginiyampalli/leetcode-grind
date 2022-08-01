package stacks;

import java.util.Stack;

/**
 *
 Maintain list of opening brackets using a stack.
 For every closing bracket, make sure that the last bracket that was opened matches [ last bracket that was opened = top of the stack].
 */

public class ValidParenthesis_LC_20 {
    public static void main(String args[]){
        Solution solution = new Solution();
        System.out.println("Validity of {{}}()()(([()])) " + solution.isValid("{{}}()()(([()]))"));
        System.out.println("Validity of {{}}()()(([()]))) " + solution.isValid("{{}}()()(([()])))"));
    }
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] input = s.toCharArray();

        for(char bracket: input){
            if(isOpenBracket(bracket)){
                stack.push(bracket);
            } else {
                if(stack.empty()) return false;
                char open = stack.peek();
                if(match(open,bracket)){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    public boolean isOpenBracket(char c){
        return c=='{' || c=='(' || c=='[' ;
    }

    public boolean match(char open, char close){
        if(open == '{'){
            return close == '}';
        }

        if(open == '['){
            return close == ']';
        }

        if(open == '('){
            return close == ')';
        }

        return false;
    }
}
