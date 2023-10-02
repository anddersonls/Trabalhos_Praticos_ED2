package Questoes;
import Sort.HeapSort;

public class Questao1<T extends Number & Comparable<T>> {
    HeapSort<T> hsort= new HeapSort<>();
    //
    public void HeapModified(T []arr, int k){

        int n=arr.length;
        for(int i = n / 2 - 1; i >= 0; i--) {
            hsort.maxHeapify(arr, n, i);
        }
        for (int i = n - 1; i >= n-k; i--) {
            // Trocar o elemento raiz (o maior) com o último elemento não classificado
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Chama o heapify no heap reduzido
            hsort.maxHeapify(arr, i, 0);
        }

    }
    public  T[] retornaKMaiores(T []v1, int []P){
        int k=P[0];
        //Encontra o K=maior.
        for(int i=0;i<P.length;i++){
            if(P[i]>k){
                k=P[i];
            }
        }
        HeapModified(v1,k); //Aplica o heapsort apenas K vezes, faz o vetor ter os K maiores elementos nas ultimas posições
        T[] Maiores = (T[]) new Number[P.length]; //cria um vetor com o tamanho do vetor P
        int n=v1.length;
        for(int i=0;i<P.length;i++){
            Maiores[i]=v1[n-P[i]]; //Faz os i primeiros elementos serem iguais aos ultimos elementos do vetor v1, que são justamente os maiores
        }
        return Maiores;
    }
}


