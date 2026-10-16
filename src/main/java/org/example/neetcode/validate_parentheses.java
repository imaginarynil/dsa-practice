package org.example.neetcode;

import java.util.Stack;

public class validate_parentheses {
    // t: O()
    // s: O()
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else {
                if(st.isEmpty()) {
                    return false;
                }
                char top = st.pop();
                if(top == '(' && c != ')') {
                    return false;
                }
                if(top == '{' && c != '}') {
                    return false;
                }
                if(top == '[' && c != ']') {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }

    void main() {
        var x = isValid("[]");
        x = isValid("([{}])");
        x = isValid("[(])");
        x = isValid("[");
    }
}
