package linklist.gfg;

import java.util.HashMap;

public class LRUCacheDesign {

    private HashMap<Integer, Node1> map;
    private int capacity, count;
    private Node1 head, tail;

    public LRUCacheDesign(int capacity)
    {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node1(0, 0);
        tail = new Node1(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        count = 0;
    }

    public void deleteNode(Node1 node)
    {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(Node1 node)
    {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    public int get(int key)
    {
        if (map.get(key) != null) {
            Node1 node = map.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            System.out.println("Got the value : " +
                    result + " for the key: " + key);
            return result;
        }
        System.out.println("Did not get any value" +
                " for the key: " + key);
        return -1;
    }

    public void set(int key, int value)
    {
        System.out.println("Going to set the (key, "+
                "value) : (" + key + ", " + value + ")");
        if (map.get(key) != null) {
            Node1 node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        }
        else {
            Node1 node = new Node1(key, value);
            map.put(key, node);
            if (count < capacity) {
                count++;
                addToHead(node);
            }
            else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }



}

class Node1 {
    int key;
    int value;
    Node1 pre;
    Node1 next;

    public Node1(int key, int value)
    {
        this.key = key;
        this.value = value;
    }
}