package test;


import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dbDao.ContatoDAO;
import model.Contato;

public class TesteQueryId {

	public static void main(String[] args) throws SQLException {
		ContatoDAO cdao = new ContatoDAO();
		System.out.println("Digite um id: ");
		Scanner id = new Scanner(System.in);
		int Id = id.nextInt();
		
		List<Contato> contato = cdao.getId(Id);

		for (Contato contato1 : contato) {
			System.out.println("Nome do contato: "+contato1.getNome());
			System.out.println("Email do contato: "+contato1.getEmail());
			System.out.println("Endereço do contato: "+contato1.getEndereco());
			System.out.println("CPF: "+contato1.getCpf());
			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
		}
		
		id.close();
	
	}

}
