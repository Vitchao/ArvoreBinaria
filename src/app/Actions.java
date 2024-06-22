package app;

import lib.ArvoreBinaria;
import java.util.ArrayList;

public class Actions {
    private ArvoreBinaria<Aluno> alunosMat;
    private ArvoreBinaria<Aluno> alunosNome;
    private ArvoreBinaria<Disciplina> disciplinas;

    public Actions() {
        this.alunosMat = new ArvoreBinaria<Aluno>(new ComparadorAlunoPorMatricula());
        this.alunosNome = new ArvoreBinaria<Aluno>(new ComparadorAlunoPorNome());
        this.disciplinas = new ArvoreBinaria<Disciplina>(new ComparadorDisciplinaPorCodigo());
    }

    public void CadastrarAluno(Aluno aluno) {
        this.alunosNome.adicionar(aluno);
        this.alunosMat.adicionar(aluno);
    }

    public Aluno ConsultarAlunoMatricula(int matricula) {
        return this.alunosMat.pesquisar(new Aluno(matricula, ""));
    }

    public Aluno ConsultarAlunoNome(String nome) {
        return this.alunosNome.pesquisar(new Aluno(0, nome));
    }

    public void CadastrarDisciplina(Disciplina disciplina) {
        this.disciplinas.adicionar(disciplina);
    }

    public Disciplina ConsultarDisciplinaCodigo(int codigo) {
        return this.disciplinas.pesquisar(new Disciplina(codigo, "", 0));
    }

    public Aluno ExcluirAlunoMatricula(Aluno aluno){
        Aluno exAlun = this.ConsultarAlunoNome(aluno.getNome());
        if (exAlun != null) {
            this.alunosNome.remover(exAlun);
        }

        return this.alunosMat.remover(aluno);
    }

    public void InformarPreRequisito(Disciplina dis1, Disciplina dis2) {
        dis2.setPreRequisitos(dis1);
    }

    public void InformarDisciplinaCursada(Aluno aluno, Disciplina disciplina) {
        aluno.setDisciplinasCursadas(disciplina);
    }

    public String DetalhesAluno(Aluno aluno) {
        String infAluno = "Nome - " + aluno.getNome() + "\nMatrícula - " + aluno.getMatricula() + "\n\nDisciplinas Cursadas:\n";
        for(Disciplina disciplina : aluno.getDisciplinasCursadas()) {
            infAluno += disciplina.toString() + ";\n";
        }

        return infAluno;
    }

    public String toStringDisciplinas() {
        return this.disciplinas.caminharEmOrdem();
    }

    public String toStringAlunos() {
        return this.alunosMat.caminharEmOrdem();
    }
}
