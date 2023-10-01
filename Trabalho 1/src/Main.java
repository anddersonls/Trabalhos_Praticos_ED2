import java.util.Random;
import java.util.Scanner;
public class Main<T> {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Float[] vec = new Float[15];
        int [] vec2 = new int[9];

        //int [] result;
        Random random = new Random();

        for(int i=0; i<vec.length; i++){
            vec[i] = random.nextFloat(10);
        }

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
                    questao1(vec);
                    break;
                case 2:
                    questao2(vec);
                    break;
                case 3:
                    questao3(vec);
                    break;
                case 4:
                    questao4(vec);
                    break;
                case 5:
                    System.out.println("Até mais!");
                    menu = false;
                default:
                    System.out.println();
            }
        }
    }
    public static void questao1(Float[] vec) {
        Questao1<Float> resp = new Questao1<>();
    }

    public static void questao2(Float[] vec) {
        Questao2<Float> resp = new Questao2<>();
    }

    public static void questao3(Float[] vec) {
        Questao3<Float> resp = new Questao3<>();
    }
    public static void questao4(Float[] vec) {
        Questao4<Float> resp = new Questao4<>();

        System.out.println("Vetor Original: ");
        for(int i=0; i<vec.length; i++){
            System.out.println(vec[i]);
        }
        System.out.println();
        System.out.println("----------------------");
        System.out.println();
        Float[] result = resp.bshisort(vec, 6);

        System.out.println("Vetor Resultante: ");
        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }
}