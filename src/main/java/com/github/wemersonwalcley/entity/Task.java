package com.github.wemersonwalcley.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

import com.github.wemersonwalcley.enumerator.TaskPriorityLevel;
import com.github.wemersonwalcley.enumerator.TaskResponsible;
import com.github.wemersonwalcley.enumerator.TaskSituation;

@Table(name = "tb_task")
public class Task implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty(message = "Campo título é obrigatório.")
	private String title;
	
	@NotEmpty(message = "Campo descrição é obrigatório.")
	private String description;
	
	@Column(name = "responsible")
	@NotEmpty(message = "Campo responsável é obrigatório.")
	private TaskResponsible taskResponsible;
	
	@Column(name = "situation")
	@NotEmpty(message = "Campo responsável é obrigatório.")
	private TaskSituation taskSituation;

	@NotEmpty(message = "Campo data é obrigatório.")
	@Temporal(TemporalType.TIMESTAMP)
	private Date deadline;
	
	@Column(name = "priority_level")
	@Enumerated(EnumType.STRING)
	private TaskPriorityLevel taskPriorityLevel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TaskResponsible getTaskResponsible() {
		return taskResponsible;
	}

	public void setTaskResponsible(TaskResponsible taskResponsible) {
		this.taskResponsible = taskResponsible;
	}

	public TaskSituation getTaskSituation() {
		return taskSituation;
	}

	public void setTaskSituation(TaskSituation taskSituation) {
		this.taskSituation = taskSituation;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public TaskPriorityLevel getTaskPriorityLevel() {
		return taskPriorityLevel;
	}

	public void setTaskPriorityLevel(TaskPriorityLevel taskPriorityLevel) {
		this.taskPriorityLevel = taskPriorityLevel;
	}

}
