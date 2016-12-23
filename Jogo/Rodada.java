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
    
    public void NovaRodada(Jogador jogador, ArrayList<Jogador> jogadores,ArrayList<Carta> cartasTabuleiro, Deque<CartaSorteOuReves> cartasSorteReves,ArrayList<CartaPropriedade> cartasPropriedade, ArrayList<CartaCompanhia> cartasCompanhia,ArrayList<Casa> casasInterface, int indiceJogador)
	{
                //SE O JOGADOR ESTIVER PRESO
		if(jogador.getPreso() == true)
		{
                    //ADICIONAR BOTOES
                    Botoes.mostrarBotao(Botoes.finalizarTurno);
                    Botoes.mostrarBotao(Botoes.tentarSorte);
                    Botoes.mostrarBotao(Botoes.habeasCorpus);
                    UserInterface.Dialogo.avisoGenerico("Voce ainda esta preso por mais " + Integer.toString(jogador.getDiasDePrisaoRestantes()) + " rodada(s)!");
                    //PREPARAR PARA ESPERAR ACAO DO JOGADOR
                    esperarAcao = false;
                    modoTentarSorte = false;
                    modoHabeasCorpus = false;
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
		cartasTabuleiro.get(posicaoJogador).Efeito(jogador, jogadores,resultadoDados,cartasTabuleiro,cartasSorteReves,cartasPropriedade,cartasCompanhia);
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
                }
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
                    jogador.setSaldo(cartasPropriedade.get(k).getValorCompraDeCasa());
                    //NOTIFICAR
                    UserInterface.Dialogo.avisoGenerico(jogador.getName()+" construiu uma casa em "+cartasTabuleiro.get(posicaoJogador).getNome());
                    //ANULAR OS CONTROLADORES
                    Rodada.modoCompraCasa = false;
                    Rodada.esperarAcao = false;
                    Botoes.adicionarCasa.removeAll();
                    Botoes.removerBotao(Botoes.adicionarCasa);
                    Botoes.removerBotao(Botoes.adicionarHotel);
                }
                else if(modoCompraHotel)
                {
                    //PROCEDIMENTOS PARA COMPRAR A CASA
                    //ATUALIZAR O NUMERO
                    cartasPropriedade.get(k).setNumeroCasas(cartasPropriedade.get(k).getNumeroCasas()+1);
                    //DEBITAR DO SALDO
                    jogador.setSaldo(cartasPropriedade.get(k).getValorCompraDeHotel());
                    //NOTIFICAR
                    UserInterface.Dialogo.avisoGenerico(jogador.getName()+" construiu um hotel em "+cartasTabuleiro.get(posicaoJogador).getNome());
                    //ANULAR OS CONTROLADORES
                    Rodada.modoCompraCasa = false;
                    Rodada.esperarAcao = false;
                    Botoes.adicionarCasa.removeAll();
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
                //MOSTRAR BOTOES DA GUI
                Botoes.removerBotao(Botoes.jogarDados);
                Botoes.mostrarBotao(Botoes.finalizarTurno);
                while(!esperarAcao)
                {
                    //LISTENER PARA TERMINAR O TURNO
                    Botoes.finalizarTurno.addActionListener((ActionEvent e) -> {
                        Rodada.esperarAcao = true;
                        Rodada.finalizarTurno = true;        
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
                
                }
                //Anular os controladores para a proxima rodada
                Rodada.rolarDados = false;
                Botoes.jogarDados.removeAll();
                Botoes.removerBotao(Botoes.jogarDados);
            }		
                }
             
        Botoes.removerBotao(Botoes.jogarDados);
        Botoes.jogarDados.removeAll();
        Rodada.rolarDados = false;
    }
}
