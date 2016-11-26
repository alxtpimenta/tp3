/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogo;

import java.util.*;
import Elementos.Jogador;
import Propriedades.Definicoes;

public class Main 
{
    public static void main(String[] args) 
    {
        // TODO code application logic here
        int numJogadores;
        boolean modoPartida; //true é modo comum, de falência, e false é com contador por tempo/jogadas/etc
        long tempoMaxMinu;
        long horaAtual;
        long horaFinal;
        
        int i;
        
        String nome;
        int cor;
        int dados;
        Random gerador;
        
        /*
        Início do Jogo
        É aberta uma janela em que o usuário escolhe:
        
        -modo de término do jogo
         --depois de um tempo X, x em minutos escolhido pelo usuário
         --ou terminar pelo modo normal de falência. (mas mesmo assim jogador escolhe um tempo máximo para o jogo em minutos.)
         Com base na escolha, cria contador de tempo/passagens ou não cria.(Ou deixa a opção de trocar 
         de modo ligada durante o jogo (jogos que demoram muito) e inicia o contador de tempo/passadas de qualquer forma.)
         
         -numero de Jogadores. (entre MIN_JOGADORES E MAX_JOGADORES)
           Após ler retorna esse numero de jogadores para serem criados aqui.
        */
        
        //TESTE DA INTERFACE
        UserInterface.Dialogo.boasVindas();
        
        //Pedaço para testes, remover depois
        numJogadores = 4;
        modoPartida = true;
        tempoMaxMinu = 60;
        //fim pedaço para testes
        
        ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
        
        
        gerador = new Random(); //gerador de números aleatórios
        /* Código real que vamos usar
        for(i=0; i<numJogadores; i++)
        {
        	dados = gerador.nextInt(12)+1;
        	
            //Abre janela pedindo para inserir os dados relativos a cada jogador:
            //- nome (variável nome)
            //- cor escolhida (variável cor)
            //- animação/imagem lançar os dados (exibe valor sorteado pela variavel dados aqui no inicio do bloco)
            
        	jogadores.add(new Jogador(nome, Definicoes.QUANTIA_INICIAL, cor, dados));
        }
    	*/
        
        //Código temporário só enquanto a janela não fica pronta
        dados = gerador.nextInt(12)+1;
        jogadores.add(new Jogador("Alexandre", Definicoes.QUANTIA_INICIAL, 1, dados));
        
        dados = gerador.nextInt(12)+1;
        jogadores.add(new Jogador("Ana Carolina", Definicoes.QUANTIA_INICIAL, 2, dados));
        
        dados = gerador.nextInt(12)+1;
        jogadores.add(new Jogador("Ana Luiza", Definicoes.QUANTIA_INICIAL, 3, dados));
        
        dados = gerador.nextInt(12)+1;
        jogadores.add(new Jogador("Pedro", Definicoes.QUANTIA_INICIAL, 4, dados));
        //fim código temporário
        
        Collections.sort(jogadores); //jogadores ordenados no Array pela vez de jogar

        //Inicia a partida
        horaAtual = System.currentTimeMillis();
        horaFinal  = horaAtual + (tempoMaxMinu * 60000);
        
        
    }
}
