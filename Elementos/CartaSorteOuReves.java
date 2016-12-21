package Elementos;

import java.util.ArrayList;

public class CartaSorteOuReves extends Carta {

	private int _quant;
	private int _action;
	
	public void setQuantidade(int quant)
	{
		this._quant = quant;
	}
	public int getQuantidade()
	{
		return this._quant;
	}
	
	public void setAction(int action_ref)
	{
		this._action = action_ref;
	}
	public int getAction()
	{
		return this._action;
	}
        
        @Override
        public String tooltip(ArrayList<Jogador> jogadores)
        {
            return this.getNome();
        }
	
}
