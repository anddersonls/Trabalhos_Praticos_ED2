package Questoes;
import java.util.Random;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int [] result;

        boolean menu = true;

        while(menu){
            System.out.println();
            System.out.println("1 - Realizar a questão 1");
            System.out.println("2 - Realizar a questão 2");
            System.out.println("3 - Realizar a questão 3");
            System.out.println("4 - Realizar a questão 4");
            System.out.println("5 - Sair");
            System.out.println("Opção: ");
            int opcao = scanner.nextInt();

            switch(opcao){
                case 1:
                    questao1();
                    break;
                case 2:
                    questao2();
                    break;
                case 3:
                    questao3();
                    break;
                case 4:
                    questao4();
                    break;
                case 5:
                    System.out.println("Até mais!");
                    menu = false;
                default:
                    System.out.println();
            }
        }
    }
    public static void questao1() {
        Questao1<Integer> resp = new Questao1<>();
        Integer[] vec = {7, 15, 5, 1, 8, 10, 9, 13};
        int[] P = {2, 5};

        mostraVetor(vec);
        Number[] result = resp.retornaKMaiores(vec, P);

        System.out.println("Vetor Resultante: ");
        for(int i=0; i<result.length; i++){
            System.out.print(result[i] + " ");
        }
    }

    public static void questao2() {
        Questao2<String> resp = new Questao2<>();
        Integer[] vec1 = {7, 9, 3};
        //mostraVetor(vec1);
        Integer[] vec2 = {4, 5, 1, 2};
        //mostraVetor(vec2);

        String[] string1 = {"a", "l", "k"};
        String[] string2 = {"h", "m", "c", "j"};
        mostraVetor(string1);
        mostraVetor(string2);
        System.out.println();
        Object result = resp.calculaMediana(string1, string2);
        System.out.println("Mediana: " + result);
    }

    public static void questao3() {
        Questao3<Integer> resp = new Questao3<>();
        Integer[] vec = vetorRadomicoInteger();
        mostraVetor(vec);

        Number[] result1 = resp.distanciaTa(vec, 6);
        System.out.println("Resolução com n^2");
        if(result1 != null) {
            System.out.println("Vetor Resultante: ");
            System.out.println(result1[0] + " " + result1[1]);
        }else{
            System.out.println("Não há valor que satisfaça a diferença!");
        }
        System.out.println();

        Number[] result2 = resp.distanciaTb(vec, 6);
        System.out.println("Resolução com nlogn");
        if(result2 != null) {
            System.out.println("Vetor Resultante: ");
            System.out.println(result2[0] + " " + result2[1]);
        }else{
            System.out.println("Não há valor que satisfaça a diferença!");
        }

    }
    public static void questao4() {
        Questao4<Float> resp = new Questao4<>();
        Float[] vec = vetorRadomicoFloat();

        mostraVetor(vec);
        Float[] result = resp.bshisort(vec, 6);

        System.out.println("Vetor Resultante: ");
        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }

    public static Float[] vetorRadomicoFloat(){
        Random random = new Random();
        Float[] vec = new Float[10];

        for(int i=0; i<vec.length; i++){
            vec[i] = random.nextFloat(10);
        }

        return vec;
    }

    public static Integer[] vetorRadomicoInteger(){
        Random random = new Random();
        Integer[] vec = new Integer[15];

        for(int i=0; i<vec.length; i++){
            vec[i] = random.nextInt(10);
        }

        return vec;
    }
    public static Double[] vetorRadomicoDouble(){
        Random random = new Random();
        Double[] vec = new Double[15];

        for(int i=0; i<vec.length; i++){
            vec[i] = random.nextDouble(10);
        }

        return vec;
    }

    public static void mostraVetor(Object[] vec){
        System.out.println("Vetor Original: ");
        System.out.print("[ ");
        for(int i=0; i<vec.length; i++){
            System.out.print(vec[i] + " ");
        }
        System.out.print("]");
        System.out.println();
        System.out.println("----------------------");
        System.out.println();
    }
}