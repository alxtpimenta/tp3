package Builders;

import Elementos.CartaReceitaFederal;

public class ReceitaFederalCardBuilder {

	private final CartaReceitaFederal _carta_receita;
	
	public ReceitaFederalCardBuilder()
	{
		this._carta_receita = new CartaReceitaFederal();
	}
	
	public ReceitaFederalCardBuilder id(int id)
	{
		this._carta_receita.setId(id);
		return this;
	}
	
	public ReceitaFederalCardBuilder categoria(String categoria)
	{
		this._carta_receita.setCategoria(categoria);
		return this;
	}
	
	public ReceitaFederalCardBuilder cor(String cor)
	{
		this._carta_receita.setCor(cor);
		return this;
	}
	
	public ReceitaFederalCardBuilder nome(String nome)
	{
		this._carta_receita.setNome(nome);
		return this;
	}
	
	public ReceitaFederalCardBuilder owner(int owner)
	{
		this._carta_receita.setOwner(owner);
		return this;
	}
	
	public CartaReceitaFederal build()
	{
		return this._carta_receita;
	}
}
