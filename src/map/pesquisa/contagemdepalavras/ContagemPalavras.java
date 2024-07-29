package map.pesquisa.contagemdepalavras;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private Map<String, Integer> contagemMap;

    public ContagemPalavras() {
        this.contagemMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem) {
        this.contagemMap.put(palavra, contagem);
    }

    public void removerPalavra(String palavra) {
        if (!this.contagemMap.isEmpty()) {
            this.contagemMap.remove(palavra);
        }
    }

    public void exibirContagemPalavras() {
        System.out.println(this.contagemMap);
    }

    public String encontrarPalavraMaisFrequente() {
        Integer maiorContagem = Integer.MIN_VALUE;
        String palavraMaisFrequente = null;
        if (!this.contagemMap.isEmpty()) {
            for (Map.Entry<String, Integer> entry : contagemMap.entrySet()) {
                if (entry.getValue() > maiorContagem) {
                    maiorContagem = entry.getValue();
                    palavraMaisFrequente = entry.getKey();
                }
            }
        }

        return palavraMaisFrequente;
    }

    public static void main(String[] args) {
        ContagemPalavras contagemPalavras = new ContagemPalavras();

        contagemPalavras.exibirContagemPalavras();
        if (contagemPalavras.encontrarPalavraMaisFrequente() != null) {
            System.out.println("A palavra mais frequente é: " + contagemPalavras.encontrarPalavraMaisFrequente() + ".");
        } else {
            System.out.println("O map está vazio.");
        }

        contagemPalavras.adicionarPalavra("Repolho", 10);
        contagemPalavras.adicionarPalavra("Celular", 2);
        contagemPalavras.adicionarPalavra("PC", 14);
        contagemPalavras.adicionarPalavra("Bolo", 4);
        contagemPalavras.adicionarPalavra("Bolo", 5);
        contagemPalavras.adicionarPalavra("Chocolate", 15);

        System.out.println();
        contagemPalavras.exibirContagemPalavras();
        if (contagemPalavras.encontrarPalavraMaisFrequente() != null) {
            System.out.println("A palavra mais frequente é: " + contagemPalavras.encontrarPalavraMaisFrequente() + ".");
        } else {
            System.out.println("O map está vazio.");
        }

        contagemPalavras.removerPalavra("Celular");
        contagemPalavras.removerPalavra("Chocolate");

        System.out.println();
        contagemPalavras.exibirContagemPalavras();
        if (contagemPalavras.encontrarPalavraMaisFrequente() != null) {
            System.out.println("A palavra mais frequente é: " + contagemPalavras.encontrarPalavraMaisFrequente() + ".");
        } else {
            System.out.println("O map está vazio.");
        }
    }
}