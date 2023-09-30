public class Questao1 {
    public static int[] bshisort(int[] vec){
        int n=vec.length;
        for(int i=n/2 -1;i>=0;i--){
            Maxheap(vec, i,n);
        }

        int prim_part = (vec.length-1)/3;
        int ultm_part = (vec.length-1) - prim_part;
        int[] aux_vec1 = new int[prim_part];
        int[] aux_vec2 = new int[ultm_part - prim_part];
        int[] aux_vec3 = new int[vec.length - ultm_part];

        for(int i=0; i<prim_part; i++){
            aux_vec1[i] = vec[i];
        }
        for(int i=prim_part; i<ultm_part; i++){
            aux_vec2[(i-prim_part)] = vec[i];
        }
        for(int i=ultm_part; i<vec.length; i++){
            aux_vec3[i - ultm_part] = vec[i];
        }

        aux_vec1 = selectionSort(aux_vec1);
        aux_vec2 = insertionSort(aux_vec2);
        aux_vec3 = selectionSort(aux_vec3);
        for(int i=0; i<aux_vec1.length; i++){
            vec[i] = aux_vec1[i];
        }
        for(int i=0; i<aux_vec2.length; i++){
            vec[i+prim_part] = aux_vec2[i];
        }
        for(int i=0; i<aux_vec3.length; i++){
            vec[i+ultm_part] = aux_vec3[i];
        }
        return vec;
    }

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

