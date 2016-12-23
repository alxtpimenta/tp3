package Elementos;

import Propriedades.Definicoes;
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
	public void Efeito(Jogador jogador,ArrayList<Jogador> jogadores, int resultado_dados,ArrayList<Carta> cartasTabuleiro, Deque<CartaSorteOuReves> cartasSorteReves,ArrayList<CartaPropriedade> cartasPropriedade, ArrayList<CartaCompanhia> cartasCompanhia)
	{
		//verifica se a carta propriedade no tabuleiro nao pertence a ninguem e nem ao jogador jogando a rodada
		if(cartasTabuleiro.get(jogador.getPosicaoTabuleiro()).getOwner() != Definicoes.SEM_PROPRIETARIO && cartasTabuleiro.get(jogador.getPosicaoTabuleiro()).getOwner() != jogador.getId())
		{
			//faz uma busca para achar a carta propriedade correspondente a carta do tabuleiro em questao
			for(int j=0; j<cartasPropriedade.size();j++)
			{
				if(cartasPropriedade.get(j).getId() == cartasTabuleiro.get(jogador.getPosicaoTabuleiro()).getId())
				{
                                    //Determina o proprietario
                                    int idProprietario = cartasTabuleiro.get(jogador.getPosicaoTabuleiro()).getOwner();
                                    int i;
                                    //olha para o numero de casas para definir quanto pagar de aluguel
                                    switch (cartasPropriedade.get(j).getNumeroCasas()) {
                                        case 0:
                                            UserInterface.Dialogo.avisoGenerico(jogador.getName()+" pagou aluguel no valor de: " + cartasPropriedade.get(j).getAluguel());
                                            jogador.setSaldo(jogador.getSaldo() - cartasPropriedade.get(j).getAluguel());
                                            for(i=0;i<jogadores.size();i++)
                                                if(jogadores.get(i).getId() == idProprietario)
                                                {
                                                    jogadores.get(i).setSaldo(jogadores.get(i).getSaldo() + cartasPropriedade.get(j).getAluguel());
                                                    UserInterface.Dialogo.avisoGenerico(jogadores.get(i).getName()+" recebeu "+Integer.toString(cartasPropriedade.get(j).getAluguel())+" de pagamento!");
                                                }
                                            break;
                                        case 1:
                                            UserInterface.Dialogo.avisoGenerico(jogador.getName()+" pagou aluguel com uma casa no valor de: " + cartasPropriedade.get(j).getAluguelComUmaCasa());
                                            jogador.setSaldo(jogador.getSaldo() - cartasPropriedade.get(j).getAluguelComUmaCasa());
                                            for(i=0;i<jogadores.size();i++)
                                                if(jogadores.get(i).getId() == idProprietario)
                                                {
                                                    jogadores.get(i).setSaldo(jogadores.get(i).getSaldo() + cartasPropriedade.get(j).getAluguelComUmaCasa());
                                                    UserInterface.Dialogo.avisoGenerico(jogadores.get(i).getName()+" recebeu "+Integer.toString(cartasPropriedade.get(j).getAluguelComUmaCasa())+" de pagamento!");
                                                }
                                            break;
                                        case 2:
                                            UserInterface.Dialogo.avisoGenerico(jogador.getName()+" pagou aluguel com duas casas no valor de: " + cartasPropriedade.get(j).getAluguelComDuasCasas());
                                            jogador.setSaldo(jogador.getSaldo() - cartasPropriedade.get(j).getAluguelComDuasCasas());
                                            for(i=0;i<jogadores.size();i++)
                                                if(jogadores.get(i).getId() == idProprietario)
                                                {
                                                    jogadores.get(i).setSaldo(jogadores.get(i).getSaldo() + cartasPropriedade.get(j).getAluguelComDuasCasas());
                                                    UserInterface.Dialogo.avisoGenerico(jogadores.get(i).getName()+" recebeu "+Integer.toString(cartasPropriedade.get(j).getAluguelComDuasCasas())+" de pagamento!");
                                                }
                                            break;
                                        case 3:
                                            UserInterface.Dialogo.avisoGenerico(jogador.getName()+" pagou aluguel com tres casas no valor de: " + cartasPropriedade.get(j).getAluguelComTresCasas());
                                            jogador.setSaldo(jogador.getSaldo() - cartasPropriedade.get(j).getAluguelComTresCasas());
                                            for(i=0;i<jogadores.size();i++)
                                                if(jogadores.get(i).getId() == idProprietario)
                                                {
                                                    jogadores.get(i).setSaldo(jogadores.get(i).getSaldo() + cartasPropriedade.get(j).getAluguelComTresCasas());
                                                    UserInterface.Dialogo.avisoGenerico(jogadores.get(i).getName()+" recebeu "+Integer.toString(cartasPropriedade.get(j).getAluguelComTresCasas())+" de pagamento!");
                                                }
                                            break;
                                        case 4:
                                            UserInterface.Dialogo.avisoGenerico(jogador.getName()+" pagou aluguel com quatro casas no valor de: " + cartasPropriedade.get(j).getAluguelComQuatroCasas());
                                            jogador.setSaldo(jogador.getSaldo() - cartasPropriedade.get(j).getAluguelComQuatroCasas());
                                            for(i=0;i<jogadores.size();i++)
                                                if(jogadores.get(i).getId() == idProprietario)
                                                {
                                                    jogadores.get(i).setSaldo(jogadores.get(i).getSaldo() + cartasPropriedade.get(j).getAluguelComQuatroCasas());
                                                    UserInterface.Dialogo.avisoGenerico(jogadores.get(i).getName()+" recebeu "+Integer.toString(cartasPropriedade.get(j).getAluguelComQuatroCasas())+" de pagamento!");
                                                }
                                            break;
                                        case 5:
                                            UserInterface.Dialogo.avisoGenerico(jogador.getName()+" pagou aluguel com quatro casas e hotel no valor de: " + cartasPropriedade.get(j).getAluguelComHotel());
                                            jogador.setSaldo(jogador.getSaldo() - cartasPropriedade.get(j).getAluguelComHotel());
                                            for(i=0;i<jogadores.size();i++)
                                                if(jogadores.get(i).getId() == idProprietario)
                                                {
                                                    jogadores.get(i).setSaldo(jogadores.get(i).getSaldo() + cartasPropriedade.get(j).getAluguelComHotel());
                                                    UserInterface.Dialogo.avisoGenerico(jogadores.get(i).getName()+" recebeu "+Integer.toString(cartasPropriedade.get(j).getAluguelComHotel())+" de pagamento!");
                                                }
                                            break;
                                        default:
                                            break;
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
            saida = this.getNome() + newline + "Valor de compra: " + Integer.toString(this.getValorDeCompra()) + newline + "Valor de hipoteca: " + Integer.toString(this.getValorHipoteca()) + newline +
                    newline + "Aluguel: " + this._aluguel + newline + "Aluguel com 1 casa: " + this._aluguel_com_uma_casa + newline + "Aluguel com 2 casas: " + this._aluguel_com_duas_casas + newline + "Aluguel com 3 casas: " + this._aluguel_com_tres_casas + newline +
                    "Aluguel com 4 casas: " + this._aluguel_com_quatro_casas + newline + "Aluguel com hotel: " + this._aluguel_com_hotel;
            //Busca na lista de jogadores o proprietario da companhia
            for(int i = 0; i < jogadores.size(); i++)
            {
                //Se encontrar, altera o nome
                if(jogadores.get(i).getId() == this.getOwner())
                    proprietario = jogadores.get(i).getName();
            }
            
            if(this._numero_casas < 5)
            {
                saida = saida + newline + "Proprietario: " + proprietario + newline + "Numero de casas: " + Integer.toString(this._numero_casas);
                return saida;
            }
            else
            {
                saida = saida + newline + "Proprietario: " + proprietario + newline + "Numero de casas: 4" + newline + "Hotel construido";
                return saida;
            }
        }
	
}
