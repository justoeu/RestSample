package br.com.justoeu.domain;

import java.util.Date;

import br.com.justoeu.domain.enums.TypeAccount;

public class AccountInformation {

	private int idAccount;
	private String firstName;
	private String lastName;
	private TypeAccount typeAccount;
	private Date lastConnect;
	
	public AccountInformation(){}
	
	public AccountInformation(int idAccount, String firstName, String lastName,
			TypeAccount typeAccount, Date lastConnect) {
		super();
		this.idAccount = idAccount;
		this.firstName = firstName;
		this.lastName = lastName;
		this.typeAccount = typeAccount;
		this.lastConnect = lastConnect;
	}
	
	public int getIdAccount() { return idAccount; }
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public TypeAccount getTypeAccount() { return typeAccount; }
	public Date getLastConnect() { return lastConnect; }
	
	public void setIdAccount(int idAccount) { this.idAccount = idAccount; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	public void setTypeAccount(TypeAccount typeAccount) { this.typeAccount = typeAccount; }
	public void setLastConnect(Date lastConnect) { this.lastConnect = lastConnect; }
	
}