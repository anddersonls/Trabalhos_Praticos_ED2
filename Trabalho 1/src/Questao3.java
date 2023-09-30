public class Questao3 {
    public static int[] distanciaTa(int []v, int T){
        int n=v.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(Math.abs(v[i]-v[j])==T){
                    return new int[]{v[i],v[j]};
                }
            }
        }
        return new int[]{-1,-1};
    }

    public static int[] distanciaTb(int []v, int T){
        //ordene o vetor imediatamente ANDERSON
        for(int i=0;i<v.length;i++){
            int diferenca=v[i]-T;
            int pesquisa=BuscaBinaria(v,diferenca);
            if(pesquisa!=-1){
                return new int[]{v[i], v[pesquisa]};
            }

            int diferenca2=v[i]+T;
            int pesquisa2=BuscaBinaria(v,diferenca2);
            if(pesquisa2!=-1){
                return new int[]{v[i], v[pesquisa2]};
            }
        }
        return new int[]{-1,-1};
    }

    public static int BuscaBinaria( int []vetor, int elemento){
        int inicio=0;
        int fim=vetor.length-1;
        int meio;
        while(inicio<=fim){
            meio=(inicio+fim)/2;
            if(vetor[meio]==elemento){
                return meio;
            }
            else if(elemento>vetor[meio]){
                inicio=meio+1;
            }
            else{
                fim=meio-1;
            }
        }
        return -1;
    }
}
