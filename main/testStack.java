package main;

public class testStack {


    private int[] values;
    private int pointer;

    public static void main(String[] args){

        testStack s = new testStack(6);
        s.addToStack(10);
        s.addToStack(12);
        s.addToStack(20);


        s.pop();
        s.printStack();
        s.addToStack(40);

        s.printStack();


    }

    public testStack(int stackLength){
        pointer = -1;
        values = new int[stackLength];
    }

    
    public void addToStack(int value){

        if (pointer+2 > values.length){
            return;
        }

        pointer++;
        values[pointer] = value;
    }

    public int pop(){
        if (pointer > -1) {
            int valueReturn = values[pointer];
            pointer--;
            return valueReturn;
        }
        return -1;
    }

    public int stackLength(){
        if (pointer == -1){
            return 0;
        }
        return pointer;
    }

    public void printStack(){
        for (int i = 0 ; i <= pointer; i++){
            System.out.println(values[i]);
        }
    }
}
