package com.github.wemersonwalcley.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import com.github.wemersonwalcley.entity.Task;
import com.github.wemersonwalcley.enumerator.TaskPriorityLevelEnum;
import com.github.wemersonwalcley.enumerator.TaskResponsibleEnum;
import com.github.wemersonwalcley.enumerator.TaskSituationEnum;
import com.github.wemersonwalcley.repository.task.TaskRepository;
import com.github.wemersonwalcley.service.TaskServiceImpl;

@Named("taskBean")
@ViewScoped
public class TaskBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TaskRepository repository;

	@Inject
	private TaskServiceImpl taskService;

	private List<Task> taskList;

	private Task task;

	private Task selectedTask;

	private String titleFilter;
	
	private TaskResponsibleEnum responsibleFilter;
	
	private TaskSituationEnum situationFilter;
	
	private TaskPriorityLevelEnum priorityFilter;

	private Long idFilter;

	public void search() {
		if (titleFilter.isEmpty() && idFilter == null && responsibleFilter == null && priorityFilter == null) {
			taskList = repository.findAll();
		} else {
			taskList = repository.findAllByFilter(titleFilter, responsibleFilter, priorityFilter, idFilter);
		}
	}
	
	public void deleteTask() {
		taskService.delete(selectedTask);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tarefa excluída."));
        PrimeFaces.current().ajax().update("form:messages");
        listarTasks();
	}

	public void finishTask() {
		selectedTask.setTaskSituationEnum(TaskSituationEnum.COMPLETED);
		taskService.create(selectedTask);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tarefa concluída."));
        PrimeFaces.current().ajax().update("form:messages");
        listarTasks();
	}

	public void prepareNewTask() {
		task = new Task();

	}

	public void prepareEditTask() {
		selectedTask = new Task();
	}

	public void createNewTask() {
		task.setTaskSituationEnum(TaskSituationEnum.IN_PROGRESS);
		taskService.create(task);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tarefa criada."));
        PrimeFaces.current().ajax().update("form:messages");
		listarTasks();
	}

	public void saveEditedTask() {
		taskService.create(selectedTask);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tarefa editada."));
        PrimeFaces.current().ajax().update("form:messages");
	}

	public void listarTasks() {
		taskList = repository.findAll();
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public TaskResponsibleEnum[] getTaskResponsibleEnums() {
		return TaskResponsibleEnum.values();
	}

	public TaskPriorityLevelEnum[] getTaskPriorityLevelEnums() {
		return TaskPriorityLevelEnum.values();
	}
	
	public TaskSituationEnum[] getTaskSituationEnums() {
		return TaskSituationEnum.values();
	}

	public Task getTask() {
		return task;
	}

	public Task getSelectedTask() {
		return selectedTask;
	}

	public void setSelectedTask(Task selectedTask) {
		this.selectedTask = selectedTask;
	}

	public String getTitleFilter() {
		return titleFilter;
	}

	public void setTitleFilter(String titleFilter) {
		this.titleFilter = titleFilter;
	}

	public Long getIdFilter() {
		return idFilter;
	}

	public void setIdFilter(Long idFilter) {
		this.idFilter = idFilter;
	}
	
	public TaskResponsibleEnum getResponsibleFilter() {
		return responsibleFilter;
	}
	
	public void setResponsibleFilter(TaskResponsibleEnum responsibleFilter) {
		this.responsibleFilter = responsibleFilter;
	}
	
	public TaskSituationEnum getSituationFilter() {
		return situationFilter;
	}
	
	public void setSituationFilter(TaskSituationEnum situationFilter) {
		this.situationFilter = situationFilter;
	}
	
	public TaskPriorityLevelEnum getPriorityFilter() {
		return priorityFilter;
	}
	
	public void setPriorityFilter(TaskPriorityLevelEnum priorityFilter) {
		this.priorityFilter = priorityFilter;
	}

}
