package Questoes;

import Estrutura.AVLTree;
import Estrutura.Entry;
import Estrutura.ListaLigada;
import Estrutura.MultiMap;

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

        MultiMap hash = new MultiMap<Integer, String>(20);
        hash.put(3, "Leandro");
        hash.put(5, "Luan");
        hash.put(6, "Lucas");
        hash.put(7, "Anderson");
        hash.put(7, "Joao victor");
        hash.put(36, "Amora");
        hash.put(5, "Joana");
        Entry<Integer, ListaLigada<String>>[] multimap = hash.getTable();
        for(int i=0; i<multimap.length; i++){
            if(multimap[i]!=null){
                System.out.println("Chave: "+multimap[i].getKey()+ " Valor da chave "+ multimap[i].getValue());
            }
        }

        System.out.println(hash.findAll(7));
    }
    public static void questao2_1() {
        String pastaDocumentos = "C:\\Users\\ander\\Documents\\Java_Projects\\Trabalhos ED2\\Trabalho 2\\src\\Documentos";
        String pastaVerificar = "C:\\Users\\ander\\Documents\\Java_Projects\\Trabalhos ED2\\Trabalho 2\\src\\Verificar";

        Questao2_a questao = new Questao2_a(4);
        questao.carregarPasta(pastaDocumentos);
        questao.verificaPlagio(pastaVerificar);
        //String key = "esteéodocumento";
        //System.out.println((key.hashCode() & 0x7FFFFFFF) % 20);
        //System.out.println((key.hashCode() & 0x7FFFFFFF) % 40);


    }
    public static void questao2_2() {
        String pastaDocumentos = "C:\\Users\\ander\\Documents\\Java_Projects\\Trabalhos ED2\\Trabalho 2\\src\\Documentos";
        String pastaVerificar = "C:\\Users\\ander\\Documents\\Java_Projects\\Trabalhos ED2\\Trabalho 2\\src\\Verificar";
        Questao2_b questao = new Questao2_b(4);
        questao.carregarPasta(pastaDocumentos);
        questao.verificaPlagio(pastaVerificar);

    }
}