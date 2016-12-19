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

import Elementos.LuckCardBuilder;
import Elementos.PropriedadeCardBuilder;
import Elementos.CompanhiaCardBuilder;

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
			//id,cat,color,name,buy_valuerent,one_house_rent,two_house_rent,three_house_rent,four_house_rent,hotel_rent,buy_house_value,buy_hotel_value,mortgage_value,owner
			
			//categoria
			
			//incompleto ainda
			if(separator[1] == "property")
			{
				CartaPropriedade carta = new PropriedadeCardBuilder().id(Integer.valueOf(separator[0])).build();
				lista_geral_cartas.add(carta);
			}
			else if(separator[1] == "company")
			{
				
			}
			else if(separator[1] == "start")
			{
				
			}
			else if(separator[1] == "visitor")
			{
				
			}
			else if(separator[1] == "taxrestitution")
			{
				
			}
			else if(separator[1] == "vacation")
			{
				
			}
			else if(separator[1] == "federalrevenue")
			{
				
			}
			else if(separator[1] == "police")
			{
				
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
