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
    public void put(K key,V value){
        int hashCode=key.hashCode()%hashTable.length;
        Entry node=hashTable[hashCode];

        if(node==null){
            Entry newNode=new Entry(key,value);
            hashTable[hashCode]=newNode;
        }else{
            Entry previousNode=node;
            while(node !=null){
                if(node.key==key){
                    node.value=value;
                    return;
                }
                previousNode=node;
                node=node.next;
            }
            Entry newNode=new Entry(key,value);
            previousNode.next=newNode;
        }
    }
    public V get(K key){
        int hasCode=key.hashCode()%hashTable.length;
        Entry node=hashTable[hasCode];
        while(node!=null){
            if(node.key.equals(key)){
                return (V)node.value;
            }
            node=node.next;
        }
        return null;
    }
}
