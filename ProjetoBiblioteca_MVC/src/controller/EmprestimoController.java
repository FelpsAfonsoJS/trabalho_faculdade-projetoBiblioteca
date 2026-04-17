package controller;

import model.Aluno;
import model.Emprestimo;
import model.Livro;
import model.Repositorio;

public class EmprestimoController {
    private Repositorio repositorio;
    private LivroController livroController;
    private AlunoController alunoController;

    public EmprestimoController(Repositorio repositorio,
                                LivroController livroController,
                                AlunoController alunoController) {
        this.repositorio = repositorio;
        this.livroController = livroController;
        this.alunoController = alunoController;
    }

    public void emprestar(int idLivro, String buscaAluno) {
        Livro livro = livroController.buscarPorId(idLivro);
        if (livro == null) { System.out.println("Livro nao encontrado."); return; }
        if (livro.getQuantidade() <= 0) { System.out.println("Livro indisponivel."); return; }

        Aluno aluno = alunoController.buscar(buscaAluno);
        if (aluno == null) { System.out.println("Aluno nao encontrado."); return; }

        livro.emprestar();
        repositorio.getEmprestimos().add(new Emprestimo(livro, aluno));
        System.out.println("Emprestimo realizado!");
    }

    public void devolver(int index) {
        if (index < 0 || index >= repositorio.getEmprestimos().size()) {
            System.out.println("Emprestimo invalido.");
            return;
        }
        Emprestimo e = repositorio.getEmprestimos().get(index);
        if (e.isDevolvido()) {
            System.out.println("Livro ja devolvido.");
        } else {
            e.devolver();
            System.out.println("Livro devolvido!");
        }
    }

    public void relatorio() {
        System.out.println("\n===== RELATORIO DE EMPRESTIMOS =====");
        boolean temAberto = false;
        for (int i = 0; i < repositorio.getEmprestimos().size(); i++) {
            Emprestimo e = repositorio.getEmprestimos().get(i);
            if (!e.isDevolvido()) {
                System.out.println("[" + i + "] " + e);
                temAberto = true;
            }
        }
        if (!temAberto) System.out.println("Nenhum emprestimo em aberto.");
        System.out.println("=====================================\n");
    }
}