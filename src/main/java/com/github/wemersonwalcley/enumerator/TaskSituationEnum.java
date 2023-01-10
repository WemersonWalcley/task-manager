package com.github.wemersonwalcley.enumerator;

public enum TaskSituationEnum {
	EMPTY_SITUATION("Selecione"),
	IN_PROGRESS("Em Progresso"),
	COMPLETED("Completo");
	
	private String descricao;
	
	TaskSituationEnum(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
