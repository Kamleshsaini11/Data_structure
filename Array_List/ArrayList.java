import java.lang.String;
import java.util.Scanner;
class ArrayList implements List {
    int arr[];
    int size;
    int buffer;

    ArrayList() {
        size = 0;
        buffer = 3;
        //arr = (D [])new Object[buffer];
        arr =new int[buffer];
    }

    public void add(int obj) {
        if (size == buffer) {
            int arr2[] = new int[buffer * 2];
            buffer = buffer * 2;
            for (int y = 0; y < size; y++) {
                arr2[y] = arr[y];
            }
            arr = arr2;
        }
        arr[size] = obj;
        size++;
    }

    public void add(int obj, int pos) {
        if (size == buffer) {
            int arr2[] = new int[buffer * 2];
            buffer = buffer * 2;
            for (int y = 0; y < size; y++) {
                arr2[y] = arr[y];
            }
            arr = arr2;
        }
        try {
            if (pos < 0) {
                throw new ArrayIndexOutOfBoundsException();
            } else if (pos == size) {
                arr[size] = obj;
                size++;
            } else {
                for (int i = size - 1; i >= pos; i--) {
                    arr[i + 1] = arr[i];
                }
                arr[pos] = obj;
                size++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("please enter the valid index number from 0 to " + size + " " + "for add " + obj);
            Scanner scan = new Scanner(System.in);
            int i = scan.nextInt();
            add(obj, i);
        }
    }

    public int remove(int pos) {
            int value=0;
        try {
            value=arr[pos];
            if (pos < 0 || pos >= size) {
                throw new ArrayIndexOutOfBoundsException();
            } else if (pos == size - 1) {
                arr[size - 1] = 0;
                size--;
            } else {
                for (int i = pos; i < size - 1; i++) {
                    arr[i] = arr[i + 1];
                }
                arr[size - 1] = 0;
                size--;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(
                    "Plese Enter a valid index number from 0 to" + (size - 1) + "for remove elements from " + pos);
        }
        return value;

    }

    public void search(int obj) {
        int f = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] == obj) {
                f = 1;
                System.out.println("position of given number is " + i);
                break;
            }
        }
        if (f != 1) {
            System.out.println("please enter a write obj");
        }
    }

    public void reverse() {
        System.out.println("List is");
        int arr2[] = new int[size];
        int j = 0;
        for (int i = size - 1; i >= 0; i--) {
            arr2[j] = arr[i];
            j++;
        }
        arr = arr2;
    }

    public void traverse() {
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("size of array list is" + " " + size);
    }
}