package com.github.wemersonwalcley.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class NumberBean {
	
	private static Integer NUMERO = 0;
	
	public NumberBean() {
		NUMERO++;
	}
	
	public Integer getNumero() {
		return NUMERO;
	}
}
