package Elementos;

public class FeriasCardBuilder {

	private final CartaFerias _carta_ferias;
	
	public FeriasCardBuilder()
	{
		this._carta_ferias = new CartaFerias();
	}	

	public FeriasCardBuilder id(int id)
	{
		this._carta_ferias.setId(id);
		return this;
	}
	
	public FeriasCardBuilder categoria(String categoria)
	{
		this._carta_ferias.setCategoria(categoria);
		return this;
	}
	
	public FeriasCardBuilder cor(String cor)
	{
		this._carta_ferias.setCor(cor);
		return this;
	}
	
	public FeriasCardBuilder nome(String nome)
	{
		this._carta_ferias.setNome(nome);
		return this;
	}
	
	public FeriasCardBuilder owner(int owner)
	{
		this._carta_ferias.setOwner(owner);
		return this;
	}
	
	public CartaFerias build()
	{
		return this._carta_ferias;
	}
	
}
