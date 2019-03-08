package com.jiaoshen.entity.newuser;

import java.util.List;
import java.util.Map;

public class NewUser {
	private String name;
	
	private String psd;
	
	
	private List<Account> accounts;
    

	public String getPsd() {
		return psd;
	}

	public void setPsd(String psd) {
		this.psd = psd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "NewUser [name=" + name + ", psd=" + psd + ", accounts=" + accounts + ", map1="+ "]";
	}
    
	
	
	
	
	

}
