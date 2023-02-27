/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univali.passeiocavalo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author marco
 */
public class EstrategiaPelasBordas {
    public final int totalMovimentosNecessarios = 64;
    public static Tabuleiro tabuleiro;
    public static int iteracoes = 0;
    public static int movimentosValidos = 0;
    private int pesoTabuleiro[][];
    
    public void run(){
        Long antes,depois;
        tabuleiro = new Tabuleiro(0, 0);
        populaPesoTabuleiro();
        
        System.out.println("\n\nPosição Inicial, X:"+tabuleiro.posicaoCavalo.x + "  Y:" + tabuleiro.posicaoCavalo.y);
        antes = System.currentTimeMillis();
        executaEstrategia(tabuleiro.posicaoCavalo);
        depois = System.currentTimeMillis();
        System.out.println("\nTempo de execução: " + (depois-antes) + "ms");
        System.out.println("Iterações realizadas: "+ iteracoes);
        System.out.println("Movimentos Validos: " + movimentosValidos);
        tabuleiro.imprimirTabuleiro();
    }
    
    public boolean executaEstrategia(Posicao posicaoAtual){
        iteracoes++;
        ArrayList<Posicao> movimentosPossiveis = tabuleiro.buscaMovimentosPossiveis(posicaoAtual);
        movimentosPossiveis.sort((a, b) -> pesoTabuleiro[a.x][a.y] - pesoTabuleiro[b.x][b.y]);
        
        /*System.out.println("Posição atual, X:" + posicaoAtual.x + "  Y:" + posicaoAtual.y);
        System.out.println("Iterações realizadas: "+ iteracoes);
        System.out.println("Movimentos Validos: " + movimentosValidos);*/
 
        /*tabuleiro.imprimirTabuleiro();
        System.out.println("\n");*/
        
        //tabuleiro.imprimirMovimentosPossiveis(posicaoAtual);
        
        movimentosValidos++;
    	tabuleiro.tabuleiro[posicaoAtual.x][posicaoAtual.y] = movimentosValidos;
        
        if(movimentosPossiveis.isEmpty() && movimentosValidos == totalMovimentosNecessarios){
            return true;
        }
    	
        for (Posicao posicao : movimentosPossiveis) {
			if(executaEstrategia(posicao)) {
				return true;
			}
		}
        
        movimentosValidos--;
        tabuleiro.tabuleiro[posicaoAtual.x][posicaoAtual.y] = 0;
               
        return false;
    }

    public void populaPesoTabuleiro() {
    	pesoTabuleiro = new int[tabuleiro.tamanho][tabuleiro.tamanho];
    	ArrayList<Posicao> pesos = new ArrayList<>();
    	Posicao posicao;
    	
    	for (int i = 0; i < tabuleiro.tamanho; i++) {
			for (int j = 0; j < tabuleiro.tamanho; j++) {
				posicao = new Posicao(i, j);
				pesos = tabuleiro.buscaMovimentosPossiveis(posicao);
				
				pesoTabuleiro[i][j] = pesos.size();
				
			}
		}
    	//imprimirPesoTabuleiro();
    }
    
    public void imprimirPesoTabuleiro(){
        for (int i = 0; i < tabuleiro.tamanho; i++) {
            for (int j = 0; j < tabuleiro.tamanho; j++) {
                System.out.print(pesoTabuleiro[i][j]+"\t");
            }
            System.out.print("\n");
        }
    }
}

