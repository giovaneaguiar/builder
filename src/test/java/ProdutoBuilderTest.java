import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class ProdutoBuilderTest {

    @Test
    void deveRetornarExcecaoParaProdutoComIDInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ProdutoBuilder().setNome("Produto 1").setPreco(100.0).build();
        });
    }

    @Test
    void deveRetornarExcecaoParaProdutoComNomeVazio() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ProdutoBuilder().setId(1).setPreco(100.0).build();
        });
    }

    @Test
    void deveRetornarExcecaoParaProdutoComPrecoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ProdutoBuilder().setId(1).setNome("Produto 1").build();
        });
    }

    @Test
    void deveCriarProdutoValido() {
        Produto produto = new ProdutoBuilder().setId(1).setNome("Produto 1").setPreco(100.0).addCategoria("Eletrônicos").addCategoria("Informática").build();

        assertNotNull(produto);
        assertEquals(1, produto.getId());
        assertEquals("Produto 1", produto.getNome());
        assertEquals(100.0, produto.getPreco(), 0.01);
        List<String> categorias = produto.getCategorias();
        assertNotNull(categorias);
        assertEquals(2, categorias.size());
        assertTrue(categorias.contains("Eletrônicos"));
        assertTrue(categorias.contains("Informática"));
    }
}
