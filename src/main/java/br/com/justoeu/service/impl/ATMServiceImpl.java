package br.com.justoeu.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.slf4j.Logger;

import br.com.justoeu.domain.AccountBalance;
import br.com.justoeu.domain.AccountInformation;
import br.com.justoeu.domain.AccountService;
import br.com.justoeu.domain.Handling;
import br.com.justoeu.domain.enums.TypeAccount;
import br.com.justoeu.service.ATMService;
import br.com.justoeu.util.date.CalendarParams;
import br.com.justoeu.util.date.CalendarUtils;

public class ATMServiceImpl implements ATMService {

	@Inject
	private Logger logger;

	@Override
	public void receiverDeposit(@Observes Handling hand){
		logger.info("Entrou " + hand.toString());
	}
	
	@Override
	public List<AccountBalance> balanceOfAccount(int idAccount) throws Exception{
		
		logger.info("====> Gerando Balance");
		
		List<AccountBalance> lBalance = new ArrayList<AccountBalance>();
		
		if (idAccount == 0){
			throw new Exception("ID Account is null");
		} else{
			
			for (int i=0; i< 5; i++){
//				BigDecimal max = new BigDecimal(10 + ".0");
//		        BigDecimal randFromDouble = new BigDecimal(Math.random());
//		        BigDecimal actualRandomDec = randFromDouble.divide(max,BigDecimal.ROUND_DOWN);
		        
				lBalance.add(new AccountBalance(1, new BigDecimal(new Random().nextInt(10000))));
			}			
		}
		
		return lBalance;
	}

	@Override
	public List<AccountService> allServices(int idAccount) {

		logger.info("====> Gerando Servicos");
		
		List<AccountService> lService = new ArrayList<AccountService>();

		lService.add(new AccountService("Investimento", CalendarUtils.plusOrMinusPartsOfDate(1, CalendarUtils.date(), CalendarParams.YEAR)));
		lService.add(new AccountService("Conta Salario", CalendarUtils.plusOrMinusPartsOfDate(10, CalendarUtils.date(), CalendarParams.DAY)));
		lService.add(new AccountService("Seguro", CalendarUtils.plusOrMinusPartsOfDate(1, CalendarUtils.date(), CalendarParams.MONTH)));
		lService.add(new AccountService("Previdencia Privada", CalendarUtils.plusOrMinusPartsOfDate(100, CalendarUtils.date(), CalendarParams.DAY)));
		
		return lService;
		
	}

	@Override
	public AccountInformation accountInformation(int idAccount) {

		AccountInformation info = new AccountInformation();
		info.setFirstName("Valmir");
		info.setIdAccount(1);
		info.setLastConnect(CalendarUtils.date());
		info.setLastName("Justo");
		info.setTypeAccount(TypeAccount.PRIME);
		
		return info;
	}
	
}