package set.operacoesbasicas.conjuntodeconvidados;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
    private Set<Convidado> convidadoSet;

    public ConjuntoConvidados() {
        this.convidadoSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int codigoConvite) {
        convidadoSet.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite) {
        Convidado convidadoParaRemover = null;

        for (Convidado c : this.convidadoSet) {
            if(c.getCodigoConvite() == codigoConvite) {
                convidadoParaRemover = c;
                break;
            }
        }

        convidadoSet.remove(convidadoParaRemover);
    }

    public int contarConvidados() {
        return this.convidadoSet.size();
    }

    public void exibirConvidados() {
        System.out.println(this.convidadoSet);
    }

    public static void main(String[] args) {
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();
        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidados no Set de convidados.");

        conjuntoConvidados.adicionarConvidado("Fábio", 0);
        conjuntoConvidados.adicionarConvidado("Convidado 2", 1);
        conjuntoConvidados.adicionarConvidado("Convidado 3", 2);
        conjuntoConvidados.adicionarConvidado("Convidado 4", 3);

        System.out.println();
        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidados no Set de convidados.");
        conjuntoConvidados.exibirConvidados();

        conjuntoConvidados.removerConvidadoPorCodigoConvite(2);

        System.out.println();
        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidados no Set de convidados.");
        conjuntoConvidados.exibirConvidados();

        conjuntoConvidados.adicionarConvidado("Convidado 5", 4);

        System.out.println();
        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidados no Set de convidados.");
        conjuntoConvidados.exibirConvidados();

        conjuntoConvidados.adicionarConvidado("Convidado 5", 3);

        System.out.println();
        System.out.println("Existem " + conjuntoConvidados.contarConvidados() + " convidados no Set de convidados.");
        conjuntoConvidados.exibirConvidados();
    }
}
