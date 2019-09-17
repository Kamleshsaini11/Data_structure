import java.util.Scanner;
import java.lang.String;
class StackArrayList implements Stack {
    int arr[];
    int size;
    int buffer;

    StackArrayList() {
        size = 0;
        buffer = 10;
        arr = new int[buffer];
    }

    public void push(int q) {
        arr[size] = q;
        size++;
        if (size == buffer) {
            int arr2[] = new int[buffer * 2];
            buffer = buffer * 2;
            for (int y = 0; y < size; y++) {
                arr2[y] = arr[y];
            }
            arr = arr2;
        }
    }
    public int pop() {
        int value=0;
        try
        {
           if (size==0)
           {
              throw new ArrayIndexOutOfBoundsException();
           }
           else
           {
              value=arr[size-1];
              arr[size-1]=0;
              size--;
           }       
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
           System.out.println("Array is alread empty");
        }
        return value;
     }  
       public int peek()
       {
         return arr[size-1];
        }
         public int length()
        {
           return size;
        } 
}