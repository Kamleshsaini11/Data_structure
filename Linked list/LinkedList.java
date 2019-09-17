import java.lang.String;
class LinkedList {
    Node firstnode;
    int size;

    LinkedList() {
        firstnode = null;
        size = 0;
    }

    public void insertAtFirst(int a) {
        Node node = new Node();
        node.data = a;
        node.next = null;
        if (firstnode == null) {
            firstnode = node;
            size++;
        } else {
            node.next = firstnode;
            firstnode = node;
            size++;
        }
    }

    public void insertAtLast(int a) {
        Node node = new Node();
        node.data = a;
        node.next = null;

        if (firstnode == null) {
            firstnode = node;
            size++;
        } else {
            Node node1 = new Node();
            node1 = firstnode;
            while (node1.next != null) {
                node1 = node1.next;
            }
            node1.next = node;
            size++;
        }
    }

    public void insertAtPosition(int a, int pos) { // where a is element and b is the position of the elements
                                                          // where we
        // want to story value
        if (pos < 0 || pos > size) {
            System.out.println("please enter the write position between 0 to" + size);
        }
        Node node = new Node();
        node.data = a;
        Node n = new Node();
        n = firstnode;
        for (int i = 0; i < pos - 1; i++) {
            n = n.next;
        }
        node.next = n.next;
        n.next = node;
        size++;
    }

    public void removeAtFirst() {
        if (firstnode == null) {
            System.out.println("List is already empty");
            size--;
        }
        if (firstnode.next == null) {
            firstnode = null;
            size--;
        }
        Node n = new Node();
        n = firstnode;
        firstnode = firstnode.next;
        n = null;
        size--;

    }

    public void removeAtLast() {
        if (firstnode == null) {
            System.out.println("List is already empty");
            size--;
        }
        if (firstnode.next == null) {
            firstnode = null;
            size--;
        }
        Node n = new Node();
        Node n1 = new Node();
        n = firstnode;
        n1 = n.next;
        while (n1.next != null) {
            n1 = n1.next;
            n = n.next;
        }
        n.next = null;
        size--;
    }

    public void removeAtPosition(int pos) {
        if (pos < 0 || pos >= size) {
            System.out.println("please enter the write position between 0 to" + (size - 1));
        }
        if (pos == 0) {
            removeAtFirst();
        } else {
            Node n = new Node();
            // Node n1=new Node();
            n = firstnode;
            for (Integer i = 0; i < pos - 1; i++) {
                n = n.next;
            }
            n.next = n.next.next;
            size--;
        }
    }

    public void search(int a) // Here a is the element,and this function is tell position of given elements
    {
        Node n = new Node();
        n = firstnode;
        int i = 0, f = 0;
        while (n.next != null) {
            if (a == n.data) {
                if (f == 1) {
                    System.out.print(i + " ");
                } else {
                    System.out.print("position of given number is " + i + " ");
                }
                f = 1;
            }
            n = n.next;
            i++;
        }
        if (n.data == a) {
            if (f == 1) {
                System.out.println(i + " ");
            } else
                System.out.println("position of given number is " + i + " ");
        } else {
            System.out.println("");
        }
        if (f != 1) {
            System.out.println("Given number is not in list");
        }
    }

    public void ReverseList() {
        Node previous = new Node();
        Node current = new Node();
        Node next = new Node();
        current = firstnode;
        previous = next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        firstnode = previous;
    }

    public void show() {
        Node n = new Node();
        n = firstnode;
        while (n.next != null) {
            System.out.println(n.data);
            n = n.next;
        }
        System.out.println(n.data);
        System.out.println("size of a array is " + size);
    }
}