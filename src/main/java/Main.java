import java.rmi.server.RemoteServer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import LinkedList.MyLinkedList;

public class Main
{
    public static void main(String[] args) throws Exception {
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
        for(int i = 0; i < actual.size(); i++){
            System.out.println(actual.get(0));            
        }
        System.out.println("|||||" + expected.toString());
    }
}
