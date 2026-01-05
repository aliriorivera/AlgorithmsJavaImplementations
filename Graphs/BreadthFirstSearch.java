package Graphs;

import BasicStructures.Queue;


/**
 * BFS - cola
 * 
 * Este algoritmo es basicamente listar inorder (left root right) una estructura
 * esta basado en una cola que mantiene los nodos que son hijos de los root.
 * ademas hay un arreglo que mantiene los nodos que ya han sido visitados.
 * 
 * 
 * se inicia con un vertice y se mete a la Cola y a la lista de visitados
 * 
 * despues se itera la cola hasta que quede vacia, momento en el cual el algoritmo se termina.
 * {
 *  dentro de la iteracion primero se saca el elemento de la cola (dequeue) y ese se pone de 
 *  referencia para saber cuales son los hijos.
 * 
 *  si los hijos no han sido visitados (osea que no estan en la lista de visitados, aka arreglo),
 *  entonces se meten a la cola (enqueue) y a la lista de visitados
 * 
 * si algunos de ellos ya ha sido visitado, o los dos, entonces se continua con la iteracion
 *
 * }
 * 
 * 
 * el inorder estara en la lista de visitados..
 * 
 * este algoritmo lista de nivel en nivel
 * https://www.linkedin.com/pulse/comparison-breadth-first-search-depth-first-methods-uses-liu-ud4ce
 * 
 * 
 * esta es la mejor forma de atravezar un arbol por niveles!!!!!
 * esto lo pueden preguntar en una prueba o entrevista... simpre pensar en filas!!
 * 
 */

public class BreadthFirstSearch {

    static int[] visitedNodes;
    static int[][] matrix;
    static Queue q;

    public static void main(String[] args){

        matrix = new int[][]{{0,1,1,0},{0,0,1,0},{1,0,0,1},{0,0,0,1}};
        visitedNodes = new int[]{-1,-1,-1,-1};
        q = new Queue(4);

        BFS(2);

        for (int i = 0; i < visitedNodes.length; i++){
            System.out.println(visitedNodes[i]);
        }

    }

    public static boolean wasVisited(int vertex){
        for (int i = 0; i < visitedNodes.length; i++){
            if(visitedNodes[i]==vertex){
                return true;
            }
        }
        return false;
    }

    public static void addToVisitedNodes(int vertex){
        for (int i = 0; i < visitedNodes.length; i++){
            if(visitedNodes[i]==-1){
                visitedNodes[i] = vertex;
                return;
            }
        }
    }

    public static void BFS(int vertex){
        

        q.enqueue(vertex);
        addToVisitedNodes(vertex);

        while(!q.isNull()){
            vertex = q.dequeue();            
            for(int j = 0 ; j < 4 ; j++){
                if (matrix[vertex][j] == 1 && !wasVisited(j)){
                    q.enqueue(j);
                    addToVisitedNodes(j);
                }
            }
        }
    }
}
