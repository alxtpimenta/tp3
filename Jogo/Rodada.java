package Jogo;
import Elementos.Carta;
import Elementos.CartaCompanhia;
import Elementos.CartaPropriedade;
import Elementos.CartaSorteOuReves;
import Elementos.Casa;
import Elementos.Dados;
import Elementos.Jogador;
import Propriedades.Definicoes;
import Proxy.RefreshGUI;
import UserInterface.Botoes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Deque;


public class Rodada {

	
    private static boolean rolarDados = false;
    private static boolean modoCompra = false;
    private static boolean esperarAcao = false;
    private static boolean finalizarTurno = false;
    private static boolean modoCompraHotel = false;
    private static boolean modoCompraCasa = false;
    private static boolean modoTentarSorte = false;
    private static boolean modoHabeasCorpus = false;
    private static boolean modoVenderCasa = false;
    private static boolean modoVenderCompanhia = false;
    
    
    public void NovaRodada(Jogador jogador, ArrayList<Jogador> jogadores,ArrayList<Carta> cartasTabuleiro, Deque<CartaSorteOuReves> cartasSorteReves,ArrayList<CartaPropriedade> cartasPropriedade, ArrayList<CartaCompanhia> cartasCompanhia,ArrayList<Casa> casasInterface, int indiceJogador,ArrayList<CartaSorteOuReves> cartas_nao_devolvidas_sorteoureves)
	{
    	
    	
                //SE O JOGADOR ESTIVER PRESO
		if(jogador.getPreso() == true)
		{
                    //ADICIONAR BOTOES
                    Botoes.mostrarBotao(Botoes.finalizarTurno);
                    Botoes.mostrarBotao(Botoes.tentarSorte);
                    
                  //PREPARAR PARA ESPERAR ACAO DO JOGADOR
                    esperarAcao = false;
                    modoTentarSorte = false;
                    modoHabeasCorpus = false;
                    
                    //BUSCA CARTA HABEAS CORPUS
                    for(int p=0;p<cartas_nao_devolvidas_sorteoureves.size();p++)
                    {
                    	
                    	if(cartas_nao_devolvidas_sorteoureves.get(p).getAction() == 6 && cartas_nao_devolvidas_sorteoureves.get(p).getOwner() == jogador.getId())
                    	{
                    		Botoes.mostrarBotao(Botoes.habeasCorpus);
                    		
                    	}
                    }
                    
                    UserInterface.Dialogo.avisoGenerico("Voce ainda esta preso por mais " + Integer.toString(jogador.getDiasDePrisaoRestantes()) + " rodada(s)!");
                    
                    //ESPERAR ACAO
                    while(!esperarAcao)
                    {
                        //LISTENER DO HABEAS CORPUS
                        Botoes.habeasCorpus.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent e) 
                            {
                                Rodada.esperarAcao = true;
                                Rodada.modoHabeasCorpus = true;
                            } 
                        });
                        //LISTENER DO TENTAR SORTE
                        Botoes.tentarSorte.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent e) 
                            {
                                Rodada.esperarAcao = true;
                                Rodada.modoTentarSorte = true;
                            } 
                        });
                        //LISTENER DE FINALIZAR RODADA
                        Botoes.finalizarTurno.addActionListener(new ActionListener()
                        {
                            @Override
                            public void actionPerformed(ActionEvent e) 
                            {
                                Rodada.esperarAcao = true;
                                Rodada.finalizarTurno = true;
                            } 
                        });
                    }
                    //MODO HABEAS CORPUS
                    if(modoHabeasCorpus)
                    {
                        jogador.setPreso(false);
                        jogador.setDiasDePrisaoRestantes(0);
                        UserInterface.Dialogo.avisoGenerico("Voce utilizou sua carta de habeas corpus e saiu da prisao. Jogue normalmente na proxima rodada!");
                        
                        //BUSCA CARTA HABEAS CORPUS PARA DEVOLVE-LA AO BARALHO
                        for(int p=0;p<cartas_nao_devolvidas_sorteoureves.size();p++)
                        {                        	
                        	if(cartas_nao_devolvidas_sorteoureves.get(p).getAction() == 6)
                        	{
                        		cartas_nao_devolvidas_sorteoureves.get(p).setOwner(9);
                        		cartasSorteReves.addLast(cartas_nao_devolvidas_sorteoureves.get(p));
                        		
                        	}
                        }
                    }
                    //MODO TENTAR SORTE
                    else if(modoTentarSorte)
                    {
                        int sorte1,sorte2;
                        UserInterface.Dialogo.avisoGenerico("Se ao jogar o dado duas vezes e obter o mesmo numero, voce sera solto! Caso contrario, permanece mais uma rodada!");
                        //SORTEAR
                        Dados sorte = new Dados();
                        sorte1 = sorte.RolarDados();
                        UserInterface.Dialogo.avisoGenerico("Resultado dos dados: "+Integer.toString(sorte1));
                        sorte2 = sorte.RolarDados();
                        UserInterface.Dialogo.avisoGenerico("Resultado dos dados: "+Integer.toString(sorte2));
                        if(sorte1 == sorte2)
                        {
                            UserInterface.Dialogo.avisoGenerico("Sorte! Voce foi liberado!");
                            jogador.setPreso(false);
                            jogador.setDiasDePrisaoRestantes(0);
                            //DESATIVAR CONTROLADORES
                            finalizarTurno = false;
                            modoHabeasCorpus = false;
                            modoTentarSorte = false;
                            //REMOVER BOTOES
                            Botoes.removerBotao(Botoes.finalizarTurno);
                            Botoes.finalizarTurno.removeAll();
                            Botoes.removerBotao(Botoes.habeasCorpus);
                            Botoes.habeasCorpus.removeAll();
                            Botoes.removerBotao(Botoes.tentarSorte);
                            Botoes.tentarSorte.removeAll();
                        }
                        else
                        {
                            UserInterface.Dialogo.avisoGenerico("Azar! Nao foi dessa vez!");
                            jogador.setDiasDePrisaoRestantes(jogador.getDiasDePrisaoRestantes()-1);
                            //DESATIVAR CONTROLADORES
                            finalizarTurno = false;
                            modoHabeasCorpus = false;
                            modoTentarSorte = false;
                            //REMOVER BOTOES
                            Botoes.removerBotao(Botoes.finalizarTurno);
                            Botoes.finalizarTurno.removeAll();
                            Botoes.removerBotao(Botoes.habeasCorpus);
                            Botoes.habeasCorpus.removeAll();
                            Botoes.removerBotao(Botoes.tentarSorte);
                            Botoes.tentarSorte.removeAll();
                        }
                    }
                    //FINALIZAR RODADA
                    else if(finalizarTurno)
                    {
                        //DIMINUI OS DIAS DE PRISAO
                        jogador.setDiasDePrisaoRestantes(jogador.getDiasDePrisaoRestantes()-1);
                        //SE OS DIAS RESTANTES DE PRISAO FORAM <= 0 DESATIVA O MODO PRISAO
                        if(jogador.getDiasDePrisaoRestantes() <= 0)
                            jogador.setPreso(false);
                        //DESATIVAR CONTROLADORES
                        finalizarTurno = false;
                        modoHabeasCorpus = false;
                        modoTentarSorte = false;
                        //REMOVER BOTOES
                        Botoes.removerBotao(Botoes.finalizarTurno);
                        Botoes.finalizarTurno.removeAll();
                        Botoes.removerBotao(Botoes.habeasCorpus);
                        Botoes.habeasCorpus.removeAll();
                        Botoes.removerBotao(Botoes.tentarSorte);
                        Botoes.tentarSorte.removeAll();
                    }
		}
		else
                    //JOGADOR NÃO ESTA PRESO
                    {
                    //ADICIONAR BOTOES
                    Botoes.mostrarBotao(Botoes.jogarDados);
                    while(!rolarDados)
                    {
                        Botoes.jogarDados.addActionListener((ActionEvent e) -> {
                            Rodada.rolarDados = true; 
                        });
            }
            if(Rodada.rolarDados)
            {
		//
		Dados dados = new Dados();
		int resultadoDados = dados.RolarDados();
                UserInterface.Dialogo.jogarDados(resultadoDados);
		int posicaoJogador = jogador.getPosicaoTabuleiro() + resultadoDados;
		if(posicaoJogador > 39)
		{
                    posicaoJogador = posicaoJogador - 40;
		}
		//Nova posição do tabuleiro
		jogador.setPosicaoTabuleiro(posicaoJogador);
                //Atualiza a GUI antes do efeito da carta
                RefreshGUI.atualizarJogadoresXY(jogadores, casasInterface);
                RefreshGUI.atualizarLabels(jogadores, indiceJogador);
                RefreshGUI.atualizarPinos(jogadores);
                RefreshGUI.atualizarTooltip(cartasTabuleiro, jogadores, jogador);
                UserInterface.Tabuleiro.refresh();
		//invoca efeito da carta da posicao do jogador
		cartasTabuleiro.get(posicaoJogador).Efeito(jogador, jogadores,resultadoDados,cartasTabuleiro,cartasSorteReves,cartasPropriedade,cartasCompanhia,cartas_nao_devolvidas_sorteoureves);
                //Atualiza a GUI apos o efeito
                RefreshGUI.atualizarJogadoresXY(jogadores, casasInterface);
                RefreshGUI.atualizarLabels(jogadores, indiceJogador);
                RefreshGUI.atualizarPinos(jogadores);
                RefreshGUI.atualizarTooltip(cartasTabuleiro, jogadores, jogador);
                UserInterface.Tabuleiro.refresh();
                //Se for uma propriedade ou companhia e o jogador nao for dono, ir para o modo de compra
                if(("company".equals(cartasTabuleiro.get(posicaoJogador).getCategoria())
                    || "property".equals(cartasTabuleiro.get(posicaoJogador).getCategoria()))
                    && cartasTabuleiro.get(posicaoJogador).getOwner() == Definicoes.SEM_PROPRIETARIO)
                {   
                    //Atualizar botoes
                    Botoes.mostrarBotao(Botoes.finalizarTurno);
                    Botoes.removerBotao(Botoes.jogarDados);
                    Botoes.mostrarBotao(Botoes.comprar);
                    esperarAcao = false;
                    while(!esperarAcao)
                    {
                       //ESPERAR ACAO DO JOGADOR
                        Botoes.finalizarTurno.addActionListener((ActionEvent e) -> {
                            Rodada.esperarAcao = true;
                            Rodada.finalizarTurno = true;        
                        });
                    
                        //ACTION LISTENER DE COMPRA
                        Botoes.comprar.addActionListener((ActionEvent e) -> {
                            Rodada.esperarAcao = true;
                            Rodada.modoCompra = true;
                        });
                    }
                if(modoCompra)
                {
                    //REALIZAR COMPRA
                	if("property".equals(cartasTabuleiro.get(posicaoJogador).getCategoria()))
                	{
	                    UserInterface.Dialogo.avisoGenerico(jogador.getName() + " comprou " + cartasTabuleiro.get(posicaoJogador).getNome()+"!");
	                    cartasTabuleiro.get(posicaoJogador).setOwner(jogador.getId());
	                    //busca valor de compra da carta correta
	                    int k =0;
	                    for(int i=0;i<cartasPropriedade.size();i++)
	                    {
	                    	if(cartasPropriedade.get(i).getNome().compareTo(cartasTabuleiro.get(posicaoJogador).getNome()) == 0)
	                    	{
	                    		k = i;
	                    	}
	                    }
	                    jogador.setSaldo(jogador.getSaldo() -  cartasPropriedade.get(k).getValorDeCompra());
                        }
                        else if("company".equals(cartasTabuleiro.get(posicaoJogador).getCategoria()))
                	{
	                    UserInterface.Dialogo.avisoGenerico(jogador.getName() + " comprou " + cartasTabuleiro.get(posicaoJogador).getNome()+"!");
	                    cartasTabuleiro.get(posicaoJogador).setOwner(jogador.getId());
	                    int k =0;
	                    for(int i=0;i<cartasCompanhia.size();i++)
	                    {
	                    	if(cartasCompanhia.get(i).getNome().compareTo(cartasTabuleiro.get(posicaoJogador).getNome()) == 0)
	                    	{
	                    		k = i;
	                    	}
	                    }
	                    jogador.setSaldo(jogador.getSaldo() -  cartasCompanhia.get(k).getValorDeCompra());
                        }
                    //ANULAR CONTROLADORES
                    Rodada.esperarAcao = false;
                    Rodada.modoCompra = false;
                    Rodada.finalizarTurno = true;
                    Botoes.comprar.removeAll();
                    Botoes.removerBotao(Botoes.comprar);
                    Botoes.removerBotao(Botoes.finalizarTurno);
                }
                else if(Rodada.finalizarTurno)
                {
                    //Anula os controladores do loop para pular o turno
                    Rodada.esperarAcao = false;
                    Rodada.finalizarTurno = false;
                    Botoes.finalizarTurno.removeAll();
                    Botoes.removerBotao(Botoes.finalizarTurno);
                    Botoes.removerBotao(Botoes.comprar);
                }
            }
            //Se a propriedade for do jogador
            else if(("property".equals(cartasTabuleiro.get(posicaoJogador).getCategoria()))
                    && cartasTabuleiro.get(posicaoJogador).getOwner() == jogador.getId())
            {
            	//busca carta propriedade referente
            	int k =0;
                for(int i=0;i<cartasPropriedade.size();i++)
                {
                	if(cartasPropriedade.get(i).getNome().compareTo(cartasTabuleiro.get(posicaoJogador).getNome()) == 0)
                	{
                		k = i;
                	}
                }
                if(cartasPropriedade.get(k).getNumeroCasas() >= (Definicoes.NUM_MAX_CASAS + Definicoes.NUM_MAX_HOTEIS))
                {
                	 //NÃO ADICIONAR NENHUM BOTÃO
                }
                else if(cartasPropriedade.get(k).getNumeroCasas() >= Definicoes.NUM_MAX_CASAS)
                {
                    Botoes.mostrarBotao(Botoes.adicionarHotel);
                }
                else
                {
                    Botoes.mostrarBotao(Botoes.adicionarCasa);
                    Botoes.mostrarBotao(Botoes.venderCasa);
                }
                Rodada.esperarAcao = false;
                Rodada.modoCompraCasa = false;
                Rodada.modoCompraHotel = false;
                Rodada.finalizarTurno = false;
                //MOSTRAR BOTOES DA GUI
                Botoes.removerBotao(Botoes.jogarDados);
                Botoes.mostrarBotao(Botoes.finalizarTurno);
                //ESPERAR AÇÃO DO JOGADOR
                while(!esperarAcao)
                {
                    //LISTENER PARA COMPRAR CASA
                    Botoes.adicionarCasa.addActionListener((ActionEvent e) -> {
                        Rodada.esperarAcao = true;
                        Rodada.modoCompraCasa = true;        
                    });
                    //LISTENER PARA COMPRAR HOTEL
                    Botoes.adicionarHotel.addActionListener((ActionEvent e) -> {
                        Rodada.esperarAcao = true;
                        Rodada.modoCompraHotel = true;        
                    });
                    //LISTENER PARA VENDER CASA
                    Botoes.venderCasa.addActionListener((ActionEvent e) -> {
                        Rodada.esperarAcao = true;
                        Rodada.modoVenderCasa = true;        
                    });
                    
                    //LISTENER PARA TERMINAR O TURNO
                    Botoes.finalizarTurno.addActionListener((ActionEvent e) -> {
                        Rodada.esperarAcao = true;
                        Rodada.finalizarTurno = true;        
                    });
                }
                if(modoCompraCasa)
                {
                    //PROCEDIMENTOS PARA COMPRAR A CASA
                    //ATUALIZAR O NUMERO
                    cartasPropriedade.get(k).setNumeroCasas(cartasPropriedade.get(k).getNumeroCasas()+1);
                    //DEBITAR DO SALDO
                    jogador.setSaldo(cartasPropriedade.get(k).getValorCompraDeCasa() + jogador.getSaldo());
                    //NOTIFICAR
                    UserInterface.Dialogo.avisoGenerico(jogador.getName()+" construiu uma casa em "+cartasTabuleiro.get(posicaoJogador).getNome());
                    //ANULAR OS CONTROLADORES
                    Rodada.modoCompraCasa = false;
                    Rodada.esperarAcao = false;
                    Rodada.modoVenderCasa = false;
					Rodada.modoCompraHotel = false;
                    Botoes.adicionarCasa.removeAll();
                    Botoes.removerBotao(Botoes.adicionarCasa);
                    Botoes.removerBotao(Botoes.adicionarHotel);
                    Botoes.removerBotao(Botoes.venderCasa);
                }
                else if(modoCompraHotel)
                {
                    //PROCEDIMENTOS PARA COMPRAR A CASA
                    //ATUALIZAR O NUMERO
                    cartasPropriedade.get(k).setNumeroCasas(cartasPropriedade.get(k).getNumeroCasas()+1);
                    //DEBITAR DO SALDO
                    jogador.setSaldo(cartasPropriedade.get(k).getValorCompraDeHotel() + jogador.getSaldo());
                    //NOTIFICAR
                    UserInterface.Dialogo.avisoGenerico(jogador.getName()+" construiu um hotel em "+cartasTabuleiro.get(posicaoJogador).getNome());
                    //ANULAR OS CONTROLADORES
                    Rodada.modoCompraCasa = false;
                    Rodada.esperarAcao = false;
                    Rodada.modoVenderCasa = false;
                    Botoes.adicionarCasa.removeAll();
                    Botoes.removerBotao(Botoes.adicionarCasa);
                    Botoes.removerBotao(Botoes.adicionarHotel);
                    Botoes.removerBotao(Botoes.venderCasa);
                }
                else if(modoVenderCasa)
                {
                    //PROCEDIMENTOS PARA VENDER A CASA
                    //ATUALIZAR O NUMERO
                    cartasPropriedade.get(k).setNumeroCasas(0);
                    cartasPropriedade.get(k).setOwner(Definicoes.SEM_PROPRIETARIO);
                    //CREDITAR NO SALDO
                    jogador.setSaldo(cartasPropriedade.get(k).getValorHipoteca() + jogador.getSaldo());
                    //NOTIFICAR
                    UserInterface.Dialogo.avisoGenerico(jogador.getName()+" vendeu a propriedade "+cartasTabuleiro.get(posicaoJogador).getNome() + " por " + cartasPropriedade.get(k).getValorHipoteca());
                    //ANULAR OS CONTROLADORES
                    Rodada.modoCompraCasa = false;
                    Rodada.esperarAcao = false;
                    Rodada.modoVenderCasa = false;
                    Botoes.adicionarCasa.removeAll();
                    Botoes.removerBotao(Botoes.venderCasa);
                    Botoes.removerBotao(Botoes.adicionarCasa);
                    Botoes.removerBotao(Botoes.adicionarHotel);
                }
                else if(Rodada.finalizarTurno)
                {
                    //Anula os controladores do loop para pular o turno
                    Rodada.esperarAcao = false;
                    Rodada.finalizarTurno = false;
                    Botoes.finalizarTurno.removeAll();
                    Botoes.removerBotao(Botoes.finalizarTurno);
                    Botoes.removerBotao(Botoes.adicionarCasa);
                    Botoes.removerBotao(Botoes.adicionarHotel);
                }
            }
            //Se a companhia for do jogador
            else if(("company".equals(cartasTabuleiro.get(posicaoJogador).getCategoria()))
                    && cartasTabuleiro.get(posicaoJogador).getOwner() == jogador.getId())
                {
            	
            	//busca carta companhia referente
            	int t =0;
                for(int u=0;u<cartasCompanhia.size();u++)
                {
                	if(cartasCompanhia.get(u).getNome().compareTo(cartasTabuleiro.get(posicaoJogador).getNome()) == 0)
                	{
                		t = u;
                	}
                }
            	
            	
                //MOSTRAR BOTOES DA GUI
                Botoes.removerBotao(Botoes.jogarDados);
                Botoes.mostrarBotao(Botoes.finalizarTurno);
                Botoes.mostrarBotao(Botoes.venderCasa);
                Rodada.esperarAcao = false;
                Rodada.finalizarTurno = false;
                Rodada.modoCompraHotel = false;
                while(!esperarAcao)
                {
                    //LISTENER PARA TERMINAR O TURNO
                    Botoes.finalizarTurno.addActionListener((ActionEvent e) -> {
                        Rodada.esperarAcao = true;
                        Rodada.finalizarTurno = true;        
                    });
                    
                  //LISTENER PARA VENDER
                    Botoes.venderCasa.addActionListener((ActionEvent e) -> {
                        Rodada.esperarAcao = true;
                        Rodada.modoVenderCompanhia = true;        
                    });
                    
                    
                }
                if(Rodada.finalizarTurno)
                {
                    //Anula os controladores do loop para pular o turno
                    Rodada.esperarAcao = false;
                    Rodada.finalizarTurno = false;
                    Botoes.finalizarTurno.removeAll();
                    Botoes.removerBotao(Botoes.finalizarTurno);
                    Botoes.removerBotao(Botoes.adicionarCasa);
                    Botoes.removerBotao(Botoes.adicionarHotel);
                }
                else if(Rodada.modoVenderCompanhia)
                {	
                    //PROCEDIMENTOS PARA VENDER A COMPANHIA
                    //ATUALIZAR O NUMERO                	
                    cartasCompanhia.get(t).setOwner(Definicoes.SEM_PROPRIETARIO);
                    //CREDITAR NO SALDO
                    jogador.setSaldo(cartasCompanhia.get(t).getValorHipoteca() + jogador.getSaldo());
                    //NOTIFICAR
                    UserInterface.Dialogo.avisoGenerico(jogador.getName()+" vendeu a companhia "+cartasTabuleiro.get(posicaoJogador).getNome() + " por " + cartasCompanhia.get(t).getValorHipoteca());
                    //ANULAR OS CONTROLADORES
                    Rodada.modoVenderCompanhia = false;
                    Rodada.esperarAcao = false;
                    Rodada.finalizarTurno = false;
                    Botoes.removerBotao(Botoes.venderCasa);
                    Botoes.removerBotao(Botoes.adicionarCasa);
                    Botoes.removerBotao(Botoes.adicionarHotel);
                }
                
                }
                //Anular os controladores para a proxima rodada
                Rodada.modoVenderCompanhia = false;
                
                Rodada.rolarDados = false;
                Botoes.jogarDados.removeAll();
                Botoes.removerBotao(Botoes.jogarDados);
                Botoes.removerBotao(Botoes.venderCasa);
            }		
                }
             
        Botoes.removerBotao(Botoes.jogarDados);
        Botoes.jogarDados.removeAll();
        Rodada.rolarDados = false;
    }
}
