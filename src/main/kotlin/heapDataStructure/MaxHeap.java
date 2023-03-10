package heapDataStructure;

// Ref: https://ocw.mit.edu/courses/6-006-introduction-to-algorithms-spring-2020/resources/lecture-8-binary-heaps/
public class MaxHeap {
    private final int[] Heap; // Array
    private int size;
    private int maxsize;
    public MaxHeap(int size) {
        this.maxsize = size;
        this.size = 0;
        this.Heap = new int[this.maxsize + 1];
        this.Heap[0] = Integer.MAX_VALUE;
    }
    public int getParent(int position) {
        return (position / 2);
    }
    public int leftChild(int position) {
        return (2 * position);
    }
    public int rightChild(int position) {
        return  ((2 * position) + 1);
    }
    public void swap(int firstPosition, int secondPosition) {
        int tmp;
        tmp = this.Heap[firstPosition];
        this.Heap[firstPosition] = this.Heap[secondPosition];
        this.Heap[secondPosition] = tmp;
    }
    private void heapifyUp(int position) {
        while (position > 1 && this.Heap[position] > this.Heap[getParent(position)]) {
            swap(position, getParent(position));
            position = getParent(position);
        }
        // Or use recursion
        // if (position > 1 && this.Heap[position] > this.Heap[getParent(position)]) {
        //     swap(position, getParent(position));
        //     heapifyUp(getParent(position));
        // }
        // Complexity: O(log n) because we are dividing the problem in half each time
    }
    private void heapifyDown(int position) {
        this.swap(position, this.size);
        while (position <= (this.size / 2) && (this.Heap[position] < this.Heap[leftChild(position)] || this.Heap[position] < this.Heap[rightChild(position)])) {
            int maxChild = Math.max(this.Heap[leftChild(position)], this.Heap[rightChild(position)]);
            if (maxChild == this.Heap[leftChild(position)]) {
                this.swap(position, leftChild(position));
                position = leftChild(position);
            } else {
                this.swap(position, rightChild(position));
                position = rightChild(position);
            }
        }
    }
    public void insert(int element) {
        if (this.size < this.maxsize) {
            Heap[++this.size] = element;
            int current = this.size;
            heapifyUp(current);
        } else {
            System.out.println("Sorry, Heap fill");
        }
    }
    public void print() {
        for (int i = 1; i<= getParent(this.size); i++) {
            try {
                System.out.println( this.Heap[i] + " :\n\t Left Child: " + this.Heap[this.leftChild(i)] + "\n\t Right Child: " + this.Heap[rightChild(i)]);
            } catch (Exception e) {
                System.out.println( this.Heap[i] + " :\n\t Left Child: " + this.Heap[this.leftChild(i)]);
            }
        }
    }
    public int extractMax() {
        int popped = this.Heap[1];
        this.Heap[1] = this.Heap[this.size--];
        heapifyDown(1);
        return popped;
    }
    public static void main(String[] args)
    {

        //MaxHeap maxHeap = new MaxHeap(8);
        //maxHeap.insert(1);
        //maxHeap.insert(4);
        //maxHeap.insert(2);
        //maxHeap.insert(5);
        //maxHeap.insert(13);
        //maxHeap.insert(6);
        //maxHeap.insert(17);
        //maxHeap.insert(3);

        //System.out.println("Maximum is:" + maxHeap.extractMax());

        //maxHeap.print();
        //System.out.println(maxHeap.Heap[9]);

        MaxHeap maxHeap1 = new MaxHeap(10);
        maxHeap1.insert(10);
        maxHeap1.insert(20);
        maxHeap1.insert(30);
        maxHeap1.insert(40);
        maxHeap1.insert(50);
        maxHeap1.insert(60);
        maxHeap1.insert(70);
        maxHeap1.insert(80);
        maxHeap1.insert(90);
        maxHeap1.insert(100);


        maxHeap1.print();
        //System.out.println("Maximum is:" + maxHeap1.extractMax());
        //System.out.println("Heap size: "+maxHeap1.Heap.length+ " maxHeap.Heap[10]:"+maxHeap1.Heap[10]);
    }

}
