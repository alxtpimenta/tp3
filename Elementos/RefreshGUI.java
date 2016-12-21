/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import Propriedades.Definicoes;
import UserInterface.Labels;
import java.util.ArrayList;

/**
 *
 * @author alxtp
 */
public class RefreshGUI 
{
    public static void atualizarPinos(ArrayList<Jogador> jogadores)
    {
            for(int i = 0; i < jogadores.size(); i++)
            {
                switch(jogadores.get(i).getCor())
                {
                case Definicoes.BRANCO:
                    UserInterface.Pecas.atualizarBranco(jogadores.get(i).getX(), jogadores.get(i).getY());
                    break;
                case Definicoes.PRETO:
                    UserInterface.Pecas.atualizarPreto(jogadores.get(i).getX(), jogadores.get(i).getY());
                    break;
                case Definicoes.AZUL:
                    UserInterface.Pecas.atualizarAzul(jogadores.get(i).getX(), jogadores.get(i).getY());
                    break;
                case Definicoes.AMARELO:
                    UserInterface.Pecas.atualizarAmarelo(jogadores.get(i).getX(), jogadores.get(i).getY());
                    break;
                case Definicoes.VERDE:
                    UserInterface.Pecas.atualizarVerde(jogadores.get(i).getX(), jogadores.get(i).getY());
                    break;
                case Definicoes.VERMELHO:
                    UserInterface.Pecas.atualizarVermelho(jogadores.get(i).getX(), jogadores.get(i).getY());
                }
            }
    }
    
    public static void atualizarJogadoresXY(ArrayList<Jogador> jogadores, ArrayList<Casa> casasInterface)
    {
        for(int i = 0; i < jogadores.size(); i++)
        {
            jogadores.get(i).setX(casasInterface.get(jogadores.get(i).getPosicaoTabuleiro()).x());
            jogadores.get(i).setY(casasInterface.get(jogadores.get(i).getPosicaoTabuleiro()).y());
        }
    }
    
    public static void atualizarTooltip(ArrayList<Carta> cartas_na_ordem_do_tabuleiro, ArrayList<Jogador> jogadores, int ID)
    {
            for(int i = 0; i < cartas_na_ordem_do_tabuleiro.size(); i++)
            {
                    if(cartas_na_ordem_do_tabuleiro.get(i).getId() == jogadores.get(ID).getPosicaoTabuleiro())
                    {
                        //Atualiza a label com a tooltip da carta
                        UserInterface.Labels.alterarTooltip(cartas_na_ordem_do_tabuleiro.get(i).tooltip(jogadores));
                    }
            }
    }
    
    public static void atualizarTooltip2(ArrayList<Carta> cartas_na_ordem_do_tabuleiro, ArrayList<Jogador> jogadores)
    {
            for(int i = 0; i < cartas_na_ordem_do_tabuleiro.size(); i++)
            {
                for(int j = 0; j < jogadores.size(); j ++)
                {
                    if(cartas_na_ordem_do_tabuleiro.get(i).getId() == jogadores.get(j).getPosicaoTabuleiro())
                    {
                        //Atualiza a label com a tooltip da carta
                        UserInterface.Labels.alterarTooltip(cartas_na_ordem_do_tabuleiro.get(i).tooltip(jogadores));
                    }
                }
            }
    }
    
    public static void atualizarLabels(ArrayList<Jogador> jogadores, int ID)
    {
        for(int i = 0; i < jogadores.size(); i++)
        {
            if(ID == jogadores.get(i).getId())
            {
                Labels.alterarNomeJogador(jogadores.get(ID).getName(),jogadores.get(ID).getCor());
                Labels.alterarDinheiro(jogadores.get(ID).getSaldo());
            }
        }
    }
}
