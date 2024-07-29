package map.operacoesbasicas.dicionario;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> dicionarioMap;

    public Dicionario() {
        this.dicionarioMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao) {
        this.dicionarioMap.put(palavra, definicao);
    }

    public void removerPalavra(String palavra) {
        if (!this.dicionarioMap.isEmpty()) {
            this.dicionarioMap.remove(palavra);
        }
    }

    public void exibirPalavras() {
        System.out.println(this.dicionarioMap);
    }

    public String pesquisarPorPalavra(String palavra) {
        String definicao = null;
        if (!this.dicionarioMap.isEmpty()) {
            definicao = this.dicionarioMap.get(palavra);
        }
        return definicao;
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();

        dicionario.exibirPalavras();

        dicionario.adicionarPalavra("Bola", "Objeto de forma redonda.");
        dicionario.adicionarPalavra("Bolo", "Iguaria doce com massa e normalmente recheio e cobertura.");
        dicionario.adicionarPalavra("Bolo", "Iguaria doce com massa.");
        dicionario.adicionarPalavra("Tapete", "Objeto costurado com tecidos para enfeitar lugares.");

        System.out.println();
        dicionario.exibirPalavras();

        dicionario.removerPalavra("Bolo");
        dicionario.removerPalavra("Tapete");

        System.out.println();
        dicionario.exibirPalavras();

        System.out.println();
        System.out.println("A definição da palavra \"Bola\" é: "  + (dicionario.pesquisarPorPalavra("Bola") != null ? dicionario.pesquisarPorPalavra("Bola") : "Palavra não cadastrada!"));

        System.out.println();
        System.out.println("A definição da palavra \"Tapete\" é: " + (dicionario.pesquisarPorPalavra("Tapete") != null ? dicionario.pesquisarPorPalavra("Tapete") : "Palavra não cadastrada!"));
    }

}
