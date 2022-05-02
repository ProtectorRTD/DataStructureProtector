import linked_list.MyLinkedList;

import java.util.LinkedList;

public class Main
{
    public static void main(String[] args) throws Exception {
        String word_v1 = "Zero";
        String word_v2 = "Two";
        String word_v3 = "Three";
        String word_finall = "Four";
        //Java classic Linked List
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(word_v1);
        linkedList.add(word_v2);
        linkedList.add(word_v3);

        //My implement
        MyLinkedList<String> mylist = new MyLinkedList<>();
        mylist.add(word_v1);
        mylist.add(word_v2);
        mylist.add(word_v3);

        mylist.set(2, "Bda bda");
        for(int i = 0; i < mylist.size(); i++){
            System.out.println("Data - "+ mylist.get(i));
        }
        System.out.println("");
    }
}
