package test;

import java.util.Scanner;

import dbDao.ContatoDAO;

public class TesteUpdate {

	public static void main(String[] args) {
		
		System.out.println("Digite uma coluna que queira editar: ");
		Scanner chave = new Scanner(System.in);
		String coluna = chave.nextLine();
		
		System.out.println("Digite o novo valor para a coluna: ");
		Scanner valor = new Scanner(System.in);
		String dado = valor.nextLine();
		
		System.out.println("Digite o id: ");
		Scanner linha = new Scanner(System.in);
		int id = linha.nextInt();
		
		try {
			
			ContatoDAO dao = new ContatoDAO();
			dao.update(coluna, dado, id);
			System.out.println("Atualização feita!");
			
		} catch (Exception e) {
			
			e.getStackTrace();
		}
		
		chave.close();
		valor.close();
		linha.close();
	}

}
