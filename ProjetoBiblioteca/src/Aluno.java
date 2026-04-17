public class Aluno {
    private String nome;
    private String ra;

    public Aluno(String nome, String ra) {
        if (nome == null || nome.isEmpty() || ra == null || ra.isEmpty()) {
            throw new IllegalArgumentException("Dados invalidos");
        }
        this.nome = nome;
        this.ra = ra;
    }

    public String getNome() { return nome; }
    public String getRa() { return ra; }

    @Override
    public String toString() {
        return nome + " (RA: " + ra + ")";
    }
}