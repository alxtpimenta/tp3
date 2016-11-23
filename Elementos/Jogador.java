* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

/**
 *
 * @author alexandrepimenta
 */
public class Jogador implements Comparable<Jogador>
{
    public Jogador(String nome, int dinheiro, int cor, int resultadoDados)
    {
        this._nome = nome;
        this._dinheiro = dinheiro;
        this._cor = cor;
        this._resultadoDados = resultadoDados;
    }
    
    private int _dinheiro;
    private String _nome;
    private int _cor;
    private int _coordX;
    private int _coordY;
    private int _resultadoDados; //vou usar uma vez só, para determinar a ordem de jogada dos jogadores.
    
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
