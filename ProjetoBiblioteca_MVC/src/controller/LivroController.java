package controller;

import model.Livro;
import model.Repositorio;

public class LivroController {
    private Repositorio repositorio;

    public LivroController(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void cadastrar(String titulo, String autor, int quantidade) {
        repositorio.getLivros().add(new Livro(titulo, autor, quantidade));
        System.out.println("Livro cadastrado!");
    }

    public void listar() {
        if (repositorio.getLivros().isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        System.out.println("\n--- Livros ---");
        for (Livro l : repositorio.getLivros()) {
            System.out.println(l);
        }
    }

    public void buscar(String termo) {
        boolean encontrou = false;
        for (Livro l : repositorio.getLivros()) {
            if (l.getTitulo().toLowerCase().contains(termo.toLowerCase()) ||
                    l.getAutor().toLowerCase().contains(termo.toLowerCase())) {
                System.out.println(l);
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("Nenhum livro encontrado.");
    }

    public Livro buscarPorId(int id) {
        for (Livro l : repositorio.getLivros()) {
            if (l.getId() == id) return l;
        }
        return null;
    }
}