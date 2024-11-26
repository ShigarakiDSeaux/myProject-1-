import java.util.ArrayList;

public class Queue<E>{
    //Array-based implementation ofo FIFO queue.
    private int head;
    private int tail;
    private int size;
    private int maxSize;
    private E [] elements;
    

    public Queue(){
        head = 0;
        tail = 0;
        size = 0;
        maxSize = 5;
        elements = (E[]) new Object[maxSize];
    }

    public Queue(int maxSize){
        head = 0;
        tail = 0;
        size = 0;
        this.maxSize = maxSize;
        //type casting E to O tyype array.
        elements = (E[]) new Object[maxSize];
    }

    public E first(){
        return (E)elements[head];
    }

    public E last(){
        return (E)elements[tail];
    }

    public boolean isEmpty(){
       return size == 0 || elements == null;

    }

    public boolean isFull(){   
        if (isEmpty()){
            return false;
        }
        return this.size() == maxSize;
    }

    public boolean hasPriority(int index){
        //No indecies but I want to move(increment) the head each time.
        //check empty or full
        if (index >= size|| isEmpty()){
            return false;

        }
        
        if ( elements[index] != null &&((Document) elements[index]).getFileName().equals("priority_topSecret.txt")){
            return true;
        }
        
        return hasPriority(index+1);

        

    }


    public void enqueue(E e){
        if(size < maxSize){
            //The array is not full
            elements[tail] = e;
            size++;
            // tail = tail + 1 // Not quite right...
            tail = (tail + 1) % maxSize; //keeps you in bounds.
        }

        

    }

    public ArrayList<E> queAsArray(){
       ArrayList <E> result = new ArrayList<>();
       for(int i = head; i < head + size; i++){
        result.add(elements[i]);
       }

       return result;
        
    }
    public void priorityEnqueue(E e){
        //first I want to check if the list if full
        if (size < maxSize){
            this.enqueue(e);
        }

    }
    public void swapPriority(){
        E temp = null;
        for (int i = head; i < head + size; i++){
            if((((Document) elements[i]).getFileName().equals("priority_topSecret.txt"))){
                temp = elements[head];
                elements[head] = elements[i];
                elements[i] = temp;


                
                
                
            }
            // System.out.println(priorityElement);
            
        }

    }

    public int size(){
        return size;
    }

        

    public E dequeue(){
        E returnElement;
        if(size > 0){
            returnElement = (E)elements[head];
            size--;
            head = (head + 1) % maxSize;

            return returnElement;
        }

        System.out.println("ERROR: Queue is empty! Cannot remove element from empty queue...");
        return null;

    }

    @Override
    public String toString(){
        String str = "";
            //0(n)
        for (int i = head; i < head + size; i++){
            str += elements[i % maxSize] + " ";
        }

        return str;
    }


    



}