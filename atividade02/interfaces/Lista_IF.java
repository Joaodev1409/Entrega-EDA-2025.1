package atividade02;

/*
 * Interface para implementação da classe "Lista",
 * que deve ser implementada como uma Lista Duplamente Encadeada
 */
public interface Lista_IF  {

	public Integer remove(Integer elemento) throws Exception;
	
	public void insert(Integer elemento);
	
	public boolean isEmpty();
	
	public Integer search(Integer elemento) throws Exception;
	
	public Integer head() throws Exception;
	
	public Integer tail() throws Exception;
	
	public int size();
	
}
