import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.testng.annotations.Test;

import linkedlist.MyLinkedList;

public class LinkedListTest {
    /*
    Check void add(int index, Object o)
    Insert in middle of linked list
    */
    @Test
    public void first() {
        String word_v1 = "Zero";
        String word_v2 = "Two";
        String word_v3 = "Three";
        String word_finall = "Four";
        //Java classic Linked List
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(word_v1);
        linkedList.add(word_v2);
        linkedList.add(word_v3);
        linkedList.add(2, word_finall);

        //My implement
        MyLinkedList<String> mylist = new MyLinkedList<>();
        mylist.add(word_v1);
        mylist.add(word_v2);
        mylist.add(word_v3);
        mylist.add(2,word_finall);
        //записывать в массив и тупо сравнивать потом
        
        assertArrayEquals(linkedList.toArray(), mylist.toArray());
    }
    /*
    Check void add(int index, Object o)
    Insert in first index
    */
    @Test
    public void second()
    {        
        String word_v1 = "Zero";
        //Java classic Linked List
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(word_v1);
        //My implement
        MyLinkedList<String> mylist = new MyLinkedList<>();
        mylist.add(0,word_v1);
        System.out.println("word_v1 - "+linkedList.get(0) + " word_v2 - " + mylist.get(0));
        assertArrayEquals(linkedList.toArray(), mylist.toArray());
    }
    /*
    Check void add(int index, Object o)
    Insert in last index
    */
    @Test
    public void three()
    {        
        String word_v1 = "Zero";
        //Java classic Linked List
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(word_v1);
        linkedList.add(word_v1);
        //My implement
        MyLinkedList<String> mylist = new MyLinkedList<>();
        mylist.add(word_v1);
        mylist.add(1, word_v1);
        assertArrayEquals(linkedList.toArray(), mylist.toArray());
    }
    /*
    Check int indexOf(Object o)
    */
    @Test
    public void four()
    {
        String word_v1 = "Zero";
        //Java classic Linked List
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(word_v1);
        linkedList.add(word_v1);
        //My implement
        MyLinkedList<String> mylist = new MyLinkedList<>();
        mylist.add(word_v1);
        mylist.add(1, word_v1);

        int expected = linkedList.indexOf(word_v1);
        int actual = mylist.indexOf(word_v1);
        assertEquals(expected, actual);
    }
    /*
    Check int indexOf(Object o)
    If dont have object in the list
    */
    @Test
    public void five()
    {
        String word_v1 = "Zero";
        //Java classic Linked List
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(word_v1);
        linkedList.add(word_v1);
        //My implement
        MyLinkedList<String> mylist = new MyLinkedList<>();
        mylist.add(word_v1);
        mylist.add(1, word_v1);

        int expected = linkedList.indexOf("Bababa");
        int actual = mylist.indexOf("bababa");
        assertEquals(expected, actual);
    }
    /*
    Check int lastindexOf
    */
    @Test
    public void six()
    {
        String word_v1 = "Zero";
        //Java classic Linked List
        LinkedList linkedList = new LinkedList<>();
        linkedList.add(word_v1);
        linkedList.add(word_v1);
        //My implement
        MyLinkedList mylist = new MyLinkedList<>();
        mylist.add(word_v1);
        mylist.add(1, word_v1);

        int expected = linkedList.lastIndexOf(word_v1);
        int actual = mylist.lastIndexOf("Zero");
        assertEquals(expected, actual);
    }
    /*
    Check get(int index) -  first index
    */
    @Test
    public void seven()
    {
        String word_v1 = "Zero";
        //Java classic Linked List
        LinkedList linkedList = new LinkedList<>();
        linkedList.add(word_v1);
        linkedList.add(word_v1);
        //My implement
        MyLinkedList mylist = new MyLinkedList<>();
        mylist.add(word_v1);
        mylist.add(1, word_v1);

        Object expected = linkedList.get(0);
        Object actual = mylist.get(0);
        assertEquals(expected, actual);
    }
    /*
    Check get(int index) -  last index
    */
    @Test
    public void eight()
    {
        String word_v1 = "Zero";
        //Java classic Linked List
        LinkedList linkedList = new LinkedList<>();
        linkedList.add(word_v1);
        linkedList.add(word_v1);
        //My implement
        MyLinkedList mylist = new MyLinkedList<>();
        mylist.add(word_v1);
        mylist.add(1, word_v1);

        Object expected = linkedList.get(1);
        Object actual = mylist.get(1);
        assertEquals(expected, actual);
    }
    /*
    Check get(int index) -  Exception
    */
//    @Test(expected = IndexOutOfBoundsException.class)
//    public void nine()
//    {
//        String word_v1 = "Zero";
//        MyLinkedList mylist = new MyLinkedList<>();
//        mylist.add(word_v1);
//        mylist.add(1, word_v1);
//        Object actual = mylist.get(5);
//    }
    /*
    Check subList function
    */
    @Test
    public void ten()
    {
        String word_v1 = "Zero";
        //Java classic Linked List
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(word_v1);
        linkedList.add(word_v1);
        linkedList.add(word_v1);
        linkedList.add(word_v1);
        //My implement
        MyLinkedList<String> mylist = new MyLinkedList<>();
        mylist.add(word_v1);
        mylist.add(word_v1);
        mylist.add(word_v1);
        mylist.add(word_v1);
        List expected = linkedList.subList(0, 4);
        List actual =  linkedList.subList(0, 4);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }
    /*
    Check subList - Invalid index
    */
//    @Test(expected = IndexOutOfBoundsException.class)
//    public void eleven()
//    {
//        String word_v1 = "Zero";
//        //My implement
//        MyLinkedList<String> mylist = new MyLinkedList<>();
//        mylist.add(word_v1);
//        mylist.add(word_v1);
//        mylist.add(word_v1);
//        mylist.add(word_v1);
//        List<String> actual =  mylist.subList(0, 5);
//    }
    /*
    Check containsAll(Collection<?> c)
    */
    @Test
    public void twelf()
    {
        List <String> list1 = new ArrayList();  
        list1.add("One");
        list1.add("Second");
        list1.add("Three");
        //My implement
        
        MyLinkedList<String> actual = new MyLinkedList<>();
        actual.add(list1.get(0));
        actual.add(list1.get(1));
        actual.add(list1.get(2));

        LinkedList<String> expected = new LinkedList<>();
        expected.add(list1.get(0));
        expected.add(list1.get(1));
        expected.add(list1.get(2));
        assertEquals(expected.containsAll(list1), actual.containsAll(list1));
    }
    /*
    addAll(Collection<? extends E> c)
    */
    @Test
    public void thirteen()
    {
        List <String> list1 = new ArrayList();  
        list1.add("One");
        list1.add("Second");
        list1.add("Three");
        //My implement
        MyLinkedList<String> actual = new MyLinkedList<>();
        LinkedList<String> expected = new LinkedList<>();
        actual.addAll(list1);
        expected.addAll(list1);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }
    /*
    addAll(int index, Collection<? extends E> c)
    */
    @Test
    public void fourteen()
    {
        List <String> list1 = new ArrayList();  
        list1.add("One");
        list1.add("Second");
        list1.add("Three");
        //My implement
        MyLinkedList<String> actual = new MyLinkedList<>();
        LinkedList<String> expected = new LinkedList<>();
        String one = "Blink";
        actual.add(one);
        expected.add(one);
        actual.addAll(1,list1);
        expected.addAll(1,list1);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }    
    /*
    addAll(int index, Collection<? extends E> c) index in middle
    */
    @Test
    public void fifteen()
    {
        List <String> list1 = new ArrayList();  
        list1.add("One");
        list1.add("Second");
        list1.add("Three");
        //My implement
        MyLinkedList<String> actual = new MyLinkedList<>();
        LinkedList<String> expected = new LinkedList<>();
        String one = "Blink";
        actual.add(one);
        actual.add(one);
        actual.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        actual.addAll(1,list1);
        expected.addAll(1,list1);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }
    /*
    addAll(int index, Collection<? extends E> c) index in last
    */
    @Test
    public void sixteen()
    {
        List <String> list1 = new ArrayList();  
        list1.add("One");
        list1.add("Second");
        list1.add("Three");
        //My implement
        MyLinkedList<String> actual = new MyLinkedList<>();
        LinkedList<String> expected = new LinkedList<>();
        String one = "Blink";
        actual.add(one);
        actual.add(one);
        actual.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        actual.addAll(2,list1);
        expected.addAll(2,list1);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }
    /*
    removeAll(Collection<?> c)
    */
    @Test
    public void seventeen()
    {
        List <String> list1 = new ArrayList();  
        list1.add("One");
        list1.add("Second");
        list1.add("Three");
        //My implement
        MyLinkedList<String> actual = new MyLinkedList<>();
        LinkedList<String> expected = new LinkedList<>();
        String one = "One";
        String second = "Second";
        String three = "Three";
        actual.add(one);
        actual.add(second);
        actual.add(three);
        expected.add(one);
        expected.add(second);
        expected.add(three);
        actual.removeAll(list1);
        expected.removeAll(list1);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }
    /*
    retainAll(Collection<?> c)
    */
    @Test
    public void eighteen()
    {
        List <String> list1 = new ArrayList();  
        list1.add("One");
        list1.add("Second");
        list1.add("Three");
        //My implement
        MyLinkedList<String> actual = new MyLinkedList<>();
        LinkedList<String> expected = new LinkedList<>();
        String one = "One";
        String second = "Second";
        actual.add(one);
        actual.add(second);
        expected.add(one);
        expected.add(second);
        actual.retainAll(list1);
        expected.retainAll(list1);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }
    /*
    retainAll(Collection<?> c)
    */
    @Test
    public void nineteen()
    {
        List <String> list1 = new ArrayList();  
        list1.add("Three");
        //My implement
        MyLinkedList<String> actual = new MyLinkedList<>();
        LinkedList<String> expected = new LinkedList<>();
        String one = "One";
        String second = "Second";
        actual.add(one);
        actual.add(second);
        expected.add(one);
        expected.add(second);
        actual.retainAll(list1);
        expected.retainAll(list1);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }
    /*
    clear
    */
    @Test
    public void twenty()
    {
        MyLinkedList<String> actual = new MyLinkedList<>();
        LinkedList<String> expected = new LinkedList<>();
        String one = "One";
        String second = "Second";
        actual.add(one);
        actual.add(second);
        expected.add(one);
        expected.add(second);
        actual.clear();
        expected.clear();
        assertArrayEquals(expected.toArray(), actual.toArray());
    }
    /*
    public E set(int index, E element) 
    */
    @Test
    public void twentyOne()
    {
        MyLinkedList<String> actual = new MyLinkedList<>();
        LinkedList<String> expected = new LinkedList<>();
        String one = "One";
        String second = "Second";
        actual.add(one);
        actual.add(second);
        expected.add(one);
        expected.add(second);
        actual.set(0,second);
        expected.set(0, second);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }
    /*
    public E set(int index, E element) 
    */
    @Test
    public void twentyTwo()
    {
        MyLinkedList<String> actual = new MyLinkedList<>();
        LinkedList<String> expected = new LinkedList<>();
        String one = "One";
        String second = "Second";
        actual.add(one);
        actual.add(second);
        expected.add(one);
        expected.add(second);
        actual.set(1, one);
        expected.set(1, one);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }
    /*
    public E set(int index, E element) 
    */
    @Test
    public void twentyThree()
    {
        MyLinkedList<String> actual = new MyLinkedList<>();
        LinkedList<String> expected = new LinkedList<>();
        String one = "One";
        String second = "Second";
        actual.add(one);
        actual.add(second);
        expected.add(one);
        expected.add(second);
        actual.set(1, one);
        expected.set(1, one);
        assertEquals(expected.set(1, one), actual.set(1, one));
    }
    /*
    public E set(int index, E element) 
    */
    @Test
    public void twentyFour()
    {
        MyLinkedList<String> actual = new MyLinkedList<>();
        LinkedList<String> expected = new LinkedList<>();
        String one = "One";
        String second = "Second";
        actual.add(one);
        actual.add(second);
        expected.add(one);
        expected.add(second);
        actual.set(1, one);
        expected.set(1, one);
        assertEquals(expected.set(0, one), actual.set(0, one));
    }
}
