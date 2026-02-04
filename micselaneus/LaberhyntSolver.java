package micselaneus;

import BasicStructures.*;

/**
 * 
 * La clave esta en el uso de una pila para mantener el camino que se esta recorriendo
 * 
 * (1) primero se adiciona el vertice a la pila y a la lista de visitados
 * 
 * despues se comprueba si el vertice es igual al nodo al que se quiere llegar.
 * Si es igual entonces se retorna un true para acabar con todo los ciclos.
 * 
 * si no, entonces se hace un for para iterar sobre los hijos
 * solo se entra al ciclo especifico del for para el hijo, si el hijo no ha sido visitado
 * en el ciclo se llama de nuevo la funcion en recursividad, enviando el hijo como argumento
 * 
 * con esto se inciara de nuevo (1)
 * 
 * llegara un punto en que o retorna true o no tiene mas hijos para iterar,
 * en este ultimo se retorna false despues del for, indicando que no hay mas que hacer
 * en esa rama
 * 
 * la funcion recibe lo que retorna y si es false, hace un pop para quitar el nodo que ya se 
 * recorrio y que no es el buscado
 * y despues hace un continue para seguir con los otros hijos
 * 
 * si se recibio un true entonces inmediatamente se retorna true para finalizar con todos los ciclos
 * 
 * 
 * y al final, el camino se encuentra en la pila pero al revez jejejeje
 * 
 * 
 *  el problema de este metodo es que es de fuerza bruta y el camino que se encuentre puede que no sea 
 * el mas optimo significa que dependiendo del orden de los hijos en la iteracion, puede coger el camino 
 * mas largo
 * ej : 1 2 3 4 5 6 pero hay otro camino 1 2 8 6
 * 
 * 
 */

public class LaberhyntSolver {

    static int[][] laberynth;
    static Stack stack;
    static int[] visitedNodes;

    public static void main(String[] args){


        laberynth = new int[][]{
            {0,1,1,0,0,0,0,0,0,0},
            {1,0,1,1,1,0,0,0,0,0},
            {1,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,0,1,0,0,0,0},
            {0,1,0,0,0,0,0,0,0,0},
            {0,0,0,1,0,0,1,1,1,0},
            {0,0,0,0,0,1,0,0,0,0},
            {0,0,0,0,0,1,0,0,1,0},
            {0,0,0,0,0,1,0,1,0,1},
            {0,0,0,0,0,0,0,0,1,0}};

        visitedNodes = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        stack = new Stack();
        boolean solvable = solver(0,9);

        if (solvable == false){
            System.out.println("There is no path");
            return;
        }

        while(stack.isEmpty() == false){
            System.out.println(stack.pop());
        }


    }


    static boolean solver(int vertex, int endVertex){

        stack.push(vertex);
        addToVisitedNodes(vertex);

        if (vertex == endVertex){
            return true;
        }

        for(int i = 0 ; i < laberynth[vertex].length; i++){
            if(laberynth[vertex][i] == 1 && wasVisited(i) == false){

                boolean val = solver(i, endVertex);
                if (val == false){
                    stack.pop();
                    continue;
                }
                return true;
            }
        }

        return false;
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

    
}
