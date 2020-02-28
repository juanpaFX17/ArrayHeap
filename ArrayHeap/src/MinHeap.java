import java.nio.BufferUnderflowException;

class MinHeap {
    private int[] Heap;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;


    public MinHeap() {
        this(DEFAULT_CAPACITY);
    }

    public MinHeap( int capacity ) {
        size= 0;
        Heap = new int[capacity+1];
    }


    public int getSize() {
        return size;
    }

    public int[] getHeap() {
        return Heap;
    }

    public int[] enlargeArray(int[] arr){
        int[] newArr = new int[arr.length*2];
        for(int i=0; i<arr.length; i++){
            newArr[i] = arr[i];
        }
        arr=newArr;
        return arr;
    }

    public int findMin( )
    {
        if( isEmpty() ) {
            throw new BufferUnderflowException();
        }
        return Heap[1];
    }

    // Function to return the position of
    // the parent for the node currently
    // at pos
    /*
    private int parent(int pos) {
        return pos / 2;
    }

    // Function to return the position of the
    // left child for the node currently at pos
    private int leftChild(int pos) {
        return (2 * pos);
    }

    // Function to return the position of
    // the right child for the node currently
    // at pos
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    // Function that returns true if the passed
    // node is a leaf node
    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }
    */
    // Function to swap two nodes of the heap

    public void insert(int element) {
        if( size == Heap.length-1){
            Heap = enlargeArray(Heap);
        }
        // Percolate up
        int hole = ++size;

        for( Heap[0] = element; element<(Heap[hole/2]) ; hole /= 2 ) {
            Heap[hole] = Heap[hole / 2];
        }
        Heap[hole] = element;

    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    // Function to heapify the node at pos
    /*
    private void minHeapify(int pos) {

        // If the node is a non-leaf node and greater
        // than any of its child
        if (!isLeaf(pos)) {
            if (Heap[pos] > Heap[leftChild(pos)]
                    || Heap[pos] > Heap[rightChild(pos)]) {

                // Swap with the left child and heapify
                // the left child
                if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }

                // Swap with the right child and heapify
                // the right child
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }
    */


    private void percolateDown( int hole ) {
        int child;
        int tmp = Heap[hole];
        for( ; hole * 2 <= size; hole = child ) {
            child = hole*2;

            if( child != size && Heap[child+1]<Heap[child]){
                child++;
            }

            if( Heap[child]<tmp) {
                Heap[hole] = Heap[child];
            }else {
                break;
            }
        }
        Heap[hole] = tmp;
    }

    public boolean isEmpty(){
        int a = this.size;
        boolean r = false;
        if(a==0){
            r = true;
        }
        return r;
    }

    public void remove(int k){
        int t = 1;
        for(int i=1; i<this.getSize();i++){
            if(Heap[i]==k){
                break;
            }
            t++;
        }
        Heap[t] = Integer.MIN_VALUE;
        while(Heap[t]<Heap[(int)Math.floor(t/2)]){
            swap(t,(int)Math.floor(t/2));
            t=(int)Math.floor(t/2);
        }
        deleteMin();
    }

    // Function to build the min heap using
// the minHeapify
    /*
    public void minHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }
       */

    public int deleteMin() {
        if(isEmpty()==true){
            throw new BufferUnderflowException();
        }
        int minItem= findMin();
        Heap[1] = Heap[size--];
        percolateDown(1);
        return minItem;

    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i]
                    + " LEFT CHILD : " + Heap[2 * i]
                    + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }
}


