package Strings;

/**
 * 
 * se basa en 3 for loops, el primero para iterar sobre la letra que cambia,
 * el segundo for para iterar desde 0 hasta el largo del arreglo
 * y el tercer for para imprimir del arreglo desde el valor actual del loop1 
 * hasta el valor actual del loop2
 * 
 * ejemplo 
 * 
 * abcd
 * 
 * el primer for va a iterar i-0 >> i=3  (a b c d)
 * a
 * ab
 * abc
 * abcd
 * 
 * el segundo for va de j = i >> j = 3
 * el tercer for va de h = i >> h = j
 * b
 * bc
 * bcd
 * 
 * c
 * cd
 * 
 * d
 * 
 */
public class substringsWithForLoop {

    public static void main(String[] args){

        String a = "abcde";
        char[] letters = a.toCharArray();

        for (int i = 0 ; i< a.length() ; i++){
            for (int j = i; j < a.length() ; j++){
                for (int h = i ; h <= j ; h++){
                    System.out.print(letters[h]);
                }
                System.out.println();

            }
            // System.out.println();
            // System.out.println("*****");

        }

    }
    
}
