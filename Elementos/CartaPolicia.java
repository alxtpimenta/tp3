package Elementos;

import java.util.ArrayList;
import java.util.Deque;

public class CartaPolicia extends Carta{

	@Override
	public void Efeito(Jogador jogador,ArrayList<Jogador> jogadores, int resultado_dados,ArrayList<Carta> cartas_ordem_tabuleiro, Deque<CartaSorteOuReves> cartas_sorte_ou_reves,ArrayList<CartaPropriedade> cartas_propriedades, ArrayList<CartaCompanhia> cartas_companhias)
	{
            //manda o jogador para a cadeia posicao 10 no array
            UserInterface.Dialogo.avisoGenerico("O jogador " + jogador.getName() + " foi preso! Voce deve permanecer preso por 3 rodadas ou usar uma carta habeas corpus");
            //System.out.println("O jogador " + jogador.getName() + " foi preso! Voce deve permanecer preso por 3 rodadas ou usar uma carta habeas corpus");
            jogador.setPosicaoTabuleiro(10);
            jogador.setPreso(true);
            jogador.setDiasDePrisaoRestantes(3);
	}
	
        public String tooltip()
        {
            return this.getNome();
        }
}
