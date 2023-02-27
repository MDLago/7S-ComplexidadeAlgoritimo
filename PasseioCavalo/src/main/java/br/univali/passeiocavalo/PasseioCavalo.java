/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.univali.passeiocavalo;

import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class PasseioCavalo {

    public static void main(String[] args) {
//        Tabuleiro tabuleiro = new Tabuleiro(0,0);
//        ArrayList <Tabuleiro.Posicao> posicoes;
//        posicoes = tabuleiro.buscaMovimentosPossiveis();
//        
//        for (Tabuleiro.Posicao posicoe : posicoes) {
//            System.out.println(posicoe.x + "  " + posicoe.y);
//        }
//        tabuleiro.imprimirTabuleiro();

        EstrategiaTentativaErro tentativaErro = new EstrategiaTentativaErro();
        
        tentativaErro.run();
    }
}
