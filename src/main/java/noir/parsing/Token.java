package noir.parsing;

/**
 * The {@code Token} class represents a token in an expression.
 * Tokens can be variables, operators, functions, or parentheses.
 */
class Token {
    private final String type;
    private final String value;
    private int precedence;
    private boolean leftAssociative;

    /**
     * Constructs a {@code Token} with the specified type and value.
     * This constructor is typically used for variables and parentheses.
     *
     * @param type  the type of the token (e.g., "NUMBER", "LEFT_PAREN", "RIGHT_PAREN")
     * @param value the value of the token as a string
     */
    public Token(String type, String value) {
        this.type = type;
        this.value = value;
    }

    /**
     * Constructs a {@code Token} with the specified type, value, precedence, and associativity.
     * This constructor is typically used for operators.
     *
     * @param type             the type of the token (e.g., "OPERATOR")
     * @param value            the value of the token as a string
     * @param precedence       the precedence of the operator
     * @param leftAssociative  whether the operator is left associative
     */
    public Token(String type, String value, int precedence, boolean leftAssociative) {
        this.type = type;
        this.value = value;
        this.precedence = precedence;
        this.leftAssociative = leftAssociative;
    }

    /**
     * Returns the type of the token.
     *
     * @return the type of the token
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the value of the token.
     *
     * @return the value of the token
     */
    public String getValue() {
        return value;
    }

    /**
     * Returns the precedence of the token.
     * This is relevant for operator tokens.
     *
     * @return the precedence of the token
     */
    public int getPrecedence() {
        return precedence;
    }

    /**
     * Returns whether the token is left associative.
     * This is relevant for operator tokens.
     *
     * @return {@code true} if the token is left associative; {@code false} otherwise
     */
    public boolean isLeftAssociative() {
        return leftAssociative;
    }

    /**
     * Returns a string representation of the token.
     *
     * @return the value of the token as a string
     */
    @Override
    public String toString() {
        return value;
    }
}
