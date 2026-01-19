package Trees;


/**
 * La clave en la impresion del level order es que primero se calcula la altura del arbol
 * y despues esa altura se itera de tal forma que se tiene cuantos niveles se requieren
 * 
 * despues se envia esa altura a una funcion que la va a decrecer al medida que avanza 
 * hacia abajo en el arbol. de tal forma que cuando eso sea == 0 significa que ya 
 * hemos llegado al nivel que se quiere imprimir.
 * 
 * los demas traversal son simplemente cambiando la posicion de las funciones.
 *  
 * Inorder (Depth First Traversal as in graphs)
 * LEFT ROOT RIGHT
 * 
 * Preorder (Depth First Traversal as in graphs)
 * ROOT LEFT RIGHT
 * 
 * postorder (Depth First Traversal as in graphs)
 * LEFT RIGHT ROOT
 * 
 * Level Order  (Breadth First Traversal as in graphs)
 * print by level
 * 
 * 
 */
public class TraverseTree {
    

    public static void main(String[] args){

        Tree t = new Tree();
        Node a = new Node(4);


        a = t.insertToTree(a, 6);
        
        a = t.insertToTree(a, 1);
        a = t.insertToTree(a, 3);
        a = t.insertToTree(a, 2);
        a = t.insertToTree(a, 7);
        a = t.insertToTree(a, 9);
        a = t.insertToTree(a, 5);


        // a = remove(a, 4);
        System.out.println("");

        levelOrder(a);
    }

    static void levelOrder(Node c){
        //calculate height

        HeightOfTree h = new HeightOfTree();
        int hh = h.height(c,0);

        for (int i = 1 ; i <= hh ; i++){
            printLevelStop(c, i);
        }
    }

    static void printLevelStop(Node n, int level){
        if (n == null){
            return;
        }

        level--;

        if (level == 0){
            System.out.println(n.data);
            return;

        }

        printLevelStop(n.left, level);
        printLevelStop(n.right, level);

        return;
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
