package Elementos;

import Elementos.CartaCompanhia;

public class CompanhiaCardBuilder {

	private CartaCompanhia _carta_companhia;
	
	public CompanhiaCardBuilder(){
		
		this._carta_companhia = new CartaCompanhia();
		
	}
	
	public CompanhiaCardBuilder id(int id)
	{
		this._carta_companhia.setId(id);
		return this;
	}
	
	public CompanhiaCardBuilder categoria(String categoria)
	{
		this._carta_companhia.setCategoria(categoria);
		return this;
	}
	
	public CompanhiaCardBuilder cor(String cor)
	{
		this._carta_companhia.setCor(cor);
		return this;
	}
	
	public CompanhiaCardBuilder nome(String nome)
	{
		this._carta_companhia.setNome(nome);
		return this;
	}
	
	public CompanhiaCardBuilder owner(int owner)
	{
		this._carta_companhia.setOwner(owner);
		return this;
	}
	
	public CompanhiaCardBuilder valor_de_compra_companhia(int valor_de_compra){
		this._carta_companhia.setValorDeCompra(valor_de_compra);
		return this;
	}	
	
	public CompanhiaCardBuilder valor_aluguel_base(int valor_aluguel_base){
		this._carta_companhia.setValorDeAluguelBase(valor_aluguel_base);
		return this;
	}
	
	public CompanhiaCardBuilder valor_hipoteca_companhia(int valor_hipoteca_companhia){
		this._carta_companhia.setValorHipoteca(valor_hipoteca_companhia);
		return this;
	}
	
	public CartaCompanhia build()
	{
		return this._carta_companhia;
	}
}
