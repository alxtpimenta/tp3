/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import javax.swing.JLabel;

/**
 *
 * @author alexandrepimenta
 */
public class Labels 
{
    public static JLabel jogadorAtivo = new JLabel("Jogador Ativo",JLabel.LEFT);
    public static JLabel dinheiro = new JLabel("Dinheiro",JLabel.LEFT);
    public static JLabel tooltip = new JLabel("Tooltip",JLabel.LEFT);
    
    public static void definirLabelJogador(String texto)
    {
        Labels.jogadorAtivo.setText(texto);
    }
    
    public static void definirLabelDinheiro(String texto)
    {
        Labels.dinheiro.setText(texto);
    }
    
    public static void definirTooltip(String texto)
    {
        Labels.tooltip.setText(texto);
    }
    
    public static void iniciarLabels()
    {
        Labels.jogadorAtivo.setBounds(73, 15, 340, 35);
        Labels.jogadorAtivo.setText("Teste");
        //
        Labels.dinheiro.setBounds(81, 85, 300, 40);
        Labels.dinheiro.setText("Teste");
        //
        Labels.tooltip.setBounds(65, 548, 354, 197);
        Labels.tooltip.setText("Teste");
    }
    
    public static void exibirLabels()
    {
        Tabuleiro.painel.add(Labels.jogadorAtivo);
        Tabuleiro.painel.add(Labels.dinheiro);
        Tabuleiro.painel.add(Labels.tooltip);
        Tabuleiro.painel.repaint();
    }
}
