import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Emprestimo {
    private Livro livro;
    private Aluno aluno;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean devolvido;

    public Emprestimo(Livro livro, Aluno aluno) {
        this.livro = livro;
        this.aluno = aluno;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = dataEmprestimo.plusDays(7);
        this.devolvido = false;
    }

    public void devolver() {
        devolvido = true;
        livro.devolver();
    }
    public boolean isDevolvido() { return devolvido; }

    public String getDataDevolucaoFormatada() {
        String diaSemana = dataDevolucao.getDayOfWeek()
                .getDisplayName(TextStyle.FULL, new Locale("pt", "BR"));
        return dataDevolucao + " (" + diaSemana + ")";
    }

    @Override
    public String toString() {
        return "Aluno: " + aluno +
                " | Livro: " + livro.getTitulo() +
                " | Devolucao: " + getDataDevolucaoFormatada() +
                (devolvido ? " [Devolvido]" : " [Em aberto]");
    }
}