package atividade02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class Test_Fila {
    private Fila_IF fila;

    @Before
    public void setUp() {
        fila = new Fila();
    }

    // ---------- Estado inicial ----------

    @Test
    public void deveIniciarVazia() {
        assertTrue(fila.isEmpty());
    }

    @Test(expected = Exception.class)
    public void deveLancarExcecaoAoFazerDequeueEmFilaVazia() throws Exception {
        fila.dequeue();
    }

    @Test(expected = Exception.class)
    public void deveLancarExcecaoAoConsultarHeadDeFilaVazia() throws Exception {
        fila.head();
    }

    // ---------- Inserção e head ----------

    @Test
    public void devePermitirEnqueueEConsultarHead() throws Exception {
        fila.enqueue(100);
        assertEquals(Integer.valueOf(100), fila.head());

        fila.enqueue(200);
        assertEquals(Integer.valueOf(100), fila.head());
    }

    @Test
    public void devePermitirValoresDuplicados() throws Exception {
        fila.enqueue(99);
        fila.enqueue(99);
        assertEquals(Integer.valueOf(99), fila.head());
        fila.dequeue();
        assertEquals(Integer.valueOf(99), fila.head());
    }

    // ---------- Remoção (dequeue) ----------

    @Test
    public void deveRemoverElementosNaOrdemFIFO() throws Exception {
        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);

        assertEquals(Integer.valueOf(10), fila.dequeue());
        assertEquals(Integer.valueOf(20), fila.dequeue());
        assertEquals(Integer.valueOf(30), fila.dequeue());
        assertTrue(fila.isEmpty());
    }
}
