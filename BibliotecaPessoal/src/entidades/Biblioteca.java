package entidades;

import java.util.HashMap;

public class Biblioteca {
	private HashMap<String,Livro> estante;
	
	public Biblioteca () {
		this.estante = new HashMap<>();
	}
	
	public void adicionarLivroPorAutor(Livro livro) {
		estante.put(livro.getAutor(),livro);
		System.out.println("Livro adicionado com sucesso!");
	}
	
	public void adicionarLivroPorTitulo(Livro livro) {
		estante.put(livro.getTitulo(),livro);
		System.out.println("Livro adicionado com sucesso!");
	}
	
	public void listarLivros() {
		if(estante.isEmpty()) {
			System.out.println("Estante vazia!");
		}else {
			estante.forEach((t,l) -> System.out.println("Livro: "+t+"-"+l));
		}
	}
	
	public void buscarLivroPorAutor(String autor) {	
		if(!estante.containsKey(autor)) {
			System.out.println(autor + "- não encontrado");
		}else {
			estante.get(autor);
		}
	}
	
	
	
	
	
	
	
	
}
