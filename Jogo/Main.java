/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogo;

import java.util.*;
import Elementos.Jogador;
import Elementos.JogadorLocal;
import Elementos.JogadorComputador;
import Propriedades.Definicoes;
import UserInterface.Tabuleiro;
import java.io.IOException;

public class Main 
{
    public static void main(String[] args) throws IOException 
    {
        int numJogadoresLocais;
        int numJogadoresComputador;
        ArrayList<Jogador> jogadores;
        ArrayList<String> arrayCores;
        String [] cores;
        boolean modoPartida; //true Ã© modo comum, de falÃªncia, e false Ã© com contador por tempo/jogadas/etc
        long tempoMaxMinu;
        long horaAtual;
        long horaFinal;
        
        int i;
        
        String nome;
        int cor;
        int dados;
        Random gerador;
        
        /*
        InÃ­cio do Jogo
        Ã‰ aberta uma janela em que o usuÃ¡rio escolhe:
        
        -modo de tÃ©rmino do jogo
         --depois de um tempo X, x em minutos escolhido pelo usuÃ¡rio
         --ou terminar pelo modo normal de falÃªncia. (mas mesmo assim jogador escolhe um tempo mÃ¡ximo para o jogo em minutos.)
         Com base na escolha, cria contador de tempo/passagens ou nÃ£o cria.(Ou deixa a opÃ§Ã£o de trocar 
         de modo ligada durante o jogo (jogos que demoram muito) e inicia o contador de tempo/passadas de qualquer forma.)
         
         -numero de Jogadores. (entre MIN_JOGADORES E MAX_JOGADORES)
           ApÃ³s ler retorna esse numero de jogadores para serem criados aqui.
        */
        
        //INICIALIZACAO DA INTERFACE
        UserInterface.Sprites.carregarSprites();
        UserInterface.Botoes.iniciarBotoes();
        UserInterface.Labels.iniciarLabels();
        UserInterface.Pecas.iniciarPecas();
        //INICIAR TABULEIRO
        Tabuleiro board = Tabuleiro.inicializarTabuleiro();
        board.adicionarPainel();
        Tabuleiro.setVisible();
        //DIALOGO DA INTERFACE
        UserInterface.Dialogo.boasVindas();

        //PedaÃ§o para testes, remover depois
        modoPartida = true;
        tempoMaxMinu = 60;
        //fim pedaÃ§o para testes
        
        jogadores = new ArrayList<Jogador>();    
        gerador = new Random(); //gerador de nÃºmeros aleatÃ³rios
        
    	arrayCores = new ArrayList<String>();
    	arrayCores.add("Branco");
    	arrayCores.add("Preto");
    	arrayCores.add("Azul");
    	arrayCores.add("Amarelo");
    	arrayCores.add("Verde");
    	arrayCores.add("Vermelho");

        //Preenche a lista de jogadores usando a interface
        numJogadoresLocais = UserInterface.Dialogo.quantidadeJogadoresLocais();
        for(i = 0; i < numJogadoresLocais; i++)
        {
            String nomeJogadorLocal = UserInterface.Dialogo.nomeJogador(i+1);
            
            cores = new String[arrayCores.size()];
            cores = arrayCores.toArray(cores);
            int corJogadorLocal = UserInterface.Dialogo.corJogador(i+1, cores);
            switch (corJogadorLocal){
            	case 0: arrayCores.remove("Branco");
            		break;
            	case 1: arrayCores.remove("Preto");
    			break;
            	case 2: arrayCores.remove("Azul");
			break;
            	case 3: arrayCores.remove("Amarelo");
			break;
            	case 4: arrayCores.remove("Verde");
			break;
            	case 5: arrayCores.remove("Vermelho");
			break;
            default:break;
            }
            
            dados = gerador.nextInt(12)+1;
            JogadorLocal humanPlayer = new JogadorLocal();
            humanPlayer.setCor(corJogadorLocal);
            humanPlayer.setName(nomeJogadorLocal);
            humanPlayer.setSaldo(Definicoes.QUANTIA_INICIAL);
            humanPlayer.setResultadoDados(dados);
            humanPlayer.setTipo("humano");
            
            jogadores.add(humanPlayer);
        }
        numJogadoresComputador = UserInterface.Dialogo.quantidadeJogadoresComputador();
        int j;
        for(j=0;j<numJogadoresComputador;j++)
        {
        	String nomeJogadorComputador = UserInterface.Dialogo.nomeJogadorComputador(j+1);
        	
        	cores = new String[arrayCores.size()];
            cores = arrayCores.toArray(cores);
            int corJogadorComputador = UserInterface.Dialogo.corJogador(j+1, cores);
            switch (corJogadorComputador){
            	case 0: arrayCores.remove("Branco");
            		break;
            	case 1: arrayCores.remove("Preto");
    			break;
            	case 2: arrayCores.remove("Azul");
			break;
            	case 3: arrayCores.remove("Amarelo");
			break;
            	case 4: arrayCores.remove("Verde");
			break;
            	case 5: arrayCores.remove("Vermelho");
			break;
            default:break;
            }
            
            dados = gerador.nextInt(12)+1;
            JogadorComputador computerPlayer = new JogadorComputador();
            computerPlayer.setCor(corJogadorComputador);
            computerPlayer.setName(nomeJogadorComputador);
            computerPlayer.setSaldo(Definicoes.QUANTIA_INICIAL);
            computerPlayer.setResultadoDados(dados);
            computerPlayer.setTipo("computador");
            
            jogadores.add(computerPlayer);
        }
        
        //Collections.sort(jogadores); //jogadores ordenados no Array pela vez de jogar
        
        //EXIBIR ELEMENTOS DA INTERFACE
        UserInterface.Botoes.mostrarBotaoDados();
        UserInterface.Botoes.mostrarBotaoTurno();
        UserInterface.Labels.exibirLabels();
        UserInterface.Pecas.adicionarAzul();

        //Inicia a partida
        horaAtual = System.currentTimeMillis();
        horaFinal  = horaAtual + (tempoMaxMinu * 60000);
        
        
        
        
        
    }
}
