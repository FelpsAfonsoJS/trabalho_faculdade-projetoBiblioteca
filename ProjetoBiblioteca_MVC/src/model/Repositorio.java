package model;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    private List<Livro> livros = new ArrayList<>();
    private List<Aluno> alunos = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public List<Livro> getLivros() { return livros; }
    public List<Aluno> getAlunos() { return alunos; }
    public List<Emprestimo> getEmprestimos() { return emprestimos; }
}