package Elementos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;


public class Setup {

	public static ArrayList<Carta> MontarBaralhoGeral() throws FileNotFoundException
	{
		List<Carta> lista_geral_cartas = new ArrayList<>();
                Scanner scan = new Scanner(new FileInputStream(new File("board_cards.txt")));
                String line;
                String[] separator;
                while(scan.hasNext())
                {
                    line = scan.nextLine();
                    separator = line.split(",");
                    
                    
                    //propriedade ref:
                    //id,cat,color,name,buy_value,rent,one_house_rent,two_house_rent,three_house_rent,four_house_rent,hotel_rent,buy_house_value,buy_hotel_value,mortgage_value,owner
                    
                    //categoria
                    
                    if(separator[1].compareTo("property") == 0)
                    {
                        CartaPropriedade carta = new PropriedadeCardBuilder().id(Integer.valueOf(separator[0])).categoria(separator[1]).cor(separator[2]).nome(separator[3]).valor_de_compra(Integer.valueOf(separator[4])).aluguel(Integer.valueOf(separator[5])).aluguel_com_uma_casa(Integer.valueOf(separator[6])).aluguel_com_duas_casas(Integer.valueOf(separator[7])).aluguel_com_tres_casas(Integer.valueOf(separator[8])).aluguel_com_quatro_casas(Integer.valueOf(separator[9])).aluguel_com_hotel(Integer.valueOf(separator[10])).valor_compra_de_casa(Integer.valueOf(separator[11])).valor_compra_de_hotel(Integer.valueOf(separator[12])).valor_hipoteca(Integer.valueOf(separator[13])).owner(Integer.valueOf(separator[14])).build();
                        lista_geral_cartas.add(carta);
                    }
                    else if(separator[1].compareTo("company") == 0)
                    {
                        CartaCompanhia carta = new CompanhiaCardBuilder().id(Integer.valueOf(separator[0])).categoria(separator[1]).cor(separator[2]).nome(separator[3]).valor_de_compra_companhia(Integer.valueOf(separator[4])).valor_aluguel_base(Integer.valueOf(separator[5])).valor_hipoteca_companhia(Integer.valueOf(separator[6])).owner(Integer.valueOf(separator[7])).build();
                        lista_geral_cartas.add(carta);
                    }
                    else if(separator[1].compareTo("start") == 0)
                    {
                        
                        CartaInicio carta = new InicioCardBuilder().id(Integer.valueOf(separator[0])).categoria(separator[1]).cor(separator[2]).nome(separator[3]).owner(Integer.valueOf(separator[4])).build();
                        lista_geral_cartas.add(carta);
                    }
                    else if(separator[1].compareTo("visitor") == 0)
                    {
                        CartaVisitante carta = new VisitanteCardBuilder().id(Integer.valueOf(separator[0])).categoria(separator[1]).cor(separator[2]).nome(separator[3]).owner(Integer.valueOf(separator[4])).build();
                        lista_geral_cartas.add(carta);
                    }
                    else if(separator[1].compareTo("taxrestitution") == 0)
                    {
                        CartaRestituicaoImpostoDeRenda carta = new RestituicaoCardBuilder().id(Integer.valueOf(separator[0])).categoria(separator[1]).cor(separator[2]).nome(separator[3]).owner(Integer.valueOf(separator[4])).build();
                        lista_geral_cartas.add(carta);
                    }
                    else if(separator[1].compareTo("vacation") == 0)
                    {
                        CartaFerias carta = new FeriasCardBuilder().id(Integer.valueOf(separator[0])).categoria(separator[1]).cor(separator[2]).nome(separator[3]).owner(Integer.valueOf(separator[4])).build();
                        lista_geral_cartas.add(carta);
                    }
                    else if(separator[1].compareTo("federalrevenue") == 0)
                    {
                        CartaReceitaFederal carta = new ReceitaFederalCardBuilder().id(Integer.valueOf(separator[0])).categoria(separator[1]).cor(separator[2]).nome(separator[3]).owner(Integer.valueOf(separator[4])).build();
                        lista_geral_cartas.add(carta);
                    }
                    else if(separator[1].compareTo("police") == 0)
                    {
                        CartaPolicia carta = new PoliciaCardBuilder().id(Integer.valueOf(separator[0])).categoria(separator[1]).cor(separator[2]).nome(separator[3]).owner(Integer.valueOf(separator[4])).build();
                        lista_geral_cartas.add(carta);
                    }
                    else if(separator[1].compareTo("luck") == 0)
                    {
                        //auxiliar pois essa compoe a ordem do tabuleiro, mas as cartas em si tem build diferente abaixo
                        CartaSorteOuRevesAuxiliar carta = new SorteOuRevesAuxiliarCardbuilder().id(Integer.valueOf(separator[0])).categoria(separator[1]).categoria(separator[2]).nome(separator[3]).owner(Integer.valueOf(separator[4])).build();
                        lista_geral_cartas.add(carta);
                    }
                    
                }
                
                scan.close();
            
		
		ArrayList<Carta> list = new ArrayList<>();
		for(Carta card:lista_geral_cartas)
		{
			list.add(card);
		}
		
		//cartas do tabuleiro, print de teste
		
		return list;
		
	}
	public static Deque<CartaSorteOuReves> MontarBaralhoSorteOuReves() throws FileNotFoundException
	{
		List<CartaSorteOuReves> lista_de_cartas = new ArrayList<>();
                Scanner scan = new Scanner(new File("luck_cards.txt"));
                while(scan.hasNext())
                {
                    String line = scan.nextLine();
                    String[] separator = line.split(",");
                    
                    //id,cat,color,nome,action,quant,owner
                    CartaSorteOuReves carta = new LuckCardBuilder().id(Integer.valueOf(separator[0])).categoria(separator[1]).cor(separator[2]).nome(separator[3]).action(Integer.valueOf(separator[4])).quantidade(Integer.valueOf(separator[5])).owner(Integer.valueOf(separator[6])).build();
                    lista_de_cartas.add(carta);
                    
                }
                scan.close();
            
		Collections.shuffle(lista_de_cartas);
		
		//Montagem do Deque (tira de cima e coloca no fundo)
		Deque<CartaSorteOuReves> deque = new ArrayDeque<>();
                lista_de_cartas.forEach((card) -> {
                    deque.add(card);
            });
		return deque;
		
	}	
	
	
}
