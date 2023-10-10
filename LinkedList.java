package DataStructuresAndAlgorithms;

import java.util.NoSuchElementException;

/**
 * This class implements a singly linked list.
 */
public class LinkedList {

    /**
     * This class represents a node in the linked list.
     */
    private class Node {
        private int value; // The value stored in this node
        private Node next; // The next node in the list

        /**
         * Constructs a new node with the given value.
         *
         * @param value the value to store in this node
         */
        public Node(int value) {
            this.value = value;
        }
    }

    private Node first; // The first node in the list
    private Node last; // The last node in the list
    private int size; // The number of elements in the list

    /**
     * Adds a new element to the beginning of the list.
     *
     * @param item the value to add
     */
    public void addFirst(int item) {
        var node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }

        size++;
    }

    /**
     * Adds a new element to the end of the list.
     *
     * @param item the value to add
     */
    public void addLast(int item) {
        var node = new Node(item);

        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }

        size++;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this
     * list,
     * or -1 if this list does not contain the element.
     *
     * @param item the element to search for
     * @return the index of the first occurrence of the specified element or -1 if
     *         the element is not present
     */
    public int indexOf(int item) {
        int index = 0;
        var current = first;

        while (current != null) {
            if (current.value == item)
                return index;

            current = current.next;
            index++;
        }

        return -1;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if this list contains the specified element.
     *
     * @param item the element to search for
     * @return true if this list contains the specified element, false otherwise
     */
    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    /**
     * Removes the first element from this list.
     *
     * @throws NoSuchElementException if the list is empty
     */
    public void deleteFirst() {

        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            var second = first.next;
            first.next = null;
            first = second;
        }

        size--;
    }

    /**
     * Removes the last element from this list.
     *
     * @throws NoSuchElementException if the list is empty
     */
    public void deleteLast() {

        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }

        size--;
    }

    /**
     * Returns the node preceding the specified node, or null if the specified node
     * is the first node.
     *
     * @param node the node whose predecessor is to be returned
     * @return the preceding node, or null if the specified node is the first node
     */
    private Node getPrevious(Node node) {
        var current = first;

        while (current != null) {
            if (current.next == node)
                return current;

            current = current.next;
        }

        return null;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements, false otherwise
     */
    private boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence.
     *
     * @return an array containing all of the elements in this list in proper
     *         sequence
     */
    public int[] toArray() {
        int[] array = new int[size];

        var current = first;
        var index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    /**
     * Reverses the order of the elements in this list.
     */
    public void reverse() {

        if (isEmpty())
            return;

        var previous = first;
        var current = first.next;

        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    /**
     * Returns the value of the element at the specified position from the end of
     * the list.
     *
     * @param k the position from the end of the list (1-based index)
     * @return the value of the element at the specified position from the end of
     *         the list
     * @throws IllegalStateException    if the list is empty
     * @throws IllegalArgumentException if the specified position is non-positive or
     *                                  greater than the size of the list
     */
    public int getKthNodeFromEnd(int k) {

        if (isEmpty())
            throw new IllegalStateException();

        if (k <= 0)
            throw new IllegalArgumentException();

        var a = first;
        var b = first;

        for (int i = 0; i < k - 1; i++) {
            b = b.next;

            if (b == null)
                throw new IllegalArgumentException();
        }

        while (b != last) {
            a = a.next;
            b = b.next;
        }

        return a.value;
    }

    // ... (rest of your LinkedList class)

    public static void main(String[] args) {
        // Create a new LinkedList instance
        LinkedList list = new LinkedList();

        // Add some elements to the list
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);

        // Display the size of the list
        System.out.println("Size: " + list.size()); // Output: 3

        // Check if a particular element is present in the list
        System.out.println("Contains 20: " + list.contains(20)); // Output: true
        System.out.println("Contains 40: " + list.contains(40)); // Output: false

        // Get and display the index of a particular element
        System.out.println("Index of 20: " + list.indexOf(20)); // Output: 1

        // Delete the first and last elements
        list.deleteFirst();
        list.deleteLast();

        // Display the remaining elements as an array
        int[] array = list.toArray();
        for (int value : array) {
            System.out.print(value + " "); // Output: 20
        }
        System.out.println();

        // Reverse the list and display the elements again
        list.reverse();
        array = list.toArray();
        for (int value : array) {
            System.out.print(value + " "); // Output: 20
        }
        System.out.println();

        // Attempt to get the 1st node from the end of the list
        try {
            System.out.println("1st node from end: " + list.getKthNodeFromEnd(1)); // Output: 20
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
