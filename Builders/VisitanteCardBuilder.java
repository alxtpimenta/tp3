package Builders;

import Elementos.CartaVisitante;

public class VisitanteCardBuilder {

private final CartaVisitante _carta_visitante;
	
	public VisitanteCardBuilder()
	{
		this._carta_visitante = new CartaVisitante();
	}	

	public VisitanteCardBuilder id(int id)
	{
		this._carta_visitante.setId(id);
		return this;
	}
	
	public VisitanteCardBuilder categoria(String categoria)
	{
		this._carta_visitante.setCategoria(categoria);
		return this;
	}
	
	public VisitanteCardBuilder cor(String cor)
	{
		this._carta_visitante.setCor(cor);
		return this;
	}
	
	public VisitanteCardBuilder nome(String nome)
	{
		this._carta_visitante.setNome(nome);
		return this;
	}
	
	public VisitanteCardBuilder owner(int owner)
	{
		this._carta_visitante.setOwner(owner);
		return this;
	}
	
	public CartaVisitante build()
	{
		return this._carta_visitante;
	}
	
	
}
