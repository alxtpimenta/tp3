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
import Elementos.Rodada;
import Elementos.CartaSorteOuReves;
import Elementos.Casa;
import Elementos.RefreshGUI;
import Propriedades.Leitores;

public class Main 
{
    public static void main(String[] args) throws IOException 
    {
        int numJogadoresLocais = -1;
        int numJogadoresComputador;
        ArrayList<Jogador> jogadores;
        ArrayList<String> arrayCores;
        String [] cores;
        long tempoMaxMinu;
        long horaAtual;
        int i;
        int dados;
        Random gerador;
        
        //INICIALIZACAO DA INTERFACE
        ArrayList<Casa> casasInterface = Leitores.carregarCasas();
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
        
        jogadores = new ArrayList<>();    
        gerador = new Random(); //gerador de nÃºmeros aleatÃ³rios
        
    	arrayCores = new ArrayList<>();
    	arrayCores.add("Branco");
    	arrayCores.add("Preto");
    	arrayCores.add("Azul");
    	arrayCores.add("Amarelo");
    	arrayCores.add("Verde");
    	arrayCores.add("Vermelho");

        //Preenche a lista de jogadores usando a interface
        int ID = 0;
        //GARANTE QUE A ENTRADA IRÁ SER SEMRPE UM INTEIRO MAIOR OU IGUAL DOIS E MENOR OU IGUAL A SEIS
        while(true)
        {
            numJogadoresLocais = UserInterface.Dialogo.quantidadeJogadoresLocais();
            if((numJogadoresLocais > Definicoes.MIN_JOGADORES-1) && (numJogadoresLocais < Definicoes.MAX_JOGADORES +1))
                break;
            else
                UserInterface.Dialogo.avisoGenerico("Entrada inválida!");
        }
        
        for(i = 0; i < numJogadoresLocais; i++)
        {
            String nomeJogadorLocal = UserInterface.Dialogo.nomeJogador(i+1);
            
            cores = new String[arrayCores.size()];
            cores = arrayCores.toArray(cores);
            int corJogadorLocal = UserInterface.Dialogo.corJogador(i+1, cores);
            switch (corJogadorLocal){
            	case Definicoes.BRANCO: arrayCores.remove("Branco");
            		break;
            	case Definicoes.PRETO: arrayCores.remove("Preto");
    			break;
            	case Definicoes.AZUL: arrayCores.remove("Azul");
			break;
            	case Definicoes.AMARELO: arrayCores.remove("Amarelo");
			break;
            	case Definicoes.VERDE: arrayCores.remove("Verde");
			break;
            	case Definicoes.VERMELHO: arrayCores.remove("Vermelho");
			break;
            default:break;
            }
            
            dados = gerador.nextInt(12)+1;
            JogadorLocal humanPlayer = new JogadorLocal();
            humanPlayer.setId(ID);
            humanPlayer.setCor(corJogadorLocal);
            humanPlayer.setName(nomeJogadorLocal);
            humanPlayer.setSaldo(Definicoes.QUANTIA_INICIAL);
            humanPlayer.setResultadoDados(dados);
            humanPlayer.setTipo("humano");
            humanPlayer.setPosicaoTabuleiro(0);
            humanPlayer.setPreso(false);
            humanPlayer.setDiasDePrisaoRestantes(0);
            humanPlayer.setX(casasInterface.get(Definicoes.CASA_INICIAL_GUI).x());
            humanPlayer.setY(casasInterface.get(Definicoes.CASA_INICIAL_GUI).y());
            ID++;
            
            jogadores.add(humanPlayer);
        }
        
        /*
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
            computerPlayer.setX(casasInterface.get(Definicoes.CASA_INICIAL_GUI).x());
            computerPlayer.setY(casasInterface.get(Definicoes.CASA_INICIAL_GUI).y());
            numero_jogadores++;
            
            jogadores.add(computerPlayer);
        }
        */
        
        //construcao do deque e das cartas na ordem do tabuleiro
        ArrayList<Carta> cartas_na_ordem_do_tabuleiro = Setup.MontarBaralhoGeral();
        Deque<CartaSorteOuReves> deque_cartas_sorte_ou_reves = Setup.MontarBaralhoSorteOuReves();
        
        //construcao do baralho so de propriedade
        ArrayList<CartaPropriedade> cartas_propriedades = new ArrayList<>();
        //construcao do baralho so de companhias
        ArrayList<CartaCompanhia> cartas_companhia = new ArrayList<>();
        cartas_na_ordem_do_tabuleiro.forEach((card) -> {
            if(card.getCategoria().compareTo("property") == 0)
            {
                cartas_propriedades.add((CartaPropriedade)card);
            }
            else if(card.getCategoria().compareTo("company") == 0)
            {
                cartas_companhia.add((CartaCompanhia)card);
            }
        });
        
        Dados resultado_dados = new Dados();
        
        //rolando dados para cada jogador, disputa de vez
        for(int k=0;k<jogadores.size();k++)
        {
        	jogadores.get(k).setResultadoDados(resultado_dados.RolarDados());
        }
        
        //ordena jogadores de acordo com o numero tirado no dado. Esta ordem vai se manter ate o final
        Collections.sort(jogadores);
        
        //inicia nova rodada at� que s� tenha um jogador, que ser� o vencedor
        int indice_jogador_da_vez = 0;
        //
        UserInterface.Dialogo.avisoGenerico("O jogador " + jogadores.get(0).getName() + " rolou os dados e tirou " + jogadores.get(0).getResultados()+", e sera o primeiro a jogar!");
        //System.out.println("Iniciando nova rodada: vez do " + jogadores.get(indice_jogador_da_vez).getName());
        Rodada nova_rodada = new Rodada(); 
        
        //ADICIONAR AS PECAS DE CADA JOGADOR
        for( i =0; i < jogadores.size();i++)
        {
            switch(jogadores.get(i).getCor())
            {
                case Definicoes.BRANCO:
                    UserInterface.Pecas.adicionarBranco();
                    break;
                case Definicoes.PRETO:
                    UserInterface.Pecas.adicionarPreto();
                    break;
                case Definicoes.AZUL:
                    UserInterface.Pecas.adicionarAzul();
                    break;
                case Definicoes.AMARELO:
                    UserInterface.Pecas.adicionarAmarelo();
                    break;
                case Definicoes.VERDE:
                    UserInterface.Pecas.adicionarVerde();
                    break;
                case Definicoes.VERMELHO:
                    UserInterface.Pecas.adicionarVermelho();
            } 
        }
        //INICIALIZAR ELEMENTOS DA INTERFACE
        //EXIBIR LABELS
        UserInterface.Labels.exibirLabels();
        //INÍCIO DO LOOP DE JOOGO
        while(jogadores.size() > 1)
        {
            //ATUALIZA A INTERFACE
            //ATUALIZAR POSIÇÃO DOS PINOS DE CADA JOGADOR
            RefreshGUI.atualizarJogadoresXY(jogadores, casasInterface);
            RefreshGUI.atualizarPinos(jogadores);
            RefreshGUI.atualizarTooltip(cartas_na_ordem_do_tabuleiro, jogadores,indice_jogador_da_vez);
            RefreshGUI.atualizarLabels(jogadores, indice_jogador_da_vez);
            UserInterface.Tabuleiro.refresh();
            UserInterface.Dialogo.avisoGenerico("Iniciando nova rodada: " + jogadores.get(indice_jogador_da_vez).getName());
            //FIM DA ATUALIZAÇÃO DA INTERFACE
            nova_rodada.NovaRodada(jogadores.get(indice_jogador_da_vez),jogadores,cartas_na_ordem_do_tabuleiro,deque_cartas_sorte_ou_reves,cartas_propriedades,cartas_companhia,casasInterface, indice_jogador_da_vez);
            //ATUALIZA A INTERFACE APOS A JOGADA
            RefreshGUI.atualizarTooltip(cartas_na_ordem_do_tabuleiro, jogadores, indice_jogador_da_vez);
            RefreshGUI.atualizarJogadoresXY(jogadores, casasInterface);
            RefreshGUI.atualizarPinos(jogadores);
            RefreshGUI.atualizarLabels(jogadores, indice_jogador_da_vez);
            UserInterface.Tabuleiro.refresh();
            //VERIFICAR FALENCIA
            if(jogadores.get(indice_jogador_da_vez).getSaldo() <= 0)
            {
                jogadores.remove(indice_jogador_da_vez);
                UserInterface.Dialogo.avisoGenerico("" + jogadores.get(indice_jogador_da_vez).getName() + "faliu e saiu do jogo.");
            }
            //AVANÇAR JOGADOR
            indice_jogador_da_vez++;
            if(indice_jogador_da_vez >= jogadores.size())
            {
        	indice_jogador_da_vez = 0;
            }
        }
                
    }
}
