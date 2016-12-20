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
import Elementos.Dados;
import Elementos.Setup;
import Elementos.Carta;
import Elementos.CartaCompanhia;
import Elementos.CartaPropriedade;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import Elementos.Rodada;
import UserInterface.Labels;
import Elementos.CartaSorteOuReves;

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
        int numero_jogadores = 0;
        
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
            humanPlayer.setId(numero_jogadores);
            humanPlayer.setCor(corJogadorLocal);
            humanPlayer.setName(nomeJogadorLocal);
            humanPlayer.setSaldo(Definicoes.QUANTIA_INICIAL);
            humanPlayer.setResultadoDados(dados);
            humanPlayer.setTipo("humano");
            humanPlayer.setPosicaoTabuleiro(0);
            humanPlayer.setPreso(false);
            humanPlayer.setDiasDePrisaoRestantes(0);
            numero_jogadores++;
            
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
            computerPlayer.setId(numero_jogadores);
            computerPlayer.setCor(corJogadorComputador);
            computerPlayer.setName(nomeJogadorComputador);
            computerPlayer.setSaldo(Definicoes.QUANTIA_INICIAL);
            computerPlayer.setResultadoDados(dados);
            computerPlayer.setTipo("computador");
            computerPlayer.setPosicaoTabuleiro(0);
            computerPlayer.setPreso(false);
            computerPlayer.setDiasDePrisaoRestantes(0);
            numero_jogadores++;
            
            jogadores.add(computerPlayer);
        }
        
        //lista jogadores ok
        System.out.println("Jogadores no jogo:");
        for(int k=0;k<jogadores.size();k++)
        {
        	System.out.println(jogadores.get(k).getName() + " " + jogadores.get(k).getTipo());
        }
        
        //construcao do deque e das cartas na ordem do tabuleiro
        Deque<CartaSorteOuReves> deque_cartas_sorte_ou_reves = Setup.MontarBaralhoSorteOuReves();
        ArrayList<Carta> cartas_na_ordem_do_tabuleiro = Setup.MontarBaralhoGeral();
        
        //construcao do baralho so de propriedade
        ArrayList<CartaPropriedade> cartas_propriedades = new ArrayList<>();
        //construcao do baralho so de companhias
        ArrayList<CartaCompanhia> cartas_companhia = new ArrayList<>();
        for(Carta card:cartas_na_ordem_do_tabuleiro)
        {
        	if(card.getCategoria().compareTo("property") == 0)
        	{
        		cartas_propriedades.add((CartaPropriedade)card);
        	}
        	else if(card.getCategoria().compareTo("company") == 0)
        	{
        		cartas_companhia.add((CartaCompanhia)card);
        	}
        	
        }
                
        //EXIBIR ELEMENTOS DA INTERFACE
        UserInterface.Botoes.mostrarBotaoDados();
        UserInterface.Botoes.mostrarBotaoTurno();
        UserInterface.Labels.exibirLabels();
        UserInterface.Pecas.adicionarAzul();

        //Inicia a partida
        horaAtual = System.currentTimeMillis();
        horaFinal  = horaAtual + (tempoMaxMinu * 60000);
        
        //decidindo a ordem dos jogadores
        System.out.println("Decidindo ordem dos jogadores:");
        
        Dados resultado_dados = new Dados();
        
        //rolando dados para cada jogador, disputa de vez
        for(int k=0;k<jogadores.size();k++)
        {
        	jogadores.get(k).setResultadoDados(resultado_dados.RolarDados());
        	System.out.println("O jogador " + jogadores.get(k).getName() + " rolou os dados e tirou " + jogadores.get(k).getResultados() + "!");
        }
        
        //ordena jogadores de acordo com o numero tirado no dado. Esta ordem vai se manter ate o final
        Collections.sort(jogadores);
        
        //inicia nova rodada at� que s� tenha um jogador, que ser� o vencedor
        int indice_jogador_da_vez = 0;
        System.out.println("Iniciando nova rodada: vez do " + jogadores.get(indice_jogador_da_vez).getName());
        Rodada nova_rodada = new Rodada();
        
        //inicializar todos os labels ancorados a um jogador
        //teste de labels
        Labels.alterarNomeJogador("Pedro");
        Labels.alterarDinheiro(10000);
        Labels.alterarTooltip("no ideia");
        
        //ACTION_LISTENER > S� VAI PARA FRENTE SE O JOGADOR CLICAR "JOGAR DADOS"
        //"JOGAR DADOS" DEVE SER O UNICO BOTAO VISIVEL        
        
        //teste com 1 loop
        int t=0;
        //jogadores.size() > 1
        while(t < 1)
        {
        	nova_rodada.NovaRodada(jogadores.get(indice_jogador_da_vez),jogadores,cartas_na_ordem_do_tabuleiro,deque_cartas_sorte_ou_reves,cartas_propriedades,cartas_companhia);
        	
        	if(jogadores.get(indice_jogador_da_vez).getSaldo() <= 0)
        	{
        		jogadores.remove(indice_jogador_da_vez);
        		System.out.println("O jogador " + jogadores.get(indice_jogador_da_vez).getName() + "perdeu e foi removido do jogo.");
        	}
        	indice_jogador_da_vez++;
        	if(indice_jogador_da_vez >= jogadores.size())
        	{
        		indice_jogador_da_vez = 0;
        	}
        	t++;
        }
                
    }
}
