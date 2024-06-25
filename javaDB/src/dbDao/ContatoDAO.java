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
	private Connection con;
	
	public ContatoDAO() throws SQLException {
		this.con = ConectionDB.getConnection();
	}
	
	public List<Contato> select() throws SQLException {
		String select = "select * from contatos";
		PreparedStatement smt = con.prepareStatement(select);
		ResultSet rset = smt.executeQuery();
		List<Contato> contato = new ArrayList<Contato>();
		
		while (rset.next()) {
			Contato ct = new Contato();
			ct.setNome(rset.getString("nome"));
			ct.setEmail(rset.getString("email"));
			ct.setEndereco(rset.getString("endereco"));
			ct.setCpf(rset.getString("cpf"));
			contato.add(ct);
		}
		
		rset.close();
		smt.close();
		con.close();
		
		return contato;
	}
	
	public void adiciona(Contato contato) throws SQLException {
		String sql = "insert into contatos(nome, email, endereco, cpf) values (?,?,?,?)";
		PreparedStatement smt = con.prepareStatement(sql);
		smt.setString(1, contato.getNome());
		smt.setString(2, contato.getEmail());
		smt.setString(3, contato.getEndereco());
		smt.setString(4, contato.getCpf());
		
		smt.execute();
		
		smt.close();
		con.close();
	}
	
	public void delete(int id) throws SQLException {
		String del = "delete from contatos where id="+id;
		PreparedStatement smt = con.prepareStatement(del);
		
		smt.execute();
		con.close();
	}
	
	public void update(int coluna, String valor, int id) throws SQLException {

			if(coluna == 1) {
				String up_nome = "update contatos set nome = ? where id = ?";
				PreparedStatement smt_name = con.prepareStatement(up_nome);
				smt_name.setString(1, valor);
				smt_name.setInt(2, id);
				
				smt_name.executeUpdate();
				con.close();
			}
			
			if(coluna == 2) {
				String up_email = "update contatos set email = ? where id = ?";
				PreparedStatement smt_email = con.prepareStatement(up_email);
				smt_email.setString(1, valor);
				smt_email.setInt(2, id);
				
				smt_email.executeUpdate();
				con.close();
			}
			
			if(coluna == 3) {
				String up_endereco = "update contatos set endereco = ? where id = ?";
				PreparedStatement smt_endereco = con.prepareStatement(up_endereco);
				smt_endereco.setString(1, valor);
				smt_endereco.setInt(2, id);
				
				smt_endereco.executeUpdate();
				con.close();
			}
			
			if(coluna == 4) {
				String up_cpf = "update contatos set cpf = ? where id = ?";
				PreparedStatement smt_cpf = con.prepareStatement(up_cpf);
				smt_cpf.setString(1, valor);
				smt_cpf.setInt(2, id);
				
				smt_cpf.executeUpdate();
				con.close();
			}
			
	}
	
	
}
