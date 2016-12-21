package Elementos;
import java.util.ArrayList;
import java.util.Deque;

import Elementos.Jogador;

public class CartaVisitante extends Carta {

	@Override
	public void Efeito(Jogador jogador, ArrayList<Jogador> jogadores,int resultado_dados,ArrayList<Carta> cartas_ordem_tabuleiro, Deque<CartaSorteOuReves> cartas_sorte_ou_reves,ArrayList<CartaPropriedade> cartas_propriedades, ArrayList<CartaCompanhia> cartas_companhias)
	{
		//faz nada com o jogador
		System.out.println("O jogador " + jogador.getName() + " entrou de ferias com a familia. Sem efeitos nesta casa.");
	}
}
