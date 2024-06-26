package test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dbDao.ContatoDAO;
import model.Contato;

public class TesteQueryName {

	public static void main(String[] args) {
		try {
			ContatoDAO cdao = new ContatoDAO();
			System.out.println("Digite uma letra: ");
			Scanner name = new Scanner(System.in);
			String letra = name.nextLine();

			List<Contato> contato = cdao.getNome(letra);

			for (Contato contato1 : contato) {
				System.out.println("Nome do contato: "+contato1.getNome());
				System.out.println("Email do contato: "+contato1.getEmail());
				System.out.println("Endereço do contato: "+contato1.getEndereco());
				System.out.println("CPF: "+contato1.getCpf());
				System.out.println("+++++++++++++++++++++++++++++++++++++++++");
			}

			name.close();
			
		}catch (SQLException e) {
			System.out.println("Erro de busca: "+e);
		}
	}

}
