package DataStructuresAndAlgorithms;

import java.util.Arrays;

/**
 * This class implements a queue using a circular array.
 */
public class ArrayQueue {

    private int[] items; // Array to hold the elements of the queue
    private int front; // Index of the front element of the queue
    private int rear; // Index where the next element will be added
    private int count; // Current number of elements in the queue

    /**
     * Constructs an empty queue with the specified capacity.
     *
     * @param capacity the capacity of the queue
     */
    public ArrayQueue(int capacity) {
        items = new int[capacity];
        front = 0;
        rear = 0;
    }

    /**
     * Adds an item to the rear of the queue.
     *
     * @param item the item to be added
     * @throws IllegalStateException if the queue is full
     */
    public void enqueue(int item) {
        if (isFull())
            throw new IllegalStateException("Queue is full.");

        items[rear] = item;
        rear = (rear + 1) % items.length; // Allows Array to be circular
        count++;
    }

    /**
     * Removes and returns the item at the front of the queue.
     *
     * @return the item at the front of the queue
     * @throws IllegalStateException if the queue is empty
     */
    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException("Empty Queue cannot be dequeued.");

        var item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length; // Allows Array to be circular
        count--;

        return item;
    }

    /**
     * Returns the item at the front of the queue without removing it.
     *
     * @return the item at the front of the queue
     * @throws IllegalStateException if the queue is empty
     */
    public int peek() {
        if (isEmpty())
            throw new IllegalStateException("Empty queue cannot be peeked.");

        return items[front];
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
        return Arrays.toString(items);
    }

    /**
     * Main method to test the ArrayQueue implementation with sample operations.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        var queue = new ArrayQueue(5);

        // Populate Queue
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println(queue);

        // Remove front of queue.
        var front = queue.dequeue();

        // Add to queue.
        queue.enqueue(60);

        System.out.println(front);

        // Display contents of circular array queue.
        System.out.println(queue);
    }
}
