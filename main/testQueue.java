package main;

public class testQueue {
    

    private int in;
    private int out;
    private int[] queue;
    private int maxSize;


    public static void main(String[] args){
        testQueue a = new testQueue(4);

        a.addToQueue(2);
        a.addToQueue(4);
        a.addToQueue(3);
        a.addToQueue(6);

        a.dequeue();

        a.printQueue();

        a.dequeue();

        a.printQueue();



    }

    public testQueue(int max){
        maxSize = max;
        in = out = -1;
        queue = new int[max];
    }


    public void addToQueue(int value){
        if (in+2 > maxSize){
            return;
        }

        if (out == -1){
            out++;
        }

        in++;
        queue[in]=value;
    }

    public int dequeue(){

        if (out == -1){
            return -1;
        }

        int valueReturn = queue[out];

        if (in == out){
            in  = out = -1;   
        }else if (in > out){
            out++;
        }

        return valueReturn;
    }


    public void printQueue(){

        System.out.println("");


        for (int i = out; i <= in;  i++){
            System.out.println(queue[i]);
        }
    }
}
