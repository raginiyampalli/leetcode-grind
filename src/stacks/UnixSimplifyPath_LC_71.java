package stacks;

import java.util.Stack;

/**
 1. Split the string with delimiter '/'.
 2. Push everything into stack except empty strings and single period strings.
 3. Process each pop and save it in string buffer.
 4. While processing,
 (i) while string = "..", maintain a counter and keep popping until its zero, increment the counter if string is "..", decrement otherwise.

 Test Case : "/home/of/foo/../../bar/../../is/./here/."

 */

public class UnixSimplifyPath_LC_71 {
    public static void main(String args[]) {
        UnixPath solution = new UnixPath();
        String input = "/home/of/foo/../../bar/../../is/./here/.";
        System.out.println(solution.simplifyPath(input));
    }
}
class UnixPath {
    public String simplifyPath(String path) {
        String[] input = path.split("/");
        Stack<String> stack = new Stack();
        String DOUBLE_PERIOD = "..";
        for(String str:input){
            if(DOUBLE_PERIOD.equals(str)){
                System.out.println(str);
                stack.push(str);
            } else if(!str.equals(".") && !str.isEmpty()){
                System.out.println(str);
                stack.push(str);
            }

        }

        StringBuffer sb = new StringBuffer();

        while(!stack.empty()){
            String current = stack.pop();
            if(!current.isEmpty()){
                if(DOUBLE_PERIOD.equals(current)){
                    int counter = 1;

                    while(!stack.empty() && counter >0){
                        if(DOUBLE_PERIOD.equals(stack.peek())){
                            stack.pop();
                            counter++;
                        } else{
                            stack.pop();
                            counter--;
                        }

                    }
                }else {
                    sb = sb.insert(0,"/"+current);
                }
            }
        }

        if(sb.length()==0) return "/";

        return new String(sb);

    }
}
