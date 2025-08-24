package entidades;

import java.util.List;
import java.util.ArrayList;

public class Biblioteca {
	private List<Livro> livros;

	public Biblioteca() {
		this.livros = new ArrayList<>();
	}

	public void adicionarLivro(Livro livro) {
		livros.add(livro);
		System.out.println("Livro adicionado com sucesso!");
	}

	
	public List<Livro> getLivros() {
        return livros;
    }


	public void listarLivros() {
		if (!livros.isEmpty()) {
			for (Livro i : livros) {
				System.out.println(i);
			}
		} else {
			System.out.println("Estante vazia!");
		}

	}

	public void buscarLivrosPorAutor(String autor) {
		for (Livro livro : livros) {
			if (livro.getAutor().equalsIgnoreCase(autor)) {
				System.out.println(livro);
			} else {
				System.out.println("Livro não encontrado!");
			}
		}
	}

	public void buscarLivroPorTitulo(String titulo) {
		for (Livro livro : livros) {
			if (livro.getTitulo().equalsIgnoreCase(titulo)) {
				System.out.println(livro);
			} else {
				System.out.println("Livro não encontrado!");
			}
		}
	}

}
