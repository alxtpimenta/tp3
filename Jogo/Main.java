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
        int numjogadores;
        boolean modoPartida; //true é modo comum, de falência, e false é com contador por tempo/jogadas/etc
        
        /*
        Início do Jogo
        É aberta uma janela em que o usuário escolhe:
        
        -modo de término do jogo
         --depois de um tempo X ou de X passagens de cada jogador pela casa start
         --ou terminar pelo modo normal de falência.
         Com base na escolha, cria contador de tempo/passagens ou não cria.(Ou deixa a opção de trocar 
         de modo ligada durante o jogo, e inicia o contador de tempo/passadas de qualquer forma.)
         
         -numero de Jogadores.
           Após ler retorna esse numero de jogadores para serem criados aqui.
           
           a partir disto, instanciamos a classe jogo, entrando os parametros modo de termino e numero
           de jogadores.
        */
        
        Jogo partida = new Jogo (numJogadores, modoPartida);
        
    }
}
