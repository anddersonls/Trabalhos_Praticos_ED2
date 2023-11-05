package Estrutura;

/*
Implementação da Árvore AVL para
 */
public class AVLTree {
    private AVLNode root = null;

    public AVLTree( ) {
        root = null;
    }

    public void clear() {
        root = null;
    }
    public boolean isEmpty() {
        return root == null;
    }

    public AVLNode getRootNode (){
        return root;
    }

    // Retorna a altura da árvore
    private static int height( AVLNode t ) {
        if (t == null) {
            return -1;
        } else {
            return t.height;
        }
    }


    //Retorna o maior valor.
    private static int max( int lhs, int rhs ) {
        if (lhs > rhs) {
            return lhs;
        } else {
            return rhs;
        }
    }

    // Retorna o fator de balanceamento da árvore com raiz t
    private int getFactor (AVLNode t) {
        return height( t.left ) - height( t.right );
    }

    public boolean insert (String x) {
        root = insert (x, root);
        return true;
    }

    public AVLNode insert (String x, AVLNode t) {
        x=x.toLowerCase();
        if( t == null )
            t = new AVLNode( x, null, null );
        else if( toKey(x)<t.key ) t.left = insert( x, t.left );
        else if( toKey(x)>t.key) t.right = insert( x, t.right );
        t = balance (t);
        return t;
    }

    public AVLNode balance (AVLNode t) {
        if ( getFactor(t) == 2 ) {
            if (getFactor (t.left)>0) t = doRightRotation( t );
            else t = doDoubleRightRotation( t );
        }
        else if ( getFactor(t) == -2 ) {
            if ( getFactor(t.right)<0 ) t = doLeftRotation( t );
            else t = doDoubleLeftRotation( t );
        }
        t.height = max( height( t.left ), height( t.right ) ) + 1;
        return t;
    }

    // Faz Rotação simples a direita
    private static AVLNode doRightRotation( AVLNode k2 ) {
        AVLNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
        k1.height = max( height( k1.left ), k2.height ) + 1;
        return k1;
    }

    // Faz Rotação simples à esquerda
    private static AVLNode doLeftRotation( AVLNode k1 ) {
        AVLNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
        k2.height = max( height( k2.right ), k1.height ) + 1;
        return k2;
    }

    // Faz Rotação dupla à direita
    private static AVLNode doDoubleRightRotation( AVLNode k3 ) {
        k3.left = doLeftRotation( k3.left );
        return doRightRotation( k3 );
    }

    //Faz Rotação dupla à esquerda
    private static AVLNode doDoubleLeftRotation( AVLNode k1 ) {
        k1.right = doRightRotation( k1.right );
        return doLeftRotation( k1 );
    }

    public boolean search(String palavra) {
        return search(root,palavra);
    }
    protected Boolean search(AVLNode p, String palavra) {
        palavra=palavra.toLowerCase();
        while (p != null) {
            // se valor procuradp == chave do nó retorna referência ao nó
            if (palavra.equals(p.palavra)) return true;
            //se valor procurado < chave do nó, procurar na sub-árvore esquerda deste nó
            else if (toKey(palavra)<p.key) p = p.left;
            // se valor procurado > chave do nó, procurar na sub-árvore direita deste nó
            else p = p.right;
        }
        // caso chave não foi achada, retorna false
        return false;
    }

    public void Simetrico() {
        inorder(root);
    }
    protected void inorder(AVLNode p) {
        if (p != null) {
            inorder(p.left);
            System.out.print(p.palavra+" - ");
            inorder(p.right);
        }
    }

    public void preOrdem() {
        preorder(root);
    }
    protected void preorder(AVLNode p) {
        if (p != null) {
            System.out.print(p.palavra + " - ");
            preorder(p.left);
            preorder(p.right);
        }
    }

    public void PosOrdem() {
        postorder(root);
    }

    protected void postorder(AVLNode p) {
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.palavra + " " + p.key);
        }
    }

    public static int toKey(String palavra){
        int code=0;
        for(int i =0;i<palavra.length();i++){
            code+=palavra.codePointAt(i);
        }
        return code;
    }

}
