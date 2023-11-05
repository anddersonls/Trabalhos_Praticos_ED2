package Questoes;

import Estrutura.Entry;
import Estrutura.LinkedList;

public class Questao1<K, V> {
    private int capacity; //capacidade total
    private static final double resize_factor = 0.8;
    private Entry<K, LinkedList<V>>[] table;
    private int ocupado; //quantidade de espaços válidos ocupados na tabela

    public Questao1() {
        this.capacity = 20;
    }

    public Questao1(int initialCapacity) {
        this.capacity = initialCapacity;
        table = new Entry[initialCapacity];
        ocupado = 0;
    }

    public Entry<K, LinkedList<V>>[] getTable(){
        return table;
    }
    public int getCapacity(){
        return capacity;
    }

    public void put(K key, V val) {
        //Verifica se já há 80% de espaços ocupados
        if (ocupado + 1 > table.length * resize_factor) {
            resizeTable();
        }
        int i = hash(key);
        //Verifica se o espaço está vazio. Caso esteja insere-se um novo par<chave, valor>
        //caso contrário, basta adicionar o valor a lista já existente na posição
        if(table[i]==null){
            table[i] = new Entry<>(key, new LinkedList<V>());
            ocupado++;
        }
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
    public int ocupado() {
        return ocupado;
    }

    //calcula o valor do hash
    private int hash(K key) {
        return (key.hashCode() & 0x7FFFFFFF) % capacity;
    }

    //Duplica o tamanho da tabela
    private void resizeTable() {
        this.capacity = table.length * 2;
        Entry<K, LinkedList<V>>[] newTable = new Entry[capacity];

        for (Entry<K, LinkedList<V>> entry : table) {
            if (entry != null) {
                int index = hash(entry.getKey());
                //Verifica se há algum valor já na nova posição da nova tabela
                //Se for null, então está vazia logo basta colocar a chave e a lista associada a chave
                //Se for diferente de null, então já há um par<chave, valor> então basta inserir os valores na lista existente
                if(newTable[index]==null){
                    newTable[index] = new Entry<>(entry.getKey(), entry.getValue());
                }else{
                    LinkedList<V> lista = entry.getValue();
                    int tamanho = lista.getTamanhoLista();
                    for(int i=0; i<tamanho; i++){
                        newTable[index].getValue().add(lista.getConteudo(i));
                    }
                }
            }
        }

        table = newTable;
    }
}
