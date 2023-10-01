public class Sort<T extends Comparable<T>> {
    //IMPLEMENTAÇÃO DE MERGE SORT
    public T[] mergeSort(T[] array) {
        T[] tempArray = (T[]) new Comparable[array.length];
        return mergeMain(array, tempArray, 0, array.length - 1);
    }

    public T[] mergeMain(T[] array, T[] tempArray, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeMain(array, tempArray, left, middle);
            mergeMain(array, tempArray, middle + 1, right);
            merge(array, tempArray, left, middle + 1, right);
        }
        return array;
    }

    public void merge(T[] array, T[] tempArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tempPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (array[leftPos].compareTo(array[rightPos]) <= 0) {
                tempArray[tempPos] = array[leftPos];
                leftPos++;
            } else {
                tempArray[tempPos] = array[rightPos];
                rightPos++;
            }
            tempPos++;
        }

        while (leftPos <= leftEnd) {
            tempArray[tempPos] = array[leftPos];
            tempPos++;
            leftPos++;
        }

        while (rightPos <= rightEnd) {
            tempArray[tempPos] = array[rightPos];
            tempPos++;
            rightPos++;
        }

        for (int i = 0; i < numElements; i++, rightEnd--) {
            array[rightEnd] = tempArray[rightEnd];
        }
    }

    // IMPLEMENTAÇÃO DO BUILD MAXHEAP
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

    // IMPLEMENTAÇÃO DO SELECTION SORT
    public T[] selectionSort(T[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            T temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    // IMPLEMENTAÇÃO DO INSERTION SORT
    public T[] insertionSort(T[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            T key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
        return array;
    }
}
