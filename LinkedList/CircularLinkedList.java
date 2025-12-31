package LinkedList;

/**
 * the key in this structure is to use a node as a pointer to the last element 
 * (basically is the same element)
 * that is done because keeping it as pointer, will avoid that in every insertion we have 
 * to traverse the whole list up to the last element to point its next element to 
 * the newly created.
 * 
 * it does not need to be at head:
 * 
 * insert a then a.next = a
 * insert b then a.next  = b, and b. next  = a
 * insert c then a.next = b , and b.next = c, and c.next = a
 * 
 * to remove an element the idea is to check the next element value so, you can have in the
 * same loop, the current node, the next node and the next next node 
 * with that information you can remove nodes.
 * 
 * it is better with double linked list because you can know the prev and next node
 * in all nodes so, it is easy and quick to remove nodes.
 * 
 */

public class CircularLinkedList {

    
    Node lastNode;

    public CircularLinkedList(){

    }

    public void insertAtHead(int val){

        if (lastNode == null){
            lastNode = new Node(val);
            lastNode.next = lastNode;
            return;
        }

        Node tmpNode = new Node(val);
        tmpNode.next = lastNode.next;
        lastNode.next = tmpNode;
    }

    public void removeAtHead(int val){
        if (lastNode == null){
            return;
        }

        Node currNode = lastNode;

        // it means there is only one node
        if (currNode.next == lastNode){
            if (currNode.value == val){
                lastNode = null;
            }
            return;
        }


        // iterate over the next element of lastNode to check if the next value
        // is the one you are looking for. so you know the prev and the next
        while (currNode.next != lastNode){// only until one before the lastNode.
            if (currNode.next.value != val){
                currNode = currNode.next;
            }else{
                break;
            }
        } 


        if (currNode.next.value == val){
            if (currNode.next == lastNode){// the next node is the last so it needs to be updated
                lastNode = currNode;
            }
            currNode.next = currNode.next.next;
        }

    }


    public static void main(String[] args){

        CircularLinkedList c = new CircularLinkedList();

        c.insertAtHead(9);
        c.insertAtHead(3);
        c.insertAtHead(2);
        c.insertAtHead(8);

        c.removeAtHead(3);

    }
    
}
