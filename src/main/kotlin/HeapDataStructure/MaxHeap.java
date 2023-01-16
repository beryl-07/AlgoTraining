package HeapDataStructure;

public class MaxHeap {
    private int[] Heap; // Array
    private int size;
    private int maxsize;
    public MaxHeap(int size) {
        this.maxsize = size;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;
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
        tmp = Heap[firstPosition];
        Heap[firstPosition] = Heap[secondPosition];
        Heap[secondPosition] = tmp;
    }
}
