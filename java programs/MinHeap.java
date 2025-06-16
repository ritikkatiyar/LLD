class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i) { return (2 * i + 1); }
    private int right(int i) { return (2 * i + 2); }

    public void insert(int val) {
        if (size == capacity) throw new RuntimeException("Heap full");
        heap[size] = val;
        int i = size++;
        while (i != 0 && heap[parent(i)] > heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public int extractMin() {
        if (size == 0) throw new RuntimeException("Heap empty");
        int root = heap[0];
        heap[0] = heap[--size];
        heapify(0);
        return root;
    }

    public int getMin() {
        if (size == 0) throw new RuntimeException("Heap empty");
        return heap[0];
    }

    private void heapify(int i) {
        int smallest = i;
        int l = left(i), r = right(i);
        if (l < size && heap[l] < heap[smallest]) smallest = l;
        if (r < size && heap[r] < heap[smallest]) smallest = r;
        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    private void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
}
