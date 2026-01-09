package sortingAlghoritms;


/*
 * Bubble Sort Algorithm
 * 
 * -- Time complexity:
 *          O(n^2) because you will have to iterate from pivot to each value.
 * -- Stable:
 *          YES  -->>  Example [2a, 2b, 1]
 * 
 * The algorithm tries to push the greatest values to the right so, it takes
 * one element and the next to compare. If the first element is bigger than the second
 * one then, they get swapped. the next step is to increase the index and repeat the process
 * it means that it is pushing always the bigger value to the right.
 * 
 * the process finishes when there are no more swaps because it means that all the elements
 * are sorted
 * 
 * 
 * suppose you have a = [5, 4, 3, 2, 1]
 * is a[0] > a[1]? YES so, swap them  [4, 5, 3, 2, 1]
 * is a[1] > a[2]? YES so, swap them  [4, 3, 5, 2, 1]
 * is a[2] > a[3]? YES so, swap them  [4, 3, 2, 5, 1]
 * is a[3] > a[4]? YES so, swap them  [4, 3, 2, 1, 5]
 * 
 * Notice that number 5 starts in index 0 and ends in index 4 in only one cycle
 * as there were swaps, the algorithm repeats the process.
 * 
 * a = [4, 3, 2, 1, 5] 
 * is a[0] > a[1]? YES so, swap them  [3, 4, 2, 1, 5]
 * is a[1] > a[2]? YES so, swap them  [3, 2, 4, 1, 5]
 * is a[2] > a[3]? YES so, swap them  [3, 2, 1, 4, 5]
 * is a[3] > a[4]? NO so, NO swap     [3, 2, 1, 4, 5]
 *  
 * Notice that number 4 starts in index 0 and ends in index 3 in only one cycle
 * as there were swaps, the algorithm repeats the process.
 * 
 * a = [3, 2, 1, 4, 5]
 * is a[0] > a[1]? YES so, swap them  [2, 3, 1, 4, 5]
 * is a[1] > a[2]? YES so, swap them  [2, 1, 3, 4, 5]
 * is a[2] > a[3]? NO so,  NO swap    [2, 1, 3, 4, 5]
 * is a[3] > a[4]? NO so, NO swap     [2, 1, 3, 4, 5]
 * 
 * as there were swaps, the algorithm repeats the process.
 * 
 * a = [2, 1, 3, 4, 5]
 * is a[0] > a[1]? YES so, swap them  [1, 2, 3, 4, 5]
 * is a[1] > a[2]? NO so,  NO swap    [1, 2, 3, 4, 5]
 * is a[2] > a[3]? NO so,  NO swap    [1, 2, 3, 4, 5]
 * is a[3] > a[4]? NO so, NO swap     [1, 2, 3, 4, 5]
 * 
 * as there were swaps, the algorithm repeats the process.
 * 
 * a = [2, 1, 3, 4, 5]
 * is a[0] > a[1]? NO so,  NO swap    [1, 2, 3, 4, 5]
 * is a[1] > a[2]? NO so,  NO swap    [1, 2, 3, 4, 5]
 * is a[2] > a[3]? NO so,  NO swap    [1, 2, 3, 4, 5]
 * is a[3] > a[4]? NO so, NO swap     [1, 2, 3, 4, 5]
 * 
 * 
 * As there were no more swaps it means the array is SORTED.
 * 
 * NOTE: as the algorithm always pushes the greatest value to the right, you can
 * break each loop one clycle less per repetition (see: variable loops line 76)
 */


public class BubbleSort {
    
    static int[] toSort = {1,2,7,8,9,2,1,5,9,9,4,4,2,6,5,8,8,25,2,1,5,6};

    public static void main(String[] args){

        int swaps = 0;
        int loops = 0; // enhanced because we know that every loop puts the greater value to the right
        do{
            swaps = 0;
            for (int i = 0 ; i < toSort.length-1-loops; i++){
                if (toSort[i]> toSort[i+1]){
                    int tmp  = toSort[i];
                    toSort[i] = toSort[i+1];
                    toSort[i+1] = tmp;
                    swaps = 1;
                }
            }
            loops++;
        }while(swaps != 0);


        System.out.println();

        for (int i = 0 ; i < toSort.length ; i++){
            System.out.print(toSort[i] + ", ");
        }

        System.out.println();
    }
}
