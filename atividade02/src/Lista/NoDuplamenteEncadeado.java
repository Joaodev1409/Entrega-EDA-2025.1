package Lista;

public class NoDuplamenteEncadeado<T> {
    	protected T chave;
	protected NoDuplamenteEncadeado<T> proximo = null;
	
	public NoDuplamenteEncadeado() {
		this.setChave(null);
		this.setProximo(null);
	}
	
	public NoDuplamenteEncadeado(T chave) {
		this.setChave(chave);
		this.setProximo(null);
	}
	
	public NoDuplamenteEncadeado(T chave, NoDuplamenteEncadeado<T> proximo) {
		this.setChave(chave);
		this.setProximo(proximo);
	}

	public T getChave() {
		return chave;
	}

	public void setChave(T chave) {
		this.chave = chave;
	}

	public NoDuplamenteEncadeado<T> getProximo() {
		return proximo;
	}

	public void setProximo(NoDuplamenteEncadeado<T> proximo) {
		this.proximo = proximo;
	}
	
	public boolean isNull() {
		return (chave == null ? true:false);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || this.chave == null) {
			return false;
		}
		@SuppressWarnings("unchecked")
		NoDuplamenteEncadeado<T> aComparar = ((NoDuplamenteEncadeado<T>) obj);
		if ( (this.chave.compareTo(aComparar.getChave()) == 0) &&
				(this.getProximo().equals(aComparar.getProximo())) ) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		if (!this.isNull())
			return this.chave.toString();
		return null;
	}
	
	
}
