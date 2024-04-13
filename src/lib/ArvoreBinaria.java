package lib;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.*;

public class ArvoreBinaria<T> implements IArvoreBinaria<T> {
    protected No<T> raiz = null;
    protected Comparator<T> comparador;

    public ArvoreBinaria(Comparator<T> comp) {
        comparador = comp;
    }

    @Override
    public void adicionar(T novoValor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T pesquisar(T valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T pesquisar(T valor, Comparator comparador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private T pesquisarRecursivo(T valor, No<T> no, Comparator comparador) {
        if (no == null) {
            return null;
        } else {
            int comparacao = comparador.compare(valor, no.getValor());

            if (comparacao == 0) {
                return no.getValor();
            } else if (comparacao < 0) {
                return pesquisarRecursivo(valor, no.getFilhoEsquerda(), comparador);
            } else {
                return pesquisarRecursivo(valor, no.getFilhoDireita(), comparador);
            }
        }
    }

    @Override
    public T remover(T valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int altura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int altura(No<T> no) {
        int alt = -1;
        if (no != null){
            if (no.getFilhoEsquerda() == null && no.getFilhoDireita() == null) {
                alt = 0;
            } else {
                int filhoEsq = altura(no.getFilhoEsquerda());
                int filhoDir = altura(no.getFilhoDireita());

                alt = Math.max(filhoEsq, filhoDir) + 1;
            }
        }

        return alt;
    }

    @Override
    public int quantidadeNos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int quantidadeNos(No<T> no) {
        int quant = 0;

        if (no != null) {
            quant = quantidadeNos(no.getFilhoEsquerda()) + quantidadeNos(no.getFilhoDireita()) + 1;
        }

        return quant;
    }

    @Override
    public String caminharEmNivel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String caminharEmOrdem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void caminharEmOrdem(No<T> raiz, String nivelOrdem) {
        if (raiz != null) {
            caminharEmOrdem(raiz.getFilhoEsquerda(), nivelOrdem);
            nivelOrdem += raiz.getValor() + "\n";
            caminharEmOrdem(raiz.getFilhoDireita(), nivelOrdem);
        }
    }
}
