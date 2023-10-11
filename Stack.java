package DataStructuresAndAlgorithms;

import java.util.Arrays;

public class Stack {
    private int[] elements;
    private int top;

    // Constructor to initialize stack with a specified capacity
    public Stack(int capacity) {
        elements = new int[capacity];
        top = -1; // Top is -1 when stack is empty
    }

    // Method to add an item to the stack
    public void push(int item) {
        if (top == elements.length - 1) {
            throw new StackOverflowError("Stack is full");
        }
        elements[++top] = item;
    }

    // Method to remove and return the top item from the stack
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements[top--];
    }

    // Method to return the top item from the stack without removing it
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements[top];
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(elements, 0, top + 1);
        return Arrays.toString(content);
    }

    public static void main(String[] args) {
        // Test the Stack implementation
        Stack stack = new Stack(10);
        stack.push(5);
        stack.push(10);
        stack.push(15);
        System.out.println(stack.toString()); // Output: [5, 10, 15]
        System.out.println(stack.peek()); // Output: 15
        System.out.println(stack.pop()); // Output: 15
        System.out.println(stack.peek()); // Output: 10
        System.out.println(stack.isEmpty()); // Output: false
        stack.pop();
        stack.pop();
        System.out.println(stack.isEmpty()); // Output: true
    }
}
