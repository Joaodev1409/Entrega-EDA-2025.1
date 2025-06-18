package Fila;

import Pilha.Pilha;
import Excecoes.*;

public class Fila implements Fila_IF {

    private Pilha pilhaInput;
    private Pilha pilhaOut;

    public Fila() {
        pilhaInput = new Pilha();
        pilhaOut = new Pilha();
    }

    @Override
    public void enqueue(Integer elemento){
        pilhaInput.push(elemento);
    }

    @Override
    public Integer dequeue() throws FilaVaziaException{
        if (isEmpty()){
            throw new FilaVaziaException();
        }
        if (pilhaOut.isEmpty()){
            transferirElementosDePilhas();
        }
        try{
            return pilhaOut.pop();
        } catch(PilhaVaziaException e){
            throw new FilaVaziaException();
        }
    }



    @Override
    public boolean isEmpty() {
        return pilhaInput.isEmpty() && pilhaOut.isEmpty();
    }

    @Override
    public Integer head() throws FilaVaziaException {
        if (isEmpty()) {
            throw new FilaVaziaException();
        }

        if (pilhaOut.isEmpty()) {
            transferirElementosDePilhas();
        }

        try {
            return pilhaOut.top();
        } catch (Exception e) {
            throw new FilaVaziaException();
        }
    }

    private void transferirElementosDePilhas() {

        while (!pilhaInput.isEmpty()){
            try{
                pilhaOut.push(pilhaInput.pop());
            } catch(PilhaVaziaException e){}
        }
    }
}