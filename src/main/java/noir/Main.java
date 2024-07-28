package src.main.java.noir;

import src.main.java.noir.parsing.PropositionParser;

public class Main {
    public static void main(String[] args) {
        String expression = "1 0 ->";
        Expression parsedExpression = PropositionParser.parse(expression);
        boolean result = parsedExpression.evaluate();
        System.out.println("Result: " + result); // Should print: Result: false
        System.out.println("(¬A ∧ B) ∨ B → C");
    }
}
