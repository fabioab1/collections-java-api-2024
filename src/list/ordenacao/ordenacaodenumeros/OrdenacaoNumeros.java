package list.ordenacao.ordenacaodenumeros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {
    private List<Integer> ordenacaoNumeros;

    public OrdenacaoNumeros() {
        this.ordenacaoNumeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        this.ordenacaoNumeros.add(numero);
    }

    public List<Integer> ordenarAscendente() {
        List<Integer> listaAscendente = new ArrayList<>(this.ordenacaoNumeros);
        if (!this.ordenacaoNumeros.isEmpty()) {
            Collections.sort(listaAscendente);
            return listaAscendente;
        } else {
            throw new RuntimeException("A lista está vazia.");
        }
    }

    public List<Integer> ordenarDescendente() {
        List<Integer> listaAscendente = new ArrayList<>(this.ordenacaoNumeros);
        if (!this.ordenacaoNumeros.isEmpty()) {
            listaAscendente.sort(Collections.reverseOrder());
//            Collections.sort(listaAscendente); // Modo que eu fiz
//            Collections.reverse(listaAscendente);
            return listaAscendente;
        } else {
            throw new RuntimeException("A lista está vazia.");
        }
    }

    public static void main(String[] args) {
        OrdenacaoNumeros listaNumeros = new OrdenacaoNumeros();

        listaNumeros.adicionarNumero(23);
        listaNumeros.adicionarNumero(14);
        listaNumeros.adicionarNumero(7);
        listaNumeros.adicionarNumero(8);
        listaNumeros.adicionarNumero(4);
        listaNumeros.adicionarNumero(37);
        listaNumeros.adicionarNumero(28);

        System.out.println(listaNumeros.ordenacaoNumeros);

        System.out.println();

        System.out.println(listaNumeros.ordenarAscendente());

        System.out.println();

        System.out.println(listaNumeros.ordenarDescendente());
    }

}
