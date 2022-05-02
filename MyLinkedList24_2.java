

public class MyLinkedList24_2<E> extends MyAbstractList<E> {
    private Node<E> head, tail;

    @Override
    public E set(int index, E e) {
        if (index < 0 || index > size - 1) return null;
        else {
            Node<E> current = head;
            for (int i = 0; i < index; i++)
                current = current.next;

            current.element = e;
            return current.element;
        }
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        size++;

        if (tail == null)
            tail = head;
    }


    public MyLinkedList(E[] objects) {
        super(objects);
    }
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        if (tail == null) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = tail.next;
        }

        size++;
    }

    public class LinkedListIterator
            implements java.util.Iterator<E> {
        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public E next() {
            E e = current.element;
            current = current.next;
            return e;
        }

        @Override
        public void remove() {
            System.out.println("Implementation left as an exercise");
        }
    }
    @Override
    public void add(int index, E e) {
        if (index == 0) addFirst(e);
        else if (index >= size) addLast(e);
        else {
            Node<E> current = head;
            for (int i = 1; i < index; i++)
                current = current.next;
            Node<E> temp = current.next;
            current.next = new Node<>(e);
            (current.next).next = temp;
            size++;
        }
    }


    public E removeFirst() {
        if (size == 0) return null;
        else {
            Node<E> temp = head;
            head = head.next;
            size--;
            return temp.element;
        }
    }

    public E removeLast() {
        if (size == 0) return null;
        else if (size == 1) {
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        }
        else {
            Node<E> current = head;

            for (int i = 0; i < size - 2; i++)
                current = current.next;

            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) return null;
        else if (index == 0) return removeFirst();
        else if (index == size - 1) return removeLast();
        else {
            Node<E> previous = head;

            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }

            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }
    @Override
    public java.util.Iterator<E> iterator() {
        return new LinkedListIterator();
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", ");
            }
            else {
                result.append("]");
            }
        }

        return result.toString();
    }
    public E getFirst() {
        if (size == 0) {
            return null;
        }
        else {
            return head.element;
        }
    }

    public E getLast() {
        if (size == 0) {
            return null;
        }
        else {
            return tail.element;
        }
    }
    @Override
    public void clear() {
        size = 0;
        head = tail = null;
    }

    @Override
    public boolean contains(E e) {
        if (size == 0) return false;
        else {
            Node<E> current = head;

            while (current != null) {
                if (current.element == e)
                    return true;
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) return null;
        else if (index == 0) return getFirst();
        else if (index == size - 1) return getLast();
        else {
            Node<E> current = head.next;

            for (int i = 1; i < index; i++)
                current = current.next;
            return current.element;
        }

    }

    @Override
    public int indexOf(E e) {
        if (head.element == e) return 0;
        else if (tail.element == e) return size - 1;
        else {
            Node<E> current = head.next;
            int index = 1;
            while (current != null) {
                if (current.element == e)
                    return index;
                current = current.next;
                index++;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        int index = -1;
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (current.element == e)
                index = i;
            current = current.next;
        }

        return index;
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }


    public MyLinkedList() {
    }

}