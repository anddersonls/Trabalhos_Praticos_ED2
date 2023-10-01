public class Questao1<T extends Number & Comparable<T>> extends Sort<T> {
    public T[] RetornaKMaiores(T[] v1, int[] P) {
        int k = P[0];
        for (int i = 0; i < P.length; i++) {
            if (P[i] > k) {
                k = P[i];
            }
        }
        heapSort(v1);
        T[] Maiores = (T[]) new Number[P.length];
        int n = v1.length;
        for (int i = 0; i < P.length; i++) {
            Maiores[i] = v1[n - P[i]];
        }
        return Maiores;
    }
}


