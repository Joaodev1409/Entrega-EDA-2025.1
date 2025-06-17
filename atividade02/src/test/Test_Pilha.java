package atividade02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class Test_Pilha {
    private Pilha_IF pilha;

    @Before
    public void setUp() {
        pilha = new Pilha();
    }

    // ---------- Estado inicial ----------

    @Test
    public void deveIniciarVazia() {
        assertTrue(pilha.isEmpty());
    }

    @Test(expected = Exception.class)
    public void deveLancarExcecaoAoFazerPopEmPilhaVazia() throws Exception {
        pilha.pop();
    }

    @Test(expected = Exception.class)
    public void deveLancarExcecaoAoConsultarTopoDePilhaVazia() throws Exception {
        pilha.top();
    }

    // ---------- Inserção e topo ----------

    @Test
    public void devePermitirPushEConsultarTopo() throws Exception {
        pilha.push(10);
        assertEquals(Integer.valueOf(10), pilha.top());

        pilha.push(20);
        assertEquals(Integer.valueOf(20), pilha.top());
    }

    @Test
    public void devePermitirValoresDuplicados() throws Exception {
        pilha.push(42);
        pilha.push(42);
        assertEquals(Integer.valueOf(42), pilha.top());
        pilha.pop();
        assertEquals(Integer.valueOf(42), pilha.top());
    }

    // ---------- Remoção (pop) ----------

    @Test
    public void deveRemoverElementosNaOrdemLIFO() throws Exception {
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        assertEquals(Integer.valueOf(30), pilha.pop());
        assertEquals(Integer.valueOf(20), pilha.pop());
        assertEquals(Integer.valueOf(10), pilha.pop());
        assertTrue(pilha.isEmpty());
    }
}
