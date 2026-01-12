package Trees;


/**
 * 
 * La clave de este, es entender los casos de cada uno, sobretodo en remover un nodo,
 * en el codigo hay comentarios (sobretodo hay uno grande) que explica los casos
 * 
 * para eliminar un nodo, este puede estar con uno, dos o ningun nodo a su izquierda o
 * derecha
 * 
 * recordar que para eliminar un nodo que tenga dos hijos, se atraviesa el subarbol que
 * se forma al ir a un lado o al otro. Dependiendo de que lado se tome, recordar que
 * 
 * si se toma el arbol a la izquierda, entonces se debe buscar el nodo mas lejano a 
 * la derecha y ese nodo se intercambia con el que se va a borrar y se cambian sus 
 * referencias a derecha e izquierda
 * 
 * Si se toma el arbol de la derecha, entonces se debe buscar el nodo mas lejano a la 
 * izquierda y es enodo se intercambia con el que se va a borrar y se cambian sus 
 * referencias a derecha e izquierda
 * 
 * nuestro amigo aqui es el node.next.next porque nos permite saber que sucede dos nodos 
 * despues y de esta forma del node.next tendremos el siguiente y tambien el anterior que 
 * seria el nodo actual. Esta informacion es supervaliosa para cambiar las referencias.
 * 
 */

public class Tree {


    public static void main(String[] args){

        Node a = new Node(4);


        a = insertToTree(a, 6);
        
        a = insertToTree(a, 1);
        a = insertToTree(a, 3);
        a = insertToTree(a, 2);
        a = insertToTree(a, 7);
        a = insertToTree(a, 9);
        a = insertToTree(a, 5);


        // a = remove(a, 4);
        System.out.println("");

        preOrderTraversal(a);
    }

    static Node insertToTree(Node node, int value){

        if (value < node.data){
            if (node.left == null){
                node.left = new Node(value);
                return node;
            }
            node.left = insertToTree(node.left, value);
        }


        if (value > node.data){
            if (value > node.data){
                if (node.right == null){
                    node.right = new Node (value);
                }
            }
            node.right = insertToTree(node.right, value);
        }
    
        return node;
    }

    static Node remove(Node n, int val){
        
        if(n.data == val){
            // case 1:  no children
            if (n.left == null && n.right == null){
                return null;
            }else if(n.left != null && n.right == null){ //case 2: only one children on the left
                return n.left;
            }else if (n.left == null && n.right != null){ // case 3: only one child on the right 
                return n.right;
            }
            //case 4: children on left and right

            /**
             * two options (use one of them):
             * 1. traverse the left subtree always analysing only the rigth branches
             *      and find the greatest value node (the one with no right child)
             *      the value does not matter because being the most right branch   
             *      means the greatest
             * 2. traverse the right subtree always analysing only the left branches. 
             *      and find the lowest value node (the one with no left child)
             *      the value does not matter because being the most left branch   
             *      means the lowest
             */

            // // searching using case 1
            // if (n.left.right == null){
            //     Node tmpNode = n.left;
            //     n.left = n.left.left;
            //     n.data = tmpNode.data;
            //     return n;
            // }

            // Node tmpNode = n.left;

            // while(tmpNode.right.right != null){
            //     tmpNode = tmpNode.right;
            // }

            // n.data = tmpNode.right.data;

            // tmpNode.right = tmpNode.right.left;
            // finish using case 1

            // also can be used case 2

            if (n.right.left == null){
                Node tmpNode = n.right;
                tmpNode.left = n.left;
                n = tmpNode;
                return n;
            }
            
            Node tmpNode = n.right;

            while (tmpNode.left.left != null){
                tmpNode = tmpNode.left;
            }
            
            n.data = tmpNode.left.data;

            tmpNode.left = tmpNode.left.right;

            // end case 2


            return n;
        }

        if (n.data > val && n.left != null){
            n.left = remove(n.left, val);
        }else if (n.right != null){
            n.right = remove(n.right, val);
        }

        return n;
    }

    // LEFT ROOT RIGHT
    static void inOrderTraversal(Node n){
        if (n == null){
            return;
        }
        inOrderTraversal(n.left);
        System.out.println(n.data);
        inOrderTraversal(n.right);
    }


    // ROOT LEFT RIGHT
    static void preOrderTraversal(Node n){
        if (n == null){
            return;

        }
        System.out.println(n.data);
        preOrderTraversal(n.left);
        preOrderTraversal(n.right);
    }

    // LEFT RIGHT ROOT
    static void postOrderTraaversal(Node n){
        if (n == null){
            return;
        }
        postOrderTraaversal(n.left);
        postOrderTraaversal(n.right);
        System.out.println(n.data);
    }

}
