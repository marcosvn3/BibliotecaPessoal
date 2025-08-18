package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sistema {
	String path = "C:\\Users\\vynni\\3D Objects\\meuArquivo.txt";
	
	public Sistema() {};
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
