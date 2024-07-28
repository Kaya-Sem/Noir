package noir.parsing;

import java.util.*;

/**
 * Convert tokens in infix notation to prefix notation with the Shunting yard algorithm.
 *
 * @author Kayasem
 */
public class InfixToRPN {

    public static List<Token> convert(List<Token> tokens) {
        List<Token> outputQueue = new ArrayList<>();
        Deque<Token> operatorStack = new ArrayDeque<>();

        for (Token token : tokens) {
            switch (token.getType()) {
                case VARIABLE:
                    outputQueue.add(token);
                    break;
                case FUNCTION:
                case LEFT_PAREN:
                    operatorStack.push(token);
                    break;
                case OPERATOR:
                    while (!operatorStack.isEmpty() &&
                            operatorStack.peek().getType() != TokenType.LEFT_PAREN &&
                            (operatorStack.peek().getPrecedence() > token.getPrecedence() ||
                                    (operatorStack.peek().getPrecedence() == token.getPrecedence() &&
                                            token.isLeftAssociative()))) {
                        outputQueue.add(operatorStack.pop());
                    }
                    operatorStack.push(token);
                    break;
                case RIGHT_PAREN:
                    while (!operatorStack.isEmpty() && operatorStack.peek().getType() != TokenType.LEFT_PAREN) {
                        outputQueue.add(operatorStack.pop());
                    }
                    if (operatorStack.isEmpty()) {
                        throw new IllegalArgumentException("Mismatched parentheses");
                    }
                    operatorStack.pop(); // Pop the left parenthesis and discard it
                    if (!operatorStack.isEmpty() && operatorStack.peek().getType() == TokenType.FUNCTION) {
                        outputQueue.add(operatorStack.pop());
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Unknown token type: " + token.getType());
            }
        }

        while (!operatorStack.isEmpty()) {
            Token token = operatorStack.pop();
            if (token.getType() == TokenType.LEFT_PAREN || token.getType() == TokenType.RIGHT_PAREN) {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            outputQueue.add(token);
        }

        return outputQueue;
    }

}
