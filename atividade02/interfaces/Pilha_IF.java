/*
 * Interface para implementa��o da classe "Pilha",
 * a qual deve ser implementada com uma Lista Duplamente Encadeada
 */
public interface Pilha_IF  {

	public Integer pop() throws Exception;
	
	public void push(Integer elemento);
	
	public boolean isEmpty();
	
	public Integer top() throws Exception;
	
}
