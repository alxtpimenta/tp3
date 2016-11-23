/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import Propriedades.Definicoes;

/**
 *
 * @author alexandrepimenta
 */
public class Imovel extends Casa
{
    public Imovel(String nome, int valorDeCompra, int hipoteca, int aluguel, int alugel1casa, int aluguel2casas,int aluguel3casas, int aluguel4casas, int valorDeCompraCasa, int valorDeCompraHotel)
    {
        this._nome = nome;
        this.valorDeCompra = valorDeCompra;
        this.hipoteca = hipoteca;
        this.aluguel = aluguel;
        this.aluguel1casas = alugel1casa;
        this.aluguel2casas = aluguel2casas;
        this.aluguel3casas = aluguel3casas;
        this.aluguel4casas = aluguel4casas;
        this.valorDeCompraCasa = valorDeCompraCasa;
        this.valorDeCompraHotel = valorDeCompraHotel;
        this.qtdCasas = 0;
        this.qtdHoteis = 0;
        this.proprietario = null;
    }
    private int valorDeCompra;
    private int hipoteca;
    //
    private int valorDeCompraCasa;
    private int valorDeCompraHotel;
    //
    private int aluguel;
    private int aluguel1casas;
    private int aluguel2casas;
    private int aluguel3casas;
    private int aluguel4casas;
    //
    private int qtdCasas;
    private int qtdHoteis;
    //
    private Jogador proprietario;
    
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
    
    public boolean adicionarCasa(Jogador p)
    {
        //Verifica se o jogador tem saldo o suficiente, e se tem o numero maximo de casas
        if((p.saldoAtual() >= this.valorDeCompraCasa) && (this.qtdCasas < Definicoes.NUM_MAX_CASAS) && (p == proprietario))
        {
            p.removerSaldo(valorDeCompraCasa); //Remove o valor do saldo do jogador
            this.qtdCasas++; //Incrementa a quantidade de casas
            return true;
        }
        else
            return false;
    }
    
    //Verifica se o jogador tem saldo o suficiente, e se tem o numero maximo de hoteis
    public boolean adicionarHotel(Jogador p)
    {
        if((p.saldoAtual() >= this.valorDeCompraHotel) && (this.qtdHoteis < Definicoes.NUM_MAX_HOTEIS) && (p == proprietario))
        {
            p.removerSaldo(valorDeCompraHotel); //Remove o valor do saldo do jogador
            this.qtdHoteis++; //Incrementa a quantidade de hoteis
            return true;
        }
        else
            return false; //Caso contrario, retorna falso
    }
    
    public boolean cobrarAluguel(Jogador p )
    {
        //Cobrar o valor do aluguel do saldo do jogador
        //De acordo com o numero de casas e se tiver hotel
        return true;
    }
}