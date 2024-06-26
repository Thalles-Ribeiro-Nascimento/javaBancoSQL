package app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dbDao.ContatoDAO;
import model.Contato;

public class Gerencia_Contato {

	public static void main(String[] args) throws SQLException {
		ContatoDAO dao = new ContatoDAO();

//		Escolhendo as funcionalidades
		System.out.println("Escolha entre as funciolidades abaixo:");
		System.out.println("1: Listar todos os contatos");
		System.out.println("2: Listar os contatos que começam com determinada letra");
		System.out.println("3: Listar contato por identificador");
		System.out.println("4: Adicionar um novo contato");
		System.out.println("5: Deletar um contato");
		System.out.println("6: Atualizar um contato");
		System.out.println("7: Fechar o programa");

		Scanner funcao = new Scanner(System.in);
		int funcao_escolhida = funcao.nextInt();

//		Lista todos os contatos, caso a funcionalidade seja a 1
		if(funcao_escolhida == 1) {
			List<Contato> contato = dao.select();

			for (Contato contato1 : contato) {
				System.out.println("Nome do contato: "+contato1.getNome());
				System.out.println("Email do contato: "+contato1.getEmail());
				System.out.println("Endereço do contato: "+contato1.getEndereco());
				System.out.println("CPF: "+contato1.getCpf());
				System.out.println("+++++++++++++++++++++++++++++++++++++++++");
			}
		}

//		Lista os contatos começados com alguma determinada letra
		if(funcao_escolhida == 2) {
			System.out.println("Digite uma letra: ");
			Scanner name = new Scanner(System.in);
			String letra = name.nextLine();

			List<Contato> contato = dao.getNome(letra);

			for (Contato contato1 : contato) {
				System.out.println("Nome do contato: "+contato1.getNome());
				System.out.println("Email do contato: "+contato1.getEmail());
				System.out.println("Endereço do contato: "+contato1.getEndereco());
				System.out.println("CPF: "+contato1.getCpf());
				System.out.println("+++++++++++++++++++++++++++++++++++++++++");
			}
			name.close();
		}

//		Lista os contatos pelo id
		if(funcao_escolhida == 3) {
			System.out.println("Digite um id: ");
			Scanner id = new Scanner(System.in);
			int Id = id.nextInt();

			List<Contato> contato = dao.getId(Id);

			for (Contato contato1 : contato) {
				System.out.println("Nome do contato: "+contato1.getNome());
				System.out.println("Email do contato: "+contato1.getEmail());
				System.out.println("Endereço do contato: "+contato1.getEndereco());
				System.out.println("CPF: "+contato1.getCpf());
				System.out.println("+++++++++++++++++++++++++++++++++++++++++");
			}

			id.close();
		}

//		Insere um novo contato
		if(funcao_escolhida == 4) {
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

			System.out.println("Digite seu CPF: ");
			Scanner cpf = new Scanner(System.in);
			String CPF = cpf.nextLine();
			contato.setCpf(CPF);

			dao.adiciona(contato);
			System.out.println("Gravação feita no Banco de Dados");

			nome.close();
			email.close();
			endereco.close();
			cpf.close();
		}

//		Apaga um contato
		if(funcao_escolhida == 5) {
			System.out.println("Digite o Id que queira deletar: ");
			Scanner id = new Scanner(System.in);

			dao.delete(id.nextInt());
			System.out.println("Contato deletado!");

			id.close();
		}

//		Atualiza um contato
		if(funcao_escolhida == 6) {

			System.out.println("Digite o id: ");
			Scanner id = new Scanner(System.in);
			int Id = id.nextInt();

			List<Contato> contato = dao.getIdentificador(Id);

			for (Contato contato1 : contato) {
				System.out.println("Nome do contato: "+contato1.getNome());
				System.out.println("Email do contato: "+contato1.getEmail());
				System.out.println("Endereço do contato: "+contato1.getEndereco());
				System.out.println("CPF: "+contato1.getCpf());
				System.out.println(" ");
			}

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

			dao.update(coluna, dado, Id);
			System.out.println("Atualização feita!");

			id.close();
			chave.close();
			valor.close();

		}
		
		if(funcao_escolhida == 7) {
			System.out.println("Certo, encerraremos o programa!");
			System.out.println("...");
			System.out.println(" ");
		}


		funcao.close();		

		System.out.println("Programa encerrado!!");


	}

}
