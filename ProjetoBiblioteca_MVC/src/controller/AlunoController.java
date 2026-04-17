package controller;

import model.Aluno;
import model.Repositorio;

public class AlunoController {
    private Repositorio repositorio;

    public AlunoController(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void cadastrar(String nome, String ra) {
        for (Aluno a : repositorio.getAlunos()) {
            if (a.getRa().equalsIgnoreCase(ra)) {
                System.out.println("Ja existe um aluno com esse RA.");
                return;
            }
        }
        repositorio.getAlunos().add(new Aluno(nome, ra));
        System.out.println("Aluno cadastrado!");
    }

    public void listar() {
        if (repositorio.getAlunos().isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        System.out.println("\n--- Alunos ---");
        for (int i = 0; i < repositorio.getAlunos().size(); i++) {
            System.out.println(i + " - " + repositorio.getAlunos().get(i));
        }
    }

    // Busca por índice da lista, RA ou nome
    public Aluno buscar(String entrada) {
        if (entrada.matches("\\d+") && entrada.length() <= 2) {
            int idx = Integer.parseInt(entrada);
            if (idx >= 0 && idx < repositorio.getAlunos().size())
                return repositorio.getAlunos().get(idx);
        }
        for (Aluno a : repositorio.getAlunos()) {
            if (a.getRa().equalsIgnoreCase(entrada) ||
                    a.getNome().equalsIgnoreCase(entrada))
                return a;
        }
        return null;
    }
}