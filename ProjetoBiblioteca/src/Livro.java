public class Livro {

    private static int contador = 1;

    private int id;
    private String titulo;
    private String autor;
    private int quantidade;

    public Livro(String titulo, String autor, int quantidade) {
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("Titulo esta vazio");
        }
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade Invalida!");
        }
        this.id = contador++;
        this.titulo = titulo;
        this.autor = autor;
        this.quantidade = quantidade;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getQuantidade() { return quantidade; }

    public void adicionarQuantidade(int qtd) {
        if (qtd > 0) quantidade += qtd;
    }
    public void emprestar() {
        if (quantidade > 0) quantidade--;
        else throw new IllegalStateException("Sem estoque");
    }
    public void devolver() {
        quantidade++;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Titulo: " + titulo +
                " | Autor: " + autor +
                " | Disponivel: " + quantidade;
    }
}