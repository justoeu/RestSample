package br.com.justoeu.domain;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

import org.slf4j.Logger;

import br.com.justoeu.infrastructure.security.SecurityService;

public class ATM {

	@Inject @Any
	private Event<Handling> handlingEvent;
	
	@Inject
	private Logger logger;

//	public ATM(Event<Handling> handlingEvent, Logger logger) {
//		super();
//		this.handlingEvent = handlingEvent;
//		this.logger = logger;
//	}

	@SecurityService
	public void deposit(Double value) {
		logger.info("deposit = " + value);
		handlingEvent.fire(new Handling(value));
	}

}