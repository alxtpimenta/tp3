package Elementos;

import java.util.ArrayList;
import java.util.Deque;

public class CartaFerias extends Carta {

	@Override
	public void Efeito(Jogador jogador, ArrayList<Jogador> jogadores, int resultado_dados, ArrayList<Carta> cartas_ordem_tabuleiro,Deque<CartaSorteOuReves> cartas_sorte_ou_reves,ArrayList<CartaPropriedade> cartas_propriedades, ArrayList<CartaCompanhia> cartas_companhias,ArrayList<CartaSorteOuReves> cartas_nao_devolvidas_sorteoureves)
	{
            //SAIDA GUI
            UserInterface.Dialogo.avisoGenerico("O jogador " + jogador.getName() + " entrou de ferias com a familia!");
	}
        
        @Override
        public String tooltip(ArrayList<Jogador> jogadores)
        {
            return this.getNome();
        }
	
}
