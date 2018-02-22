package com.star.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.star.entities.UserEntity;

public class UserDaoImpl implements IUserDao {

	@Override
	public ResultSet getUser(UserEntity user, Connection connection) throws SQLException{
		
		connection.setAutoCommit(false);
		
		String sql = "SELECT * FROM user_info WHERE user_name = ?, user_password = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, user.getUsername());
		preparedStatement.setString(2, user.getPassword());
		
		ResultSet set = preparedStatement.executeQuery(sql);
		System.out.println("成功查询一位用户");
		
		return set;
	}

	@Override
	public void addUser(UserEntity user, Connection connection) throws SQLException {
		
		connection.setAutoCommit(false);
		
		String sql = "INSERT INTO user_info (user_name, user_password, user_email) VALUES (?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, user.getUsername());
		preparedStatement.setString(2, user.getPassword());
		preparedStatement.setString(3, user.getEmail());
		
		connection.commit();
		System.out.println("成功插入一条信息");
		
		preparedStatement.close();
		connection.close();
	}

	@Override
	public String getEmail(String username, Connection connection) throws SQLException{
		
		String email = null;
		connection.setAutoCommit(false);
		
		String sql = "SELECT user_email FROM user_info WHERE user_name = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, username);
		
		ResultSet set = preparedStatement.executeQuery(sql);
		System.out.println("成功查询一位用户");
		
		if (set.next()) {
			email = set.getString("user_email");
		}
		
		set.close();
		preparedStatement.close();
		connection.close();
		
		return email;
	}
}
