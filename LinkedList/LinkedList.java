package LinkedList;

public class LinkedList {
    
    Node mainNode;

    public LinkedList(){
        mainNode = null;
    }


    // this can be done without recursion using a while loop
    // a = node.next
    // while a != null
    //      a = a.next
    // a.next =   new Node(val);
    // return;
    public void insert(int val){
        if (mainNode == null){
            mainNode = new Node(val);
            return;
        }
        mainNode.next = insertLocal(mainNode.next, val);
    }

    private Node insertLocal(Node l, int val){
        if (l == null){
            return new Node(val);
        }

        l.next = insertLocal(l.next, val);

        return l;
    }

    // no recursion
    // the key for this insertion is to create a temporal node to hold the main values.
    public void insertattail(int val){
       
        if (mainNode == null) {
            mainNode = new Node(val);
            return;
        }
        Node temp = mainNode;  
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(val);
    }


    public void print(){
        if (mainNode == null){
            System.out.println("LINKED LIST EMPTY");
            return;
        }

        printLocal(mainNode);
    }

    private void printLocal(Node n){
        if (n == null){
            return;
        }
        System.out.println(n.value);
        printLocal(n.next);
    }

    public void remove(int val){
        if (mainNode == null){
            return;
        }
        mainNode = removeLocal(mainNode, val);
    }

    private Node removeLocal(Node n, int val){
        if (n == null){
            return n;
        }
        if (n.value == val){
            return n.next;
        }

        n.next = removeLocal(n.next, val);

        return n;
    }


    public static void main(String[] args){

        LinkedList a = new LinkedList();
        a.insert(3);
        a.insert(5);
        a.insert(6);
        a.insert(1);
        a.insert(4);
        a.insert(10);
        a.insert(77);
        a.print();

        a.remove(6);

        
    }
    
}
