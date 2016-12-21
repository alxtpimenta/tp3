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
    private static JFrame tabuleiro;
    
    private static Tabuleiro instancia = null;
    
    //Construtor
    protected Tabuleiro()
    {
        tabuleiro = new JFrame("Banco Imobiliario");
        tabuleiro.setSize(Definicoes.RESOLUCAOX,Definicoes.RESOLUCAOY);
        tabuleiro.setLocationRelativeTo(null);
        tabuleiro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tabuleiro.setResizable(false);
        tabuleiro.setVisible(true);
    }
    
    //Instanciar o singleton do tabuleiro
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
    public static JPanel painel = new JPanel()
    {
        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.drawImage(Sprites.planoDeFundo,0,0,null);
        }
    };
    
    //Adiciona o painel ao JFrame
    public void adicionarPainel()
    {
        Tabuleiro.tabuleiro.add(Tabuleiro.painel);
        Tabuleiro.painel.setLayout(null);
        Tabuleiro.painel.setVisible(true);
    }
    
    //Torna os objetos swing visiveis apos a inclusao
    public static void setVisible()
    {
        Tabuleiro.painel.setVisible(true);
        Tabuleiro.tabuleiro.setVisible(true);
    }
    
    public static void refresh()
    {
        Tabuleiro.painel.repaint();
    }
    
    public static JButton jogarDados = new JButton("Jogar Dados");
    public static JButton comprar = new JButton("Comprar");
    public static JButton adicionarCasa = new JButton("Adicionar casa");
    public static JButton adicionarHotel = new JButton("Adicionar Hotel");
    public static JButton finalizarTurno = new JButton("Finalizar turno");
    
}
