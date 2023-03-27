package L01;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class DLinkedList<T> implements List<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (isEmpty())
            return false;

        Node<T> temp = head;

        while (temp.hasNext()) {
            if (temp.getValue().equals(o))
                return true;
            temp = temp.getNext();
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            Node<T> temp = head;
            ;

            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public T next() {
                T value = temp.getValue();
                temp = temp.getNext();
                return value;
            }
        };
    }

    @Override
    public Object[] toArray() {
        if (isEmpty())
            return new Object[0];
        Object[] object = new Object[size];

        Node<T> temp = head;
        for (int i = 0; temp.hasNext(); i++, temp = temp.getNext()) {
            object[i] = temp.getValue();
        }
        return object;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        Node<T> newNode = new Node<>(t);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }

        size++;
        return true;

    }

    @Override
    public boolean remove(Object o) {
        boolean flag = false;
        if (isEmpty())
            return false;
        if (head.getValue().equals(o)) {
            head = head.getNext();
            head.setPrev(null);
            flag = true;
        }
        if (tail.getValue().equals(o) && !flag) {
            tail = tail.getPrev();
            tail.setNext(null);
            flag = true;
        }
        Node<T> temp = head;
        while (temp.hasNext() && !flag) {
            if (temp.getValue().equals(o)) {

                temp.getPrev().setNext(temp.getNext());
                temp.getNext().setPrev(temp.getPrev());
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        size -= flag ? 1 : 0;
        return flag;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        head = tail = null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {


    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        if (isEmpty())
            return -1;
        Node<T> temp = head;
        int index = 0;
        while (temp.hasNext()) {
            if (temp.getValue().equals(o))
                return index;
            temp = temp.getNext();
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (isEmpty())
            return -1;
        Node<T> temp = tail;
        int index = size;
        while (temp.hasPrev()) {
            if (temp.getValue().equals(o))
                return index;
            temp = temp.getPrev();
            index--;
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}