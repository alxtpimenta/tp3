/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

public abstract class Jogador implements Comparable<Jogador>
{   
	private int _id;
    private int _dinheiro;
    private String _nome;
    private int _cor;
    private int _coordX;
    private int _coordY;
    private int _resultadoDados; //vou usar uma vez só, para determinar a ordem de jogada dos jogadores.
    private String _tipo;
    private int _posicao_no_tabuleiro;
    private boolean _preso;
    private int _dias_de_prisao_restantes;
    
    public void setId(int id)
    {
    	this._id = id;
    }
    public int getId()
    {
    	return this._id;
    }
        
    public void setName(String name){
    	this._nome = name;    	
    }
    
    public String getName()
    {
    	return this._nome;
    }
    
    public void setTipo(String tipo){
    	this._tipo = tipo;    	
    }
    
    public String getTipo()
    {
    	return this._tipo;
    }
    
    public void setSaldo(int dinheiro_inicial)
    {
    	this._dinheiro = dinheiro_inicial;
    }
    public int getSaldo()
    {
        return this._dinheiro;
    }
    
    public void setCor(int cor)
    {
    	this._cor = cor;
    }
    
    public int getCor()
    {
        return this._cor;
    }    
    
    public void setX()
    {
    	
    }    
    
    public int getX()
    {
        return this._coordX;
    }
    
    public void setY()
    {
    	
    }   
    
    public int getY()
    {
        return this._coordY;
    }
    
    public void setResultadoDados(int dados)
    {
    	this._resultadoDados = dados;
    }
    public int getResultados()
    {
    	return this._resultadoDados;
    }
    
    public void adicionarSaldo(int quantia)
    {
        this._dinheiro += quantia;
    }
    
    public void removerSaldo(int quantia)
    {
        this._dinheiro -= quantia;
    }
    
    public void setPosicaoTabuleiro(int posicao)
    {
    	this._posicao_no_tabuleiro = posicao;
    }
    
    public int getPosicaoTabuleiro()
    {
    	return this._posicao_no_tabuleiro;
    }
    
    public void setPreso(boolean preso)
    {
    	this._preso = preso;
    }
    public boolean getPreso()
    {
    	return this._preso;
    }
    
    public void setDiasDePrisaoRestantes(int dias)
    {
    	this._dias_de_prisao_restantes = dias;
    }
    public int getDiasDePrisaoRestantes()
    {
    	return this._dias_de_prisao_restantes;
    }
    
    
    public static boolean verificarFalencia(Jogador o)
    {
        if(o.getSaldo() <= 0)
            return true;
        else
            return false;
    }
    
    public int compareTo(Jogador outro_jogador)
	{
		if(this.getResultados() < outro_jogador.getResultados())
		{
			return -1;
		}
		else if(this.getResultados() > outro_jogador.getResultados())
		{
			return 1;
		}
		else
			return 0;
	}
}
