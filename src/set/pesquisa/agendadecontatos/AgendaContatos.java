package set.pesquisa.agendadecontatos;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> contatoSet;

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero) {
        this.contatoSet.add(new Contato(nome, numero));
    }

    public void exibirContatos() {
        System.out.println(this.contatoSet);
    }

    public Set<Contato> pesquisarPorNome(String nome) {
        Set<Contato> contatosPorNome = new HashSet<>();
        for(Contato c : this.contatoSet) {
            if(c.getNome().startsWith(nome)) {
                contatosPorNome.add(c);
            }
        }

        return contatosPorNome;
    }

    public Contato atualizarNumeroContato(String nome, int novoNumero) {
        Contato contatoAtualizado = null;

        for (Contato c : this.contatoSet) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                c.setNumeroTelefone(novoNumero);
                contatoAtualizado = c;
                break;
            }
        }

        return contatoAtualizado;
    }

    public Contato atualizarNumeroContatoPorNumero(int numeroAntigo, int novoNumero) {
        Contato contatoAtualizado = null;

        for (Contato c : this.contatoSet) {
            if (c.getNumeroTelefone() == numeroAntigo) {
                c.setNumeroTelefone(novoNumero);
                contatoAtualizado = c;
                break;
            }
        }

        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.exibirContatos();

        agendaContatos.adicionarContato("Fábio", 12345);
        agendaContatos.adicionarContato("Gustavo", 12345);
        agendaContatos.adicionarContato("Felipe", 12346);
        agendaContatos.adicionarContato("Roger", 12347);
        agendaContatos.adicionarContato("Ana", 12348);

        System.out.println();
        agendaContatos.exibirContatos();

        System.out.println();
        System.out.println(agendaContatos.pesquisarPorNome("Fábio"));

        System.out.println();
        agendaContatos.exibirContatos();

        System.out.println();
        System.out.println("Contato atualizado: " + agendaContatos.atualizarNumeroContatoPorNumero(12345, 12355));

        System.out.println();
        agendaContatos.exibirContatos();
    }
}
