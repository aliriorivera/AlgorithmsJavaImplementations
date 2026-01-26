package main;

import LinkedList.Node;

public class TestLinkedList {


    Node root;

    public static void main(String[] args){

        TestLinkedList l = new TestLinkedList();
        l.push(4);
        l.push(2);
        l.push(6);
        l.push(8);
        l.push(1);
        l.push(0);
        l.push(1);
        l.push(5);

        l.printLinkedList();

        System.out.println("");

        l.pop(1);

        l.printLinkedList();
        

    }
    

    public TestLinkedList(){
        root = null;
    }

    public void push(int value){
        if (root == null){
            root  = new Node(value);
            return;
        }

        Node temp = root;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(value);
    }

    public void pop(int value){
        if (root == null){
            return;
        }

        if (root.value == value){
            root = root.next;
            return;
        }


        Node temp = root;
        while(temp.next != null){
            if(temp.next.value == value){
                temp.next = temp.next.next;
                // return; // leave it if you want to search only one.
            }
            temp = temp.next;
        }
    }

    public void printLinkedList(){
        Node temp = root;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

}
