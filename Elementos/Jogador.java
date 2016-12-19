/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

public abstract class Jogador
{   
    private int _dinheiro;
    private String _nome;
    private int _cor;
    private int _coordX;
    private int _coordY;
    private int _resultadoDados; //vou usar uma vez só, para determinar a ordem de jogada dos jogadores.
    private String _tipo;
        
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
        if(o.getSaldo() <= 0)
            return true;
        else
            return false;
    }
    
    public int compareTo(Jogador outroJogador) {
        if (this._resultadoDados < outroJogador._resultadoDados) {
            return -1;
        }
        if (this._resultadoDados > outroJogador._resultadoDados) {
            return 1;
        }
        return 0;
    }
}
