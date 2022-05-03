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
        Collection<String> collection = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            actual.add(Integer.toString(i));
            expected.add(Integer.toString(i));
            collection.add(Integer.toString(i));
        }
        actual.addAll(0, collection);
        expected.addAll(0, collection);
        System.out.println("");
    }
}
