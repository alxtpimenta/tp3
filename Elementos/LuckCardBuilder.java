package Elementos;
import Elementos.CartaSorteOuReves;

public class LuckCardBuilder {

	private CartaSorteOuReves _carta_sorte_reves;
	
	public LuckCardBuilder()
	{
		this._carta_sorte_reves = new CartaSorteOuReves();
	}
	
	public LuckCardBuilder id(int id)
	{
		this._carta_sorte_reves.setId(id);
		return this;
	}
	
	public LuckCardBuilder categoria(String categoria)
	{
		this._carta_sorte_reves.setCategoria(categoria);
		return this;
	}
	
	public LuckCardBuilder cor(String cor)
	{
		this._carta_sorte_reves.setCor(cor);
		return this;
	}
	
	public LuckCardBuilder nome(String nome)
	{
		this._carta_sorte_reves.setNome(nome);
		return this;
	}
	
	public LuckCardBuilder owner(int owner)
	{
		this._carta_sorte_reves.setOwner(owner);
		return this;
	}
	
	public LuckCardBuilder quantidade(int quantidade)
	{
		this._carta_sorte_reves.setQuantidade(quantidade);
		return this;
	}
	
	public LuckCardBuilder action(int action)
	{
		this._carta_sorte_reves.setAction(action);
		return this;
	}
	
	public CartaSorteOuReves build() {
		return this._carta_sorte_reves;
	}
}
