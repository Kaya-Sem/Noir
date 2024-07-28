package src.main.java.noir;

import java.util.List;
import java.util.Map;

/**
 * Convert tokens in infix notation to prefix notation.
 * @author Kayasem
 */
public class InfixToRPN {
    private static final Map<String, Integer> precedenceMap = Map.of(
            "!", 3,
            "&&", 2,
            "||", 1,
            "->", 0
    );

    /**
     * Converts an array of infix tokens and returns a list of tokens in RPN.
     *
     * @param infixTokens the array of tokens in infix notation
     * @return the list of tokens in RPN
     * @see <a href="https://en.wikipedia.org/wiki/Reverse_Polish_notation">Reverse Polish notation</a>
     */
    public static List<String> convertToRPN(String[] infixTokens) {
        return null;

    }
}
