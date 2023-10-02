package Sort;

public class MergeSort<T> {
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
            if (compara(array[leftPos], (array[rightPos])) <= 0) {
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

    public int compara(T obj1, T obj2) {
        if (obj1 instanceof String) {
            int i = (obj1.toString()).compareTo(obj2.toString());
            return i;
        } else {
            if (Integer.parseInt(obj1.toString()) < Integer.parseInt(obj2.toString())) {
                return -1;
            } else if (Integer.parseInt(obj1.toString()) == Integer.parseInt(obj2.toString())) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}
