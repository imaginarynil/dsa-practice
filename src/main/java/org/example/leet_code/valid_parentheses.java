package org.example.leet_code;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class valid_parentheses {
    public boolean isValid_Optimal(String s) {
        Stack<Character> stack = new Stack<>();
        char[] str = s.toCharArray();
        for (char c : str) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (
                    top == '(' && c != ')' ||
                    top == '[' && c != ']' ||
                    top == '{' && c != '}'
                ) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> open = new Stack<>();
        Queue<Character> close = new LinkedList<>();
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(' || str[i] == '{' || str[i] == '[') {
                open.push(str[i]);
            } else {
                close.add(str[i]);
                if (!open.isEmpty()) {
                    char top = open.pop();
                    switch (str[i]) {
                        case ')':
                            if (top != '(') {
                                return false;
                            }
                            break;
                        case '}':
                            if (top != '{') {
                                return false;
                            }
                            break;
                        case ']':
                            if (top != '[') {
                                return false;
                            }
                            break;
                    }
                    close.remove();
                }
            }
        }
        return open.isEmpty() && close.isEmpty();
    }

    void main() {
        boolean b;
        b = isValid_Optimal("(]");
//        b = isValid("()");
//        b = isValid("()[]{}");
//        b = isValid("(]");
//        b = isValid("([])");
//        b = isValid("([)]");
    }
}
