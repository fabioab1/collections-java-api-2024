package list.ordenacao.ordenacaodepessoas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas {
    private List<Pessoa> listaPessoas;

    public OrdenacaoPessoas() {
        this.listaPessoas = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura) {
        this.listaPessoas.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade() {
        List<Pessoa> listaOrdenadaPorIdade = new ArrayList<>(listaPessoas);
        Collections.sort(listaOrdenadaPorIdade);
        return listaOrdenadaPorIdade;
    }

    public List<Pessoa> ordenarPorAltura() {
        List<Pessoa> listaOrdenadaPorAltura = new ArrayList<>(listaPessoas);
        Collections.sort(listaOrdenadaPorAltura, new ComparatorPorAltura());
        return listaOrdenadaPorAltura;
    }

    public static void main(String [] args) {
        OrdenacaoPessoas ordenacaoPessoas = new OrdenacaoPessoas();

        ordenacaoPessoas.adicionarPessoa("Fábio", 19, 1.77);
        ordenacaoPessoas.adicionarPessoa("Isabela", 13, 1.59);
        ordenacaoPessoas.adicionarPessoa("Roger", 22, 1.80);
        ordenacaoPessoas.adicionarPessoa("Laura", 39, 1.66);

        System.out.println(ordenacaoPessoas.listaPessoas);

        System.out.println();

        System.out.println(ordenacaoPessoas.ordenarPorIdade());

        System.out.println();

        System.out.println(ordenacaoPessoas.ordenarPorAltura());
    }
}
