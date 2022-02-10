public class ArrayQueue implements Queue {
    private final int INITIAL_SIZE = 50;
    private int[] queue;
    private int LOGICAL_SIZE;

    public ArrayQueue() {
        this.queue = new int[INITIAL_SIZE];
        this.LOGICAL_SIZE = 0;
    }

    public void pushLast (int newElement){
        if(this.queue.length == this.LOGICAL_SIZE) {
            int[] newQueue = new int[2*this.queue.length];
            for (int i = 0; i < this.queue.length; i++) newQueue[i] = this.queue[i];

            this.queue = newQueue;
        }

        this.queue[this.LOGICAL_SIZE] = newElement;
        this.LOGICAL_SIZE++;
    }

    public int popFirst () {
        if(this.LOGICAL_SIZE == 0)
            throw new RuntimeException("Underflow");

        int first =  this.queue[0];

        //shift left of all the remaining ones
        for(int i= 1; i < this.LOGICAL_SIZE; i++) this.queue[i - 1] = this.queue[i];

        this.LOGICAL_SIZE--;
        return first;
    }

    public int peekFirst () {
        if(this.LOGICAL_SIZE == 0)
            throw new RuntimeException("Underflow");

        return this.queue[0];
    }

    public int getSize () {
        return this.LOGICAL_SIZE;
    }
}
