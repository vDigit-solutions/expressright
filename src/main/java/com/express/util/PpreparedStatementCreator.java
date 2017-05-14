package com.express.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.SqlProvider;

public class PpreparedStatementCreator implements PreparedStatementCreator,
		SqlProvider {
	
	private final PreparedStatementSetter pps ;
	private final String sql;
	
	

	public PpreparedStatementCreator(PreparedStatementSetter pps, String sql) {
		super();
		this.pps = pps;
		this.sql = sql;
	}

	@Override
	public String getSql() {
		
		return sql;
	}

	@Override
	public PreparedStatement createPreparedStatement(Connection con)
			throws SQLException {
		PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		pps.setValues(preparedStatement);
		return preparedStatement;
	}

}
