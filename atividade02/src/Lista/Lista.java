package Lista;
import Excecoes.*;

public class Lista implements Lista_IF {

    NoDuplamenteEncadeado cabeca = null;
    NoDuplamenteEncadeado cauda = null;

    public Lista() {
        cabeca = new NoDuplamenteEncadeado();
        cauda = new NoDuplamenteEncadeado();
        cabeca.setProximo(cauda);
        cabeca.setAnterior(cabeca);
    }

    @Override
    public Integer head(){
        return cabeca.getProximo().chave;
    }
    @Override
    public Integer tail(){
        return cauda.getAnterior().chave;
    }

    @Override
    public boolean isEmpty() {
        return cabeca.getProximo() == cauda;
    }

    @Override
    public int size() {
        if (isEmpty()) return 0;
        int contador = 1;
        NoDuplamenteEncadeado apontador = cabeca.getProximo();
        while (apontador.getProximo() != cauda) {
            apontador = apontador.getProximo();
            contador++;
        }
        return contador;
    }

    @Override
    public Integer search(Integer chave)throws ListaVaziaException,ElementoNaoEncontradoException {
        if(isEmpty()){
            throw new ListaVaziaException();
        }
        NoDuplamenteEncadeado retorno = cabeca;
        while (retorno != null && retorno != cauda) {
            if (retorno.getChave().equals(chave)) return retorno.chave;
            retorno = retorno.getProximo();
        }
        throw new ElementoNaoEncontradoException();
    }

    @Override
    public void insert(Integer chave) {
        NoDuplamenteEncadeado novoNo = new NoDuplamenteEncadeado(chave);
        if (isEmpty()) {
            novoNo.setProximo(cauda);
            cabeca.setProximo(novoNo);
        } else {
            NoDuplamenteEncadeado apontador = cabeca;
            while (apontador.getProximo() != cauda) {
                apontador = apontador.getProximo();
            }
            novoNo.setProximo(cauda);
            apontador.setProximo(novoNo);
        }
    }

    public void insert(Integer chave, int index) {
        NoDuplamenteEncadeado novoNo = new NoDuplamenteEncadeado(chave);
        if (isEmpty()) {
            novoNo.setProximo(cauda);
            cabeca.setProximo(novoNo);
        } else {
            NoDuplamenteEncadeado apontador = cabeca;
            for (int i = 0; i < index && apontador.getProximo() != cauda; i++) {
                apontador = apontador.getProximo();
            }
            novoNo.setProximo(apontador.getProximo());
            apontador.setProximo(novoNo);
        }
    }

    public Integer remove(Integer chave) throws ListaVaziaException, ElementoNaoEncontradoException {
        if (isEmpty()) throw new ListaVaziaException();
        NoDuplamenteEncadeado apontador = cabeca;
        while (apontador.getProximo() != cauda) {
            if (apontador.getProximo().getChave().equals(chave)) {
                NoDuplamenteEncadeado retorno = apontador.getProximo();
                apontador.setProximo(retorno.getProximo());
                return retorno.chave;
            }
            apontador = apontador.getProximo();
        }
        throw new ElementoNaoEncontradoException();
    }

    public NoDuplamenteEncadeado sucessor(Integer chave) throws ElementoNaoEncontradoException {
        NoDuplamenteEncadeado retorno = cabeca;
        while (retorno != cauda) {
            if (retorno.getChave().equals(chave)) {
                return retorno.getProximo();
            }
            retorno = retorno.getProximo();
        }
        throw new ElementoNaoEncontradoException();
    }

    public NoDuplamenteEncadeado predecessor(Integer chave) throws ElementoNaoEncontradoException {
        NoDuplamenteEncadeado apontador = cabeca.getProximo();
        while (apontador.getProximo() != cauda) {
            if (apontador.getProximo().getChave().equals(chave)) {
                return apontador;
            }
            apontador = apontador.getProximo();
        }
        throw new ElementoNaoEncontradoException();
    }
}

