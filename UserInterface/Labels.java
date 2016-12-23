/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Propriedades.Definicoes;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author alexandrepimenta
 */
public class Labels 
{
    protected static JLabel jogadorAtivo = new JLabel("Jogador Ativo",SwingConstants.CENTER);
    protected static JLabel dinheiro = new JLabel("Dinheiro",SwingConstants.CENTER);
    protected static JLabel tooltip = new JLabel("Tooltip",SwingConstants.CENTER);
    
    public static void iniciarLabels()
    {
        Font grande = new Font("SansSerif", Font.BOLD, 50);
        Labels.jogadorAtivo.setBounds(73, 15, 340, 35);
        Labels.jogadorAtivo.setForeground(Color.white);
        Labels.jogadorAtivo.setText(null);
        Labels.jogadorAtivo.setHorizontalAlignment(SwingConstants.CENTER);
        Labels.jogadorAtivo.setVerticalAlignment(SwingConstants.CENTER);
        Labels.jogadorAtivo.setFont(grande);
        //
        Font medium = new Font("SansSerif", Font.BOLD, 30);
        Labels.dinheiro.setBounds(81, 85, 300, 40);
        Labels.dinheiro.setText(null);
        Labels.dinheiro.setForeground(Color.white);
        Labels.dinheiro.setHorizontalAlignment(SwingConstants.CENTER);
        Labels.dinheiro.setVerticalAlignment(SwingConstants.CENTER);
        Labels.dinheiro.setFont(medium);
        //
        Font small = new Font("SansSerif", Font.PLAIN, 17);
        Labels.tooltip.setFont(small);
        Labels.tooltip.setBounds(65, 548, 354, 197);
        Labels.tooltip.setText(null);
        Labels.tooltip.setForeground(Color.white);
        Labels.tooltip.setHorizontalAlignment(SwingConstants.CENTER);
        Labels.tooltip.setVerticalAlignment(SwingConstants.CENTER);
    }
    
    public static void exibirLabels()
    {
        Tabuleiro.painel.add(Labels.jogadorAtivo);
        Tabuleiro.painel.add(Labels.dinheiro);
        Tabuleiro.painel.add(Labels.tooltip);
        Tabuleiro.setVisible();
        Tabuleiro.painel.repaint();
    }
    
    //Altera o nome do jogador ativo na interface
    public static void alterarNomeJogador(String nome, int cor)
    {
        Labels.jogadorAtivo.setText(nome);
        switch(cor)
        {
            case Definicoes.BRANCO:
                Labels.jogadorAtivo.setForeground(Color.WHITE);
                break;
            case Definicoes.PRETO:
                Labels.jogadorAtivo.setForeground(Color.BLACK);
                break;
            case Definicoes.AZUL:
                Labels.jogadorAtivo.setForeground(Color.BLUE);
                break;
            case Definicoes.AMARELO:
                Labels.jogadorAtivo.setForeground(Color.YELLOW);
                break;
            case Definicoes.VERDE:
                Labels.jogadorAtivo.setForeground(Color.GREEN);
                break;
            case Definicoes.VERMELHO:
                Labels.jogadorAtivo.setForeground(Color.RED);
                break;
            default:
                break;
        }
        
        Tabuleiro.painel.repaint();
    }
    
    //Altera a quantia de dinheiro exibida na interface
    public static void alterarDinheiro(int quantia)
    {
        Labels.dinheiro.setText("Saldo: $"+Integer.toString(quantia));
        Tabuleiro.painel.repaint();
    }
    
    //Altera o tooltip de descricao da casa atual do jogador
    public static void alterarTooltip(String texto)
    {
        Labels.tooltip.setText("<html>"+texto+"</html>");
        Tabuleiro.painel.repaint();
    }
}
