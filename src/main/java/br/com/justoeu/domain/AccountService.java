package br.com.justoeu.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AccountService {

	private String nameService;
	private Date dateExpire;
	
	public AccountService(){}
	
	public AccountService(String nameService, Date dateExpire) {
		super();
		this.nameService = nameService;
		this.dateExpire = dateExpire;
	}

	public String getNameService() { return nameService; }
	public Date getDateExpire() { return dateExpire; }

	public void setNameService(String nameService) { this.nameService = nameService; }
	public void setDateExpire(Date dateExpire) { this.dateExpire = dateExpire; }
	
}