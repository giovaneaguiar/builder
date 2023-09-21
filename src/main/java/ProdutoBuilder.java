import java.util.ArrayList;
import java.util.List;

public class ProdutoBuilder {

    private int id;
    private String nome;
    private double preco;
    private List<String> categorias;

    public ProdutoBuilder() {
        this.categorias = new ArrayList<>();
    }

    public Produto build() {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido");
        }
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço inválido");
        }
        return new Produto(id, nome, preco, categorias);
    }

    public ProdutoBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public ProdutoBuilder setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ProdutoBuilder setPreco(double preco) {
        this.preco = preco;
        return this;
    }

    public ProdutoBuilder addCategoria(String categoria) {
        this.categorias.add(categoria);
        return this;
    }
}