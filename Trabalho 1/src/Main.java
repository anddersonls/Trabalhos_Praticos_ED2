import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int [] vec = new int[10];
        int [] vec2 = new int[9];

        int [] result;
        Random random = new Random();

        for(int i=0; i<vec.length; i++){
            vec[i] = random.nextInt(10);
            if(vec2.length > i)
                vec2[i] = random.nextInt(10);
        }

        /*Questao4 resp = new Questao4();
        result = resp.bshisort(vec);*/

        Questao2 resp = new Questao2();
        //Questao3 resp = new Questao3();

        //float r = resp.calculaMediana(vec, vec2);

        //result = resp.distanciaTb(vec, 15);
        String r;
        String string = "anderson";
        String string2 = "leandro";
        r = resp.calculaMediana(string, string2);

        System.out.println("Mediana: " + r);
        /*
        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }*/
    }
}