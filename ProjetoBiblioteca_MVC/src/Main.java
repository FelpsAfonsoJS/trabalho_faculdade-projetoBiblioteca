import controller.AlunoController;
import controller.EmprestimoController;
import controller.LivroController;
import model.Repositorio;
import view.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Repositorio repositorio = new Repositorio();
        LivroController livroCtrl = new LivroController(repositorio);
        AlunoController alunoCtrl = new AlunoController(repositorio);
        EmprestimoController emprestimoCtrl = new EmprestimoController(repositorio, livroCtrl, alunoCtrl);
        Menu menu = new Menu(sc);

        int opcao;
        do {
            opcao = menu.exibirELer();
            switch (opcao) {
                case 1 -> livroCtrl.cadastrar(
                        menu.lerLinha("Titulo"),
                        menu.lerLinha("Autor"),
                        menu.lerInt("Quantidade"));

                case 2 -> alunoCtrl.cadastrar(
                        menu.lerLinha("Nome"),
                        menu.lerLinha("RA"));

                case 3 -> {
                    livroCtrl.listar();
                    int id = menu.lerInt("ID do livro");
                    alunoCtrl.listar();
                    String busca = menu.lerLinha("Nome, RA ou numero do aluno");
                    emprestimoCtrl.emprestar(id, busca);
                }

                case 4 -> {
                    emprestimoCtrl.relatorio();
                    int idx = menu.lerInt("Numero do emprestimo");
                    emprestimoCtrl.devolver(idx);
                }

                case 5 -> livroCtrl.buscar(menu.lerLinha("Buscar"));

                case 6 -> emprestimoCtrl.relatorio();

                case 0 -> System.out.println("Encerrando...");

                default -> System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);

        sc.close();
    }
}