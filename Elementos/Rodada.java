package Elementos;
import java.util.ArrayList;
import Elementos.Jogador;
import Elementos.JogadorComputador;
import Elementos.JogadorLocal;
import Elementos.Carta;
import java.util.Deque;
import Elementos.Dados;


public class Rodada {

	
	public void NovaRodada(Jogador jogador, ArrayList<Jogador> jogadores,ArrayList<Carta> cartas_ordem_tabuleiro, Deque<CartaSorteOuReves> cartas_sorte_ou_reves,ArrayList<CartaPropriedade> cartas_propriedades, ArrayList<CartaCompanhia> cartas_companhias)
	{
		//habilitar botoes dessas opcoes apos efeito inicial cumprido
		boolean ofertas = false;
		boolean vender = false;
		boolean hipotecar = false;
		boolean comprar = false;
		
		//check se o jogador esta preso
		if(jogador.getPreso() == true)
		{
			System.out.println("Voce ainda esta preso. Se tiver e se quiser, use a carta de habeas corpus ou finalize a rodada.");
			//se tiver habeas corpus o botao de usa-lo deve aparecer
			//se nao tiver nenhuma outra opcao pode ser mostrada, e apenas a finalizar rodada
			
			
			//ACTION LISTENER > BOTAO HABEAS CORPUS
			//se usado, mudar as condicoes e finaliza rodada
			//ACTION LISTENER > BOTAO FINALIZAR RODADA
			//reduzir os dias de prisao restantes, mudar a condicao de preso se dias == 0
			//ACTION LISTENER BOTAO "TENTAR A SORTE" > jogador rolar os dados, se tirar dois numeros iguals ele sai da cadeia, atualiza condicoes
			//estes devem ser os unicos botoes mostrados ou "com cor diferente" para mostrar que podem ser utilizados
		}
		else{
		
			//jogador rola dados. ASSOCIAR A UM BOTAO
			//PARTE OBRIGATORIA - CUMPRE ANTES DE TER OPCOES
			Dados dados = new Dados();
			int resultado_dados = dados.RolarDados();
			int posicao_jogador = jogador.getPosicaoTabuleiro() + resultado_dados;
			if(posicao_jogador > 39)
			{
				posicao_jogador = posicao_jogador - 40;
			}
			//seta nova posicao do jogador no tabuleiro (pode ser mudada com efeito a seguir)
			jogador.setPosicaoTabuleiro(posicao_jogador);
			//invoca efeito da carta da posicao do jogador
			cartas_ordem_tabuleiro.get(23).Efeito(jogador, jogadores,resultado_dados,cartas_ordem_tabuleiro,cartas_sorte_ou_reves,cartas_propriedades,cartas_companhias);
						
			System.out.println(jogador.getPosicaoTabuleiro() + " " + jogador.getPreso() + " " + jogador.getSaldo());
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
			
		}
	}
}
