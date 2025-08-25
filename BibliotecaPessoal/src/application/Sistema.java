package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import entidades.Biblioteca;
import entidades.Livro;

public class Sistema {
    
    private Biblioteca biblioteca = new Biblioteca();
    
    String path = "C:\\Users\\vynni\\3D Objects\\livros.txt";
    Scanner input = new Scanner(System.in);
    
    public void iniciarSistema() {
        System.out.println("================================");
        System.out.println("     Bem vindo a Biblioteca");
        System.out.println("================================");
        
        carregarLivrosDoArquivo();
       
        Boolean iniciado = true;
        do {
            
            System.out.println("Selecione uma opçao:");
            System.out.println("1 - Cadastrar Livro na biblioteca: ");
            System.out.println("2 - Listar Livros: ");
            System.out.println("3 - Buscar Livro por Autor: ");
            System.out.println("4 - Buscar Livro por Titulo: ");
            System.out.println("5 - Remover Livro por Titulo: ");
            System.out.println("0 - Fechar biblioteca; ");
            
            String opcao = input.nextLine();
            
            if(opcao.equals("1")) {
                
                System.out.println("Informe o Titulo do livro: ");
                String nomeLivro = input.nextLine();
                
                System.out.println("Informe o Autor do livro: ");
                String autorLivro = input.nextLine();
                
                System.out.println("Informe o Ano de publicacao do livro: ");
                int anoPublicacaoLivro = input.nextInt();
                
                input.nextLine(); // Consumir a quebra de linha
                System.out.println("Informe o genero do livro: ");
                String generoLivro = input.nextLine();
                
                System.out.println("Informe a Descricao do livro: ");
                String descricaoLivro = input.nextLine();
                
                biblioteca.adicionarLivro(new Livro(nomeLivro, autorLivro, anoPublicacaoLivro, generoLivro, descricaoLivro));
                
            }else if(opcao.equals("2")) {
                
                biblioteca.listarLivros();
                
            }else if(opcao.equals("3")) {
                System.out.println("Informe o Autor do livro:");
                String nomeAutor = input.nextLine();
                
                biblioteca.buscarLivrosPorAutor(nomeAutor);
            }else if(opcao.equals("4")) {
                System.out.println("Informe o Titulo do livro:");
                String tituloLivro = input.nextLine();
                
                biblioteca.buscarLivroPorTitulo(tituloLivro);
            }else if(opcao.equals("5")) {
                System.out.println("Informe o Titulo do livro:");
                String tituloLivro = input.nextLine();
                
                biblioteca.removerLivro(tituloLivro);
            }else if(opcao.equals("0")) {
                iniciado = false;
                salvarLivrosNoArquivo();
                System.out.println("Fechando a biblioteca!");
            }else {
                System.err.println("\n\nPasse uma opcao valida!!");
            }
        }while(iniciado);
                
    }
    
    private void carregarLivrosDoArquivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    
                    String[] dados = linha.split(";");
                    
                    // Verificar se tem exatamente 5 campos
                    if (dados.length == 5) {
                        String titulo = dados[0].trim();
                        String autor = dados[1].trim();
                        
                        int ano = Integer.parseInt(dados[2].trim());
                      
                        String genero = dados[3].trim();
                       
                        String descricao = dados[4].trim();
                        
                        
                        boolean livroExiste = false;
                        for (Livro livro : biblioteca.getLivros()) {
                            if (livro.getTitulo().equalsIgnoreCase(titulo) && 
                                livro.getAutor().equalsIgnoreCase(autor)) {
                                livroExiste = true;
                                break;
                            }
                        }
                        
                        if (!livroExiste) {
                            biblioteca.adicionarLivro(new Livro(titulo, autor, ano, genero, descricao));
                        }
                    }
                    else {
                        System.err.println("Linha com formato inválido: " + linha);
                    }
                
                }
            
            }
            System.out.println("Livros carregados do arquivo com sucesso!");
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado. Será criado um novo ao salvar.");
        }
    }
    
    
    private void salvarLivrosNoArquivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            
            for (Livro livro : biblioteca.getLivros()) {
                String linha = livro.getTitulo() + ";" + 
                              livro.getAutor() + ";" + 
                              livro.getAnoPublicacao() + ";" + 
                              livro.getGenero() + ";" + 
                              livro.getDescricao();
                writer.write(linha);
                writer.newLine();
            }
            System.out.println("Livros salvos no arquivo com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar livros no arquivo: " + e.getMessage());
        
            System.err.println("Verifique se o diretório existe: C:\\Users\\vynni\\3D Objects\\");
        }
    }
   
}