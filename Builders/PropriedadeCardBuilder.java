package Builders;

import Elementos.CartaPropriedade;


public class PropriedadeCardBuilder {

	private final CartaPropriedade _carta_propriedade;
	
	public PropriedadeCardBuilder(){
		this._carta_propriedade = new CartaPropriedade();
	}
	
	public PropriedadeCardBuilder id(int id)
	{
		this._carta_propriedade.setId(id);
		return this;
	}
	
	public PropriedadeCardBuilder categoria(String categoria)
	{
		this._carta_propriedade.setCategoria(categoria);
		return this;
	}
	
	public PropriedadeCardBuilder cor(String cor)
	{
		this._carta_propriedade.setCor(cor);
		return this;
	}
	
	public PropriedadeCardBuilder nome(String nome)
	{
		this._carta_propriedade.setNome(nome);
		return this;
	}
	
	public PropriedadeCardBuilder owner(int owner)
	{
		this._carta_propriedade.setOwner(owner);
		return this;
	}
	
	public PropriedadeCardBuilder valor_de_compra(int valor_de_compra){
		this._carta_propriedade.setValorDeCompra(valor_de_compra);
		return this;
	}
	
	public PropriedadeCardBuilder aluguel(int aluguel){
		this._carta_propriedade.setAluguel(aluguel);
		return this;
	}
	
	public PropriedadeCardBuilder aluguel_com_uma_casa(int aluguel_com_uma_casa){
		this._carta_propriedade.setAluguelComUmaCasa(aluguel_com_uma_casa);
		return this;
	}
	
	public PropriedadeCardBuilder aluguel_com_duas_casas(int aluguel_com_duas_casas){
		this._carta_propriedade.setAluguelComDuasCasas(aluguel_com_duas_casas);
		return this;
	}
	
	public PropriedadeCardBuilder aluguel_com_tres_casas(int aluguel_com_tres_casas){
		this._carta_propriedade.setAluguelComTresCasas(aluguel_com_tres_casas);
		return this;
	}
	
	public PropriedadeCardBuilder aluguel_com_quatro_casas(int aluguel_com_quatro_casas){
		this._carta_propriedade.setAluguelComQuatroCasas(aluguel_com_quatro_casas);
		return this;
	}
	
	public PropriedadeCardBuilder aluguel_com_hotel(int aluguel_com_hotel){
		this._carta_propriedade.setAluguelComHotel(aluguel_com_hotel);
		return this;
	}
	
	public PropriedadeCardBuilder valor_compra_de_casa(int valor_compra_de_casa){
		this._carta_propriedade.setValorCompraDeCasa(valor_compra_de_casa);
		return this;
	}
	
	public PropriedadeCardBuilder valor_compra_de_hotel(int valor_compra_de_hotel){
		this._carta_propriedade.setValorCompraDeHotel(valor_compra_de_hotel);
		return this;
	}
	
	public PropriedadeCardBuilder valor_hipoteca(int valor_hipoteca){
		this._carta_propriedade.setValorHipoteca(valor_hipoteca);
		return this;
	}
	
	public CartaPropriedade build() {
		return this._carta_propriedade;
	}
	
	
}
