package Elementos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

import Elementos.Carta;
import Elementos.CartaSorteOuReves;
import Elementos.CartaPropriedade;
import Elementos.CartaPolicia;
import Elementos.CartaReceitaFederal;
import Elementos.CartaFerias;
import Elementos.CartaRestituicaoImpostoDeRenda;
import Elementos.CartaVisitante;
import Elementos.CartaInicio;


import Elementos.LuckCardBuilder;
import Elementos.PropriedadeCardBuilder;
import Elementos.CompanhiaCardBuilder;
import Elementos.PoliciaCardBuilder;
import Elementos.ReceitaFederalCardBuilder;
import Elementos.InicioCardBuilder;
import Elementos.VisitanteCardBuilder;
import Elementos.RestituicaoCardBuilder;
import Elementos.FeriasCardBuilder;

public class Setup {

	public ArrayList<Carta> MontarBaralhoGeral() throws FileNotFoundException
	{
		List<Carta> lista_geral_cartas = new ArrayList<>();
		Scanner scan = new Scanner(new File("C:/Users/SALA/workspace/BancoImobiliario/src/luck_cards.txt"));
		while(scan.hasNext())
		{
			String line = scan.nextLine();
			String[] separator = line.split(";");
			
			//propriedade ref:
			//id,cat,color,name,buy_value,rent,one_house_rent,two_house_rent,three_house_rent,four_house_rent,hotel_rent,buy_house_value,buy_hotel_value,mortgage_value,owner
			
			//categoria
			
			//incompleto ainda
			if(separator[1] == "property")
			{
				if(separator[14] == "null")
				{
					separator[14] = null;
				}
				
				CartaPropriedade carta = new PropriedadeCardBuilder().id(Integer.valueOf(separator[0])).categoria(separator[1]).cor(separator[2]).nome(separator[3]).valor_de_compra(Integer.valueOf(separator[4])).aluguel(Integer.valueOf(separator[5])).aluguel_com_uma_casa(Integer.valueOf(separator[6])).aluguel_com_duas_casas(Integer.valueOf(separator[7])).aluguel_com_tres_casas(Integer.valueOf(separator[8])).aluguel_com_quatro_casas(Integer.valueOf(separator[9])).aluguel_com_hotel(Integer.valueOf(separator[10])).valor_compra_de_casa(Integer.valueOf(separator[11])).valor_compra_de_hotel(Integer.valueOf(separator[12])).valor_hipoteca(Integer.valueOf(separator[13])).owner(Integer.valueOf(separator[14])).build();
				lista_geral_cartas.add(carta);
			}
			else if(separator[1] == "company")
			{
				if(separator[7] == "null")
				{
					separator[7] = null;
				}
				
				CartaCompanhia carta = new CompanhiaCardBuilder().id(Integer.valueOf(separator[0])).categoria(separator[1]).cor(separator[2]).nome(separator[3]).valor_de_compra_companhia(Integer.valueOf(separator[4])).valor_aluguel_base(Integer.valueOf(separator[5])).valor_hipoteca_companhia(Integer.valueOf(separator[6])).owner(Integer.valueOf(separator[7])).build();
				lista_geral_cartas.add(carta);
			}
			else if(separator[1] == "start")
			{
				if(separator[4] == "null")
				{
					separator[4] = null;
				}
			
				CartaInicio carta = new InicioCardBuilder().id(Integer.valueOf(separator[0])).categoria(separator[1]).cor(separator[2]).nome(separator[3]).owner(Integer.valueOf(separator[4])).build();
				lista_geral_cartas.add(carta);
			}
			else if(separator[1] == "visitor")
			{
				if(separator[4] == "null")
				{
					separator[4] = null;
				}
			
				CartaVisitante carta = new VisitanteCardBuilder().id(Integer.valueOf(separator[0])).categoria(separator[1]).cor(separator[2]).nome(separator[3]).owner(Integer.valueOf(separator[4])).build();
				lista_geral_cartas.add(carta);
			}
			else if(separator[1] == "taxrestitution")
			{
				if(separator[4] == "null")
				{
					separator[4] = null;
				}
			
				CartaRestituicaoImpostoDeRenda carta = new RestituicaoCardBuilder().id(Integer.valueOf(separator[0])).categoria(separator[1]).cor(separator[2]).nome(separator[3]).owner(Integer.valueOf(separator[4])).build();
				lista_geral_cartas.add(carta);
			}
			else if(separator[1] == "vacation")
			{
				if(separator[4] == "null")
				{
					separator[4] = null;
				}
			
				CartaFerias carta = new FeriasCardBuilder().id(Integer.valueOf(separator[0])).categoria(separator[1]).cor(separator[2]).nome(separator[3]).owner(Integer.valueOf(separator[4])).build();
				lista_geral_cartas.add(carta);
			}
			else if(separator[1] == "federalrevenue")
			{
				if(separator[4] == "null")
				{
					separator[4] = null;
				}
			
				CartaReceitaFederal carta = new ReceitaFederalCardBuilder().id(Integer.valueOf(separator[0])).categoria(separator[1]).cor(separator[2]).nome(separator[3]).owner(Integer.valueOf(separator[4])).build();
				lista_geral_cartas.add(carta);
			}
			else if(separator[1] == "police")
			{
				if(separator[4] == "null")
				{
					separator[4] = null;
				}
			
				CartaPolicia carta = new PoliciaCardBuilder().id(Integer.valueOf(separator[0])).categoria(separator[1]).cor(separator[2]).nome(separator[3]).owner(Integer.valueOf(separator[4])).build();
				lista_geral_cartas.add(carta);
			}		
			
		}
		scan.close();
		
		ArrayList<Carta> list = new ArrayList<>();
		for(Carta card:lista_geral_cartas)
		{
			list.add(card);
		}
		
		return list;
		
	}
	public Deque<Carta> MontarBaralhoSorteOuReves() throws FileNotFoundException
	{
		List<Carta> lista_de_cartas = new ArrayList<>();
		Scanner scan = new Scanner(new File("C:/Users/SALA/workspace/BancoImobiliario/src/luck_cards.txt"));
		
		while(scan.hasNext())
		{
			String line = scan.nextLine();
			String[] separator = line.split(";");
			
			
			//id,cat,color,nome,action,quant,owner
			CartaSorteOuReves carta = new LuckCardBuilder().id(Integer.valueOf(separator[0])).categoria(separator[1]).cor(separator[2]).nome(separator[3]).action(Integer.valueOf(separator[4])).quantidade(Integer.valueOf(separator[5])).owner(Integer.valueOf(separator[6])).build();
			lista_de_cartas.add(carta);
						
		}
		scan.close();
		Collections.shuffle(lista_de_cartas);
		
		//Montagem do Deque (tira de cima e coloca no fundo)
		Deque<Carta> deque = new ArrayDeque<>();
		for(Carta card:lista_de_cartas)
		{
			deque.add(card);
		}
		
		return deque;
		
	}	
	
}
