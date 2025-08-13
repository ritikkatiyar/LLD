import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
            // default constructor for dummy head/tail
        }
    }

    Map<Integer, Node> cacheMap;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        head = new Node(); // dummy head
        tail = new Node(); // dummy tail
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)) return -1;
        Node node = cacheMap.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            node.value = value;
            deleteNode(node);
            insertAfterHead(node);
        } else {
            if (cacheMap.size() == capacity) {
                Node lru = tail.prev;
                cacheMap.remove(lru.key);
                deleteNode(lru);
            }
            Node newNode = new Node(key, value);
            cacheMap.put(key, newNode);
            insertAfterHead(newNode);
        }
    }

    private void deleteNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void insertAfterHead(Node node) {
        Node first = head.next;
        head.next = node;
        node.prev = head;
        node.next = first;
        first.prev = node;
    }
}


