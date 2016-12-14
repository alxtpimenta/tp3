/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Propriedades.Definicoes;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author alexandrepimenta
 */
public class Tabuleiro 
{
    private final JFrame tabuleiro;
    
    private static Tabuleiro instancia = null;
    
    protected Tabuleiro()
    {
        tabuleiro = new JFrame("Banco Imobiliario");
        tabuleiro.setSize(Definicoes.RESOLUCAOX,Definicoes.RESOLUCAOY);
        tabuleiro.setLocationRelativeTo(null);
        tabuleiro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tabuleiro.setVisible(true);
    }
    public static Tabuleiro inicializarTabuleiro()
    {
        if(instancia == null)
        {
            instancia = new Tabuleiro();
            return instancia;
        }
        else
            return null;
    }
    
    //PLANO DE FUNDO
    public static JPanel background = new JPanel()
    {
        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.drawImage(Sprites.planoDeFundo,0,0,null);
        }
    };
    
    public void adicionarFundo()
    {
        this.tabuleiro.add(Tabuleiro.background);
    }
    
    public JButton jogarDados = new JButton("Jogar Dados");
}
