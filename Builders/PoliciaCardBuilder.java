package Builders;

import Elementos.CartaPolicia;

public class PoliciaCardBuilder {

	private final CartaPolicia _carta_policia;
	
	public PoliciaCardBuilder()
	{
		this._carta_policia = new CartaPolicia();
		
	}
	
	public PoliciaCardBuilder id(int id)
	{
		this._carta_policia.setId(id);
		return this;
	}
	
	public PoliciaCardBuilder categoria(String categoria)
	{
		this._carta_policia.setCategoria(categoria);
		return this;
	}
	
	public PoliciaCardBuilder cor(String cor)
	{
		this._carta_policia.setCor(cor);
		return this;
	}
	
	public PoliciaCardBuilder nome(String nome)
	{
		this._carta_policia.setNome(nome);
		return this;
	}
	
	public PoliciaCardBuilder owner(int owner)
	{
		this._carta_policia.setOwner(owner);
		return this;
	}
	
	public CartaPolicia build()
	{
		return this._carta_policia;
	}
	
}
