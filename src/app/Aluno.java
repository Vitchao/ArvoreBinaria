package app;

import java.util.ArrayList;

public class Aluno  {
    private int matricula;
    private String nome;
    private ArrayList<Disciplina> disciplinasCursadas;

    public Aluno(int matricula, String nome){
        this.matricula = matricula;
        this.nome = nome;
        this.disciplinasCursadas = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Matrícula = "  + this.matricula + ", Nome = " + this.nome;
    }

    public int getMatricula() {
        return this.matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Disciplina> getDisciplinasCursadas() {
        return this.disciplinasCursadas;
    }

    public void setDisciplinasCursadas(Disciplina disciplina) {
        this.disciplinasCursadas.add(disciplina);
    }
}
