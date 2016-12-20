package Elementos;

import Elementos.CartaInicio;

public class InicioCardBuilder {

	private CartaInicio _carta_inicio;
	
	public InicioCardBuilder()
	{
		this._carta_inicio = new CartaInicio();
	}	

	public InicioCardBuilder id(int id)
	{
		this._carta_inicio.setId(id);
		return this;
	}
	
	public InicioCardBuilder categoria(String categoria)
	{
		this._carta_inicio.setCategoria(categoria);
		return this;
	}
	
	public InicioCardBuilder cor(String cor)
	{
		this._carta_inicio.setCor(cor);
		return this;
	}
	
	public InicioCardBuilder nome(String nome)
	{
		this._carta_inicio.setNome(nome);
		return this;
	}
	
	public InicioCardBuilder owner(int owner)
	{
		this._carta_inicio.setOwner(owner);
		return this;
	}
	
	public CartaInicio build()
	{
		return this._carta_inicio;
	}
}
