package linked_list;

import java.util.*;


public class MyLinkedList<E> implements List<E>, Deque<E> {
    private Node<E> root;
    private Node<E> last;
    private int size = 0;

    public MyLinkedList(Node<E> root, Node<E> last) {
        this.root = root;
        this.last = last;
    }

    public MyLinkedList() {

    }

    @Override
    public boolean add(E e) {
        if (root == null) {
            root = new Node<>(e);
            root.setNextNode(last);
        } else {
            Node<E> object = new Node<>(e);
            if (last != null) {
                last.setNextNode(object);
                last = last.getNextNode();
            } else {
                root.setNextNode(object);
                last = object;
            }
        }
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == 0) {
            add(element);
            return;
        }
        Node<E> next = root.getNextNode();
        Node<E> current = root;
        int nowPos = 0;
        while (nowPos < index) {
            if (nowPos + 1 == index) {
                break;
            }
            next = next.getNextNode();
            current = current.getNextNode();
            nowPos++;
        }
        Node<E> object = new Node<>(element);
        object.setNextNode(next);
        current.setNextNode(object);
        this.size++;
    }

    public void add(int index, Node<E> rootList, Node<E> lastList) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            lastList.setNextNode(root);
            root = rootList;
            return;
        }
        Node<E> current = root;
        Node<E> next = root.getNextNode();
        int nowPos = 0;
        while (nowPos < index) {
            if (nowPos + 1 == index) {
                current.setNextNode(rootList);
                if (next != null) {
                    lastList.setNextNode(next);
                }
                break;
            }
            next = next.getNextNode();
            current = current.getNextNode();
            nowPos++;
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c.isEmpty()) return false;
        for (E e : c) {
            add(e);
        }
        return true;
    }

    @Override
    public void addFirst(E e) {
        Node<E> object = new Node<>(e);
        object.setNextNode(root);
        root = object;
        size++;
    }

    @Override
    public void addLast(E e) {
        Node<E> object = new Node<>(e);
        last.setNextNode(object);
        last = last.getNextNode();
        size++;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        MyLinkedList<E> linkedList = new MyLinkedList<>();
        for (E e : c) {
            linkedList.add(e);
        }
        add(index, linkedList.getRoot(), linkedList.getLastNode());
        size += c.size();
        return true;
    }

    @Override
    public void clear() {
        size = 0;
        root = null;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public E element() {
        return root.getData();
    }

    @Override
    public E get(int index) {
        if (root == null)
            return null;
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int pos = 0;
        Node<E> tmp = root;
        while (pos != index) {
            tmp = tmp.getNextNode();
            pos++;
        }
        return tmp.getData();
    }

    private Node<E> getRoot() {
        return root;
    }

    public Node<E> getLastNode() {
        return last;
    }

    @Override
    public E getFirst() {
        return root.getData();
    }

    @Override
    public E getLast() {
        return last.getData();
    }

    @Override
    public int indexOf(Object o) {
        int count = 0;
        boolean checker = false;
        Node<E> tmp = root;
        while (tmp != null) {
            if (o.equals(tmp.getData())) {
                checker = true;
                break;
            }
            tmp = tmp.getNextNode();
            count++;
        }
        if (!checker) {
            count = -1;
        }
        return count;
    }

    @Override
    public int lastIndexOf(Object o) {
        int count = 0;
        int lastIndex = -1;
        Node<E> tmp = root;
        while (tmp != null) {
            if (o.equals(tmp.getData())) {
                lastIndex = count;
            }
            tmp = tmp.getNextNode();
            count++;
        }
        return lastIndex;
    }

    @Override
    public boolean offer(E e) {
        addLast(e);
        return true;
    }

    @Override
    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    @Override
    public E peek() {
        return root.getData();
    }

    @Override
    public E peekFirst() {
        return peek();
    }

    @Override
    public E peekLast() {
        return last.getData();
    }

    @Override
    public E poll() {
        return remove(0);
    }

    @Override
    public E pollFirst() {
        if (isEmpty()) return null;
        return poll();
    }

    @Override
    public void push(E e) {
        add(0, e);
    }

    @Override
    public E pop() {
        return remove(0);
    }

    @Override
    public E remove() {
        return remove(0);
    }

    @Override
    public E removeFirst() {
        return remove(0);
    }

    @Override
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public E pollLast() {
        return remove(size - 1);
    }


    @Override
    public boolean removeFirstOccurrence(Object o) {
        return remove(o);
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        int lastPosition = -1;
        Node<E> current = root;
        for (int i = 0; i < size; i++) {
            if (current.getData().equals(o)) {
                lastPosition = i;
            }
            current = current.getNextNode();
        }
        if (lastPosition != -1)
            remove(lastPosition);
        return true;

    }

    @Override
    public boolean remove(Object o) {
        if (o == null || isEmpty())
            return false;
        Node<E> prev = root;
        Node<E> current = root.getNextNode();
        boolean checker = false;
        if (root.getData().equals(o)) {
            root = root.getNextNode();
            checker = true;
        }
        while (current != null && !checker) {
            if (o.equals(current.getData())) {
                prev.setNextNode(current.getNextNode());
                checker = true;
                break;
            }
            prev = current;
            current = current.getNextNode();
        }
        if (checker)
            size--;

        return true;
    }

    @Override
    public E remove(int index) {
        if (index > this.size()) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> object = new Node<>(get(index));
        remove(object.getData());
        return object.getData();
    }

    @Override
    public E set(int index, E element) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> object = new Node<>(element);
        Node<E> current = root;
        if (index == 0) {
            object.setNextNode(root.getNextNode());
            root.setNextNode(object);
            root = root.getNextNode();
        }
        for (int i = 0; i < size; i++) {
            if (index == i + 1) {
                object.setNextNode(current.getNextNode().getNextNode());
                current.setNextNode(object);
                break;
            }
            current = current.getNextNode();
        }
        return current.getData();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<E> checker = root;
        int count = 0;
        while (checker != null) {
            array[count++] = checker.getData();
            checker = checker.getNextNode();
        }
        return array;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            a = (T[]) java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size);
        int i = 0;
        Object[] result = a;
        for (Node<E> x = root; x != null; x = x.getNextNode()) {
            result[i++] = x.getData();
        }
        return a;
    }

    /*
    AbstractCollection
    */

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c.isEmpty() || c.size() > size)
            return false;
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (root == null)
            return false;
        for (Object e : c) {
            remove(e);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException();
        }
        Node<E> current = root;
        boolean checker;
        int length = size;
        for (int i = 0; i < length; i++) {
            checker = false;
            for (Object e : c) {
                if (current.getData().equals(e)) {
                    checker = true;
                    break;
                }
            }
            if (!checker) {
                remove(current.getData());
            }
            current = current.getNextNode();
        }
        return true;
    }

    public String toString() {
        return "";
    }

    /*
    Methods inherited from class java.util.AbstractList
    */

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex > size || toIndex > size || fromIndex > toIndex || fromIndex < 0) {
            throw new IndexOutOfBoundsException();
        }
        List<E> result = new MyLinkedList<>();
        int pos = 0;
        Node<E> current = root;
        while (pos < toIndex) {
            if (pos > fromIndex) {
                result.add(current.getData());
            }
            current = current.getNextNode();
            pos++;
        }
        return result;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }

}
