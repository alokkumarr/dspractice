package linklist;

class DNode {
    DNode prev;
    DNode next;
    int data;

    DNode(int data) {
        this.data = data;
        prev = null;
        next = null;
    }
}
