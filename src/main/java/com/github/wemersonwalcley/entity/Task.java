package com.github.wemersonwalcley.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.github.wemersonwalcley.enumerator.TaskPriorityLevelEnum;
import com.github.wemersonwalcley.enumerator.TaskResponsibleEnum;
import com.github.wemersonwalcley.enumerator.TaskSituationEnum;

@Table(name = "tb_task")
@Entity
public class Task implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Task(){}

	public Task(String title, TaskResponsibleEnum taskResponsibleEnum, TaskSituationEnum taskSituationEnum,
			TaskPriorityLevelEnum taskPriorityLevelEnum, Date deadline) {
		super();
		this.title = title;
		this.taskResponsibleEnum = taskResponsibleEnum;
		this.taskSituationEnum = taskSituationEnum;
		this.taskPriorityLevelEnum = taskPriorityLevelEnum;
		this.deadline = deadline;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	
	private String description;
	
	@Column(name = "responsible")
	@Enumerated(EnumType.STRING)
	private TaskResponsibleEnum taskResponsibleEnum;
	
	@Column(name = "situation")
	@Enumerated(EnumType.STRING)
	private TaskSituationEnum taskSituationEnum;

	@Column(name = "priority_level")
	@Enumerated(EnumType.STRING)
	private TaskPriorityLevelEnum taskPriorityLevelEnum;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date deadline;


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

	public TaskResponsibleEnum getTaskResponsible() {
		return taskResponsibleEnum;
	}

	public void setTaskResponsibleEnum(TaskResponsibleEnum taskResponsibleEnum) {
		this.taskResponsibleEnum = taskResponsibleEnum;
	}

	public TaskSituationEnum getTaskSituation() {
		return taskSituationEnum;
	}

	public void setTaskSituationEnum(TaskSituationEnum taskSituationEnum) {
		this.taskSituationEnum = taskSituationEnum;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public TaskPriorityLevelEnum getTaskPriorityLevel() {
		return taskPriorityLevelEnum;
	}

	public void setTaskPriorityLevelEnum(TaskPriorityLevelEnum taskPriorityLevelEnum) {
		this.taskPriorityLevelEnum = taskPriorityLevelEnum;
	}
	
	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", taskResponsibleEnum="
				+ taskResponsibleEnum + ", taskSituationEnum=" + taskSituationEnum + ", taskPriorityLevelEnum="
				+ taskPriorityLevelEnum + ", deadline=" + deadline + "]";
	}

}
