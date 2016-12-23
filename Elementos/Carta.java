/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import java.util.ArrayList;
import java.util.Deque;

/**
 *
 * @author alexandrepimenta
 */
public abstract class Carta 
{
    private int _id;
    private String _nome;
    private String _categoria;   
    private String _cor;
    private int _owner;
    
    public void setId(int id)
    {
    	this._id = id;
    }
    public int getId()
    {
    	return this._id;
    }
    
    public void setCategoria(String cat)
    {
    	this._categoria = cat;
    }
    
    public String getCategoria()
    {
    	return this._categoria;
    }
    
    public void setCor(String cor)
    {
    	this._cor = cor;
    }
    
    public String getCor()
    {
    	return this._cor;
    }
    
    public void setNome(String nome)
    {
    	this._nome = nome;
    }
    
    public String getNome()
    {
    	return this._nome;
    }
    
    public void setOwner(int owner)
    {
    	this._owner = owner;
    }
    public int getOwner()
    {
    	return this._owner;
    }    
    
    public void Efeito(Jogador jogador, ArrayList<Jogador> jogadores, int resultado_dados,ArrayList<Carta> cartas_ordem_tabuleiro,Deque<CartaSorteOuReves> cartas_sorte_ou_reves,ArrayList<CartaPropriedade> cartas_propriedades, ArrayList<CartaCompanhia> cartas_companhias, ArrayList<CartaSorteOuReves> cartas_nao_devolvidas_sorteoureves){
    	
    }
    
    public String tooltip(ArrayList<Jogador> jogadores)
    {
        String empty = null;
        return null;
    }
  
}
