package Questoes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int [] result;

        boolean menu = true;

        while (menu) {
            System.out.println();
            System.out.println("1 - Realizar a questão 1");
            System.out.println("2 - Realizar a questão 2 com Tabela Hash");
            System.out.println("3 - Realizar a questão 2 com Árvore");
            System.out.println("4 - Sair");
            System.out.println("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    questao1();
                    break;
                case 2:
                    questao2_1();
                    break;
                case 3:
                    questao2_2();
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
        int n=30;

        Questao1 hash = new Questao1<Integer, String>(n);
        hash.put(3, "Leandro");
        hash.put(5, "Luan");
        hash.put(6, "Lucas");
        hash.put(7, "Anderson");
        hash.put(7, "Joao victor");
        hash.put(36, "Amora");
        hash.put(5, "Joana");
        Object[] chaves= hash.getKeys();
        for(Object key:chaves){
            if(key!=null){
                Integer keyInt=(Integer)key;
                System.out.println("Chave: "+keyInt+ " Valor da chave "+ hash.get(key));
            }
        }

        System.out.println(hash.findAll(7));
    }
    public static void questao2_1() {
        String pastaDocumentos = "C:\\Users\\ander\\Documents\\Java_Projects\\Trabalhos ED2\\Trabalho 2\\src\\Documentos";
        String pastaVerificar = "C:\\Users\\ander\\Documents\\Java_Projects\\Trabalhos ED2\\Trabalho 2\\src\\Verificar";

        Questao2 questao = new Questao2(4);
        questao.carregarPasta(pastaDocumentos);
        questao.verificaPlagio(pastaVerificar);
        //String key = "esteéodocumento";
        //System.out.println((key.hashCode() & 0x7FFFFFFF) % 20);
        //System.out.println((key.hashCode() & 0x7FFFFFFF) % 40);


    }
    public static void questao2_2() {

    }
}