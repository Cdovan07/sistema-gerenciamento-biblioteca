package servico;

import java.util.ArrayList;
import modelo.Livro;

public class Biblioteca {

    private ArrayList<Livro> livros = new ArrayList<>();

    public void cadastrarLivro(Livro livro) {

        for (Livro livroExistente : livros) {
            if (livroExistente.getCodigo() == livro.getCodigo()) {
                System.out.println("Já existe um livro com esse código!");
                return;
            }
        }

        livros.add(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    public Livro buscarLivro(int codigo) throws LivroNaoEncontradoException {
        for (Livro livro : livros) {
            if (livro.getCodigo() == codigo) {
                return livro;
            }
        }

        throw new LivroNaoEncontradoException(
            "Livro com código " + codigo + " não encontrado."
        );
    }

    public void emprestarLivro(int codigo) throws LivroNaoEncontradoException {
        Livro livro = buscarLivro(codigo);

        if (livro.isEmprestado()) {
            System.out.println("Esse livro já está emprestado.");
        } else {
            livro.emprestar();
            System.out.println("Livro emprestado com sucesso!");
        }
    }

    public void devolverLivro(int codigo) throws LivroNaoEncontradoException {
        Livro livro = buscarLivro(codigo);

        if (!livro.isEmprestado()) {
            System.out.println("Esse livro não está emprestado.");
        } else {
            livro.devolver();
            System.out.println("Livro devolvido com sucesso!");
        }
    }
}
