package br.com.justoeu.infrastructure.security.impl;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;

import br.com.justoeu.infrastructure.security.SecurityService;

@SecurityService
@Interceptor
public class SecurityServiceImpl {
	
	@Inject
	private Logger logger;

	public SecurityServiceImpl() {
	}
	
	@AroundInvoke
	public Object operation(InvocationContext context) throws Exception {
		logger.info("before operation");
		Object obj = context.proceed();
		logger.info("after operation");
		System.out.println("Entrou!!!!");
		return obj;
	}
}