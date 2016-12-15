/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import javax.swing.JButton;

/**
 *
 * @author alexandrepimenta
 */
public class Botoes 
{
    public static JButton jogarDados = new JButton("Jogar Dados");
    public static JButton comprar = new JButton("Comprar");
    public static JButton adicionarCasa = new JButton("Adicionar casa");
    public static JButton adicionarHotel = new JButton("Adicionar Hotel");
    public static JButton finalizarTurno = new JButton("Finalizar turno");
    
    public static void mostrarBotaoDados()
    {
        Botoes.jogarDados.setBounds(25, 213, 120, 50);
        Tabuleiro.painel.add(Botoes.jogarDados);
    }
    
    public static void removerBotaoDados()
    {
        Tabuleiro.painel.remove(Botoes.jogarDados);
        Tabuleiro.painel.repaint();
    }
    
    public void mostrarBotaoCompra()
    {
        Botoes.comprar.setBounds(25, 213, 120, 50);
        Tabuleiro.painel.add(Botoes.comprar);
        Tabuleiro.painel.repaint();
    }
    
    public static void removerBotaoCompra()
    {
        Tabuleiro.painel.remove(Botoes.comprar);
    }
    
    public static void mostrarBotaoCasa()
    {
        Botoes.adicionarCasa.setBounds(25, 213, 120, 50);
        Tabuleiro.painel.add(Botoes.adicionarCasa);
    }
    
    public static void removerBotaoCasa()
    {
        Tabuleiro.painel.remove(Botoes.adicionarCasa);
    }
    
    public void mostrarBotaoHotel()
    {
        Botoes.adicionarHotel.setBounds(25, 213, 120, 50);
        Tabuleiro.painel.add(Botoes.adicionarHotel);
    }
    
    public static void removerBotaoHotel()
    {
        Tabuleiro.painel.remove(Botoes.adicionarHotel);
    }
    
    public static void mostrarBotaoTurno()
    {
        Botoes.finalizarTurno.setBounds(25, 213, 120, 50);
        Tabuleiro.painel.add(Botoes.finalizarTurno);
    }
    
    public static void removerBotaoTurno()
    {
        Tabuleiro.painel.remove(Botoes.finalizarTurno);
    }
    
}
