package LinkedList;

public class DoubleLinkedList {

    /**
     * 
     * the While loop is your friend here!!!!
     * 
     * The functions can be done recursively.
     */

    Node mainNode;

    public DoubleLinkedList(){
    }

    // non recursive insertion
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
        Node t = temp.next;
        t.previous = temp; // temp.next.previous = temp

    }


    // recursive insertion
    public void insertValue(int val){

        if (mainNode == null){
            mainNode = new Node(val);
            return;
        }

        mainNode = insertRecursive(val, mainNode);
    }

    public Node insertRecursive(int val, Node n){
        
        if (n == null){
            return new Node(val);
        } 


        Node last = insertRecursive(val, n.next);
        last.previous = n;
        n.next = last;
    
        return n;
    }


    // no recursive removal.
    public void removeValue(int val){

        if (mainNode == null){
            return;
        }
        if (mainNode.value == val){
            mainNode = mainNode.next;
            return;
        }

        Node tmpNode = mainNode;
        while (tmpNode != null){
            if (tmpNode.value == val){
                if (tmpNode.previous != null){
                    tmpNode.previous.next = tmpNode.next;
                }
                if (tmpNode.next != null){
                    tmpNode.next.previous = tmpNode.previous;
                }
            }
            tmpNode = tmpNode.next;
        }
    }

    public void printDoubleLinkedList(){
        Node tmp = mainNode;
        while (tmp != null){
            System.out.println(tmp.value);
            tmp = tmp.next;
        }
    }

    public static void main(String[] args){

        DoubleLinkedList d = new DoubleLinkedList();
        d.insertValue(4);
        // d.insertValue(5);
        // d.insertValue(6);
        // d.insertValue(7);

        d.printDoubleLinkedList();
        System.out.println();

        d.removeValue(6);

        d.printDoubleLinkedList();
        System.out.println();

        d.insertValue(5);
        d.insertValue(6);
        d.insertValue(7);

        d.printDoubleLinkedList();
        System.out.println();

        d.removeValue(6);

        d.printDoubleLinkedList();
        System.out.println();

    }
    
}
