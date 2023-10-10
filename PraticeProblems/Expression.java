package DataStructuresAndAlgorithms.PraticeProblems;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * This class provides a method to check if an expression has balanced brackets.
 */
public class Expression {

    // Lists of bracket characters to be considered
    private final List<Character> leftBrackets = Arrays.asList('(', '<', '[', '{');
    private final List<Character> rightBrackets = Arrays.asList(')', '>', ']', '}');

    /**
     * Determines if the given input string has balanced brackets.
     * A string has balanced brackets if each opening bracket has a corresponding
     * closing bracket
     * in the correct order.
     *
     * @param input the string to be checked for balanced brackets
     * @return true if the string has balanced brackets, false otherwise
     */
    public boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (isLeftBracket(ch))
                stack.push(ch);

            if (isRightBracket(ch)) {
                if (stack.empty())
                    return false;

                var top = stack.pop();
                if (bracketsDontMatch(top, ch))
                    return false;
            }
        }

        return stack.empty();
    }

    /**
     * Helper method to check if a character is an opening bracket.
     *
     * @param ch the character to be checked
     * @return true if the character is an opening bracket, false otherwise
     */
    private boolean isLeftBracket(char ch) {
        return leftBrackets.contains(ch);
    }

    /**
     * Helper method to check if a character is a closing bracket.
     *
     * @param ch the character to be checked
     * @return true if the character is a closing bracket, false otherwise
     */
    private boolean isRightBracket(char ch) {
        return rightBrackets.contains(ch);
    }

    /**
     * Helper method to check if the opening and closing brackets match.
     *
     * @param left  the opening bracket character
     * @param right the closing bracket character
     * @return true if the brackets match, false otherwise
     */
    private boolean bracketsDontMatch(char left, char right) {
        return leftBrackets.indexOf(left) != rightBrackets.indexOf(right);
    }

    /**
     * Main method to test the isBalanced method with a sample expression.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Expression exp = new Expression();

        // Case 1: Simple balanced expression
        String str1 = "(1 + 2)";
        var result1 = exp.isBalanced(str1);
        System.out.println(str1 + " is balanced: " + result1); // Output: true

        // Case 2: Nested balanced expression
        String str2 = "{[1 + (2 * 3)] - 4}";
        var result2 = exp.isBalanced(str2);
        System.out.println(str2 + " is balanced: " + result2); // Output: true

        // Case 3: Unbalanced expression - Missing closing bracket
        String str3 = "(1 + 2";
        var result3 = exp.isBalanced(str3);
        System.out.println(str3 + " is balanced: " + result3); // Output: false

        // Case 4: Unbalanced expression - Extra closing bracket
        String str4 = "(1 + 2))";
        var result4 = exp.isBalanced(str4);
        System.out.println(str4 + " is balanced: " + result4); // Output: false

        // Case 5: Unbalanced expression - Mismatched brackets
        String str5 = "[1 + 2)";
        var result5 = exp.isBalanced(str5);
        System.out.println(str5 + " is balanced: " + result5); // Output: false

        // Case 6: Empty expression - Considered balanced
        String str6 = "";
        var result6 = exp.isBalanced(str6);
        System.out.println(str6 + " is balanced: " + result6); // Output: true

        // Case 7: Expression with no brackets - Considered balanced
        String str7 = "1 + 2";
        var result7 = exp.isBalanced(str7);
        System.out.println(str7 + " is balanced: " + result7); // Output: true
    }

}
