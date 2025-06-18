package Lista;


public class NoDuplamenteEncadeado{
    protected Integer chave;
	protected NoDuplamenteEncadeado proximo = null;
    protected NoDuplamenteEncadeado anterior = null;
	
	public NoDuplamenteEncadeado() {
		this.setChave(null);
		this.setProximo(null);
	}
	
	public NoDuplamenteEncadeado(Integer chave) {
		this.setChave(chave);
		this.setProximo(null);
	}
	
	public NoDuplamenteEncadeado(Integer chave, NoDuplamenteEncadeado proximo) {
		this.setChave(chave);
		this.setProximo(proximo);
	}

	public Integer getChave() {
		return chave;
	}

	public void setChave(Integer chave) {
		this.chave = chave;
	}

	public NoDuplamenteEncadeado getProximo() {
		return proximo;
	}

	public void setProximo(NoDuplamenteEncadeado proximo) {
		this.proximo = proximo;
	}

    public NoDuplamenteEncadeado getAnterior() {
		return anterior;
	}
	public void setAnterior(NoDuplamenteEncadeado anterior) {
		this.anterior = anterior;
	}
	
	public boolean isNull() {
		return (chave == null ? true:false);
	}
    
	public String toString() {
		if (!this.isNull())
			return this.chave.toString();
		return null;
	}
	
	
}
