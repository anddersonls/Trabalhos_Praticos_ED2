import java.util.Arrays;

public class Questao3<T extends Number>{
    public T[] distanciaTa(T[] v, T value) {
        int n = v.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double diferenca = v[i].doubleValue() - v[j].doubleValue();
                if (Math.abs(diferenca) == value.doubleValue()) {
                    T[] resultado = (T[]) new Number[]{v[i], v[j]};
                    return resultado;
                }
            }
        }
        return null;
    }

    public T[] distanciaTb(T[] v, T value) {
        // Ordene o vetor imediatamente
        Arrays.sort(v);

        for (int i = 0; i < v.length; i++) {
            double diferenca = v[i].doubleValue() - value.doubleValue();
            int pesquisa = BuscaBinaria(v, diferenca);
            if (pesquisa != -1) {
                T[] resultado = (T[]) new Number[]{v[i], v[pesquisa]};
                return resultado;
            }

            double diferenca2 = v[i].doubleValue() + value.doubleValue();
            int pesquisa2 = BuscaBinaria(v, diferenca2);
            if (pesquisa2 != -1) {
                T[] resultado = (T[]) new Number[]{v[i], v[pesquisa]};
                return resultado;
            }
        }
        return null;
    }

    public int BuscaBinaria(T[] vetor, double elemento) {
        int inicio = 0;
        int fim = vetor.length - 1;
        int meio;
        while (inicio <= fim) {
            meio = (inicio + fim) / 2;
            double valorMeio = vetor[meio].doubleValue();
            if (valorMeio == elemento) {
                return meio;
            } else if (elemento > valorMeio) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }
}

