import linked_list.MyLinkedList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Main
{
    public static void main(String[] args) throws Exception {
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
        System.out.println("");
    }
}
