package queue;

public class QueueWithLinkedList {
    Node front, rear;

    QueueWithLinkedList(int c) {
       front = null;
       rear = null;
    }

    public void enqueue(int x) {
        Node temp = new Node(x);
        if (front == null) {
            front = rear = temp;
            return;
        }
        rear.next = temp;
        rear = temp;
    }

    public void dequeue() {
        if (front == null) return;
        front = front.next;
        if (front == null) rear = null;
    }

}
