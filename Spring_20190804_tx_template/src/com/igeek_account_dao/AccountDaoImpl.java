package com.igeek_account_dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.igeek_account.AccountDao;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

	@Override
	public void out(String outer, int money) {
		//JDBCÄ£°åJdbcDaoSupport
		this.getJdbcTemplate().update("update account set money=money-? where name=?", money,outer);
	
	}

	@Override
	public void in(String inner, int money) {
		this.getJdbcTemplate().update("update account set money=money+? where name=?", money,inner);
	}

}
