package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {

	/** The usuario. */
	public String usuario = "root"; // informar usuário
	
	/** The senha. */
	public String senha = "djd12123"; // informar senha

	/**
	 * Conectar.
	 *
	 * @return the connection
	 * @throws Exception the exception
	 */
	public Connection Conectar() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost/dbagenda";
		java.sql.Connection conn = DriverManager.getConnection(url, usuario, senha);
		return conn;
	}

	/**
	 * Inserir contato.
	 *
	 * @param contato the contato
	 */
	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos (nome, fone, email) values (?,?,?)";
		try {
			Connection conn = Conectar();
			PreparedStatement pst = conn.prepareStatement(create);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.execute();
			conn.close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Listar contato.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listarContato() {
		String read = "select * from contatos order by nome";
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		try {
			Connection conn = Conectar();
			PreparedStatement pst = conn.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				contatos.add(new JavaBeans(id, nome, fone, email));
			}
			conn.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	/**
	 * Selecionar contato.
	 *
	 * @param contato the contato
	 */
	public void selecionarContato(JavaBeans contato) {
		String read2 = "select * from contatos where id = ? ";
		try {
			Connection conn = Conectar();
			PreparedStatement pst = conn.prepareStatement(read2);
			pst.setString(1, contato.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				contato.setId(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Edita contato.
	 *
	 * @param contato the contato
	 */
	public void editaContato(JavaBeans contato) {
		String update = "update contatos set nome=?, fone=?, email=? where id=?";
		try {
			Connection conn = Conectar();
			PreparedStatement pst = conn.prepareStatement(update);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.setString(4, contato.getId());
			pst.execute();
			conn.close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Deletar contato.
	 *
	 * @param contato the contato
	 */
	public void deletarContato(JavaBeans contato) {
		String delete = "delete from contatos where id = ?";
		try {
			Connection conn = Conectar();
			PreparedStatement pst = conn.prepareStatement(delete);
			pst.setString(1, contato.getId());
			pst.executeUpdate();
			conn.close();
			pst.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
