public class Questao2 extends Sort{
    public static float calculaMediana(int []v1, int []v2){
        int n=v1.length;
        int m=v2.length;

        int []v3=new int[n+m];

        for(int i=0;i<n;i++){
            v3[i]=v1[i];
        }
        for(int i=n;i<n+m;i++){
            v3[i]=v2[i-n];
        }

        float mediana;
        int meio=(n + m)/2;

        //usa algum método de ordenação tipo mergeSort
        mergeSort(v3);

        if((n+m)%2==0){      //verificando se o número é par,
            mediana=(float)(v3[meio]+v3[meio+1])/2;
        }
        else{
            mediana=(float)(v3[meio]);
        }
        return mediana;
    }

    public static String calculaMediana(String string1, String string2) {
        String mediana = "";
        int n = string1.length();
        int m = string2.length();
        int meio = (n + m) / 2 ;

        string1 = string1.toLowerCase();
        string2 = string2.toLowerCase();

        int[] vec = new int[n+m];

        for (int i = 0; i < n; i++) {
            vec[i] = string1.codePointAt(i);
        }
        for (int i=n; i < n+m ; i++) {
            vec[i] = string2.codePointAt(i-n);
        }
        mergeSort(vec);

        if ((n + m) % 2 == 0) {      //verificando se o número é par,
            mediana = mediana + (char) vec[meio - 1] + (char) vec[meio];
        } else {
            mediana = mediana + (char) vec[meio - 1];
        }
        return mediana;
    }
}
