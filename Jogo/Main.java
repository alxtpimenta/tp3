/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogo;

/**
 *
 * @author alexandrepimenta
 */
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
        
        /*
        Início do Jogo
        É aberta uma janela em que o usuário escolhe:
        
        -modo de término do jogo
         --depois de um tempo X, x em minutos escolhido pelo usuário
         --ou terminar pelo modo normal de falência. (mas mesmo assim jogador escolhe um tempo máximo para o jogo em minutos.)
         Com base na escolha, cria contador de tempo/passagens ou não cria.(Ou deixa a opção de trocar 
         de modo ligada durante o jogo (jogos que demoram muito) e inicia o contador de tempo/passadas de qualquer forma.)
         
         -numero de Jogadores.
           Após ler retorna esse numero de jogadores para serem criados aqui.
        */
        
        //Pedaço para testes, remover depois
        numJogadores = 4;
        modoPartida = true;
        tempoMaxMinu = 60;
        //fim pedaço para testes
        
        //Inicia a partida
         horaAtual = System.currentTimeMillis();
         horaFinal  = horaAtual + (tempoMaxMinu x 60000);
        
        /*
        Abre janela pedindo para inserir os dados relativos a cada jogador:
        - nome
        - cor
        - lançar dados
        */
        
        for(i=0; i<numJogadores; i++)
        {
        }
        
    }
}
