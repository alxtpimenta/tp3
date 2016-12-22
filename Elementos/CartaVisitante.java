package Elementos;
import java.util.ArrayList;
import java.util.Deque;


public class CartaVisitante extends Carta {

	@Override
	public void Efeito(Jogador jogador, ArrayList<Jogador> jogadores,int resultado_dados,ArrayList<Carta> cartas_ordem_tabuleiro, Deque<CartaSorteOuReves> cartas_sorte_ou_reves,ArrayList<CartaPropriedade> cartas_propriedades, ArrayList<CartaCompanhia> cartas_companhias)
	{
		//SAIDA GUI
		UserInterface.Dialogo.avisoGenerico("O jogador " + jogador.getName() + " esta apenas visitando a cadeia! Que sorte!");
	}
        
        @Override
        public String tooltip(ArrayList<Jogador> jogadores)
        {
            return this.getNome();
        }
}
