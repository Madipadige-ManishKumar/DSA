import java.util.*;

class Solution {
    public static String infixToPostfix(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If operand, add to result
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }
            // If '(' push to stack
            else if (ch == '(') {
                stack.push(ch);
            }
            // If ')' pop until '('
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // remove '('
                }
            }
            // If operator
            else {
                while (!stack.isEmpty() && precedence(stack.peek()) > precedence(ch)
                        || (!stack.isEmpty() && precedence(stack.peek()) == precedence(ch) && !isRightAssociative(ch))) {
                    if (stack.peek() == '(') break;
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop all remaining operators
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    // Precedence of operators
    private static int precedence(char op) {
        switch (op) {
            case '^': return 3;
            case '*': case '/': return 2;
            case '+': case '-': return 1;
            default: return -1;
        }
    }

    // Associativity: true if right-associative
    private static boolean isRightAssociative(char op) {
        return op == '^';
    }
}
