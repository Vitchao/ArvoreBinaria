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
        No<T> novoNo = new No<T>(novoValor);

        if (this.raiz == null){
            this.raiz = novoNo;
        } else {
            No<T> atualNo = this.raiz;
            boolean inserido = false;

            while(!inserido) {
                //Novo No é menor do que o No Atual -> Novo Filho Esquerda
                if (comparador.compare(novoNo.getValor(), atualNo.getValor()) < 0) {
                    if (atualNo.getFilhoEsquerda() == null) {
                        inserido = true;
                        atualNo.setFilhoEsquerda(novoNo);
                    } else {
                        atualNo = atualNo.getFilhoEsquerda();
                    }
                }
                //Novo No é maior do que o NO Atual -> Novo Filho Direita
                else {
                    if (atualNo.getFilhoDireita() == null) {
                        inserido = true;
                        atualNo.setFilhoDireita(novoNo);
                    } else {
                        atualNo = atualNo.getFilhoDireita();
                    }
                }
            }
        }
    }

    @Override
    public T pesquisar(T valor) {
        if (valor == null) {
            return null;
        } else {
            return pesquisarRecursivo(valor, this.raiz,this.comparador);
        }
    }

    @Override
    public T pesquisar(T valor, Comparator comparador) {
        if (valor == null) {
            return null;
        } else  {
            return pesquisarRecursivo(valor, this.raiz, comparador);
        }
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
        No<T> noRetorno = new No<>(null);
        this.raiz = removerRecursivo(this.raiz, valor, noRetorno);

        return noRetorno.getValor();
    }

    protected No<T> removerRecursivo(No<T> no, T valor, No<T> noRetorno) {
        if (no == null) {
            return null;
        }

        int comparacao = comparador.compare(valor, no.getValor());
        if (comparacao < 0) {
            no.setFilhoEsquerda(removerRecursivo(no.getFilhoEsquerda(), valor, noRetorno));
        } else if (comparacao > 0) {
            no.setFilhoDireita(removerRecursivo(no.getFilhoDireita(), valor, noRetorno));
        } else {
            noRetorno.setValor(no.getValor());
            if (no.getFilhoEsquerda() == null && no.getFilhoDireita() == null) {
                return null;
            }
            else if (no.getFilhoEsquerda() == null) {
                return no.getFilhoDireita();
            } else if (no.getFilhoDireita() == null) {
                return no.getFilhoEsquerda();
            }
            else {
                No<T> minimo = encontrarMinimo(no.getFilhoDireita());
                no.setValor(minimo.getValor());
                no.setFilhoDireita(removerRecursivo(no.getFilhoDireita(), minimo.getValor(), new No<T>(null)));
            }
        }
        return raiz;
    }

    private No<T> encontrarMinimo(No<T> no) {
        while (no.getFilhoEsquerda() != null) {
            no = no.getFilhoEsquerda();
        }
        //Retornando menor nó
        return no;
    }

    @Override
    public int altura() {
        return altura(this.raiz);
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
        return quantidadeNos(this.raiz);
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
        ArrayList<No<T>> fila = new ArrayList<No<T>>();
        String nivelNos = "";

        if (this.raiz == null) {
            nivelNos = "[]";
        } else {
            No<T> atualNo;

            fila.add(this.raiz);
            nivelNos = "[";
            while (fila.size() > 0 ) {
                atualNo = fila.getFirst();
                nivelNos += atualNo.getValor() + "\n";

                fila.removeFirst();

                if (atualNo.getFilhoEsquerda() != null) {
                    fila.add(atualNo.getFilhoEsquerda());
                }

                if (atualNo.getFilhoDireita() != null) {
                    fila.add(atualNo.getFilhoDireita());
                }
            }
            nivelNos += "]";
        }
        return nivelNos;
    }

    @Override
    public String caminharEmOrdem() {
        StringBuilder nivelOrdem = new StringBuilder();

        nivelOrdem.append("[\n");
        caminharEmOrdem(this.raiz, nivelOrdem);
        nivelOrdem.append("]");;

        return nivelOrdem.toString().trim();
    }

    private void caminharEmOrdem(No<T> raiz, StringBuilder nivelOrdem) {
        if (raiz != null) {
            caminharEmOrdem(raiz.getFilhoEsquerda(), nivelOrdem);
            nivelOrdem.append(raiz.getValor());
            nivelOrdem.append("\n");
            caminharEmOrdem(raiz.getFilhoDireita(), nivelOrdem);
        }
    }
}