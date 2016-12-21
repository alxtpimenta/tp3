package Elementos;

public class SorteOuRevesAuxiliarCardbuilder {

	private final CartaSorteOuRevesAuxiliar _carta_sorte_ou_reves_auxliar;
	
	public SorteOuRevesAuxiliarCardbuilder()
	{
		this._carta_sorte_ou_reves_auxliar = new CartaSorteOuRevesAuxiliar();
	}
	
	public SorteOuRevesAuxiliarCardbuilder id(int id)
	{
		this._carta_sorte_ou_reves_auxliar.setId(id);
		return this;
	}
	
	public SorteOuRevesAuxiliarCardbuilder categoria(String categoria)
	{
		this._carta_sorte_ou_reves_auxliar.setCategoria(categoria);
		return this;
	}
	
	public SorteOuRevesAuxiliarCardbuilder cor(String cor)
	{
		this._carta_sorte_ou_reves_auxliar.setCor(cor);
		return this;
	}
	
	public SorteOuRevesAuxiliarCardbuilder nome(String nome)
	{
		this._carta_sorte_ou_reves_auxliar.setNome(nome);
		return this;
	}
	
	public SorteOuRevesAuxiliarCardbuilder owner(int owner)
	{
		this._carta_sorte_ou_reves_auxliar.setOwner(owner);
		return this;
	}
	
	public CartaSorteOuRevesAuxiliar build()
	{
		return this._carta_sorte_ou_reves_auxliar;
	}
}
