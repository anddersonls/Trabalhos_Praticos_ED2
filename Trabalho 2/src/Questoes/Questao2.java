package Questoes;

import Estrutura.Entry;
import Estrutura.Table;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Questao2 {
    private Table<String, String> table;
    private int m; //tamanho da sequência de palavras para verificação de plágio
    public Questao2(int m){
        this.table = new Table<>(20);
        this.m = m;
    }
    public Entry<String, String>[] getTable(){
        return table.getTable();
    }
    public int getM(){
        return m;
    }
    public void carregarPastaDocumentos() {
        String pastaPath = "C:\\Users\\ander\\Documents\\Java_Projects\\Trabalhos ED2\\Trabalho 2\\src\\Documentos";

        File pasta = new File(pastaPath);

        // Verifique se a pasta existe
        if (pasta.exists() && pasta.isDirectory()) {
            File[] arquivos = pasta.listFiles();

            if (arquivos != null) {
                for (File arquivo : arquivos) {
                    if (arquivo.isFile()) {
                        distribuirSecoes(arquivo);
                    }
                }
                for (Entry<String, String> entry : table.getTable()) {
                    if (entry != null) {
                        System.out.println("Chave: " + entry.getKey() + ", Valor: " + entry.getValue());
                    }
                }
            }else {
                System.out.println("A pasta está vazia.");
            }
        } else {
            System.out.println("A pasta não existe ou não é um diretório válido.");
        }
    }
    public void distribuirSecoes(File arquivo){
        try (BufferedReader leitorBufferizado = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            System.out.println("Processando o arquivo: " + arquivo.getName());
            while ((linha = leitorBufferizado.readLine()) != null) {
                String[] palavras = linha.split(" ");
                for (int i = 0; i < palavras.length - m + 1; i++) {
                    String secao = "";
                    for (int j = 0; j < m; j++) {
                        secao += palavras[i + j] + " ";
                    }
                    //ngramas.add(ngrama.toString().toLowerCase());
                    table.put(secao.toLowerCase(), secao.toLowerCase());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void verificaPlagio(String arquivoPath){
        ArrayList<String> secoesPalavras;
        secoesPalavras = reparteDocumento(arquivoPath);
        String plagio = "";
        int aux = 0;
        for(int i=0; i<secoesPalavras.size(); i++){
            String valor = table.get(secoesPalavras.get(i).toLowerCase());
            if(valor != null){
                System.out.println("Plágio no trecho: " + secoesPalavras.get(i));
                plagio += secoesPalavras.get(i).toUpperCase();
                aux = 3;
            }else{
                if(aux <= 0) {
                    plagio += secoesPalavras.get(i);
                    aux = 3;
                }else{
                    aux--;
                }
            }
        }
        gerarRelatorioPlagio(plagio);
    }

    public ArrayList<String> reparteDocumento(String arquivoPath){
        try {
            BufferedReader leitorBufferizado = new BufferedReader(new FileReader(arquivoPath));
            String linha;

            ArrayList<String> secoesPalavras = new ArrayList<>();

            while ((linha = leitorBufferizado.readLine()) != null) {
                String[] palavras = linha.split(" ");
                for (int i = 0; i < palavras.length - m + 1; i++) {
                    String secao = "";
                    for (int j = 0; j < m; j++) {
                        secao += palavras[i + j] + " ";
                    }
                    secoesPalavras.add(secao);
                }
            }

            // Exibir os n-gramas
            for (String secao : secoesPalavras) {
                System.out.println(secao);
            }

            leitorBufferizado.close();
            return secoesPalavras;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void gerarRelatorioPlagio(String conteudo) {
        String nomeArquivo = "relatorio_de_plagio.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write(conteudo);
            System.out.println("Relatório de plágio gerado com sucesso em " + nomeArquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
