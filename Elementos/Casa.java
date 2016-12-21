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
    //DETECTA MOUSEOVER SOBRE A CASA
    public boolean mouseOver(int x, int y)
    {
        //SE AS COORDENADAS DO MOUSE ESTIVEREM DENTRO DAS PAREDES DA CASA
        //RETORNE TRUE, CASO CONTRARIO, RETORNE FALSE
        if( (_x1 > x) && (_x2 < x) && (_y1 > y) && (_y1 < y) )
            return true;
        else
            return false;
    }
    //RETORNA O X E Y PARA IMPRESSAO NO TABULEIRO
    public int x()
    {
        return this._x2-this._x1;
    }
    public int y()
    {
        return this._y2-this._y1;
    }
    
}
