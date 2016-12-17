/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author alexandrepimenta
 */
public class Pecas 
{
    protected static JLabel jAzul = new JLabel(new ImageIcon(Sprites.jogadorAzul));
    protected static JLabel jAmarelo = new JLabel(new ImageIcon(Sprites.jogadorAmarelo));
    protected static JLabel jBranco = new JLabel(new ImageIcon(Sprites.jogadorBranco));
    protected static JLabel jPreto = new JLabel(new ImageIcon(Sprites.jogadorPreto));
    protected static JLabel jVerde = new JLabel(new ImageIcon(Sprites.jogadorVerde));
    protected static JLabel jVermelho = new JLabel(new ImageIcon(Sprites.jogadorVermelho));
    
    public static void iniciarPecas()
    {
        Pecas.jAzul.setBounds(0,0, 39, 65);
        Pecas.jAmarelo.setBounds(0,0, 39, 65);
        Pecas.jBranco.setBounds(0,0, 39, 65);
        Pecas.jPreto.setBounds(0,0, 39, 65);
        Pecas.jVerde.setBounds(0,0, 39, 65);
        Pecas.jVermelho.setBounds(0,0, 39, 65);
    }
    
    public static void adicionarAzul()
    {
        Tabuleiro.painel.add(Pecas.jAzul);
        Tabuleiro.setVisible();
        Tabuleiro.painel.repaint();
    }
    
    public static void removerAzul()
    {
        Tabuleiro.painel.remove(Pecas.jAzul);
        Tabuleiro.painel.repaint();
    }
    
    public static void atualizarAzul(int x, int y)
    {
        Pecas.jAzul.setBounds(x,y, 39, 65);
        Tabuleiro.painel.repaint();
    }
    
    public static void adicionarAmarelo()
    {
        Tabuleiro.painel.add(Pecas.jAmarelo);
        Tabuleiro.painel.repaint();
    }
    
    public static void removerAmarelo()
    {
        Tabuleiro.painel.remove(Pecas.jAmarelo);
        Tabuleiro.painel.repaint();
    }
    
    public static void atualizarAmarelo(int x, int y)
    {
        Pecas.jAmarelo.setBounds(x,y, 39, 65);
        Tabuleiro.painel.repaint();
    }
    
    public static void adicionarBranco()
    {
        Tabuleiro.painel.add(Pecas.jBranco);
        Tabuleiro.painel.repaint();
    }
    
    public static void removerBranco()
    {
        Tabuleiro.painel.remove(Pecas.jBranco);
        Tabuleiro.painel.repaint();
    }
    
    public static void atualizarBranco(int x, int y)
    {
        Pecas.jBranco.setBounds(x,y, 39, 65);
        Tabuleiro.painel.repaint();
    }
    
    public static void adicionarPreto()
    {
        Tabuleiro.painel.add(Pecas.jPreto);
        Tabuleiro.painel.repaint();
    }
    
    public static void removerPreto()
    {
        Tabuleiro.painel.remove(Pecas.jPreto);
        Tabuleiro.painel.repaint();
    }
    
    public static void atualizarPreto(int x, int y)
    {
        Pecas.jPreto.setBounds(x,y, 39, 65);
        Tabuleiro.painel.repaint();
    }
    
    public static void adicionarVerde()
    {
        Tabuleiro.painel.add(Pecas.jVerde);
        Tabuleiro.painel.repaint();
    }
    
    public static void removerVerde()
    {
        Tabuleiro.painel.remove(Pecas.jVerde);
        Tabuleiro.painel.repaint();
    }
    
    public static void atualizarVerde(int x, int y)
    {
        Pecas.jVerde.setBounds(x,y, 39, 65);
        Tabuleiro.painel.repaint();
    }
    
    public static void adicionarVermelho()
    {
        Tabuleiro.painel.add(Pecas.jVermelho);
        Tabuleiro.painel.repaint();
    }
    
    public static void removerVermelho()
    {
        Tabuleiro.painel.remove(Pecas.jVermelho);
        Tabuleiro.painel.repaint();
    }
    
    public static void atualizarVermelho(int x, int y)
    {
        Pecas.jVermelho.setBounds(x,y, 39, 65);
        Tabuleiro.painel.repaint();
    }
}
