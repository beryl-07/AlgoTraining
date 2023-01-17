package HeapDataStructure;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxHeapTest {
    @Test
    void test() {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(30);
        maxHeap.insert(40);
        maxHeap.insert(50);
        maxHeap.insert(60);
        maxHeap.insert(70);
        maxHeap.insert(80);
        maxHeap.insert(90);
        maxHeap.insert(100);
        //maxHeap.print();
        assertEquals(100, maxHeap.extractMax());
        assertEquals(90, maxHeap.extractMax());
    }
}