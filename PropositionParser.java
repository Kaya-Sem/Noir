import java.util.Arrays;
import java.util.Stack;

public class PropositionParser {

    // '\\s+' is one or more whitespace character
    private static final String SPLIT_REGEX = "\\s+";

    public static Expression parse(String input) {
        Stack<Expression> stack = new Stack<>();
        String[] tokens = input.split(SPLIT_REGEX);
        System.out.println("tokens:" + Arrays.toString(tokens));

        // needs Shunting yard algorithm. Either output Reverse polish or AST. https://en.wikipedia.org/wiki/Shunting_yard_algorithm:w

        for (String token : tokens) {
            switch (token) {
                case "1":
                    stack.push(new Constant(true));
                    break;
                case "0":
                    stack.push(new Constant(false));
                    break;
                case "->":
                    Expression right = stack.pop();
                    Expression left = stack.pop();
                    stack.push(new Implies(left, right));
                    break;
                // Add more cases for other operators (e.g., "&&") if needed
                default:
                    throw new IllegalArgumentException("Unexpected token: " + token);
            }
        }

        return stack.pop();
    }
}