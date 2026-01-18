package Trees;

/**
 * recordar que siempre que es un arbol o una estructura que se divida en dos, 
 * van a hacerse dos llamadas a funciones en la misma funcion, una a derecha y otra a 
 * izquierda.
 * 
 * lo importante es comprobar los casos en los leafs que pasa si envio un nodo
 * nulo, en este caso devuelvo sin adicionar uno al valor de la altura.
 * 
 */

public class HeightOfTree {

    static Tree a;
    public static void main(String[] args){
        a = new Tree();
        // a.insertToTree(null, 0);

        Node cc = new Node(100);


        cc = a.insertToTree(cc, 50);
        cc = a.insertToTree(cc, 2000);
        cc = a.insertToTree(cc, 20);
        cc = a.insertToTree(cc, 60);
        cc = a.insertToTree(cc, 1000);
        cc = a.insertToTree(cc, 5000);
        cc = a.insertToTree(cc, 19);
        cc = a.insertToTree(cc, 18);
        cc = a.insertToTree(cc, 17);
        cc = a.insertToTree(cc, 54);
        cc = a.insertToTree(cc, 70);
        cc = a.insertToTree(cc, 71);
        cc = a.insertToTree(cc, 72);
        cc = a.insertToTree(cc, 73);
        cc = a.insertToTree(cc,74);
        cc = a.insertToTree(cc, 75);
        cc = a.insertToTree(cc, 76);
        cc = a.insertToTree(cc, 77);

        int f = height(cc, 0);

        System.out.println(f);
    }

    public static int height(Node b, int lastheight){

        if(b == null){
            return lastheight;
        }

        lastheight++;

        int leftH = height(b.left, lastheight);
        int rightH = height(b.right, lastheight);

        if (leftH < rightH){
            return rightH;
        }

        return leftH;

    }
    
}
