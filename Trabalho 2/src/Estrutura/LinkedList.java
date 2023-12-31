package Estrutura;

/*
Implementação da Lista Ligada para armazenar qualquer tipo de dado
 */
public class LinkedList<T> {

    private Node<T> primeiroNo;
    private Node<T> ultimoNo;

    private int tamanhoLista;

    public LinkedList(){
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanhoLista = 0;
    }

    //Adiciona ao final da lista
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

    //remove um elemento pelo índice dele na lista
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

    public Node<T> getNo(int index){
        Node<T> noAuxiliar = primeiroNo;
        for(int i=0; (i < index) && (noAuxiliar != null); i++){
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        return noAuxiliar;
    }

    public T getConteudo(int index){
        Node<T> noAuxiliar = primeiroNo;
        for(int i=0; (i < index) && (noAuxiliar != null); i++){
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        return noAuxiliar.getConteudo();
    }

    public int getTamanhoLista(){
        return this.tamanhoLista;
    }

    //Transforma o conteúdo encontrada na lista em uma string
    @Override
    public String toString() {
        String strRetorno = "";
        Node<T> noAuxiliar = primeiroNo;
        for(int i = 0; i<getTamanhoLista(); i++){
            strRetorno += "[Conteudo=" + noAuxiliar.getConteudo() + "]";
            noAuxiliar = noAuxiliar.getNoProximo();
            if(noAuxiliar!=null){
                strRetorno += "-->";
            }
        }
        return strRetorno;
    }

}