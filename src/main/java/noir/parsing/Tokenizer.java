package noir.parsing;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Provides methods for tokenizing logical propositions.
 * It can handle non-uniform spacing, for example by replacing logical operators like "->" and "||" with their padded versions
 * and then tokenizes the string by splitting on spaces.
 */
public class Tokenizer {
    /**
     * The regex pattern used for splitting the input string into tokens.
     */
    public static final String SPLITTING_VALUE = "\\s";

    /**
     * Tokenizes the input string by replacing logical operators with their padded
     * versions and splitting the string on spaces.
     *
     * @param input the input string containing logical propositions
     * @return an array of tokens extracted from the input string
     * @throws IllegalArgumentException if the input is null or empty
     */
    public static String[] tokenize(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty");
        }

        // Remove all whitespace from the input string
        input = input.replaceAll("\\s", "");

        // Add a space after each character and handle logical operators
        input = input.chars()
                .mapToObj(c -> (char) c + " ")
                .collect(Collectors.joining())
                .replace("- >", "->")
                .replace("| |", "||");

        // Trim trailing space and split the string into tokens
        input = input.trim();
        return input.split(SPLITTING_VALUE);
    }

    /**
     * The main method to test the tokenize method.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        String input = "x-> (y || z)";
        String[] tokens = Tokenizer.tokenize(input);
        System.out.println(Arrays.toString(tokens));
    }
}
