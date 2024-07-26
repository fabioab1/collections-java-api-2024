package list.operacoesbasicas.carrinhodecompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> listaCompras;
    public int variavel;

    public CarrinhoDeCompras() {
        this.listaCompras = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        this.listaCompras.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();

        if (!listaCompras.isEmpty()) {
            for (Item i : listaCompras) {
                if (i.getNome().equalsIgnoreCase(nome)) {
                    itensParaRemover.add(i);
                }
            }
            listaCompras.removeAll(itensParaRemover);
        } else {
            System.out.println("O carrinho está vazio!");
        }
    }

    public double calcularValorTotal() {
        double total = 0;

        if (!listaCompras.isEmpty()) {
            for (Item t : listaCompras) {
                total += t.getPreco();
            }

            return total;
        } else {
            // total = -1;
            throw new RuntimeException("O carrinho está vazio!");
        }

        // return total;
    }

    public void exibirItens() {
        System.out.println(listaCompras);
    }

    public int obterQuantidadeDeProdutosNoCarrinho() {
        return listaCompras.size();
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        /*
        Sem o construtor, eu teria que fazer manualmente no main e depois em cada método, eu teria que implementar uma verificação para saber se o atributo do objeto, que armazena uma lista que armazena
        objetos Item, está vazio ou tem uma lista armazenada nele.
        List<Item> novaLista = new ArrayList<>();
        carrinhoDeCompras.listaCompras = novaLista;
         */

        // System.out.println("Valor total até o momento: " + (carrinhoDeCompras.calcularValorTotal() == -1 ? "O carrinho está vazio." : "R$ " + String.format("%.2f", carrinhoDeCompras.calcularValorTotal())));
        // System.out.println("Valor total até o momento: R$ " + String.format("%.2f", carrinhoDeCompras.calcularValorTotal()));
        System.out.println("Quantidade de produtos no carrinho: " + carrinhoDeCompras.obterQuantidadeDeProdutosNoCarrinho());
        System.out.println("Produtos: ");
        carrinhoDeCompras.exibirItens();

        carrinhoDeCompras.removerItem("Batata");

        System.out.println();

        carrinhoDeCompras.adicionarItem("Berinjela", 5.99, 5);

        System.out.println("Valor total até o momento: R$ " + String.format("%.2f", carrinhoDeCompras.calcularValorTotal()));
        System.out.println("Quantidade de produtos no carrinho: " + carrinhoDeCompras.obterQuantidadeDeProdutosNoCarrinho());
        System.out.println("Produtos: ");
        carrinhoDeCompras.exibirItens();

        System.out.println();

        carrinhoDeCompras.adicionarItem("Tomate", 7.45, 3);
        carrinhoDeCompras.adicionarItem("Batata", 5.00, 12);
        carrinhoDeCompras.adicionarItem("Batata", 5.00, 12);
        carrinhoDeCompras.adicionarItem("Batata", 5.00, 12);

        System.out.println("Valor total até o momento: R$ " + String.format("%.2f", carrinhoDeCompras.calcularValorTotal()));
        System.out.println("Quantidade de produtos no carrinho: " + carrinhoDeCompras.obterQuantidadeDeProdutosNoCarrinho());
        System.out.println("Produtos: ");
        carrinhoDeCompras.exibirItens();

        System.out.println();

        carrinhoDeCompras.removerItem("Batata");

        System.out.println("Valor total até o momento: R$ " + String.format("%.2f", carrinhoDeCompras.calcularValorTotal()));
        System.out.println("Quantidade de produtos no carrinho: " + carrinhoDeCompras.obterQuantidadeDeProdutosNoCarrinho());
        System.out.println("Produtos: ");
        carrinhoDeCompras.exibirItens();
    }
}
