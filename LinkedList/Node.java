package LinkedList;

public class Node {

    public Node previous;
    public int value;
    public Node next;

    public Node(int val){
        next =  null;
        value = val;
        previous = null;
    }
}
