package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.BeanJSP;
import connection.SingleConnection;

public class DaoUsuario {
	private Connection connection;
	
	public DaoUsuario() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(BeanJSP usuario) throws Exception {
		try {
		String sql = "INSERT INTO usuario(login,senha, nome) VALUES (?,?, ?)";
		PreparedStatement insert = connection.prepareStatement(sql);
		insert.setString(1, usuario.getLogin());
		insert.setString(2, usuario.getSenha());
		insert.setString(3, usuario.getNome());
		insert.execute();
		connection.commit();
		}catch(Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
				
			} catch (Exception e2) {
				e2.printStackTrace();
				
			}
			
		}
	}
	
	public List<BeanJSP> listar() throws Exception{
		List<BeanJSP> listar = new ArrayList<BeanJSP>();
		String sql = "SELECT * FROM usuario";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultset = statement.executeQuery();
		
		while(resultset.next()) {
			
			BeanJSP beanjsp = new BeanJSP();
			beanjsp.setLogin(resultset.getString("login"));
			beanjsp.setSenha(resultset.getString("senha"));
			beanjsp.setId(resultset.getLong("id"));
			beanjsp.setNome(resultset.getString("nome"));
			listar.add(beanjsp);
			
			
		}
		
		return listar;
		
	}
	
	public void deletar(Long id) {
		String sql = "DELETE FROM usuario WHERE id="+id;	
		
		try {
			PreparedStatement statement;
			statement = connection.prepareStatement(sql);
			statement.execute();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}
	}

	public BeanJSP consultar(String id) throws SQLException {
		String sql = "select * from usuario where id = '"+id+"'";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()) {
			BeanJSP beanjsp = new BeanJSP();
			beanjsp.setId(resultSet.getLong("id"));
			beanjsp.setLogin(resultSet.getString("login"));			
			beanjsp.setSenha(resultSet.getString("senha"));
			beanjsp.setNome(resultSet.getString("nome"));
			
			return beanjsp;
			
		}
		return null;
	}

	public void atualizar(BeanJSP usuario) {
		try {
		String sql = "update usuario set login = ?, senha = ?, nome =? where id =  " + usuario.getId();
		PreparedStatement preparedstatement = connection.prepareStatement(sql);
		preparedstatement.setString(1,usuario.getLogin());
		preparedstatement.setString(2, usuario.getSenha());
		preparedstatement.setString(3, usuario.getNome());
		preparedstatement.executeUpdate();
		connection.commit();
		}catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		}
	}
	
	public boolean validarLogin(String login) throws SQLException {
		String sql = "select count(1) as qtd from usuario where login = '"+login+"'";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()) {
			
			
			return resultSet.getInt("qtd") <= 0;
			
		}
		return false;
	}


}
