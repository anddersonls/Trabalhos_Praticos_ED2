import java.util.Arrays;

public class Questao4<T extends Comparable<T>> extends Sort<T> {
    public T[] bshisort(T[] array, int E) {
        int resto_E = array.length % E;
        buildMaxHeap(array);
        T[] auxVec1 = Arrays.copyOfRange(array, 0, resto_E);
        T[] auxVec2 = Arrays.copyOfRange(array, resto_E, array.length - resto_E);
        T[] auxVec3 = Arrays.copyOfRange(array, array.length - resto_E, array.length);

        auxVec1 = selectionSort(auxVec1);
        auxVec2 = insertionSort(auxVec2);
        auxVec3 = selectionSort(auxVec3);

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


