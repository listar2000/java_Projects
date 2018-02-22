package com.star.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.star.entities.UserEntity;

public interface IUserDao {
	
	public ResultSet getUser(UserEntity user, Connection connection) throws SQLException;
	
	public void addUser(UserEntity user, Connection connection) throws SQLException;
	
	public String getEmail(String username, Connection connection) throws SQLException;
	
}
