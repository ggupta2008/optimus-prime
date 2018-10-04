package ds;


// Used in algorithms like Tower of Hanoi, tree traversals, stock span problem, histogram problem.
// Used in Backtracking, Knight tour problem, rat in a maze, N queen problem and sudoku solver

import java.util.Vector;

public class Stack<T> {

    private Vector<T> vector = new Vector<>();

    public T push(T item) {
        vector.add(item);
        return item;
    }

    public T pop() {
        if(vector == null) return null;
        if (vector.isEmpty()) return null;

        T item = vector.elementAt(vector.size() -1);
        vector.remove(vector.size()-1);
        return item;
    }

    public T peek() {
        return vector.stream().skip(vector.size() - 1).findFirst().get();
    }

    public T search(T item) {
        return null;
    }

    public boolean isEmpty() {
        return vector.isEmpty();
    }

    @Override
    public String toString() {
        return "Stack{" +
                "vector=" + vector +
                '}';
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        System.out.println(stack.isEmpty());
        stack.push("Gaurav");
        System.out.println(stack);
        stack.push("Gupta");
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }

}
