
import java.util.Stack;

public class InfixToPostfix {

    public static String convertToPostOrder(String inOrder) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postOrder = new StringBuilder();

        for (int i = 0; i < inOrder.length(); i++) {
            char c = inOrder.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                postOrder.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postOrder.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && getPrecedence(stack.peek()) >= getPrecedence(c)) {
                    postOrder.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postOrder.append(stack.pop());
        }

        return postOrder.toString();
    }

    private static int getPrecedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        String inOrder = "a+b*c-(d/e+f*g*h)";
        String postOrder = convertToPostOrder(inOrder);
        System.out.println("Infix: " + inOrder);
        System.out.println("Postfix: " + postOrder);
    }
}
