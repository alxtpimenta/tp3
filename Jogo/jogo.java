package Jogo;

public class Jogo{
	
  int numJogadores;
  boolean modoPartida;
  long horaAtual;
  long horaFinal;
  
  
  public Jogo(int nj, boolean modo, long tmm){
	  
	//registra hora do começo
	 horaAtual = System.currentTimeMillis();
	 horaFinal  = horaAtual + (tmm x 60000);    
  }
  
  
  
}
 
