package org.example.neetcode;

import java.util.Stack;

public class evaluate_reverse_polish_notation {
    public boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    // t: O()
    // s: O()
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String token: tokens) {
            if(isNumeric(token)) {
                st.push(Integer.parseInt(token));
            } else {
                int second = st.pop();
                int first = st.pop();
                int result = 0;
                switch(token) {
                    case "+":
                        result = first + second;
                        break;
                    case "-":
                        result = first - second;
                        break;
                    case "*":
                        result = first * second;
                        break;
                    case "/":
                        result = (int) first / second;
                        break;
                }
                st.push(result);
            }
        }
        return st.pop();
    }

    void main() {
        String[] in = {"1","2","+","3","*","4","-"};
        var x = evalRPN(in);
    }
}
