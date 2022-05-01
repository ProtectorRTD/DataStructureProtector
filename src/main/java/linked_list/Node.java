package linked_list;
public class Node <E>
{
    private E element;
    private Node<E> next;

    public Node(E element) 
    {
        this.element = element;
        this.next = null;
    }     
    public void setNextNode(Node<E> node) 
    {
        this.next = node;
    }
    public Node<E> getNextNode() 
    {
        return this.next;
    }
    public E getData()
    {
        return element;
    }
    public Class<? extends Object> getGenerics()
    {
        return element.getClass();
    }
}
