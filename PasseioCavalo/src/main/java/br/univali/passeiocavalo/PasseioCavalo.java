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

        EstrategiaTentativaErro tentativaErro = new EstrategiaTentativaErro();
        EstrategiaPelasBordas pelasBordas = new EstrategiaPelasBordas();
        
        tentativaErro.run();
        pelasBordas.run();
    }
}
