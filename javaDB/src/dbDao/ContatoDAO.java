package dbDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectionFactory.ConectionDB;
import model.Contato;

public class ContatoDAO {
	private Connection con = null;
	PreparedStatement smt = null;
	ResultSet rs = null;
	
	public ContatoDAO() throws SQLException {
		this.con = ConectionDB.getConnection();
	}
	
	public void closeConnection() throws SQLException {
	    if (con != null) {
	        con.close();
	    }
	}
	
//	Método para listar os contatos
	public List<Contato> select() throws SQLException {
		String select = "select * from contatos";
		smt = con.prepareStatement(select);
		rs = smt.executeQuery();
		List<Contato> contato = new ArrayList<Contato>();
		
		while (rs.next()) {
			Contato ct = new Contato();
			ct.setNome(rs.getString("nome"));
			ct.setEmail(rs.getString("email"));
			ct.setEndereco(rs.getString("endereco"));
			ct.setCpf(rs.getString("cpf"));
			contato.add(ct);
		}
		
		rs.close();
		smt.close();
		
		
		return contato;
	}
	
//	Método para listar os contatos pela letra
	public List<Contato> getNome(String letra) throws SQLException {
		String select = "select * from contatos where nome like '"+letra+"%'";
		smt = con.prepareStatement(select);
		smt.execute();
		
		rs = smt.executeQuery();
		List<Contato> contato = new ArrayList<Contato>();
		
		while (rs.next()) {
			Contato ct = new Contato();
			ct.setNome(rs.getString("nome"));
			ct.setEmail(rs.getString("email"));
			ct.setEndereco(rs.getString("endereco"));
			ct.setCpf(rs.getString("cpf"));
			contato.add(ct);
		}
		
		rs.close();
		smt.close();
		
		
		return contato;
	}
	
	
//	Método para listar os contatos pelo id
	public List<Contato> getId(int id) throws SQLException {
		String select = "select * from contatos where id = ?";
		PreparedStatement smt = con.prepareStatement(select);
		smt.setInt(1, id);
		smt.execute();
		rs = smt.executeQuery();
		List<Contato> contato = new ArrayList<Contato>();
		
		while (rs.next()) {
			Contato ct = new Contato();
			ct.setNome(rs.getString("nome"));
			ct.setEmail(rs.getString("email"));
			ct.setEndereco(rs.getString("endereco"));
			ct.setCpf(rs.getString("cpf"));
			contato.add(ct);
		}
		
		rs.close();
		smt.close();
		
		
		return contato;
	}
	
//	Método que lista pelo id usado na função 6 do app gerencia_contato (obs: Não fechei a conexão para não dar erro ao atualizar)
	public List<Contato> getIdentificador(int id) throws SQLException {
		String select = "select * from contatos where id = ?";
		PreparedStatement smt = con.prepareStatement(select);
		smt.setInt(1, id);
		smt.execute();
		rs = smt.executeQuery();
		List<Contato> contato = new ArrayList<Contato>();
		
		while (rs.next()) {
			Contato ct = new Contato();
			ct.setNome(rs.getString("nome"));
			ct.setEmail(rs.getString("email"));
			ct.setEndereco(rs.getString("endereco"));
			ct.setCpf(rs.getString("cpf"));
			contato.add(ct);
		}
		
		rs.close();
		smt.close();
		
		return contato;
	}
	
//	Método que adiciona um novo contato
	public void adiciona(Contato contato) throws SQLException {
		String sql = "insert into contatos(nome, email, endereco, cpf) values (?,?,?,?)";
		smt = con.prepareStatement(sql);
		smt.setString(1, contato.getNome());
		smt.setString(2, contato.getEmail());
		smt.setString(3, contato.getEndereco());
		smt.setString(4, contato.getCpf());
		
		smt.execute();
		smt.close();
		
	}
	
//	Método que deleta um contato
	public void delete(int id) throws SQLException {
		String del = "delete from contatos where id="+id;
		PreparedStatement smt = con.prepareStatement(del);
		
		smt.execute();
		
	}
	
	
//	Método que edita um campo de um contato
	public void update(int coluna, String valor, int id) throws SQLException {

			if(coluna == 1) {
				String up_nome = "update contatos set nome = ? where id = ?";
				PreparedStatement smt_name = con.prepareStatement(up_nome);
				smt_name.setString(1, valor);
				smt_name.setInt(2, id);
				
				smt_name.executeUpdate();
				
			}
			
			if(coluna == 2) {
				String up_email = "update contatos set email = ? where id = ?";
				PreparedStatement smt_email = con.prepareStatement(up_email);
				smt_email.setString(1, valor);
				smt_email.setInt(2, id);
				
				smt_email.executeUpdate();
				
			}
			
			if(coluna == 3) {
				String up_endereco = "update contatos set endereco = ? where id = ?";
				PreparedStatement smt_endereco = con.prepareStatement(up_endereco);
				smt_endereco.setString(1, valor);
				smt_endereco.setInt(2, id);
				
				smt_endereco.executeUpdate();
				
			}
			
			if(coluna == 4) {
				String up_cpf = "update contatos set cpf = ? where id = ?";
				PreparedStatement smt_cpf = con.prepareStatement(up_cpf);
				smt_cpf.setString(1, valor);
				smt_cpf.setInt(2, id);
				
				smt_cpf.executeUpdate();
				
			}
			
	}
	
	
}
