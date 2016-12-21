/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;
import javax.swing.JOptionPane;
/**
 *
 * @author alexandrepimenta
 */
public  class Dialogo 
{
    //MOSTRA MENSAGEM DE DIALOGO DE BOAS VINDAS
    public static void boasVindas()
    {
        JOptionPane.showMessageDialog(null,Textos.BOAS_VINDAS);
    }
    
    //EXIBE O VALOR SORTEADO DOS DADOS
    public static void jogarDados(int valor)
    {
        //EXIBE UMA CAIXA DE DIALOGO COM O VALOR SORTEADO
        JOptionPane.showMessageDialog(null,"Dados jogados! Resultado: "+Integer.toString(valor));
    }
    
    //SOLICITA A QUANTIDADE DE JOGADORES
    //O VALOR E RETORNADO COMO INTEIRO
    public static int quantidadeJogadoresLocais()
    {
        //ARMAZENA OS DADOS INSERIDOS
        String quantidade;
        int saida;
        //SOLICITA A ENTRADA DO USUARIO
        quantidade = JOptionPane.showInputDialog(Textos.QTD_JOGADORES_LOCAIS);
        //CONVERTE A SAIDA PARA INTEIRO
        saida = Integer.parseInt(quantidade);
        //RETORNA A SAIDA
        return saida;
    }
    public static int quantidadeJogadoresComputador()
    {
        //ARMAZENA OS DADOS INSERIDOS
        String quantidade;
        int saida;
        //SOLICITA A ENTRADA DO USUARIO
        quantidade = JOptionPane.showInputDialog(Textos.QTD_JOGADORES_COMPUTADOR);
        //CONVERTE A SAIDA PARA INTEIRO
        saida = Integer.parseInt(quantidade);
        //RETORNA A SAIDA
        return saida;
    }
    
    public static String nomeJogador(int numJogador)
    {
        //ARMAZENA OS DADOS INSERIDOS
        String nome;
        //SOLICITAR ENTRADA DO USUARIO
        nome = JOptionPane.showInputDialog(Textos.INSERIR_NOME_LOCAL +" " + Integer.toString(numJogador));
        //RETORNA O NOME DO JOGADOR
        return nome;
    }
    
    public static String nomeJogadorComputador(int numJogador)
    {
        //ARMAZENA OS DADOS INSERIDOS
        String nome;
        //SOLICITAR ENTRADA DO USUARIO
        nome = JOptionPane.showInputDialog(Textos.INSERIR_NOME_COMPUTADOR + " " + Integer.toString(numJogador),"Computador " + numJogador);
        //RETORNA O NOME DO JOGADOR
        return nome;
    }
    
    //SOLICITA A COR DO JOGADOR
    //O VALOR E RETORNADO EM INT, DE ACORDO COM AS DEFINICOES
    public static int corJogador(int numJogador,  String [] cores)
    {
        //ARMAZENA OS DADOS
        String entrada;
    	
        //SOLICITA ENTRADA DO USUARIO
        entrada = (String)JOptionPane.showInputDialog(null,Textos.SELECIONAR_COR +" " + Integer.toString(numJogador),Textos.SELECIONAR_COR +" " + Integer.toString(numJogador),JOptionPane.QUESTION_MESSAGE,null,cores,cores[0]);
        
        if("Branco".equals(entrada))
            return 0;
        else if("Preto".equals(entrada))
            return 1;
        else if("Azul".equals(entrada))
            return 2;
        else if("Amarelo".equals(entrada))
            return 3;
        else if("Verde".equals(entrada))
            return 4;
        else if("Vermelho".equals(entrada))
            return 5;
        
        //CASO NENHUM VALOR SEJA SELECIONADO, SERA RETORNADO ERRO (-1)
        return -1;
    }
    
    //MOSTRA MENSAGEM DE ERRO CASO A COR JA TENHA SIDO SELECIONADA
    public static void erroCorSelecionada()
    {
        JOptionPane.showMessageDialog(null,Textos.COR_JA_SELECIONADA);
    }
    
    //Mensagem de aviso generico (aviso de cobranca, sorte, reves)
    public static void avisoGenerico(String texto)
    {
        JOptionPane.showMessageDialog(null,texto);
    }
    
    //Caixa de dialogo generica sim/nao (deseja comprar x imovel?)
    //Retorna TRUE se a resposta for sim, e FALSE se for nao
    public static boolean perguntaGenerica(String texto)
    {
        int resposta = JOptionPane.showConfirmDialog(null,texto,null,JOptionPane.YES_NO_OPTION);
        if(resposta == JOptionPane.YES_OPTION)
            return true;
        else
            return false;
    }
}
