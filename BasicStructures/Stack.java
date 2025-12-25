package BasicStructures;

public class Stack {

    private int[] values;
    private int currentIndex = -1;
    private int maxSize = 100;

    public Stack(){
        values = new int[maxSize];
        for (int i = 0 ; i < maxSize; i++){
            values[i] = -1;
        }
    }

    public void push(int value){
        currentIndex++;
        if(currentIndex > maxSize){
            addNewArray();   
        }

        this.values[currentIndex] = value;
        
    }

    public int pop(){
        if (currentIndex == -1){
            return 0;
        }
        int popElement = this.values[this.currentIndex];
        currentIndex--;
        return popElement;

    }


    public int peek(){
        return this.values[currentIndex];
    }


    public boolean isEmpty(){
        return currentIndex == -1 ? true : false;
    }


    public int size(){
        return currentIndex + 1;
    }

    
    private void addNewArray(){
        int[] tmpValues = new int[currentIndex + maxSize];

        for(int i = 0 ; i < values.length ; i++ ){
            tmpValues[i] = values[i];
        }
        this.values = tmpValues;
    }

    public void printStack(){
        for (int i = 0 ; i < this.currentIndex + 1 ; i++){
            System.out.println(this.values[i]);
        }
    }

    public static void main(String[] args){
        Stack a = new Stack();
        a.push(5);
        a.push(3);
        a.push(45);
        a.push(8);
        a.push(9);

        System.out.println("SIZE:  " + a.size());
        System.out.println(a.isEmpty());
        System.out.println(a.pop());
        System.out.println(a.pop());
        System.out.println(a.pop());
        System.out.println("SIZE:  " + a.size());
        System.out.println(a.pop());
        System.out.println(a.pop());
        System.out.println(a.pop());
        System.out.println(a.pop());
        System.out.println(a.pop());
        System.out.println(a.pop());
        System.out.println(a.pop());
        System.out.println(a.pop());
        System.out.println("SIZE:  " + a.size());
        System.out.println(a.isEmpty());

        a.printStack();
    }    
}
