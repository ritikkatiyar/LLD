public class MyHashMap <K,V>{
    private static final int INTIAL_SIZE=1<<4;
    private static final int MAXIMUM_CAPACITY=1<<30;

    public Entry[] hashTable;

    public MyHashMap(){
        hashTable=new Entry[INTIAL_SIZE];
    }
    public MyHashMap(int capacity){
        int tableSize=tableSizeFor(capacity);
        hashTable=new Entry[tableSize];
    }
    final int  tableSizeFor(int cap){
        int n=cap-1;
        n |=n >>> 1;
        n |=n >>> 2;
        n |=n >>> 4;
        n |=n >>> 8;
        n |=n >>> 16;
        return (n<0)?1:(n>=MAXIMUM_CAPACITY)?MAXIMUM_CAPACITY:n+1;
    }
    class Entry<K,V>{
        public K key;
        public V value;
        public Entry next;

        Entry(K k,V v){
            key=k;
            value=v;
        }
    }
}
