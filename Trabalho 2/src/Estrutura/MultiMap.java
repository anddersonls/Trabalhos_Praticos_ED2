package Estrutura;

public class MultiMap<K, V> {
    private int capacity;
    private static final double LOAD_FACTOR = 0.8;

    private Entry<K, ListaLigada<V>>[] table;
    private int size;

    public MultiMap() {
        this.capacity = 20;
    }

    public MultiMap(int initialCapacity) {
        this.capacity = initialCapacity;
        table = new Entry[initialCapacity];
        size = 0;
    }

    public Entry<K, ListaLigada<V>>[] getTable(){
        return table;
    }

    public void put(K key, V val) {
        int i = hash(key);
        if(table[i]==null){
            table[i] = new Entry<>(key, new ListaLigada<V>());
        }
        table[i].setKey(key);
        table[i].getValue().add(val);
    }

    public V findAll(K key) {
        int i = hash(key);
        if(table[i]!=null){
            return (V) table[i].getValue();
        }
        return null;
    }
    public V get(K key) {
        for (int i = hash(key); table[i].getKey() != null; i = (i + 1) % capacity){
            if (table[i].getKey().equals(key))
                return (V) table[i].getValue();
        }
        return null;
    }
    public int size() {
        return size;
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7FFFFFFF) % capacity;
    }
}
