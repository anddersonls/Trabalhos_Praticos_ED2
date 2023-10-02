package Questoes;

import Sort.MergeSort;

public class Questao2<T>{
    public Object calculaMediana(T[] v1, T[] v2){
        int n=v1.length;
        int m=v2.length;
        int tam = n+m;

        //criação do vetor a ser ordenado
        T[] v3 = (T[]) new Object[tam];

        //junçãon dos dois vetores no v3
        System.arraycopy(v1, 0, v3, 0, n);
        System.arraycopy(v2, 0, v3, n, m);

        Object mediana;
        int meio=(n + m)/2;

        //usa do mergeSort, com tempo O(nlogn), para ordenar v3
        MergeSort<T> msort = new MergeSort<>();
        msort.mergeSort(v3);
        System.out.println("Vetor Ordenado: ");
        System.out.print("[ ");
        for(int i=0; i<v3.length; i++){
            System.out.print(v3[i] + " ");
        }
        System.out.println("]");
        //cálculo da mediana
        if (tam % 2 == 0) {
            if (v3[meio] instanceof String) {
                mediana = (Object) ((v3[meio - 1].toString()).concat(v3[meio].toString()));
            } else {
                mediana = (Object) ((Integer.parseInt(v3[meio - 1].toString()) + (Integer.parseInt(v3[meio].toString()))) / 2);
            }
        } else {
            mediana = (Object) v3[meio + 1];
        }

        return (T) mediana;
    }
}
