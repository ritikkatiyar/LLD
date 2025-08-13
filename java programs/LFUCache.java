import java.util.*;

class LFUCache {
    class Node1 {
        int key;
        int value;
        int count;

        public Node1(int key, int value) {
            this.key = key;
            this.value = value;
            this.count = 1; // start with frequency 1
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Node1)) return false;
            return this.key == ((Node1) o).key;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }
    
    private Map<Integer, Node1> cacheMap;
    private Map<Integer, LinkedHashSet<Node1>> freqMap;
    private int capacity;
    private int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.minFreq = 0;
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)) return -1;
        Node1 Node1 = cacheMap.get(key);
        updateFreq(Node1);
        return Node1.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (cacheMap.containsKey(key)) {
            Node1 Node1 = cacheMap.get(key);
            Node1.value = value;
            updateFreq(Node1);
        } else {
            if (cacheMap.size() == capacity) {
                // Evict least freq used Node1
                LinkedHashSet<Node1> minFreqList = freqMap.get(minFreq);
                Node1 toRemove = minFreqList.iterator().next();
                minFreqList.remove(toRemove);
                cacheMap.remove(toRemove.key);
                if (minFreqList.isEmpty()) {
                    freqMap.remove(minFreq);
                }
            }
            Node1 newNode1 = new Node1(key, value);
            cacheMap.put(key, newNode1);
            freqMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(newNode1);
            minFreq = 1; // reset min frequency to 1
        }
    }

    private void updateFreq(Node1 Node1) {
        int freq = Node1.count;
        LinkedHashSet<Node1> set = freqMap.get(freq);
        set.remove(Node1);
        if (set.isEmpty()) {
            freqMap.remove(freq);
            if (minFreq == freq) minFreq++;
        }

        Node1.count++;
        freqMap.computeIfAbsent(Node1.count, k -> new LinkedHashSet<>()).add(Node1);
    }
}


