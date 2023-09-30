import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int [] vec = new int[100];
        int [] result;
        Random random = new Random();

        for(int i=0; i<vec.length; i++){
            vec[i] = random.nextInt(100);
        }
        
        Questao1 resp = new Questao1();
        result = resp.bshisort(vec);

        for(int item: result){
            System.out.println(item);
        }
    }
}