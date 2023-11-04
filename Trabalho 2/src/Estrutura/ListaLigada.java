package Estrutura;

import Estrutura.Node;

public class ListaLigada<T> {

    private Node<T> primeiroNo;
    private Node<T> ultimoNo;

    private int tamanhoLista;

    public ListaLigada(){
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanhoLista = 0;
    }

    public T get(int index){
        return this.getNo(index).getConteudo();
    }

    //Adiciona ao FINAL da lista
    public void add(T elemento){
        Node<T> novoNo = new Node<>(elemento);
        novoNo.setNoProximo(null);
        if(primeiroNo == null){
            primeiroNo = novoNo;
        }
        if(ultimoNo != null){
            ultimoNo.setNoProximo(novoNo);
        }
        ultimoNo = novoNo;
        tamanhoLista++;
    }

    public void remove(int index){
        if(index == 0){
            primeiroNo = primeiroNo.getNoProximo();
        }else{
            Node<T> noAuxiliar = getNo(index);
            Node<T> noPrevio = getNo(index-1);
            noPrevio.setNoProximo(noAuxiliar.getNoProximo());
            if(noAuxiliar == ultimoNo){
                ultimoNo = noPrevio;
            }
        }
        this.tamanhoLista--;
    }

    private Node<T> getNo(int index){
        Node<T> noAuxiliar = primeiroNo;
        for(int i=0; (i < index) && (noAuxiliar != null); i++){
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        return noAuxiliar;
    }

    public int size(){
        return this.tamanhoLista;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        Node<T> noAuxiliar = primeiroNo;
        for(int i = 0; i<size(); i++){
            strRetorno += "[Conteudo=" + noAuxiliar.getConteudo() + "]";
            noAuxiliar = noAuxiliar.getNoProximo();
            if(noAuxiliar!=null){
                strRetorno += "-->";
            }
        }
        return strRetorno;
    }
}