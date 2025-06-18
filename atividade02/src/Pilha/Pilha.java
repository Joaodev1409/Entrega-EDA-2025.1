package Pilha;

import Excecoes.*;
import Lista.Lista; //lista duplamente encadeada.

public class Pilha implements Pilha_IF {

    private Lista lista;

    public Pilha() {
        lista = new Lista();
    }


    @Override
    public Integer pop() throws PilhaVaziaException{
        if (isEmpty()) {
            throw new PilhaVaziaException();
        }
        try {
            Integer elemento = lista.tail();  // Pega o elemento do topo (último inserido)
            lista.remove(elemento);           // Remove esse elemento
            return elemento;
        } catch (Exception e) {
            throw new PilhaVaziaException();  // Garante que se der qualquer erro, levanta exceção da pilha
        }
    }

    @Override
    public void push(Integer elemento) {
        lista.insert(elemento);
    }

    @Override
    public boolean isEmpty() {
        return lista.isEmpty();
    }

    @Override
    public Integer top() throws PilhaVaziaException{
        if (isEmpty()) {
            throw new PilhaVaziaException();
        }
        try {
            return lista.tail();  // Apenas consulta o elemento no topo (último)
        } catch (Exception e) {
            throw new PilhaVaziaException();
        }
    }

}
