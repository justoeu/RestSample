package br.com.justoeu.service;

import java.util.List;

import br.com.justoeu.domain.AccountBalance;
import br.com.justoeu.domain.AccountInformation;
import br.com.justoeu.domain.AccountService;
import br.com.justoeu.domain.Handling;

public interface ATMService {

	public abstract void receiverDeposit(Handling hand);
	public abstract List<AccountBalance> balanceOfAccount(int idAccount) throws Exception;
	public abstract List<AccountService> allServices(int idAccount);
	public abstract AccountInformation accountInformation(int idAccount);

}