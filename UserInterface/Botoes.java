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
    
    //Inicializa os botoes
    public static void iniciarBotoes()
    {
        Botoes.jogarDados.setBounds(25, 213, 120, 50);
        Botoes.comprar.setBounds(25, 213, 120, 50);
        Botoes.finalizarTurno.setBounds(340, 213, 120, 50);
        Botoes.adicionarCasa.setBounds(25, 213, 120, 50);
        Botoes.adicionarHotel.setBounds(170, 213, 120, 50);
    }
    
    //Exibe o botao de jogar os dados
    public static void mostrarBotaoDados()
    {
        Tabuleiro.painel.add(Botoes.jogarDados);
        Tabuleiro.setVisible();
        Tabuleiro.painel.repaint();
    }
    
    //Oculta o botao de mostrar os dados
    public static void removerBotaoDados()
    {
        Tabuleiro.painel.remove(Botoes.jogarDados);
        Tabuleiro.painel.repaint();
    }
    
    //Exibe o botao de compra (imovel ou empresa)
    public void mostrarBotaoCompra()
    {
        Tabuleiro.painel.add(Botoes.comprar);
        Tabuleiro.setVisible();
        Tabuleiro.painel.repaint();
    }
    
    //Oculta o botao de compra
    public static void removerBotaoCompra()
    {
        Tabuleiro.painel.remove(Botoes.comprar);
        Tabuleiro.painel.repaint();
    }
    
    //Exibe o botao de construir casa
    public static void mostrarBotaoCasa()
    {
        Tabuleiro.painel.add(Botoes.adicionarCasa);
        Tabuleiro.setVisible();
        Tabuleiro.painel.repaint();
    }
    
    //Oculta o botao de construir casa
    public static void removerBotaoCasa()
    {
        Tabuleiro.painel.remove(Botoes.adicionarCasa);
        Tabuleiro.painel.repaint();
    }
    
    //Exibe o botao de construir hotel
    public void mostrarBotaoHotel()
    {
        Tabuleiro.painel.add(Botoes.adicionarHotel);
        Tabuleiro.setVisible();
        Tabuleiro.painel.repaint();
    }
    
    //Oculta o botao de construir hotel
    public static void removerBotaoHotel()
    {
        Tabuleiro.painel.remove(Botoes.adicionarHotel);
        Tabuleiro.painel.repaint();
    }
    
    //Exibe o botao de passar o turno
    public static void mostrarBotaoTurno()
    {
        Tabuleiro.painel.add(Botoes.finalizarTurno);
        Tabuleiro.setVisible();
        Tabuleiro.painel.repaint();
    }
    
    //Oculta o botao de passar o turno
    public static void removerBotaoTurno()
    {
        Tabuleiro.painel.remove(Botoes.finalizarTurno);
        Tabuleiro.painel.repaint();
    }
    

}
