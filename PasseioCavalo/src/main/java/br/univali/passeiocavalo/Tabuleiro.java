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
public class Tabuleiro {
    
    public final int tamanho = 8;
    public ArrayList<Posicao> movimentoCavalo = new ArrayList<>();
    public Posicao posicaoCavalo;
    public int tabuleiro[][];
    
    public Tabuleiro(int xCavalo, int yCavalo){
        definirMovimentosCavalo();
        tabuleiro = new int [tamanho][tamanho];
        inicializaTabuleiro();
        posicaoCavalo = new Posicao(xCavalo,yCavalo);
    }
    
    public final void definirMovimentosCavalo(){
        this.movimentoCavalo.add(new Posicao(1,-2));
        this.movimentoCavalo.add(new Posicao(2,-1));
        this.movimentoCavalo.add(new Posicao(2,1));
        this.movimentoCavalo.add(new Posicao(1,2));
        this.movimentoCavalo.add(new Posicao(-1,2));
        this.movimentoCavalo.add(new Posicao(-2,1));
        this.movimentoCavalo.add(new Posicao(-2,-1));
        this.movimentoCavalo.add(new Posicao(-1,-2));
    }
    
    public final void inicializaTabuleiro(){
        for (int i = 0; i < tamanho; i++) {
            for(int j = 0; j < tamanho; j++){
                tabuleiro[i][j] = 0;
            }
        }
    }
    
    public ArrayList<Posicao> buscaMovimentosPossiveis(Posicao posicao){
        ArrayList<Posicao> movimentosPossiveis = new ArrayList<Posicao>();
        
        for (Posicao proximoMovimento : movimentoCavalo) {
            int proximoX = posicao.x + proximoMovimento.x;
            int proximoY = posicao.y + proximoMovimento.y;
            if(movimentoValido(proximoX,proximoY) 
                    && tabuleiro[proximoX][proximoY] == 0){
                movimentosPossiveis.add(new Posicao(proximoX,proximoY));
            }
        }
        return movimentosPossiveis;
    }
    
    public void imprimirMovimentosPossiveis(Posicao posicao){
        ArrayList<Posicao> movimentosPossiveis = buscaMovimentosPossiveis(posicao);
        
        for (Posicao movimentos : movimentosPossiveis) {
            System.out.println("X: "+movimentos.x + "  Y: "+movimentos.y);
        }
    }
    
    public boolean movimentoValido(int x, int y){
        return x >=0 && x <=7 && 
                y >= 0 && y <= 7;
    }
    
    public void imprimirTabuleiro(){
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.print(tabuleiro[i][j]+"\t");
            }
            System.out.print("\n");
        }
    }
}
