package Elementos;

import java.util.ArrayList;
import java.util.Deque;

public class CartaCompanhia extends Carta{

	private int valor_de_compra;
	private int valor_de_aluguel_base; //aluguel aqui tem que ser multiplicado pelo valor da soma dos dados
	private int valor_hipoteca;
	
	public void setValorDeCompra(int valor_de_compra)
	{
		this.valor_de_compra = valor_de_compra;
	}
	public int getValorDeCompra()
	{
		return this.valor_de_compra;
	}
	
	public void setValorDeAluguelBase(int valor_de_aluguel_base)
	{
		this.valor_de_aluguel_base = valor_de_aluguel_base;
	}
	public int getValorDeAluguelBase()
	{
		return this.valor_de_aluguel_base;
	}
	
	public void setValorHipoteca(int valor_hipoteca)
	{
		this.valor_hipoteca = valor_hipoteca;
	}
	public int getValorHipoteca()
	{
		return this.valor_hipoteca;
	}
	
	@Override
	public void Efeito(Jogador jogador,ArrayList<Jogador> jogadores, int resultado_dados,ArrayList<Carta> cartas_ordem_tabuleiro, Deque<CartaSorteOuReves> cartas_sorte_ou_reves,ArrayList<CartaPropriedade> cartas_propriedades, ArrayList<CartaCompanhia> cartas_companhias)
	{
		//verifica se a carta companhia no tabuleiro nao pertence a ninguem e nem ao jogador jogando a rodada
		if(cartas_ordem_tabuleiro.get(jogador.getPosicaoTabuleiro()).getOwner() != 9 && cartas_ordem_tabuleiro.get(jogador.getPosicaoTabuleiro()).getOwner() != jogador.getId())
		{
			//faz uma busca para achar a carta companhia correspondente a carta do tabuleiro em questao
			for(int j=0; j<cartas_companhias.size();j++)
			{
				if(cartas_companhias.get(j).getId() == cartas_ordem_tabuleiro.get(jogador.getPosicaoTabuleiro()).getId())
				{
					UserInterface.Dialogo.avisoGenerico("O jogador pagou " + resultado_dados * cartas_companhias.get(j).getValorDeAluguelBase() +" por parar nessa companhia!");
					jogador.setSaldo(jogador.getSaldo() - resultado_dados * cartas_companhias.get(j).getValorDeAluguelBase());
				}
			
			}
		}
		
		
	}
        
        @Override
        public String tooltip(ArrayList<Jogador> jogadores)
        {
            String newline = System.getProperty("line.separator");
            String saida;
            String proprietario = "Nenhum";
            saida = this.getNome() + newline + "Valor de compra: " + Integer.toString(this.getValorDeCompra()) + newline + "Valor de hipoteca: " + Integer.toString(this.getValorHipoteca()) + newline + "Valor base de aluguel: " + Integer.toString(this.getValorDeAluguelBase());
            //Busca na lista de jogadores o proprietario da companhia
            for(int i = 0; i < jogadores.size(); i++)
            {
                //Se encontrar, altera o nome
                if(jogadores.get(i).getId() == this.getOwner())
                    proprietario = jogadores.get(i).getName();
            }
            
            saida = saida + newline + "Proprietario: " + proprietario;
            return saida;
        }
	
}
