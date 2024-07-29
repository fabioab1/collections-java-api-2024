package map.pesquisa.estoquedeprodutoscompreco;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {
    private Map<Long, Produto> produtoMap;

    public EstoqueProdutos() {
        this.produtoMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco) {
        this.produtoMap.put(cod, new Produto(nome, quantidade, preco));
    }

    public void exibirProdutos() {
        System.out.println(this.produtoMap);
    }

    public double calcularValorTotalEstoque() {
        double valorTotal = 0;
        if (!produtoMap.isEmpty()) {
            for(Produto p : this.produtoMap.values()) {
                valorTotal += p.getPreco() * p.getQuantidade();
            }
        }
        return valorTotal;
    }

    public Produto obterProdutoMaisCaro() {
        Produto produtoMaisCaro = null;
        double valorProdutoMaisCaro = Double.MIN_VALUE;
        if (!this.produtoMap.isEmpty()) {
            for (Produto p : this.produtoMap.values()) {
                if (p.getPreco() > valorProdutoMaisCaro) {
                    valorProdutoMaisCaro = p.getPreco();
                    produtoMaisCaro = p;
                }
            }
        }

        return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato() {
        Produto produtoMaisBarato = null;
        double valorProdutoMaisBarato = Double.MAX_VALUE;
        if (!this.produtoMap.isEmpty()) {
            for (Produto p : this.produtoMap.values()) {
                if (p.getPreco() < valorProdutoMaisBarato) {
                    valorProdutoMaisBarato = p.getPreco();
                    produtoMaisBarato = p;
                }
            }
        }

        return produtoMaisBarato;
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        Produto maiorProduto = null;
        double valorQuantidade = Double.MIN_VALUE;
        if (!this.produtoMap.isEmpty()) {
            for (Produto p : this.produtoMap.values()) {
                double valor = p.getPreco() * p.getQuantidade();
                if (valor > valorQuantidade) {
                    valorQuantidade = valor;
                    maiorProduto = p;
                }
            }
        }
        return maiorProduto;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoqueProdutos = new EstoqueProdutos();

        estoqueProdutos.exibirProdutos();
        System.out.println("Valor total do estoque: R$ " + String.format("%.2f", estoqueProdutos.calcularValorTotalEstoque()));
        System.out.println("Produto mais caro: " + (estoqueProdutos.obterProdutoMaisCaro() != null ? estoqueProdutos.obterProdutoMaisCaro() : "O estoque está vazio."));
        System.out.println("Produto mais barato: " + (estoqueProdutos.obterProdutoMaisBarato() != null ? estoqueProdutos.obterProdutoMaisBarato() : "O estoque está vazio."));
        System.out.println("Produto de maior valor considerando a quantidade: " + (estoqueProdutos.obterProdutoMaiorQuantidadeValorTotalNoEstoque() != null ? estoqueProdutos.obterProdutoMaiorQuantidadeValorTotalNoEstoque() : "O estoque está vazio."));

        estoqueProdutos.adicionarProduto(25112L, "Mouse Gamer", 5, 120d);
        estoqueProdutos.adicionarProduto(21424L, "Máquina de lavar", 10, 1800d);
        estoqueProdutos.adicionarProduto(21423L, "Smartphone celular", 5, 1900d);
        estoqueProdutos.adicionarProduto(15527L, "Corrente de bicicleta", 40, 35d);
        estoqueProdutos.adicionarProduto(52783L, "Mochila viajante Japonesa", 35, 35d);

        System.out.println();
        estoqueProdutos.exibirProdutos();
        System.out.println("Valor total do estoque: R$ " + String.format("%.2f", estoqueProdutos.calcularValorTotalEstoque()));
        System.out.println("Produto mais caro: " + (estoqueProdutos.obterProdutoMaisCaro() != null ? estoqueProdutos.obterProdutoMaisCaro() : "O estoque está vazio."));
        System.out.println("Produto mais barato: " + (estoqueProdutos.obterProdutoMaisBarato() != null ? estoqueProdutos.obterProdutoMaisBarato() : "O estoque está vazio."));
        System.out.println("Produto de maior valor considerando a quantidade: " + (estoqueProdutos.obterProdutoMaiorQuantidadeValorTotalNoEstoque() != null ? estoqueProdutos.obterProdutoMaiorQuantidadeValorTotalNoEstoque() : "O estoque está vazio."));
    }
}
