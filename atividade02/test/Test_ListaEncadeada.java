package atividade02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class Test_ListaEncadeada {
    private Lista_IF lista;

    @Before
    public void setUp() {
        lista = new ListaDuplamenteEncadeada();
    }

    // ---------- Testes de estado inicial ----------

    @Test
    public void deveIniciarVazia() {
        assertTrue(lista.isEmpty());
        assertEquals(0, lista.size());
    }

    @Test(expected = Exception.class)
    public void deveLancarExcecaoAoObterHeadDeListaVazia() throws Exception {
        lista.head();
    }

    @Test(expected = Exception.class)
    public void deveLancarExcecaoAoObterTailDeListaVazia() throws Exception {
        lista.tail();
    }

    @Test(expected = Exception.class)
    public void deveLancarExcecaoAoBuscarElementoInexistente() throws Exception {
        lista.search(9999);
    }

    @Test(expected = Exception.class)
    public void deveLancarExcecaoAoRemoverElementoInexistente() throws Exception {
        lista.remove(9999);
    }

    // ---------- Testes de inserção, busca e tamanho ----------

    @Test
    public void deveInserirElementosEAumentarTamanho() {
        for (int i = 0; i < 999; i++) {
            assertEquals(i, lista.size());
            lista.insert(1000 + i);
            assertEquals(i + 1, lista.size());
        }
    }

    @Test
    public void deveInserirEPermitirBuscaSimples() throws Exception {
        lista.insert(555);
        lista.insert(777);
        assertEquals(Integer.valueOf(555), lista.search(555));
        assertEquals(Integer.valueOf(777), lista.search(777));
    }

    @Test
    public void deveInserirEPermitirBuscaSequencial() throws Exception {
        for (int i = 0; i < 999; i++) {
            lista.insert(1000 + i);
            assertEquals(Integer.valueOf(1000 + i), lista.search(1000 + i));
        }
    }

    @Test
    public void devePermitirElementosDuplicados() throws Exception {
        lista.insert(42);
        lista.insert(42);
        assertEquals(2, lista.size());

        lista.remove(42); // remove uma ocorrência
        assertEquals(1, lista.size());
        assertEquals(Integer.valueOf(42), lista.search(42));
    }

    // ---------- Testes de head e tail ----------

    @Test
    public void deveRetornarHeadETailCorretamente() throws Exception {
        lista.insert(10);
        lista.insert(20);
        lista.insert(30);
        assertEquals(Integer.valueOf(10), lista.head());
        assertEquals(Integer.valueOf(30), lista.tail());
    }

    // ---------- Testes de remoção ----------

    @Test
    public void deveRemoverElementoComReducaoDeTamanho() throws Exception {
        lista.insert(555);
        lista.insert(777);
        assertEquals(2, lista.size());
        lista.remove(555);
        assertEquals(1, lista.size());
    }

    @Test(expected = Exception.class)
    public void deveLancarExcecaoAoBuscarElementoRemovido() throws Exception {
        lista.insert(555);
        lista.insert(777);
        lista.remove(555);
        lista.search(555); // deve lançar exceção
    }

    @Test
    public void deveRemoverTodosOsElementos() throws Exception {
        lista.insert(1);
        lista.insert(2);
        lista.insert(3);
        lista.remove(1);
        lista.remove(2);
        lista.remove(3);
        assertTrue(lista.isEmpty());
        assertEquals(0, lista.size());
    }

    @Test
    public void deveRemoverHeadETailCorretamente() throws Exception {
        lista.insert(10);
        lista.insert(20);
        lista.insert(30);

        lista.remove(10); // remove head
        assertEquals(Integer.valueOf(20), lista.head());

        lista.remove(30); // remove tail
        assertEquals(Integer.valueOf(20), lista.tail());
    }
}
