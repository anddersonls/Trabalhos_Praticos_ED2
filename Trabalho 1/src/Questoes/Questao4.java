package Questoes;

import Sort.HeapSort;
import Sort.SelectionSort;
import Sort.InsertionSort;
import java.util.Arrays;

public class Questao4<T extends Comparable<T>>{
    public T[] bshisort(T[] array, int E) {
        int resto_E = array.length % E;

        //construçaõ do maxheap
        HeapSort<T> maxheap = new HeapSort<>();
        maxheap.buildMaxHeap(array);

        //Copiando as pontas e o meio do vetor para vetores auxiliares
        T[] auxVec1 = Arrays.copyOfRange(array, 0, resto_E);
        T[] auxVec2 = Arrays.copyOfRange(array, resto_E, array.length - resto_E);
        T[] auxVec3 = Arrays.copyOfRange(array, array.length - resto_E, array.length);

        //resolução das partes do vetor pelos métodos de ordenação designados
        InsertionSort<T> inssort = new InsertionSort<>();
        SelectionSort<T> selsort = new SelectionSort<>();
        auxVec1 = selsort.selectionSort(auxVec1);
        auxVec2 = inssort.insertionSort(auxVec2);
        auxVec3 = selsort.selectionSort(auxVec3);

        //copiando os vetores auxiliares para o vetor principal
        for (int i = 0; i < auxVec1.length; i++) {
            array[i] = auxVec1[i];
        }
        for (int i = 0; i < auxVec2.length; i++) {
            array[i + resto_E] = auxVec2[i];
        }
        for (int i = 0; i < auxVec3.length; i++) {
            array[i + array.length - resto_E] = auxVec3[i];
        }
        return array;
    }
}


