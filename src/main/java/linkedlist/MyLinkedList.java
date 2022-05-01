package linkedlist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class MyLinkedList<E> implements List<E> {
    private Node<E> root;
    private Node<E> last; // dodelat v teoriu
    private int size = 0;

    @Override
    public int size() {
        if (isEmpty())
            return 0;
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[this.size()];
        Node<E> checker = root;
        int count = 0;
        while (checker != null) {
            array[count] = checker.getData();
            count++;
            checker = checker.getNextNode();
        }
        return array;
    }

    @Override
    public boolean add(E e) {
        if (root == null) {
            root = new Node<>(e);
            this.size++;
        } else {
            Node<E> object = new Node<>(e);
            if (last != null) {
                last.setNextNode(object);
                last = last.getNextNode();
            } else {
                root.setNextNode(object);
                last = object;
            }
            this.size++;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null)
            return false;
        if (o.equals(root.getData())) {
            root = root.getNextNode();
            return true;
        }
        Node<E> tmp = root;
        Node<E> next = root.getNextNode();
        while (!o.equals(next.getData())) {
            tmp = tmp.getNextNode();
            next = next.getNextNode();
        }
        if (next != null) {
            next = next.getNextNode();
        }
        tmp.setNextNode(next);
        size--;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c.isEmpty() || c.size() > size)
            return false;
        Object[] array = c.toArray();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (contains(array[i])) {
                count++;
            }
        }
        return (size == count);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        @SuppressWarnings("unchecked")
        E[] arrray = (E[]) c.toArray();
        for (E e : arrray) {
            add(e);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        @SuppressWarnings("unchecked")
        E[] arrray = (E[]) c.toArray();
        int count = index;
        for (E e : arrray) {
            add(count, e);
            count++;
        }
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean removeAll(Collection<?> c) {
        if (root == null)
            return false;
        E[] array = (E[]) c.toArray();
        for (E e : array) {
            remove(e);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c == null) {
            throw new NullPointerException();
        }
        @SuppressWarnings("unchecked")
        E[] array = (E[]) c.toArray();
        Node<E> current = root;
        boolean check = false;
        for (int i = 0; i < size; i++) {
            check = false;
            for (E e : array) {
                if (current.getData().equals(e)) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                remove(current.getData());
            }
            current = current.getNextNode();
        }
        return true;
    }

    @Override
    public void clear() {
        root = null;
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
        while (pos < size - 1) {
            tmp = tmp.getNextNode();
            pos++;
        }
        return tmp.getData();
    }

    @Override
    public E set(int index, E element) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> object = new Node<>(element);
        Node<E> prev = root;
        if (index == 0) {
            object.setNextNode(root.getNextNode());
            root = object;
            return prev.getData();
        }
        Node<E> tmp = root.getNextNode();
        for (int i = 1; i < size; i++) {
            if (index == i) {
                prev.setNextNode(object);
                object.setNextNode(tmp.getNextNode());
                break;
            }
            if (tmp.getNextNode() != null) {
                tmp = tmp.getNextNode();
            }
            prev = prev.getNextNode();
        }
        return tmp.getData();
    }

    @Override
    public void add(int index, E element) {
        if (index > this.size()) {
            return;
        }
        if (index == 0) {
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

    @Override
    public E remove(int index) {
        if (index > this.size()) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> object = new Node<>(get(index));
        remove(object);
        return object.getData();
    }

    @Override
    public int indexOf(Object o) {
        int pos = -1;
        int count = 0;
        Node<E> tmp = root;
        while (tmp != null) {
            if (o.equals(tmp.getData())) {
                pos = count;
                break;
            }
            tmp = tmp.getNextNode();
            count++;
        }
        return pos;
    }

    @Override
    public int lastIndexOf(Object o) {
        int pos = -1;
        int count = 0;
        Node<E> tmp = root;
        while (count < size) {
            if (tmp == null)
                break;
            if (tmp.getData().equals(o)) {
                pos = count;
            }
            count++;
            tmp = tmp.getNextNode();
        }
        return pos;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex > size || toIndex > size || fromIndex > toIndex || fromIndex < 0) {
            throw new IndexOutOfBoundsException();
        }
        MyLinkedList<E> result = new MyLinkedList<>();
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
        if (a.length > size)
            a[size] = null;

        return a;
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

}
