import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SistemaBiblioteca sistema = new SistemaBiblioteca();

        int opcao;

        do {
            System.out.println("\n FACULDADE INTELIGENCIA ILIMITADA");
            System.out.println("1- Cadastrar Livro");
            System.out.println("2- Cadastrar Aluno");
            System.out.println("3- Emprestar Livro");
            System.out.println("4- Devolver Livro");
            System.out.println("5- Buscar Livro");
            System.out.println("6- Relatorio de Emprestimos");
            System.out.println("0- Sair");
            System.out.print("Opcao: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Titulo: ");
                    String titulo = sc.nextLine();

                    System.out.print("Autor: ");
                    String autor = sc.nextLine();

                    System.out.print("Quantidade: ");
                    int qtd = sc.nextInt();
                    sc.nextLine();

                    sistema.cadastrarLivro(titulo, autor, qtd);
                    break;

                case 2:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("RA: ");
                    String ra = sc.nextLine();

                    sistema.cadastrarAluno(nome, ra);
                    break;

                case 3:
                    sistema.listarLivros();
                    System.out.print("ID do livro: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    sistema.listaAlunos();
                    System.out.print("Nome, RA ou numero do aluno: ");
                    String buscaAluno = sc.nextLine();

                    sistema.emprestarLivro(id, buscaAluno);
                    break;

                case 4:
                    sistema.relatorioEmprestimo();
                    System.out.print("Numero do emprestimo para devolver: ");
                    int emp = sc.nextInt();
                    sc.nextLine();

                    sistema.devolverLivro(emp);
                    break;

                case 5:
                    System.out.print("Buscar (titulo ou autor): ");
                    String termo = sc.nextLine();

                    sistema.buscarLivro(termo);
                    break;

                case 6:
                    sistema.relatorioEmprestimo();
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opcao invalida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}