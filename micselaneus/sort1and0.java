package micselaneus;

/**
 * 
 * poner los zeros al lado izquierdo y los 1 a la derecha
 * se basa en tener un indice que indica donde esta el primer 1 y asi cada
 * vez que se encuentre un zero se cambia con ese indice y se suma uno mas
 * al indice.
 * 
 * como siempre sabemos que despues de ese indice hay al menos otro 1 entonces
 * se puede hacer eso.
 * 
 * 
 */
public class sort1and0 {

    public static void main(String[] arrgs){

        int[] arreglo = new int[]{1,0,0,0,1,1,1,0,1,1,1,0};

        int firstOneToupdate = -1;

        for (int i = 0 ; i < arreglo.length ; i++){
            if (arreglo[i] == 1 && firstOneToupdate == -1){
                firstOneToupdate = i;
            }

            if (arreglo[i] == 0){
                if (firstOneToupdate == -1){
                    continue;
                }
                arreglo[firstOneToupdate] = 0;
                arreglo[i] = 1;
                firstOneToupdate++;
            }
        }

        for (int i = 0 ; i < arreglo.length ; i++){
            System.out.println(arreglo[i]);
        }

    }
    
}
