package Estrutura;

/*
Implementação da Tabela Hash para armazenamento de um par <chave, valor> de qualquer tipo
com traatamento de colisões por hash duplo.
 */
public class Table<K, V> {
    private int capacity;
    private static final double resize_factor = 0.7;

    private Entry<K, V>[] table;
    private int size;

    public Table() {
        this.capacity = 1000;
    }

    public Table(int initialCapacity) {
        this.capacity = initialCapacity;
        table = new Entry[initialCapacity]; //cria um array de entradas para o par<chave, valor>
        size = 0;
    }

    public Entry<K, V>[] getTable(){
        return table;
    }

    //coloca um novo par<chave, valor> na tabela
    public void put(K key, V value) {
        boolean coloca = true;
        //verifica se a lotação já ultrapassa o fator de redimensionamento
        if (size + 1 > table.length * resize_factor) {
            resizeTable();
        }

        int index = hash(key);
        int step = hash2(key);
        int contador = 1;
        while (table[index] != null && coloca==true && !table[index].getKey().equals(key)) {
            // verifica se o valor a ser colocado ainda não existe na tabela, se existir a flag se torna false
            if(table[index].getValue().equals(value)){
                coloca = false;
            }
            index = (index + (contador * step)) % table.length;
            contador++;
            //System.out.println("Tentando colocar " + value + " no index: " + index);
        }

        //não havendo um valor igual existente na tabela, colaca-se o novo valor
        if(coloca == true){
            table[index] = new Entry<>(key, value);
            size++;
        }
    }

    //retorna um valor valor pela chave
    public V get(K key) {
        int index = hash(key);
        int step = hash2(key);
        int contador = 1;
        int aux = index;
        while (table[index] != null) {
            if (table[index].getKey().equals(key)) {
                return table[index].getValue();
            }
            index = (index + (contador * step)) % table.length;
            contador++;
            if(index == aux){
                break;
            }
        }

        return null;
    }

    public int size() {
        return size;
    }

    //calcula o hash
    private int hash(K key) {
        return (key.hashCode() & 0x7FFFFFFF) % capacity;
    }
    //calcula o hash duplo
    private int hash2(K key) {
        int hashCode = key.hashCode() & 0x7FFFFFFF; // remove o bit de sinal
        int step = hashCode % (capacity - 1);

        if (step == 0) {
            step = 1; // garante que o salto seja pelo menos 1
        }
        else if(capacity%step == 0){
            step = (step/2) + 1;
        }

        return step;
    }

    //Redimensiona a tabela com tratammento de colisão hash duplo
    private void resizeTable() {
        this.capacity = table.length * 2;
        Entry<K, V>[] newTable = new Entry[capacity];

        for (Entry<K, V> entry : table) {
            if (entry != null) {
                int index = hash(entry.getKey());
                int step = hash2(entry.getKey());
                int contador = 1;

                //enquanto não encontra um espaço vazio, o hash duplo auxilia em encontrar o novo espaço
                while (newTable[index] != null) {
                    index = (index + (contador * step)) % capacity;
                    contador++;
                }

                newTable[index] = entry;
            }
        }

        table = newTable;
    }
}

