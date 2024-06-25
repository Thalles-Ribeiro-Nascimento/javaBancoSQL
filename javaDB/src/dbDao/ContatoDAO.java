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
			ct.setIdade(rset.getInt("idade"));
			contato.add(ct);
		}
		
		rset.close();
		smt.close();
		con.close();
		
		return contato;
	}
	
	public void adiciona(Contato contato) throws SQLException {
		String sql = "insert into contatos(nome, email, endereco, idade) values (?,?,?,?)";
		PreparedStatement smt = con.prepareStatement(sql);
		smt.setString(1, contato.getNome());
		smt.setString(2, contato.getEmail());
		smt.setString(3, contato.getEndereco());
		smt.setInt(4, contato.getIdade());
		
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
	
	public void update(String chave, String valor, int id) throws SQLException {
		if(chave == "idade") {
			String up_idade = "update contatos set idade="+valor+" where id="+id;
			PreparedStatement smt1 = con.prepareStatement(up_idade);
			smt1.execute();
			con.close();
		}else {
			String up = "update contatos set "+chave+"="+valor+" where id="+id;
			PreparedStatement smt = con.prepareStatement(up);

			smt.execute();
			con.close();
		}
	}
	
}
