package Questoes;

import Estrutura.ListaLigada;

public class Questao1<Key, Value> {
    private Key keys[];
    private ListaLigada<Value>[] values;
    private int tamanho;
    public Questao1(int tamanho){
        this.tamanho=tamanho;
        this.values = new ListaLigada[tamanho];
        keys=(Key[]) new Object[tamanho];
    }
    public Key[] getKeys() {
        return keys;
    }

    public void setKeys(Key[] keys) {
        this.keys = keys;
    }

    public ListaLigada<Value>[] getValues() {
        return values;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int hashFunction(Key key){
        return (key.hashCode() & 0x7fffffff)%tamanho;
    }

    public void put(Key key, Value val) {
        int i = hashFunction(key);
        if ( values[i] == null ){
            values[i] = new ListaLigada<Value>();
        }
        keys[i] = key;
        values[i].add(val);
    }
    public Value findAll(Key key) {
        int i = hashFunction(key);
        if(values[i]!=null){
            return (Value) values[i];
        }
        return null;
    }
    public Value get(Key key) {
        for (int i = hashFunction(key); keys[i] != null; i = (i + 1) % tamanho){
            if (keys[i].equals(key))
                return (Value) values[i];
        }
        return null;
    }
}