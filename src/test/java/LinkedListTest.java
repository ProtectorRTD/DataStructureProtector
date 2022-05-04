import linked_list.MyLinkedList;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class LinkedListTest {
    /*
    Check void add(int index, Object o)
    Insert in middle of linked list
    */

    private MyLinkedList<String> myLinkedList;
    private LinkedList<String> linkedList;


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
    Check void add(int index, Object o)
    Exception()
    */
    @Test (expectedExceptions = IndexOutOfBoundsException.class)
    public void firstException() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add(5, "Da");
    }
    @Test
    public void addObjects(){
        MyLinkedList<String> actual = new MyLinkedList<>();
        LinkedList<String> expected = new LinkedList<>();
        for(int i = 0; i < 300000; i++){
            actual.add(Integer.toString(i));
            expected.add(Integer.toString(i));
        }
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
    /*
    addAll(int index = 0)
    */
    @Test
    public void addAllTestIndexZero() {
        MyLinkedList<String> actual = new MyLinkedList<>();
        LinkedList<String> expected = new LinkedList<>();
        Collection<String> collection = new ArrayList<>();
        for (int i = 0; i < 300000; i++) {
            actual.add(Integer.toString(i));
            expected.add(Integer.toString(i));
            collection.add(Integer.toString(i));
        }
        actual.addAll(0, collection);
        expected.addAll(0, collection);
        Assert.assertArrayEquals(expected.toArray(),actual.toArray());
    }
    /*
    addAll(int index = 5) - middle
    */
    @Test
    public void addAllTestIndexInMiddle() {
        MyLinkedList<String> actual = new MyLinkedList<>();
        LinkedList<String> expected = new LinkedList<>();
        Collection<String> collection = new ArrayList<>();
        for (int i = 0; i < 300000; i++) {
            actual.add(Integer.toString(i));
            expected.add(Integer.toString(i));
            collection.add(Integer.toString(i));
        }
        actual.addAll(5, collection);
        expected.addAll(5, collection);
        Assert.assertArrayEquals(expected.toArray(),actual.toArray());
    }
    /*
    addAll(int index = 5) - end
    */
    @Test
    public void addAllTestIndexInEnd() {
        MyLinkedList<String> actual = new MyLinkedList<>();
        LinkedList<String> expected = new LinkedList<>();
        Collection<String> collection = new ArrayList<>();
        for (int i = 0; i < 300000; i++) {
            actual.add(Integer.toString(i));
            expected.add(Integer.toString(i));
            collection.add(Integer.toString(i));
        }
        actual.addAll(300000, collection);
        expected.addAll(300000, collection);
        Assert.assertArrayEquals(expected.toArray(),actual.toArray());
    }
    /*
    addAll no index
    */
    @Test
    public void addAllTestWithoutIndex() {
        MyLinkedList<String> actual = new MyLinkedList<>();
        LinkedList<String> expected = new LinkedList<>();
        Collection<String> collection = new ArrayList<>();
        for (int i = 0; i < 300000; i++) {
            actual.add(Integer.toString(i));
            expected.add(Integer.toString(i));
            collection.add(Integer.toString(i));
        }
        actual.addAll( collection);
        expected.addAll( collection);
        Assert.assertArrayEquals(expected.toArray(),actual.toArray());
    }
    /*
    сlear
    */
    @Test
    public void clearTest()
    {
        MyLinkedList<String> actual = new MyLinkedList<>();
        LinkedList<String> expected = new LinkedList<>();
        Collection<String> collection = new ArrayList<>();
        for (int i = 0; i < 30000; i++) {
            actual.add(Integer.toString(i));
            expected.add(Integer.toString(i));
            collection.add(Integer.toString(i));
        }
        actual.addAll( collection);
        expected.addAll( collection);
        actual.clear();
        expected.clear();
        Assert.assertArrayEquals(expected.toArray(),actual.toArray());
    }


    /*
    Check int indexOf(Object o)
    If dont have object in the list
    */
    @Test
    public void TestIndexOfDontHaveObject()
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
    public void LastIndexOf()
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
    public void getFirstIndex()
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
    public void getLastindex()
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
    public void subList()
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
    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void subListException()
    {
        String word_v1 = "Zero";
        //My implement
        MyLinkedList<String> mylist = new MyLinkedList<>();
        mylist.add(word_v1);
        mylist.add(word_v1);
        mylist.add(word_v1);
        mylist.add(word_v1);
        List<String> actual =  mylist.subList(0, 5);
    }
    /*
    Check containsAll(Collection<?> c)
    */
    @Test
    public void containsAll()
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
    public void addAll()
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
    public void addAllIndex()
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
    public void addAllMiddle()
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
    public void addAllLast()
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
    public void removeAll()
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
    public void retainAll()
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
    public void retainAllSecond()
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
    public E set(int index, E element) 
    */
    @Test
    public void setTest()
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
    public void setInMiddle()
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
    public void setTests()
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
    public void setChecker()
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

    @Test
    public void addFirstTest(){
        MyLinkedList<String> actual = new MyLinkedList<>();
        LinkedList<String> expected = new LinkedList<>();
        String one = "One";
        String second = "Second";
        String blablabla = "Blablabla";
        actual.add(one);
        actual.add(second);
        expected.add(one);
        expected.add(second);
        actual.addFirst(blablabla);
        expected.addFirst(blablabla);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void addFirstSecondTest(){
        MyLinkedList<String> actual = new MyLinkedList<>();
        LinkedList<String> expected = new LinkedList<>();
        String one = "One";
        String second = "Second";
        String blablabla = "Blablabla";
        actual.add(one);
        actual.add(second);
        expected.add(one);
        expected.add(second);
        actual.addFirst(blablabla);
        expected.addFirst(blablabla);
        Collection<String> collection = new ArrayList<>();
        for (int i = 0; i < 30000; i++) {
            actual.add(Integer.toString(i));
            expected.add(Integer.toString(i));
            collection.add(Integer.toString(i));
        }
        actual.addAll(collection);
        expected.addAll(collection);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void addLastTest(){
        MyLinkedList<String> actual = new MyLinkedList<>();
        LinkedList<String> expected = new LinkedList<>();
        String one = "One";
        String second = "Second";
        String blablabla = "Blablabla";
        actual.add(one);
        actual.add(second);
        expected.add(one);
        expected.add(second);
        actual.addLast(blablabla);
        expected.addLast(blablabla);
        Collection<String> collection = new ArrayList<>();
        for (int i = 0; i < 30000; i++) {
            actual.add(Integer.toString(i));
            expected.add(Integer.toString(i));
            collection.add(Integer.toString(i));
        }
        actual.addAll(collection);
        expected.addAll(collection);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void pollLastTest(){
        MyLinkedList<String> actual = new MyLinkedList<>();
        LinkedList<String> expected = new LinkedList<>();
        String one = "One";
        String second = "Second";
        String blablabla = "Blablabla";
        actual.add(one);
        actual.add(second);
        expected.add(one);
        expected.add(second);
        actual.addLast(blablabla);
        expected.addLast(blablabla);
        actual.pollLast();
        expected.pollLast();
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void removeLastOccurrence(){
        MyLinkedList<String> actual = new MyLinkedList<>();
        LinkedList<String> expected = new LinkedList<>();
        String one = "One";
        String second = "Second";
        String blablabla = "Blablabla";
        actual.add(one);
        actual.add(second);
        expected.add(one);
        expected.add(second);
        actual.addLast(blablabla);
        expected.addLast(blablabla);
        actual.addLast(blablabla);
        expected.addLast(blablabla);
        actual.addLast(blablabla);
        expected.addLast(blablabla);
        actual.removeLastOccurrence(blablabla);
        expected.removeLastOccurrence(blablabla);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    private void fillList1(){
        myLinkedList = new MyLinkedList<>();
        linkedList = new LinkedList<>();

        myLinkedList.add("Hello");
        linkedList.add("Hello");
    }

    private void fillList2(){
        myLinkedList = new MyLinkedList<>();
        linkedList = new LinkedList<>();

        myLinkedList.add("Hello1");
        myLinkedList.add("Hello2");
        myLinkedList.add(1, "Hello3");
        myLinkedList.add(3, "Hello4");

        linkedList.add("Hello1");
        linkedList.add("Hello2");
        linkedList.add(1, "Hello3");
        linkedList.add(3, "Hello4");
    }

    @Test
    public void remove_1(){
        fillList1();
        myLinkedList.remove("Hello");
        linkedList.remove("Hello");

        assertArrayEquals(linkedList.toArray(), myLinkedList.toArray());
    }

    @Test
    public void remove_2(){
        fillList2();
        myLinkedList.remove("Hello1");
        linkedList.remove("Hello1");

        assertArrayEquals(linkedList.toArray(), myLinkedList.toArray());
    }

    @Test
    public void remove_3(){
        fillList2();
        myLinkedList.remove("Hello4");
        linkedList.remove("Hello4");

        assertArrayEquals(linkedList.toArray(), myLinkedList.toArray());
    }

    @Test
    public void remove_4(){
        fillList2();
        myLinkedList.remove("Hello1");
        linkedList.remove("Hello1");
        myLinkedList.remove("Hello3");
        linkedList.remove("Hello3");

        assertArrayEquals(linkedList.toArray(), myLinkedList.toArray());
    }

    @Test
    public void remove_5(){
        fillList1();
        myLinkedList.remove("Hello5");
        linkedList.remove("Hello5");

        assertArrayEquals(linkedList.toArray(), myLinkedList.toArray());
    }

    @Test
    public void remove_6(){
        linkedList = new LinkedList<>();
        myLinkedList = new MyLinkedList<>();

        linkedList.remove("Hello1");
        myLinkedList.remove("Hello1");
    }
}
