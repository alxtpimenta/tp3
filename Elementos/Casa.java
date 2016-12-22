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
public class Casa 
{
    public Casa(int x1,int x2,int y1,int y2)
    {
        this._x1 = x1;
        this._x2 = x2;
        this._y1 = y1;
        this._y2 = y2;
    }
    //ATRIBUTOS
    protected int _x1;
    protected int _x2;
    protected int _y1;
    protected int _y2;
    //RETORNA O X E Y PARA IMPRESSAO NO TABULEIRO
    public int x()
    {
            return this._x1;
    }
    public int y()
    {
            return this._y1;
    }
    
}
