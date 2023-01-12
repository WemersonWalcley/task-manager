package com.github.wemersonwalcley.enumerator;

public enum TaskPriorityLevelEnum {
	HIGH("Urgente"),
	MEDIUM("Média"),
	LOW("Baixa");
	
	private String descricao;
	
	TaskPriorityLevelEnum(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}	

}
