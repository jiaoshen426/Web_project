package com.jiaoshen.entity.newuser;

import java.math.BigDecimal;
import java.sql.Date;

public class Account {
	
	private Integer id;
	
	private String cardId;
	
	private BigDecimal balance;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}


	@Override
	public String toString() {
		return "Account [id=" + id + ", cardId=" + cardId + ", balance=" + balance + "]";
	}
	
	

}
