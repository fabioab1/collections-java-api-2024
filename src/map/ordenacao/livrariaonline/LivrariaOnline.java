package map.ordenacao.livrariaonline;

import java.util.*;

public class LivrariaOnline {
    private Map<String, Livro> livroMap;

    public LivrariaOnline() {
        this.livroMap = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco) {
        Livro livro = new Livro(titulo, autor, preco);
        this.livroMap.put(link, livro);
    }

    public void removerLivro(String titulo) {
        String linkParaRemover = null;

        if (!this.livroMap.isEmpty()) {

            for (Map.Entry<String, Livro> entry : this.livroMap.entrySet()) {

                String tituloLivro = entry.getValue().getTitulo();
                String linkLivro = entry.getKey();

                if (tituloLivro.equalsIgnoreCase(titulo)) {
                    linkParaRemover = linkLivro;
                }
            }

            this.livroMap.remove(linkParaRemover);
        }
    }

    public void exibirLivros() {
        System.out.println(this.livroMap);
    }

    public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {
        List<Map.Entry<String, Livro>> livrosPorPrecoList = new ArrayList<>(this.livroMap.entrySet());

        livrosPorPrecoList.sort(new ComparatorPorPreco());

        Map<String, Livro> livrosPorPreco = new LinkedHashMap<>();

        for(Map.Entry<String, Livro> entry : livrosPorPrecoList) {
            livrosPorPreco.put(entry.getKey(), entry.getValue());
        }

        return livrosPorPreco;
    }

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
        Map<String, Livro> livrosPorAutor = new HashMap<>();

        if (!this.livroMap.isEmpty()) {
            for (Map.Entry<String, Livro> entry : this.livroMap.entrySet()) {

                String autorLivro = entry.getValue().getAutor();
                String link = entry.getKey();
                Livro livro = entry.getValue();

                if (autorLivro.equalsIgnoreCase(autor)) {
                    livrosPorAutor.put(link, livro);
                }
            }
        }

        return livrosPorAutor;
    }

    public Livro obterLivroMaisCaro() {
        Livro livroMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;

        if (!this.livroMap.isEmpty()) {
            for (Livro l : this.livroMap.values()) {
                if (l.getPreco() > maiorPreco) {
                    maiorPreco = l.getPreco();
                    livroMaisCaro = l;
                }
            }
        }

        return livroMaisCaro;
    }

    public Livro exibirLivroMaisBarato() {
        Livro livroMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;

        if (!this.livroMap.isEmpty()) {
            for (Livro l : this.livroMap.values()) {
                if (l.getPreco() < menorPreco) {
                    menorPreco = l.getPreco();
                    livroMaisBarato = l;
                }
            }
        }

        return livroMaisBarato;
    }

    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();

        System.out.println(livrariaOnline.exibirLivrosOrdenadosPorPreco());
        livrariaOnline.exibirLivros();

        livrariaOnline.adicionarLivro("link1", "Livro 1", "Autor 1", 15d);
        livrariaOnline.adicionarLivro("link2", "Livro 2", "Autor 1", 18d);
        livrariaOnline.adicionarLivro("link3", "Livro 3", "Autor 2", 11d);
        livrariaOnline.adicionarLivro("link4", "Livro 4", "Autor 1", 20d);
        livrariaOnline.adicionarLivro("link4", "Livro 5", "Autor 3", 21d);
        livrariaOnline.adicionarLivro("link5", "Livro 6", "Autor 3", 22d);
        livrariaOnline.adicionarLivro("link5", "Livro 7", "Autor 4", 10d);
        livrariaOnline.adicionarLivro("link6", "Livro 8", "Autor 4", 9d);
        livrariaOnline.adicionarLivro("link7", "Livro 9", "Autor 5", 16d);

        System.out.println();
        System.out.println(livrariaOnline.exibirLivrosOrdenadosPorPreco());
        livrariaOnline.exibirLivros();
        System.out.println("Livros do \"Autor 1\": " + livrariaOnline.pesquisarLivrosPorAutor("Autor 1"));
        System.out.println("Livro mais caro da Livraria: " + livrariaOnline.obterLivroMaisCaro());
        System.out.println("Livro mais barato da Livraria: " + livrariaOnline.exibirLivroMaisBarato());

        livrariaOnline.removerLivro("Livro 1");
        livrariaOnline.removerLivro("Livro 5");

        System.out.println();
        System.out.println(livrariaOnline.exibirLivrosOrdenadosPorPreco());
        livrariaOnline.exibirLivros();
        System.out.println("Livros do \"Autor 1\": " + livrariaOnline.pesquisarLivrosPorAutor("Autor 1"));
        System.out.println("Livro mais caro da Livraria: " + livrariaOnline.obterLivroMaisCaro());
        System.out.println("Livro mais barato da Livraria: " + livrariaOnline.exibirLivroMaisBarato());
    }
}