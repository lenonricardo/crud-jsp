package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.SingleConnection;

public class DaoLogin {
	
	private Connection connection;
	
	
	public DaoLogin() {
		connection = SingleConnection.getConnection();
	}
	public boolean validarLogin(String login, String senha) throws Exception {
		String sql = "SELECT * from usuario WHERE Login = '"+login+"' AND senha = '"+senha+"'";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultset = statement.executeQuery();
		if(resultset.next()) {
			return true;
		}else {
			return false;
		}
	}
}
