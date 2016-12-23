package Builders;

import Elementos.CartaRestituicaoImpostoDeRenda;

public class RestituicaoCardBuilder {

private final CartaRestituicaoImpostoDeRenda _carta_restituicao;
	
	public RestituicaoCardBuilder()
	{
		this._carta_restituicao = new CartaRestituicaoImpostoDeRenda();
	}	

	public RestituicaoCardBuilder id(int id)
	{
		this._carta_restituicao.setId(id);
		return this;
	}
	
	public RestituicaoCardBuilder categoria(String categoria)
	{
		this._carta_restituicao.setCategoria(categoria);
		return this;
	}
	
	public RestituicaoCardBuilder cor(String cor)
	{
		this._carta_restituicao.setCor(cor);
		return this;
	}
	
	public RestituicaoCardBuilder nome(String nome)
	{
		this._carta_restituicao.setNome(nome);
		return this;
	}
	
	public RestituicaoCardBuilder owner(int owner)
	{
		this._carta_restituicao.setOwner(owner);
		return this;
	}
	
	public CartaRestituicaoImpostoDeRenda build()
	{
		return this._carta_restituicao;
	}
	
}
