package test;

import java.sql.SQLException;
import java.util.Scanner;

import dbDao.ContatoDAO;
import model.Contato;

public class TesteInsert {

	public static void main(String[] args) {
		Contato contato = new Contato();
		
		System.out.println("Escreva seu nome: ");
		Scanner nome = new Scanner(System.in);
		String name = nome.nextLine();
		contato.setNome(name);
		
		System.out.println("Escreva seu email: ");
		Scanner email = new Scanner(System.in);
		String e_mail = email.nextLine();
		contato.setEmail(e_mail);
		
		System.out.println("Escreva seu endereco: ");
		Scanner endereco = new Scanner(System.in);
		String end = endereco.nextLine();
		contato.setEndereco(end);
		
		System.out.println("Escreva sua idade: ");
		Scanner nascimento = new Scanner(System.in);
		int data = nascimento.nextInt();
		contato.setIdade(data);

		try {
			
			ContatoDAO dao = new ContatoDAO();
			dao.adiciona(contato);
			System.out.println("Gravação feita no Banco de Dados");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		nome.close();
		email.close();
		endereco.close();
		nascimento.close();

	}

}
