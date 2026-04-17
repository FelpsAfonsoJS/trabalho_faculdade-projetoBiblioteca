import java.util.ArrayList;
import java.util.List;

public class SistemaBiblioteca {

    private List<Livro> livros = new ArrayList<>();
    private List<Aluno> alunos = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void cadastrarLivro(String titulo, String autor, int quantidade) {
        livros.add(new Livro(titulo, autor, quantidade));
        System.out.println("Livro cadastrado!");
    }

    public void cadastrarAluno(String nome, String ra) {
        // Impede RA duplicado
        for (Aluno a : alunos) {
            if (a.getRa().equalsIgnoreCase(ra)) {
                System.out.println("Ja existe um aluno com esse RA.");
                return;
            }
        }
        alunos.add(new Aluno(nome, ra));
        System.out.println("Aluno cadastrado!");
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }
        System.out.println("\n--- Livros ---");
        for (Livro l : livros) {
            System.out.println(l);
        }
    }

    public void listaAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        System.out.println("\n--- Alunos ---");
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println(i + " - " + alunos.get(i));
        }
    }

    public void buscarLivro(String termo) {
        boolean encontrou = false;
        for (Livro l : livros) {
            if (l.getTitulo().toLowerCase().contains(termo.toLowerCase()) ||
                    l.getAutor().toLowerCase().contains(termo.toLowerCase())) {
                System.out.println(l);
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("Nenhum livro encontrado.");
    }

    public void emprestarLivro(int idLivro, String buscaAluno) {
        // Busca livro pelo ID
        Livro livroSelecionado = null;
        for (Livro l : livros) {
            if (l.getId() == idLivro) {
                livroSelecionado = l;
                break;
            }
        }
        if (livroSelecionado == null) {
            System.out.println("Livro nao encontrado.");
            return;
        }
        if (livroSelecionado.getQuantidade() <= 0) {
            System.out.println("Livro indisponivel, quantidade em estoque: 0.");
            return;
        }

        // Busca aluno por índice, RA ou nome
        Aluno aluno = null;
        if (buscaAluno.matches("\\d+") && buscaAluno.length() <= 2) {
            // Trata como índice da lista se for número pequeno
            int idx = Integer.parseInt(buscaAluno);
            if (idx >= 0 && idx < alunos.size()) {
                aluno = alunos.get(idx);
            }
        }
        if (aluno == null) {
            // Tenta por RA ou por nome
            for (Aluno a : alunos) {
                if (a.getRa().equalsIgnoreCase(buscaAluno) ||
                        a.getNome().equalsIgnoreCase(buscaAluno)) {
                    aluno = a;
                    break;
                }
            }
        }
        if (aluno == null) {
            System.out.println("Aluno nao encontrado. Busque por nome, RA ou numero da lista.");
            return;
        }

        livroSelecionado.emprestar();
        emprestimos.add(new Emprestimo(livroSelecionado, aluno));
        System.out.println("Emprestimo realizado com sucesso!");
    }

    public void devolverLivro(int index) {
        if (index < 0 || index >= emprestimos.size()) {
            System.out.println("Emprestimo invalido.");
            return;
        }
        Emprestimo e = emprestimos.get(index);
        if (e.isDevolvido()) {
            System.out.println("Este livro ja foi devolvido.");
        } else {
            e.devolver();
            System.out.println("Livro devolvido com sucesso!");
        }
    }

    public void relatorioEmprestimo() {
        System.out.println("\n========== RELATORIO DE EMPRESTIMOS ==========");
        boolean temAberto = false;
        for (int i = 0; i < emprestimos.size(); i++) {
            Emprestimo e = emprestimos.get(i);
            if (!e.isDevolvido()) {
                System.out.println("[" + i + "] " + e);
                temAberto = true;
            }
        }
        if (!temAberto) System.out.println("Nenhum emprestimo em aberto.");
        System.out.println("BIBLIOTECA SONHOS FOFINHOS\n");
    }
}