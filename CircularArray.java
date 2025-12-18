import java.util.NoSuchElementException;
import java.util.Scanner;

public class CircularArray {

    private int[] arr;
    private int front, rear, count;

    // Constructor
    public CircularArray(int size) {
        arr = new int[size];
        front = 0;
        rear = 0;
        count = 0;
    }

    // ADD (no duplicates)
    public void add(int value) {
        if (count == arr.length) {
            System.out.println("Array is full");
            return;
        }

        // check duplicate
        for (int i = 0; i < count; i++) {
            int index = (front + i) % arr.length;
            if (arr[index] == value) {
                System.out.println("Duplicate element not allowed");
                return;
            }
        }

        arr[rear] = value;
        rear = (rear + 1) % arr.length;
        count++;
        System.out.println("Added");
    }

    // REMOVE
    public int remove() {
        if (count == 0) {
            throw new NoSuchElementException("Array is empty");
        }

        int out = arr[front];
        front = (front + 1) % arr.length;
        count--;
        return out;
    }

    // DISPLAY
    public void display() {
        if (count == 0) {
            System.out.println("Array is empty");
            return;
        }

        System.out.print("Elements: ");
        for (int i = 0; i < count; i++) {
            int index = (front + i) % arr.length;
            System.out.print(arr[index] + " ");
        }
        System.out.println();
    }

    // SEARCH (Bonus)
    public boolean search(int value) {
        for (int i = 0; i < count; i++) {
            int index = (front + i) % arr.length;
            if (arr[index] == value) {
                return true;
            }
        }
        return false;
    }

    // MAIN
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = sc.nextInt();

        CircularArray ca = new CircularArray(size);

        ca.add(10);
        ca.add(20);
        ca.add(30);
        ca.display();

        ca.remove();
        ca.display();

        System.out.println("Search 20: " + ca.search(20));
    }
}
