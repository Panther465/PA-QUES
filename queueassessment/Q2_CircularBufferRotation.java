package queueassessment;

public class Q2_CircularBufferRotation {
    int[] buf;
    int front = 0;
    int size = 0;
    int cap;

    Q2_CircularBufferRotation(int cap) {
        this.cap = cap;
        buf = new int[cap];
    }

    void add(int val) {
        if (size == cap) {
            buf[front] = val;
            front = (front + 1) % cap;
            return;
        }
        buf[(front + size) % cap] = val;
        size++;
    }

    void rotate(int k) {
        if (size == 0) return;
        k = k % size;
        for (int i = 0; i < k; i++) {
            int val = buf[front];
            front = (front + 1) % cap;
            buf[(front + size - 1) % cap] = val;
        }
    }

    void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(buf[(front + i) % cap] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Q2_CircularBufferRotation cb = new Q2_CircularBufferRotation(5);
        for (int i = 1; i <= 5; i++) {
            cb.add(i);
        }
        cb.display();

        cb.rotate(2);
        System.out.print("After rotate(2): ");
        cb.display();

        cb.add(6);
        System.out.print("After add(6): ");
        cb.display();

        cb.rotate(7);
        System.out.print("After rotate(7): ");
        cb.display();

        Q2_CircularBufferRotation cb2 = new Q2_CircularBufferRotation(6);
        cb2.add(10);
        cb2.add(20);
        cb2.add(30);
        cb2.add(40);
        cb2.rotate(1);
        System.out.print("Not full buffer after rotate(1): ");
        cb2.display();
    }
}
