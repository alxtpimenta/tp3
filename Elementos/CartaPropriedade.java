package Elementos;

import java.util.ArrayList;
import java.util.Deque;

public class CartaPropriedade extends Carta{
	
	private int _valor_de_compra;
	private int _aluguel;
	private int _aluguel_com_uma_casa;
	private int _aluguel_com_duas_casas;
	private int _aluguel_com_tres_casas;
	private int _aluguel_com_quatro_casas;
	private int _aluguel_com_hotel;
	private int _valor_compra_de_casa;
	private int _valor_compra_de_hotel;
	private int _valor_hipoteca;
	private int _numero_casas; //numero casas = 5 significa hotel
	
	public void setValorDeCompra(int valor_de_compra)
	{
		this._valor_de_compra = valor_de_compra;
	}
	
	public int getValorDeCompra()
	{
		return this._valor_de_compra;
	}

	public void setAluguel(int aluguel)
	{
		this._aluguel = aluguel;
	}
	
	public int getAluguel()
	{
		return this._aluguel;
	}
	
	public void setAluguelComUmaCasa(int aluguel_com_uma_casa)
	{
		this._aluguel_com_uma_casa = aluguel_com_uma_casa;
	}
	
	public int getAluguelComUmaCasa()
	{
		return this._aluguel_com_uma_casa;
	}
	
	public void setAluguelComDuasCasas(int aluguel_com_duas_casas)
	{
		this._aluguel_com_duas_casas = aluguel_com_duas_casas;
	}
	
	public int getAluguelComDuasCasas()
	{
		return this._aluguel_com_duas_casas;
	}
	
	public void setAluguelComTresCasas(int aluguel_com_tres_casas)
	{
		this._aluguel_com_tres_casas = aluguel_com_tres_casas;
	}
	
	public int getAluguelComTresCasas()
	{
		return this._aluguel_com_tres_casas;
	}
	
	public void setAluguelComQuatroCasas(int aluguel_com_quatro_casas)
	{
		this._aluguel_com_quatro_casas = aluguel_com_quatro_casas;
	}
	
	public int getAluguelComQuatroCasas()
	{
		return this._aluguel_com_quatro_casas;
	}
	
	public void setAluguelComHotel(int aluguel_com_hotel)
	{
		this._aluguel_com_hotel = aluguel_com_hotel;
	}
	
	public int getAluguelComHotel()
	{
		return this._aluguel_com_hotel;
	}
	
	public void setValorCompraDeCasa(int valor_compra_de_casa)
	{
		this._valor_compra_de_casa = valor_compra_de_casa;
	}
	
	public int getValorCompraDeCasa()
	{
		return this._valor_compra_de_casa;
	}
	
	public void setValorCompraDeHotel(int valor_compra_de_hotel)
	{
		this._valor_compra_de_hotel = valor_compra_de_hotel;
	}
	
	public int getValorCompraDeHotel()
	{
		return this._valor_compra_de_hotel;
	}
	
	public void setValorHipoteca(int valor_hipoteca)
	{
		this._valor_hipoteca = valor_hipoteca;
	}
	
	public int getValorHipoteca()
	{
		return this._valor_hipoteca;
	}
	
	public void setNumeroCasas(int numero_casas)
	{
		this._numero_casas = numero_casas;
	}
	
	public int getNumeroCasas()
	{
		return this._numero_casas;
	}
	
	
	@Override
	public void Efeito(Jogador jogador,ArrayList<Jogador> jogadores, int resultado_dados,ArrayList<Carta> cartas_ordem_tabuleiro, Deque<CartaSorteOuReves> cartas_sorte_ou_reves,ArrayList<CartaPropriedade> cartas_propriedades, ArrayList<CartaCompanhia> cartas_companhias)
	{
		//verifica se a carta propriedade no tabuleiro nao pertence a ninguem e nem ao jogador jogando a rodada
		if(cartas_ordem_tabuleiro.get(jogador.getPosicaoTabuleiro()).getOwner() != 9 && cartas_ordem_tabuleiro.get(jogador.getPosicaoTabuleiro()).getOwner() != jogador.getId())
		{
			//faz uma busca para achar a carta propriedade correspondente a carta do tabuleiro em questao
			for(int j=0; j<cartas_propriedades.size();j++)
			{
				if(cartas_propriedades.get(j).getId() == cartas_ordem_tabuleiro.get(jogador.getPosicaoTabuleiro()).getId())
				{
					//olha para o numero de casas para definir quanto pagar de aluguel
					if(cartas_propriedades.get(j).getNumeroCasas() == 0)
					{
                                            UserInterface.Dialogo.avisoGenerico("Jogador pagou aluguel sem casas no valor de:" + cartas_propriedades.get(j).getAluguel());
                                            jogador.setSaldo(jogador.getSaldo() - cartas_propriedades.get(j).getAluguel());
					}
					else if(cartas_propriedades.get(j).getNumeroCasas() == 1)
					{
						UserInterface.Dialogo.avisoGenerico("Jogador pagou aluguel com uma casa no valor de:" + cartas_propriedades.get(j).getAluguelComUmaCasa());
						jogador.setSaldo(jogador.getSaldo() - cartas_propriedades.get(j).getAluguelComUmaCasa());
					}
					else if(cartas_propriedades.get(j).getNumeroCasas() == 2)
					{
						UserInterface.Dialogo.avisoGenerico("Jogador pagou aluguel com duas casas no valor de:" + cartas_propriedades.get(j).getAluguelComDuasCasas());
						jogador.setSaldo(jogador.getSaldo() - cartas_propriedades.get(j).getAluguelComDuasCasas());
					}
					else if(cartas_propriedades.get(j).getNumeroCasas() == 3)
					{
						UserInterface.Dialogo.avisoGenerico("Jogador pagou aluguel com tres casas no valor de:" + cartas_propriedades.get(j).getAluguelComTresCasas());
						jogador.setSaldo(jogador.getSaldo() - cartas_propriedades.get(j).getAluguelComTresCasas());
					}
					else if(cartas_propriedades.get(j).getNumeroCasas() == 4)
					{
						UserInterface.Dialogo.avisoGenerico("Jogador pagou aluguel com quatro casas no valor de:" + cartas_propriedades.get(j).getAluguelComQuatroCasas());
						jogador.setSaldo(jogador.getSaldo() - cartas_propriedades.get(j).getAluguelComQuatroCasas());
					}
					else if(cartas_propriedades.get(j).getNumeroCasas() == 5)
					{
						UserInterface.Dialogo.avisoGenerico("Jogador pagou aluguel com quatro casas e hotel no valor de:" + cartas_propriedades.get(j).getAluguelComHotel());
						jogador.setSaldo(jogador.getSaldo() - cartas_propriedades.get(j).getAluguelComHotel());
					}
				}
			}
			
		}
		
	}
	
}
