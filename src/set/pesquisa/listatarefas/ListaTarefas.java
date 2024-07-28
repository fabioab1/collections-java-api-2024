package set.pesquisa.listatarefas;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> tarefaSet;

    public ListaTarefas() {
        this.tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        this.tarefaSet.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        Tarefa tarefaParaRemover = null;

        for (Tarefa t : this.tarefaSet) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                tarefaParaRemover = t;
                break;
            }
        }

        this.tarefaSet.remove(tarefaParaRemover);
    }

    public void exibirTarefas() {
        System.out.println(this.tarefaSet);
    }

    public int contarTarefas() {
        return this.tarefaSet.size();
    }

    public Set<Tarefa> obterTarefasConcluidas() {
        Set<Tarefa> tarefasConcluidas = new HashSet<>();

        for (Tarefa t : this.tarefaSet) {
            if (t.isConcluida()) {
                tarefasConcluidas.add(t);
            }
        }

        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefasPendentes = new HashSet<>();

        for (Tarefa t : this.tarefaSet) {
            if (!t.isConcluida()) {
                tarefasPendentes.add(t);
            }
        }

        return tarefasPendentes;
    }

    public void marcarTarefaConcluida(String descricao) {
        for (Tarefa t : this.tarefaSet) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                t.setConcluida(true);
                break;
            }
        }
    }

    public void marcarTarefaPendente(String descricao) {
        for (Tarefa t : this.tarefaSet) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                t.setConcluida(false);
                break;
            }
        }
    }

    public void limparListaTarefas() {
        this.tarefaSet.removeAll(tarefaSet);
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        System.out.println();
        listaTarefas.exibirTarefas();
        System.out.println("Quantidade de tarefas da lista: " + listaTarefas.contarTarefas());
        System.out.print("Tarefas concluídas: ");
        System.out.println(listaTarefas.obterTarefasConcluidas());
        System.out.print("Tarefas pendentes: ");
        System.out.println(listaTarefas.obterTarefasPendentes());

        listaTarefas.adicionarTarefa("Lavar o quintal");
        listaTarefas.adicionarTarefa("Limpar o PC");
        listaTarefas.adicionarTarefa("Limpar o teclado");
        listaTarefas.adicionarTarefa("Limpar o teclado");
        listaTarefas.adicionarTarefa("Fazer a atividade do Bootcamp");
        listaTarefas.adicionarTarefa("Fazer a atividade do Bootcamp");

        System.out.println();
        listaTarefas.exibirTarefas();
        System.out.println("Quantidade de tarefas da lista: " + listaTarefas.contarTarefas());
        System.out.print("Tarefas concluídas: ");
        System.out.println(listaTarefas.obterTarefasConcluidas());
        System.out.print("Tarefas pendentes: ");
        System.out.println(listaTarefas.obterTarefasPendentes());

        listaTarefas.removerTarefa("Lavar o quintal");
        listaTarefas.removerTarefa("Fazer a atividade do Bootcamp");

        System.out.println();
        listaTarefas.exibirTarefas();
        System.out.println("Quantidade de tarefas da lista: " + listaTarefas.contarTarefas());
        System.out.print("Tarefas concluídas: ");
        System.out.println(listaTarefas.obterTarefasConcluidas());
        System.out.print("Tarefas pendentes: ");
        System.out.println(listaTarefas.obterTarefasPendentes());

        listaTarefas.marcarTarefaConcluida("Limpar o PC");
        listaTarefas.marcarTarefaConcluida("Limpar o teclado");

        System.out.println();
        listaTarefas.exibirTarefas();
        System.out.println("Quantidade de tarefas da lista: " + listaTarefas.contarTarefas());
        System.out.print("Tarefas concluídas: ");
        System.out.println(listaTarefas.obterTarefasConcluidas());
        System.out.print("Tarefas pendentes: ");
        System.out.println(listaTarefas.obterTarefasPendentes());

        listaTarefas.marcarTarefaPendente("Limpar o PC");
        listaTarefas.marcarTarefaPendente("Limpar o teclado");

        System.out.println();
        listaTarefas.exibirTarefas();
        System.out.println("Quantidade de tarefas da lista: " + listaTarefas.contarTarefas());
        System.out.print("Tarefas concluídas: ");
        System.out.println(listaTarefas.obterTarefasConcluidas());
        System.out.print("Tarefas pendentes: ");
        System.out.println(listaTarefas.obterTarefasPendentes());

        listaTarefas.limparListaTarefas();

        System.out.println();
        listaTarefas.exibirTarefas();
        System.out.println("Quantidade de tarefas da lista: " + listaTarefas.contarTarefas());
        System.out.print("Tarefas concluídas: ");
        System.out.println(listaTarefas.obterTarefasConcluidas());
        System.out.print("Tarefas pendentes: ");
        System.out.println(listaTarefas.obterTarefasPendentes());
    }
}
