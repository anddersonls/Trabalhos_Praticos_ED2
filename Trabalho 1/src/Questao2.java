public class Questao2<T extends Number & Comparable<T>> extends Sort<T>{
    public double calculaMediana(T[] v1, T[] v2){
        int n=v1.length;
        int m=v2.length;

        T[] v3 = (T[]) new Comparable[n + m];
        System.arraycopy(v1, 0, v3, 0, n);
        System.arraycopy(v2, 0, v3, n, m);

        double mediana;
        int meio=(n + m)/2;

        //usa algum método de ordenação tipo mergeSort
        mergeSort(v3);

        if((n+m)%2==0){      //verificando se o número é par,
            mediana = v3[meio].doubleValue() + v3[meio+1].doubleValue();
            mediana = mediana/2;
        }
        else{
            mediana = v3[meio].doubleValue();
        }

        return mediana;
    }
/*
    public static String calculaMediana(String string1, String string2) {
        String mediana = "";
        int n = string1.length();
        int m = string2.length();
        int meio = (n + m) / 2 ;

        string1 = string1.toLowerCase();
        string2 = string2.toLowerCase();

        T[] vec = (T[]) new Comparable[n + m];

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
    }*/

}
