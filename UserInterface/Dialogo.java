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
        //EXIBE UMA CAIXA DE DIALOGO COM O VALOR SORTEADO (ENQUANTO NAO SAO FEITOS OS SPRITES)
        JOptionPane.showMessageDialog(null,Integer.toString(valor));
    }
    
    //SOLICITA A QUANTIDADE DE JOGADORES
    //O VALOR E RETORNADO COMO INTEIRO
    public static int quantidadeJogadores()
    {
        //ARMAZENA OS DADOS INSERIDOS
        String quantidade;
        int saida;
        //SOLICITA A ENTRADA DO USUARIO
        quantidade = JOptionPane.showInputDialog(Textos.QTD_JOGADORES);
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
        nome = JOptionPane.showInputDialog(Textos.INSERIR_NOME +" " + Integer.toString(numJogador));
        //RETORNA O NOME DO JOGADOR
        return nome;
    }
    
    //SOLICITA A COR DO JOGADOR
    //O VALOR E RETORNADO EM INT, DE ACORDO COM AS DEFINICOES
    public static int corJogador(int numJogador)
    {
        //ARMAZENA OS DADOS
        String [] cores = {"Branco","Preto","Azul","Amarelo","Verde","Vermelho"};
        String entrada;
        //SOLICITA ENTRADA DO USUARIO
        entrada = (String)JOptionPane.showInputDialog(null,Textos.SELECIONAR_COR +" " + Integer.toString(numJogador),Textos.SELECIONAR_COR +" " + Integer.toString(numJogador),JOptionPane.QUESTION_MESSAGE,null,cores,cores[0]);
        
        //!! A FUNCAO NAO REALIZA CONSULTA SE A COR JA FOI SELECIONADA !!
        //!! A CONSULTA DEVE SER FEITA NO BACK END !!
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
}
