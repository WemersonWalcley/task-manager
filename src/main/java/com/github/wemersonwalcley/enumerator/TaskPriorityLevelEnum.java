package com.github.wemersonwalcley.enumerator;

public enum TaskPriorityLevelEnum {
	EMPTY_PRIORITY("Selecione"),
	ALTA("Urgente"),
	MEDIA("Média"),
	BAIXA("Baixa");
	
	private String descricao;
	
	TaskPriorityLevelEnum(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}	

}
