package entidades;

import java.util.List;
import java.util.ArrayList;

public class Biblioteca {
	private List<Livro> estante;

	public Biblioteca() {
		this.estante = new ArrayList<>();
	}

	public void adicionarLivro(Livro livro) {
		estante.add(livro);
		System.out.println("Livro adicionado com sucesso!");
	}

	public void listarLivros() {
		if (!estante.isEmpty()) {
			for (Livro i : estante) {
				System.out.println(i);
			}
		} else {
			System.out.println("Estante vazia!");
		}

	}

	public void buscarLivrosPorAutor(String autor) {
		for (Livro livro : estante) {
			if (livro.getAutor().equalsIgnoreCase(autor)) {
				System.out.println(livro);
			} else {
				System.out.println("Livro não encontrado!");
			}
		}
	}

	public void buscarLivroPorTitulo(String titulo) {
		for (Livro livro : estante) {
			if (livro.getTitulo().equalsIgnoreCase(titulo)) {
				System.out.println(livro);
			} else {
				System.out.println("Livro não encontrado!");
			}
		}
	}

}
