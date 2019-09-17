import java.util.Scanner;
import java.lang.String;
class QueueArraylist implements Queue {
    int arr[];
    int size;
    int buffer;

    QueueArraylist() {
        size = 0;
        buffer = 2;
        arr = new int[buffer];
    }

    public void enqueue(int q) {
        arr[size] = q;
        size++;
        if (size == buffer) {
            int arr2[] = new int[buffer * 2];
            // buffer = buffer * 2;
            for (int y = 0; y < size; y++) {
                arr2[y] = arr[y];
            }
            arr = arr2;
        }
    }

    public int dequeue() {
        int value = 0;
        try {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException();
            } else {
                value = arr[0];
                arr[0] = 0;
                for (int i = 0; i < size - 1; i++) {
                    arr[i] = arr[i + 1];
                }
                size--;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array is alread empty");
        }
        return value;
    }

    public int peek() {
        return arr[size - 1];
    }

    public int length() {
        return size;
    }
}