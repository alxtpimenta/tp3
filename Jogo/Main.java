/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogo;



import java.util.*;
import Elementos.Jogador;
import Propriedades.Definicoes;
import UserInterface.Tabuleiro;
import java.io.IOException;
import Elementos.Dados;
import Propriedades.Setup;
import Elementos.Carta;
import Elementos.CartaCompanhia;
import Elementos.CartaPropriedade;
import java.util.ArrayList;
import java.util.Deque;
import Elementos.CartaSorteOuReves;
import Elementos.Casa;
import Proxy.RefreshGUI;

public class Main 
{
    public static void main(String[] args) throws IOException 
    {
        int numJogadoresLocais = -1;
        ArrayList<Jogador> jogadores;
        ArrayList<String> arrayCores;
        String [] cores;
        int i;
        int dados;
        Random gerador;
        
        //INICIALIZACAO DA INTERFACE
        ArrayList<Casa> casasInterface = Setup.carregarCasas();
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
            Jogador humanPlayer = new Jogador();
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
        //construcao do deque e das cartas na ordem do tabuleiro
        ArrayList<Carta> cartasTabuleiro = Setup.MontarBaralhoGeral();
        Deque<CartaSorteOuReves> cartasSorteReves = Setup.MontarBaralhoSorteOuReves();
        //construcao do baralho so de propriedade
        ArrayList<CartaPropriedade> cartasPropriedade = new ArrayList<>();
        //construcao do baralho so de companhias
        ArrayList<CartaCompanhia> cartasCompanhia = new ArrayList<>();
        cartasTabuleiro.forEach((card) -> {
            if(card.getCategoria().compareTo("property") == 0)
            {
                cartasPropriedade.add((CartaPropriedade)card);
            }
            else if(card.getCategoria().compareTo("company") == 0)
            {
                cartasCompanhia.add((CartaCompanhia)card);
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
        int indiceJogador = 0;
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
            RefreshGUI.atualizarTooltip(cartasTabuleiro, jogadores,jogadores.get(indiceJogador));
            RefreshGUI.atualizarLabels(jogadores, indiceJogador);
            UserInterface.Tabuleiro.refresh();
            UserInterface.Dialogo.avisoGenerico("Iniciando nova rodada: " + jogadores.get(indiceJogador).getName());
            //FIM DA ATUALIZAÇÃO DA INTERFACE
            nova_rodada.NovaRodada(jogadores.get(indiceJogador),jogadores,cartasTabuleiro,cartasSorteReves,cartasPropriedade,cartasCompanhia,casasInterface, indiceJogador);
            //ATUALIZA A INTERFACE APOS A JOGADA
            RefreshGUI.atualizarTooltip(cartasTabuleiro, jogadores, jogadores.get(indiceJogador));
            RefreshGUI.atualizarJogadoresXY(jogadores, casasInterface);
            RefreshGUI.atualizarPinos(jogadores);
            RefreshGUI.atualizarLabels(jogadores, indiceJogador);
            UserInterface.Tabuleiro.refresh();
            //VERIFICAR FALENCIA
            if(jogadores.get(indiceJogador).getSaldo() <= 0)
            {
                UserInterface.Dialogo.avisoGenerico("" + jogadores.get(indiceJogador).getName() + " faliu e saiu do jogo.");
                //DESTITUIR PROPRIEDADES DO FALIDO
                Setup.destituirPropriedades(cartasTabuleiro, jogadores.get(indiceJogador));
                //REMOVER PEÃO DO TABULEIRO
                switch(jogadores.get(indiceJogador).getCor())
                {
                    case Definicoes.BRANCO:
                        UserInterface.Pecas.removerBranco();
                       break;
                  case Definicoes.PRETO:
                        UserInterface.Pecas.removerPreto();
                        break;
                    case Definicoes.AZUL:
                        UserInterface.Pecas.removerAzul();
                        break;
                    case Definicoes.AMARELO:
                        UserInterface.Pecas.removerAmarelo();
                        break;
                       case Definicoes.VERDE:
                       UserInterface.Pecas.removerVerde();
                        break;
                    case Definicoes.VERMELHO:
                        UserInterface.Pecas.removerVermelho();
                }
                //REMOVER DA LISTA
                jogadores.remove(indiceJogador);
            }
            //AVANÇAR JOGADOR
            indiceJogador++;
            if(indiceJogador >= jogadores.size())
            {
        	indiceJogador = 0;
            }
        }
        //FIM DE JOGO
        UserInterface.Dialogo.avisoGenerico("Fim de jogo! "+jogadores.get(indiceJogador).getName()+" venceu!");
                
    }
}
