package com.github.wemersonwalcley.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import com.github.wemersonwalcley.entity.Task;
import com.github.wemersonwalcley.repository.task.TaskRepository;

@Named("taskBean")
@ViewScoped
public class TaskBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private List<Task> tasks;
	
	@Inject
	private TaskRepository repository;
	
    public void listarTasks() {
    	System.out.println("LIST BEFORE: " + tasks);
    	tasks = repository.findAll();
    	System.out.println("LIST AFTER: " + tasks.get(0));
    }

	public List<Task> getTasks() {
		return tasks;
	}

}
