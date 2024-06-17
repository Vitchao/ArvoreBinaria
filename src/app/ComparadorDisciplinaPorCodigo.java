package app;

import java.util.Comparator;

public class ComparadorDisciplinaPorCodigo implements Comparator<Disciplina> {
    @Override
    public int compare(Disciplina disc1, Disciplina disc2) {
        return Integer.compare(disc1.getCodigo(), disc2.getCodigo());
    }
}
