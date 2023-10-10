package DataStructuresAndAlgorithms.PraticeProblems;

import java.util.Stack;

/**
 * This class provides a method to reverse a given string using a stack.
 */
public class StringReverser {

    /**
     * Reverses the given input string using a stack.
     *
     * @param input the string to be reversed
     * @return the reversed string
     * @throws IllegalArgumentException if the input string is null
     */
    public String reverse(String input) {
        if (input == null)
            throw new IllegalArgumentException("Input cannot be null");

        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        StringBuffer reversed = new StringBuffer();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }

    /**
     * Main method to test the reverse method with sample strings.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        StringReverser reverser = new StringReverser();

        // Case 1: Simple string
        String str1 = "hello";
        String result1 = reverser.reverse(str1);
        System.out.println("Reversed: " + result1); // Output: olleh

        // Case 2: Empty string
        String str2 = "";
        String result2 = reverser.reverse(str2);
        System.out.println("Reversed: " + result2); // Output:

        // Case 3: Single character string
        String str3 = "a";
        String result3 = reverser.reverse(str3);
        System.out.println("Reversed: " + result3); // Output: a

        // Case 4: String with spaces
        String str4 = "hello world";
        String result4 = reverser.reverse(str4);
        System.out.println("Reversed: " + result4); // Output: dlrow olleh

        // Case 5: String with special characters
        String str5 = "hello@world!";
        String result5 = reverser.reverse(str5);
        System.out.println("Reversed: " + result5); // Output: !dlrow@olleh

        // Case 6: null input (should throw an exception)
        try {
            String str6 = null;
            String result6 = reverser.reverse(str6);
            System.out.println("Reversed: " + result6);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Output: Input cannot be null
        }
    }
}
