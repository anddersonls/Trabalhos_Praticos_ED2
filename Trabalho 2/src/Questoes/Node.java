package Questoes;

public class Node<T> {

    private T conteudo;
    private Node<T> noProximo;

    public Node(T conteudo) {
        this.conteudo = conteudo;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public Node<T> getNoProximo() {
        return noProximo;
    }

    public void setNoProximo(Node<T> noProximo) {
        this.noProximo = noProximo;
    }

    @Override
    public String toString() {
        return "Conteudo=" + conteudo +
                '}';
    }
}