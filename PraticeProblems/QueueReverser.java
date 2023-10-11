package DataStructuresAndAlgorithms.PraticeProblems;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * This class provides a method to reverse the order of elements in a queue.
 */
public class QueueReverser {

    /**
     * Reverses the order of elements in the specified queue.
     * This method uses a stack to reverse the queue elements.
     * 
     * @param queue the queue whose elements are to be reversed
     * @throws IllegalArgumentException if the queue is empty
     */
    public static void reverse(Queue<Integer> queue) {
        if (queue.isEmpty())
            throw new IllegalArgumentException("Queue cannot be empty.");

        Stack<Integer> stack = new Stack<>();

        // Remove elements from the queue and push them onto the stack
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        // Pop elements from the stack and add them back to the queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    /**
     * Main method to test the reverse method with a sample queue.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();

        // Adding elements to the queue
        queue.add(10);
        queue.add(20);
        queue.add(30);

        // Displaying the original queue
        System.out.println("Original Queue: " + queue);

        // Reversing the queue
        reverse(queue);

        // Displaying the reversed queue
        System.out.println("Reversed Queue: " + queue);
    }
}
