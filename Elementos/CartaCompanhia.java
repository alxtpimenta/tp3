package Elementos;

import Propriedades.Definicoes;
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
	public void Efeito(Jogador jogador,ArrayList<Jogador> jogadores, int resultado_dados,ArrayList<Carta> cartasTabuleiro, Deque<CartaSorteOuReves> cartasSorteReves,ArrayList<CartaPropriedade> cartasPropriedade, ArrayList<CartaCompanhia> cartasCompanhia ,ArrayList<CartaSorteOuReves> cartas_nao_devolvidas_sorteoureves)
	{
		//verifica se a carta companhia no tabuleiro nao pertence a ninguem e nem ao jogador jogando a rodada
		if(cartasTabuleiro.get(jogador.getPosicaoTabuleiro()).getOwner() != Definicoes.SEM_PROPRIETARIO && cartasTabuleiro.get(jogador.getPosicaoTabuleiro()).getOwner() != jogador.getId())
		{
			//faz uma busca para achar a carta companhia correspondente a carta do tabuleiro em questao
			for(int j=0; j<cartasCompanhia.size();j++)
			{
				if(cartasCompanhia.get(j).getId() == cartasTabuleiro.get(jogador.getPosicaoTabuleiro()).getId())
				{
                                        int idProprietario = cartasTabuleiro.get(jogador.getPosicaoTabuleiro()).getOwner();
                                        int i;
					UserInterface.Dialogo.avisoGenerico(jogador.getName()+" pagou " + resultado_dados * cartasCompanhia.get(j).getValorDeAluguelBase() +" por parar em "+ cartasCompanhia.get(j).getNome()+"!");
					jogador.setSaldo(jogador.getSaldo() - resultado_dados * cartasCompanhia.get(j).getValorDeAluguelBase());
                                        for(i=0;i<jogadores.size();i++)
                                            if(jogadores.get(i).getId() == idProprietario)
                                            {
                                                jogadores.get(i).setSaldo(jogadores.get(i).getSaldo() + resultado_dados * cartasCompanhia.get(j).getValorDeAluguelBase());
                                                UserInterface.Dialogo.avisoGenerico(jogadores.get(i).getName()+" recebeu "+Integer.toString(resultado_dados * cartasCompanhia.get(j).getValorDeAluguelBase())+" de pagamento!");
                                            }
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
