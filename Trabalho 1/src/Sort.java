public class Sort {
    //IMPLEMENTAÇÃO DE MERGE SORT
    public static int[] mergeSort(int [] vec){
        int [] tempVec = new int[vec.length];

        return mergeMain(vec, tempVec, 0, vec.length-1);
    }

    public static int [] mergeMain(int [] vec, int [] tempVec, int esq, int dir){
        int meio;
        if(esq<dir){
            meio = (esq+dir) / 2;
            mergeMain(vec, tempVec, esq, meio);
            mergeMain(vec, tempVec, meio + 1, dir);
            merge(vec, tempVec, esq, meio+1, dir);
        }

        return vec;
    }

    public static void merge (int [] vec, int [] tempVec, int esqPos, int dirPos, int dirFim){
        int esqFim = dirPos - 1;
        int tempPos = esqPos;
        int numElem = dirFim - esqPos + 1;

        while(esqPos <= esqFim && dirPos <= dirFim){
            if(vec[esqPos] <= vec[dirPos]){
                tempVec[tempPos] = vec[esqPos];
                esqPos++;
            }else{
                tempVec[tempPos] = vec[dirPos];
                dirPos++;
            }
            tempPos++;
        }

        while(esqPos <= esqFim){
            tempVec[tempPos] = vec[esqPos];
            tempPos++;
            esqPos++;
        }

        while(dirPos <= dirFim){
            tempVec[tempPos] = vec[dirPos];
            tempPos++;
            dirPos++;
        }

        for(int i=0; i<numElem; i++, dirFim--){
            vec[dirFim] = tempVec[dirFim];
        }
    }
    //IMPLEMENTAÇÃO DO BUILD MAXHEAP
    public static void Maxheap(int []vetor, int i, int n) {
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;
        int raiz = i;
        if (esquerda < n && vetor[esquerda] > vetor[raiz]) {
            raiz = esquerda;
        }
        if (direita < n && vetor[direita] > vetor[raiz]) {
            raiz = direita;
        }
        if (raiz != i) {
            int aux = vetor[raiz];
            vetor[raiz] = vetor[i];
            vetor[i] = aux;
            Maxheap(vetor, raiz, n);
        }
    }
    //IMPLEMENTAÇÃO DO SELECTION SORT
    public static int[] selectionSort(int[] vec) {
        for (int i = 0; i < vec.length; i++) {
            int min = i;
            for (int j = i + 1; j < vec.length; j++) {
                if (vec[j] < vec[min]) {
                    min = j;
                }
            }
            int aux = vec[i];
            vec[i] = vec[min];
            vec[min] = aux;
        }
        return vec;
    }

    //IMPLEMENTAÇÃO DO INSERTION SORT
    public static int[] insertionSort(int[] vec) {
        for (int i = 1; i < vec.length; i++) {
            int j = i - 1, chave = vec[i];

            while (j >= 0 && vec[j] > chave) {
                vec[j + 1] = vec[j];
                j--;
            }

            vec[j + 1] = chave;
        }
        return vec;
    }

}