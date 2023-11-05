package Estrutura;

/*
Implementa o nó utilizado na construção da Árvore AVL
 */
public class AVLNode {
    protected int height;
    protected int key;
    protected String palavra;
    protected AVLNode left, right;

    public AVLNode ( String palavra ) {
        this( palavra, null, null );
    }

    public AVLNode ( String palavra, AVLNode lt, AVLNode rt ) {
        this.palavra=palavra;
        key = toKey(palavra);
        left = lt;
        right = rt;
        height   = 0;
    }
    public static int toKey(String palavra){
        int code=0;
        for(int i =0;i<palavra.length();i++){
            code+=palavra.codePointAt(i);
        }
        return code;
    }
}