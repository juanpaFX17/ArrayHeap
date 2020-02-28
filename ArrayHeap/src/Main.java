public class Main {
    public static void main(String[] args) {
        System.out.println("The Min Heap is ");
        MinHeap minHeap = new MinHeap(1);
        minHeap.insert(12);
        minHeap.insert(4);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(8);
        minHeap.insert(7);

        minHeap.print();
        minHeap.deleteMin();
        System.out.println("");
        int[] arr = minHeap.getHeap();
        System.out.println(arr[5]);
        System.out.println("");
        minHeap.print();

    }
}

