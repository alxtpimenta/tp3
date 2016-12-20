package Elementos;

import java.util.ArrayList;
import java.util.Deque;
import Elementos.Carta;
import Elementos.CartaSorteOuReves;

public class CartaSorteOuRevesAuxiliar extends Carta{

	//funcao retira uma carta do topo da lista sorte_ou_reves e cumpre seu efeito
	@Override
	public void Efeito(Jogador jogador,ArrayList<Jogador> jogadores, int resultado_dados, ArrayList<Carta> cartas_ordem_tabuleiro, Deque<CartaSorteOuReves> cartas_sorte_ou_reves,ArrayList<CartaPropriedade> cartas_propriedades, ArrayList<CartaCompanhia> cartas_companhias)
	{		
		//tira carta do topo
		CartaSorteOuReves card = cartas_sorte_ou_reves.pop();
		
		System.out.println("Sua carta de sorte ou reves e de +" + card.getCategoria() + "!");		
		
		if(card.getAction() == 0)
		{
			System.out.println(card.getNome());
			jogador.setSaldo(jogador.getSaldo() - card.getQuantidade());
		}
		else if(card.getAction() == 1)
		{
			System.out.println(card.getNome());
			jogador.setSaldo(jogador.getSaldo() + card.getQuantidade());
		}
		else if(card.getAction() == 2)
		{
			System.out.println(card.getNome());			
			jogador.setPosicaoTabuleiro(10);
			jogador.setPreso(true);
			jogador.setDiasDePrisaoRestantes(3);
		}
		else if(card.getAction() == 3)
		{
			System.out.println(card.getNome());
			jogador.setSaldo(jogador.getSaldo() + 200000);
			jogador.setPosicaoTabuleiro(0);
		}
		else if(card.getAction() == 4)
		{
			System.out.println(card.getNome());
			if(resultado_dados % 2 == 0)
			{
				jogador.setSaldo(jogador.getSaldo() + 100000);
			}
			else
			{
				jogador.setSaldo(jogador.getSaldo() - 100000);
			}
		}
		else if(card.getAction() == 5)
		{
			System.out.println(card.getNome());	
			for(int i=0;i<jogadores.size();i++)
			{
				if(jogadores.get(i).getId() != jogador.getId())
				{
					jogadores.get(i).setSaldo(jogadores.get(i).getSaldo() - 50000);
					jogador.setSaldo(jogador.getSaldo() + 50000);
				}
			}
			
		}
		else if(card.getAction() == 6)
		{
			System.out.println(card.getNome());	
			card.setOwner(jogador.getId());
		}
		else if(card.getAction() == 7)
		{
			System.out.println(card.getNome());
			card.setOwner(jogador.getId());
			
		}
		else if(card.getAction() == 8)
		{
			System.out.println(card.getNome());
			Rodada nova_rodada = new Rodada();
			nova_rodada.NovaRodada(jogador, jogadores, cartas_ordem_tabuleiro, cartas_sorte_ou_reves, cartas_propriedades, cartas_companhias);
		}
		
		//bota a carta no fundo se nao for atribuida a um jogador
		cartas_sorte_ou_reves.add(card);
		
	}	
}
