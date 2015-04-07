package br.com.justoeu.infrastructure.producer;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Dependent
public class LoggerProducer {

  @Produces
  public Logger loggerProducer(InjectionPoint ip){
    return LoggerFactory.getLogger(ip.getMember().getDeclaringClass().getName());
  }
}