/*
 * Interface para implementa��o da classe "Fila",
 * a qual deve ser implementada com duas pilhas
 */
public interface Fila_IF  {

	public Integer dequeue() throws Exception;
	
	public void enqueue(Integer elemento);
	
	public boolean isEmpty();
	
	public Integer head() throws Exception;
	
}
