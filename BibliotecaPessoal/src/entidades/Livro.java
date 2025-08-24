package entidades;

public class Livro {

	private String titulo; 
	private	String autor;
	private int anoPublicacao;
	private String genero;
	private String descricao;
	private int now ;
	
	
	public Livro (String titulo, String autor, int anoPublicacao, String genero,String descricao) {
		setTitulo(titulo);
		setAutor(autor);
		setAnoPublicacao(anoPublicacao);
		setGenero(genero);
		setDescricao(descricao);
		this.now = 2025;
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
		if(autor.length() <= 4) {
			this.autor = autor;
		}
	}

	public int getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(int anoPublicacao) {
		if(anoPublicacao <= now && anoPublicacao >=1800) {
			this.anoPublicacao = anoPublicacao;
		}
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", autor=" + autor + ", anoPublicacao=" + anoPublicacao + ", genero="
				+ genero + ", descricao=" + descricao + "]";
	}

	

	
	
	
	
	
}
