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
    public Especial(String nome,int adicionar, int remover, boolean prisao, boolean sortereves)
    {
        this._nome = nome;
        this.adicionar = adicionar;
        this.remover = remover;
        this.prisao = prisao;
        this.sortereves = sortereves;
    }
    
    private int adicionar;
    private int remover;
    private boolean prisao;
    private boolean sortereves;
    
    public void processarCarta(Jogador p)
    {
        if(adicionar > 0)
            p.adicionarSaldo(adicionar);
        else if(remover > 0)
            p.removerSaldo(remover);
        else if(sortereves)
        {
            //PROCEDIMENTO PARA PEGAR UMA CARTA SORTE/REVES
        }
    }
}
