package Questoes;

public class Main {
    public static void main(String[] args) {
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

}