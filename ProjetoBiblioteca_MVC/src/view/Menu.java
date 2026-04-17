package view;

import java.util.Scanner;

public class Menu {
    private Scanner sc;

    public Menu(Scanner sc) {
        this.sc = sc;
    }

    public int exibirELer() {
        System.out.println("\n====== BIBLIOTECA ======");
        System.out.println("1 - Cadastrar Livro");
        System.out.println("2 - Cadastrar Aluno");
        System.out.println("3 - Emprestar Livro");
        System.out.println("4 - Devolver Livro");
        System.out.println("5 - Buscar Livro");
        System.out.println("6 - Relatorio de Emprestimos");
        System.out.println("0 - Sair");
        System.out.print("Opcao: ");
        int opcao = sc.nextInt();
        sc.nextLine();
        return opcao;
    }

    public String lerLinha(String rotulo) {
        System.out.print(rotulo + ": ");
        return sc.nextLine();
    }

    public int lerInt(String rotulo) {
        System.out.print(rotulo + ": ");
        int v = sc.nextInt();
        sc.nextLine();
        return v;
    }
}