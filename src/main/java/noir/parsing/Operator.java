package noir.parsing;

/**
 * Enum representing different types of operators with their symbols, precedence, and associativity.
 */
public enum Operator {
    NEGATION("!", 4, false),       // Unary operator
    AND("&&", 2, true),            // Binary operator
    OR("||", 2, true),             // Binary operator
    IMPLIES("->", 1, false),       // Binary operator
    EQUIVALENT("=", 0, true),      // Binary operator for equivalence
    UNEQUIVALENT("!=", 0, true);   // Binary operator for propositional unequivalence

    private final String symbol;
    private final int precedence;
    private final boolean leftAssociative;

    /**
     * Constructs an {@code Operator} with the specified symbol, precedence, and associativity.
     *
     * @param symbol            the symbol representing the operator
     * @param precedence        the precedence of the operator
     * @param leftAssociative   whether the operator is left associative
     */
    Operator(String symbol, int precedence, boolean leftAssociative) {
        this.symbol = symbol;
        this.precedence = precedence;
        this.leftAssociative = leftAssociative;
    }

    /**
     * Returns the symbol of the operator.
     *
     * @return the symbol of the operator
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Returns the precedence of the operator.
     *
     * @return the precedence of the operator
     */
    public int getPrecedence() {
        return precedence;
    }

    /**
     * Returns whether the operator is left associative.
     *
     * @return {@code true} if the operator is left associative; {@code false} otherwise
     */
    public boolean isLeftAssociative() {
        return leftAssociative;
    }

    /**
     * Returns the {@code Operator} associated with the given symbol.
     *
     * @param symbol the symbol of the operator
     * @return the {@code Operator} corresponding to the symbol
     * @throws IllegalArgumentException if the symbol does not match any operator
     */
    public static Operator fromSymbol(String symbol) {
        for (Operator op : values()) {
            if (op.getSymbol().equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Unknown operator symbol: " + symbol);
    }
}
