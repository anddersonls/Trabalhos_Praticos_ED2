package Questoes;

import Estrutura.Entry;
import Estrutura.Table;

import java.io.*;
import java.util.ArrayList;

public class Questao2_a {
    private Table<String, String> table;
    private int m; //tamanho da sequência de palavras para verificação de plágio
    public Questao2_a(int m){
        this.table = new Table<>(20);
        this.m = m;
    }
    public Entry<String, String>[] getTable(){
        return table.getTable();
    }
    public int getM(){
        return m;
    }
    public void carregarPasta(String pastaPath) {
        File pasta = new File(pastaPath);

        // Verifique se a pasta existe
        if (pasta.exists() && pasta.isDirectory()) {
            File[] arquivos = pasta.listFiles();

            if (arquivos != null) {
                for (File arquivo : arquivos) {
                    if (arquivo.isFile()) {
                        distribuirSecoesNaTabela(arquivo);
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
    public void distribuirSecoesNaTabela(File arquivo){
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
        ArrayList<String[]> secoesPalavras;
        secoesPalavras = documentosVerificar(arquivoPath);
        String plagio = "";
        for(int i=0; i<secoesPalavras.size(); i++){
            String valor = table.get(secoesPalavras.get(i)[0].toLowerCase());
            if(valor != null){
                plagio += "Plágio no documento " + secoesPalavras.get(i)[2] + ", parágrafo " + secoesPalavras.get(i)[1] + ", no seguinte trecho: " + secoesPalavras.get(i)[0] + "\n";
            }
        }
        gerarRelatorioPlagio(plagio);
    }

    public ArrayList<String[]> documentosVerificar(String arquivoPath){
        File pasta = new File(arquivoPath);
        ArrayList<String[]> secoesPalavras = new ArrayList<>();
        // Verifique se a pasta existe
        if (pasta.exists() && pasta.isDirectory()) {
            File[] arquivos = pasta.listFiles();

            if (arquivos != null) {
                for (File arquivo : arquivos) {
                    if (arquivo.isFile()) {
                        try {
                            BufferedReader leitorBufferizado = new BufferedReader(new FileReader(arquivo));
                            String linha;
                            int paragrafo = 0;
                            while ((linha = leitorBufferizado.readLine()) != null) {
                                String[] palavras = linha.split(" ");
                                if (palavras.length > 1) {
                                    paragrafo++;
                                }
                                for (int i = 0; i < palavras.length - m + 1; i++) {
                                    String[] secao = new String[3];
                                    secao[0] = "";
                                    secao[1] = Integer.toString(paragrafo);
                                    secao[2] = arquivo.getName();
                                    for (int j = 0; j < m; j++) {
                                        secao[0] += palavras[i + j] + " ";
                                    }
                                    secoesPalavras.add(secao);
                                }
                            }

                            // Exibir os n-gramas
                            /*for (String secao : secoesPalavras) {
                                System.out.println(secao);
                            }*/

                            leitorBufferizado.close();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return secoesPalavras;
            }
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
