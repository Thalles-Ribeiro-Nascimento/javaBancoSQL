package app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dbDao.ContatoDAO;
import model.Contato;

public class Gerencia_Contato {

	public static void main(String[] args) throws SQLException {
		ContatoDAO dao = new ContatoDAO();
		Scanner sc = new Scanner(System.in);
		int opcao;
		do {
			//		Escolhendo as funcionalidades
			System.out.println("Escolha entre as funciolidades abaixo:");
			System.out.println("1: Listar todos os contatos");
			System.out.println("2: Listar os contatos que começam com determinada letra");
			System.out.println("3: Listar contato por identificador");
			System.out.println("4: Adicionar um novo contato");
			System.out.println("5: Deletar um contato");
			System.out.println("6: Atualizar um contato");
			System.out.println("7: Fechar o programa");
			opcao = sc.nextInt();
			sc.nextLine();
			if(opcao < 1 || opcao >7) {
				System.out.println("Opção incorreta");
			}

			else {
				if(opcao != 7) {
					switch(opcao) {
					case 1:	
						System.out.println("Certo. Listando os usuários para você:");
						System.out.println(" ");
						//		Lista todos os contatos, caso a funcionalidade seja a 1
						List<Contato> contato = dao.select();

						for (Contato contato1 : contato) {
							System.out.println("Nome do contato: "+contato1.getNome());
							System.out.println("Email do contato: "+contato1.getEmail());
							System.out.println("Endereço do contato: "+contato1.getEndereco());
							System.out.println("CPF: "+contato1.getCpf());
							System.out.println(" ");
						}

						break;

						//		Lista os contatos começados com alguma determinada letra
					case 2:
						System.out.println("Digite uma letra: ");
						String letra = sc.nextLine();
						System.out.println("Ok, segue abaixo os usuários com a letra "+letra);
						System.out.println(" ");
						
						List<Contato> contato2 = dao.getNome(letra);

						for (Contato contato1 : contato2) {
							System.out.println("Nome do contato: "+contato1.getNome());
							System.out.println("Email do contato: "+contato1.getEmail());
							System.out.println("Endereço do contato: "+contato1.getEndereco());
							System.out.println("CPF: "+contato1.getCpf());
							System.out.println(" ");
						}

						break;

						//		Lista os contatos pelo id
					case 3:
						System.out.println("Digite um id: ");
						int Id = sc.nextInt();
						System.out.println("Ok, segue abaixo os usuários com o ID = "+Id);
						System.out.println(" ");
						
						
						List<Contato> contato3 = dao.getId(Id);

						for (Contato contato1 : contato3) {
							System.out.println("Nome do contato: "+contato1.getNome());
							System.out.println("Email do contato: "+contato1.getEmail());
							System.out.println("Endereço do contato: "+contato1.getEndereco());
							System.out.println("CPF: "+contato1.getCpf());
							System.out.println(" ");
						}
						

						break;

						//		Insere um novo contato
					case 4:
						Contato contato4 = new Contato();

						System.out.println("Escreva seu nome: ");

						String nm = sc.nextLine();
						contato4.setNome(nm);

						System.out.println("Escreva seu email: ");

						String e_mail = sc.nextLine();
						contato4.setEmail(e_mail);

						System.out.println("Escreva seu endereco: ");

						String end = sc.nextLine();
						contato4.setEndereco(end);

						System.out.println("Digite seu CPF: ");

						String CPF = sc.nextLine();
						contato4.setCpf(CPF);

						dao.adiciona(contato4);
						System.out.println("Gravação feita no Banco de Dados");
						System.out.println("");


						break;

						//		Apaga um contato
					case 5:
						System.out.println("Digite o Id que queira deletar: ");
						dao.delete(sc.nextInt());
						System.out.println("Contato deletado!");
						System.out.println("");


						break;

						//		Atualiza um contato e lista ele para que seja visto melhor o campo que será alterado
					case 6:
						System.out.println("Digite o id: ");

						int Id1 = sc.nextInt();
						System.out.println("Ok, segue abaixo o usuário com a ID = "+Id1);
						System.out.println(" ");

						List<Contato> contato6 = dao.getIdentificador(Id1);

						for (Contato contato1 : contato6) {
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

						int coluna = sc.nextInt();
						sc.nextLine();
						System.out.println("Digite o novo valor para a coluna: ");

						String dado = sc.nextLine();

						dao.update(coluna, dado, Id1);
						System.out.println("Atualização feita!");
						System.out.println("");


						break;
					}
				}
			}

		}while(opcao != 7);		
		System.out.println("Programa encerrado!!");
		sc.close();
		dao.closeConnection();

	}

}
