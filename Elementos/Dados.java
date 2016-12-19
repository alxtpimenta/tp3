package Elementos;

import java.util.Random;

public class Dados {

	public int RolarDados()
	{
		int dado1,dado2;;
		Random randomGenerator = new Random();
				
		dado1 = randomGenerator.nextInt(6) + 1;
		dado2 = randomGenerator.nextInt(6) + 1;
		
		return dado1+dado2;
			
		
	}
	
	
}
