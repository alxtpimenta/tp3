package Elementos;

import java.util.ArrayList;
import java.util.Deque;

public class CartaSorteOuRevesAuxiliar extends Carta{

	//funcao retira uma carta do topo da lista sorte_ou_reves e cumpre seu efeito
	@Override
	public void Efeito(Jogador jogador,ArrayList<Jogador> jogadores, int resultado_dados, ArrayList<Carta> cartas_ordem_tabuleiro, Deque<CartaSorteOuReves> cartas_sorte_ou_reves,ArrayList<CartaPropriedade> cartas_propriedades, ArrayList<CartaCompanhia> cartas_companhias)
	{		
		//tira carta do topo
		CartaSorteOuReves card = cartas_sorte_ou_reves.pop();
		
		UserInterface.Dialogo.avisoGenerico("Sorte ou reves: " + card.getNome());		
		
            switch (card.getAction()) {
                case 0:
                    jogador.setSaldo(jogador.getSaldo() - card.getQuantidade());
                    break;
                case 1:
                    jogador.setSaldo(jogador.getSaldo() + card.getQuantidade());
                    break;
                case 2:
                    jogador.setPosicaoTabuleiro(10);
                    jogador.setPreso(true);
                    jogador.setDiasDePrisaoRestantes(3);
                    break;
                case 3:
                    jogador.setSaldo(jogador.getSaldo() + 200000);
                    jogador.setPosicaoTabuleiro(0);
                    break;
                case 4:
                    if(resultado_dados % 2 == 0)
                    {
                        jogador.setSaldo(jogador.getSaldo() + 100000);
                    }
                    else
                    {
                        jogador.setSaldo(jogador.getSaldo() - 100000);
                    }
                    break;
                case 5:
                    for(int i=0;i<jogadores.size();i++)
                    {
                        if(jogadores.get(i).getId() != jogador.getId())
                        {
                            jogadores.get(i).setSaldo(jogadores.get(i).getSaldo() - 50000);
                            jogador.setSaldo(jogador.getSaldo() + 50000);
                        }
                    }
                    break;
                case 6:
                    card.setOwner(jogador.getId());
                    break;
                case 7:
                    card.setOwner(jogador.getId());
                    break;
                case 8:
                    //Rodada nova_rodada = new Rodada();
                    //cartas_sorte_ou_reves.add(card);
                    //nova_rodada.NovaRodada(jogador, jogadores, cartas_ordem_tabuleiro, cartas_sorte_ou_reves, cartas_propriedades, cartas_companhias);
                    break;
                default:
                    break;
            }
		
		//bota a carta no fundo se nao for atribuida a um jogador
		if(card.getAction() != 6 && card.getAction() != 7)
		{
			cartas_sorte_ou_reves.add(card);
		}
		
		
	}
        
        @Override
        public String tooltip(ArrayList<Jogador> jogadores)
        {
            return this.getNome();
        }
}
