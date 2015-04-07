package br.com.justoeu.domain;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AccountBalance {
	
	public AccountBalance(){ }
	
	public AccountBalance(int idAccount, BigDecimal balance) {
		super();
		this.idAccount = idAccount;
		this.balance = balance;
	}

	private int idAccount;
	private BigDecimal balance;
	
	public int getIdAccount() { return idAccount; }
	public BigDecimal getBalance() { return balance; }
	
	public void setIdAccount(int idAccount) { this.idAccount = idAccount; }
	public void setBalance(BigDecimal balance) { this.balance = balance; }
	
}