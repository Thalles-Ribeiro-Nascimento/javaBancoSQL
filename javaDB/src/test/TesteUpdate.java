package test;

import java.util.Scanner;

import dbDao.ContatoDAO;

public class TesteUpdate {

	public static void main(String[] args) {

		System.out.println("Digite uma coluna que queira editar: ");
		System.out.println("1: Nome");
		System.out.println("2: Email");
		System.out.println("3: Endereço");
		System.out.println("4: CPF");		
		Scanner chave = new Scanner(System.in);
		int coluna = chave.nextInt();

		System.out.println("Digite o novo valor para a coluna: ");
		Scanner valor = new Scanner(System.in);
		String dado = valor.nextLine();
		
		System.out.println("Digite o id: ");
		Scanner id = new Scanner(System.in);
		int Id = id.nextInt();

		try {

			ContatoDAO dao = new ContatoDAO();
			dao.update(coluna, dado, Id);
			System.out.println("Atualização feita!");
			

		} catch (Exception e) {
			System.out.println("Não foi possível atualizar! Causa: "+e);
			
		}

		chave.close();
		valor.close();
		id.close();
	}

}
