/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univali.passeiocavalo;

import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class EstrategiaTentativaErro {
    public final int totalMovimentosNecessarios = 64;
    public static Tabuleiro tabuleiro;
    public static int iteracoes = 0;
    public static int movimentosValidos = 0;
    
    public void run(){
        Long antes,depois;
        tabuleiro = new Tabuleiro(0, 0);
        
        antes = System.currentTimeMillis();
        executaEstrategia(tabuleiro.posicaoCavalo);
        depois = System.currentTimeMillis();
        System.out.println("\nTempo de execução: " + (depois-antes) + "ms");
        System.out.println("Iterações realizadas: "+ iteracoes);
        System.out.println("Movimentos Validos: " + movimentosValidos);
        tabuleiro.imprimirTabuleiro();
    }
    
    public boolean executaEstrategia(Tabuleiro.Posicao posicaoAtual){
        iteracoes++;
        ArrayList<Tabuleiro.Posicao> movimentosPossiveis = tabuleiro.buscaMovimentosPossiveis(posicaoAtual);
        
        System.out.println("Posição atual, X:" + posicaoAtual.x + "  Y:" + posicaoAtual.y);
        System.out.println("Iterações realizadas: "+ iteracoes);
        System.out.println("Movimentos Validos: " + movimentosValidos);
 
        tabuleiro.imprimirTabuleiro();
        System.out.println("\n");
        
        tabuleiro.imprimirMovimentosPossiveis(posicaoAtual);
        
        
        if(movimentosPossiveis.isEmpty() && movimentosValidos == totalMovimentosNecessarios-1){
            movimentosValidos++;
            tabuleiro.tabuleiro[posicaoAtual.x][posicaoAtual.y] = movimentosValidos;
            return true;
        }
        
        if(movimentosValidos > totalMovimentosNecessarios){
            movimentosValidos--;
            tabuleiro.tabuleiro[posicaoAtual.x][posicaoAtual.y] = 0; 
            return false;
        }
        
        if(tabuleiro.tabuleiro[posicaoAtual.x][posicaoAtual.y] != 0){
            movimentosValidos--;
            return false;
        }
        
        if(movimentosPossiveis.isEmpty()){
            tabuleiro.tabuleiro[posicaoAtual.x][posicaoAtual.y] = 0;
            return false;
        }
        
        if(!movimentosPossiveis.isEmpty() && movimentosValidos < totalMovimentosNecessarios){
            movimentosValidos ++;
            tabuleiro.tabuleiro[posicaoAtual.x][posicaoAtual.y] = movimentosValidos;
            
            if(executaEstrategia(movimentosPossiveis.remove(0))){
                return true;
            }else{
                movimentosValidos--;
                tabuleiro.tabuleiro[posicaoAtual.x][posicaoAtual.y] = 0; 
                if(movimentosPossiveis.isEmpty()){
                    return false;
                }
                else{
                    return executaEstrategia(movimentosPossiveis.remove(0));
                }
                
            }  
        }
        
        return false;
    }
}
