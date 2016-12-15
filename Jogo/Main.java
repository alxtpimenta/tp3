/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogo;

import java.util.*;
import Elementos.Jogador;
import Propriedades.Definicoes;
import UserInterface.Labels;
import UserInterface.Sprites;
import UserInterface.Tabuleiro;
import java.io.IOException;

public class Main 
{
    public static void main(String[] args) throws IOException 
    {
        // TODO code application logic here
        int numJogadores;
        boolean modoPartida; //true é modo comum, de falência, e false é com contador por tempo/jogadas/etc
        long tempoMaxMinu;
        long horaAtual;
        long horaFinal;
        
        int i;
        
        String nome;
        int cor;
        int dados;
        Random gerador;
        
        /*
        Início do Jogo
        É aberta uma janela em que o usuário escolhe:
        
        -modo de término do jogo
         --depois de um tempo X, x em minutos escolhido pelo usuário
         --ou terminar pelo modo normal de falência. (mas mesmo assim jogador escolhe um tempo máximo para o jogo em minutos.)
         Com base na escolha, cria contador de tempo/passagens ou não cria.(Ou deixa a opção de trocar 
         de modo ligada durante o jogo (jogos que demoram muito) e inicia o contador de tempo/passadas de qualquer forma.)
         
         -numero de Jogadores. (entre MIN_JOGADORES E MAX_JOGADORES)
           Após ler retorna esse numero de jogadores para serem criados aqui.
        */
        
        //INICIALIZACAO DA INTERFACE
        UserInterface.Sprites.carregarSprites();
        UserInterface.Botoes.iniciarBotoes();
        UserInterface.Labels.iniciarLabels();
        //INICIAR TABULEIRO
        Tabuleiro board = Tabuleiro.inicializarTabuleiro();
        board.adicionarPainel();
        Tabuleiro.setVisible();
        //DIALOGO DA INTERFACE
        UserInterface.Dialogo.boasVindas();

        //Pedaço para testes, remover depois
        modoPartida = true;
        tempoMaxMinu = 60;
        //fim pedaço para testes
        
        ArrayList<Jogador> jogadores = new ArrayList<>();    
        gerador = new Random(); //gerador de números aleatórios

        //Preenche a lista de jogadores usando a interface
        numJogadores = UserInterface.Dialogo.quantidadeJogadores();
        for(i = 0;i < numJogadores; i++)
        {
            String nomeJogador = UserInterface.Dialogo.nomeJogador(i+1);
            int corJogador = UserInterface.Dialogo.corJogador(i+1);
            dados = gerador.nextInt(12)+1;
            jogadores.add(new Jogador(nomeJogador,Definicoes.QUANTIA_INICIAL,corJogador,dados));
        }
        
        Collections.sort(jogadores); //jogadores ordenados no Array pela vez de jogar
        
        //EXIBIR ELEMENTOS DA INTERFACE
        UserInterface.Botoes.mostrarBotaoDados();
        UserInterface.Botoes.mostrarBotaoTurno();
        UserInterface.Labels.exibirLabels();

        //Inicia a partida
        horaAtual = System.currentTimeMillis();
        horaFinal  = horaAtual + (tempoMaxMinu * 60000);
        
        
    }
}
