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
public class Carta 
{
    private String texto;
    private int adicionar;
    private int remover;
    private boolean prisao;
    
    void processarCarta(Jogador p)
    {
        if(adicionar > 0)
            p.adicionarSaldo(adicionar);
        else if(remover > 0)
            p.removerSaldo(remover);
        else if (prisao)
        {
            //ENVIAR JOGADOR PARA PRISAO
        }
    }
    
}
