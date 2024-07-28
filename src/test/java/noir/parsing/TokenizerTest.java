package noir.parsing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TokenizerTest {

    @Test
    void testTokenizeSimpleExpression() {
        String input = "x->y";
        String[] expected = {"x", "->", "y"};
        assertArrayEquals(expected, Tokenizer.tokenize(input));
    }

    @Test
    void testTokenizeExpressionWithSpaces() {
        String input = "x -> y";
        String[] expected = {"x", "->", "y"};
        assertArrayEquals(expected, Tokenizer.tokenize(input));
    }

    @Test
    void testTokenizeComplexExpression() {
        String input = "x-> (y || z)";
        String[] expected = {"x", "->", "(", "y", "||", "z", ")"};
        assertArrayEquals(expected, Tokenizer.tokenize(input));
    }

    @Test
    void testTokenizeWithExtraSpaces() {
        String input = " x ->   ( y   ||   z ) ";
        String[] expected = {"x", "->", "(", "y", "||", "z", ")"};
        assertArrayEquals(expected, Tokenizer.tokenize(input));
    }

    @Test
    void testTokenizeOnlyLogicalOperators() {
        String input = "-> ||";
        String[] expected = {"->", "||"};
        assertArrayEquals(expected, Tokenizer.tokenize(input));
    }

    @Test
    void testTokenizeNoSpaces() {
        String input = "x->y||z";
        String[] expected = {"x", "->", "y", "||", "z"};
        assertArrayEquals(expected, Tokenizer.tokenize(input));
    }

    @Test
    void testTokenizeEmptyInput() {
        String input = "";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> Tokenizer.tokenize(input));
        assertEquals("Input string cannot be null or empty", exception.getMessage());
    }

    @Test
    void testTokenizeSingleCharacter() {
        String input = "x";
        String[] expected = {"x"};
        assertArrayEquals(expected, Tokenizer.tokenize(input));
    }

    @Test
    void testTokenizeSingleOperator() {
        String input = "->";
        String[] expected = {"->"};
        assertArrayEquals(expected, Tokenizer.tokenize(input));
    }

    @Test
    void testTokenizeMultipleSpaces() {
        String input = "x     y    z";
        String[] expected = {"x", "y", "z"};
        assertArrayEquals(expected, Tokenizer.tokenize(input));
    }

    @Test
    void testTokenizeSpecialCharacters() {
        String input = "x->(y||z)";
        String[] expected = {"x", "->", "(", "y", "||", "z", ")"};
        assertArrayEquals(expected, Tokenizer.tokenize(input));
    }

    @Test
    void testTokenizeParentheses() {
        String input = "(x)";
        String[] expected = {"(", "x", ")"};
        assertArrayEquals(expected, Tokenizer.tokenize(input));
    }

    @Test
    void testTokenizeNestedParentheses() {
        String input = "(x -> (y || z))";
        String[] expected = {"(", "x", "->", "(", "y", "||", "z", ")", ")"};
        assertArrayEquals(expected, Tokenizer.tokenize(input));
    }
}
