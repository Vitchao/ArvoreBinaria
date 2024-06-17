package app;

import java.util.ArrayList;

public class Disciplina {
    private int codigo;
    private String nome;
    private int cargaHoraria;
    private ArrayList<Disciplina> preRequisitos;

    public Disciplina(int codigo, String nome, int cargaHoraria) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.preRequisitos = new ArrayList<>();
    }

    public String toString() {
        return "Código = " + this.codigo + ", Nome = " + this.nome + ", Carga Horária = " + this.cargaHoraria;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public int getCargaHoraria() {
        return this.cargaHoraria;
    }

    public ArrayList<Disciplina> getPreRequisitos() {
        return this.preRequisitos;
    }

    public void setPreRequisitos(Disciplina disciplina) {
        this.preRequisitos.add(disciplina);
    }
}
