package set.operacoesbasicas.conjuntodepalavrasunicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavraSet;

    public ConjuntoPalavrasUnicas() {
        this.palavraSet = new HashSet<>();
    }

    public void adicionarPalavra(String palavra) {
        this.palavraSet.add(palavra);
    }

    public void removerPalavra(String palavra) {
        String palavraParaRemover = "";
        if (!this.palavraSet.isEmpty()) {
            for (String p : this.palavraSet) {
                if (p.equalsIgnoreCase(palavra)) {
                    palavraParaRemover = p;
                    break;
                }
            }

            palavraSet.remove(palavraParaRemover);
        }
    }

    public boolean verificarPalavra(String palavra) {
        boolean temAPalavra = false;
        if (!this.palavraSet.isEmpty()) {
            for (String p : this.palavraSet) {
                if (p.equalsIgnoreCase(palavra)) {
                    temAPalavra = true;
                    break;
                }
            }
        }

        return temAPalavra;
    }

    public void exibirPalavrasUnicas() {
        System.out.println(this.palavraSet);
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoPalavras = new ConjuntoPalavrasUnicas();

        System.out.print("As palavras do set são: ");
        conjuntoPalavras.exibirPalavrasUnicas();

        conjuntoPalavras.adicionarPalavra("Jogo");
        conjuntoPalavras.adicionarPalavra("Xbox");
        conjuntoPalavras.adicionarPalavra("Celular");
        conjuntoPalavras.adicionarPalavra("Processador");
        conjuntoPalavras.adicionarPalavra("Placa-mãe");

        System.out.println();
        System.out.print("As palavras do set são: ");
        conjuntoPalavras.exibirPalavrasUnicas();

        System.out.println();
        if (conjuntoPalavras.verificarPalavra("Computador")) {
            System.out.println("A palavra \"Computador\" existe no set");
        } else {
            System.out.println("A palavra \"Computador\" não existe no set");
        }

        conjuntoPalavras.removerPalavra("Celular");
        conjuntoPalavras.removerPalavra("Xbox");

        System.out.println();
        System.out.print("As palavras da lista são: ");
        conjuntoPalavras.exibirPalavrasUnicas();

        conjuntoPalavras.adicionarPalavra("Computador");

        System.out.println();
        System.out.print("As palavras da lista são: ");
        conjuntoPalavras.exibirPalavrasUnicas();

        System.out.println();
        if (conjuntoPalavras.verificarPalavra("Computador")) {
            System.out.println("A palavra \"Computador\" existe no set");
        } else {
            System.out.println("A palavra \"Computador\" não existe no set");
        }
    }
}
