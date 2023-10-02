package Sort;

public class HeapSort<T extends Comparable<T>> {
    public void buildMaxHeap(T[] array) {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(array, i, n);
        }
    }
    public void heapSort(T[] arr) {
        int n = arr.length;

        // Construir um max-heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }

        // Extrair elementos um por um
        for (int i = n - 1; i >= 0; i--) {
            // Trocar o elemento raiz (o maior) com o último elemento não classificado
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Chama o heapify no heap reduzido
            maxHeapify(arr, i, 0);
        }
    }


    public void maxHeapify(T[] array, int i, int n) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < n && array[left].compareTo(array[largest]) > 0) {
            largest = left;
        }

        if (right < n && array[right].compareTo(array[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            T temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            maxHeapify(array, largest, n);
        }
    }

}
