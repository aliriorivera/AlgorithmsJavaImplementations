package main;

public class TestA{

    public static void main(String[] args) {
        // System.out.println("Hola Mundo......");
        // TestB b = new TestB();
        // System.out.println(b.testeo());


        // double tt = 333e3d;
        // System.out.println(55 + "aaaa");

        // {
        //     System.out.println("teste");
        // }

        int[] input = new int[]{3,3};
        int[] values = twoSum(input, 6);

            System.out.print("* " + values[0] + " --- " + values[1] + " *");
        

    }


    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0 ; i < nums.length-1; i++){
            for (int j = i+1; j< nums.length ; j++ ){
                if (nums[i] + nums[j] == target){
                    result = new int[]{i, j};
                    return result;
                }
            }
        }

        return result;
    }
}
