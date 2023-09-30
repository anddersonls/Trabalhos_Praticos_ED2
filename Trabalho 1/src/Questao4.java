public class Questao4 extends Sort{
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
}

