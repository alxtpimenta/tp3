package Elementos;
import UserInterface.Botoes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Deque;


public class Rodada {

	
    public static boolean rolarDados = false;
    public static boolean modoCompra = false;
    public static boolean propriedadeJogador = false;
    public static boolean esperarAcao = false;
    public static boolean finalizarTurno = false;
    
    public void NovaRodada(Jogador jogador, ArrayList<Jogador> jogadores,ArrayList<Carta> cartas_ordem_tabuleiro, Deque<CartaSorteOuReves> cartas_sorte_ou_reves,ArrayList<CartaPropriedade> cartas_propriedades, ArrayList<CartaCompanhia> cartas_companhias,ArrayList<Casa> casasInterface, int ID)
	{
		//habilitar botoes dessas opcoes apos efeito inicial cumprido
		boolean ofertas = false;
		boolean vender = false;
		boolean hipotecar = false;
		boolean comprar = false;
                
                //Habilitar botoes iniciais
                Botoes.mostrarBotaoDados();
		
		//check se o jogador esta preso
		if(jogador.getPreso() == true)
		{
			UserInterface.Dialogo.avisoGenerico("Voce ainda esta preso. Se tiver e se quiser, use a carta de habeas corpus ou finalize a rodada.");
			//se tiver habeas corpus o botao de usa-lo deve aparecer
			//se nao tiver nenhuma outra opcao pode ser mostrada, e apenas a finalizar rodada
			
			
			//ACTION LISTENER > BOTAO HABEAS CORPUS
			//se usado, mudar as condicoes e finaliza rodada
			//ACTION LISTENER > BOTAO FINALIZAR RODADA
			//reduzir os dias de prisao restantes, mudar a condicao de preso se dias == 0
			//ACTION LISTENER BOTAO "TENTAR A SORTE" > jogador rolar os dados, se tirar dois numeros iguals ele sai da cadeia, atualiza condicoes
			//estes devem ser os unicos botoes mostrados ou "com cor diferente" para mostrar que podem ser utilizados
		}
		else
                {
                    Botoes.mostrarBotaoDados();
                    while(!rolarDados)
                    {
                        Botoes.jogarDados.addActionListener(new ActionListener()
                        {
                           @Override
                            public void actionPerformed(ActionEvent e) 
                            {
                                Rodada.rolarDados = true;
                            } 
                        });
                    }
                    if(Rodada.rolarDados)
                    {
			//jogador rola dados. ASSOCIAR A UM BOTAO
			//PARTE OBRIGATORIA - CUMPRE ANTES DE TER OPCOES
			Dados dados = new Dados();
			int resultado_dados = dados.RolarDados();
                        UserInterface.Dialogo.jogarDados(resultado_dados);
			int posicao_jogador = jogador.getPosicaoTabuleiro() + resultado_dados;
			if(posicao_jogador > 39)
			{
				posicao_jogador = posicao_jogador - 40;
			}
			//seta nova posicao do jogador no tabuleiro (pode ser mudada com efeito a seguir)
			jogador.setPosicaoTabuleiro(posicao_jogador);
                        //Atualiza a posição na GUI
                        RefreshGUI.atualizarJogadoresXY(jogadores, casasInterface);
                        RefreshGUI.atualizarPinos(jogadores);
			//invoca efeito da carta da posicao do jogador
			cartas_ordem_tabuleiro.get(posicao_jogador).Efeito(jogador, jogadores,resultado_dados,cartas_ordem_tabuleiro,cartas_sorte_ou_reves,cartas_propriedades,cartas_companhias);
                        //Atualiza a GUI após o efeito
                        RefreshGUI.atualizarJogadoresXY(jogadores, casasInterface);
                        RefreshGUI.atualizarLabels(jogadores, ID);
                        RefreshGUI.atualizarPinos(jogadores);
                        RefreshGUI.atualizarTooltip(cartas_ordem_tabuleiro, jogadores, ID);
                        UserInterface.Tabuleiro.refresh();
                        RefreshGUI.atualizarLabels(jogadores, ID);
			
			System.out.println(jogador.getPosicaoTabuleiro() + " " + jogador.getPreso() + " " + jogador.getSaldo());
                        //Se for uma propriedade ou companhia e o jogador não for dono, ir para o modo de compra
                        if(("company".equals(cartas_ordem_tabuleiro.get(posicao_jogador).getCategoria())
                                || "property".equals(cartas_ordem_tabuleiro.get(posicao_jogador).getCategoria()))
                                && cartas_ordem_tabuleiro.get(posicao_jogador).getOwner() != jogador.getId())
                        {
                            //Atualizar botoes
                            Botoes.mostrarBotaoTurno();
                            Botoes.removerBotaoDados();
                            esperarAcao = false;
                            while(!esperarAcao)
                            {
                                //ESPERAR ACAO DO JOGADOR
                                Botoes.finalizarTurno.addActionListener(new ActionListener()
                                {
                                    @Override
                                    public void actionPerformed(ActionEvent e) 
                                    {
                                        Rodada.esperarAcao = true;
                                        Rodada.finalizarTurno = true;
                                    }        
                                });
                            }
                            if(modoCompra)
                            {
                                //REALIZAR COMPRA
                            }
                            else if(Rodada.finalizarTurno)
                            {
                                //Anula os controladores do loop para pular o turno
                                Rodada.esperarAcao = false;
                                Rodada.finalizarTurno = false;
                                Botoes.finalizarTurno.removeAll();
                                Botoes.removerBotaoTurno();
                            }
                        }
                        //Se a propriedade for do jogador
                        else if(("company".equals(cartas_ordem_tabuleiro.get(posicao_jogador).getCategoria())
                                || "property".equals(cartas_ordem_tabuleiro.get(posicao_jogador).getCategoria()))
                                && cartas_ordem_tabuleiro.get(posicao_jogador).getOwner() == jogador.getId())
                        {
                            //MOSTRAR OPCOES DE COMPRA DE CASA/HOTEL/HIPOTECA
                            UserInterface.Dialogo.avisoGenerico("ERRO!!!");
                        }
			//PARTE DE OPCOES - DEPENDE DA POSICAO
			//*********
			//se carta for PROPRIEDADE OU COMPANHIA e owner == 9 > mostrar opcao de comprar
			//> ao clicar, abrir dialogo > ACTION LISTENER > aceitar modificar atributo owner na lista correspondente (lista de propriedades e lista de companhias)
			
			//se carta for do proprio jogador
			//mostrar opcao de comprar casa ou hotel dependendo do numero de casas que ja tem na propriedade. Novamente ACTION LISTENER> abrir dialogo de confirmacao
			//atualizar propriedade numero de casas
			
			//se carta for do proprio jogador > BOTAO OPCAO DE VENDA
			//se carta for do proprio jogador > BOTAO OPCAO DE HIPOTECA
			//**********
			
			//opcoes de oferta GLOBIAS INDEPENDE DA CARTA> BOTAO> abrir combobox com opcoes de propriedades a serem ofertadas (lista de propriedades com dono) dialogo para preencher valor da oferta
			//fazer AI DO COMPUTADOR PARA ACEITAR OU DECLINAR
			//LOOP ATE FINALIZAR A RODADA
			
			//CRIAR DIALOGO DE ACEITAR OFERTA EXTERNA (A QUALQUER MOMENTO)
                        //Anular os controladores para a proxima rodada
                        Rodada.rolarDados = false;
                        Botoes.jogarDados.removeAll();
                    }

			
		}
                /*//ATUALIZA A GUI
                RefreshGUI.atualizarPinos(jogadores);
                RefreshGUI.atualizarLabels(jogadores, jogador.getId());
                UserInterface.Tabuleiro.refresh();*/
	}
}
