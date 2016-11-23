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
public class Empresa extends Casa
{
    public Empresa(String nome, int valorDeCompra,int hipoteca, int taxa)
    {
        this._nome = nome;
        this.valorDeCompra = valorDeCompra;
        this.hipoteca = hipoteca;
        this.taxa = taxa;
    }
    private int valorDeCompra;
    private int hipoteca;
    private int taxa;
    //
    private Jogador proprietario;
    //
    public boolean comprarImovel(Jogador p)
    {
        if(p.saldoAtual() >= this.valorDeCompra) //Verifica se o jogador tem saldo suficiente
        {
            p.removerSaldo(valorDeCompra); //Deduz o valor do saldo
            this.proprietario = p; //Determina o proprietario do imovel
            return true;
        }
        else
            return false; //Caso contrario, retorna falso
    }
    
    public void cobrarTaxa(Jogador p, int dado)
    {
        p.removerSaldo(taxa*dado); //Debita a taxa do saldo do jogador
    }
}
