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
public abstract class Casa 
{
    //ATRIBUTOS
    protected String _nome;
    protected int _tipo;
    protected int _x1;
    protected int _x2;
    protected int _y1;
    protected int _y2;
    protected int card;
    //RETORNA O NOME DA CASA
    public String nome()
    {
        return _nome;
    }
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
    
    public void setXY(int x1, int x2, int y1, int y2)
    {
        this._x1 = x1;
        this._x2 = x2;
        this._y1 = y1;
        this._y2 = y2;
    }
}
