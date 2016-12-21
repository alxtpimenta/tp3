package Elementos;

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
        
        public String tooltip()
        {
            return this.getNome();
        }
	
}
