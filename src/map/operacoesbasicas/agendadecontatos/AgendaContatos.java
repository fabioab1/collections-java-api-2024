package map.operacoesbasicas.agendadecontatos;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> contatoMap;

    public AgendaContatos() {
        this.contatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone) {
        this.contatoMap.put(nome, telefone);
    }

    public void removerContato(String nome) {
        if (!this.contatoMap.isEmpty()) {
            contatoMap.remove(nome);
        }
    }

    public void exibirContatos() {
        System.out.println(contatoMap);
    }

    public Integer pesquisarPorNome(String nome) {
        Integer numeroPorNome = null;
        if (!this.contatoMap.isEmpty()) {
            numeroPorNome = contatoMap.get(nome);
        }

        return numeroPorNome;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.exibirContatos();

        agendaContatos.adicionarContato("Pessoa1", 123456);
        agendaContatos.adicionarContato("Pessoa2", 123457);
        agendaContatos.adicionarContato("Pessoa2", 123458);
        agendaContatos.adicionarContato("Pessoa3", 123459);
        agendaContatos.adicionarContato("Pessoa3", 123460);
        agendaContatos.adicionarContato("Pessoa4", 123461);
        agendaContatos.adicionarContato("Pessoa5", 123461);

        System.out.println();
        agendaContatos.exibirContatos();

        agendaContatos.removerContato("Pessoa1");
        agendaContatos.removerContato("Pessoa4");

        System.out.println();
        agendaContatos.exibirContatos();

        System.out.println();
        System.out.println("O número da \"Pessoa5\" é: " + agendaContatos.pesquisarPorNome("Pessoa5"));
    }
}

