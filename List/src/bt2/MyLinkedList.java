package bt2;

public class MyLinkedList<E> {
    private Node<E> head;
    private int numNodes = 0;

    // Inner class for Node
    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }

    // Constructor with initial node
    public MyLinkedList(E data) {
        head = new Node<>(data);
        numNodes++;
    }

    // Add element at specific index
    public void add(int index, E data) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numNodes);
        }

        Node<E> newNode = new Node<>(data);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<E> temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        numNodes++;
    }

    // Add element at the beginning
    public void addFirst(E data) {
        add(0, data);
    }

    // Add element at the end
    public void addLast(E data) {
        add(numNodes, data);
    }

    // Remove element at specific index
    public E remove(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numNodes);
        }

        Node<E> temp = head;
        if (index == 0) {
            head = head.next;
        } else {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node<E> nodeToRemove = temp.next;
            temp.next = nodeToRemove.next;
            temp = nodeToRemove;
        }
        numNodes--;
        return temp.data;
    }

    // Remove specific element
    public boolean remove(Object o) {
        Node<E> temp = head;
        Node<E> previous = null;

        while (temp != null) {
            if (temp.data.equals(o)) {
                if (previous == null) {
                    head = temp.next;
                } else {
                    previous.next = temp.next;
                }
                numNodes--;
                return true;
            }
            previous = temp;
            temp = temp.next;
        }
        return false;
    }

    // Get element at specific index
    public E get(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numNodes);
        }

        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    // Get size of the list
    public int size() {
        return numNodes;
    }

    // Print list elements
    public void printList() {
        Node<E> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Clone the list
    public MyLinkedList<E> clone() {
        MyLinkedList<E> clonedList = new MyLinkedList<>(head.data);
        Node<E> temp = head.next;

        while (temp != null) {
            clonedList.addLast(temp.data);
            temp = temp.next;
        }
        return clonedList;
    }

    // Check if list contains an element
    public boolean contains(E o) {
        Node<E> temp = head;
        while (temp != null) {
            if (temp.data.equals(o)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Get index of an element
    public int indexOf(E o) {
        Node<E> temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data.equals(o)) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }
}
