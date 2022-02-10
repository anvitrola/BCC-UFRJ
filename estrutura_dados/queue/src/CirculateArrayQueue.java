public class CirculateArrayQueue implements Queue {
    private final int INITIAL_SIZE = 10;

    private int[] queue;
    private int LOGICAL_SIZE;

    private int head; //first position
    private int tail; //last position

    public CirculateArrayQueue() {
        initialize(INITIAL_SIZE);
    }

    public CirculateArrayQueue(int size) {
        initialize(size);
    }

    private void initialize (int size) {
        this.queue = new int[size];
        this.LOGICAL_SIZE = 0;
        this.head = 0;
        this.tail = -1;
    }

    /**
     */
    public void pushLast (int newElement) {
        int queueSize = this.queue.length;

        if(queueSize == LOGICAL_SIZE) { //overflow
              int [] newQueue = new int[2*queueSize];
              int contCopiedElements = 0;
              for(int i = this.head; i != this.tail; i = (i+1) % queueSize){
                newQueue[contCopiedElements++] = this.queue[i];
              }

              newQueue[contCopiedElements++] = this.queue[this.tail];
              this.queue = newQueue;

              this.head = 0;
              this.tail = contCopiedElements -1;
        }
        this.tail = (this.tail++) % queueSize;
        this.queue[this.tail] = newElement;

        if(LOGICAL_SIZE == 0)
            this.tail = this.head;

        this.LOGICAL_SIZE++;
    }

    /**
     * A lógica aqui é que o primeiro da fila não esteja relacionado
     * ao index do elemento, mas à posição em que se encontra o 'título'
     * de primeiro (head) da fila
     */
    public int popFirst() {
        if(this.LOGICAL_SIZE == 0)
            throw new RuntimeException("Underflow");
        //the first now is the next array index
        int first = this.queue[this.head++];

        this.LOGICAL_SIZE--;
        return first;
    }

    public int peekFirst() {
        if(this.LOGICAL_SIZE == 0)
            throw new RuntimeException("Underflow");

        return this.queue[this.head];
    }

    public int getSize() {
        return this.LOGICAL_SIZE;
    }

     /*
        Tamanho inicial do array = 1
        Crescimento em P.G. (com razão 2)
      #inserção        esforço            tamanho (depois)
             1   ----      1      ----       1
             2   ----  1 + 1      ----       2
             3   ----  2 + 1      ----       4
             4   ----      1      ----       4
             5   ----  4 + 1      ----       8
             6   ----      1      ----       8
             7   ----      1                 8
             8   ----      1                 8
             9   ----  8 + 1                 8
            10   ----      1
           ....         ...
         n = 2^k ----      1
         Esforço total = n + (1+2+4+8+16+...+2^(k-1))
                       = n + (2^k - 1)
                       = n +   n  - 1
                       = 2n - 1 = O(n)
         Esforço médio (por inserção) = O(n) / n = O(1)
         -----------------------------------
         Tamanho inicial do array = 1
        Crescimento em P.A. (com razão 10)
      #inserção        esforço            tamanho (depois)
             1   ----      1      ----       10
             2   ----      1      ----       10
             3   ----      1      ----       10
             4   ----      1      ----       10
           ...                              ...
            10   ----      1      ----       10
            11   ---  10 + 1      ----       20
            12             1                 20
            13             1                 20
           ...
            20             1                 20
            21        20 + 1                 30
            22             1                 30
          ...
         n=10k                          o menor múltiplo de 10
                                          que é <= n
         Esforço total = n + (10+20+30+40+50+...+ 10k)
                       = n + (10 + 10k).k/2 =
                       = n +  5k^2 + 5k =
                       = n + 5(n/10)^2 + 5(n/10)
                       = n + n^2/20 + n/2 =
                       = 0.05n^2 + 1.5n = O(n^2)
         Esforço médio (por inserção) = O(n^2) / n = O(n)
     */
}
