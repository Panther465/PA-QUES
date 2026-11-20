package heap;

import java.util.ArrayList;

public class MaxHeapImplementation {
    static class MaxHeap {
        ArrayList<Integer> heap = new ArrayList<>();

        void insert(int val) {
            heap.add(val);
            int i = heap.size() - 1;
            while (i > 0) {
                int parent = (i - 1) / 2;
                if (heap.get(parent) >= heap.get(i)) break;
                swap(i, parent);
                i = parent;
            }
        }

        int peek() {
            if (heap.isEmpty()) {
                System.out.println("Heap is empty");
                return -1;
            }
            return heap.get(0);
        }

        int extractMax() {
            if (heap.isEmpty()) {
                System.out.println("Heap is empty");
                return -1;
            }
            int max = heap.get(0);
            int last = heap.remove(heap.size() - 1);
            if (!heap.isEmpty()) {
                heap.set(0, last);
                heapifyDown(0);
            }
            return max;
        }

        void heapifyDown(int i) {
            int n = heap.size();
            while (true) {
                int largest = i;
                int left = 2 * i + 1;
                int right = 2 * i + 2;

                if (left < n && heap.get(left) > heap.get(largest)) largest = left;
                if (right < n && heap.get(right) > heap.get(largest)) largest = right;
                if (largest == i) break;

                swap(i, largest);
                i = largest;
            }
        }

        void swap(int i, int j) {
            int temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }

        int size() {
            return heap.size();
        }

        void print() {
            System.out.println(heap);
        }
    }

    public static void main(String[] args) {
        MaxHeap h = new MaxHeap();
        h.insert(10);
        h.insert(40);
        h.insert(30);
        h.insert(5);
        h.insert(50);
        h.insert(20);

        System.out.print("Heap array: ");
        h.print();
        System.out.println("Max: " + h.peek());

        System.out.print("Extracting: ");
        while (h.size() > 0) {
            System.out.print(h.extractMax() + " ");
        }
        System.out.println();
        h.extractMax();
    }
}
