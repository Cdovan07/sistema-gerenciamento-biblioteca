package app;

import java.util.Scanner;
import modelo.Livro;
import servico.Biblioteca;
import servico.LivroNaoEncontradoException;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE BIBLIOTECA =====");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Buscar livro");
            System.out.println("4 - Emprestar livro");
            System.out.println("5 - Devolver livro");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = entrada.nextInt();
                entrada.nextLine();

                switch (opcao) {

                    case 1:
                        System.out.print("Código: ");
                        int codigo = entrada.nextInt();
                        entrada.nextLine();

                        System.out.print("Título: ");
                        String titulo = entrada.nextLine();

                        System.out.print("Autor: ");
                        String autor = entrada.nextLine();

                        biblioteca.cadastrarLivro(
                            new Livro(codigo, titulo, autor)
                        );
                        break;

                    case 2:
                        biblioteca.listarLivros();
                        break;

                    case 3:
                        System.out.print("Digite o código: ");
                        codigo = entrada.nextInt();

                        Livro livro = biblioteca.buscarLivro(codigo);
                        System.out.println(livro);
                        break;

                    case 4:
                        System.out.print("Código do livro: ");
                        codigo = entrada.nextInt();

                        biblioteca.emprestarLivro(codigo);
                        break;

                    case 5:
                        System.out.print("Código do livro: ");
                        codigo = entrada.nextInt();

                        biblioteca.devolverLivro(codigo);
                        break;

                    case 0:
                        System.out.println("Encerrando o sistema...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }

            } catch (LivroNaoEncontradoException e) {
                System.out.println("Erro: " + e.getMessage());

                opcao = -1;

            } catch (Exception e) {
                System.out.println("Entrada inválida!");
                entrada.nextLine();

                opcao = -1;
            }

        } while (opcao != 0);

        entrada.close();
    }
}

