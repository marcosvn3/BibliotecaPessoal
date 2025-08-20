package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import entidades.Biblioteca;
import entidades.Livro;

public class Sistema {
	
	private Biblioteca biblioteca = new Biblioteca();
	
	String path = "C:\\Users\\vynni\\3D Objects\\biblioteca\\";
	Scanner input = new Scanner(System.in);
	
	public Sistema() {};
	
	public void iniciarSistema() {
		System.out.println("================================");
		System.out.println("     Bem vindo a Biblioteca");
		System.out.println("================================");
		
		Boolean iniciado = true;
		do {
			
			System.out.println("Selecione uma opçao:");
			System.out.println("1 - Cadastrar Livro na biblioteca: ");
			System.out.println("2 - Listar Livros: ");
			System.out.println("3 - Buscar Livro por Autor: ");
			System.out.println("4 - Buscar Livro por Titulo: ");
			System.out.println("0 - Fechar biblioteca; ");
			
			String opcao = input.nextLine();
			
			if(opcao.equals("1")) {
				input.nextLine();
				
				System.out.println("Informe o Titulo do livro: ");
				String nomeLivro = input.nextLine();
				System.out.println("Informe o Autor do livro: ");
				String autorLivro = input.nextLine();
				System.out.println("Informe o Ano de publicacao do livro: ");
				int anoPublicacaoLivro = input.nextInt();
				System.out.println("Informe o Descricao do livro do livro: ");
				String descricaoLivro = input.nextLine();
				
				biblioteca.adicionarLivro(new Livro(nomeLivro,autorLivro,anoPublicacaoLivro,descricaoLivro));
				
			}else if(opcao.equals("2")) {
				
				biblioteca.listarLivros();
				
			}else if(opcao.equals("3")) {
				input.nextLine();
				System.out.println("Informe o Autor do livro:");
				String nomeAutor = input.nextLine();
				
				biblioteca.buscarLivrosPorAutor(nomeAutor);
			}else if(opcao.equals("4")) {
				input.nextLine();
				System.out.println("Informe o Titulo do livro:");
				String tituloLivro = input.nextLine();
				
				biblioteca.buscarLivroPorTitulo(tituloLivro);;
			}else if(opcao.equals("0")) {
				iniciado = false;
				System.out.println("Fechando a biblioteca!");
			}else {
				System.err.println("\n\nPasse uma opcao valida!!");
			}
		}while(iniciado);
				
	}
	
	
	
	
	
	
	
	
	
	
	public  void lerArquivo(){
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
		    String linha;
		    while ((linha = reader.readLine()) != null) {
		        System.out.println(linha);
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
}
