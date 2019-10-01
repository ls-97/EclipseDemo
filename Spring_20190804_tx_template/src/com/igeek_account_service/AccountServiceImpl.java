package com.igeek_account_service;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.igeek_account.AccountDao;



public class AccountServiceImpl implements AccountService {
	private AccountDao accountDao;
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	private TransactionTemplate transactionTemplate;
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	@Override
	public void transfer(String outer, String inner, int money) {
		// TODO Auto-generated method stub
		
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				// TODO Auto-generated method stub
				accountDao.out(outer, money);
				//int a=10/0;
				accountDao.in(inner, money);
			}
		});
		
	}

}
