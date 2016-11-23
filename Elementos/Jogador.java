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
public class Jogador 
{
    public Jogador(String nome, int dinheiro, int cor)
    {
        this._nome = nome;
        this._dinheiro = dinheiro;
        this._cor = cor;
    }
    
    private int _dinheiro;
    private String _nome;
    private int _cor;
    private int _coordX;
    private int _coordY;
    private int _dadosIniciais;
    
    public int saldoAtual()
    {
        return this._dinheiro;
    }
    
    public String nome()
    {
        return this._nome;
    }
    
    public int cor()
    {
        return this._cor;
    }
    
    public int X()
    {
        return this._coordX;
    }
    
    public int Y()
    {
        return this._coordY;
    }
    
    public void adicionarSaldo(int quantia)
    {
        this._dinheiro += quantia;
    }
    
    public void removerSaldo(int quantia)
    {
        this._dinheiro -= quantia;
    }
    
    public static boolean verificarFalencia(Jogador o)
    {
        if(o.saldoAtual() <= 0)
            return true;
        else
            return false;
    }
}
