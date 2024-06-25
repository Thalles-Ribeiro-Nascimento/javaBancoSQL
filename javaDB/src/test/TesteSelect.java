package test;

import java.sql.SQLException;
import java.util.List;

import dbDao.ContatoDAO;
import model.Contato;

public class TesteSelect {

	public static void main(String[] args) throws SQLException {
		ContatoDAO cdao = new ContatoDAO();
		List<Contato> contato = cdao.select();

		for (Contato contato1 : contato) {
			System.out.println("Nome do contato: "+contato1.getNome());
			System.out.println("Email do contato: "+contato1.getEmail());
			System.out.println("Endereço do contato: "+contato1.getEndereco());
			System.out.println("Idade: "+contato1.getIdade());
			System.out.println("+++++++++++++++++++++++++++++++++++++++++");
		}
	}

}

