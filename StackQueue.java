package DataStructuresAndAlgorithms;

import java.util.Stack;

/**
 * This class implements a queue using two stacks.
 */
public class StackQueue {
    private Stack<Integer> stack1 = new Stack<>(); // Stack to hold enqueued items
    private Stack<Integer> stack2 = new Stack<>(); // Stack to hold dequeued items

    /**
     * Adds an item to the queue.
     *
     * @param item the item to be added
     */
    public void enqueue(int item) {
        stack1.push(item);
    }

    /**
     * Removes and returns the item at the front of the queue.
     *
     * @return the item at the front of the queue
     * @throws IllegalStateException if the queue is empty
     */
    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException("Can't Dequeue from empty queue.");

        moveStack1ToStack2();

        return stack2.pop();
    }

    /**
     * Returns the item at the front of the queue without removing it.
     *
     * @return the item at the front of the queue
     * @throws IllegalStateException if the queue is empty
     */
    public int peek() {
        if (isEmpty())
            throw new IllegalStateException("Can't peek from empty queue.");

        moveStack1ToStack2();

        return stack2.peek();
    }

    /**
     * Transfers items from stack1 to stack2 if stack2 is empty.
     * This method helps in reversing the order of items to simulate queue behavior.
     */
    private void moveStack1ToStack2() {
        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    /**
     * Main method to test the StackQueue implementation with sample operations.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        StackQueue queue = new StackQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        var first = queue.dequeue();
        System.out.println(first); // Output: 10

        var second = queue.dequeue();
        System.out.println(second); // Output: 20

        var peek = queue.peek();
        System.out.print(peek); // Output: 30
    }
}
