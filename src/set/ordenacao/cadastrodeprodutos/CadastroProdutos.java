package set.ordenacao.cadastrodeprodutos;

import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class CadastroProdutos {
    private Set<Produto> produtoSet;

    public CadastroProdutos() {
        this.produtoSet = new HashSet<>();
    }

    public void adicionarProduto(String nome, long codigo, double preco, int quantidade) {
        this.produtoSet.add(new Produto(nome, codigo, preco, quantidade));
    }

    public Set<Produto> exibirProdutosPorNome() {
        Set<Produto> produtosPorNome = new TreeSet<>(this.produtoSet);
        return produtosPorNome;
    }

    public Set<Produto> exibirProdutosPorPreco() {
        Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());
        produtosPorPreco.addAll(this.produtoSet);
        return produtosPorPreco;
    }

    public static void main(String[] args) {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();

        cadastroProdutos.adicionarProduto("Mouse Gamer", 111352L, 245d, 5);
        cadastroProdutos.adicionarProduto("Processador R5 5600g", 11312L, 437d, 1);
        cadastroProdutos.adicionarProduto("Placa-mãe B500", 114566L, 500d, 1);
        cadastroProdutos.adicionarProduto("Conectores RJ45", 199245L, 567d, 50);

        System.out.println(cadastroProdutos.produtoSet);

        System.out.println();
        System.out.println(cadastroProdutos.exibirProdutosPorNome());

        System.out.println();
        System.out.println(cadastroProdutos.exibirProdutosPorPreco());
    }
}