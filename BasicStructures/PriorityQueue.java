package BasicStructures;


/**
 * 
 * Se puede implementar con Heap Max or min,  LinkedList (todas, pero yo creo que es mas facil la circular porque
 * con el last ya tiene el inicio y el final)
 * 
 * tambien es facil con la double linked list porque puede saber el previous y el next y mas con un circular
 * linked list queda muy bueno.
 * 
 * Recordar que el valor que se consulta es la prioridad, y a partir de ese valor es que se colocan o no
 * los valores
 * 
 * otro paso importante es poner la mayor prioridad siempre al principio, con eso cuando se haga el dequeue es O(1) siempre
 * 
 */

public class PriorityQueue {

    static class Node{

        int value;
        int priority;
        Node previous;
        Node Next;

        Node(int value, int priority){
            this.value = value;
            this.priority = priority;
        }
    }

    static Node root;

    public static void main(String[] args){
        enQueue(1, 10);
        enQueue(1, 6);
        enQueue(1, 4);
        enQueue(1, 1);
        enQueue(1, 5);
        enQueue(1, 3);
        enQueue(3, 5);
        enQueue(3, 0);

        dequeue();
        dequeue();
        // dequeue();
        // dequeue();
        // dequeue();


        Node tmp = root;
        while(tmp.Next !=null){
            System.out.println(tmp.priority + "  " + tmp.value);
            tmp = tmp.Next;
        }
        System.out.println(tmp.priority + "  " + tmp.value);

    }
 
    

    // si lo hiciera con single linked list, el previous se tiene que guardar como nodo
    // y simplemente reemplazar todo lo que diga tmp.previous por ese nodo. :)
    public static void enQueue(int value, int priority){

        Node newNode = new Node(value, priority);
        
        if (root == null){
            root = newNode;
            return;
        }

        Node tmp = root;

        while(tmp != null){
            if (tmp.priority < priority){
                if (tmp.previous != null){
                    tmp.previous.Next = newNode;
                }
                newNode.previous = tmp.previous;
                newNode.Next = tmp;
                tmp.previous = newNode;
                return;
            }

            if(tmp.priority == priority){
                if (tmp.Next != null && tmp.Next.priority == priority){
                    tmp = tmp.Next;
                    continue;
                }

                if(tmp.Next != null){
                    tmp.Next.previous = newNode;
                }

                newNode.Next = tmp.Next;
                newNode.previous = tmp;
                tmp.Next = newNode;
                return;
            }
            
            if (tmp.Next == null){
                tmp.Next = newNode;
                newNode.previous = tmp;
                return;
            }

            tmp = tmp.Next;
        }
    }


    public static Node dequeue(){
        if (root == null){
            return root;
        }
        
        Node tmp = root;
        root = root.Next;
        
        return tmp;
    }
}
