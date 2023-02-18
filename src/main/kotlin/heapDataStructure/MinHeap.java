package heapDataStructure;

public class MinHeap {
    private int[] Heap;
    private int size;
    private int maxSize;

    public MinHeap(int size) {
        this.Heap = new int [size+1];
        this.maxSize = size;
        this.size = 0;
        this.Heap[0] = Integer.MIN_VALUE;
    }
    public MinHeap(int[] array) {
        this.Heap = new int [array.length+1];
        this.maxSize = array.length;
        this.size = array.length;
        this.Heap[0] = Integer.MIN_VALUE;
        for (int i=0; i<array.length; i++) {
            this.Heap[i+1] = array[i];
        }
        for (int i=getParent(this.size); i>0; i--) {
            heapifyDown(i);
        }
    }
    public int getParent (int position) {
        return (position / 2);
    }
    public int leftChild(int position) {
        return (2 * position);
    }
    public int rightChild(int position) {
        return (2 * position) + 1;
    }
    public void swap(int firstPosition, int secondPosition) {
        int tmp = Heap[firstPosition];
        Heap[firstPosition] = Heap[secondPosition];
        Heap[secondPosition] = tmp;
    }
    public void heapifyUp(int position) {
        while (position > 1 && Heap[position] < Heap[getParent(position)]) {
            this.swap(position, getParent(position));
            position = getParent(position);
        }
    }
    public void insert(int key) {
        if (this.size < this.maxSize) {
            Heap[++this.size] = key;
            heapifyUp(this.size);
        } else {
            System.out.println("The Heap is full");
        }
    }
    public void heapifyDown(int position){
        this.swap(position, this.size);
        while (position <= getParent(this.size) && (this.Heap[position] > this.Heap[rightChild(position)] || this.Heap[position] > this.Heap[leftChild(position)])){
            int maxChild = Math.max(this.Heap[rightChild(position)],this.Heap[leftChild(position)]);
            if (maxChild == this.Heap[rightChild(position)]) {
                this.swap(position, rightChild(position));
                position = rightChild(position);
            } else {
                this.swap(position, leftChild(position));
                position = leftChild(position);
            }
        }
    }
    public int extract_min() {
        int min = this.Heap[1];
        this.Heap[1] = this.Heap[this.size--];
        heapifyDown(1);
        return min;
    }

    public void print() {
        for (int i=1; i<=getParent(this.size); i++) {
            try {
                System.out.println(this.Heap[i] + "\n\t Left Child: " + this.Heap[leftChild(i)] + "\n\t Right Child: "+ this.Heap[rightChild(i)]);
            } catch (Exception e) {
                System.out.println(this.Heap[i] + "\n\t Left Child: " + this.Heap[leftChild(i)]);
            }
        }
    }

    public static void main(String[] args){
       MinHeap minHeap = new MinHeap(5);

       minHeap.insert(50);
       minHeap.insert(40);
       minHeap.insert(10);
       minHeap.insert(20);
       minHeap.insert(30);

       minHeap.print();
       System.out.println(minHeap.extract_min());
    }
}
