package app;

import lib.ArvoreAVL;
import lib.ArvoreBinaria;
import lib.IArvoreBinaria;

public class AppRelatorioAVL {
    public static void main(String[] args) {

        GeradorDeArvores gerador = new GeradorDeArvores();
        ComparadorAlunoPorMatricula comparador = new ComparadorAlunoPorMatricula();
        IArvoreBinaria<Aluno> arv;

        arv = new ArvoreAVL(comparador);
        gerador.geraArvoreDegenerada(100, arv);
        System.out.println("Árvore AVL Criada");
        System.out.println("Quantidade de Nós: " + arv.quantidadeNos()+ " Altura: " + arv.altura());
        arv = new ArvoreBinaria(comparador);
        gerador.geraArvoreDegenerada(100, arv);
        System.out.println("Árvore Degenerada Criada");
        System.out.println("Quantidade de Nós: " + arv.quantidadeNos()+ " Altura: " + arv.altura());

        arv = new ArvoreAVL(comparador);
        gerador.geraArvoreDegenerada(1000, arv);
        System.out.println("Árvore AVL Criada");
        System.out.println("Quantidade de Nós: " + arv.quantidadeNos()+ " Altura: " + arv.altura());
        arv = new ArvoreBinaria(comparador);
        gerador.geraArvoreDegenerada(1000, arv);
        System.out.println("Árvore Degenerada Criada");
        System.out.println("Quantidade de Nós: " + arv.quantidadeNos()+ " Altura: " + arv.altura());

        arv = new ArvoreAVL(comparador);
        gerador.geraArvoreDegenerada(10000, arv);
        System.out.println("Árvore AVL Criada");
        System.out.println("Quantidade de Nós: " + arv.quantidadeNos()+ " Altura: " + arv.altura());
        arv = new ArvoreBinaria(comparador);
        gerador.geraArvoreDegenerada(10000, arv);
        System.out.println("Árvore Degenerada Criada");
        System.out.println("Quantidade de Nós: " + arv.quantidadeNos()+ " Altura: " + arv.altura());


    }
}
