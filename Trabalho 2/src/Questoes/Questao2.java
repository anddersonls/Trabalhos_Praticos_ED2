package Questoes;

import Estrutura.AVLTree;
import Estrutura.Entry;
import Estrutura.Table;

import java.io.*;
import java.util.ArrayList;

public class Questao2 {
    private Table<String, String> table;
    private AVLTree arvore;
    private int m; //tamanho da sequência de palavras para verificação de plágio
    public Questao2(int m){
        this.table = new Table<>(1000);
        this.arvore = new AVLTree();
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
                //Para cada arquivo na pasta, distribui-se na tabela as seções possíveis
                for (File arquivo : arquivos) {
                    if (arquivo.isFile()) {
                        distribuirSecoes(arquivo);
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
        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            System.out.println("Processando o arquivo: " + arquivo.getName());
            //Realiza a leitura do arquivo linha por linha
            while ((linha = leitor.readLine()) != null) {
                String[] palavras = linha.split(" ");
                //Divide nas possíveis possibilidades de sequências de tamanho m de palavras
                for (int i = 0; i < palavras.length - m + 1; i++) {
                    String secao = "";
                    for (int j = 0; j < m; j++) {
                        secao += palavras[i + j] + " ";
                    }
                    table.put(secao.toLowerCase(), secao.toLowerCase());
                    arvore.insert(secao.toLowerCase());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String verificaPlagioNaTabela(String arquivoPath){
        ArrayList<String[]> secoesPalavras;
        secoesPalavras = documentosVerificar(arquivoPath);
        String plagio = "";
        for(int i=0; i<secoesPalavras.size(); i++){
            String valor = table.get(secoesPalavras.get(i)[0].toLowerCase());
            if(valor != null){
                plagio += "Plágio no documento " + secoesPalavras.get(i)[2] + ", parágrafo "
                        + secoesPalavras.get(i)[1] + ", no seguinte trecho: "
                        + secoesPalavras.get(i)[0] + "\n";
            }
        }
        if(plagio == ""){
            plagio += "Não houve ocorrências de plágio!";
        }
        gerarRelatorioPlagio(plagio);
        return plagio;
    }

    public String verificaPlagioNaAVL(String arquivoPath){
        ArrayList<String[]> secoesPalavras;
        secoesPalavras = documentosVerificar(arquivoPath);
        String plagio = "";
        for(int i=0; i<secoesPalavras.size(); i++){
            boolean valor = arvore.search(secoesPalavras.get(i)[0].toLowerCase());
            if(valor == true){
                plagio += "Plágio no documento " + secoesPalavras.get(i)[2] + ", parágrafo " + secoesPalavras.get(i)[1] + ", no seguinte trecho: " + secoesPalavras.get(i)[0] + "\n";
            }
        }
        if(plagio == ""){
            plagio += "Não houve ocorrências de plágio!";
        }
        gerarRelatorioPlagio(plagio);
        return plagio;
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
                            BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
                            String linha;
                            int paragrafo = 0;
                            while ((linha = leitor.readLine()) != null) {
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
                            leitor.close();

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
