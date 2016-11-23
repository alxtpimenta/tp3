/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

/**
 *
 * @author alexandrepimenta
 */
public class Especial extends Casa 
{
    private int adicionar;
    private int remover;
    private int prisao;
    private boolean sorte;
    private boolean reves;
    
    public void processarCarta(Jogador p)
    {
        if(adicionar > 0)
            p.adicionarSaldo(adicionar);
        else if(remover > 0)
            p.removerSaldo(remover);
        else if(sorte)
        {
            //PROCEDIMENTO PARA PEGAR UMA CARTA SORTE/REVES
        }
        else if(reves)
        {
            //PROCEDIMENTO PARA PEGAR UMA CARTA SORTE/REVES
        }
    }
}
