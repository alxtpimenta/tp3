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
    protected String _nome;
    protected int _tipo;
    protected int _coordX;
    protected int _coordY;
    //
    
    public int X()
    {
        return _coordX;
    }
    
    public int Y()
    {
        return _coordY;
    }
    
    public String nome()
    {
        return _nome;
    }
}
