package Questoes;

import Estrutura.Entry;
import Estrutura.LinkedList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int [] result;

        boolean menu = true;

        while (menu) {
            System.out.println();
            System.out.println("|----------MENU DE FUNCIONALIDADES-----------|");
            System.out.println("1 - Realizar a questão 1");
            System.out.println("2 - Realizar a questão 2 com Tabela Hash");
            System.out.println("3 - Realizar a questão 2 com Árvore AVL");
            System.out.println("4 - Sair");
            System.out.println("Opção: ");
            int opcao = scanner.nextInt();
            System.out.println();

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
                case 4:
                    System.out.println("Até mais!");
                    menu = false;
                default:
                    System.out.println();
            }
        }
    }
    public static void questao1() {
        int n=5;

        Questao1 multimap = new Questao1<Integer, String>(n);
        multimap.put(1, "Leandro");
        multimap.put(2, "Anderson");
        multimap.put(3, "Dallyson");
        multimap.put(4, "Anselmo");
        multimap.put(5, "Flamengo");
        multimap.put(6, "Vito");
        multimap.put(7, "Joana");
        multimap.put(8, "Sabryna");
        multimap.put(9, "André");
        multimap.put(10, "Gabriel");

        Entry<Integer, LinkedList<String>>[] table = multimap.getTable();

        //mostrando todos os pares <chave, valor> existentes no MuiltMap
        for(int i=0; i<table.length; i++){
            if(table[i]!=null){
                System.out.println("Chave: "+table[i].getKey()+ " - Valor da chave: "+ table[i].getValue());
            }
        }

        int encontrarChave = 5;
        System.out.println();
        System.out.println("Valores associados a chave " + encontrarChave + ": "+multimap.findAll(encontrarChave));
        System.out.println("Tamanho atual do MultiMap: " + multimap.getCapacity());
    }
    public static void questao2_1() {
        String pastaDocumentos = "C:\\Users\\ander\\Documents\\Java_Projects\\Trabalhos ED2\\Trabalho 2\\src\\Documentos";
        String pastaVerificar = "C:\\Users\\ander\\Documents\\Java_Projects\\Trabalhos ED2\\Trabalho 2\\src\\Verificar";

        Questao2 questao = new Questao2(4);
        questao.carregarPasta(pastaDocumentos);
        String plagio = questao.verificaPlagioNaTabela(pastaVerificar);
        System.out.println();
        System.out.println(plagio);
    }
    public static void questao2_2() {
        String pastaDocumentos = "C:\\Users\\ander\\Documents\\Java_Projects\\Trabalhos ED2\\Trabalho 2\\src\\Documentos";
        String pastaVerificar = "C:\\Users\\ander\\Documents\\Java_Projects\\Trabalhos ED2\\Trabalho 2\\src\\Verificar";

        Questao2 questao = new Questao2(4);
        questao.carregarPasta(pastaDocumentos);
        String plagio = questao.verificaPlagioNaAVL(pastaVerificar);
        System.out.println();
        System.out.println(plagio);
    }
}