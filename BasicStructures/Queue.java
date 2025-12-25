package BasicStructures;

public class Queue {

    private int[] values;
    private int maxSize = 4;
    private int tail = -1;
    private int front = -1;

    public Queue(){
        values = new int[maxSize];
        fillQueue();
    }

    public Queue(int maxSizeInput){
        maxSize = maxSizeInput;
        values = new int[maxSizeInput];
        fillQueue();
    }

    public void fillQueue(){
        for (int i = 0 ; i < maxSize ; i++){
            values[i] = -1;
        }
    }

    public void enqueue(int value){
        
        if(front+1 == maxSize){
            // you should return something but in this case I will not for simplicity.
            System.out.println("QUEUE is FULL...");
            return;
        }

        if (front == -1 &&  tail == -1){
            tail++;
        }

        front++;

        this.values[front] = value;
    }

    public int dequeue(){
        if (tail == -1){
            System.out.println("QUEUE is EMPTY...");
            return 0;
        }

        int tmpValue = this.values[tail];
        if (front == tail){
            front=-1;
            tail=-1;
        }else{
            tail++;
        }

        return tmpValue;
    }
    
    public int peek(){
        if (isNull()){
            System.out.println("IS EMPTY!!!");
            return 0;
        }
        return this.values[front];
    }

    public int tail(){
        if (isNull()){
            System.out.println("IS EMPTY!!!");
            return 0;
        }
        return this.values[tail]; 
    }

    public boolean isFull(){
        return front == maxSize ? true : false;
    }

    public boolean isNull(){
        return (front == -1 && tail == -1) ? true : false;
    }
   

    public static void main(String[] args){


        Queue q = new Queue();
        q.peek();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(8);
        q.enqueue(9);

        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(8);
        q.enqueue(4);
        q.enqueue(8);
        q.enqueue(9);

        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(999999999);
        q.enqueue(22222222);
        q.enqueue(4);
        q.enqueue(8);
        q.enqueue(9);

        q.dequeue();

        System.out.println(q.peek());
        System.out.println(q.tail());
    }
}
