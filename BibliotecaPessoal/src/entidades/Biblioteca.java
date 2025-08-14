package entidades;

import java.util.HashMap;

public class Biblioteca {
	private HashMap<String, Livro> estante;

	public Biblioteca() {
		this.estante = new HashMap<>();
	}

	public void adicionarLivroPorAutor(Livro livro) {
		estante.put(livro.getAutor(), livro);
		System.out.println("Livro adicionado com sucesso!");
	}

	public void adicionarLivroPorTitulo(Livro livro) {
		estante.put(livro.getTitulo(), livro);
		System.out.println("Livro adicionado com sucesso!");
	}

	public void listarLivros() {
		if (!estante.isEmpty()) {
			estante.forEach((tituloL, livro) -> System.out.println("Livro" + tituloL + "-" + livro));
		} else {
			System.out.println("Estante vazia!");
		}

	}

	public void buscarLivroPorAutor(String autor) {
		if (!estante.containsKey(autor)) {
			System.out.println(autor + "- não encontrado");
		} else {
			estante.get(autor);
		}
	}
	
	public void buscarLivroPorTitulo(String titulo) {
		if (!estante.containsKey(titulo)) {
			System.out.println(titulo + "- não encontrado");
		} else {
			estante.get(titulo);
		}
	}
	

}
