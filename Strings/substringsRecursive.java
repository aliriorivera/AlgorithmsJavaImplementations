package Strings;


/**
 * Este se basa en el hecho de que para sacar todos los substrings,
 * se llega hasta el final de la ultima letra y los 
 * substring que se devuelven son los que se unen a la primera letra que  
 * tenia el ciclo antes.
 * 
 *  ejemplo a b c
 *  
 * 
 * la funcion coje a como base y envia al recursivo b c
 * la funcion coje b como base y envia al recursivo c
 * la funcion recursiva devuelve el c ya que el length es 1
 * la funcion que llamo toma ese c y lo mezcla con la base, retorna b, bc
 * la funcion que llamo toma ese b, bc y lo mezcla con la base, retorna a, ab, abc
 * 
 * Aqui toca imprimir el resultado antes de devolverlo en cada paso, ya que sino la
 * impresion final solo va a tener a, ab, abc  OJO!!!!!
 *  
 *  
 * 
 */
public class substringsRecursive {

    public static void main(String[] args){

        getSubstrings("abcde".toCharArray());

    }



    public static String[] getSubstrings(char[] letters){
        int lenOfLetters = letters.length;
        if (lenOfLetters == 1){
            System.out.println(String.valueOf(letters[0]));
            String[] a = {String.valueOf(letters[0])};
            return a;
        }

        char[] newForSubstring = new char[lenOfLetters - 1];
        for (int i = 1; i < lenOfLetters; i++ ){    
            newForSubstring[i-1] = letters[i];
        }

        // System.out.println(newForSubstring);

        String[] resultSubs = getSubstrings(newForSubstring);
        String[] resultTotal = new String[resultSubs.length + 1];
        resultTotal[0] = String.valueOf(letters[0]);
        for (int j = 1; j <= resultSubs.length; j++){
            resultTotal[j] = resultTotal[0]+resultSubs[j-1];
        }

        for (int h = 0 ; h < resultTotal.length ; h++){
            System.out.println(resultTotal[h]);
        }
        return resultTotal;

    }
}
