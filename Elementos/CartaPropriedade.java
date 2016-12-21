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
						int valor = cartas_propriedades.get(j).getAluguel();
						int id_jogador_dono_da_carta = cartas_propriedades.get(j).getOwner();
						
						
						System.out.println("Jogador pagou aluguel sem casas no valor de:" + valor + " para o jogador " + jogadores.get(id_jogador_dono_da_carta).getName());
						jogador.setSaldo(jogador.getSaldo() - valor);
						jogadores.get(id_jogador_dono_da_carta).setSaldo(jogadores.get(id_jogador_dono_da_carta).getSaldo() + valor);
					}
					else if(cartas_propriedades.get(j).getNumeroCasas() == 1)
					{
						int valor = cartas_propriedades.get(j).getAluguelComUmaCasa();
						int id_jogador_dono_da_carta = cartas_propriedades.get(j).getOwner();
						
						
						System.out.println("Jogador pagou aluguel com 1 casa no valor de:" + valor + " para o jogador " + jogadores.get(id_jogador_dono_da_carta).getName());
						jogador.setSaldo(jogador.getSaldo() - valor);
						jogadores.get(id_jogador_dono_da_carta).setSaldo(jogadores.get(id_jogador_dono_da_carta).getSaldo() + valor);
					}
					else if(cartas_propriedades.get(j).getNumeroCasas() == 2)
					{
						int valor = cartas_propriedades.get(j).getAluguelComDuasCasas();
						int id_jogador_dono_da_carta = cartas_propriedades.get(j).getOwner();
						
						
						System.out.println("Jogador pagou aluguel com 2 casas no valor de:" + valor + " para o jogador " + jogadores.get(id_jogador_dono_da_carta).getName());
						jogador.setSaldo(jogador.getSaldo() - valor);
						jogadores.get(id_jogador_dono_da_carta).setSaldo(jogadores.get(id_jogador_dono_da_carta).getSaldo() + valor);
					}
					else if(cartas_propriedades.get(j).getNumeroCasas() == 3)
					{
						int valor = cartas_propriedades.get(j).getAluguelComTresCasas();
						int id_jogador_dono_da_carta = cartas_propriedades.get(j).getOwner();
						
						
						System.out.println("Jogador pagou aluguel com 3 casas no valor de:" + valor + " para o jogador " + jogadores.get(id_jogador_dono_da_carta).getName());
						jogador.setSaldo(jogador.getSaldo() - valor);
						jogadores.get(id_jogador_dono_da_carta).setSaldo(jogadores.get(id_jogador_dono_da_carta).getSaldo() + valor);
					}
					else if(cartas_propriedades.get(j).getNumeroCasas() == 4)
					{
						int valor = cartas_propriedades.get(j).getAluguelComQuatroCasas();
						int id_jogador_dono_da_carta = cartas_propriedades.get(j).getOwner();
						
						
						System.out.println("Jogador pagou aluguel com 4 casas no valor de:" + valor + " para o jogador " + jogadores.get(id_jogador_dono_da_carta).getName());
						jogador.setSaldo(jogador.getSaldo() - valor);
						jogadores.get(id_jogador_dono_da_carta).setSaldo(jogadores.get(id_jogador_dono_da_carta).getSaldo() + valor);
					}
					else if(cartas_propriedades.get(j).getNumeroCasas() == 5)
					{
						int valor = cartas_propriedades.get(j).getAluguelComHotel();
						int id_jogador_dono_da_carta = cartas_propriedades.get(j).getOwner();
						
						
						System.out.println("Jogador pagou aluguel com 4 casas e um hotel no valor de:" + valor + " para o jogador " + jogadores.get(id_jogador_dono_da_carta).getName());
						jogador.setSaldo(jogador.getSaldo() - valor);
						jogadores.get(id_jogador_dono_da_carta).setSaldo(jogadores.get(id_jogador_dono_da_carta).getSaldo() + valor);
					}
				}
			}
			
		}
		else
		{
			System.out.println("Ninguem possui esta propriedade ainda. Sem efeitos!");
		}
		
	}
	
}
