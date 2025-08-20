package entidades;

import java.time.LocalDate;

public class Livro {

	private String titulo; 
	private	String autor;
	private int anoPublicacao;
	private String genero;
	private LocalDate now;
	
	
	public Livro (String titulo, String autor, int anoPublicacao, String genero) {
		setTitulo(titulo);
		setAutor(autor);
		setAnoPublicacao(anoPublicacao);
		setGenero(genero);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if(titulo.length() != 0) {
			this.titulo = titulo;
		}else {
			System.out.println("Exception");//refatorar depois!
		}
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		if(autor.length() >= 5) {
			this.autor = autor;
		}else {
			System.out.println("Exception");//refatorar depois!
		}
	}

	public int getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(int anoPublicacao) {
		now = null;
		
		if(anoPublicacao <= now.getYear() && anoPublicacao >=1900) {
			this.anoPublicacao = anoPublicacao;
		}else{
			System.out.println("Dispara Exception"); // refatorar depois
		}
		
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", autor=" + autor + ", anoPublicacao=" + anoPublicacao + ", genero="
				+ genero + "]";
	}
	
	
	
	
	
}
