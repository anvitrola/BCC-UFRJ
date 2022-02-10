import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayQueueTest {
    private Queue<Integer> queue;

    @Before
    public void setUp () {
        this.queue = new ArrayQueue();
    }

    @Test
    public void basicsTest () {
        queue.pushLast(10);
        queue.pushLast(20);
        queue.pushLast(30);
        queue.pushLast(40);


        assertEquals(4, queue.getSize());
        assertEquals(10, queue.peekFirst());
        assertEquals(10, queue.popFirst());
        assertEquals(3, queue.getSize());
        assertEquals(20, queue.peekFirst());
    }

    @Test
    public void pushAndSizeTest () {
        for(int i = 0; i < 1000; i++) {
            queue.pushLast(i);
        }

        assertEquals(1000, queue.getSize());
    }

    @Test
    public void timeAnalysisTest () {
        final int SIZE = 200_000;

        long initial_time = System.currentTimeMillis();
        for(int i = 0; i < SIZE; i++) {
            queue.pushLast(i);
        }
        long duration = System.currentTimeMillis() - initial_time;

        System.out.printf("\nIt took %.3fs to add %d elements in a queue", (duration / 1000.), SIZE);

        initial_time = System.currentTimeMillis();
        while(queue.getSize() < 0) {
            queue.popFirst();
        }
        duration = System.currentTimeMillis() - initial_time;

        System.out.printf("\nIt took %.3fs to remove %d elements in a queue", (duration / 1000.), SIZE);
    }

}