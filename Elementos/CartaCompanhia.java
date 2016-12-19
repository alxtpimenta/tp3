package Elementos;

public class CartaCompanhia extends Carta{

	private int valor_de_compra;
	private int valor_de_aluguel_base; //aluguel aqui tem que ser multiplicado pelo valor da soma dos dados
	private int valor_hipoteca;
	
	public void setValorDeCompra(int valor_de_compra)
	{
		this.valor_de_compra = valor_de_compra;
	}
	public int getValorDeCompra()
	{
		return this.valor_de_compra;
	}
	
	public void setValorDeAluguelBase(int valor_de_aluguel_base)
	{
		this.valor_de_aluguel_base = valor_de_aluguel_base;
	}
	public int getValorDeAluguelBase()
	{
		return this.valor_de_aluguel_base;
	}
	
	public void setValorHipoteca(int valor_hipoteca)
	{
		this.valor_hipoteca = valor_hipoteca;
	}
	public int getValorHipoteca()
	{
		return this.valor_hipoteca;
	}
	
}
