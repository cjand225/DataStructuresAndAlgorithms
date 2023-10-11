package DataStructuresAndAlgorithms;

import java.util.Arrays;

/**
 * This class implements a priority queue using an array.
 */
public class PriorityQueue {
    private int[] items = new int[5]; // Array to hold the elements of the queue
    private int count; // Current number of elements in the queue

    /**
     * Adds an item to the queue in a position based on its priority.
     *
     * @param item the item to be added
     * @throws IllegalStateException if the queue is full
     */
    public void add(int item) {
        if (isFull())
            throw new IllegalStateException("Queue is full.");

        var i = shiftItemsToInsert(item);
        items[i] = item;
        count++;
    }

    /**
     * Shifts items to the right to make room for a new item, keeping the queue
     * sorted.
     *
     * @param item the item to be inserted
     * @return the index where the item should be inserted
     */
    private int shiftItemsToInsert(int item) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (items[i] < item) // Updated comparison to '<' for highest value priority
                items[i + 1] = items[i];
            else
                break;
        }
        return i + 1;
    }

    /**
     * Removes and returns the item with the highest priority (highest value).
     *
     * @return the item with the highest priority
     * @throws IllegalStateException if the queue is empty
     */
    public int remove() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty.");

        return items[--count];
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Checks if the queue is full.
     *
     * @return true if the queue is full, false otherwise
     */
    public boolean isFull() {
        return count == items.length;
    }

    /**
     * Returns a string representation of the queue.
     *
     * @return a string representation of the queue
     */
    @Override
    public String toString() {
        var content = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(content);
    }

    /**
     * Main method to test the PriorityQueue implementation with sample operations.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();

        queue.add(5);
        queue.add(3);
        queue.add(6);
        queue.add(1);
        queue.add(4);

        System.out.println(queue); // Output: [6, 5, 4, 3, 1]

        var top = queue.remove();

        System.out.println(top); // Output: 1
        System.out.println(queue); // Output: [6, 5, 4, 3]
    }
}
