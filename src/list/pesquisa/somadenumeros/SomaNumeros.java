package list.pesquisa.somadenumeros;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    private List<Integer> listaNumeros;

    public SomaNumeros() {
        this.listaNumeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        this.listaNumeros.add(numero);
    }

    public int calcularSoma() {
        int resultado = 0;

        if(!listaNumeros.isEmpty()) {
            for (Integer n : listaNumeros) {
                resultado += n;
            }

            return resultado;
        } else {
            throw new RuntimeException("A lista está vazia.");
        }
    }

    public int encontrarMaiorNumero() {
        if(!listaNumeros.isEmpty()) {
            int maiorNumero = listaNumeros.get(0);

            for (Integer n : listaNumeros) {
                if(n > maiorNumero) {
                    maiorNumero = n;
                }
            }

            return maiorNumero;
        } else {
            throw new RuntimeException("A lista está vazia.");
        }
    }

    public int encontrarMenorNumero() {
        if(!listaNumeros.isEmpty()) {
            int menorNumero = listaNumeros.get(0);

            for (Integer n : listaNumeros) {
                if(n < menorNumero) {
                    menorNumero = n;
                }
            }

            return menorNumero;
        } else {
            throw new RuntimeException("A lista está vazia.");
        }
    }

    public void exibirNumeros() {
        if (!listaNumeros.isEmpty()) {
            System.out.println(this.listaNumeros);
        } else {
            System.out.println("A lista está vazia.");
        }

    }

    public static void main(String [] args) {
        SomaNumeros somaNumeros = new SomaNumeros();

        somaNumeros.adicionarNumero(5);
        somaNumeros.adicionarNumero(14);
        somaNumeros.adicionarNumero(6);
        somaNumeros.adicionarNumero(18);
        somaNumeros.adicionarNumero(43);
        somaNumeros.adicionarNumero(25);
        somaNumeros.adicionarNumero(19);

        System.out.print("Números armazenados na lista: ");
        somaNumeros.exibirNumeros();

        System.out.println();

        System.out.println("O resultado da soma de todos os números da lista é de " + somaNumeros.calcularSoma());

        System.out.println();

        System.out.println("O maior número da lista é " + somaNumeros.encontrarMaiorNumero() + ", enquanto que o menor é " + somaNumeros.encontrarMenorNumero());
    }
}
