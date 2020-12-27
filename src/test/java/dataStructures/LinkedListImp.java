package dataStructures;

public class LinkedListImp implements List {
    private Node head;
    private Node tail;
    private int size;

    @Override
    public void add(String newEl) {
        if (size == 0) {
            Node newElement = new Node(newEl, null, null);
            this.head = newElement;
            this.tail = newElement;
        } else if (size == 1) {
            Node newElement = new Node(newEl, null, head);
            this.tail = newElement;
            this.head.next = newElement;
        } else {
            Node newElement = new Node(newEl, null, null);
            Node temp = tail;
            this.tail = newElement;
            temp.next = tail;
            this.tail.prev = temp;
        }
        size++;

    }

    @Override
    public String get(int index) {
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.value;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    class Node {
        String value;
        Node next;
        Node prev;

        public Node(String element, Node next, Node prev) {
            this.value = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
