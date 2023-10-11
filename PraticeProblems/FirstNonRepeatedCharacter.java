package DataStructuresAndAlgorithms.PraticeProblems;

import java.util.HashMap;

/**
 * This class provides a solution to the problem of finding the first
 * non-repeated character in a string.
 * The solution uses a HashMap to store the count of each character in the
 * string.
 */
public class FirstNonRepeatedCharacter {

    /**
     * Finds and returns the first non-repeated character in the specified string.
     * If no such character exists, returns Character.MIN_VALUE.
     *
     * @param string the string to be searched
     * @return the first non-repeated character, or Character.MIN_VALUE if no such
     *         character exists
     */
    public static Character findFirstNonRepeatedCharacter(String string) {

        // Create a HashMap to store the count of each character
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        // Convert the string to a char array for easy iteration
        var chars = string.toCharArray();

        // Populate the HashMap with the count of each character
        for (char ch : chars) {
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }

        // Iterate through the char array to find the first non-repeated character
        for (char ch : chars) {
            if (map.get(ch) == 1)
                return ch;
        }

        // Return Character.MIN_VALUE if no non-repeated character is found
        return Character.MIN_VALUE;
    }

    /**
     * Main method to test the findFirstNonRepeatedCharacter method with a sample
     * input.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {

        // Call the method with a sample input and print the result
        char content = findFirstNonRepeatedCharacter("A green Apple");
        System.out.println(content); // Output: g
    }
}
