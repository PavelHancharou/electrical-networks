package by.hancharou.electricalnetworks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	private Connection connection;
	private PreparedStatement pStatement;
	private ResultSet resultSet;
	
	//DELETE THIS METHOD IF HE DO NOT USE
	public boolean accauntIsExist(String email, String password) {
		boolean isExist = false;
		try{
			connection = ConnectionManager.getManager().getConnection();
			pStatement = connection.prepareStatement("SELECT * FROM tbl_users;");
			resultSet = pStatement.executeQuery();
			
			while (resultSet.next()) {
				if(email.equals(resultSet.getString(2)) && password.equals(resultSet.getString(3))) {isExist=true;}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.getManager().closeDbResources(connection, pStatement, resultSet);
		}
		return isExist;
	}
	
	public void searchAllTables() {
		try{
			connection = ConnectionManager.getManager().getConnection();
			pStatement = connection.prepareStatement("select * from tbl_ps;");
			resultSet = pStatement.executeQuery();
			
			while (resultSet.next()) {
				System.out.println(resultSet.getLong(1) + " - " + resultSet.getString(2));
				//if(email.equals(resultSet.getString(2)) && password.equals(resultSet.getString(3))) {isExist=true;}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.getManager().closeDbResources(connection, pStatement, resultSet);
		}
	}
}