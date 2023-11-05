package Estrutura;

public class Table<K, V> {
    private int capacity;
    private static final double LOAD_FACTOR = 0.8;

    private Entry<K, V>[] table;
    private int size;

    public Table() {
        this.capacity = 20;
    }

    public Table(int initialCapacity) {
        this.capacity = initialCapacity;
        table = new Entry[initialCapacity];
        size = 0;
    }

    public Entry<K, V>[] getTable(){
        return table;
    }

    public void put(K key, V value) {
        boolean coloca = true;
        if (size + 1 > table.length * LOAD_FACTOR) {
            resizeTable();
        }

        int index = hash(key);
        int step = hash2(key);

        //!table[index].getKey().equals(key)
        //System.out.println("Tentando colocar " + value + " no index: " + index);
        while (table[index] != null && coloca==true) {
            //System.out.println("Valor armazenado: " + table[index].getValue() + " Novo Valor: " + value);
            if(table[index].getValue().equals(value)){
                coloca = false;
            }
            index = (index + step) % table.length;
            //System.out.println("Tentando colocar " + value + " no index: " + index);
        }


        if(coloca == true){
            table[index] = new Entry<>(key, value);
            size++;
        }
        /*
        for(int i=0; i<table.length; i++){
            if(table[i]!=null){
                System.out.println("Index: " + i + " Chave-valor: " + table[i].getValue());
            }
        }*/

    }

    public V get(K key) {
        int index = hash(key);
        int step = hash2(key);
        int aux = index;
        while (table[index] != null) {
            if (table[index].getKey().equals(key)) {
                return table[index].getValue();
            }
            index = (index + step) % table.length;
            if(index == aux){
                break;
            }
        }

        return null;
    }

    public int size() {
        return size;
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7FFFFFFF) % capacity;
    }

    private int hash2(K key) {
        int hashCode = key.hashCode() & 0x7FFFFFFF; // Remove o bit de sinal
        int step = hashCode % (capacity - 1); // Usa o valor diretamente

        if (step == 0) {
            step = 1; // Certifica-se de que o salto seja pelo menos 1
        }

        return step;
    }

    private void resizeTable() {
        this.capacity = table.length * 2;
        Entry<K, V>[] newTable = new Entry[capacity];

        for (Entry<K, V> entry : table) {
            if (entry != null) {
                int index = hash(entry.getKey());
                int step = hash2(entry.getKey());

                while (newTable[index] != null) {
                    index = (index + step) % capacity;
                }

                newTable[index] = entry;
            }
        }

        table = newTable;
    }
}

