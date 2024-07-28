package set.ordenacao.listadealunos;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> alunoSet;

    public GerenciadorAlunos() {
        this.alunoSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, long matricula, double nota) {
        this.alunoSet.add(new Aluno(nome, matricula, nota));
    }

    public void removerAluno(long matricula) {
        Aluno aluno = null;

        if (!this.alunoSet.isEmpty()) {
            for (Aluno a : this.alunoSet) {
                if (a.getMatricula() == matricula) {
                    aluno = a;
                }
            }

            this.alunoSet.remove(aluno);
        }
    }

    public Set<Aluno> exibirAlunosPorNome() {
        Set<Aluno> alunosPorNome = new TreeSet<>(this.alunoSet);
        return alunosPorNome;
    }

    public Set<Aluno> exibirAlunosPorNota() {
        Set<Aluno> alunosPorNota = new TreeSet<>(new ComparatorPorNota());
        alunosPorNota.addAll(this.alunoSet);
        return alunosPorNota;
    }

    public void exibirAlunos() {
        System.out.println(this.alunoSet);
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        gerenciadorAlunos.exibirAlunos();
        System.out.println(gerenciadorAlunos.exibirAlunosPorNome());
        System.out.println(gerenciadorAlunos.exibirAlunosPorNota());

        gerenciadorAlunos.adicionarAluno("Aluno 1", 123456L, 7.5);
        gerenciadorAlunos.adicionarAluno("Aluno 2", 123457L, 7.8);
        gerenciadorAlunos.adicionarAluno("Aluno 3", 123457L, 7.9);
        gerenciadorAlunos.adicionarAluno("Aluno 4", 123458L, 10);
        gerenciadorAlunos.adicionarAluno("Aluno 5", 123459L, 9.5);

        System.out.println();
        gerenciadorAlunos.exibirAlunos();
        System.out.println(gerenciadorAlunos.exibirAlunosPorNome());
        System.out.println(gerenciadorAlunos.exibirAlunosPorNota());

        gerenciadorAlunos.removerAluno(123456L);
        gerenciadorAlunos.removerAluno(123458L);

        System.out.println();
        gerenciadorAlunos.exibirAlunos();
        System.out.println(gerenciadorAlunos.exibirAlunosPorNome());
        System.out.println(gerenciadorAlunos.exibirAlunosPorNota());
    }
}
