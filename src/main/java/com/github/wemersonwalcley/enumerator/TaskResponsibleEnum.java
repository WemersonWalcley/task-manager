package com.github.wemersonwalcley.enumerator;

public enum TaskResponsibleEnum {
	EMPTY_RESPONSIBLE("Selecione"),
	WEMERSON("Wemerson"),
	WALLAS("Wallas"),
	RICARDO("Ricardo");
	
	private String descricao;
	
	TaskResponsibleEnum(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
