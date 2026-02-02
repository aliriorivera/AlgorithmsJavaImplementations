package micselaneus;

public class Fibonachi {


    public static void main(String[] args){

        // System.out.println(recursiveFibonacy(6));
        System.out.println(fibonaci(7));
        // fibonaci(7);

    }


    public static int recursiveFibonacy(int n){

        if (n == 0){
            return 0;
        }

        if (n == 1){
            return 1;
        }

        int left = recursiveFibonacy(n-1);
        int right = recursiveFibonacy(n-2);


        return left + right;
    }


    // non recursive fibonaci
    public static int fibonaci(int n){
        if (n == 0){
            return 0;
        }

        if (n == 1){
            return 1;
        }

        int a = 0;
        int b = 1;
        int total = 0;
        for (int i = 2; i <= n; i++){
            total = a + b;
            int tmp = a;
            a = b;
            b = tmp + b;
            // System.out.println(total);
        }
        return total;
    }
    
}
