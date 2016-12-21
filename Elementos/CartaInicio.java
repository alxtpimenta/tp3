package Elementos;

import java.util.ArrayList;
import java.util.Deque;


public class CartaInicio extends Carta{

	//funcao credita 200.000 a um jogador
	@Override
	public void Efeito(Jogador jogador, ArrayList<Jogador> jogadores, int resultado_dados, ArrayList<Carta> cartas_ordem_tabuleiro,Deque<CartaSorteOuReves> cartas_sorte_ou_reves,ArrayList<CartaPropriedade> cartas_propriedades, ArrayList<CartaCompanhia> cartas_companhias)
	{		
		//System.out.println("Casa inicio! " + jogador.getName() + " receba o seu pro-labore de $200.000!.");
                UserInterface.Dialogo.avisoGenerico("Casa inicio! " + jogador.getName() + " receba o seu pro-labore de $200.000!.");
		jogador.setSaldo(jogador.getSaldo() + 200000);
		
	}
        
        public String tooltip()
        {
            return this.getNome();
        }
}
