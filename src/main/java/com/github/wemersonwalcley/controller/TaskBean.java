package com.github.wemersonwalcley.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import com.github.wemersonwalcley.entity.Task;
import com.github.wemersonwalcley.enumerator.TaskPriorityLevelEnum;
import com.github.wemersonwalcley.enumerator.TaskResponsibleEnum;
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

	private List<Task> tasks;
	
	private Task task;
	
	public void prepareNewTask() {
		task = new Task();
	}
	
	public void createNewTask() {
		taskService.create(task);
	}
	
    public void listarTasks() {
    	tasks = repository.findAll();
    }

	public List<Task> getTasks() {
		return tasks;
	}
	
	public TaskResponsibleEnum[] getTaskResponsibleEnums() {
		return TaskResponsibleEnum.values();
	}
	
	public TaskPriorityLevelEnum[] getTaskPriorityLevelEnums() {
		return TaskPriorityLevelEnum.values();
	}
	
	public Task getTask() {
		return task;
	}

}
