package test;

import java.util.Scanner;
import dbDao.ContatoDAO;


public class TesteDelete {

	public static void main(String[] args) {
		System.out.println("Digite o Id que queira deletar: ");
		Scanner id = new Scanner(System.in);
		
		try {
			ContatoDAO dao = new ContatoDAO();
			dao.delete(id.nextInt());
			System.out.println("Contato deletado!");
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		id.close();

	}

}
